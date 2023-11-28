import java.io.File;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Message {

	static Schema schema;
	
	public static void LoadXSD()
	{
		String xsdFile = "Protocolo.xsd";
	    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    try {
			schema = schemaFactory.newSchema(new Source[] {
			    new StreamSource(
			        new File(xsdFile))
			});
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println("XSD Protocol Load Complete");
	}
	
	public static boolean ValidateXMLMessage(String xmlMessage)
	{
		StringReader stringReader = new StringReader(xmlMessage);
	    try 
	    {
			schema.newValidator().validate(new StreamSource(stringReader));
		} 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
			return false;
		}

	    stringReader.close();
	    
	    return true;
	}
	
	private static Document getXMLDocument(String xmlMessage)
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		try
		{
			builder = factory.newDocumentBuilder();
			return builder.parse(new InputSource(new StringReader(xmlMessage)));
		}
		catch(Exception e)
		{
			System.out.println("Mensagem XML mal formada");
		}
		
		return null;
	}
	
	//Mensagens Cliente -> Servidor
	public static String SignIn(String username, String password)
	{
		return "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><SignIn username=\"" + username + "\" password=\"" + password + "\"/></Protocolo>";
	}
	
	public static String Login(String username, String password)
	{
		return "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><Login username=\"" + username + "\" password=\"" + password + "\"/></Protocolo>";
	}
	
	//Mensagens Servidor -> Cliente
	public static String SignInLoginAnswer(boolean valid, String profileName, String userType)
	{
		return "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><SignInLoginAnswer valid=\"" + valid + "\" profileName=\"" + profileName + "\" userType=\"" + userType + "\"/></Protocolo>";
	}
}