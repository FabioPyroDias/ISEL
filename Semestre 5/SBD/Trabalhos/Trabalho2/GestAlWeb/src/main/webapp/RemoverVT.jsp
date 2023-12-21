<!DOCTYPE html>
<html>
<%@ page import="GestAl.*,  java.io.PrintWriter"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Remo��o de Vistas e Tabelas"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Remover Tabelas">
<meta name="keywords" content="ISEL, ADEETC">
<meta name="description" content="Remo��o de Vistas e Tabelas">
<meta name="owner" content="ISEL/ADEETC - Doutor Porf�rio Filipe">
<meta name="copyright" content="ISEL/ADEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="15Dec2012">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Remover Vistas e Tabelas</title>
</head>
<body>
<a href="javascript:window.history.back()">Voltar</a>
<br>
<%
Consola.setOut(new PrintWriter(out));
if (Gestor.removerVistas() && Gestor.removerTabelas()){%> 
	<script>	
		alert('Remo��o com sucesso!');
	</script>
	Sucesso na remoc�o das vistas e tabelas!
	<%
}
else
{
	%> 
	<script>
		alert('Falhou a remo��o!');
	</script>
	Falhou a remo��o das tabelas e vistas...
	<%
}
Consola.setOut(null);
%>
</body>
</html>
