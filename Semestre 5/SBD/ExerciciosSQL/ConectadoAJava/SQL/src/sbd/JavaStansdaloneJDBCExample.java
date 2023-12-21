package sbd;

import java.sql.*;

public class JavaStansdaloneJDBCExample {

	   static final String DB_URL = "jdbc:mysql://localhost:3306/aula";
	   static final String USER = "root";
	   static final String PASS = "diogo";
	   static final String QUERY = "SELECT numero,"
	   		+ "    nome,"
	   		+ "    genero,"
	   		+ "    nascido,"
	   		+ "    IFNULL( telemovel , '-') as telemovel,"
	   		+ "    IFNULL(email, '-') as email"
	   		+ "  FROM aula.aluno;";

	   public static void main(String[] args) {
	      // Open a connection
	      try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(QUERY);
			 // Extract data from result set
			  while (rs.next()) {
			    // Retrieve by column name
				System.out.print("numero: " + rs.getInt("numero"));
				System.out.print(", nome: " + rs.getString("nome"));
				System.out.print(", genero: " + rs.getString("genero"));
				System.out.print(", nascido: " + rs.getDate("nascido"));
				System.out.print(", telemovel: " + rs.getString("telemovel"));
				System.out.print(", email: " + rs.getString("email"));
			    System.out.println();
			 }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	   }

}



