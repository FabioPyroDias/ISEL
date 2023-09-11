import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Servidor UDP que atende o porto 5025 para listar fotos
 */

/**
 * @author Porfírio Filipe
 *
 */
public class UDPListar extends Thread {

	int port = 5025;
	String pasta="fotos";
	
	public UDPListar(int port, String pasta) {
		this.port=port;
		this.pasta=pasta;
	}

	private String ListarPasta() {
		String result = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><Listar><Resposta>";
		File folder = new File(foto.contexto+ File.separator +pasta);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++)
			if (listOfFiles[i].isFile())
				result = result + "<Foto path='" + listOfFiles[i].getName() + "' mime='image/jpg'/>";
		return result + "</Resposta></Listar></Protocolo>";
	}

	private static boolean Check(String comando) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new InputSource(new StringReader(comando)));
			if (xmlUtil.Validar(document, foto.contexto + File.separator + "protocolo.xsd"))
				return true;
			//NodeList Listar = document.getElementsByTagName("Listar");
			//return Listar.getLength() == 1;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void Listar() {
		DatagramSocket s = null;
		DatagramPacket packetIn = null;
		DatagramPacket packetOut = null;

		try {
			s = new DatagramSocket(port);

			for (;;) {
				byte[] buffer = new byte[64 * 1024]; // tamanho máximo udp

				packetIn = new DatagramPacket(buffer, buffer.length);
				System.out.println("Servidor UDP espera comando listar no porto " + port + "...");

				s.receive(packetIn);

				MyMessage recvMessage = new MyMessage(packetIn.getData());

				String request = recvMessage.getS();

				System.out.println("Recebeu comando:" + request);
				String response = null;
				if (Check(request)) {
					response = ListarPasta();  // indica os ficheiros presentes
				} else {
					response = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><Listar><Resposta>";
					response = response + "<Erro>Listar: Formato da mensagem inválido</Erro>";
					response = response + "</Resposta></Listar></Protocolo>";
				}

				MyMessage recvResponse = new MyMessage(response);

				byte[] d = recvResponse.getData();

				packetOut = new DatagramPacket(d, d.length, packetIn.getAddress(), packetIn.getPort());

				System.out.println("Vai enviar/responder:" + response);
				
				s.send(packetOut);
				
				System.out.println(
						"Enviou para " + (packetIn.getAddress()).toString() + "/" + packetIn.getPort() + "...");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			s.close();
		}
	}

	public void run() {
		Listar();
	}

	public static void main(String[] args) {
		(new UDPListar(5025,"pessoas")).start();
		(new UDPListar(5026,"chocolates")).start();
	}

}
