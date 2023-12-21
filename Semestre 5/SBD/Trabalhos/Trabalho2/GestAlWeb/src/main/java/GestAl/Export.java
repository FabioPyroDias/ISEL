package GestAl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Exporta a tabela considerando o formato 'sql', 'csv', 'xml' ou 'json
 */
@WebServlet("/Export")
public class Export extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* Processa as antidades XML
	 * quot	"	U+0022 (34)	XML 1.0	quotation mark
	   amp	&	U+0026 (38)	XML 1.0	ampersand
	   apos	'	U+0027 (39)	XML 1.0	apostrophe (1.0: apostrophe-quote)
	   lt	<	U+003C (60)	XML 1.0	less-than sign
	   gt	>	U+003E (62)	XML 1.0	greater-than sign
	 */
	private String xmlEntities(String xml) {
		xml=xml.replaceAll("\"","&quot;");
		xml=xml.replaceAll("&","&amp;");
		xml=xml.replaceAll("'","&apos;");
		xml=xml.replaceAll("<","&lt;");
		return xml.replaceAll(">","&gt;");
	}
	
	// https://docs.fileformat.com/spreadsheet/csv/
	// Each field may or may not be enclosed in double quotes (however some programs, such as Microsoft Excel, do not use double quotes at all).  
	// If fields are not enclosed with double quotes, then double quotes may not appear inside the fields. 
	/* Fields containing line breaks (CRLF), double quotes, and commas should be enclosed in double-quotes.  
	   For example:
			"aaa","b CRLF
			bb","ccc" CRLF
			zzz,yyy,xxx
	If double-quotes are used to enclose fields, then a double-quote appearing inside a field must be escaped by preceding it with another double quote.  
	For example:
			"aaa","b""bb","ccc"
	*/
	private String csvEscape(String csv) {
		csv=csv.replaceAll("\"","\"\"");
		return "\""+csv+"\"";
	}
	
	// concretiza o processo de exportação de todas as tabelas para todos os formatos: SQL, CSV, XML e JSON
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain; charset=UTF-8");
		Manipula dados = new Manipula();
		String formato=request.getParameter("Formato");  // SQL, CSV, XML ou JSON
		String tabela=request.getParameter("Tabela");
		if(tabela!=null && formato!=null)
			try {
				String select="SELECT * FROM " + tabela+" ORDER BY 1,2";
				if(tabela.compareToIgnoreCase("foto")==0)
					select = "SELECT numero,REPLACE(to_base64(conteudo),'\\n','') as conteudo FROM foto order by numero";
				ResultSet rs = dados.getResultado(select);
				int rowCount = rs.last() ? rs.getRow() : 0;
				System.out.println("Linhas: "+rowCount);
				if(rowCount>0) {
					rs.beforeFirst();
					ResultSetMetaData rsmd = rs.getMetaData();
					int colCount = rsmd.getColumnCount();
					//int dimcols[] = new int[colCount];
					//int typecols[] = new int[colCount];
					//String typenames[] = new String[colCount];
					String colNames = "";
					for (int i = 0; i < colCount; i++) 
						//String aux = rsmd.getColumnLabel(i + 1);
						//dimcols[i] = rsmd.getColumnDisplaySize(i + 1);
						//typecols[i] = rsmd.getColumnType(i + 1);
						//typenames[i] = rsmd.getColumnTypeName(i + 1);
						colNames = colNames + rsmd.getColumnLabel(i + 1) + ", ";
					colNames = colNames.substring(0, colNames.length() - 2);
					if(formato.compareToIgnoreCase("CSV")==0)
						out.println(colNames);
					if(formato.compareToIgnoreCase("XML")==0)
						out.println("<?xml version = \"1.0\" encoding = \"utf-8\"?>\n<"+tabela+"s>");
					if(formato.compareToIgnoreCase("JSON")==0)
						out.println("{\""+tabela+"\": [");
					while (rs.next()) {
						String Linha = "";
						if(formato.compareToIgnoreCase("SQL")==0)
							Linha = "INSERT INTO " + tabela + " (" + colNames + ") VALUES (";
						if(formato.compareToIgnoreCase("XML")==0)
							Linha = "\t<"+tabela;
						if(formato.compareToIgnoreCase("JSON")==0)
							Linha = "{\n";
						for (int i = 1; i <= colCount; i++) {
							String item = "NULL";
							if(rs.getObject(i)!=null) {
								if(formato.compareToIgnoreCase("CSV")==0) 			
									item=csvEscape(rs.getString(i));			// processa os carateres especiais
								else if(formato.compareToIgnoreCase("SQL")==0) 		
										if(tabela.compareToIgnoreCase("foto")==0 && i==2)
											item = "from_base64('"+rs.getString(i)+"')";
										else									// duplica apostrofes no insert
											item = Configura.fmTipo(rs.getString(i).replaceAll("'","''"), 
													rsmd.getColumnType(i));
								else if(formato.compareToIgnoreCase("XML")==0) 		// susbtitui as entidades, caso existam
									item=" "+rsmd.getColumnLabel(i)+"=\""+xmlEntities(rs.getString(i))+"\"";
								else if(formato.compareToIgnoreCase("JSON")==0) 	// considera todos os valores como string
									item="\t\""+rsmd.getColumnLabel(i)+"\":\""+
												rs.getString(i).replaceAll("\"","\\\\\"")+"\"";
							} else 
								if(formato.compareToIgnoreCase("XML")==0||formato.compareToIgnoreCase("JSON")==0)
									item="";
							Linha = Linha + item;
							if(formato.compareToIgnoreCase("SQL")==0 || formato.compareToIgnoreCase("CSV")==0)
									Linha = Linha+ ", ";
							if(formato.compareToIgnoreCase("JSON")==0)
									Linha = Linha+ ",\n";	
						}
						if(formato.compareToIgnoreCase("XML")!=0)
							Linha = Linha.substring(0, Linha.length() - 2);
						if(formato.compareToIgnoreCase("SQL")==0)
							Linha=Linha + ");";
						if(formato.compareToIgnoreCase("XML")==0)
							Linha = Linha+"/>";
						if(formato.compareToIgnoreCase("JSON")==0)
							Linha = Linha+"},";
						out.println(Linha);
					}
					if(formato.compareToIgnoreCase("XML")==0)
						out.println("</"+tabela+"s>");
					if(formato.compareToIgnoreCase("JSON")==0)
						out.println("]}");
				}
			} catch (SQLException e) {
				System.err.println("Ocorreu erro na exportação...");
				System.err.println("Ver detalhes abaixo:\r\n");
				e.printStackTrace();
				System.err.println("-----SQLException-----");
				System.err.println("SQLState:  " + e.getSQLState());
				System.err.println("Message:  " + e.getMessage());
				System.err.println("Vendor:  " + e.getErrorCode());
			}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
