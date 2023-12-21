package disciplina;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DiscDelete")
public class DiscDelete extends HttpServlet {

	private static final long serialVersionUID = 2173812416937754960L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Disc d = new Disc();
		d.setCodigo(request.getParameter("Codigo"));
		d.setDesignacao(request.getParameter("Designacao"));
		if (DiscDao.delete(d) != 1){
			out.println("<h2>Sorry! Unable to update record...</h2>");
			request.getRequestDispatcher("Disc.jsp?Codigo="+d.getCodigo()+"&Designacao="+d.getDesignacao()).include(request, response);
		} else
			response.sendRedirect("Disc.jsp?parent=true"); 
		
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
