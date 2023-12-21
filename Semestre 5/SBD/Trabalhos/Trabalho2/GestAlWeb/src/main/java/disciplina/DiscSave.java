package disciplina;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DiscSave")
public class DiscSave extends HttpServlet {

	private static final long serialVersionUID = 1156573442522918800L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Disc d = new Disc();
		d.setCodigo(request.getParameter("Codigo"));
		d.setDesignacao(request.getParameter("Designacao"));
		
		if (DiscDao.save(d) > 0)
			out.print("<script>alert('Record saved successfully!');</script>");
		else 
			out.println("<h2>Sorry! Unable to save record...</h2>");
		
		request.getRequestDispatcher("Disc.jsp").include(request, response);

		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
