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
 * Devolve a lista de anos associados a inscrições (sem nota) 
 */
@WebServlet("/getAnos")
public class getAnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getAnos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manipula dados = new Manipula( new Configura());
		String numero=request.getParameter("Numero");
		String codigo=request.getParameter("Codigo");
		String designacao=request.getParameter("Designacao");
		if(designacao!=null) {
			try {
				codigo=dados.getVObject("SELECT CODIGO FROM DISCIPLINA WHERE DESIGNACAO='"+designacao+"'").toString();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(codigo==null || codigo.compareTo("")==0 || numero==null || numero.compareTo("")==0)
			return;
		ResultSet rs = dados.getResultado("SELECT DISTINCT ANO FROM INSCRICAO WHERE CODIGO='"+codigo
												+"' AND NUMERO="+numero+" AND NOTA IS NULL ORDER BY ANO");
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
