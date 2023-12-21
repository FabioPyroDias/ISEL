<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.sql.ResultSetMetaData, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Inscrição na disciplina"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Inscrição">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Inscrição na disciplina num determinado ano">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="12dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleTable.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Inscrição na Disciplina</title>
</head>
<body style="text-align:center;">
<h2>Inscrição na Disciplina</h2>
<%
String numero=request.getParameter("Numero");
String codigo=request.getParameter("Codigo");
String ano=request.getParameter("Ano");
Manipula dados = new Manipula( new Configura());
if(codigo!=null && codigo.length()>0 && ano!=null && ano.length()>0 && numero!=null && numero.length()>0){
	String directiva = "insert into inscricao (numero, ano, codigo) values (" + numero + ", " + ano + ", '" + codigo + "')";
	System.out.println("Inscrição: "+directiva);
	if (dados.xDirectiva(directiva)) 
		%> <script>alert("Inscrição realizada com sucesso!");</script><%
	else
		%> <script>alert("Falha na concretização da inscrição...")</script><%
}  // else {
	if(codigo==null) codigo="";
	if(ano==null) ano="";
	if(numero==null) numero="";

%>
<div id="myDIV" style="background-image: linear-gradient(to bottom left, goldenrod, gold); 
					   margin: auto; width: 95%; border: 2px solid #0000FF; padding: 10px;">
<br>
<form name="inscricao" method="post" autocomplete="off">
<label for="Numero">Número: </label> 
<input value="<%=numero%>" onchange="getAluno(this.value); chkInscricao(inscricao.Numero.value, inscricao.Codigo.value, inscricao.Ano.value);"
        size="5" maxlength="5" min="1" max="99999" 
		type="number" id="Numero" name="Numero" pattern="[0-9]{5}" title="Número até cinco digitos." placeholder="00000" required>
&nbsp;&nbsp;
<!--  implementar o min e o max dinamicamente a partir do ano atual  -->
<%int anoAtual=dados.today().getYear(); 
  int anoMin=anoAtual-2;
  int anoMax=anoAtual+2;
%>
<label for="Codigo">Disciplina </label>
<select title="Designação da disciplina" name="Codigo" id="Codigo" required
	onchange="inscricao.Ano.value=''; getAnosLivres('<%=anoMin%>', '<%=anoMax%>',inscricao.Numero.value, inscricao.Codigo.value); window.setTimeout(() => inscricao.Ano.focus(), 0);">
<%	ResultSet rs = dados.getResultado("SELECT CODIGO, DESIGNACAO FROM DISCIPLINA D ORDER BY DESIGNACAO"); 
	while (rs!=null && rs.next()) {
		%><option value='<%=rs.getString("CODIGO")%>'><%=rs.getString("DESIGNACAO")%></option><%
	}
	%>
</select>
&nbsp;&nbsp;
<label for="Ano">Ano </label>
<input list="Anos" value="<%=ano%>" onchange="chkInscricao(inscricao.Numero.value, inscricao.Codigo.value, this.value);" size="4" 
	min="<%=anoMin%>" max="<%=anoMax%>" 
	maxlength="4" type="number" name="Ano" pattern="[0-9]{4,4}" title="Ano da inscrição" placeholder="0000" required>
<datalist id="Anos">
<%for(int i=anoMin; i<=anoMax; i++) {%>
	<option value='<%=i%>'/>
<%}%>
</datalist>
<button>Executar</button>
<p id="msg"></p>
</form>
</div>
<%
dados.desligar();
%>
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
//Atualiza por AJAX o paragrafo com os dados do aluno
function getAluno(numero) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("msg").innerHTML = this.responseText;
  }
  xhttp.open("GET", "getAluno?Numero="+numero);
  xhttp.send();
}
//Atualiza o paragrafo com mensagem relativa à inscrição já existir 'duplicado'
function chkInscricao(numero, codigo, ano) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("msg").innerHTML = this.responseText;
  }
  xhttp.open("GET", "chkInscricao?Numero="+numero+"&Codigo="+codigo+"&Ano="+ano);
  xhttp.send();
}

//Anos no intervalo que ainda não têm inscricoes, faz pedido AJAX
function getAnosLivres(min, max, numero, codigo) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("Anos").innerHTML = this.responseText;
  }
  xhttp.open("GET", "getAnosLivres?Min="+min+"&Max="+max+"&Numero="+numero+"&Codigo="+codigo);
  xhttp.send();
}

window.setTimeout(() => inscricao.Numero.focus(), 0);
</script>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>
