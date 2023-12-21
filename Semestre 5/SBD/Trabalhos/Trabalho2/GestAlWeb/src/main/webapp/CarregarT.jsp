<!DOCTYPE html>
<html>
<%@ page import="GestAl.*,  java.io.PrintWriter"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Carregamento de Tabelas"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Carregar Tabelas">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Carregamento de Tabelas">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="20nov2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Carregar Tabelas</title>
</head>
<body>
<a href="javascript:window.history.back()">Voltar</a>
<br>
<%
Consola.setOut(new PrintWriter(out));
if (Gestor.carregarTabelas(getServletContext().getRealPath("/")+"/pessoas\\")){
	%> 
	<script>
    	alert('Carregamento das tabelas realizado com sucesso!');
	</script>
	Sucesso no carregamento das tabelas!
	<%
}
else
{
	%>
	<script> 
		alert('Falhou carregamento!');
	</script>
	Falhou o carregamento das tabelas...
	<%
}
Consola.setOut(null);
%>
</body>
</html>
