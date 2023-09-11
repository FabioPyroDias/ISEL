import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Servidor TCP que atende o porto 5025; 5026 ... para responder à obtenção da foto
 */

/**
 * @author Porfírio Filipe
 *
 */
public class TCPObter extends Thread {

	int port = 5025;
	String pasta="fotos";
		
	public TCPObter(int port, String pasta) {
		this.port=port;
		this.pasta=pasta;
	}
	
	private static String ObterPath(String xmlObter) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		String strFile=null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new InputSource(new StringReader(xmlObter)));
			NodeList Obter = document.getElementsByTagName("Obter");
			Element foto=(Element)Obter.item(0);
			Attr path=foto.getAttributeNode("path");
			strFile=path.getNodeValue();
			return strFile;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static boolean Check(String comando) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new InputSource(new StringReader(comando)));
			if (xmlUtil.Validar(document, foto.contexto+ File.separator + "protocolo.xsd"))
				return true;
			// NodeList Obter = document.getElementsByTagName("Obter");
			// return Obter.getLength() == 1;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void Obter() {
         ServerSocket serverSocket = null;
         
	     try {
	            serverSocket = new ServerSocket(port);

	            Socket newSock    = null;
	            BufferedReader is = null;
	            PrintWriter os    = null;

	            for( ; ; ) {

	                System.out.println("Servidor TCP espera comando obter no porto " + port + "...");
	                // Espera connect do cliente
	                newSock = serverSocket.accept(); 
	                
	                try {
	                    // circuito virtual estabelecido: socket cliente na variavel newSock
	                    System.out.println("Servidor aceitou a ligacao: " +  newSock.getRemoteSocketAddress());

	                    is = new BufferedReader(new InputStreamReader(newSock.getInputStream()));

	                    os = new PrintWriter(newSock.getOutputStream(), true);

	                    String inputLine = is.readLine(); 
	                    
	                    String response = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><Listar><Resposta>";
    					response = response + "<Erro>Obter: Não foi possivel processar o pedido...</Erro>";
    					response = response + "</Resposta></Listar></Protocolo>";
	                    if (Check(inputLine)) {
	                    	String strFile = ObterPath(inputLine);
	                    	if(strFile!=null) {
	                    	foto ft = new foto(foto.contexto + File.separator +pasta + File.separator +strFile, "");
	    					response = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><Obter path='"+strFile+"'><Resposta><Foto>";
	    					/* foto codificada em base64 
	    					 * isto pode ser optimizado enviando em binário e/ou criando uma tarefa */
	    					response=response+ft.getStrContent();
	    					response=response + "</Foto></Resposta></Obter></Protocolo>";
	                    	}
	                    }
	                    os.println(response);
	                    System.out.println("RESPoSTA: \n" + response );
	                }
	                catch (IOException e) {
	                    System.err.println("erro na ligaçao " + newSock + ": " + e.getMessage());
	                }
	                finally {
	                    // garantir que o socket é fechado
	                    try {
	                        if (is != null) is.close();  
	                        if (os != null) os.close();
	       
	                        if (newSock != null) newSock.close();                    
	                    } catch (IOException e) { }
	                }
	            } // end for
	        } 
	        catch (IOException e) {
	            System.err.println("Excepção no servidor: " + e);
	        }
	}

	public void run() {
		Obter();
    }
	
	public static void main(String[] args) {
		(new TCPObter(5025,"pessoas")).start();
		(new TCPObter(5026,"chocolates")).start();
	}

}
