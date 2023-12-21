package GestAl;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
/*
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FotoAlunoDown
 */
@WebServlet("/FotoDown")
public class FotoAlunoDown extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FotoAlunoDown() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		byte[] buffer = null;
		String numero = request.getParameter("numero");
		if (numero == null || numero.compareToIgnoreCase("")==0) 
			System.out.println("Número do estudante inválido!");
		else {
			System.out.println("Foto do estudante Nº " + numero+"!");
			buffer = Gestor.getFoto(Integer.valueOf(numero));
		}
		if(buffer==null) {
			String fich = getServletContext().getRealPath("/")+"/"+Foto.omissa;
			System.out.println("Foto por omissão: "+fich);
			// System.out.println("default"+fich);
			buffer = Files.readAllBytes(Paths.get(fich));
		}
		if(buffer!=null && buffer.length>0) {
			//response.setHeader("expires", "0");
			//response.setContentType("image/jpg");
			OutputStream o = response.getOutputStream();
			o.write(buffer);
			o.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
