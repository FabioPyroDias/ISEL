<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.io.PrintWriter, java.sql.ResultSetMetaData, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Exporta uma Tabela"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Exporta Tabela">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Exporta Tabela">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="10dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Exportação da Tabela</title>
</head>
<body>
<!--  Mostra sempre em SQL/insert qualquer tabela -->
<% 
Manipula dados = new Manipula(new Configura());
String tabela=request.getParameter("Tabela");
if(tabela==null||tabela.length()==0)
	Consola.writeLine("Tabela inválida!");
else{
	ResultSet rs = dados.getResultado("SELECT * FROM " + tabela+" ORDER BY 1");
	int rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
	if(rowCount>0) {
		rs.beforeFirst();
		%><h2>Exporta tabela '<%=tabela%>'</h2><br><%
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();
		String colNames = "";
		for (int i = 0; i < colCount; i++) 
			colNames = colNames + rsmd.getColumnLabel(i + 1) + ", ";
		colNames = colNames.substring(0, colNames.length() - 2);
		Configura cfg = new Configura();
		Consola.setOut(new PrintWriter(out));
		while (rs.next()) {
			String Insert = "INSERT INTO " + tabela + " (" + colNames + ") VALUES (";
			for (int i = 1; i <= colCount; i++) {
				String item = "NULL";
				if(rs.getObject(i)!=null) 
					item = Configura.fmTipo(rs.getString(i).replaceAll("'","''"), rsmd.getColumnType(i));
				Insert = Insert	+ item + ",";
			}
			Insert = Insert.substring(0, Insert.length() - 1) + ");";
			Consola.writeLine(Insert.substring(0,(Insert.length()>120)?120:Insert.length()));
		}
	} else {
		%><h2>A tabela '<%=tabela%>' está vazia!</h2><br><%
		}
	dados.desligar();
	} 
%>
<br>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>
