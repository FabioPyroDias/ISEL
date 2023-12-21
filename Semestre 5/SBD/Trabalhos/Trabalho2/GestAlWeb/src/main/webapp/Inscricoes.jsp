<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.sql.ResultSetMetaData, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Inscrições"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Inscrições do estudante">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Inscrições ativas do estudante">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="10dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleTable.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Inscrições Activas</title>
</head>
<body style="width:50%; margin:auto; text-align:center;">
<h2>Inscrições Activas</h2>
<% 
String numero=request.getParameter("Numero");
String codigo=request.getParameter("Codigo");
String designacao=request.getParameter("Designacao");
if(numero!=null||codigo!=null){
	Manipula dados = new Manipula( new Configura());
	String nome="";
	if(numero!=null)
		nome=dados.getVObject("SELECT NOME FROM ALUNO WHERE NUMERO="+numero).toString();
	if(designacao!=null){%>
		<h3>Disciplina: <%=designacao%> (<%=codigo%>)</h3>
	<%} else{ %>
		<h3>Estudante: <%=Consola.proper(nome)%> (<%=numero%>)</h3>
	<%}%>
	<br/>
	<%  
		String directiva="";
		if(numero!=null)
			directiva= "SELECT D.CODIGO, D.DESIGNACAO, ANO FROM INSCRICOES I, DISCIPLINA D WHERE I.CODIGO=D.CODIGO AND NUMERO="+numero+" ORDER BY 1, 3";
		else
			directiva= "SELECT A.NUMERO, NOME, ANO  FROM INSCRICOES I, ALUNO A WHERE I.NUMERO=A.NUMERO AND CODIGO='"+codigo+"' ORDER BY 1, 3";
		System.out.println(directiva);
		ResultSet rs = dados.getResultado(directiva);
		int rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
		if(rowCount>0) {
			rs.beforeFirst();
			%>
			<table class="styled-table">
			<tr>
				<th>
				<%if(numero!=null){%>
					Código
				<%} else {%>
					Número
				<%}%>
				</th>
				<th>
				<%if(numero!=null){%>
					Disciplina
				<%} else {%>
					Nome
				<%}%>
				</th>
				<th>Ano</th>
			</tr>
			<%
			while (rs.next()) {
				String aux="Numero="+rs.getString(1)+"&Designacao="+designacao;
				if(numero!=null)
					aux="Numero="+numero+"&Designacao="+rs.getString(2);
			%>
			<tr>
				<td title="Clique para lançar nota" >
						<a href='Lancar.jsp?<%=aux%>&Ano=<%=rs.getString(3)%>'><%=rs.getString(1)%></a>
				</td>
				<td style="text-align:left;">
					<%=rs.getString(2)%>
				</td>
				<td>
					<%=rs.getString(3)%>
				</td>
			</tr>
			<%}
		%></table><%
	} else {%>
		<script>alert("Não existem inscrições registadas!")</script>
	<%}
	dados.desligar();
}  else {  // numero==null
%>
<div id="myDIV" style="background-image: linear-gradient(to bottom left, goldenrod, gold); 
					   margin: auto; width: 95%; border: 2px solid #0000FF; padding: 10px;">
<br>
<form name="inscricoes" action="" method="post">
<label for="Numero">Número: </label>
<input onchange="chkAluno(this.value);" onkeyup="getAluno(this.value);" 
		maxlength="5" size="5" min="1" max="99999" type="number" id="Numero" name="Numero" 
		pattern="[0-9]{5}" title="Número até cinco digitos." placeholder="00000" required>
<button>Executar</button>
<p id="msg"></p>
</form>
</div>
<script>
//Atualiza por AJAX o paragrafo com os dados do aluno
function getAluno(numero) {
  if(numero==null)
	  return;
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("msg").innerHTML = this.responseText;
  }
  xhttp.open("GET", "getAluno?Numero="+numero);
  xhttp.send();
}
window.setTimeout(() => inscricoes.Numero.focus(), 0);
</script>
<%} // fim do else %>
<br>
<%if(numero!=null) { %>
	<a href="Inscrever.jsp?Numero=<%=numero%>">Nova Inscrição</a><br>
<%} %>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>
