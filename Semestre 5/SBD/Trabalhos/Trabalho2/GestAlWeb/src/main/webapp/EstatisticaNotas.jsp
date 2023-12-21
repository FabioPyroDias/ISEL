<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.sql.ResultSet, java.sql.SQLException, java.math.BigDecimal, java.math.RoundingMode"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Estatística de Notas"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Estatística de Notas por Disciplina">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Ordena por disciplina, as respectivas notas: mínima, máxima e média">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="23nov2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleTable.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Estatística de Notas</title>
</head>
<body style="text-align:center;">
	<h2>Estatística de Notas</h2>
	<%
	Manipula dados = new Manipula( new Configura());
	String directiva = "select ano, designacao, i.codigo,  min(nota), max(nota), avg(nota),"+
			" (SELECT COUNT(NUMERO) FROM inscricao a WHERE a.codigo=d.codigo and a.ano=i.ano and a.nota is not null) avaliados, "+
			" (SELECT COUNT(NUMERO) FROM inscricao b WHERE b.codigo=d.codigo and b.ano=i.ano and b.nota is null) inscritos "+
			" from inscricao as i join disciplina as d "
			+ " on (i.codigo=d.codigo) where " + Gestor.condAprov + " group by 1, 2, 3 order by 1, 2";
	System.out.println(directiva);
	ResultSet rs = dados.getResultado(directiva);
	int rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
	if(rowCount>0) {
		rs.beforeFirst();
	%>
		<table class="styled-table">
			<tr>
				<th>Ano</th>
				<th>Disciplina</th>
				<th>Mínima</th>
				<th>Máxima</th>
				<th>Média</th>
				<th>Avaliados</th>
				<th>Inscritos</th>
			</tr>
		<%
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString(1)%></td>
				<td style="text-align: left;">
				<a href="Pauta.jsp?Codigo=<%=rs.getString(3)%>&Ano=<%=rs.getString(1)%>">
					<%=rs.getString(2)%></a>
				</td>
				<td><%=rs.getBigDecimal(4).setScale(0, RoundingMode.HALF_UP)+" ("+rs.getBigDecimal(4).setScale(2, RoundingMode.HALF_UP)+")"%></td>
				<td><%=rs.getBigDecimal(5).setScale(0, RoundingMode.HALF_UP)+" ("+rs.getBigDecimal(5).setScale(2, RoundingMode.HALF_UP)+")"%></td>
				<td><%=rs.getBigDecimal(6).setScale(2, RoundingMode.HALF_UP)%></td>
				<td><%=rs.getString(7)%></td>
				<td><%=rs.getString(8)%></td>
			</tr>
			<%}%>
		</table>
	<%
	} else {%>
		<script>alert("Não existem avaliações registadas!")</script>
	<%}
	dados.desligar();
	%>
	
<br/>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>
