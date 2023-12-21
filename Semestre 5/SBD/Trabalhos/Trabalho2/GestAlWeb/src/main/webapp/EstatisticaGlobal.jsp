<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.math.BigDecimal, java.math.RoundingMode, java.text.NumberFormat"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Estatística Global"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Estatística Global">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Estatística Global">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="23nov2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleTable.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Estatística Global</title>
</head>
<body style="text-align:center;">
	<h2>Estatística Global</h2>
	<table class="styled-table">
		<tr>
			<th>Aprovados</th>
			<th>Reprovados</th>
			<th>Percentagem</th>
		</tr>
	<%
	BigDecimal nAprov = Gestor.estatistica(null, Gestor.condAprov, "count(*)");
	BigDecimal nReprov = Gestor.estatistica(null, " NOT (" + Gestor.condAprov + ")", "count(*)");
	BigDecimal nTotal = nAprov.add(nReprov);
	String sPer = " -";
	if (BigDecimal.ZERO.compareTo(nTotal) != 0) {
		BigDecimal nPer = nAprov.divide(nTotal, 3, RoundingMode.HALF_UP);
		sPer = NumberFormat.getPercentInstance().format(nPer);
	%>
		<tr>
		  <td><%=nAprov.toString()%></td>
		  <td><%=nReprov.toString()%></td>
		  <td><%=sPer%></td>
	    </tr>
	    </table>
	    <%
	}
%>
<br>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>
