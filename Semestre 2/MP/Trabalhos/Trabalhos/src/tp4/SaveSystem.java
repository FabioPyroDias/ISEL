package tp4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SaveSystem {
	
	private static File saveFile;
	
	public static void saveFileInitialization()
	{
		saveFile = new File("SaveFile.xml");
		
		if(!saveFile.exists())
		{
			try {
				saveFile.createNewFile();
				createSaveFile();
			} catch (IOException e) {
				System.out.println("An error has occurred");
				e.printStackTrace();
			}
		}
	}
	
	private static void createSaveFile()
	{
        try {
        	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("SaveData");
            
            Element saves = doc.createElement("SaveGames");
            Element lastSave = doc.createElement("LastSavedGame");
            
            rootElement.appendChild(saves);
            rootElement.appendChild(lastSave);
            
            doc.appendChild(rootElement);
        
            FileOutputStream output = new FileOutputStream("SaveFile.xml");
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            // pretty print XML
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(output);

            transformer.transform(source, result);
            
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}

	public static boolean checkSavedGame(Player player)
	{
		try 
		{
			File inputFile = saveFile;
	   	 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
		
			XPath xpath = XPathFactory.newInstance().newXPath();
			String expression = "SaveData/SaveGames/*";
			NodeList saves = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
			
			for(int index = 0; index < saves.getLength(); index++)
			{
				Node save = saves.item(index);
				if(save.getNodeType() == Node.ELEMENT_NODE)
				{
					Element nome = (Element) ((Element) save).getElementsByTagName("Name").item(0);
					
					if(nome.getTextContent().equals(player.getNome()))
					{
						return true;
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Erro: " + e.toString());
		}
		
		return false;
	}

	public static void saveGame(Player player)
	{
		try 
		{
			File inputFile = saveFile;
	   	 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
		
			XPath xpath = XPathFactory.newInstance().newXPath();
			String expression = "SaveData/SaveGames/*";
			NodeList saves = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
			
			boolean doesAlreadyExist = false;
			int saveIndex = 0;
			
			for(int index = 0; index < saves.getLength(); index++)
			{
				Node save = saves.item(index);
				if(save.getNodeType() == Node.ELEMENT_NODE)
				{
					Element nome = (Element) ((Element) save).getElementsByTagName("Name").item(0);
					
					if(nome.getTextContent().equals(player.getNome()))
					{
						doesAlreadyExist = true;
						saveIndex = index;
						break;
					}
				}
			}
			
			if(doesAlreadyExist)
			{
				Element save = (Element) saves.item(saveIndex);
				Element previousItems = (Element) save.getElementsByTagName("Items");
				
				Element equipped = doc.createElement("Equipped");
				Item[] equippedItems = player.getEquippedItems();
				
				for(int index = 0; index < equippedItems.length; index++)
				{
					if(equippedItems[index] != null)
					{
						Element item = doc.createElement(equippedItems[index].getType());
						
						Element itemName = doc.createElement("Name");
						itemName.setTextContent(equippedItems[index].getNome());
						
						Element itemRarity = doc.createElement("Rarity");
						itemRarity.setTextContent(equippedItems[index].getRarity());
						
						Element itemHealth = doc.createElement("Health");
						itemHealth.setTextContent(String.valueOf(equippedItems[index].getHealthModifier()));
						
						Element itemAttack = doc.createElement("Attack");
						itemAttack.setTextContent(String.valueOf(equippedItems[index].getAttackModifier()));
						
						Element itemDefense = doc.createElement("Defense");
						itemDefense.setTextContent(String.valueOf(equippedItems[index].getDefenseModifier()));
						
						item.appendChild(itemName);
						item.appendChild(itemRarity);
						item.appendChild(itemHealth);
						item.appendChild(itemAttack);
						item.appendChild(itemDefense);
						
						equipped.appendChild(item);
					}
					else
					{
						Element item = null;
						
						switch(index)
						{
							case 0:
								
								item = doc.createElement("Weapon");
								
								break;
								
							case 1:
								
								item = doc.createElement("Helmet");
								
								break;
															
							case 2:
								
								item = doc.createElement("Armor");								
								
								break;
								
							case 3:
								
								item = doc.createElement("Pants");
								
								break;
								
							case 4:
								
								item = doc.createElement("Gloves");
								
								break;
								
							case 5:
								
								item = doc.createElement("Boots");
								
								break;
								
							default:
								break;
						}
						
						equipped.appendChild(item);
					}	
				}
				
				Element inventory = doc.createElement("Inventory");
				Item[] inventoryItems = player.getInventoryItems();
				
				for(int index = 0; index < inventoryItems.length; index++)
				{
					if(inventoryItems[index] != null)
					{
						Element item = doc.createElement("Item");
						
						Element itemName = doc.createElement("Name");
						itemName.setTextContent(inventoryItems[index].getNome());
						
						Element itemRarity = doc.createElement("Rarity");
						itemRarity.setTextContent(inventoryItems[index].getRarity());
						
						Element itemType = doc.createElement("Type");
						itemType.setTextContent(inventoryItems[index].getType());
						
						Element itemHealth = doc.createElement("Health");
						itemHealth.setTextContent(String.valueOf(inventoryItems[index].getHealthModifier()));
						
						Element itemAttack = doc.createElement("Attack");
						itemAttack.setTextContent(String.valueOf(inventoryItems[index].getAttackModifier()));
						
						Element itemDefense = doc.createElement("Defense");
						itemDefense.setTextContent(String.valueOf(inventoryItems[index].getDefenseModifier()));
						
						item.appendChild(itemName);
						item.appendChild(itemRarity);
						item.appendChild(itemType);
						item.appendChild(itemHealth);
						item.appendChild(itemAttack);
						item.appendChild(itemDefense);
						
						inventory.appendChild(item);
					}
				}
				
				save.removeChild(previousItems);
				
				Element items = doc.createElement("Items");
				items.appendChild(equipped);
				items.appendChild(inventory);
				
				save.appendChild(items);
			}
			else
			{
				Item[] equippedItems = player.getEquippedItems();
				Item[] inventoryItems = player.getInventoryItems();
				
				Element saveGame = doc.createElement("Game");
				
				Element nameElement = doc.createElement("Name");
				nameElement.setTextContent(player.getNome());
				
				Element itemsElement = doc.createElement("Items");
				
				Element equippedElement = doc.createElement("Equipped");
				
				for(int index = 0; index < equippedItems.length; index++)
				{
					if(equippedItems[index] != null)
					{
						Element item = doc.createElement(equippedItems[index].getType());
						
						Element itemName = doc.createElement("Name");
						itemName.setTextContent(equippedItems[index].getNome());
						
						Element itemRarity = doc.createElement("Rarity");
						itemRarity.setTextContent(equippedItems[index].getRarity());
						
						Element itemHealth = doc.createElement("Health");
						itemHealth.setTextContent(String.valueOf(equippedItems[index].getHealthModifier()));
						
						Element itemAttack = doc.createElement("Attack");
						itemAttack.setTextContent(String.valueOf(equippedItems[index].getAttackModifier()));
						
						Element itemDefense = doc.createElement("Defense");
						itemDefense.setTextContent(String.valueOf(equippedItems[index].getDefenseModifier()));
						
						item.appendChild(itemName);
						item.appendChild(itemRarity);
						item.appendChild(itemHealth);
						item.appendChild(itemAttack);
						item.appendChild(itemDefense);
						
						equippedElement.appendChild(item);
					}
					else
					{
						Element item = null;
						
						switch(index)
						{
							case 0:
								
								item = doc.createElement("Weapon");
								
								break;
								
							case 1:
								
								item = doc.createElement("Helmet");
								
								break;
															
							case 2:
								
								item = doc.createElement("Armory");								
								
								break;
								
							case 3:
								
								item = doc.createElement("Pants");
								
								break;
								
							case 4:
								
								item = doc.createElement("Gloves");
								
								break;
								
							case 5:
								
								item = doc.createElement("Boots");
								
								break;
								
							default:
								break;
						}
						
						equippedElement.appendChild(item);
					}	
				}
				
				Element inventoryElement = doc.createElement("Inventory");
				
				for(int index = 0; index < inventoryItems.length; index++)
				{
					if(inventoryItems[index] != null)
					{
						Element item = doc.createElement("Item");
						
						Element itemName = doc.createElement("Name");
						itemName.setTextContent(inventoryItems[index].getNome());
						
						Element itemRarity = doc.createElement("Rarity");
						itemRarity.setTextContent(inventoryItems[index].getRarity());
						
						Element itemType = doc.createElement("Type");
						itemType.setTextContent(inventoryItems[index].getType());
						
						Element itemHealth = doc.createElement("Health");
						itemHealth.setTextContent(String.valueOf(inventoryItems[index].getHealthModifier()));
						
						Element itemAttack = doc.createElement("Attack");
						itemAttack.setTextContent(String.valueOf(inventoryItems[index].getAttackModifier()));
						
						Element itemDefense = doc.createElement("Defense");
						itemDefense.setTextContent(String.valueOf(inventoryItems[index].getDefenseModifier()));
						
						item.appendChild(itemName);
						item.appendChild(itemRarity);
						item.appendChild(itemType);
						item.appendChild(itemHealth);
						item.appendChild(itemAttack);
						item.appendChild(itemDefense);
						
						inventoryElement.appendChild(item);
					}
				}
				
				itemsElement.appendChild(equippedElement);
				itemsElement.appendChild(inventoryElement);
				
				saveGame.appendChild(nameElement);
				saveGame.appendChild(itemsElement);
				
				expression = "SaveData/SaveGames";
				saves = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
			    
				saves.item(0).appendChild(saveGame);
				
				FileOutputStream output = new FileOutputStream("SaveFile.xml");
	            
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            
	            // pretty print XML
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(output);

	            transformer.transform(source, result);
			}
		}
		catch(Exception e)
		{
			System.out.println("Não foi possível guardar: " + e.toString());
		}
		// Procurar no SaveFile se existe algum jogo com o nome dessa personagem. Done
		// Se sim, substituir essa informação toda.
		// Se não, criar um novo elemento Game e gravar essa informação.
	}
	
	public static void loadGame(String playerName)
	{
		// A partir do playerName, encontrar o node-pai.
		// Carregar toda a informação desse jogo
	}
	
	public static void loadLastGame()
	{
		//A partir do Element LastSavedGame, do seu IDREF, vou obter o Element com essa referência.
		//Depois chamo o loadGame e como argumento o nome desse element
	}
}