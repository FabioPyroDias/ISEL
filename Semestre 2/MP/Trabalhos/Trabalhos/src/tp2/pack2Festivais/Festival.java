package tp2.pack2Festivais;

import java.util.ArrayList;
import java.util.List;

public class Festival extends Evento {

	private int numEventos = 0;
	
	private Evento[] eventos = new Evento[20];
	
	public Festival(String nome) {
		super(nome);
	}

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
	
	public String toString()
	{
		return "Festival " + super.toString();
	}
	
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
	
	private int getDeepFestival()
	{
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
	
	public boolean addEvento(Evento evento)
	{
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
	
	public boolean delEvento(String nomeEvento)
	{
		if(numEventos == 0 || nomeEvento == null)
		{
			return false;
		}
		
		boolean removido = false;

		for(int index = 0; index < eventos.length; index++)
		{
			if(eventos[index] instanceof Espectaculo)
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
	
	public static void main(String[] args) {

		System.out.println("#####---- Testes ----#####");
		System.out.println();
		
		System.out.println(" - Testar Métodos - ");
		System.out.println();
		
		String artistaTeste1 = "Afonso Risco";
		String artistaTeste2 = "Beatriz Valeta";
		String artistaTeste3 = "Carlos Trindade";
		String artistaTeste4 = "Dionisio Asa";
		String artistaTeste5 = "Eduardo Carreira";
		String artistaTeste6 = "Francisca Gilberto";
		
		Espectaculo espectaculoTeste1 = new Espectaculo("Teste Espectaculo 1", "Eclipse Main", 120);
		Espectaculo espectaculoTeste2 = new Espectaculo("Teste Espectaculo 2", "ISEL", 200);
		Espectaculo espectaculoTeste3 = new Espectaculo("Teste Espectaculo 3", "Marte", 1250);
		
		Festival festivalTeste1 = new Festival("Teste 1");
		Festival festivalTeste2 = new Festival("Teste 2");
		Festival festivalTeste3 = new Festival("Teste 3");
		Festival festivalTeste4 = new Festival("Teste 4");
		Festival festivalTeste5 = new Festival("Teste 5");
		
		espectaculoTeste1.addArtista(artistaTeste1);
		espectaculoTeste2.addArtista(artistaTeste2);
		espectaculoTeste2.addArtista(artistaTeste3);
		espectaculoTeste3.addArtista(artistaTeste4);
		espectaculoTeste3.addArtista(artistaTeste5);
		espectaculoTeste3.addArtista(artistaTeste6);
		
		System.out.println("Artistas: ");
		System.out.println(artistaTeste1);
		System.out.println(artistaTeste2);
		System.out.println(artistaTeste3);
		System.out.println(artistaTeste4);
		System.out.println(artistaTeste5);
		System.out.println(artistaTeste6);
		System.out.println();
		
		System.out.println("Espectáculos: ");
		System.out.println(espectaculoTeste1.toString());
		System.out.println(espectaculoTeste2.toString());
		System.out.println(espectaculoTeste3.toString());
		System.out.println();
		
		System.out.println("Festivais: ");
		System.out.println(festivalTeste1.toString());
		System.out.println(festivalTeste2.toString());
		System.out.println(festivalTeste3.toString());
		System.out.println(festivalTeste4.toString());
		System.out.println();
		
		System.out.println("####### addEvento #######");
		System.out.println();
		
		System.out.println("Adicionar Teste Espectaculo 1, quatro vezes, a Festival Teste 1");
		System.out.println("Adicionar Teste Espectaculo 1 a Festival Teste 1 > Expectável : true  | Recebido : " + festivalTeste1.addEvento(espectaculoTeste1));
		System.out.println("Adicionar Teste Espectaculo 1 a Festival Teste 1 > Expectável : true  | Recebido : " + festivalTeste1.addEvento(espectaculoTeste1));
		System.out.println("Adicionar Teste Espectaculo 1 a Festival Teste 1 > Expectável : true  | Recebido : " + festivalTeste1.addEvento(espectaculoTeste1));
		System.out.println("Adicionar Teste Espectaculo 1 a Festival Teste 1 > Expectável : true  | Recebido : " + festivalTeste1.addEvento(espectaculoTeste1));
		System.out.println();
		
		System.out.println("Adicionar Teste Espectaculo 1 a Festival Teste 2");
		System.out.println("Adicionar Teste Espectaculo 1 a Festival Teste 2 > Expectável : true  | Recebido : " + festivalTeste2.addEvento(espectaculoTeste1));
		System.out.println();
		
		System.out.println("Adicionar Festival Teste 1 a Festival Teste 2");
		System.out.println("Adicionar Festival Teste 1 a Festival Teste 2 > Expectável : false  | Recebido : " + festivalTeste2.addEvento(festivalTeste1));
		System.out.println("Justificação : NumActuações de Afonso Risco > Festival Teste 1 : " + festivalTeste1.numActuacoes(artistaTeste1) + " | Festival Teste 2 : " + festivalTeste2.numActuacoes(artistaTeste1));
		System.out.println();
		
		System.out.println("Adicionar Teste Espectaculo 2, duas vezes, a Festival Teste 3");
		System.out.println("Adicionar Teste Espectaculo 2 a Festival Teste 3 > Expectável : true  | Recebido : " + festivalTeste3.addEvento(espectaculoTeste2));
		System.out.println("Adicionar Teste Espectaculo 2 a Festival Teste 3 > Expectável : true  | Recebido : " + festivalTeste3.addEvento(espectaculoTeste2));
		System.out.println();
		
		System.out.println("Adicionar Teste Espectaculo 3, duas vezes, a Festival Teste 3");
		System.out.println("Adicionar Teste Espectaculo 3 a Festival Teste 3 > Expectável : true  | Recebido : " + festivalTeste3.addEvento(espectaculoTeste3));
		System.out.println("Adicionar Teste Espectaculo 3 a Festival Teste 3 > Expectável : true  | Recebido : " + festivalTeste3.addEvento(espectaculoTeste3));
		System.out.println();
		
		System.out.println("Adicionar Festival Teste 1 a Festival Teste 4 > Expectável : true | Recebido : " + festivalTeste4.addEvento(festivalTeste1));
		System.out.println("Adicionar Festival Teste 2 a Festival Teste 4 > Expectável : true | Recebido : " + festivalTeste4.addEvento(festivalTeste2));
		System.out.println("Adicionar Festival Teste 3 a Festival Teste 4 > Expectável : true | Recebido : " + festivalTeste4.addEvento(festivalTeste3));
		System.out.println();
		
		System.out.println("Adicionar Festival Teste 4 a Festival Teste 5 >    Expectável : true | Recebido : " + festivalTeste5.addEvento(festivalTeste4));
		System.out.println("Adicionar Festival Teste 1 a Festival Teste 5 >    Expectável : true | Recebido : " + festivalTeste5.addEvento(festivalTeste1));
		System.out.println("Adicionar Espectaculo Teste 1 a Festival Teste 5 > Expectável : true | Recebido : " + festivalTeste5.addEvento(espectaculoTeste1));
		System.out.println();
		
		System.out.println("Festivais: ");
		System.out.println(festivalTeste1.toString());
		System.out.println(festivalTeste2.toString());
		System.out.println(festivalTeste3.toString());
		System.out.println(festivalTeste4.toString());
		System.out.println(festivalTeste5.toString());
		System.out.println();
		
		System.out.println("####### addEvento #######");
		System.out.println();
		
		System.out.println("####### getArtistas #######");
		System.out.println();
		
		System.out.print("Artistas do Festival Teste 1 : ");
		String[] artistasFestivalTeste1 = festivalTeste1.getArtistas();
		
		for(int indexArtista = 0; indexArtista < artistasFestivalTeste1.length; indexArtista++)
		{
			if(indexArtista == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(artistasFestivalTeste1[indexArtista]);
			
			if(indexArtista == artistasFestivalTeste1.length - 1)
			{
				System.out.println("]");
			}
			else 
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.print("Artistas do Festival Teste 2 : ");
		String[] artistasFestivalTeste2 = festivalTeste2.getArtistas();
		
		for(int indexArtista = 0; indexArtista < artistasFestivalTeste2.length; indexArtista++)
		{
			if(indexArtista == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(artistasFestivalTeste2[indexArtista]);
			
			if(indexArtista == artistasFestivalTeste2.length - 1)
			{
				System.out.println("]");
			}
			else 
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.print("Artistas do Festival Teste 3 : ");
		String[] artistasFestivalTeste3 = festivalTeste3.getArtistas();
		
		for(int indexArtista = 0; indexArtista < artistasFestivalTeste3.length; indexArtista++)
		{
			if(indexArtista == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(artistasFestivalTeste3[indexArtista]);
			
			if(indexArtista == artistasFestivalTeste3.length - 1)
			{
				System.out.println("]");
			}
			else 
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.print("Artistas do Festival Teste 4 : ");
		String[] artistasFestivalTeste4 = festivalTeste4.getArtistas();
		
		for(int indexArtista = 0; indexArtista < artistasFestivalTeste4.length; indexArtista++)
		{
			if(indexArtista == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(artistasFestivalTeste4[indexArtista]);
			
			if(indexArtista == artistasFestivalTeste4.length - 1)
			{
				System.out.println("]");
			}
			else 
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.print("Artistas do Festival Teste 5 : ");
		String[] artistasFestivalTeste5 = festivalTeste5.getArtistas();
		
		for(int indexArtista = 0; indexArtista < artistasFestivalTeste5.length; indexArtista++)
		{
			if(indexArtista == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(artistasFestivalTeste5[indexArtista]);
			
			if(indexArtista == artistasFestivalTeste5.length - 1)
			{
				System.out.println("]");
			}
			else 
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.println("####### getArtistas #######");
		System.out.println();
		
		System.out.println("####### getnumBilhetes #######");
		System.out.println();
		
		System.out.println("Bilhetes do Festival Teste 1 : " + festivalTeste1.getNumBilhetes());
		System.out.println("Bilhetes do Festival Teste 2 : " + festivalTeste2.getNumBilhetes());
		System.out.println("Bilhetes do Festival Teste 3 : " + festivalTeste3.getNumBilhetes());
		System.out.println("Bilhetes do Festival Teste 4 : " + festivalTeste4.getNumBilhetes());
		System.out.println("Bilhetes do Festival Teste 5 : " + festivalTeste5.getNumBilhetes());
		System.out.println();
		
		System.out.println("####### getNumBilhetes #######");
		System.out.println();
		
		System.out.println("####### numActuacoes #######");
		System.out.println();
		
		System.out.println("Numero de Actuacções de " + artistaTeste1 + " no Festival Teste 1 > Expectável : 4  | Recebido : " + festivalTeste1.numActuacoes(artistaTeste1));
		System.out.println("Numero de Actuacções de " + artistaTeste1 + " no Festival Teste 2 > Expectável : 1  | Recebido : " + festivalTeste2.numActuacoes(artistaTeste1));
		System.out.println("Numero de Actuacções de " + artistaTeste1 + " no Festival Teste 3 > Expectável : 0  | Recebido : " + festivalTeste3.numActuacoes(artistaTeste1));
		System.out.println("Numero de Actuacções de " + artistaTeste1 + " no Festival Teste 4 > Expectável : 5  | Recebido : " + festivalTeste4.numActuacoes(artistaTeste1));
		System.out.println("Numero de Actuacções de " + artistaTeste1 + " no Festival Teste 5 > Expectável : 10 | Recebido : " + festivalTeste5.numActuacoes(artistaTeste1));
		System.out.println();
		
		System.out.println("Numero de Actuacções de " + artistaTeste2 + " no Festival Teste 1 > Expectável : 0 | Recebido : " + festivalTeste1.numActuacoes(artistaTeste2));
		System.out.println("Numero de Actuacções de " + artistaTeste2 + " no Festival Teste 2 > Expectável : 0 | Recebido : " + festivalTeste2.numActuacoes(artistaTeste2));
		System.out.println("Numero de Actuacções de " + artistaTeste2 + " no Festival Teste 3 > Expectável : 0 | Recebido : " + festivalTeste3.numActuacoes(artistaTeste2));
		System.out.println("Numero de Actuacções de " + artistaTeste2 + " no Festival Teste 4 > Expectável : 2 | Recebido : " + festivalTeste4.numActuacoes(artistaTeste2));
		System.out.println("Numero de Actuacções de " + artistaTeste2 + " no Festival Teste 5 > Expectável : 2 | Recebido : " + festivalTeste5.numActuacoes(artistaTeste2));
		System.out.println();
		
		System.out.println("Numero de Actuacções de " + artistaTeste3 + " no Festival Teste 1 > Expectável : 0 | Recebido : " + festivalTeste1.numActuacoes(artistaTeste3));
		System.out.println("Numero de Actuacções de " + artistaTeste3 + " no Festival Teste 2 > Expectável : 0 | Recebido : " + festivalTeste2.numActuacoes(artistaTeste3));
		System.out.println("Numero de Actuacções de " + artistaTeste3 + " no Festival Teste 3 > Expectável : 2 | Recebido : " + festivalTeste3.numActuacoes(artistaTeste3));
		System.out.println("Numero de Actuacções de " + artistaTeste3 + " no Festival Teste 4 > Expectável : 2 | Recebido : " + festivalTeste4.numActuacoes(artistaTeste3));
		System.out.println("Numero de Actuacções de " + artistaTeste3 + " no Festival Teste 5 > Expectável : 2 | Recebido : " + festivalTeste5.numActuacoes(artistaTeste3));
		System.out.println();
		
		System.out.println("Numero de Actuacções de " + artistaTeste4 + " no Festival Teste 1 > Expectável : 0 | Recebido : " + festivalTeste1.numActuacoes(artistaTeste4));
		System.out.println("Numero de Actuacções de " + artistaTeste4 + " no Festival Teste 2 > Expectável : 0 | Recebido : " + festivalTeste2.numActuacoes(artistaTeste4));
		System.out.println("Numero de Actuacções de " + artistaTeste4 + " no Festival Teste 3 > Expectável : 2 | Recebido : " + festivalTeste3.numActuacoes(artistaTeste4));
		System.out.println("Numero de Actuacções de " + artistaTeste4 + " no Festival Teste 4 > Expectável : 2 | Recebido : " + festivalTeste4.numActuacoes(artistaTeste4));
		System.out.println("Numero de Actuacções de " + artistaTeste4 + " no Festival Teste 5 > Expectável : 2 | Recebido : " + festivalTeste5.numActuacoes(artistaTeste4));
		System.out.println();
		
		System.out.println("Numero de Actuacções de " + artistaTeste5 + " no Festival Teste 1 > Expectável : 0 | Recebido : " + festivalTeste1.numActuacoes(artistaTeste5));
		System.out.println("Numero de Actuacções de " + artistaTeste5 + " no Festival Teste 2 > Expectável : 0 | Recebido : " + festivalTeste2.numActuacoes(artistaTeste5));
		System.out.println("Numero de Actuacções de " + artistaTeste5 + " no Festival Teste 3 > Expectável : 2 | Recebido : " + festivalTeste3.numActuacoes(artistaTeste5));
		System.out.println("Numero de Actuacções de " + artistaTeste5 + " no Festival Teste 4 > Expectável : 2 | Recebido : " + festivalTeste4.numActuacoes(artistaTeste5));
		System.out.println("Numero de Actuacções de " + artistaTeste5 + " no Festival Teste 5 > Expectável : 2 | Recebido : " + festivalTeste5.numActuacoes(artistaTeste5));
		System.out.println();
		
		System.out.println("Numero de Actuacções de " + artistaTeste6 + " no Festival Teste 1 > Expectável : 0 | Recebido : " + festivalTeste1.numActuacoes(artistaTeste6));
		System.out.println("Numero de Actuacções de " + artistaTeste6 + " no Festival Teste 2 > Expectável : 0 | Recebido : " + festivalTeste2.numActuacoes(artistaTeste6));
		System.out.println("Numero de Actuacções de " + artistaTeste6 + " no Festival Teste 3 > Expectável : 2 | Recebido : " + festivalTeste3.numActuacoes(artistaTeste6));
		System.out.println("Numero de Actuacções de " + artistaTeste6 + " no Festival Teste 4 > Expectável : 2 | Recebido : " + festivalTeste4.numActuacoes(artistaTeste6));
		System.out.println("Numero de Actuacções de " + artistaTeste6 + " no Festival Teste 5 > Expectável : 2 | Recebido : " + festivalTeste5.numActuacoes(artistaTeste6));
		System.out.println();
		
		System.out.println("####### numActuacoes #######");
		System.out.println();
		
		System.out.println("####### getDeepFestival #######");
		System.out.println();
		
		System.out.println("DeepFestival do Festival Teste 1 > Expectável : 0 | Recebido : " + festivalTeste1.getDeepFestival());
		System.out.println("DeepFestival do Festival Teste 2 > Expectável : 0 | Recebido : " + festivalTeste2.getDeepFestival());
		System.out.println("DeepFestival do Festival Teste 3 > Expectável : 0 | Recebido : " + festivalTeste3.getDeepFestival());
		System.out.println("DeepFestival do Festival Teste 4 > Expectável : 1 | Recebido : " + festivalTeste4.getDeepFestival());
		System.out.println("DeepFestival do Festival Teste 5 > Expectável : 2 | Recebido : " + festivalTeste5.getDeepFestival());
		System.out.println();
		
		System.out.println("####### getDeepFestival #######");
		System.out.println();
		
		System.out.println("####### delEvento #######");
		System.out.println();
		
		String artistaParaRemover1 = "Remover 1";
		String artistaParaRemover2 = "Remover 2";
		String artistaParaRemover3 = "Remover 3";
		String artistaParaRemover4 = "Remover 4";
		String artistaParaRemover5 = "Remover 5";
		
		Espectaculo espectaculoParaRemover1 = new Espectaculo("Remover Evento 1", "Testes", 100);
		Espectaculo espectaculoParaRemover2 = new Espectaculo("Remover Evento 2", "Testes", 300);
		
		Festival festivalParaRemover1 = new Festival("Remover Evento 1");
		Festival festivalParaRemover2 = new Festival("Remover Evento 2");
		
		espectaculoParaRemover1.addArtista(artistaParaRemover1);
		espectaculoParaRemover1.addArtista(artistaParaRemover2);
		espectaculoParaRemover2.addArtista(artistaParaRemover3);
		espectaculoParaRemover2.addArtista(artistaParaRemover4);
		espectaculoParaRemover2.addArtista(artistaParaRemover5);

		festivalParaRemover1.addEvento(espectaculoParaRemover2);
		festivalParaRemover2.addEvento(espectaculoParaRemover1);
		
		System.out.println("Criação de Eventos para Remover: ");
		
		System.out.println("Espectáculo 1 : " + espectaculoParaRemover1.toString());
		System.out.println("Espectáculo 2 : " + espectaculoParaRemover2.toString());
		System.out.println("Festival 1    : " + festivalParaRemover1.toString());
		System.out.println("Festival 2    : " + festivalParaRemover2.toString());
		System.out.println();
		
		System.out.println("Festival 2 Antes das Adições e Remoções : " + festivalTeste2.toString());
		System.out.println();
		
		System.out.println("Adicionar Festival Remover Evento 1 a Festival Teste 2 > Expectável : true | Recebido : " + festivalTeste2.addEvento(festivalParaRemover1));
		System.out.println("Adicionar Festival Remover Evento 2 a Festival Teste 2 > Expectável : true | Recebido : " + festivalTeste2.addEvento(festivalParaRemover2));
		System.out.println("Resultado : " + festivalTeste2.toString());
		System.out.println();
		
		System.out.println("Adicionar Espectaculo Remover Evento 1 a Festival Teste 2 > Expectável : true | Recebido : " + festivalTeste2.addEvento(espectaculoParaRemover1));
		System.out.println("Adicionar Espectaculo Remover Evento 2 a Festival Teste 2 > Expectável : true | Recebido : " + festivalTeste2.addEvento(espectaculoParaRemover2));
		System.out.println("Resultado : " + festivalTeste2.toString());
		System.out.println();
		
		System.out.println("Adicionar Festival Remover Evento 2 a Festival Remover Evento 1 > Expectável : true | Recebido : " + festivalParaRemover1.addEvento(festivalParaRemover2));
		System.out.println("Resultado : " + festivalParaRemover1.toString());
		System.out.println("Resultado Festival Teste 2 : " + festivalTeste2.toString());
		System.out.println();
		
		System.out.println("Eliminar Festival Remover Evento 1 de Festival Teste 2 : ");
		System.out.println("Eliminar Festival Remover Evento 1 de Festival Teste 2 > Expectável : true  | Recebido : " + festivalTeste2.delEvento("Remover Evento 1"));
		System.out.println("Eliminar Festival Remover Evento 1 de Festival Teste 2 > Expectável : false | Recebido : " + festivalTeste2.delEvento("Remover Evento 1"));
		System.out.println("Resultado : " + festivalTeste2.toString());
		System.out.println();
		
		System.out.println("Eliminar Festival Remover Evento 2 de Festival Teste 2 > Expectável : true  | Recebido : " + festivalTeste2.delEvento("Remover Evento 2"));
		System.out.println("Eliminar Festival Remover Evento 2 de Festival Teste 2 > Expectável : false | Recebido : " + festivalTeste2.delEvento("Remover Evento 2"));
		System.out.println("Resultado : " + festivalTeste2.toString());
		System.out.println();
		
		System.out.println("####### delEvento #######");
		System.out.println();
	}
}