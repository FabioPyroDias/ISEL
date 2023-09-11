import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.OutputKeys;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Dados {

	private Document playerDatabase;
	public ArrayList<RegistoCliente> listaClientes;
	private ArrayList<Jogo> jogos;
	
	public Dados()
	{
		loadPlayerDatabase();
		listaClientes = new ArrayList<RegistoCliente>();
		jogos = new ArrayList<Jogo>();
	}
	
	private void loadPlayerDatabase()
	{
		File xmlFile = new File("PlayerDatabase.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			playerDatabase = builder.parse(xmlFile);
		} catch (Exception e) {
			createSaveFile();
		}
	}
	
	public Element verifyPlayer(String playerName)
	{
		NodeList playerElements = playerDatabase.getElementsByTagName("Player");
		
		for(int playerIndex = 0; playerIndex < playerElements.getLength(); playerIndex++)
		{
			if(((Element) playerElements.item(playerIndex)).getAttribute("playerName").equals(playerName))
			{
				return (Element) playerElements.item(playerIndex);
			}
		}
		
		return null;
	}
	
	public boolean verifyPassword(String playerName, String password)
	{
		NodeList playerElements = playerDatabase.getElementsByTagName("Player");
		Element player;
		
		for(int playerIndex = 0; playerIndex < playerElements.getLength(); playerIndex++)
		{
			player = ((Element) playerElements.item(playerIndex));
			
			if(player.getAttribute("playerName").equals(playerName))
			{
				if(player.getAttribute("password").equals(password))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		
		return false;
	}

	public void registerPlayer(String playerName, String password)
	{
		Element elementPlayer = playerDatabase.createElement("Player");
		
		elementPlayer.setAttribute("playerName", playerName);
		elementPlayer.setAttribute("password", password);
		elementPlayer.setAttribute("jogosJogados", "0");
		elementPlayer.setAttribute("jogosGanhos", "0");
		elementPlayer.setAttribute("jogosPerdidos", "0");
		
		Element elementNacionalidade = playerDatabase.createElement("Nacionalidade");
		Element elementIdade = playerDatabase.createElement("Idade");
		Element elementFotografia = playerDatabase.createElement("Fotografia");
		
		elementPlayer.appendChild(elementNacionalidade);
		elementPlayer.appendChild(elementIdade);
		elementPlayer.appendChild(elementFotografia);
		
		playerDatabase.getFirstChild().appendChild(elementPlayer);
		
		saveFile();
		System.out.println("Corri");
	}
	
	public String[] loadPlayer(String playerName)
	{
		String[] playerInfo = new String[6];
		NodeList players = playerDatabase.getElementsByTagName("Player");
		
		for(int playerIndex = 0; playerIndex < players.getLength(); playerIndex++)
		{
			Element player = ((Element) players.item(playerIndex));
			
			if(player.getAttribute("playerName").equals(playerName))
			{
				playerInfo[0] = player.getAttribute("jogosPerdidos");
				playerInfo[1] = player.getAttribute("jogosJogados");
				playerInfo[2] = player.getAttribute("jogosGanhos");
				playerInfo[3] = ((Element) player.getElementsByTagName("Nacionalidade").item(0)).getTextContent();
				playerInfo[4] = ((Element) player.getElementsByTagName("Idade").item(0)).getTextContent();
				playerInfo[5] = ((Element) player.getElementsByTagName("Fotografia").item(0)).getTextContent();
				
				return playerInfo;
			}
		}
		
		return null;
	}
	
	private void saveFile()
	{
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;
			transformer = transformerFactory.newTransformer();
			DOMSource sourceDOM = new DOMSource(playerDatabase);
			StreamResult result = new StreamResult(new File("PlayerDatabase.xml"));
			transformer.transform(sourceDOM, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createSaveFile()
	{
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			playerDatabase = builder.newDocument();
			Element rootElement = playerDatabase.createElement("PlayerDatabase");
			playerDatabase.appendChild(rootElement);
			
			saveFile();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createGame(String playerName)
	{
		Jogo jogo = new Jogo(playerName, playerName);
		
		jogos.add(jogo);
	}
	
	public Jogo getGame(String playerName)
	{
		for(Jogo jogo : jogos)
		{
			for(String player : jogo.getPlayers())
			{
				if(playerName.equals(player))
				{
					return jogo;
				}
			}
		}
		
		return null;
	}
}