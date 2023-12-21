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
 * Devolve os dados do aluno em forma de texto 
 */
@WebServlet("/getAluno")
public class getAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getAluno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numero=request.getParameter("Numero");
		if(numero==null || numero.compareTo("")==0)
			return;
		System.out.println("numero: "+numero);
		Manipula dados = new Manipula( new Configura());
		ResultSet rs = dados.getResultado("SELECT NASCIDO, NOME FROM ALUNO WHERE NUMERO="+numero);
		String nascido=null;
		String nome=null;
		try {
			if (rs!=null && rs.next()) {
				nascido=rs.getString("nascido");
				nome=rs.getString("nome");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.toString());
		} 
		dados.desligar();
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		if(nascido!=null) {
			String[] result = GestAl.Data.saber(nascido).split(",");
		    out.println(Consola.proper(nome)+". "+result[0]+","+result[1]+","+result[2]+result[4]);
		}
		else
			out.println("O estudante não foi encontrado!");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
