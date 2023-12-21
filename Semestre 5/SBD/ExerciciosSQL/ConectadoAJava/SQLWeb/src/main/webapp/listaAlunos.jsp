<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de alunos</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<%
String DB_URL = "jdbc:mysql://localhost:3306/aula";
String USER = "root";
String PASS = "diogo";
String QUERY = "SELECT numero,"
		+ "    nome,"
		+ "    genero,"
		+ "    nascido,"
		+ "    IFNULL( telemovel , '-') as telemovel,"
		+ "    IFNULL(email, '-') as email"
		+ " FROM aula.aluno;";
		
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery(QUERY); 
		     // Extract data from result set
		     %>   
		<table>
		  <tr>
		    <th>Número</th>
		    <th>nome</th>
		    <th>genero</th>
		    <th>nascido</th>
		    <th>telemovel</th>
		    <th>email</th>
		  </tr>
	     
		     <% 
	         while (rs.next()) {
	            // Retrieve by column name
	            %>
	            <tr>
	            <td><%= rs.getInt("numero")%></td>
	            <td><%= rs.getString("nome")%></td>
	            <td><%= rs.getString("genero")%></td>
	            <td><%= rs.getDate("nascido")%></td>
	            <td><%= rs.getString("telemovel")%></td>
	            <td><%= rs.getString("email")%></td>
	            
	          </tr>
	          <%

	         }
		     
		  %>
		  </table>
		  <%
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 

%>


</body>
</html>