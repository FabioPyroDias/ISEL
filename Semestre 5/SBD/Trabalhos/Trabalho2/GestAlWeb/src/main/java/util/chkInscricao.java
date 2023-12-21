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
 * Devolve mensagem relativa à inscrição a 'duplicada' 
 */
@WebServlet("/chkInscricao")
public class chkInscricao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public chkInscricao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numero=request.getParameter("Numero");
		String codigo=request.getParameter("Codigo");
		String ano=request.getParameter("Ano");
		if(numero==null || numero.compareTo("")==0 || codigo==null || codigo.compareTo("")==0 || ano==null || ano.compareTo("")==0)
			return;
		System.out.println("Inscrição do Nº: "+numero);
		Manipula dados = new Manipula( new Configura());
		String diretiva="SELECT * FROM INSCRICAO WHERE NUMERO="+numero+" AND CODIGO='"+codigo+"' AND ANO="+ano;
		System.out.println(diretiva);
		ResultSet rs = dados.getResultado(diretiva);
		String msg="";
		try {
			if (rs!=null && rs.next()) {
				System.out.println("Inscrição duplicada!");
				msg = "A inscrição já existe!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.toString());
		} 
		dados.desligar();
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println(msg);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
