<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.sql.ResultSetMetaData, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Lista registos"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Lista registos">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Lista registos associados aos estudantes">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="31dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleTable.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Lista Registos</title>
</head>
<body style="text-align:center;">
<h2>Lista Registos</h2>
<% 
Manipula dados = new Manipula();
String directiva=
			"SELECT numero,"+
					" nome,"+
					" codigo,"+
					" nota,"+
					" ano,"+
					" idade,"+
					" nascido,"+
					" faltam"+
			" FROM lista";
ResultSet rs = dados.getResultado(directiva);
int rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
if(rowCount>0) {
	rs.beforeFirst();
	%>
	<table class="styled-table">
	<tr>
		<th>Número</th>
		<th>Nome</th>
		<th>Código</th>
		<th>Nota</th>
		<th>Ano</th>
		<th>Idade</th>
		<th>Faltam</th>
	</tr>
  <%
	String color="powderblue";
  	String numeroAnterior=null;
  	String numeroAtual=null;
    while (rs.next()) {
	  	numeroAtual=rs.getString("numero");
    	if(numeroAnterior!=null && numeroAtual!=null && numeroAnterior.compareTo(numeroAtual)!=0)
	  		if(color.compareTo("powderblue")==0)
	  			color="#ffffff";
	  		else
	  			color="powderblue"; 
	  	%>
		<tr style="background-color:<%=color%>;">
			<td><%=rs.getString("numero")%></td>
			<td style="text-align: left;"><%=Consola.proper(rs.getString("nome"))%></td>
			<td><%=rs.getString("codigo")%></td>
			<td><%=rs.getString("nota")%></td>
			<td><%=rs.getString("ano")%></td>
			<td><%=rs.getString("idade")%></td>
			<td><%=rs.getString("faltam")%></td>
		</tr>
	<%numeroAnterior=numeroAtual;
	}%>
	</table>
<%}%>
<div style="width:95%; margin:auto; text-align:center;">
<a href="javascript:window.history.back()">Voltar</a>
</div>
</body>
</html>
