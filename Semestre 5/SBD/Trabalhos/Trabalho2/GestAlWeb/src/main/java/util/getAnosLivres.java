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
import GestAl.Manipula;

/**
 * Servlet implementation class getYears
 * Devolve a lista de anos associados ao código da disciplina que ainda não têm inscriçoes no intervalo indicado
 */
@WebServlet("/getAnosLivres")
public class getAnosLivres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String min=request.getParameter("Min");
		String max=request.getParameter("Max");
		String numero=request.getParameter("Numero");
		String codigo=request.getParameter("Codigo");
		if(min==null || min.compareTo("")==0 || max==null || max.compareTo("")==0)
			return;
		if(numero==null || numero.compareTo("")==0 || codigo==null || codigo.compareTo("")==0)
			return;
		Manipula dados = new Manipula();
		String diretiva="SELECT ANO FROM INSCRICAO WHERE NUMERO="+numero+" AND CODIGO='"+codigo+"' ORDER BY 1";
		System.out.println(diretiva);
		ResultSet rs = dados.getResultado(diretiva);
		String data="";
		try {
			int anoMin=Integer.parseInt(min);
			int anoMax=Integer.parseInt(max);
			while (rs!=null && rs.next()) {
				int anoIns=rs.getInt("ANO");
				for(int i=anoMin; i<anoIns; i++)
					data+="<option value='"+i+"'/>";
				anoMin=anoIns+1;
			}
			for(int i=anoMin; i<=anoMax; i++)
				data+="<option value='"+i+"'/>";
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
