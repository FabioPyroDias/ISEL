<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.sql.ResultSetMetaData, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Pauta da disciplina"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Pauta da Disciplina">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Pauta da disciplina num determinado ano">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="10dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleTable.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Pauta da Disciplina</title>
</head>
<body style="text-align:center;">
<h2>Pauta da Disciplina</h2>
<% 
String codigo=request.getParameter("Codigo");
String ano=request.getParameter("Ano");
Manipula dados = new Manipula( new Configura());
if(codigo!=null && ano!=null){
	String designacao="???";
	Object res = dados.getVObject("SELECT DESIGNACAO FROM DISCIPLINA WHERE CODIGO='"+codigo+"'");
	if(res!=null)
		designacao=dados.getVObject("SELECT DESIGNACAO FROM DISCIPLINA WHERE CODIGO='"+codigo+"'").toString();
	%>
	<h3><%=designacao%> em <%=ano%></h3>
	<br/>
	<%
	String directiva=
			"select a.numero, nome, MAX(NOTA) NOTA "
					+ "from aluno as a, inscricao as i where a.numero=i.numero and i.codigo='"
					+ codigo + "' and ano = " + ano + " GROUP BY A.NUMERO, CODIGO order by a.numero";
	System.out.println(directiva);
	ResultSet rs = dados.getResultado(directiva);
	int rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
	if(rowCount>0) {
		rs.beforeFirst();
		%>
		<table class="styled-table">
		<tr>
			<th>Número</th>
			<th>Nome</th>
			<th>Nota</th>
		</tr>
		<%
		while (rs.next()) {
			String nota=rs.getString("nota");
			if(nota==null) 
				nota="-";
			%>
			<tr>
				<td><%=rs.getString("numero")%></td>
				<td style="text-align: left"><%=Consola.proper(rs.getString("nome"))%></td>
				<td><%=nota%></td>
			</tr>
			<%}
	%></table><%
	} else {%>
		<script>alert("A disciplina não tem avaliações registadas neste ano!")</script>
	<%}
}  else {
if(codigo==null) codigo="";
if(ano==null) ano="";
%>
<div id="myDIV" style="background-image: linear-gradient(to bottom left, goldenrod, gold); 
					   margin: auto; width: 95%; border: 2px solid #0000FF; padding: 10px;">
<br>
<form name="pauta" action="" method="post" autocomplete="off">

<label for="Codigo">Disciplina </label>
<select onchange="pauta.Ano.value=''; getYears(this.value); window.setTimeout(() => pauta.Ano.focus(), 0);" 
		title="Designação da disciplina" name="Codigo" id="Codigo" required>
<%	ResultSet rs = dados.getResultado("SELECT CODIGO, DESIGNACAO FROM DISCIPLINA D"+
					" WHERE 0 < (SELECT COUNT(*) FROM INSCRICAO I WHERE D.CODIGO=I.CODIGO) ORDER BY DESIGNACAO"); 
	while (rs.next()) {
		%><option value='<%=rs.getString("CODIGO")%>'><%=rs.getString("DESIGNACAO")%></option><%
	}
	%>
</select>
<%int anoAtual=dados.today().getYear(); 
int anoMin=anoAtual-5;
int anoMax=anoAtual+2;
%>
<%dados.desligar(); %>
&nbsp;&nbsp;
<label for="Ano">Ano </label>
<!--  implementar o min e o max dinamicamente a partir do ano atual  -->
<input value="<%=ano%>" list="Anos" min="<%=anoMin%>" max="<%=anoMax%>" size="4" maxlength="4" type="number" name="Ano" pattern="[0-9]{4,4}" 
			title="Ano de funcionamento da disciplina" placeholder="0000" required>
<datalist id="Anos">
</datalist>
<button>Executar</button>
</form>
<br>
</div>
<script>
//seleciona a opção do item, select
function setValue(sel, inVal){
	var dl = document.getElementById(sel);
	if(dl!=null) {
		var i = 0;
		for (; i < dl.options.length; i++)
		  if (dl.options[i].value == inVal)
		    break;
		dl.selectedIndex = i;
	}	
}
setValue('Codigo', '<%=codigo%>');
// reconstroi os valores do ano fazendo pedido AJAX
function getYears(codigo) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("Anos").innerHTML = this.responseText;
  }
  xhttp.open("GET", "getYears?Codigo="+codigo);
  xhttp.send();
}
pauta.Codigo.value='<%=codigo%>';
pauta.Ano.value='<%=ano%>';
window.setTimeout(() => pauta.Codigo.focus(), 0);
</script>
<%} // fim do else %>
 <div style="width:95%; margin:auto; text-align:center;">
<a href="javascript:window.history.back()">Voltar</a>
</div>
</body>
</html>
