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
 * Servlet implementation class getYears
 * Devolve a lista de anos associados ao código da disciplina passado em parametro
 */
@WebServlet("/getYears")
public class getYears extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getYears() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo=request.getParameter("Codigo");
		if(codigo==null || codigo.compareTo("")==0)
			return;
		Manipula dados = new Manipula( new Configura());
		ResultSet rs = dados.getResultado("SELECT DISTINCT ANO FROM INSCRICAO WHERE CODIGO='"+codigo+"' AND NOTA IS NULL ORDER BY ANO");
		String data="";
		try {
			while (rs!=null && rs.next()) 
				data+="<option value='"+rs.getString("ANO")+"'/>";
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
