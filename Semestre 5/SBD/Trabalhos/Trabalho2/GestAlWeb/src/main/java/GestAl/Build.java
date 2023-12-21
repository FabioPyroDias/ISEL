package GestAl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.concurrent.ThreadLocalRandom;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.util.Arrays;
import java.util.Date;
import  java.util.Random;
import java.util.StringTokenizer;

/**
 * @author Engº Porfírio Filipe
 */
/**
 * Gera dados de demonstração
 *
 */
public class Build {
	class MyRandom {
		
		private static double round(double value, int places) {
		    if (places < 0) throw new IllegalArgumentException();

		    BigDecimal bd = BigDecimal.valueOf(value);
		    bd = bd.setScale(places, RoundingMode.HALF_UP);
		    return bd.doubleValue();
		}
		
		private static double getRandom(double min, double max) {
		    Random random = new Random();
		    return Math.floor(random.nextDouble()*(max-min+1)+min);
		}
		
		private static double rnd(double min, double max) {
			//return Math.floor(Math.random()*(max-min+1)+min);
			return getRandom(min, max);
		}
			
		public static double grade() {
			return round(rnd(10, 20),2);
		}
		
		public static int year() {
			double i = rnd(-3, 2);
			return (int)i+Year.now().getValue();
		}
		
		public static int max(int m) {
			return (int)Math.round(rnd(1, m));
		}
		
	    public static void main( String args[] ) {
    	// Generate random integers  
	      int int_random = ThreadLocalRandom.current().nextInt();   
	      // Print random integers 
	      System.out.println("Random Integers: " + int_random); 
	      // Generate Random doubles 
	      double double_rand = ThreadLocalRandom.current().nextDouble(); 
	      // Print random doubles 
	      System.out.println("Random Doubles: " + double_rand); 
	      // Generate random booleans 
	      boolean boolean_rand = ThreadLocalRandom.current().nextBoolean(); 
	      // Print random booleans 
	      System.out.println("Random Booleans: " + boolean_rand);	    	
	      //Generate random values 
	      System.out.println("Random from 1 to 30: "+MyRandom.max(30));
	      System.out.println("Random grade: "+MyRandom.grade());
	      System.out.println("Random year: "+MyRandom.year());
	    }
	}
	
	private static Date between(Date startInclusive, Date endExclusive) {
	    long startMillis = startInclusive.getTime();
	    long endMillis = endExclusive.getTime();
	    long randomMillisSinceEpoch = ThreadLocalRandom
	      .current()
	      .nextLong(startMillis, endMillis);
	    return new Date(randomMillisSinceEpoch);
	}
	
	private static Date gerarDataNasc() {
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy"); 
		int year=Year.now().getValue();
		String inicio="01/01/"+(year-40);
		String fim="01/01/"+(year-18);
		try {
			return between(formatter.parse(inicio),formatter.parse(fim));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  null;
	}
	/**
	 * Gera um número de estudante aleatório
	 * @return número do estudante
	 */
	private static int gerarNumero(Manipula dados) {
		ResultSet rs=dados.getResultado("select numero from aluno");
		int rowCount=0;
		try {
			rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int fecth=MyRandom.max(rowCount);
		System.out.println("indice aluno/numero: "+fecth+"/"+rowCount);
		int numero=0;
		try {
			if(!rs.absolute(fecth))
				return 0;
			numero=rs.getInt("numero");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return numero;
	}
	/**
	 * Gera nome completo
	 * @param genero
	 * @return
	 */
	private static String gerarNome(String genero, Manipula dados) {
		String nome=gerarNomeProprio(genero, dados);
		int tentativas=0;
		String apelido="";
		do {
			if(tentativas++>10)
				break;
			apelido=gerarApelido(dados);
		}while(nome.indexOf(apelido)!=-1);
		nome=nome+" "+apelido;
		tentativas=0;
		do {
			if(tentativas++>10)
				break;
			apelido=gerarApelido(dados);
		}while(nome.indexOf(apelido)!=-1);
		nome=nome+" "+apelido;
		return nome;	
	}

	/**
	 * Gera um nome próprio
	 * @param genero
	 * @return
	 */
	private static String gerarNomeProprio(String genero, Manipula dados) {
		return gerarNome(1,genero, dados);	
	}
	/**
	 * Gera um apelido
	 * @param genero
	 * @return
	 */
	private static String gerarApelido(Manipula dados) {
		return gerarNome(MyRandom.max(3)+2,"", dados);	
	}
	/**
	 * Gera um nome de estudante aleatório
	 * @return nome do estudante
	 */
	private static String gerarNome(int posicao, String genero, Manipula dados) {
		String SQL="select nome, rand() from aluno ";
		if(genero.compareTo("")!=0)
			SQL=SQL+" where genero='"+genero+"'";
		SQL=SQL+" order by 2 limit 1";
		ResultSet rs=dados.getResultado(SQL);
		String nome="";
		try {
			if(!rs.next())
				return "";
			nome=Consola.proper(rs.getString("nome"));
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
		StringTokenizer st = new StringTokenizer(nome," ");
		int p=0;
		String res="";
		String nm="?";
		while(p++<posicao)
			if(st.hasMoreTokens()) {
				nm=st.nextToken();
				if(nome.length()>3)
					res=nm;
			}
			else
				break;
		return res;
	}
	
	/**
	 * Gera código de disciplina aleatório 
	 * @return código da disciplina
	 */
	private static String gerarCodigo(Manipula dados) {
		ResultSet rs=dados.getResultado("select codigo from disciplina");
		int rowCount=0;
		try {
			rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
		String codigo="";
		int fecth=MyRandom.max(rowCount);
		System.out.println("indice disciplina: "+fecth+"/"+rowCount);
		try {
			if(!rs.absolute(fecth))
				return "";
			codigo=rs.getString("codigo");
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
		return codigo;
	}
	
	/**
	 * Gera inscrições aleatórias
	 */
	public static void geraInscricao() {
		Manipula dados = new Manipula( new Configura());
		int a=Year.now().getValue();
		ResultSet rs = dados.getResultado("select x.numero, x.codigo, x.ano, RAND() rand from "+
						" (select numero, codigo, ano from aluno, disciplina, (select 2018 ano"+
						" union"+
						" select "+(a-3)+
						" union"+
						" select "+(a-2)+
						" union"+
						" select "+(a-1)+
						" union"+
						" select "+a+
						" union"+
						" select "+(a+1)+") z) x"+
						" LEFT JOIN"+ 
						" (select numero, codigo, ano from inscricao) y"+
						" ON (x.numero=y.numero and x.codigo=y.codigo and x.ano=y.ano)"+
						" WHERE y.numero is null order by rand");
		int rowCount=0;
		try {
			rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		int fecth=MyRandom.max(rowCount);
		System.out.println("indice inscricao: "+fecth+"/"+rowCount);
		String numero=null;
		String codigo=null;
		String ano=null;
		try {
			if(!rs.absolute(fecth))
				return;
			numero=rs.getString("numero");
			codigo=rs.getString("codigo");
			ano=rs.getString("ano");
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}	
		String insert="insert into inscricao (numero, ano, codigo) values "+
						" ("+numero+", "
							+ano+", '"
							+codigo+"')";
		System.out.println(insert);
		dados.xDirectiva(insert);
		dados.desligar();
	}
	
	/**
	 * Gera inscrições aleatórias
	 */
	public static void gerarInscricoes() {
		for(int i=0; i<1000; i++)
			geraInscricao();
	}
	
	/**
	 * Gera inscrições aleatórias
	 */
	public static void _gerarInscricoes() {
		Manipula dados = new Manipula( new Configura());
		String insert="";
		int nvezes=0;
		do {
			insert="insert into inscricao (numero, ano, codigo) values "+
						" ("+gerarNumero(dados)+", "
							+MyRandom.year()+", '"
							+gerarCodigo(dados)+"')";
			System.out.println(insert);
			nvezes++;
		} while(dados.xDirectiva(insert));  // pára quando dá erro
		System.out.println("Gerou "+nvezes+" inscricões!");
		dados.desligar();
	}
	
	/**
	 * atualiza datas
	 * @throws SQLException 
	 */
	public static void atualiza_datas(String data) throws SQLException {
		Manipula dados = new Manipula( new Configura());
		Manipula dados2 = new Manipula( new Configura());
		ResultSet rs = dados.getResultado("select numero from aluno where nascido='"+data+"'");
		SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd"); 
		while(rs.next())
			dados2.xDirectiva("update aluno set nascido="+formatter.format(gerarDataNasc())+" where numero="+rs.getString("numero"));
		dados.desligar();
		dados2.desligar();
	}
	
	/**
	 * Simula o lançamento de notas aleatórias
	 */
	public static void gerarNotas() {
		Manipula dados = new Manipula( new Configura());
		String update="";
		int nvezes=0;
		do {
			ResultSet rs=dados.getResultado("select numero, ano, codigo  from inscricao"+
							" where nota is null and ano<="+Year.now().getValue());
			int rowCount=0;
			try {
				rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
			} catch (SQLException e) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			}
			String codigo="";
			int ano=2022;
			int numero=0;
			int fecth=MyRandom.max(rowCount);
			System.out.println("indice notas: "+fecth+"/"+rowCount);
			try {
				if(!rs.absolute(fecth))
					break;
				codigo=rs.getString("codigo");
				ano=rs.getInt("ano");
				numero=rs.getInt("numero");
			} catch (SQLException e) {
				e.printStackTrace();
				break;
			}
			update="update inscricao set nota="+MyRandom.grade()+
					" where numero="+numero+" and ano="+ano+" and codigo='"+codigo+"'";
			nvezes++;
			System.out.println(update);
		} while(dados.xDirectiva(update)&&nvezes<100);
		dados.xDirectiva("update inscricao set nota=ROUND(10*rand()+10,2) where nota>18");
		dados.xDirectiva("update inscricao set nota=ROUND(10*rand()+10,2) where nota<12");
		System.out.println("Lançou "+nvezes+" notas!");
		dados.desligar();
	}
	
	/**
	 * Sugere dados de novos alunos
	 */
	public static void sugerirAluno() {
		Manipula dados = new Manipula( new Configura());
		System.out.println("Sugestão de nomes a usar:");
		System.out.println("Nome masculino: "+Build.gerarNome("M",dados));
		System.out.println("Nome feminino: "+Build.gerarNome("F",dados));
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy"); 
		System.out.println("Data de Nascimento: "+formatter.format(gerarDataNasc()));
		dados.desligar();
	}
	
	/**
	 * Descarrega todas a fotos para uma pasta
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void descarregaFotos(String path) throws SQLException, IOException {
		Manipula dados = new Manipula( new Configura());
		ResultSet rs=dados.getResultado("select a.numero, nome, genero from aluno a, foto f where a.numero=f.numero order by numero");
		while (rs.next()) {
			String[] arrOfStr = rs.getString("nome").split(" ");
			String fileOutput=path+"\\"+rs.getString("genero")+"-"+
							rs.getString("numero")+"-"+arrOfStr[0]+" "+arrOfStr[arrOfStr.length-1]+".jpg";
			 System.out.println("Descarrega: "+fileOutput);
			 FileOutputStream fos = new FileOutputStream(fileOutput); 
	         fos.write(Gestor.getFoto(rs.getInt("numero")));
	         fos.close();
		
		}
		dados.desligar();
	}
	
	/**
	 *  Executa a geração de dados.
	 * @param args nunhum
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SQLException, IOException {

		char op;
		do {
			Consola.writeLine("*** Gerador de Dados  ***");
			Consola.writeLine("0. Terminar");
			Consola.writeLine("1. Gerar Inscrições");
			Consola.writeLine("2. Gerar Notas");
			Consola.writeLine("3. Sugerir Alunos");
			Consola.writeLine("4. Descarrega Fotos");
			Consola.writeLine("5. Atualizar Datas");
			Consola.writeLine("6. Testar Json");
			Consola.writeLine("7. Testar Split");
			op = Consola.readChar();
			switch (op) {
			case '1':
						Build.gerarInscricoes();
						break;
			case '2':
						Build.gerarNotas();
						break;
			case '3':	
						Build.sugerirAluno();
						break;
			case '4':	
						descarregaFotos("C:\\Partilha\\ISEL\\SBD\\2022-2023 Inv\\Laboratório\\2AulaPratica\\bd.fotos");
						break;
			case '5':
						Build.atualiza_datas("20000101");
						break;
			case '6': try {
			    		int PRETTY_PRINT_INDENT_FACTOR = 4;
			    		/*String TEST_XML_STRING =
			    				"<?xml version=\"1.0\" ?>"+
			    				"<alunos>"+		
			    					"<aluno numero=\"1\" nome=\"Albertina Jorge de Alpoim e Osório de Valdoleiros\" genero=\"F\" nascido=\"1990-04-08\"/>"+
			    					"<inscricao numero=\"1\" codigo=\"ICD\" ano=\"2022\"/>"+
			    					"<inscricao numero=\"1\" codigo=\"MAE\" ano=\"2020\" nota=\"13.76\"/>"+
			    					"<aluno numero=\"3\" nome=\"Sarah Ledesma Barrisco\" genero=\"F\" nascido=\"1998-01-06\"/>"+
			    				"</alunos>"; */
			    		String TEST_XML_STRING =
			    					"<aluno numero=\"1\" nome=\"Albertina Jorge de Alpoim e Osório de Valdoleiros\" genero=\"F\" nascido=\"1990-04-08\"/>"+
			    					"<aluno numero=\"3\" nome=\"Sarah Ledesma Barrisco\" genero=\"F\" nascido=\"1998-01-06\"/>";
			            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
			            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			            System.out.println(jsonPrettyPrintString);
			        } catch (JSONException je) {
			            System.out.println(je.toString());
			        }
					  break;
			case '7': 
					  String line = "\"1234567890\",\"James\",man,\"New York, NY, USA\"";
					  System.out.println("Original: "+line);
					  String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					  System.out.println();
					  Arrays.stream(tokens).forEach(System.out::println);
					  System.out.println();
			case '0':
				break;
			default:
				Consola.writeLine("Opção inválida. Tente outra vez.");
			}
		} while (op != '0');
		Consola.writeLine("Terminou a execução do Gerador de Dados.");
	}

}