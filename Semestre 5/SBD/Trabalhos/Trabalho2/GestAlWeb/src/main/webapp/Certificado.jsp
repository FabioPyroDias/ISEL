<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Certificado de Habilitações"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Certificado do estudante">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Certificado de habilitações do estudante">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="10dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleTable.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Certificado de Habilitações</title>
</head>
<body style="text-align:center;">
<h2>Certificado de Habilitações</h2>
<% 
String numero=request.getParameter("Numero");
if(numero!=null){
	Manipula dados = new Manipula( new Configura());
	String nome=dados.getVObject("SELECT NOME FROM ALUNO WHERE NUMERO="+numero).toString();
	%>
	<h3> Estudante Nº&nbsp;&nbsp;<%=numero%>,&nbsp;&nbsp;<%=Consola.proper(nome)%></h3>
	<br/>
	<%
	String directiva="SELECT ANO, DESIGNACAO, NOTA FROM AVALIACOES WHERE NUMERO="+numero;
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
			<th>Nota</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("ano")%></td>
			<td style="text-align: left"><%=rs.getString("designacao")%></td>
			<td><%=Consola.NotaToString(rs.getBigDecimal("nota"))%></td>
		</tr>
		<%}
	%></table><%
	dados.desligar();
	} else {%>
		<script>alert("O estudante não tem avaliações registadas!")</script>
	<%}
}  else {  // numero==null
%>
<div id="myDIV" style="background-image: linear-gradient(to bottom left, goldenrod, gold); 
					   margin: auto; width: 95%; border: 2px solid #0000FF; padding: 10px;">
<br>
<form name="certificado" action="" method="post">
<label for="Numero">Número: </label>
<input  onchange="getAluno(this.value);" onkeyup="getAluno(this.value);" size="5" maxlength="5" min="1" max="99999" type="number" id="Numero" name="Numero" 
	   pattern="[0-9]{5}" title="Número até cinco digitos." placeholder="00000" required>
<button>Executar</button>
<p id="msg"></p>
</form>
</div>
<script>
//Atualiza por AJAX o paragrafo com os dados do aluno
function getAluno(numero) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("msg").innerHTML = this.responseText;
  }
  xhttp.open("GET", "getAluno?Numero="+numero);
  xhttp.send();
}
window.setTimeout(() => certificado.Numero.focus(), 0);
</script>
<%} // fim do else %>
<br>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>
