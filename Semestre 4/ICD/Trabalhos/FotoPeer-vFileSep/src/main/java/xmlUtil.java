import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class xmlUtil {
	
	public static boolean Validar(Document document, String xsdFile) {
		Schema schema = null;
		try {
			String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(language);
			schema = factory.newSchema(new File(xsdFile));
			Validator validator = schema.newValidator();
			validator.validate(new DOMSource(document)); // se falhar existe
															// excepção
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* escreve um dom para um stream de output */
	
	public static final void writeDocument(Document input, OutputStream output) {
        try {
        	DOMSource domSource = new DOMSource(input);
        	StreamResult resultStream = new StreamResult(output);
        	TransformerFactory transformFactory = TransformerFactory.newInstance();
        	Transformer transformer = transformFactory.newTransformer();
        	try {
        		transformer.transform(domSource, resultStream);
        	} catch (javax.xml.transform.TransformerException e) {
        	}
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	/* lê um dom do de um stream de input */
	
	public static final Document readDocument(InputStream input) {
		// create a new DocumentBuilderFactory
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      Document doc=null;
	      try {
	         // use the factory to create a documentbuilder
	         DocumentBuilder builder = factory.newDocumentBuilder();
	         doc = builder.parse(input);
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	      return doc;
	}
	
	/* exemplo de validação com xsd de um protocolo */
	public static void main(String[] args) {
		imprimeMetodos(xmlUtil.class);
		String Listar="<?xml version='1.0' encoding='ISO-8859-1'?>"+
"<Protocolo>"+
	"<Listar>"+
		"<Resposta>"+
			"<Foto path='fotos/foto1' mime='image/jpg'/>"+
			"<Foto path='fotos/foto2' mime='image/png'/>"+
		"</Resposta>"+
	"</Listar>"+
"</Protocolo>";
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
			document = builder.parse(new InputSource(new StringReader(Listar)));
		} catch (SAXException e) {
			e.printStackTrace();
			System.out.println("Não foi possivel analisar a mensagem!");
			return;
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Não foi possivel analisar a mensagem!");
			return;
		}
		if (!Validar(document, "src"+ File.separator + "main"+ File.separator + "webapp"+ File.separator + "protocolo.xsd"))
			System.out.println("A mensagem não respeita o protocolo!");
		else
			System.out.println("A mensagem respeita o protocolo!");
	}
	// apresenta todos os metodos da class indicada
	public static void imprimeMetodos(Class<?> c){
		System.out.println("Lista de metodos da classe: "+c.getName());
		java.lang.reflect.Method[] m = c.getMethods();
		for(int i=0; i<m.length; i++)
		  System.out.println("Metodo[" + i + "]: " + m[i]);
	}
	// apresenta todos os metodos do objecto indicado
	public static void imprimeMetodos(Object o){
		imprimeMetodos(o.getClass());
	}
}
