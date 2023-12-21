package util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import GestAl.Configura;
import GestAl.Consola;
import GestAl.Manipula;

/**
 * Verifica se já existe algum nome semelhante possivelmente duplicado 
 */
@WebServlet("/chkNome")
public class chkNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public chkNome() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numero=request.getParameter("Numero");
		String nome=request.getParameter("Nome");
		String msg="?";
		if(numero!=null && numero.length()!=0 && nome!=null && nome.length()!=0) {
			System.out.println("numero: "+numero);
			System.out.println("nome: "+nome);
			Manipula dados = new Manipula( new Configura());
			ResultSet rs = dados.getResultado("SELECT * FROM ("+
					" SELECT NUMERO, NOME, 1 FROM ALUNO WHERE NUMERO > "+numero+
					" UNION"+
					" SELECT NUMERO, NOME, 2 FROM ALUNO WHERE NUMERO < "+numero+") T ORDER BY 3");
			try {	
				if(((rs!=null && rs.last()) ? rs.getRow() : 0)>0) {
					int melhor=0;
					String nomeMelhor="";
					String numeroMelhor="";
					rs.beforeFirst();
					while (rs.next()) {
						int par=(int)Consola.StringSimilarity.similarity(rs.getString("nome"), nome);
						if(par>melhor) {// pode ser maior que determinado valor percentual
							melhor=par;
							numeroMelhor=rs.getString("numero");
							nomeMelhor=rs.getString("nome");
						}
					}
					if(melhor>0.1)
						msg=melhor*100+"% parecido com '"+nomeMelhor+"', estudante nº "+numeroMelhor+"!";
					if(melhor>0)
						System.out.println(msg);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dados.desligar();
		}
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
