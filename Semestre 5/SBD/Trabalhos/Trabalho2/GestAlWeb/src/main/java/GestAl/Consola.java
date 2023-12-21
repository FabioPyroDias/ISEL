package GestAl;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import jakarta.servlet.jsp.JspWriter;

/*
 * Implementa funcionalidades de acesso à consola
 */ 

/**
 * Encapsula o acesso ao ecrã consola ou browser
 * 
 * @author Eng Porfírio Filipe
 */
final public class Consola {

	private static BufferedReader br = null;

	final static private String inFormat = "dd/MM/yyyy";

	static private SimpleDateFormat inFormatar = new SimpleDateFormat(inFormat);

	final static private String outFormat = "EEE dd MMM yyyy";
	
	private static String file = null;  //ficheiro de esrita por omissão
	
	private static  PrintWriter streamOut = null;  //stream de esrita por omissão
	
	// private static JspWriter streamOut = null;
	
	static private SimpleDateFormat outFormatar = new SimpleDateFormat(outFormat);
	
	static {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception exp) {
			System.err.println("Erro no acesso ao Standard Input");
		}
	}

	/**
	 * Converte um Calendário para String no formato do ecrã
	 * 
	 * @param data Calendário
	 * @return String no formato de data do ecã
	 */
	public static String CalendarToString(Calendar data) {
		return outFormatar.format(data);
	}

	/**
	 * Formata a nota do aluno
	 * 
	 * @param nota do aluno
	 * @return a nota formatada com dois digitos inteiros e dois decimais,
	 *         completando eventuais zeros à esquerda
	 */
	public static String NotaToString(BigDecimal nota) {
		NumberFormat formatter = new DecimalFormat("00.00");
		return formatter.format(nota);
	}

	/**
	 * Converte uma Data SQL para String no formato do ecrã
	 * 
	 * @param data
	 *            Data SQL
	 * @return String no formato do ecr�
	 */
	public static String DateToString(java.sql.Date data) {
		return outFormatar.format(data);
	}

	/**
	 * Retorna uma String com a dimensão 'dim' obtido por concatenação de
	 * espaços na String 'str'
	 * 
	 * @param str String original
	 * @param dim Dimensão final
	 * @param ch Character tipicamente ' '
	 * @return String com espaços
	 */
	public static String fill(String str, int dim, String ch) {
		if (str != null)
			while (dim > str.length())
				str = str + ch;
		return str;
	}
	/**
	 * Muda o path do ficheiro por omissão
	 * 
	 * @param str nome do ficheiro
	 */
	public static void setFile(String str) {
		file = str;
	}

	/**
	 * Muda o stream do output
	 * 
	 * @param p stream para escrever no output
	 */
	public static void setOut(PrintWriter p) {
		streamOut = p;
	}
	
	/**
	 * Escreve no ficheiro indicado por omissão o String str
	 * @param str Linha a escrever no ficheiro
	 */
	public static void escFile(String str) {
		if(file==null || file.length()==0)
			return;
	    PrintWriter bulksavwriter = null;
	    try {
			bulksavwriter = new PrintWriter(new BufferedWriter( new FileWriter (file, true)));
			bulksavwriter.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bulksavwriter.close();
	}
	/**
	 * Pergunta ao utilizador o ano de funcionamento da disciplina
	 * 
	 * @return o ano de funcionamento da disciplina indicado pelo utilizador
	 */

	public static Integer getCAnoDis() {
		String a = null;
		Integer ano = null;
		do {
			Consola.writeLine("Indique o ano de funcionamento da disciplina:");
			a = Consola.readLine();
			a = a.trim();
			try {
				ano = Integer.parseInt(a);
			} catch (NumberFormatException e) {
				continue;
			}
		} while (a.length() > 4 || a.length() == 0 || ano == null);
		return ano;
	}

	/**
	 * Pergunta ao utilizador o código da disciplina
	 * 
	 * @return código da disciplina indicada pelo utilizador
	 */
	public static String getCCodDis() {
		String codigo = null;
		do {
			Consola.writeLine("Indique o código da disciplina (max. 4 caracteres):");
			codigo = Consola.readLine();
			codigo = codigo.trim();
		} while (codigo.length() > 4 || codigo.length() == 0);
		return codigo;
	}

	/**
	 * Pergunta ao utilizador a designção da disciplina
	 * 
	 * @return a designação da disciplina indicada pelo utilizador
	 */
	public static String getCDsgDis() {
		String designacao = null;
		do {
			Consola.writeLine("Indique a nova designaçãoo (max. 60 caracteres):");
			designacao = Consola.readLine();
			designacao = designacao.trim();
		} while (designacao.length() > 60 || designacao.length() == 0);
		return designacao;
	}

	/**
	 * Pergunta ao utilizador o nome do aluno
	 * 
	 * @return o nome do aluno indicado pelo utilizador
	 */
	public static String getCNome() {
		String nome = null;
		do {
			Consola.writeLine("Indique o novo nome (max. 100 caracteres):");
			nome = Consola.readLine();
			nome = nome.trim();
		} while (nome.length() > 100 || nome.length() == 0);
		return nome;
	}

	/**
	 * Pergunta ao utilizador a nota do aluno.
	 * 
	 * @return a nota do aluno indicada pelo utilizador
	 */
	public static BigDecimal getCNotaDis() {
		String nt = null;
		BigDecimal nota = null;
		do {
			Consola.writeLine("Indique a nota [0.0...20.0]:");
			nt = Consola.readLine();
			nt = nt.trim();
			try {
				nota = new BigDecimal(nt);
			} catch (NumberFormatException e) {
				continue;
			}
		} while (nt.length() > 4 || nt.length() == 0 || nota == null
				|| nota.floatValue() > 20.0 || nota.floatValue() < 0.0);
		return nota;
	}

	/**
	 * Pergunta ao utilizador o número do aluno
	 * 
	 * @return Número do aluno indicado pelo utilizador
	 */

	public static Integer getCNumAl() {
		String num = null;
		Integer numero = null;
		do {
			Consola.writeLine("Indique o número do aluno (max. 5 digitos):");
			num = Consola.readLine();
			num = num.trim();
			try {
				numero = Integer.parseInt(num);
			} catch (NumberFormatException e) {
				continue;
			}
		} while (num.length() > 5 || num.length() == 0 || numero == null);
		return numero;
	}

	/**
	 * Pergunta ao utilizador o género do aluno
	 * 
	 * @return género do aluno indicado pelo utilizador
	 */

	public static String getCGenAl() {
		String genero = null;
		do {
			Consola.writeLine("Indique o género do aluno (M/F/X):");
			genero = Consola.readLine();
			if (genero != null && genero.length() == 1)
				genero = genero.substring(0, 1).toUpperCase();
		} while (genero.compareTo("M") != 0 && genero.compareTo("F") != 0 && genero.compareTo("X") != 0);
		return genero;
	}

	/**
	 * Pergunta ao utilizador a data de nascimento do aluno
	 * 
	 * @return data de nascimento do aluno indicada pelo utilizador
	 */

	public static java.sql.Date getCNascAl() {
		String nascido = null;
		java.sql.Date parsed = null;
		do {
			Consola.writeLine("Indique a data de nascimento do aluno ("
					+ Consola.getInFormato() + "):");
			nascido = Consola.readLine();
			try {
				parsed = Consola.StringToDate(nascido);
				break;
			} catch (ParseException e) {
				Consola.writeLine("O formato da data '" + nascido
						+ "' é inválido (" + Consola.getInFormato() + ")");
			}
		} while (true);
		return parsed;
	}

	/**
	 * Retorna o formato de escrita da data fornecida pelo utilizador
	 * 
	 * @return Formato de escrita da data fornecida pelo utilizador
	 */
	public static String getInFormato() {
		return inFormat;
	}

	/**
	 * Retorna o formato de escrita da data no ecrã
	 * 
	 * @return Formato de escrita da data no ecrã
	 */
	public static String getOutFormato() {
		return outFormat;
	}

	/**
	 * Lê um caracter do Standard Input convertendo-o para minuscula. Se a linha
	 * for vazia devolve o caracter espaaço
	 * 
	 * @return Caracter lido
	 */
	public static char readChar() {
		String str = Consola.readLine().toLowerCase();
		if (str.length() > 0)
			return str.charAt(0);
		return ' ';
	}

	/**
	 * L� uma linha do Standard Input
	 * 
	 * @return linha lida
	 */
	public static String readLine() {
		String line = "";
		try {
			line = br.readLine();
		} catch (Exception exp) {
			System.err
			.println("Erro na leitura de uma linha do Standard Input");
		}
		return line;
	}

	/**
	 * Converte uma String fornecida pelo utilizador para Calendário
	 * 
	 * @param data no formado fornecido pelo utilizador
	 * @return Calendário
	 * @throws ParseException
	 *             Ocorreu um erro na análise da String com a data
	 */
	public static Calendar StringToCalendar(String data) throws ParseException {
		Calendar d = Calendar.getInstance();
		d.setTime(inFormatar.parse(data));
		return d;
	}

	/**
	 * Converte uma String fornecida pelo utilizador para Data SQL
	 * 
	 * @param data String fornecida pelo utilizador
	 * @return Data SQL
	 * @throws ParseException
	 *             Ocorreu um erro na análise da String com a data
	 */
	public static java.sql.Date StringToDate(String data) throws ParseException {
		return new java.sql.Date(inFormatar.parse(data).getTime());
	}

	/**
	 * Escreve uma linha do Standard Output
	 * 
	 * @param line linha a ser escrita
	 */
	public static void writeLine(String line) {
		writeLine(line,streamOut);
	}
	
	/**
	 * Escreve uma linha no Stream do Browser
	 * 
	 * @param line linha a ser escrita
	 */
	public static void writeLine(String line, PrintWriter out) {
		if (line != null) {
			System.out.println(line);
			if(out!=null)
				out.println(line+"<br>");		
		}
	}
	
	public static String ValorD(String valor, String delimitador) {
		if(valor==null || valor.compareTo("null")==0)
			return "NULL";
		else
			return delimitador+valor+delimitador;
	}
	
	public static String ValorS(String valor) {
		return ValorD(valor,"'");
	}	
	
	public static String Valor(String valor) {
		return ValorD(valor,"");
	}
	
	public static String IgualS(String atributo, String valor) {
		if(valor==null || valor.compareTo("null")==0)
			return " "+atributo+" IS NULL";
		else
			return " "+atributo+" = '"+valor+"'";
	}
	
	public static String Like(String atributo, String valor) {
		if(valor==null || valor.compareTo("null")==0)
			return " "+atributo+" IS NULL";
		else if (valor.compareTo("")!=0)
			return " "+atributo+" like '"+valor+"'"; //'%"+valor+"%'";
		return "1=1";
	}
	
	public static String IgualV(String atributo, String valor) {
		if(valor==null || valor.compareTo("null")==0||valor.compareTo("")==0)
			return " "+atributo+" IS NULL";
		else
			return " "+atributo+" = "+valor;
	}
	
	public static String convertToTitleCaseIteratingChars(String text) {
	    if (text == null || text.isEmpty()) {
	        return text;
	    }

	    StringBuilder converted = new StringBuilder();

	    boolean convertNext = true;
	    for (char ch : text.toCharArray()) {
	        if (Character.isSpaceChar(ch)||ch=='-'||ch=='\'') {
	            convertNext = true;
	        } else if (convertNext) {
	            ch = Character.toTitleCase(ch);
	            convertNext = false;
	        } else {
	            ch = Character.toLowerCase(ch);
	        }
	        converted.append(ch);
	    }

	    return converted.toString();
	}
	
	public static String proper(String nm) {
        nm = convertToTitleCaseIteratingChars(nm);
        nm = nm.replaceAll(" Das ", " das ");
        nm = nm.replaceAll(" Dos ", " dos ");
        nm = nm.replaceAll(" Do ", " do ");
        nm = nm.replaceAll(" Da ", " da ");
        nm = nm.replaceAll(" De ", " de ");
        nm = nm.replaceAll(" D'", " d'");
        nm = nm.replaceAll(" D' ", " d' ");
        nm = nm.replaceAll(" E ", " e ");
        nm = nm.replaceAll("'S", "'s");
        nm = nm.replaceAll(" Von ", " von ");
        nm = nm.replaceAll(" Von ", " von ");
        nm = nm.replaceAll("Profirio", "Porfírio");
        nm = nm.replaceAll("Porfirio", "Porfírio");
        nm = nm.replaceAll("Acacio", "Acácio");
        nm = nm.replaceAll("Abilio", "Abílio");
        nm = nm.replaceAll("Osorio", "Osório");
        nm = nm.replaceAll("Patrao", "Patrão");
        nm = nm.replaceAll("Goncalves", "Gonçalves");
        nm = nm.replaceAll("Souza", "Sousa");
        return nm;
	}
/*
	The editDistance() function above is expected to calculate the edit distance between the two strings. 
	There are several implementations to this step, each may suit a specific scenario better. 
	The most common is the Levenshtein distance algorithm and we'll use it in our example below 
	(for very large strings, other algorithms are likely to perform better).
*/
	
public class StringSimilarity {

 /**
   * Calculates the similarity (a number within 0 and 1) between two strings.
   */
  public static double similarity(String s1, String s2) {
    String longer = s1, shorter = s2;
    if (s1.length() < s2.length()) { // longer should always have greater length
      longer = s2; shorter = s1;
    }
    int longerLength = longer.length();
    if (longerLength == 0) { return 1.0; /* both strings are zero length */ }
    /* 	If you have Apache Commons Text, you can use it to calculate the edit distance:
    	LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
    	return (longerLength - levenshteinDistance.apply(longer, shorter)) / (double) longerLength; 
    */
    return (longerLength - editDistance(longer, shorter)) / (double) longerLength;

  }

  // Example implementation of the Levenshtein Edit Distance
  // See http://rosettacode.org/wiki/Levenshtein_distance#Java
  public static int editDistance(String s1, String s2) {
    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();
    int[] costs = new int[s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
      int lastValue = i;
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0)
          costs[j] = j;
        else {
          if (j > 0) {
            int newValue = costs[j - 1];
            if (s1.charAt(i - 1) != s2.charAt(j - 1))
              newValue = Math.min(Math.min(newValue, lastValue),
                  costs[j]) + 1;
            costs[j - 1] = lastValue;
            lastValue = newValue;
          }
        }
      }
      if (i > 0)
        costs[s2.length()] = lastValue;
    }
    return costs[s2.length()];
  }

  public static void printSimilarity(String s, String t) {
    System.out.println(String.format(
      "%.3f is the similarity between \"%s\" and \"%s\"", similarity(s, t), s, t));
  }

  public static void main(String[] args) {
    printSimilarity("", "");
    printSimilarity("1234567890", "1");
    printSimilarity("1234567890", "123");
    printSimilarity("1234567890", "1234567");
    printSimilarity("1234567890", "1234567890");
    printSimilarity("1234567890", "1234567980");
    printSimilarity("47/2010", "472010");
    printSimilarity("47/2010", "472011");
    printSimilarity("47/2010", "AB.CDEF");
    printSimilarity("47/2010", "4B.CDEFG");
    printSimilarity("47/2010", "AB.CDEFG");
    printSimilarity("The quick fox jumped", "The fox jumped");
    printSimilarity("The quick fox jumped", "The fox");
    printSimilarity("kitten", "sitting");
  }
}
}
