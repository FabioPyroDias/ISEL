<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Descrição do Erro</title>
</head>
<body>
<h1>Opps...</h1>
<p>Ocorreu uma execeção: <%= exception.getMessage() %> </p>
<% exception.printStackTrace(response.getWriter()); %>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>