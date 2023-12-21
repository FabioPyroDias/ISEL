package util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

import GestAl.Configura;
import GestAl.Manipula;

/**
 * Apresenta lista de propriedades do sistema
 */
@WebServlet("/getProperties")
public class getProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getProperties() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Printing all System properties");
		response.setContentType("text/plain; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("\n"
				+ "Developed with:\n"
				+ "Eclipse IDE for Enterprise Java and Web Developers\n"
				+ "(includes Incubating components)\n"
				+ "Version: 2022-09 (4.25.0)\n"
				+ "Build id: 20220908-1902\n\n");
		out.println("Served at:"+request.getContextPath());

		/*
		 * To get system properties use, static Properties getProperties() of System
		 * class.
		 * 
		 * getProperties is a static method.
		 * 
		 * Plase note that these properties are environment specific.
		 */

		Properties prop = System.getProperties();

		/*
		 * To print all system properties use static void list(PrintStream ps) method of
		 * System class.
		 * 
		 * Hint : To print properties on console, paas System.out to list method.
		 */

		prop.list(out);
		out.println();
		out.println("Tomcat Version=" + getServletContext().getServerInfo());
		out.println("Servlet Specification Version=" + getServletContext().getMajorVersion() + "."
				+ getServletContext().getMinorVersion());
		out.println("JSP version=" + JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion());
		out.println();
		Manipula dados = new Manipula(new Configura());
		Connection con = dados.getLigacao();
		DatabaseMetaData meta;
		try {
			meta = con.getMetaData();
			out.println("MySQL Version=" + meta.getDatabaseProductVersion());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dados.desligar();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
