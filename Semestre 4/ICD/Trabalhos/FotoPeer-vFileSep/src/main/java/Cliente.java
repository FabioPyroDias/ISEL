import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Cliente que acede às fotografias partilhadas
 * Envia pedidos a todos os servidores (broadcast)
 */

/**
 * @author Porfírio Filipe
 *
 */
public class Cliente {
	final static int port = 5025; 	// porto de referencia no servidor
	static Hashtable<String, Remote> listaFotos = new Hashtable<String, Remote>();
	
	static class Remote {
		String IP;
		int port;

		Remote(String IP, int port) {
			this.IP = IP;
			this.port = port;
		}

		public String getIP() {
			return IP;
		}

		public int getPort() {
			return port;
		}
	}
	
	
	private static void Listar(int port) {
		DatagramSocket s = null;
		DatagramPacket packetOut = null;
		DatagramPacket packetIn = null;
		String response = null;
		try {
			try {
		        s = new DatagramSocket();
		        s.setBroadcast(true);
		    } catch (Exception e) {
		        System.err.println("Connection failed. " + e.getMessage());
		        return;
		    }
			MyMessage msg = new MyMessage(
					"<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><Listar/></Protocolo>");
			byte[] d = msg.getData();
			// 192.168.1.255 router linksys
			// 255.255.255.255 original
			packetOut = new DatagramPacket(d, d.length,InetAddress.getByName("255.255.255.255"), port);
			//packetOut = new DatagramPacket(d, d.length,InetAddress.getByName("255.255.255.255"));
			s.send(packetOut);

			byte[] buffer = new byte[1024 * 64]; // dimensão máxima pacote UDP

			packetIn = new DatagramPacket(buffer, buffer.length);
			
			 s.setSoTimeout(10*1000);   // set the timeout in millisecounds.
			 System.out.println("(?)Lista de fotos no porto ("+port+"):");
			for(;;) {		
				 try {
			s.receive(packetIn);
			
			MyMessage recvMessage = new MyMessage(packetIn.getData());

			response = recvMessage.getS();
			
			ListarXML(response,new Remote(packetIn.getAddress().getHostAddress(),packetIn.getPort()));
			
			}
            catch (SocketTimeoutException e) {
                // timeout exception.
            	System.out.println("Fim da lista.");
                //System.out.println("Timeout reached!!! " + e);
                s.setSoTimeout(0);
                break;
            }
			}
		} catch (

		Exception ex)

		{
			ex.printStackTrace();
		} finally

		{
			s.close();
		}
		
	}

	private static void ListarXML(String xmlFotos, Remote origem) {
		System.out.println("Enviado pelo servidor: "+origem.getIP()+"/"+origem.getPort());
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return;
		}
		try {
			document = builder.parse(new InputSource(new StringReader(xmlFotos)));
		} catch (SAXException e) {
			e.printStackTrace();
			return;
		}
		catch (IOException e) {
		e.printStackTrace();
		return;
		}
		NodeList Lista = document.getElementsByTagName("Erro");
		if(Lista.getLength() == 1){
			System.out.println("-->"+((Element)Lista.item(0)).getTextContent());
			return;
		}
		Lista = document.getElementsByTagName("Foto");
		int j = 0;
		
		while (j < Lista.getLength()) {
			Element foto=(Element)Lista.item(j++);
			Attr path=foto.getAttributeNode("path");
			System.out.println(path.getValue());
			listaFotos.put(path.getValue(),origem);
		}
		
	}
	
	private static void ObterXML(String response) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return;
		}
		try {
			document = builder.parse(new InputSource(new StringReader(response)));
		} catch (SAXException e) {
			e.printStackTrace();
			return;
		}
		catch (IOException e) {
			e.printStackTrace();
			return;
		}
		NodeList Erro = document.getElementsByTagName("Erro");
		if(Erro.getLength() == 1){
			System.out.println("-->"+((Element)Erro.item(0)).getTextContent());
			return;
		}
		Element Obter = (Element)(document.getElementsByTagName("Obter").item(0));
		Attr path= Obter.getAttributeNode("path");
		String strFoto = path.getValue();
		foto ft = new foto();
		Element Foto = (Element)(document.getElementsByTagName("Foto").item(0));
		ft.setStrContent(Foto.getTextContent());
		ft.save(foto.contexto+ File.separator + "down"+ File.separator +strFoto);
		ft.show();
		System.out.println("Obter foto ("+foto.contexto+ File.separator + "down"+ File.separator +strFoto+") terminado.");		
	}
	
	private static void Obter(String foto, Remote origem) {         

	        Socket socket     = null;
	        BufferedReader is = null;
	        PrintWriter    os = null;

	        try {
	            socket = new Socket(origem.getIP(), origem.getPort());

	            // Stream para escrita no socket
	            os = new PrintWriter(socket.getOutputStream(), true); 

	            // Stream para leitura do socket
	            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	            // Enviar comando Obter
	            os.println("<?xml version='1.0' encoding='ISO-8859-1'?><Protocolo><Obter path='"+foto+"'/></Protocolo>");

	            // Mostrar o que se recebe do socket
	            ObterXML(is.readLine()); 
	        } 
	       
	        catch (UnknownHostException e) { 
	            System.err.println("Máquina " + origem.getIP() + " desconhecida: " + e.getMessage());
	        } 
	        catch (IOException e) {
	            System.err.println("Erro na ligação: " + e.getMessage());
	        }
	        finally {
	            // No fim de tudo, fechar os streams e o socket
	            try {
	              if (os != null) os.close();
	              if (is != null) is.close();
	              if (socket != null ) socket.close();
	            }
	            catch (IOException e) { 
	                // if an I/O error occurs when closing this socket
	            }
	        } // end finally
	}

	public static void main(String[] args) {
		char op;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println();
			System.out.println("**** Menu ****");
			System.out.println("0. Terminar");
			System.out.println("1. Listar Fotos");
			System.out.println("2. Obter Foto (fotos -> descarrega do servidor)");
			System.out.println("3. Descarregar (descarrega do url -> down)");
			System.out.print("> ");
			try {
				op = br.readLine().charAt(0);
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			switch (op) {
			case '1':
				listaFotos.clear();
				Listar(port);
				Listar(port+1);
				break;
			case '2':
				if(Cliente.listaFotos.size()==0)
					Listar(port);
				System.out.println("Indique o nome da foto:");
				try {
					String strFoto=br.readLine();
					double tempoI = System.currentTimeMillis();
					Remote origem=listaFotos.get(strFoto);
					if(origem!=null) 
						Obter(strFoto,origem);
					else
						System.out.println("Nome da foto inválido!");
					double tempoD = System.currentTimeMillis() - tempoI;
					System.out.println("O pedido foi processado em "+tempoD+" ms!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case '3':
				System.out.println("Indique o URL da foto:");
				try {
					String strFoto=br.readLine();
					double tempoInicial = System.currentTimeMillis();
					String fich=foto.download(strFoto, foto.contexto+ File.separator + "down");
					foto f2 = new foto(fich,"");
		    		f2.show();
					double tempoDecorrido = System.currentTimeMillis() - tempoInicial;
					System.out.println("O pedido foi processado em "+tempoDecorrido+" ms!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case '0':
				break;
			default:
				System.out.println("Opção inválida. Tente outra vez.");
			}
		} while (op != '0');
		System.out.println("Terminou a execução.");
	}

}
