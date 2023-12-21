package GestAl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Importa dados das tabelas nos formatos 'sql', 'csv', 'xml' e json 
 * em conformidade com a extensão do ficheiro
 *
 */
@WebServlet("/Import")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 100,  		// 100 MB
		maxFileSize = 1024 * 1024 * 500, 				// 500 MB
		maxRequestSize = 1024 * 1024 * 500) 			// 500 MB
public class Import extends HttpServlet {
	private static final long serialVersionUID = 1L;     
      // executa as instruções insert que estão no ficheiro no formato SQL
    private boolean doSQL(InputStream in, PrintWriter out, Manipula dados) throws IOException {
    	BufferedReader input = new BufferedReader(new InputStreamReader(in));
    	String insert=null;
		while ((insert = input.readLine()) != null) {	// avançar no ficheiro linha/insert a linha/insert,
		   if(dados.xDirectiva(insert))  				// executa diretamente o insert					 
			   out.println("Executou: "+insert.substring(1,(insert.length()>120)?120:insert.length())+"...<br>");
		   else
		       out.println("Saltou: "+insert.substring(1,(insert.length()>120)?120:insert.length())+"...<br>");	// se falhar não pára
	     } 
		input.close();
		return true;
    }
    
    // gera a partir do ficheiro no formato json as instruções insert e executa-as
    private boolean doJSON(InputStream in, PrintWriter out, Manipula dados, String tabela) throws IOException {
    	ResultSet rs = dados.getResultado("SELECT * FROM " + tabela);
	   	ResultSetMetaData rsmd;
    	int colCount=0;
		try {
			rsmd = rs.getMetaData();
			colCount=rsmd.getColumnCount();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		try {
			JSONTokener tokener = new JSONTokener(in);
	        JSONObject object = new JSONObject(tokener);
	        JSONArray linhas = object.getJSONArray(tabela); 
	        for(int i=0; i<linhas.length(); i++) {
	        	JSONObject linha = (JSONObject)linhas.get(i);
	            String insert="INSERT INTO "+tabela;
	    		String values="";
	    		String atrs="";
	        	for(int j=0; j<colCount; j++) {
	        		String name = "";
	        		String item = null;
	        		try {
	        			item = linha.getString(rsmd.getColumnLabel(j + 1)).replaceAll("'","''");
	        		} catch (JSONException e) {
	        			// se falhar não é para fazer nada
	        		}
					if(item!=null && item.length()!=0) {
						name = rsmd.getColumnLabel(j + 1);
						//System.out.println(name+": " + item);
						if(tabela.compareToIgnoreCase("foto")==0 && name.compareToIgnoreCase("conteudo")==0)
							item = "from_base64('"+item+"')";
						else
							item = Configura.fmTipo(item, rsmd.getColumnType(j+1));
						values=values+item+", ";
						atrs=atrs+name+", ";
					}
    			}
	        	atrs = atrs.substring(0, atrs.length() - 2);
	        	values = values.substring(0, values.length() - 2);
	        	insert = insert+" ("+atrs+") VALUES ("+values+")";
	    		if(dados.xDirectiva(insert))  					 
				   out.println("Executou: "+insert.substring(0,(insert.length()>120)?120:insert.length())+"...<br>");
			    else
			       out.println("Saltou: "+insert.substring(0,(insert.length()>120)?120:insert.length())+"...<br>");	// se falhar não pára 
	        }
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		in.close();
		return true;
    }
    
    // gera a partir do ficheiro no formato xml as instruções insert e executa-as
    private boolean doXML(InputStream is, PrintWriter out, Manipula dados, String tabela) throws IOException{
    	ResultSet rs = dados.getResultado("SELECT * FROM " + tabela);
		String colNames="";
    	ResultSetMetaData rsmd;
    	int colCount=0;
		try {
			rsmd = rs.getMetaData();
			colCount=rsmd.getColumnCount();
			for(int i=0; i<colCount; i++)
				colNames=colNames+rsmd.getColumnLabel(i + 1)+", ";
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		colNames = colNames.substring(0, colNames.length() - 2);
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(false);
        dbf.setValidating(false);
        dbf.setIgnoringComments(false);
        dbf.setIgnoringElementContentWhitespace(true);
        Document doc;
		try {
			doc = dbf.newDocumentBuilder().parse(is);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
			return false;
		}
        NodeList lines=doc.getElementsByTagName(tabela);
    	for(int i=0; i<lines.getLength(); i++) {
            String insert="INSERT INTO "+tabela;
    		NamedNodeMap cols = lines.item(i).getAttributes();
    		String values="";
    		String atrs="";
    		for(int j=0; j<colCount; j++) 
    			try {
    				String name="";
    				if(cols.getNamedItem(rsmd.getColumnLabel(j + 1))==null)
    					continue;
    				String item = cols.getNamedItem(rsmd.getColumnLabel(j + 1)).getNodeValue();
   					if(item!=null && item.length()!=0) {
						if((rsmd.getColumnLabel(j+1).compareToIgnoreCase("conteudo")==0) && (tabela.compareToIgnoreCase("foto")==0))
							item = "from_base64('"+item+"')";
						else
							item = Configura.fmTipo(item.replaceAll("'","''"), rsmd.getColumnType(j+1));
						name = rsmd.getColumnLabel(j + 1);
		    			values=values+item+", ";
		    			atrs=atrs+name+", ";
    				}
				} catch (DOMException | SQLException e) {
					e.printStackTrace();
					return false;
				}
    		values = values.substring(0, values.length() - 2);
    		atrs = atrs.substring(0, atrs.length() - 2);
    		insert = insert+" ("+atrs+") VALUES ("+values+")";
    		if(dados.xDirectiva(insert))  					 
 			   out.println("Executou: "+insert.substring(0,(insert.length()>120)?120:insert.length())+"...<br>");
 		    else
 		       out.println("Saltou: "+insert.substring(0,(insert.length()>120)?120:insert.length())+"...<br>");	// se falhar não pára 
    	}
		is.close();
		return true;
    }
    
    // gera a partir do ficheiro no formato csv as instruções insert e executa-as
    private boolean doCSV(InputStream in, PrintWriter out, Manipula dados, String tabela) throws IOException {
    	BufferedReader input = new BufferedReader(new InputStreamReader(in));
    	String line=null;
    	String colNames=input.readLine();
    	ResultSet rs = dados.getResultado("SELECT "+colNames+" FROM " + tabela);
    	ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			while ((line = input.readLine()) != null) { 			// avançar no ficheiro linha a linha
				String[] arrOfStr = line.split(", ");
				String values="";
				for(int i=0;i<arrOfStr.length; i++) {
					String item=arrOfStr[i];
					if((rsmd.getColumnLabel(i + 1).compareToIgnoreCase("conteudo")==0) && (tabela.compareToIgnoreCase("foto")==0))
						values=values+"from_base64('"+item.substring(1,item.length()-1)+"')"+ ", ";
					else {
						if((item.length()!=0)  && (item.compareToIgnoreCase("NULL")!=0)) {
							item=item.trim().replaceAll("\"\"", "\"");	// substitui "" por "
							item=item.substring(1,item.length());  		// remove " no inicio
							item=item.substring(0,item.length()-1);  	// remove " no fim 
						}	
					   values=values+Configura.fmTipo(item.replaceAll("'","''"), rsmd.getColumnType(i + 1))+ ", ";
					}
				}
	    		values = values.substring(0, values.length() - 2);
				String insert="INSERT INTO "+tabela+" ("+colNames+") VALUES ("+values+")";
				if(dados.xDirectiva(insert))  		
					out.println("Executou: "+insert.substring(0,(insert.length()>120)?120:insert.length())+"...<br>");
				else
					out.println("Saltou: "+insert.substring(0,(insert.length()>120)?120:insert.length())+"...<br>"); // se falhar não pára
			}
		} catch (SQLException e) {
			e.printStackTrace();
			input.close();
			return false;
		}
		input.close();
		return true;
    }
    // processa a importação do ficheiro e gerando instruções insert
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("fileInput");
		if (filePart != null && filePart.getSize() > 0) {			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=ISO-8859-1");
			// prints out some information for debugging
			System.out.println("Parametro: " + filePart.getName());
			System.out.println("Ficheiro: " + filePart.getSubmittedFileName());
			System.out.println("Dimensão: " + filePart.getSize());
			System.out.println("Tipo: " + filePart.getContentType());
			out.println("Ficheiro: '" + filePart.getSubmittedFileName()+"'<br>");
			out.println("Dimensão: " + filePart.getSize()/1024+" KB<br>");
			// destinguir a extensão
			String fname=filePart.getSubmittedFileName().toLowerCase();
			String tabela=fname.substring(0, fname.lastIndexOf("."));
			String ext = fname.substring(fname.lastIndexOf(".") + 1).toLowerCase();
			out.println("Processa conforme a extensão ("+ext+")!");
			out.println("<br>");
			Manipula dados = new Manipula(new Configura());
			Connection con = dados.getLigacao();
			try {
				con.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
				out.println(e.getMessage()+"<br>");
			}
			// obtains input stream of the upload file			
			boolean ok=false;
			InputStream input=filePart.getInputStream();
			 if(ext.compareTo("sql")==0) 
				 ok=doSQL(input, out, dados);
			 else if(ext.compareTo("xml")==0) 
				 ok=doXML(input, out, dados,tabela);
			 else if(ext.compareTo("json")==0) 
				 ok=doJSON(input, out, dados,tabela);
			 else if(ext.compareTo("csv")==0) 
				 ok=doCSV(input, out, dados,tabela);
			 else 
				 out.println("Tipo de ficheiro inválido!");
			try {
				if (ok) {
					con.commit();
					out.println("Carregamento do ficheiro '" + filePart.getSubmittedFileName() + "' realizado com sucesso! "
							+ "<br>");
				} else {
					out.println("Falhou o carregamento do ficheiro '" + filePart.getSubmittedFileName() + "'! " + "<br>");
					con.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				out.println(e.getMessage() + "<br>");
			}
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
				out.println(e.getMessage() + "<br>");
			}
		 out.println("<br><a href='javascript:window.history.back()'>Voltar</a>");
		 input.close();
		 out.close();
	     dados.desligar();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
