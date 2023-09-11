package utils;
//package protocolo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//import Dados.Utilizador;

public class XMLExtraUtils {
	public static Document getDocumentFromFileName(String file) {
		Document D = null;
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
				.newInstance();
		docBuilderFactory.setIgnoringElementContentWhitespace(false);
		docBuilderFactory.setIgnoringComments(false);
		try {
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			FileInputStream is = new FileInputStream(file); 
			D = docBuilder.parse(is);
		} catch (ParserConfigurationException e) {
			System.out.println("Wrong parser configuration: " + e.getMessage());
		} catch (SAXException e) {
			System.out.println("Wrong XML file structure: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not read source file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Excepcao. Could not read source file: " + e.getMessage());
		}		
		return D;
	}
	
	public static Document getDocumentFromString(String xml) {
		Document D = null;
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
				.newInstance();
		docBuilderFactory.setIgnoringElementContentWhitespace(false);
		docBuilderFactory.setIgnoringComments(false);
		try {
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes()); 
			D = docBuilder.parse(is);
		} catch (ParserConfigurationException e) {
			System.out.println("Wrong parser configuration: " + e.getMessage());
		} catch (SAXException e) {
			System.out.println("Wrong XML file structure: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not read source file: " + e.getMessage());
		}	
		return D;
	}
	
	public static final String ConvertDocumentToString(final Document input) {
		try {
			StringWriter sw = new StringWriter();
			
			DOMSource domSource = new DOMSource(input);
			StreamResult resultStream = new StreamResult(sw);
			TransformerFactory transformFactory = TransformerFactory
					.newInstance();
			// transforma��o vazia
			Transformer transformer = transformFactory.newTransformer();

			transformer
					.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			if (input.getXmlEncoding() != null)
				transformer.setOutputProperty(OutputKeys.ENCODING,
						input.getXmlEncoding());
			else
				transformer
						.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			try {
				transformer.transform(domSource, resultStream);
				
				String result = sw.getBuffer().toString();
				return result;
			} catch (javax.xml.transform.TransformerException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
}