package GestAl;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/AlunoUp")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 10,  			// 10 MB
		maxFileSize = 1024 * 1024 * 50, 				// 50 MB
		maxRequestSize = 1024 * 1024 * 100) 			// 100 MB
public class FotoAlunoUpload extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// se correr bem devolve o numero senão devolve null
	private String AtualizaAluno(HttpServletRequest request, Manipula dados) throws SQLException {
		String comando=request.getParameter("Comando");
		if(comando==null) 
			return null;
		String numero=request.getParameter("Numero");
		String nome=request.getParameter("Nome");
		String genero=request.getParameter("Genero");
		String nascido=request.getParameter("Data");
		String nm=numero;
		if(comando.compareTo("I")==0){
			if(nm==null || nm.compareTo("")==0)
				nm=dados.getVString("select coalesce(max(numero), 0)+1 from aluno");
			else
				nm=Consola.Valor(numero);
			String directiva = 
			"insert into aluno (numero, nome, genero, nascido) values ("+
					nm +",'"+ 
					nome.trim().replaceAll("'", "''") +"','" + 
					genero + "','" + 
					nascido + "')";			
			System.out.println("Insere: "+directiva);
			if (dados.xDirectiva(directiva))
				return nm;
		} else // fim do insert

		if(comando.compareTo("U")==0){ 
			// verifica antes de fazer a actualização se o registo se mantém, reforçando o WHERE
			String numeroOld=request.getParameter("NumeroOld");
			String nomeOld=request.getParameter("NomeOld");
			String generoOld=request.getParameter("GeneroOld");
			String nascidoOld=request.getParameter("DataOld");
 			nome=nome.trim().replaceAll("'", "''");
			nomeOld=nomeOld.replaceAll("'", "''");
			String directiva = "update aluno set "
					+ "numero="+numero+", " 
					+ "nome='"+nome+"', "
				    + "genero='"+genero+"', "
				    + "nascido='"+nascido+"'"
					+ " where "
					+ Consola.IgualV("numero", numeroOld)+" AND " 
					+ Consola.IgualS("nome", nomeOld)+" AND "
				    + Consola.IgualS("genero", generoOld)+" AND "
				    + Consola.IgualS("nascido", nascidoOld);
			System.out.println("Atualiza: "+directiva);
			if (dados.xDirectiva(directiva))
				return nm;
		}  // fim da alteração
		
		return null;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	 {
		/*for (Part p : request.getParts()) {
			System.out.println("Part name: " + p.getName());
			System.out.println("Size: " + p.getSize());
			System.out.println("Content Type: " + p.getContentType());
			System.out.println("Header Names:");
			for (String name : p.getHeaderNames()) 
				System.out.println(" " + name);
			System.out.println("______________________");
		}*/
		String num=null;
		String msg=null;
		String comando=request.getParameter("Comando");
		// procura por foto semelhanye
		if(comando!=null && comando.compareTo("K")==0) {
			Manipula dados = new Manipula(new Configura());
			String FotoBase64 = request.getParameter("FotoBase64");
			String numero=request.getParameter("Numero");
			if(FotoBase64==null || FotoBase64.length()==0) {
				if(numero!=null && numero.compareTo("")!=0) {
					FotoBase64=Gestor.getFoto64(Integer.parseInt(numero));
					System.out.println("Foi buscar a fotografia à base de dados! "+FotoBase64.substring(0,20));
				} 
			} else {
				FotoBase64=FotoBase64.substring(FotoBase64.indexOf(',')+1);
				System.out.println("Utilizou a foto passada em parametro! "+FotoBase64.substring(0,20));
			}
			if(FotoBase64==null || FotoBase64.length()<=0) {
				msg="Nada para fazer!";
			} else {
				if(numero==null || numero.length()==0) {
					numero="0";
				}
				// vai percorrer as fotos e faz a comparação
				ResultSet rs = dados.getResultado("SELECT * FROM ("+
						"SELECT NUMERO, 1 FROM FOTO WHERE NUMERO > "+numero+
						" UNION"+
						" SELECT NUMERO, 2 FROM FOTO WHERE NUMERO < "+numero+") T ORDER BY 2");
				int rowCount=0;
				try {
					rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;	
					if(rowCount>0) {
						rs.beforeFirst();
						while (rs.next()) {
							int nm=rs.getInt("NUMERO");
							String Foto = Gestor.getFoto64(nm);
							if(Foto.compareToIgnoreCase(FotoBase64)==0) {
								num=String.valueOf(nm);
								msg="Foi encontrada a fotografia do estudante número "+num+"!";
								rowCount=0;
								break;
							}
						}
						if(rowCount!=0)
							msg="Não encontrou a fotografia!";
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			dados.desligar();
		}
		
		if(comando!=null && (comando.compareTo("I")==0 || comando.compareTo("U")==0) ) {
			num = request.getParameter("Numero");
			if ((num == null || num.compareTo("") == 0) && comando.compareTo("U")==0)
				System.out.println("Número do Aluno inválido!");
			else {
				Manipula dados = new Manipula(new Configura());
				boolean status=false;
				try {
					dados.getLigacao().setAutoCommit(false); // inicia transação
					num=AtualizaAluno(request, dados);
					status=num!=null;
					if(status) {
						String FotoBase64 = request.getParameter("FotoBase64");
						if(FotoBase64!=null && FotoBase64.length()>0) {
							// remove a indicação de tipo base64
							FotoBase64=FotoBase64.substring(FotoBase64.indexOf(',')+1);
							status=Gestor.setFoto64(FotoBase64, new BigDecimal(num),dados);
						} else {	
							Part filePart = request.getPart("fotoInput");
							if (filePart != null && filePart.getSize() != 0) {
								// prints out some information for debugging
								System.out.println("Parametro:" + filePart.getName());
								System.out.println("Ficheiro:" + filePart.getSubmittedFileName());
								System.out.println("Dimensão:" + filePart.getSize());
								System.out.println("Tipo:" + filePart.getContentType());
								// obtains input stream of the upload file
								InputStream input = filePart.getInputStream();
								status=Gestor.setFoto(input, new BigDecimal(num),dados);
								input.close(); // fecha o stream de leitura
								}
							}
					}
					if(status) {
						dados.getLigacao().commit();
						System.out.println("Aluno/Foto "+(num==null?"":"nº"+num)+" Sucesso!");
						msg="O registo do aluno foi atualizado/criado com sucesso!";
					}
					else {
						System.out.println("Aluno/Foto nº"+(num==null?"":"nº"+num)+" InSucesso!");
						msg="A atualização/criação do registo do aluno falhou...!";
						dados.getLigacao().rollback();
					}
					dados.getLigacao().setAutoCommit(true);
					dados.desligar();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		request.setAttribute("numero",num);
		request.setAttribute("mensagem",msg);
		request.getRequestDispatcher("Aluno.jsp").include(request, response);	
	}
}