package sbd;

import java.sql.*;

public class JavaStansdaloneJDBCExample2 {

	   static final String DB_URL = "jdbc:mysql://localhost:3306/aula";
	   static final String USER = "root";
	   static final String PASS = "diogo";
	   static int aluno = 21;
	   static String email = "a" + aluno + "@isel.pt";
	   static final String UPDATE = "UPDATE `aula`.`aluno`"
	   		+ "SET `email` = ?"
	   		+ "WHERE `numero` = ?;";
	   
	   static final String QUERY = "SELECT numero,"
		   		+ "    nome,"
		   		+ "    genero,"
		   		+ "    nascido,"
		   		+ "    telemovel,"
		   		+ "    email FROM aluno WHERE numero = ?;";
	   

	   public static void main(String[] args) {
	      // Open a connection
	      try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    	 PreparedStatement stmt = conn.prepareStatement(UPDATE);
	    	 stmt.setString(1, email);
	         stmt.setInt(2, aluno); 
	         int rowsAffected = stmt.executeUpdate();
	         //int rowsAffected = stmt.executeUpdate(UPDATE);
	    	 System.out.println("Foram alteradas " + rowsAffected + " linhas");
	    	 stmt.close();
	    	 
	    	 stmt = conn.prepareStatement(QUERY);
	    	 stmt.setInt(1, aluno);
	    	 ResultSet rs = stmt.executeQuery();
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



