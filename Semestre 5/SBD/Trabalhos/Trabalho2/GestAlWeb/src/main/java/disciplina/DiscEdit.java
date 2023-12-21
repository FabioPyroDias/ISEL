package disciplina;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DiscEdit")
public class DiscEdit extends HttpServlet {

	private static final long serialVersionUID = -4617797030215810878L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Disc d = new Disc();
		d.setCodigo(request.getParameter("Codigo"));
		d.setDesignacao(request.getParameter("Designacao"));
		d.print();
		Disc o = new Disc();
		o.setCodigo(request.getParameter("CodigoOld"));
		o.setDesignacao(request.getParameter("DesignacaoOld"));
		o.print();
		if (DiscDao.update(d, o) !=1){
			out.println("<h2>Sorry! Unable to update record...</h2>");
			request.getRequestDispatcher("Disc.jsp?Codigo="+o.getCodigo()+"&Designacao="+o.getDesignacao()).include(request, response);
		} else
			response.sendRedirect("Disc.jsp?parent=true");  //"viewDisc.jsp" 

		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
