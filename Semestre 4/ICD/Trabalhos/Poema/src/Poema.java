import javax.xml.parsers.*;
import org.w3c.dom.*;

import utils.XMLDoc;

public class Poema {

	private Document poema;
	
	private Document[] outrosPoemas;
	private Document poemaV1;
	private Document poemaV2;
	private Document poemaV3;
	private String documentoXSDPoema;
	private String documentoXSDSoneto;
	
	public static void main(String[] args) {
		
		Poema app = new Poema();
		
		app.CarregarPoema();
		app.Apresentar();
		app.Classificador();
		app.AcrescentarVerso(3);
		app.Classificador();
		app.RemoverEstrofe(1);
		app.Classificador();
		app.ApresentarVersosComPalavra("E");
	
		app.CarregarOutrosPoemasEXSD();
		app.ValidarXSDPoemaEXSDSoneto();
	}
	
	private void CarregarPoema()
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			poema = builder.parse("poema.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Apresentar()
	{
		Element root = poema.getDocumentElement();
		
		//Título
		System.out.println("Título: " + (((Element) root.getElementsByTagName("titulo").item(0)).getTextContent()));
		System.out.println();
		
		//Estrofe
		NodeList estrofes = root.getElementsByTagName("estrofe");
		for(int estrofeIndex = 0; estrofeIndex < estrofes.getLength(); estrofeIndex++)
		{
			//Verso
			NodeList versos = ((Element) estrofes.item(estrofeIndex)).getElementsByTagName("verso");
			for(int versoIndex = 0; versoIndex < versos.getLength(); versoIndex++)
			{
				System.out.println(((Element)versos.item(versoIndex)).getTextContent());
			}
			System.out.println();
		}
		
		//Autor
		System.out.println("Autor: " + (((Element) root.getElementsByTagName("autor").item(0)).getTextContent()));
		System.out.println();
	}

	private void Classificador()
	{
		Element root = poema.getDocumentElement();
		
		//Estrofes
		NodeList estrofes = root.getElementsByTagName("estrofe");
		
		//Classificar Versos
		for(int estrofeIndex = 0; estrofeIndex < estrofes.getLength(); estrofeIndex++)
		{
			NodeList versos = ((Element) estrofes.item(estrofeIndex)).getElementsByTagName("verso");
			
			
			System.out.print("Estrofe " + (estrofeIndex + 1) + ": ");
			switch(versos.getLength())
			{
				case 1:
					System.out.println("Monóstico");
					break;
				
				case 2:
					System.out.println("Dístico");
					break;
				
				case 3:
					System.out.println("Terceto");
					break;
				
				case 4:
					System.out.println("Quadra");
					break;
				
				case 5:
					System.out.println("Quinteto");
					break;
				
				case 6:
					System.out.println("Hexástico");
					break;
					
				case 7:
					System.out.println("Hepteto");
					break;
					
				case 8:
					System.out.println("Oitava");
					break;
					
				case 9:
					System.out.println("Nona");
					break;
					
				case 10:
					System.out.println("Década");
					break;
					
				default:
					System.out.println("Sem classificação");
					break;
			}
		}
		
		System.out.println();
	}

	private void AcrescentarVerso(int estrofeIndex)
	{
		Element root = poema.getDocumentElement();
	
		NodeList estrofes = root.getElementsByTagName("estrofe");
		
		if(estrofeIndex <= 0 || estrofeIndex > estrofes.getLength())
		{
			System.out.println("Estrofe inválida");
			System.out.println();
			return;
		}
		
		Element estrofe = ((Element) estrofes.item(estrofeIndex - 1));
		Element verso = poema.createElement("verso");
		verso.setTextContent("Verso Adicionado");
		estrofe.appendChild(verso);
		
		System.out.println("O Verso foi adicionado com sucesso");
		System.out.println();
	}

	private void RemoverEstrofe(int estrofeARemover)
	{
		Element root = poema.getDocumentElement();
		
		NodeList estrofes = root.getElementsByTagName("estrofe");
		
		if(estrofeARemover <= 0 || estrofeARemover > estrofes.getLength())
		{
			System.out.println("Estrofe inválida");
			System.out.println();
			return;
		}
		
		Element estrofe = ((Element) estrofes.item(estrofeARemover - 1));
		root.removeChild(estrofe);
		
		System.out.println("A Estrofe foi removida com sucesso");
		System.out.println();
	}

	private void ApresentarVersosComPalavra(String palavra)
	{
		Element root = poema.getDocumentElement();
		
		NodeList estrofes = root.getElementsByTagName("estrofe");
		
		for(int estrofeIndex = 0; estrofeIndex < estrofes.getLength(); estrofeIndex++)
		{
			NodeList versos = ((Element) estrofes.item(estrofeIndex)).getElementsByTagName("verso");
			for(int versosIndex = 0; versosIndex < versos.getLength(); versosIndex++)
			{
				boolean pertence = false;
				
				String verso = ((Element) versos.item(versosIndex)).getTextContent();
				String[] palavras = verso.split(" ");
				
				for(int palavraIndex = 0; palavraIndex < palavras.length; palavraIndex++)
				{
					if(palavra.equals(palavras[palavraIndex]))
					{
						if(!pertence)
						{
							System.out.println(verso);
							pertence = true;							
						}
					}
				}
			}
		}
		
		System.out.println();
		
		/* Em relação a XPATH
		 * NodeList versos = XMLDoc.getXPath("/poema/estrofe/verso[contains(text(), '" + palavra + "')]", D);
		 * E depois um for para imprimir com o getTextContent().
		 */
	}
	
	private void CarregarOutrosPoemasEXSD()
	{	
		//Inicializar o array de Documentos XML
		outrosPoemas = new Document[3];
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		//Poema V1
		try {
			builder = factory.newDocumentBuilder();
			outrosPoemas[0] = builder.parse("poema_v1.xml");
			
			//poemaV1 = builder.parse("poema_v1.xml");
			//outrosPoemas[0] = poemaV1;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Poema V2
		try {
			builder = factory.newDocumentBuilder();
			outrosPoemas[1] = builder.parse("poema_v2.xml");
			
			//poemaV2 = builder.parse("poema_v2.xml");
			//outrosPoemas[1] = poemaV2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Poema V3
		try {
			builder = factory.newDocumentBuilder();
			outrosPoemas[2] = builder.parse("poema_v3.xml");
			
			//poemaV3 = builder.parse("poema_v3.xml");
			//outrosPoemas[2] = poemaV3;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Caminhos para Documentos XSD
		documentoXSDPoema = "poema.xsd";
		documentoXSDSoneto = "soneto.xsd";
	}
	
	private void ValidarXSDPoemaEXSDSoneto()
	{
		for(int poemaIndex = 0; poemaIndex < outrosPoemas.length; poemaIndex++)
		{
			System.out.print("O Poema versão " + (poemaIndex + 1) + " ");
			System.out.print(((XMLDoc.validDocXSD(outrosPoemas[poemaIndex], documentoXSDPoema) ? "é válido" : "não é válido")));
			System.out.println(" pelo XSD do Poema.");
			System.out.print(((XMLDoc.validDocXSD(outrosPoemas[poemaIndex], documentoXSDSoneto) ? "É válido" : "Não é válido")));
			System.out.println(" pelo XSD do Soneto.");
			System.out.println();
			
		}
		
		//XMLDoc.validDocXSD(poemaV1, documentoXSDPoema);
		//System.out.println("Entrei Poema");
		//XMLDoc.validDocXSD(poemaV1, documentoXSDSoneto);
		
	}
}