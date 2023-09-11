import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Mensagem {

	static Schema schema;
	
	public static void LoadXSD()
	{
		String xsdFile = "ProtocoloXSD.xsd";
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
	    
	    System.out.println("Load Complete");
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
			System.out.println("Mensagem XML má formada");
		}
		
		return null;
	}
	
	public static String[] analiseMessage(String xmlMessage)
	{
		Document xmlDoc = getXMLDocument(xmlMessage);

		Element messageElement = (Element) xmlDoc.getFirstChild().getFirstChild();

		switch(messageElement.getTagName())
		{
			case "SignIn":	
				
				return getParametersSignIn(messageElement);
			
			case "Login":
				
				return getParametersLogin(messageElement);
				
			case "LoginAnswer":
				
				System.out.println("MENSAGEM -> AnaliseMessage, LoginAnswer");
				
				return getParametersLoginAnswer(messageElement);
				
			case "AddPlayer":
				
				return getParametersAddPlayer(messageElement);
				
			case "PlayColumn":
				
				return getParametersPlayColumn(messageElement);
				
			default:
				
				return null;
		}
	}
	
	public static String[] getParametersSignIn(Element signInElement)
	{
		String parameters[] = new String[3];
		
		parameters[0] = signInElement.getTagName();
		parameters[1] = signInElement.getAttribute("playerName");
		parameters[2] = signInElement.getAttribute("password");
		
		return parameters;
	}
	
	public static String[] getParametersLogin(Element loginElement)
	{
		String parameters[] = new String[3];
		
		parameters[0] = loginElement.getTagName();
		parameters[1] = loginElement.getAttribute("playerName");
		parameters[2] = loginElement.getAttribute("password");
		
		return parameters;
	}
	
	public static String[] getParametersLoginAnswer(Element loginAnswerElement)
	{
		String[] parameters;
		System.out.print("Mensagem -> getParametersLoginAnswer ");
		if(loginAnswerElement.getAttribute("validate").equals("false"))
		{
			parameters = new String[2];
			
			parameters[0] = loginAnswerElement.getTagName();
			parameters[1] = "false";
			
			System.out.println("Entrei no validate: false");
			
			return parameters;
		}
		else
		{
			int numberOfPlayers = loginAnswerElement.getChildNodes().getLength();
			int playerInfoOffset = 4;
			
			parameters = new String[3 + numberOfPlayers * playerInfoOffset];
			
			parameters[0] = loginAnswerElement.getTagName();
			parameters[1] = "true";
			parameters[2] = Integer.toString(numberOfPlayers);
			
			for(int playerIndex = 0; playerIndex < numberOfPlayers; playerIndex++)
	    	{
				Element player = ((Element) loginAnswerElement.getChildNodes().item(playerIndex));
				
				parameters[playerIndex * playerInfoOffset + 3] = player.getAttribute("playerName");
				parameters[playerIndex * playerInfoOffset + 4] = player.getAttribute("jogosJogados");
				parameters[playerIndex * playerInfoOffset + 5] = player.getAttribute("jogosGanhos");
				parameters[playerIndex * playerInfoOffset + 6] = player.getAttribute("jogosPerdidos");
	    	}
			
			System.out.println("Entrei no validate: true. Tamanho dos parametros: " + parameters.length + " ||| " + parameters[0]);
			
			return parameters;	
		}
	
	}
	
	public static String[] getParametersAddPlayer(Element addPlayerElement)
	{
		String[] parameters = new String[5];
		
		parameters[0] = addPlayerElement.getTagName();
		parameters[1] = addPlayerElement.getAttribute("playerName");
		parameters[2] = addPlayerElement.getAttribute("jogosJogados");
		parameters[3] = addPlayerElement.getAttribute("jogosGanhos");
		parameters[4] = addPlayerElement.getAttribute("jogosPerdidos");
		
		return parameters;
	}
	
	public static String[] getParametersPlayColumn(Element playColumnElement)
	{
		String[] parameters = new String[3];
		
		parameters[0] = playColumnElement.getTagName();
		parameters[1] = playColumnElement.getAttribute("playerName");
		parameters[2] = playColumnElement.getAttribute("column");
		
		return parameters;
	}
	
	//TODO Métodos Cliente -> Servidor
	public static String SignIn(String playerName, String password)
	{
		return "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><SignIn playerName=\"" + playerName + "\" password=\""+ password + "\"/></Protocolo>";
	}
	
	public static String Login(String playerName, String password)
	{
		return "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><Login playerName=\"" + playerName + "\" password=\""+ password + "\"/></Protocolo>";
	}
	
	public static String ChallengePlayer(String playerName)
	{
		return "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><Challenge playerName=\"" + playerName + "\"/></Protocolo>";
	}
	
	public static String PlayColumn(String player, String column)
	{
		return "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><PlayColumn playerName=\"" + player + "\" column=\"" + column + "\"/></Protocolo>";
	}
	
	//TODO Métodos Servidor -> Cliente
	public static String LoginAnswer(boolean validate, int numberOfPlayers, String[] playersInformation)
	{
		String message = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><LoginAnswer validate=\"" + validate + "\"";
		
		if(!validate)
		{
			return  message + "/></Protocolo>";
		}
		
		message += ">";
		
		int informationOffset = 4;
		
		for(int index = 0; index < numberOfPlayers; index++)
		{
			message += "<Player playerName=\"" + playersInformation[index * informationOffset] + "\" jogosJogados=\"" + playersInformation[index * informationOffset + 1] + "\" jogosGanhos=\"" + playersInformation[index * informationOffset + 2] + "\" jogosPerdidos=\"" + playersInformation[index * informationOffset + 3] + "\"/>";
		}
		System.out.println("MENSAGEM -> LoginAnswer, mensagem retornada: " + message);
		return message + "</LoginAnswer></Protocolo>";
	}
	
	public static String AddPlayer(String playerName, int jogosJogados, int jogosGanhos, int jogosPerdidos)
	{
		return "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><AddPlayer playerName=\"" + playerName + "\" jogosJogados=\"" + jogosJogados + "\" jogosGanhos=\"" + jogosGanhos + "\" jogosPerdidos=\"" + jogosPerdidos + "\"/></Protocolo>";
	}
	
	public static String RemovePlayer(String playerName)
	{
		return "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><RemovePlayer playerName=\"" + playerName + "\"/></Protocolo>";
	}
	
	public static String ChallengePlayerAnswer(boolean answer)
	{
		return "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><ChallengePlayerAnswer answer=\"" + answer + "\"/></Protocolo>";
	}

	public static String UpdatedBoard(String[] board, String currentTurnPlayerName)
	{
		String message = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?><Protocolo><UpdateBoard nextPlayerTurn=\"" + currentTurnPlayerName + "\">";
		
		for(int rowCol = 0; rowCol < board.length; rowCol++)
		{
			message += "<BoardSlot>" + board[rowCol] + "</BoardSlot>";			
		}
		
		return message + "</UpdateBoard></Protocolo>";
	}
}