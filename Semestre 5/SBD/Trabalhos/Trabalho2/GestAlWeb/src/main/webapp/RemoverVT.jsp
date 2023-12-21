<!DOCTYPE html>
<html>
<%@ page import="GestAl.*,  java.io.PrintWriter"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Remoção de Vistas e Tabelas"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Remover Tabelas">
<meta name="keywords" content="ISEL, ADEETC">
<meta name="description" content="Remoção de Vistas e Tabelas">
<meta name="owner" content="ISEL/ADEETC - Doutor Porfírio Filipe">
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
		alert('Remoção com sucesso!');
	</script>
	Sucesso na remocão das vistas e tabelas!
	<%
}
else
{
	%> 
	<script>
		alert('Falhou a remoção!');
	</script>
	Falhou a remoção das tabelas e vistas...
	<%
}
Consola.setOut(null);
%>
</body>
</html>
