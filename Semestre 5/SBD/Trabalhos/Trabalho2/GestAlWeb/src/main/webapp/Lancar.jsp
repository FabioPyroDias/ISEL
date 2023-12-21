<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.sql.ResultSetMetaData, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Lançamento de Nota"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Lançar Nota">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Lançamento de nota numa disciplina num ano">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="12dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleTable.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Lançar Nota</title>
</head>
<body style="text-align:center;">
<h2>Lançar Nota</h2>
<%
String numero=request.getParameter("Numero");
String designacao=request.getParameter("Designacao");
String ano=request.getParameter("Ano");
String nota=request.getParameter("Nota");
Manipula dados = new Manipula( new Configura());
if(designacao!=null && designacao.length()>0 
&& ano!=null && ano.length()>0 
&& numero!=null && numero.length()>0
&& ano!=null && ano.length()>0
&& nota!=null && nota.length()>0){
	String directiva = "update inscricao set nota=" + nota + " where numero=" + numero + " and ano=" + ano
			+ " and codigo=(select distinct codigo from disciplina where designacao = '"+designacao+"') and nota is null";
	System.out.println("Lançar: "+directiva);
	if (dados.xDirectiva(directiva)) { 
		%> <script>alert("Lançamento de nota: <%=dados.getAfetadas()%>");</script><%
	}
	else
		%> <script>alert("Falha na concretização do lançamento de nota...");</script><%
}  // else {

if(designacao==null) designacao="";
if(ano==null) ano="";
if(numero==null) numero="";
if(nota==null) nota="";
%>
<div id="myDIV" style="background-image: linear-gradient(to bottom left, goldenrod, gold); 
					   margin: auto; width: 95%; border: 2px solid #0000FF; padding: 10px;">
<br>
<form name="lancar" method="post" autocomplete="off">
<label for="Numero">Número: </label> 
<input value="<%=numero%>" 
	   onblur="getAluno(this.value); getDisciplinas(lancar.Numero.value); lancar.Designacao.value=''; lancar.Ano.value=''; lancar.Nota.value='';" 
	   size="5" maxlength="5" min="1" max="99999" type="number" id="Numero" name="Numero" 
	   pattern="[0-9]{5}" title="Número do estudante" placeholder="00000" required>
&nbsp;&nbsp;
<label for="Designacao">Disciplina: </label>
<input value="<%=designacao%>" onchange="lancar.Ano.value = ''; lancar.Nota.value = ''; getAnos(lancar.Numero.value, this.value);" list="Disciplinas" 
	   size="60" type="text" onchange="getAnos(lancar.Numero.value, lancar.Codigo.value);" 
	   name="Designacao" id="Designacao" placeholder="Alfanumérico" pattern="[a-zA-Z0-9 àáãâéêíóõôúç\-]+" 
	   title="Designação da disciplina" required>
<datalist id="Disciplinas">
</datalist>
&nbsp;&nbsp;
<%int anoAtual=dados.today().getYear();
int anoMin=anoAtual-5;
int anoMax=anoAtual+1;
%>
<% dados.desligar(); %>
<label for="Ano">Ano </label>
<!--  min 5 anos para trás e max 2 anos para a frente em relação ao ano atual obtido a partir da bd -->
<input 	onchange="lancar.Nota.value = '';" list="Anos" value="<%=ano%>" size="4" min="<%=anoMin%>" min="<%=anoMax%>" 
		maxlength="4" type="number" id="Ano" name="Ano" pattern="[0-9]{4,4}" 
		title="Ano da inscrição" placeholder="0000" required>
<datalist id="Anos">
</datalist>
&nbsp;&nbsp;
<label for="Nota">Nota </label>
<input value="<%=nota%>" size="5" min="10.00" max="20.00" 
	maxlength="5" type="number" id="Nota" name="Nota" pattern="[0-9]{1,2}([,\.][0-9]{1,2})?" step="0.05"
	title="Nota da avaliação" placeholder="00,00" required>
<button>Executar</button>
<p id="msg"></p>
</form>
</div>
<%//} // fim do else %>
<br>
<script>
//Atualiza o paragrafo com os dados do aluno
function getAluno(numero) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
	  if (xhttp.readyState === 4 && xhttp.status === 200) {
		document.getElementById("Ano").value="";
    	document.getElementById("msg").innerHTML = this.responseText;
	  }
  }
  xhttp.open("GET", "getAluno?Numero="+numero);
  xhttp.send();
}
// Devolve a lista de anos associados à inscrição do aluno na disciplina
function getAnos(numero, designacao) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
	if (xhttp.readyState === 4 && xhttp.status === 200)
    	document.getElementById("Anos").innerHTML = this.responseText;
  }
  xhttp.open("GET", "getAnos?Numero="+numero+"&Designacao="+designacao);
  xhttp.send();
}

//Devolve a lista de disciplinas associadas a inscrições (sem nota) do aluno
function getDisciplinas(numero) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
	if (xhttp.readyState === 4 && xhttp.status === 200)
    	document.getElementById("Disciplinas").innerHTML = this.responseText;
  }
  xhttp.open("GET", "getDisciplinas?Numero="+numero);
  xhttp.send();
}
if(lancar.Numero.value=="")
	window.setTimeout(() => lancar.Numero.focus(), 0);
if(lancar.Designacao.value=="")
	window.setTimeout(() => lancar.Designacao.focus(), 0);
if(lancar.Ano.value=="")
	window.setTimeout(() => lancar.Ano.focus(), 0);
if(lancar.Nota.value=="")
	window.setTimeout(() => lancar.Nota.focus(), 0);
</script>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>
