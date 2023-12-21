<!DOCTYPE html>
<html>
<%@ page import="GestAl.*,  java.io.PrintWriter"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Cria��o de Tabelas e Vistas"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Criar Tabelas e Vistas">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Cria��o de Tabelas e Vistas">
<meta name="owner" content="ISEL/DEETC - Doutor Porf�rio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="01dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Criar Tabelas e Vistas</title>
</head>
<body>
<a href="javascript:window.history.back()">Voltar</a>
<br>
<%
Consola.setOut(new PrintWriter(out));
if (Gestor.criarTabelas()  && Gestor.criarVistas()){
	%>
	<script> 
    	alert('Cria��o com sucesso!');
	</script>
	Sucesso na cria��o das tabelas e vistas!
	<%
}
else
{
	%> 
	<script>
		alert('Falhou a cria��o!');
	</script>
	Falhou a cria��o das tabelas e vistas...
	<%
}
Consola.setOut(null);
%>
</body>
</html>
