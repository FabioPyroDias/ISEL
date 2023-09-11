package tp3.XML;

import java.util.ArrayList;
import java.util.List;


import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Classe que representa um Evento do tipo Festival.
 * 
 * @version 1.0 
 * @author Docentes da Disciplina de Modelação e Programação, LEIM, Instituto Superior de Engenharia de Lisboa
 *
 */
public class Festival extends Evento {

	private static final int MAX_EVENTOS = 20;
	
	private Evento[] eventos = new Evento[MAX_EVENTOS];
	private int numEventos = 0;
	
	public Festival(String nome) {
		super(nome);
	}
	
	/**
	 * Devolve todos os bilhetes existentes no Festival (somando e devolvendo todos os bilhetes dos seus Eventos).
	 * @return o número de bilhetes existentes no Festival.
	 */
	public int getNumBilhetes() {
		
		int numBilhetes = 0;
		
		for(int index = 0; index < eventos.length; index++)
		{
			if(eventos[index] != null)
			{
				numBilhetes += eventos[index].getNumBilhetes();				
			}
		}
		
		return numBilhetes;
	}

	/**
	 * Retorna o número de actuaçõoes de um determinado artista.
	 * @param o nome do artista.
	 * @Override 
	 */
	public int numActuacoes(String artista) {
		
		int numActuacoes = 0;
		
		for(int index = 0; index < eventos.length; index++)
		{
			if(eventos[index] != null)
			{
				numActuacoes += eventos[index].numActuacoes(artista);				
			}
		}
		
		return numActuacoes;
	}
	
	/**
	 *  Devolve uma string representativa do Festival.
	 *  Nota: Ver o ficheiro OutputPretendido/OutputPretendido.txt
	 */
	public String toString() {
		return "Festival " + super.toString();
	}
	
	/**
	 * Devolve um array contendo todos, de forma não repetida, os nomes de todos os artistas quer irão 
	 * actuar no Festival.
	 * @return um array contendo os nomes dos artistas. 
	 */
	public String[] getArtistas() {
		
		List<String> artistas = new ArrayList<String>();
		
		for(int index = 0; index < eventos.length; index++)
		{
			if(eventos[index] != null)
			{
				String[] artistasRecolhidos = eventos[index].getArtistas();
				
				for(int indexArtistas = 0; indexArtistas < artistasRecolhidos.length; indexArtistas++)
				{
					if(!artistas.contains(artistasRecolhidos[indexArtistas]))
					{
						artistas.add(artistasRecolhidos[indexArtistas]);
					}
				}
			}
		}
		
		return (String[]) artistas.toArray(new String[artistas.size()]);
	}
	
	/**
	 * Retorna a profundidade maxima da "árvore" que contém Festivais dentro de Festivais. O próprio Festival não conta.
	 * @return a profundidade máxima.
	 */
	public int getDeepFestival() {
		
		int profundidade = -1;
		
		for(int index = 0; index < eventos.length; index++)
		{
			if(eventos[index] instanceof Festival)
			{
				profundidade = Math.max(profundidade, ((Festival) eventos[index]).getDeepFestival());
			}
		}
		
		profundidade++;
		
		return profundidade;
	}
	
	/**
	 * Adiciona um novo Evento ao Festival, caso para nenhum dos artistas do novo evento se verifique que o seu número de atuações no
	 * novo evento (a adicionar) supere em mais de duas o número de atuações no festival corrente.
	 * @param evento
	 * @return verdadeiro, se o novo Evento foi adicionado.
	 */
	public boolean addEvento(Evento evento) {
		
		if(numEventos == eventos.length || evento == null)
		{
			return false;
		}
		
		if(evento.getArtistas().length == 0)
		{
			return false;
		}
		
		String[] artistasEvento = evento.getArtistas();
		
		for(int indexArtista = 0; indexArtista < getArtistas().length; indexArtista++)
		{
			String artista = getArtistas()[indexArtista];
			
			for(int indexAComparar = 0; indexAComparar < artistasEvento.length; indexAComparar++)
			{
				String artistaAComparar = artistasEvento[indexAComparar];
				
				if(artista.equals(artistaAComparar))
				{
					if(evento.numActuacoes(artistaAComparar) > numActuacoes(artista) + 2)
					{
						return false;
					}
				}
			}
		}
		
		for(int index = 0; index < eventos.length; index++)
		{
			if(eventos[index] == null)
			{
				eventos[index] = evento;
				numEventos += 1;
				break;
			}
		}
		
		return true;
		
	}

	/**
	 * Remove um evento em qualquer profundidade do Festival corrente.
	 * @param nomeEvento nome do Evento a remover.
	 * @return verdadeiro, se o Evento foi removido.
	 */
	public boolean delEvento(String nomeEvento) {
		
		if(numEventos == 0 || nomeEvento == null)
		{
			return false;
		}
		
		boolean removido = false;

		for(int index = 0; index < eventos.length; index++)
		{
			if(eventos[index] instanceof Espetaculo)
			{
				if(eventos[index].toString().contains(nomeEvento))
				{
					eventos[index] = null;
					numEventos--;
					removido = true;
				}
			}
			else if(eventos[index] instanceof Festival)
			{
				if(eventos[index].toString().contains(nomeEvento))
				{
					eventos[index] = null;
					numEventos--;
					removido = true;
				}
				else
				{
					boolean removidoRecursivo = ((Festival) eventos[index]).delEvento(nomeEvento);
					
					if(!removido && removidoRecursivo)
					{
						removido = removidoRecursivo;
					}
				}
			}
		}
		
		return removido;
	}
	
	/**
	 * Imprime na consola informações sobre o Festival.
	 * Nota: Ver o output pretendido em OutputPretendido/OutputPretendido.txt.
	 * @param o prefixo para identar o Festival de acordo com a sua profundidade.
	 */
	public void print(String prefix) {
		
		System.out.println(prefix + toString());
		
		for(int eventoIndex = 0; eventoIndex < eventos.length; eventoIndex++)
		{
			if(eventos[eventoIndex] != null)
			{
				eventos[eventoIndex].print(prefix + " ");
			}
		}
	}
	
	/**
	 * Constroi um novo Festival a partir de um nó contendo as infomações lidas do documento XML. 
	 * @param nNode o nó associado ao Festival
	 * @return um novo Festival
	 */
	public static Festival build(Node nNode) {
		
		NodeList composicaoDoNode = nNode.getChildNodes();
		
		String nomeFestival = composicaoDoNode.item(1).getTextContent();
		
		Festival festival = new Festival(nomeFestival);
		
		if(composicaoDoNode.item(3).hasChildNodes())
		{
			NodeList eventos = composicaoDoNode.item(3).getChildNodes();
			
			for(int eventosIndex = 1; eventosIndex < eventos.getLength(); eventosIndex += 2)
			{
				festival.addEvento(Evento.build(eventos.item(eventosIndex)));
			}
		}
		
		return festival;
	}
	
	/**
	 * Cria um novo Elemento quer irá representar, no documento XML, o Festival associado ao Festival corrente.
	 * @param doc o Documento que irá ser usado para gerar o novo Element.
	 */
	public Element createElement(Document doc) {
		
		Element elementoFestival = doc.createElement("Festival");
		
		Element elementoNome = doc.createElement("Nome");
		elementoNome.appendChild(doc.createTextNode(getNome()));
		
		Element elementoEventos = doc.createElement("Eventos");
		
		for(int indexEventos = 0; indexEventos < eventos.length; indexEventos++)
		{
			if(eventos[indexEventos] != null)
			{
				Element elementoEvento = eventos[indexEventos].createElement(doc);
				
				elementoEventos.appendChild(elementoEvento);
			}
		}
		
		elementoFestival.appendChild(elementoNome);
		elementoFestival.appendChild(elementoEventos);
		
		return elementoFestival;
	}
	
	/**
	 * Método main que gera no output o que está no ficheiro OutputPretendido/OutputPretendido.txt e cria um novo
	 * documento XML/Eventos.xml, com a mesma estrutura que o documento OutputPretendido/Eventos.xml.
	 * @param args
	 */
	public static void main(String[] args) {
		
	      try {

	    	 File inputFile = new File("XML/BaseDados.xml");
	    	 
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	         
	     	 XPath xpath = XPathFactory.newInstance().newXPath();
			 String expression = "/BaseDados/Eventos/*";
			 NodeList nList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
	        
	         Node nNode = nList.item(0);
	         Evento evento = Evento.build(nNode);     
	         if(evento != null) evento.print("");

	
	    	 Festival fNovo = new Festival("Bollywood Music Festival"); 
			
			 Espetaculo e1_1 = new Espetaculo("Suna Hai", "Sines", 500);
			 e1_1.addArtista("Suna Hai");
			 fNovo.addEvento(e1_1);
			
			 Espetaculo e1_2 = new Espetaculo("Rait Zara", "Sines", 400);
			 e1_2.addArtista("Rait Zara");
			 fNovo.addEvento(e1_2);
		
			 if(evento instanceof Festival) {
				
				 Festival festival = (Festival)evento;
				 festival.addEvento(fNovo);
				
				 // root elements
				 Document newDoc = dBuilder.newDocument();
				 Element rootElement = newDoc.createElement("Eventos");
				 
				 rootElement.appendChild(festival.createElement(newDoc));
				 
				 newDoc.appendChild(rootElement);
				 	
				 FileOutputStream output = new FileOutputStream("XML/Eventos.xml");
		         writeXml(newDoc, output);

			 }
	        
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	}

	/**
	 * Escreve, para o OutputStream, o documento doc.
	 * @param doc o documento contendo os Elementos a gravar on ficheiro output
	 * @param output o ficheiro de saída.
	 */
	private static void writeXml(Document doc, OutputStream output) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        
        // pretty print XML
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
    }

	
}








