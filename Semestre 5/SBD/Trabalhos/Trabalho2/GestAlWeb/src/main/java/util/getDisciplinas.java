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
import GestAl.Manipula;

/**
 * Devolve a lista das disciplinas com inscrições (sem nota)  
 */
@WebServlet("/getDisciplinas")
public class getDisciplinas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getDisciplinas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numero=request.getParameter("Numero");
		if(numero==null || numero.compareTo("")==0)
			return;
		System.out.println("numero: "+numero);
		Manipula dados = new Manipula( new Configura());
		ResultSet rs = dados.getResultado("SELECT DISTINCT DESIGNACAO FROM INSCRICAO I, DISCIPLINA D"+
											" WHERE I.CODIGO=D.CODIGO AND NUMERO="+numero+" AND NOTA IS NULL ORDER BY 1");
		String data="";
		try {
			while (rs!=null && rs.next()) 
				data+="<option value='"+rs.getString(1)+"'/>";
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.toString());
		} 
		dados.desligar();
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println(data);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
