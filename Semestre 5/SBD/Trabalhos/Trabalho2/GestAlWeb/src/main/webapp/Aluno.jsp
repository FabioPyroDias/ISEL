<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.math.BigDecimal, java.time.LocalDate, java.sql.ResultSet"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Manipulação do estudante"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <!--  charset=ISO-8859-1 -->
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Ficha do Estudante">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Manipulação do estudante">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="22Dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleFoto.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<style>
	/* unvisited link */
	a:link {
	  color: blue;
	}
	
	/* visited link */
	a:visited {
	  color: green;
	}
	
	/* mouse over link */
	a:hover {
	  color: brown;
	}
	
	/* selected link */
	a:active {
	  color: black;
	}
</style>
<script src="qrious.min.js"></script>
<title>Ficha do Estudante</title>
<script>
// confirmação sobre apagar o registo corrente
function Confirma() {
  if(aluno.NumeroOld.value!="") {// se o numero estiver preenchido
	aluno.Numero.value = aluno.NumeroOld.value;
	aluno.Nome.value = aluno.NomeOld.value;
	aluno.Genero.value = aluno.GeneroOld.value;
	aluno.Data.value = aluno.DataOld.value;
  	return confirm('Quer apagar este registo?');
  }
  else
  	alert("Não existe registo seleccionado para apagar!");
  return false;
}

/* não usado
var regexSpecialCharacters = [
    "\\", ".", "+", "*", "?",
    "[", "^", "]", "$", "(",
    ")", "{", "}", "=", "!",
    "<", ">", "|", ":", "-"
];

regexSpecialCharacters.forEach(rgxSpecChar => 
    input = input.replace(new RegExp("\\" + rgxSpecChar,"gm"), "\\" + rgxSpecChar)) */

// https://www3.ntu.edu.sg/home/ehchua/programming/howto/Regexe.html

// verifica se o registo está bem preenchido no insert e no update
function checkValues() {
	if(aluno.Comando.value == "I"||aluno.Comando.value == "U") {
		 // se for insert e numero vazio = max(numero)+1
		if (aluno.Comando.value == "U" && aluno.Numero.value == "") {
			alert("O número tem de estar preenchido!");
			aluno.Numero.focus();
			return false;
		}
		if(aluno.Numero.value != "" && aluno.Numero.value.length>6) {
			alert("O número tem de ter menos de 6 digitos!");
			aluno.Numero.focus();
			return false;
		}
		if(aluno.Numero.value != "" && Number(aluno.Numero.value)<=0) {
			alert("O número tem de ser positivo!");
			aluno.Numero.focus();
			return false;
		}
		if (aluno.Nome.value == "") {
			alert("O nome tem de estar preenchido!");
			aluno.Nome.focus();
			return false;
		}
		if(aluno.Nome.length>100 || aluno.Nome.value.length<5) {
			alert("O nome tem de ter comprimento entre 5 e 100!");
			aluno.Nome.focus();
			return false;
		}
		/* [a-zA-Z]+('[a-zA-Z])?[a-zA-Z] */
		const regex = /[^a-z '\x22ÁÉÍÓÚàáãâéêíóõôúçñ\-]/g;
		var i=aluno.Nome.value.toLowerCase().search(regex);
		if(i!=-1) {
			alert("O carater '"+aluno.Nome.value.charAt(i)+"' é inválido!");
			aluno.Nome.focus();
			return false;
		}
		if (aluno.Data.value == "") {
			alert("A data de nascimento tem de estar preenchida!");
			aluno.Data.focus();
			return false;
		} else {
			const today = new Date();
			const my = new Date(aluno.Data.value);
			if(today < my) {  // não tem efeito porque se a data for limitada no input
				alert("A data de nascimento tem de ser do passado!");
				aluno.Data.focus();
				return false;
			}
		}
		if(aluno.fotoInput == "") {
			alert("Tem de seleccionar uma fotografia!");
		    return false;
		}
	}		
	return true;
}

function hide(item) {
	if(item!=null)	
		item.style.visibility="hidden";			// item.style.display = "none";
}

function show(item) {  // block, inline 					
	if(item!=null) {
		item.style.visibility="visible";						
	}
}

//esconde ou mostra um determinado elemento
function toggle (elemento) {
	if(elemento!=null) {
	  var x = document.getElementById(elemento);
	  if (x.style.display === "none") {
	    	x.style.display = "inline";  // block
	  } else {
	    	x.style.display = "none";
	  }
	}
} 
var time=null;
function DeltaTimer(render, interval) {

    this.start = start;
    this.stop = stop;

    function start() {
 	   console.log((interval/1000)+" seconds");	
       time = setTimeout(loop, interval);
       console.log("Iniciou o timer");
    }

    function stop() {
        clearTimeout(time);
        console.log("Parou o timer");	
    }

    function loop() {
    	time = setTimeout(loop, interval);
        render(interval);
    }
}

var timer = new DeltaTimer(troca, 10000);
function troca() {
	toggle('qrcode');
	toggle('img');
}

var slide=true;
function trocaSlide() {
	if(!slide) { 
		timer.start();
		console.log("Iniciou o timer!");
		}
	else
		{
		timer.stop();
		console.log("Parou o timer!");
	}
	slide=!slide;
}

function limpar() {
	hide(document.getElementById('certificado')); 
	hide(document.getElementById('i')); 
	hide(document.getElementById('inscricoes'));
	hide(document.getElementById('j'));
	hide(document.getElementById('conta')); 
	document.getElementById('age').innerHTML=''; 
	document.getElementById('tLinha').innerHTML='0'; 
	document.getElementById('img').src='silhueta.jpg'; 
	document.getElementById('img').title='Sem fotografia!';
	slide=false;
	timer.stop();
	show(document.getElementById('img'));
	hide(document.getElementById('qrcode'));
	window.setTimeout(() => aluno.ProcurarNome.focus(), 0);
}
//não usado
//popupWindow('google.com', 'test', window, 200, 100);
function popupWindow(url, windowName, win, w, h) {
    const y = win.top.outerHeight / 2 + win.top.screenY - ( h / 2);
    const x = win.top.outerWidth / 2 + win.top.screenX - ( w / 2);
    return win.open(url, windowName, `toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=${w}, height=${h}, top=${y}, left=${x}`);
}
</script>
</head>
<body style="text-align:center;">

<%
String comando=request.getParameter("Comando");
if(comando==null) 
	comando="";

String numero=request.getParameter("Numero");
String nome=request.getParameter("Nome");
String genero=request.getParameter("Genero");
String nascido=request.getParameter("Data");
String nlinha=request.getParameter("nLinha");
System.out.println("Rcebeu o numero: '"+numero+"'");
if(nlinha==null || nlinha=="")
	nlinha="0";
int tlinha=0;

String num=(String)request.getAttribute("numero");
String msg=(String)request.getAttribute("mensagem");
if(msg!=null){
	%><script>alert("<%=msg%>");</script><%
}
// Fixa o registo se encontrar a fotografia
if(comando.compareTo("K")==0 && num!=null && num.compareTo("")!=0) {
	numero=num;
	comando="S";
}
// modifica o numero se for inicialmente vazio
if(comando.compareTo("I")==0 && num!=null && num.compareTo("")!=0)
	numero=num;

System.out.println("Comando: "+comando);
System.out.println("Registo: "+nlinha);
System.out.println("Dados do Aluno:");
System.out.println("	numero: "+numero);
System.out.println("	nome: "+nome);
System.out.println("	género: "+genero);
System.out.println("	nascido: "+nascido);

String numeroOld=request.getParameter("NumeroOld");
String nomeOld=request.getParameter("NomeOld");
String generoOld=request.getParameter("GeneroOld");
String nascidoOld=request.getParameter("DataOld");

LocalDate today= LocalDate.now();
System.out.println("JSP: Comando -->> '"+comando+"'");

//procura pelo numero
//(nomeOld!=null && nome!=null && nomeOld.compareTo(nome)!=0 && comando.compareTo("U")==0)

if((numeroOld!=null && numero!=null && numeroOld.compareTo(numero)!=0 && comando.compareTo("U")==0)||comando.compareTo("S")==0||comando.compareTo("I")==0){  
	Manipula dados = new Manipula(new Configura());
	System.out.println("Procura o numero: '"+numero+"'");
	nome="";
	genero="";
	nascido="";
	today=dados.today();
	ResultSet rs = dados.getResultado("SELECT numero, nome, genero, nascido FROM aluno"+ 
					" where " + Consola.IgualV("numero", numero));
	if (rs!=null && rs.next()) {  // considera 1 linha que deve ser unica
		numero=rs.getString("numero");
		nome=rs.getString("nome");
		genero=rs.getString("genero");
		nascido=rs.getString("nascido");
		nlinha="1";
		tlinha = rs.last() ? rs.getRow() : 0;
	} 
	dados.desligar();
} 
// procura pelo nome ou avança/recua na procura
// (nomeOld!=null && nome!=null && nomeOld.compareTo(nome)==0 && comando.compareTo("U")==0)
if((numeroOld!=null && numero!=null && numeroOld.compareTo(numero)==0 && comando.compareTo("U")==0) || comando.compareTo("N")==0 || comando.compareTo("X")==0 || comando.compareTo("Z")==0){  
	if(comando.compareTo("U")==0)
		nlinha=String.valueOf(Integer.parseInt(nlinha)-1);
	Manipula dados = new Manipula(new Configura());
	numero="";
	genero="";
	nascido="";
	String filtro=Consola.Like("nome", nome.replaceAll("'","''"));
	if(comando.compareTo("N")==0) {
			session.setAttribute("filtro",filtro);
			nlinha=null;
	}
	else
		filtro=(String)session.getAttribute("filtro");
	String SQL= "SELECT numero, nome, genero, nascido FROM aluno "
				+ "where "+ filtro 
				+" order by numero";    // order by nome
	System.out.println("Procura: "+SQL);
	ResultSet rs = dados.getResultado(SQL);
	tlinha = rs.last() ? rs.getRow() : 0; 
	if(nlinha==null || nlinha.compareTo("")==0)
		rs.beforeFirst();
	else
		rs.absolute(Integer.valueOf(nlinha));
	if (rs!=null && (comando.compareTo("Z")!=0 && rs.next() || comando.compareTo("Z")==0 && rs.previous())) {  					
		// avança para a linha seguinte / anterior
		numero=rs.getString("numero");
		nome=rs.getString("nome");
		genero=rs.getString("genero");
		nascido=rs.getString("nascido");
		int aux=rs.getRow();
		if(aux!=0)
			nlinha=Integer.toString(aux);
		System.out.println("Linha atual ["+nlinha+"]/"+tlinha);
	}
	dados.desligar();
}  // fim da procura

// apaga o aluno corrente/atual
if(comando.compareTo("D")==0){
	Manipula dados = new Manipula(new Configura());
	BigDecimal nInscr = dados.getVBigDecimal("select count(*) from inscricao where numero=" + Consola.Valor(numero));
	if(null!=nInscr && !BigDecimal.ZERO.equals(nInscr)) {
		%> <script>alert('O aluno não pode ser apagado porque tem (<%=nInscr.toString()%>) inscrições/avaliações...');</script><%
	}
	else {
		String directiva = "delete from aluno where numero=" + Consola.Valor(numero);
		System.out.println("Apaga: "+directiva);
		if (dados.xDirectiva(directiva)) 
			%> <script>alert('O aluno foi apagado com sucesso!'); document.getElementById('Limpar').click();</script><%
		else 
			%> <script>alert('Ocorreu uma falha no apagamento do aluno...');</script><%
		}
	dados.desligar();	
}  // fim do apagar

if(numero==null) numero="";
if(nome==null) nome="";
if(genero==null) genero="";
if(nascido==null) nascido="";
if(nlinha==null) nlinha="";
%>

<div style="text-align:center;color:#0000FF">

<form onsubmit="return checkValues();" id="aluno" name="aluno" action="AlunoUp" method="post" enctype="multipart/form-data" >

<br>
<div id="myDIV" style="width: 95%; background-image: linear-gradient(to bottom left, goldenrod, gold); 
										margin: auto; border: 2px solid #0000FF; padding: 10px;">
	<button id="Novo" name="Novo" onclick="Comando.value='I'" title="Cria um estudante novo"><img id="iNovo" style="width:30px;height:30px;"><br>Novo</button>
	<button id="Alterar" name="Alterar" onclick="Comando.value='U'" title="Altera o estudante atual"><img id="iAlterar" style="width:30px;height:30px;"><br>Alterar</button>
	<button id="Apagar" name="Apagar" onclick="Comando.value='D'; return Confirma();" title="Apaga o estudante atual"><img id="iApagar" style="width:30px;height:30px;"><br>Apagar</button> 	
	<button id="Limpar" name="Limpar" type="reset"  value="Limpar" onclick="limpar();" title="Põe os campos no estado inicial">
			<img id="iLimpar" style="width:30px;height:30px;"><br>Limpar</button>
	<button formnovalidate="formnovalidate" id="Next" name="Next" onclick="Comando.value='X';" title="Avança para o estudante seguinte"><img id="iNext" style="width:30px;height:30px;"><br>Sguinte</button>
	<button formnovalidate="formnovalidate" id="Previous" name="Previous" onclick="Comando.value='Z';" title="Recusa para o estudante anterior"><img id="iPrevious" style="width:30px;height:30px;"><br>Anterior</button>
	<br/>
	<br/>
	<div id="conta">
	<label for="nLinha">Registo</label>&nbsp;&nbsp;&nbsp;<input  onchange='if(this.value!="" && Number(this.value)>1) {this.value=this.value-1; document.getElementById("Next").click();}' 
					min="0" type="number" id="nLinha" name="nLinha" style="width: 60px;" pattern="[0-9]{5}" title="Número do Registo" placeholder="00000">&nbsp;&nbsp;&nbsp;de&nbsp;
		<label id="tLinha">0</label>
	</div>
	<br/>
<%
String j=Gestor.temCertificado(numero);
if(j.compareTo("0")!=0) {%>
	<a id="certificado" href="Certificado.jsp">Certificado de Habilitações</a>&nbsp;<label id="j">(<%=j%>)</label>&nbsp;&nbsp;
<%}%>
<%
String i=Gestor.temInscricoes(numero);
if(i.compareTo("0")!=0) {%>
	<a id="inscricoes" href="Inscricoes.jsp">Inscricões</a>&nbsp;<label id="i">(<%=i%>)</label>
<%} else 
if(numero!=null && numero.length()!=0)
{%>
	<a id="inscrever" href="Inscrever.jsp?Numero=<%=numero%>">Inscrição?</a>
<%}%>
<br>
</div>
<fieldset style="width: 95%; margin: auto; border: 2px solid #0000FF;">
	<legend>&nbsp;&nbsp;Dados do estudante:&nbsp;&nbsp;</legend>
<!-- consultar http://html5pattern.com -->
<br>
<label for="Numero" title="Número do estudante" >Número: </label><input maxlength="5" size="6" min="1" max="99999" type="number" id="Numero" name="Numero" pattern="[0-9]{5}" 
		title="Número até cinco digitos." placeholder="00000">
		<button formnovalidate="formnovalidate" title="Procura pelo número" id="ProcurarNumero" 
		onclick="document.getElementById('Comando').value='S';"><img id="iProcurarNumero" style="width:12px;height:12px;"> Procurar</button>
&nbsp;&nbsp;<label for="Data">Nascido: </label>
	<input  onchange="idadeHoje();" type="date" id="Data" name="Data" title="Data de nascimento" min="1900-01-01" max="<%=today%>">
	<label id="age" title="Idade do estudante"></label>
<br/>
<br/>
<label for="Nome" title="Nome completo do estudante">Nome: </label>
	<input onblur="chkNome(aluno.Numero.value, this.value);" maxlength="100" size="75" type="text" id="Nome" name="Nome" pattern="[a-zA-Z '\x22ÂÁÉÍÓÚàáãâéêíóõôúçñ\-]{5,100}" title="Nome completo" placeholder="Nome completo ou %padrão% de procura">
	  <button formnovalidate="formnovalidate" title="Procura por parte do nome" id="ProcurarNome" name="Procurar2" 
	  onclick="Comando.value='N';"><img id="iProcurarNome" style="width:12px;height:12px;"> Procurar</button>
	  <div id="msgParecido" style="display:none"><label id="parecido"></label></div>
<br/>
<br/>
<fieldset title="Género do estudante" style="margin-right: auto; margin-left: auto; text-align: center; width: 250px;">      
        <legend>&nbsp;&nbsp;Género:&nbsp;&nbsp;</legend>
		<input type="radio" id="GeneroM" name="Genero" value="M" checked="checked" title="Género Masculino">
		<label for="GeneroM">Masculino</label>&nbsp;&nbsp;
		<input type="radio" id="GeneroF" name="Genero" value="F" title="Género Feminino">
		<label for="GeneroF">Feminino</label>
</fieldset>
<br/>
<br/>
<input type="hidden" id="Comando" name="Comando" value="<%=comando%>">
<input type="hidden" id="NumeroOld" name="NumeroOld" value="<%=numero%>">
<input type="hidden" id="NomeOld" name="NomeOld" value="<%=nome%>">
<input type="hidden" id="GeneroOld" name="GeneroOld" value="<%=genero%>">
<input type="hidden" id="DataOld" name="DataOld" value="<%=nascido%>">
<input type="hidden" id="FotoBase64" name="FotoBase64" value="">
<%String title=nascido!=null && nascido.compareTo("")!=0 ? Data.saber(nascido):"Sem fotografia!"; %>
<button formnovalidate="formnovalidate" title="Procura pela fotografia" id="ProcurarFoto" 
		onclick="Comando.value='K';"><img id="iProcurarFoto" style="width:12px;height:12px;"> Procurar</button>
<div id="drop-region" title="Drag & Drop foto or click to select">
	<div id="image-preview">
		 <img 		onclick="trocaSlide();"    oncontextmenu="trocaSlide();" id="img" src='<%="FotoDown?numero="+numero%>' title="<%=title%>"/>
		 <canvas 	onclick="trocaSlide();"    oncontextmenu="trocaSlide();" title="QRCode com dados do estudante!" 
		 	style="display:none; width: 80%; height: 80%; text-align: center; margin: auto;" id="qrcode"></canvas>
	</div>
	<input type="file" id="fotoInput" name="fotoInput" style="display:none"/>
	<script>document.getElementById("drop-region").addEventListener("contextmenu", (e) => {e.preventDefault()});</script>
</div>
<br>
</fieldset>

</form>
<script>
//Verifica se já existe algum nome semelhante possivelmente duplicado 
function chkNome(numero, nome) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
	document.getElementById("msgParecido").style.display = "none";
	if(this.responseText!="?") {
		document.getElementById("parecido").innerHTML=this.responseText;
		document.getElementById("msgParecido").style.display = "block";
	}
  }
  xhttp.open("GET", "chkNome?Numero="+numero+"&Nome="+nome);
  xhttp.send();
}
//determina a idade hoje
function idade(nascimento, hoje) {
    var diferencaAnos = hoje.getFullYear() - nascimento.getFullYear();
    if ( new Date(hoje.getFullYear(), hoje.getMonth(), hoje.getDate()) < 
         new Date(hoje.getFullYear(), nascimento.getMonth(), nascimento.getDate()) )
        diferencaAnos--;
    return diferencaAnos;
}

function idadeHoje() {
	Anos=idade(new Date(document.getElementById('Data').value), new Date('<%=today%>'));
	if(!isNaN(Anos))
		document.getElementById('age').innerHTML="["+Anos+"]";
}

<%if (comando.compareTo("D") != 0) {%>
	aluno.Numero.value='<%=numero%>';
	aluno.Nome.value="<%=Consola.proper(nome)%>";
	aluno.Nome.title="Nome original: <%=nome%> ";
	var QRMsg = aluno.Nome.value+": "+"<%=title%>";
	aluno.Data.value = '<%=nascido%>';
	idadeHoje();  					// atualiza a idade
	var qrcode = new QRious({		// atializa o qrcode
		  element: document.getElementById("qrcode"),
		  background: '#ffffff',
		  backgroundAlpha: 1,
		  foreground: '#5868bf',
		  foregroundAlpha: 1,
		  level: 'H',
		  padding: 5,
		  size: 256,
		  value: QRMsg
		});
	timer.start();
	<%if (genero.compareTo("F") == 0) {%>
		document.getElementById("GeneroF").checked=true;
	<%}%>
	if(aluno.Numero.value!="") {
		if(document.getElementById("certificado")!=null)
			document.getElementById("certificado").href+="?Numero="+aluno.Numero.value;
		if(document.getElementById("inscricoes")!=null)
			document.getElementById("inscricoes").href+="?Numero="+aluno.Numero.value;
	}
	aluno.nLinha.value = "<%=nlinha%>";
	<%if(tlinha>0) {%>
		aluno.nLinha.max="<%=tlinha%>";
		show(document.getElementById("conta"));
		window.setTimeout(() => aluno.nLinha.focus(), 0);
		// document.getElementById("nLinha").focus(); // não funciona
	<%} else {%>
		window.setTimeout(() => aluno.ProcurarNome.focus(), 0);
		hide(document.getElementById("conta"));
	<%}%>
	document.getElementById("tLinha").innerHTML = '<%=tlinha%>';
<%} else {%>
		document.getElementById('Limpar').click();
	<%}%>

if(aluno.nLinha.value!="" && aluno.nLinha.value!=0) {	
	if (Number(aluno.nLinha.value) >= <%=tlinha%>)
		aluno.Next.disabled = true;					//	hide(aluno.Next);  
	else
		aluno.Next.disabled = false;				//  show(aluno.Next,"inline");  	 
	
	if (Number(aluno.nLinha.value) <= 1)
		aluno.Previous.disabled = true;				//  hide(aluno.Previous);
	else
		aluno.Previous.disabled = false; 			// show(aluno.Previous,"inline"); 	
}	

document.getElementById('iNovo').src="data:image/png;base64,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";
document.getElementById('iAlterar').src="data:image/png;base64,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";
document.getElementById('iApagar').src="data:image/png;base64,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";
document.getElementById('iLimpar').src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEYAAABGCAYAAABxLuKEAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAABxBSURBVHhe7XwJmJTVme5b21/72tXdBb3QG9000LKJgILsAm4Y95hoJteZ3DExbpMJUYdxjYxKvOL1euONZtxN3FAUQXZkFWSVbqCBpvem19r3bd7zVxEVSEQjNM8z99NjV3Wd//znvOf73u/9zl+tIk3D/7eT7JwFprenCw216xH0exBP6zBqwhw4nc7sp2felNmf55y1Nx1Afq4FOlUShkQnjny+GC3NDdlPz7ydk8AEgyEYNAkE/H4EfV7odAbkOsyIhwPZHmfezklgwiEPEvEAgl4fErEIgZHg9keRW1Ce7XHm7ZwEpuVoHVSKNPy+XqiUSkiSBjqzC2aTMdvjzNs5B0yv2w2zlIDf45HDyGjQ87dpmPPOnrcIO+eAiTOM4pEgfL4+pJNx6PU69PriKCj+bw7M0UNfIJ2Kw+/ug0alglajgSmnhCGlyPY4O3ZOARMIBuEwpuFlOIUDPoaRjoAAOkdptsfZs3MKmM62BiSZhbx9PQDDyGQ0oLEzgIqKimyPs2fnFDDtjXWIRsPwebqhlSSoGEpl1WOzn55dO2eA8fj8sBtS8PR2IeL3wcTUrFZLUJqLsj3Orp0zwLQcqeVkkujr7oRSmYbFaESHO4GysrPPL8LOCWBEFZsMdsHr8VK7uMktJqg1ahRUjsp06Ac7J4DxUswh7qN2YSlA8rVaLFBoDLC7Bmd7nH07J4A5VLuDZKuCj/yipfy3EBhfTAvXgAHZHmff+h2YSCQKrSIAj7cPfq8bFquV2UiNAeX9F0bC+h2YaDiAZMQLXx9LgEQMNqsNcYUONldJtkf/WL8Dc2DfdqblNDw9XdDr9CReIxIa+1k9rTuV9Ssw4kDKqKbSdTMb+T2w220MIw1c5SOyPfrP+hUYv7cHsZCPKdoDhSINW04OAtDDaS9g/k5le32/lmQ9djrWr8A0Hf6CYaRAIOCl0jXDbHcg1tyLvXfcgY0//CECR45ke34/VrdwITbeeCM+u/12xL8BoH4Dxh8IwqpLwuf1IRIKwWrLYRWdg4bXlsAweTLilZX4eNwFCDc1Zq/4+6x23jzseOopWK+5DgGDgWOPo/sks5+ebP0GjLevHeFgRtQpFUqYHQ501LfDtvcg1J4WSJ5OaOMpfDK8BsHGo9mrvpvVPvAA6p9+GuZYHNrYMWiortPNLVg2eDDSqVOHbL8Bc3j/bsQTcYRYMEp6PXRmK7pXbIG1PAdDpkxCzdypkBxaQKPFmvET4DuwP3vlt7O6hx7CQYYQdEYUTD8P1VNnoXxcJZRaJaJuD1aOHIkEPfZE6xdg/P4gjJo4vF4vopEI9AYTUioJyUMHMOmxBdDsbIAlasGEFxdBY1YhHktg/SWz4K2tzY5welb78MPYT1DSkg6umTUY+6sHgKWfomDweIx6/NdIq4BAUwvWTpmCOOfyVeuXJ5EHavegt2UXOtuaEKLidRUUIBxNYKY2D+qOEJLxGJBIQBo2HD5rAGt/+AskIgpoTAZM+eQTWKursyP9ddtHTxGgKCQt8sdXYNLjTyO+bDNSrOBFxtNeOAGtRzZi692PI51WwDqkCtNWrYLabJavP6vAiDvVH6pHw/bFiDG23b29kJQKOAa44AioMOpYFBFO/S8Wi0FfMxIBB8G56U6wvoRKUmPWls0wl5ZlO51su+bPx0ESrYKeMvDCwZj45P9G6N0V9EoFV5w9O+bY5qlT0Vy/Glt/9TQnp4CprBRztm1jAas5u6Ek5vTb22ahriUKFf1YHe1FmjuYFJM62IFQNMKwiX3ZeI13+1Zoj2kx7bVnoLGoEI4l8XbNefD+lVS+hdlnzxNPIkVuKpxeg4sWPAXPGx8iQj6Lx9mOj81d6ln6MQaWTML4J+6GymKAv7ERH5JzhJ1Vj1n99nNoO7gJChaJe4+44Sw5D/q4j8Rrww96U0gpUvLZzImWikZhGjEKifwUVvziN3C7Ewy3CG7avh2OqqpsL2D9/ffjC3qKVmtA9ZzRGHvHr+H5aD1STMuKUzxlSDNcVUYL8u65GWuuuBI9dZ0UgH5c3dx89jwmRfy7evpgt5lhtZhw+fTRGKpuQ1dzLeobD2J3yIsk02mMu3piSyiVcH++HenWBGYsehQquwY+esRLF1+Mzr175fFXMXw2L1qEMEEpmz0SY267C91L1rFIDSOeTJw0ZpRgx8k1ubdcjc9+/j/RVXcM8UgIJTffDC0V+Bn3mCS5JOTpxoolr2EfdcpFo0qQ9jUD7h60trfDMrAQRrsdtrojKDVWw98X4O7ywuNccNw4zRSBs4yiqxep8Z+33U+RmIQ9x45CZpUDb71NAFUYPbkKc/51PjreXUVPi9A7mXpOMKFdWIGg6OZrsef/PY76xduQYmVfev31mPjCC3KfMwpM69Fa7FnzBvo6GhEOBRn3JnTGHKgoH4xYXwPybUrEw35EoimEFy7GnN9ch2iXAcHeIJSCKE8wMdFkNAbb6NFQVkh49p/mIxpTQJFKkrIVOO+CEtz48GNoePF9ZrUYxzhFQHC5aXpK4ZUzcXDln7Hv5bV05zjKbrgek158MdvpDAJTv2cjPvrDfAwach6ceflwWs1IJqLo7e3CmqVr4TEWQ7K4UFFRhPSmz2Bdug6wGTD1rssRa9PC3+M79cJocWof6/ljoR0iYdHPHobfl8CYiWX40SOP4uCzb0OZTkDJ8DvRxEJTkTiKr5iEI5uWY++r6+hVYZQTlCkvv5zplLUzAkzt9pV4/7n7MXnuDbCbTQi6u9DHmqixrRelRblwU8g5igfB7fPjYEsPARiIYcs/hbe7m2QoYfIvZiHZpYe3zQOV+uQFioQeCkfgHDMG2ioJO5cswfSf/hL7/7AEaoKiJign+luaBJyKJ1B8yWjUb/0Ude9uQzoWQsVNN2HyVzzluH3vwDQd3IW3n/kX1IybCCdJLBZ0M1WmUFvfglybCXmuPHTv2w2F1cFSQIKkUaM7pMItdz+FlwcORDISg9ZuwISfTga6dfA0u6HUfB0ceefZwgwr58hhyLtgKA6/uRyKcAjqLKfIwMhhQ0CYnrX5hSi6ZBT2ffQO6pftYUiGUXr11Zh+gqcct1P76nc0b18XVr7+BFxFJfLDeI0iiWAkwfQaZCGbQn6eA0ZW0WlyQoKZIkXAolFmHU+7fP21n38Ojd2KcF8QW17aAEV+FGaXAYkgZR8Xd7yls03L1bt37kX9H95FmpJeQRDSzDYpkYl8Pi4+CkNJCVxXXYvKn1+KLz75AAcISoKkXEai/WugCPtegVn75ydJsgG4BhawYlYgwAJRRRJtbO1ExaA8OUVGqRPEV8j0RhPBSlD5kw+4wMbD+2Gkx1y5YgW0TgcJ2I8NL66DVMHKO1dPfRH5CyCiCeWq4HhqoUWYZhWRMFIej/yZzuXCgMsvR/GttyKiVCPSsRqfLfwtaj/YkQXlOkw7Rfh81b43YHZ++j6O1O5EEaV6NBqCxaSHLxBAZ7dbfq0hkYo06e/plENBEGuKalQAJ8BJRDMHR9bycly5fDkkmwVhdwirFq2CcbQRJoKT8AdkbxAtzUYpS6JNcywVzBR6xf/wUxT+5CdQFRbiyJIPsf6Wf4DS8xm6246h9pNGEm0QpdcwfL4BFGHfC8ckuOA/3ncVPFEFqitLoWIY5VNfdPX24WhrD4oG5MhfHVOoNYi2NaOb3JCbm0cwwpC0GrS19+Kq2xdiQNGX9U+gtRVvjB1LdZqCyqDB7H+ZjWiDBv52t7ydapMZSqtFLgAT8SiCLBE8rL5jbnKSWs28zrncOgE9LCF2vbGTIRZEOUGZ/cor2Tv8bftegNm87HW89YfHUTP6fOQ6jCTYAvjIN1EWsn5/GDYrQ4ELFJqtu+4LmMsGy9UzRQzUOh26ur249ZG36D1fd+AUPeJ5hpdCpSEYSsz5t+loeX4zgu0+WQTKU2cTRCuEnEIAwn6pMHXJj85HZyKJna9uh1oCSi65BHNefz0z8GnY3x1KUcb3euqQ3LIRcNm18mmcKpVAiNlFQSTMRi0xYGZIJ4kDSZHXaJiJouQCoTeIF9RG50mgCNv++OOyco5x10unVLAkYCh5oqyFJPlrIjqtFloCKw66JL7XEBRCyPGV8G5rYhLIhbHIzgymRPOGDfAcPpwZ+DTs7wZm+/KXsGXVe0jrnXCnnPQOK3w+N/WHJHNImiCJlJkgAhG6uWS1I+QLQKtWyA8CYhRrFcPPz472pW1++GFs/o//QIJVeOWsYRhekY/2V7dBxXEkAi4DcLzRa75sgJYgh450I/jhHkz9H5Ogy7WS9EN4k6VDz2kedv1dwPQeY5n+pz/i/DEjUajpRN3BQ/iiUwtmW4oshgJluahs0+kUApxYKsI6SEO/ZhUtvjkVJT/EYyd/f1eA8tmTT0KpM6JsWjVG1xSg44+boE5y4SRrNelbzQBi8MhNyDnxU/xOIz5jbOkkNcKHOhF+dwdm3j4DksOCWCiCty+9lFV0XfZOf92+MzAp7syHLzyEVncUY6qLYNRrMX3sIKS692L7QTcO9lJ/QMfQYh3EEFLRe4JhplfeUU1y9gVZ3ZJmdAYjJIM9Oyqw4YEHsPmJJ5CWDCieOAQTL6pCGzOTiiBKvFji4sXhlppN6D5RUjHfyd/V08i/4+cCIHqVRHAiBCfy8kZceu9caCgwI/4g/kS+6Tt0KHvHU9t3BmbDe89i7bqNmHFhDdNykMSnhVmvw8B8GyYMMcLXugOf7uvG3k4jPEk7lEmmZm6l+JY30wgCsRTDLA6rwwlrTr485rr77pNBUUh6lE0fjimTh6BtwRJoJIpFoiBS+/GmZhP1kIKg6MljQtwJPaQiIDJofC04R9IxEx7tQvL3q3HF/Osg5VgQDYXx0vjx8P6NRzPfCZiG2q345L2XUVlVQYJNkT/iGFRciObmZnn3xXf+h5UNxEXlauiCh7Bj9x5sb1PjqLoSHVEqW4WFHkNQTBLLBRWc+QPw6YMPYMtTv4PKYsXgy8dg4uhSdD21FGqzDiq9GkpJxeyigorpXUmgwNdK8lfuLdMRf/BGOEcwHIXYU7MP3UfNJvhHIkASNyPa2AX8fhWunHcj9ANz5VPD/zt0GLyc86nsW6frOLnhuXnXyNolR8RtLIFBFHXiGwtJtRUhf1+GdDmqcOVjPV4YuNuhjnb4DTb4wymkVEYcbOxARdUQFA4qw0UqA1Y/9KDMKZWzz8f4sjz4XltHKcJVZYtIeZLiPf9NMY7TzHrOWy7BU+09WLWlDo/8dBZGr9sHz84DUBEIpSimRLxznir+FG8RjsFYVYzoj+fgo+feQaDlGL1OgVu3bIFj8Ne/pPStPeY/H/tn2MwaDCpwor3LS3DMfK9DJCXJ5YCfZUCCpT0h52pS6PUGoElEIbHKrizOxZhKthIJLn0ME8oI0pbV2Ljof7FGsqH8sgswtqoA/sWbkdRroGClrWAoiKYUXqNl6IgQopfm3jIbv3ezbFi/GzqC9OSrq/HFrPFwjKyCklJAfGFahJTEcBJkLDKZCKv4wSaY3lyBK+78CT0nX67hXpo2DV0nEPK3AubjV56EPtWDggF5OHC0E7msgouKy9DWfFTWJK1tbdCpKLI4ERHvve6A7C3iUajWoM/wAz/o8oRQWpST+WZmH+spkxaFU0dhXE0FAh9sQoJhomCYQcexCAbzLzlMgKKUx7VePROvsDjdsHwrivhxuZYh6/Pjsd8vRv21s2EbOlgGRwDCWxIggiNSOZeroQZK1DXA+vL7uHr+XZByHYiRI1+fPZvi80twThuYLctfR9f+lSgoGIgut08OkSGDS6kP3HRzBbq7u2E366n4UtAZNayuVWjtcsOVY4KCoaU1GwmKkuJMjaa2PhTmWxmWgp9icE04D+MuGA7/2yuREmAYCAq5AhSCQtHKJMumpFA0zZ2Jt3m/Fe+vRj6vnT11Mh59+UVUcnwda6n5T76IxluugbW6AiqWHoKE1TIhExS+lnWPDM5hOBa9gOt/9wDUdgvUegM2L1wIb0uLvN7TAmbbij/h8KevoLS0hGlZjfdX7cVFYyq44xb0dHXCwBv5RfwqVNAa1ZmswN31EEC7xSg/Q7JYDBR6CeFM8PhDcNqMSMdTcI6qxphhgxH581JAZBcCKgpM0UR9JThAnLBoqHdM116Od1gmrHzvE+Tx/cyZM/DjJxbCVTUc9//5TVQQUF0ghHsfeQaHbr4OtpHDoKZ2Ed4iCc7jzQl5JpXrtEjWH0Xeo4tw88KHUXHpbLmkeOeGG8SSvxmYrcvfwNEtr6OiQpyxqLBm22GYTTpUlZeg7VAT9AYdWlnrlA6wIxGKQ2+WoKdXbNvXxAUXQcGFqIRs50ITDCkDPUIQs/gZIzD2wgFQHOsUWUB+xCG8Q0xKBkSUF+yrIgj6667Cux4vNn68BjkEeNolM/Cjhb+jivaxeWBxDcAjH3+MMuopDUPj0QXPYO/Vl8Eyfgw0oRDBFSTMsTg2fTLjRSK7HWlCLu+ZTsaYvpsQ6OpiaAX+NjCfrXgLrbs/QHlJgVz3pEimr364AzfMGYXe1hBHFyRHN+fOJjwxmPMMMoeIROf2+DGoMJdEHKEX6eUjB0F0QnkQI/kPKPzkoLb1W9Fgs0E1YUzmkEmgxnsJ9EQuEWcu0nVzsaSnF5+v3QQL9dDFDJ8bH1uAgNvDpMPV8pJ4OAJ9Tg4e+ehDlJC74n0eLHrqeey+YjaM48dCEQxzRXJuyoxNdSnUcvqZBXjzJUbEspXoq6/HhffcA8lkOhEYXiAmRtux+l107F+NChZhgkPMdNPfvboBl1F0STEVgr5jsNiN6Orzo8BpocQntxgy3NLS0YsiepAg2zDFlJ2KUzz9EyKtsaMPVYNyoSJ/RDwkXqb7hk+3oCnPCe3oEeQj1lYi3jgPBYGU5s7BKgKwc/1maONRXDh5Mq75939HJMiCMiW+35IFkpYgiLaiYjzw3nsodTjg6+jEc48/i33XXwUjyxZWtnIop8lVQg/ht/fjrfc+QgvHDnR0YNydd2Lsz38uj5UFRgDCCpiTEvfYs24xOo7uQb5VpEal7PY79rdhF9uNM0Yg4EvDWWRGkjfQk3N8TQHklZLA6ApJ7sTWPY244LxBYm2yp0gMLfHQ3sh0eZBCa9zwQlmL5A0ZBktJMXcvjkMfr0JzWRHUI4bLp3Mi1atmTsHmeAy7Vq2Hhp4ybtIkXDXvNwQgJi9OXiUnLJMzs6FSxXTM++RXDsdD7y9GcQ7B6ezCc/MXoOFnt0DPsdOs2dTkxPS99+Dd1evRyrGT0Qim/fZRjL/rrgwcNKUo8FLiiJGTE5PZteYddLQdhkWflO8r0QPinMSDz6/CQ7fPRNcRLwqq81kHpuD2h2GRtDK8OgKUZPZp7fSgwGVnYhEkzAEIrOCcZnpKHj3MQm1iYXqOcQF2VxFG/9PPYHTl8dZp7H9/GVrLBkEaWQP1lEnYSWR3L1stlxOjL5yAufPmMYslMp4iCFop7sEkrJJYf2mhZFmiZpGaIJjOsio8vHQZnEYjggyr5+6ej5Zf/iMM5JzkvDuweMNmNC5dgRh114wFCzD+zi9BEaYUNxGSXoEkdqx5C91dHbBZLcKJ4KCW0HOXH3x+NS4eU4Jh3IG8yiLEg93o88co7LToqOtD+cg8hkqC4ZRApyeM6pK8zG5ygmmmXT3BTTAsRCsvyJG1iJfCT2+2iq3BuLvvgTmf1/DzuiVLcaS6HLsJat0naxgfMYycNBFX3nu/HI5iXsrjYEg6Nj09gIDwtYagKGXPEQTPjFdWjoU7d8LKDCS+oPTC7fPQOe8ubNy7H0c+WIaY14vLnn1WDqETTSnOSkTbtfY9ekYaFcNGynWEU90n7+4rS3eh2x3Er2+6GH7GqNGqY7rNgJLyJWHLNchCyk0VmmM34XBTF2oG58vCSpzuG6htOnsDyLHoKUsUyM8RBE0aVHJR1CjiWY8oIS78za9hzMtFymHF/g2b0LRzl0zqQy+6CJfOuxcxcpVCZCkuXq3VMzw5npb31gpAKB7Fn/AwlBRKoXsUcl9hptxcPLF/P0ySBDNb75sfwu4NUTuqMOvpp3H+bbfJ/U40hlKaIRDDoOoxGFxzPtR0RynYCK06hc17mrBiy2E886+XobW+F8XDS9Ha2sFQkKhd1Giv96CsxonWdjdKCp3Ye7gDIypdMk9pGEc+lvjOHDN6PEFYCaTEyeRYDfQYEqvWSmDUcqYTxZ94oD/2l7dD58pksiS5oHzCOMy851dyxlExVAQQGq2RoPCnTvyFilYGSpzxCgEoXDHDw/J//mJ6Zr376DkulwvJUBDRgB+zHnsM4++4I9vjZFMkYpG0OCxKMY/HoyH5ib/f04O4pxmr167F8AFxRDuSyCk0IWHOQdTLUiBHjyO7e+i+SuSWmgmMFzUE5Jk3tuAH04ZS1NErCMzOrXUYe+FQLNtYj6FluSgrIBl6IrDYtNjVImH4BZNkXhNSQEG+UJGvxOONpk2bqJ4tGHzJbIInFi64gyDwc41aJ3uGqKLTwjuEZxCHDBRfB+REC7BkqX/tNeSPGYOCGTOyvz21KUU8qsUNuRM6ow0GSw4crmKobcWYWJNHcZRCNz3CUlQAX08HBjoNZPEU2knCJdUO1Df5UFXiRDe9Qux+Yb6FoZKWU7XgSCMr3aYOlgbif0GQSMHXK/SPjoviLnMdGXkgVia/gY5quuYH12PoZXMJhggZE4ndDC2bxOpbJXhFw5ARXEJQxGWENTPGN5ipoACjSeDfBIowUYRwEdwBuqTsqmISBisnQ5d1DkVYX4CiccNwtMUDG+V+lG6/Z20jyoZb0RXWI4dK18BKeO22BswcP1hOw3L6FD8JTpQZrdcbhiP7pCAaTsAbpN5wOOVULi+L/cUc1JoMXyiV4u8htdRFVkj0HEnPsBF8Qs8Rf5lCFyIgApTTA+S72FfOY4SW4U3kx6dxJoMwIuEgYz+cCTHRyAORUB/atq6HvcCIjp4IKm19MFvMuO//rML9/zid0xSKVYGgN4hWpmiNxYTtX7Tix1eMRNMhN/SsnDsiMZRfQI+gJFerxaYIImXZQI8QnqsRmYaeITZLkKoAjmqFsxUccmaAONFOOqgSb8WzZfH4NMV0myT3yK8JVpJcJNKgWHo0HILn2FHh/Yh7G9HW3IghuVG4kzaCG0G88xhiDNEd9Z0Y5DKjYshQ7Fu5FxNnFWPH0SSqx82CVifINJNdZFBEExnmOCBMX5nscvYAOW6ZnPYVk2OWOyR2UqPTM6ws0JN79CRegy0fRlsejJZcpulCFA0ZhwFlNRhYMxvnTbkRYUsNTGVToM4bhWNdftitkiz4ivIsiCkcwikZXkpE0nqYbE7oTQ6mcyd5ja85vriXAEdwnsg0JEAZmLMNirCTgDm+O7L7Mp4z/ENypmtL3GFJ5iAziZo8ZLJR1+TCZHXCmleMolFzkVdQjsKq8bAOmwp9XiXBSMCc44JSm4u8QireFMfU58DqcPFaAmJxQMtxJKbfjLdkiPVM8sfp2Lc48xXdMhOVXzGkRCUsCFQeQtRaItxEeUGFKsSZ+N8QdLc3wGSx8b0KnoaN6Gk9gJxRN6NqaA0HUTFkhIpVZQlVsFP/AnLcvvVh+NctQ9hiQfJxQRYoUXulUgRJlAR8L8ASHqA12rF/22qMmDgn+zs6rAgX8U//Y/EVA/4LX5ZH7IldiAEAAAAASUVORK5CYII=";
document.getElementById('iNext').src="data:image/png;base64,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";
document.getElementById('iPrevious').src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEYAAABGCAIAAAD+THXTAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAEnQAABJ0Ad5mH3gAACJgSURBVGhD3Zt3kx3nld47h5smD2aAGeTAAIIEAwiREsWglUgtpbWkrV3KXrvKuy77P9vlT6Cv4Q+wVa5aWyXVWpZsa8UsUmKQQJAAkYg0GAATbuwc93feewGSaxVK/3obPT1979x+3/c54TnP6b7Q67rW/nltAqmqqsmr/883wzA4/mFItVbrmq5O1C9t7Ep1emcbv+ByXT6q84Gq1rKySvOCPa/qoqyLqiqKUkYfX69rlmmwm4Zhm7prma5tebyWwb44A+fMqAYev5LfkzV8Yd7Jp+9u94JU1qWuG7puVpwYAKzrkgFtBqx5qZdapRm6DFAWuSVjG1Wth7VxrRdcur19YX1zbZRvB0lvGN3sDtNC0PIhx6gXplvzU82pprer4+xfmD60NHdkca5pagzFIirAGfzO6zqra8fQbUYuy9o0i1qvSgHlMJ1WY6ncNO1/gupekCqMjhUqsFVY1LhjpBKL1ZoJVC6sKq7F7Dd7o4u3emfXty9uh7fCtJ+WUVEnJSaWS8uqti2LEz6c57laRF2WpW0WTcuYsq0Fxzq40Dm8PH1458zOuaZr6CYeAJqyXFVXtmHxkiUyu/oj84qJzP/HTfeCxACsnQNLxxum+JvlCwiBpJm1YYRJvjGKrnbD0+vdM7f7F7aC7TgnpBqu2/Z927Z81/FcR0KLH9Pg4iTL06zgGCVpUmRxkkVJliXpbNPZPeMf2dE+ujxzcH5qZ6c97TrMWOpFqZUWi9eIF10ix2ARFU43WRGAvozpXpCMlJ8qd+pKtyTGqsqUuMDUkjO5VuZ5udaL3ru88eN3z5zvZYHpt2dn9+6Y3Tfjr7TseYdcYX4VsKxl7GacX1WcEtCcF4U+SIuNOFuLskvrWxtb3SoMD0/73zq675kjK/ctdBzHsGw+XRdFQZTXEhoGbmLVVlGZWUlg8lINPNnuCQnHYg+CthBLEOKEoiVDmmGhXxuVf3/6/HsXPru+1a1db8+u1d3zC0utZsPUyjKNizgqsmFeBGkexFmQFpIHQiKapVcNx2z5dstzO57XsqyGabiWxZhbSXljEH22diMLhnO+c2zv6rcfOfTAQmvWlWzKJGhqVlVXhsmGh8gwcE7WO9nuBanQClaAEYzKkqzRYa0CPFtReWqt9/NTl8/0kqQqp3xrdWFqrtNwbCMvimEYj5Iiyoo4K9MiT3IVZgVprRJR06A2Fwy26TkWIenbZtM2W47Zafq+52mWtTUMb2z0NvsRSXffrPPs4Z1fPbRzdcbD2ZLbBLxkAqlWlXpt1gTkH+2lVC9YhYVJdFulZQkXb4TFB2tbb5xbe+PM1c7s0u7lHbsXpqc9LYgGm6PhehDeHiVhChfpWmkwqSYUJVBkfE4k5QkULCw5wUdYAjnmW+aOtrc83VieabZbrSjXbm6Hl9Y2upu37luaeu6BPc8c3LXccj0b45rgqiVmy8LQnMpS7P/5di9IMDV+Ifo009SKyCyNOLF+embtv73z3vpw9MTRow8tLmDZfpadW7u5tt3rR1mKK3UjzsVDOgSSO0bJ6FizgODuQLJqg2XBLmZpl8xu1bZneNCPY2ktX98137h/99LqTNss8g+vdn977kIUDP/y5OPfO7Z/77xfamlle8pd5Cdr5PdkwePtXpBUBRBrFpxq+oW1rX/46PIvL21WrfbK/Mz9081RXtweBjf7g60oCbOsyAnVssgyLmMsKmxV2BIswprkNpvMLvQ7dhNzGxQDwrp0LEO3rNq0dNtuNbxZ31zueHsXZ5pm49ooO7/RG9y6/dy+2eeP7n7ivlU8xZV4iggQsvqSk+7tpVJ92tCyWr+wMXz9zOV/OH2p9Dqru1bm2s0qGl0ejW71Br0hFCBXS4gVJTwogYVFSpQDIU/IgYqhZGNYPsrv8UtOSAWJPt6xTOpbjaqwTNw11fB2zM3smZ7ym+0gqy5euWqlo2Mrc9+CMKhcpmRTTeCa4vkvbl+CRAKrxYgtxa1koVZRw7up/j9+8+lb569tRMnTDz/YcrztUXR6/fatKIiTpEYXpCIwClVB1LX8KiTYFBspVHIyHhk3GSKGFFUZlW4gR2womlJsmfypLPXScj3T8TXDWZx27lua2zs/zVreP3epSOJHds7/8Kljqx3LZ+USvYz5RT/hN0JYQaKWY2hKiTATs2rUktzU7H5Yv3b+5t++/kFh2Ccfvt9x87MbvYu3g96QGIvLPCvzss7LSq6WJXOQWqyg1UauAAHAwX9SoQ2xnYUnYD4+Yld4hlwd1y0dli1zWanpsEMcTkNvd5zV+daJ5cWwsj+5un7l+tp/+PqTzx5aXp1zSyOj3uo6UUsAMjFrLk3LmUBCdHDENzKxYOVl2U/qU1e3/+tP39CdxsKOxdml2euD3o3b25v9JMiNKk2gNqmjrFaJCsmb8fXKYuJnEYTkVaHcwgsRIgJcyqZWpFwuNiQHQWG7ju04lmnJQjTDtG3NrZuuPoewmJuf73SiJLmxsakFo798+vg3ju2b8VQQizYcjyzLJxaZWoJPFiFroZwKicj6NPvcza3/+/G5q9v9mXabrF3v9i/e7m/04yRKiwQ1g4tyoXb2EuurA6ZSO6p3MhiOK0slPiS3mFj0XZFmcZiNgnwwKHrdsrdVdrfz/iBVVVkkPCOUmWxxPhrm524P1rYH5MXyzPT6KHr7/OX3L63BkZKVIgHuVotJDAokbC1BIqKQVbCGKsy1t89c/sUHH+85sL8z3Rkl2We3trf6AZU0IcPiTJOZ0cMTCHIUX31ht2AYBFplV5ZF+DG1lKqMkC0weHekB0M/j6aNfNGppsvIGPaDzW4YRRQ2ErMq4irDcFWc6pvD5Pp20B2lnu3t2bf3d1du/P27vx9k0rwQV+ImiWi2MSLN/NGPflRqaF3CTdGTZmS68YvfnvnNxbVEM+/bu2c7zq73gu1RnEVRUkj7Y2fjMQSH4hYZDIsJS8rOK9afiJI3DPRZzfCERlGkg2E+HFVhDBGszNkvPH7/D7/5zJ89f3Juyo3z7GY/YjCLpViMmlKyKNnMgSLPoA5Kf1nONZwoS1C96JSVxemmZyNspEgYlvCd8pN46Y7HOKE8GqNc+/WnV/tBvDo3O0qzm8NgYziKQ8yGlbMa4+UEmySSYgMJUxW3Yq2JfBdeV56ndFhaVmRBEIx6w2oU+nm6b7bx0pMPvPLiU3/69LET9+98aN/8c8cPH13doaMNE1BBmJBLKYGQZ1WW1hTvNOmFwa3RKIrjmYbPsn956tItFif1dmJEtQ7ZJrlEqEjZ0PV+kp+5cvOzzT58Mt1orPdHG4NgFMTkT44IyAs9y4sqk3xR7DwZT0YEH78rkagCj1KLmKezzfM4SEf9MhrONe0H9yw8d/zA97/+8MtfO/7o4ZXFltUw8gNLs6tzxCDjo/Irofdcr+iMi1ze4X2akTjejsLtIPJpW2z3yvbo07WNjWFc4R81+11QAgnr8hY5nWv6lVvb//3nr2mm5TdaQVxuBOFwFOVJCt40z+ocP5IiiQwx9o+Mh0EkDsUuqvpBrqbp8uF0ECebPW0wcLNgzi9OHFv5qx88+9d//vzT9++cA4xeNcvKyUU0Ua5Ex2aalWhaRrxZ+KgkWQvNLCo7ybQ0i8qym2dpXnu2Ozs39dpvf//Rhaslkk1MOV6LbCrw2AhH00iq6uYw/OT67amGb7reepQPRmGeUoGIf0Q1wrpE8wABRpDgg5mE6iZDAoaYEU4v8nTYy0aDOgm0ZLCjUb3wyN7/+Bd/8i+ff+z43oVp37QdyqXlWo7p+XqzxWsuzzPcUZSmCA8xugxMtdIKsOS5AETjp2kvKXPdXp5tX93oX9kcBjQedBsmUmKyTXJJcYd+u9u9trmdWT6TZmW5GcdRUsHVeV6RRJWEAKfQnFwvQYZ3lIfVUPIWnJ4TI2GURGGZjjp28dihpZeeevA7Tx97/vjhY3t37pxqNwGEUySn0XkWBRJZLT256N680ihYGUmIszFeVTMztE4c1lpaZnE1jLO4yHwbXzrrvfDK+i2SWuw8WYSCxI+sD3l6/ealG7fnFnZQCxE8wzimb4ELpPaUDEo8EOBglLsD4poxmnE2EXro1yROwROErl4sdexj++a+9+zxV7558oUnHtg932l79Aj0VrZeiQKk0rIXRJhwAskrmqiGhcjVCSQCgPRFiUjLJyUgqaM0DfM4r6v29MzmMDx1/jI6AtPiFwE0gSStOCZyPl4bfnq9t2vK7dZWL6nLsNBoGiBuoqxKC3KNXig3RHErepCQEyYQCVXFUTnYqvpdbTRCAj2x5P3b54//l1defvHEQ/sWplvgkDsYtG6y+pwVs1AqXFWYZWUWFiNXFfYzjcKmlyIAgSmWpw8hn8q4qhKglmVMBQ5yfaA155v2Rnf49oXNRG5OVDbsdRcSGwvcGgwHI1pS8s0M0jhMEqQ1WSM1VWPHvcwjSVRpJUQOndD8e3g3CrPBMKKnTSrHNB7cPffvXnr0L1569msnju9f3dnyaN6oNVCjzIURJP9UIipGEaWkliAkU/MOASjkTwdLcasIDPzP5NQftaMqKXBEd8ZwDBFE8WZ/SCiNx2eTX/iM8W9u9Shh1CtKU5TECWELpDJVe8blCngBNWIS8RCo0riKhsVoUISBVZS7F2a+cnT/t5968OWvPnDy+IN7V5abHhil/hIX2EbWpjbOlJjCLBLToASRwsaugEnISYkbn7CrmBClhDFypFIckSmGiY/LGxvbcYrknWzKclUNl127vZ1kuW3bea0Lt1HHCngm1fLUKBCqBY2/gbTGxVrtMDE0MOiH3Y0yGkHHe+ZbLz528G9e/sor33zywMrSbNuzDdadKgZEvFQyZM5icgqVIKFg8ypLMxQj5QEpONbVyl2sG0YgStlJ27GSU+1xBT8leRqlcanrjitUefnGBiECNoVIQSLiet3++Ss3CDaCBPUIudGOOLrpG2bLdhq27eqGq176nCBboshKIqfK0c6rS1MvPnnoP/3g5J8+eXBlpg0tGkkaDbpBfzsaDWMq23DUl50SF/YHw16v1+91h4Q5fxjyM4iiCHwsRVoPy7Itg93VdU83ZNd0+idfM/3a8Grdq1mAbmbYCIaU9Z+7tr7Z7QdBqBApSK7DhebNfkAiwa6I1Iyiz04VwraoBjQ3R9g7y/MoTPrdctQ30mjet1949NArLzz2veceffLhI/t27YAIoDX6BNemPzWwuppFqp5p2RxUC0gwquadX/KObHxOyh0eVWHJnhP3453ywV4VMFVGuCMJqpJiGQsXymDXtwdpWVuOeIxNIPkN33K8zQAkFVNEecUn5IZ9UcqNq7zMkEAqLRNyLBxm4aDlGPuXZr7y4L7vP/PId756/OTRQ0sLc+1W0/cc17UYXXU/tsVw/GPj3LJNU46WbfNSmnI8Ihvvj2WzkCsb6SLnypI0GsqeyrAUPWhXbCvHFLaQTbs5iEoNaYD2uwNJ5LOmbwUxGFgBqonqllIRSDPdoDMopT8wKdNRPErjgWuVD96//4cvf/0//6uXXjx5bGVh0TZdir6lUznqiPnrQoqL4n6heal6LFc6LFGzmg49K/YcS1+pb1CAIg0BwyVsRlFZhfQocixqZJE6co5E0iySjIYPMquq28OYCs3KFSIFSdIRNsSX0v+UASyBBCrlVh72ZUr+KkyTxk5d7l9e+PNvPftX3zrxlWOHWp2ZlHrC+hELVNhCyB4TUg3jTAIjFcPSzQktIKsUcSEFcLhgU3WWmgAYqUBKwmBbqVnCjYZeUqUMFKxecM7qxy8NPVdHvCRloCr7McKPkQUPm0BiGsAkEKlyJOtgSLMq2dWdTVHwtCNalht5utRpPvPYscM7F2c8S4cWhe5Tup0oz8M4jhM2OCwnd8e7YjgSUuIFfMDjHUFVVhJFEmXiShY0PqqFIU0Epdp5UwyhZLI8flAfk3LJtXyYsE4qokOGkUsnXho7gQKnnm8wGYXexvVlAQ8T48h3B2koxbZwTX3HzAymjofDuN8NA36loxRBSVM0CkdBRMmNs4R2XoRuDtekAiOXCpmBNkuxGZlJVQOr2lW4qWXf3VFaCiU7NpWjwifnLJSVKPbCCaQqwORyPHsXEgVH7tlIe0y/lepMyEfUMOJCoklaR42MKmxvI8jf/v3Z7W5/GKS3evHaRrC9HQT9MBqEo340GqVBWIzCIgjjKCQaYzDSDUdxSqomOK2UO2VRUnKODyU+iZoipb9wKXd1YZWZXiZalUhhVTCFEFkoSkIKYy0ae5z+WEJag0yvY0NU4xiRghTFUZql6CQMIb4yIF/coruW4Vu6a8pTD8/SptoN33N7g8Gb7/72f71z6neXbwwItDTY3N68sblxq9vb7ve7/W63v90dctIHNHCUiBVgoxGtLY4cqWI1BG4IWD4AbqptIYw85kPZoWBLb1i1b1WewY74Kh29cOW8knM4C/XHgsvKtUzcz0ifQ5L77YbhSm3AUxK+6n25GTo2h4RmXdmeS3sTZOWZS9fePPXp6787+96nl69v9YM0TYucch5CEgnmIb2Aik8yiEYek+UF+SOxJyRBdUnrIiWvxvwmMc/JOFvksaahkldu7cntLNH6kjvqNlClXoqjZEm0WFxeVZ4UN/m0QqQgNVvtRrPVQCqTZ6ofymszq62kNGK0OE1sXkXEDOrfbaVOazMzLq5v/uq9j3/86nu/vXBzmOvUIUfBl1v4Ih85SCBAA9iISlDL3UepqlQqlIG6YazKknIINYrgkIynJEqOsVdJXsZkbFEnQl01HJCykkrPaj2r9JS9KNnhzoahN/1Gs936HBLTU89nG56p6RQTzmvDqnSrgv1JNN1ioSRkDCokS2PaX9hVeTOJ5t7qhv/7jff/7udvvv7BuX5cN/yGC+kzU66lCHlYW9QpPJEleKlUq5Rnm8LhQu/8sGF+dSdT4VekJwKW2kU/qBfyxJZGyqoMuzZsVlVyNJ3KtDEZxIKXZh3bx05KHE0g8S7OXe40WRDTmBCBBstVlk77yk7HV1h1YdRKmlAwqPutad3vZLrVj/OzV2+/9uG5//nW7987e21jmGAOi+osNyCJSKARg8JyEoQ5XUlJLQ6SMR8iqOWvKu5UvIunxd28JsagJLn5V9M/1SYRQHVV0hmbw83EAquF7HZNd0gnyptcP4ZEWBqmtjrXISjRxpZe0oVZyAYgwSSo71qemggqIBGAnDiO6TV0v2U0O71cO7u29avfnfvlh59+ePH62lYfopasIELyQioVwChgao+zghhGGcPvwJHn0PA9ekM4WhYkCc0ukNQNWk4UDCG6CU65azveyU7i4MDifMO1cbBcP4aEyxqes2/HHMwWRYFrafI0FLNA+RbuJvCkr8Yu8qxAtU1ZMqjN0pqa1qYX6lan8huBpr9/4cpPXnvnZ2/+5tLtrdpuOM2OZtqEnGBi5TQ5SRLSyCfyXI06xi444QyKokASJ9BGKLIGGH4hIeW5sRCGcIaJCCL8NAlCi1JJJ1ikyZGV5emmz5oVIgWJjc7z4MqOlueQAPAj+kueGZuWZrmyy0MNqq4Qn9Q7sQJ/zrQ8rPLY9hpue8prNOmQsDfM8XevfviTX7596tyVuDKn5hbdRpPL0BjCgrJTcrNI0aJA4gdSkjYbXGrmCgE0NrlQnwImYUfS64YtN2PV9zsAXxaZrdf3re7sNLw73bGChL7Os2S+05xpN13blrsDZUZGOZZumwa71CjZNQjEM2pXL3nHpnZppa+XTbNu2WbT85qtadNtx4V5c3N45rMbH565eOrshevrGzQoaEVmgsELtAQeiyNRTuK7lHQCIWxOgkuOs3KVObZWuTpVqKYQUY5cvXaN2jc1jjY5VmQM51jmVKu1PN0x6jKOos8hia3StOXaS7PT81MtptTL1NFLT62bsmuZOhgYzjdlAlsv5IsNUK+h+0xT567gt+3GtNWYsfwpx/V7Uf7JZ9fffP+jdz88fXV9I4ippPIEE09U8lQiGne4qq3NlLSRDAG4SDIVhNiUpTOyp9eOXtEjO+Ax5Vs7llYY9D1p3Gm4K0vz7QZyusREn0NqdqamWrPtlv/A7plDO1rd7iiX512i62Ht2LQj3Y4KI02NJKmjrAohdApFUcd5PcqqYaENCm1YlMMiC7U6sZ2s2QkNp1eaV4f5G2ev/+Stj9746PJmaHTmdrU704gSBG+p0ytAtExCJHgkUYJuIsdyjWHDNO0nxTAqorjIMi0qzUB3RqYXGl6sWUmtx3XVH4x2NO3H9y82p7xWe6rdmfscEt6mJyM2DuxZObJ3hbFhUspIlGQURpOyJWFMDimyR/BBrXcksRR2gkZEgKrkbKIDaqvZNEkh02Ht24Pwo/Of/eLtd1/98PdrvaHpY8JF1yWuNXbPIw1EerMSqjwzabqZy8iGuhtZRlLVqB9wNxrVyUsw0/nodRqtLsw8dN9BaTWxi3peJnDkIAkPl1ULs9MHV5ZWZ5qo2Ex1lExg6fScIgYquEdEEpIcbpdkZh+fKBQT4YzhqRW6ZRm2S6tpNZqpZtwehp9cWfvN6XMfnP3s/PXNXgyVOq1mo9Vqtan6dESYStVKgSbeE7pGHEEa6mGjNG8QBROiVCnWtCVL7caB5cWVpcU7SujLjAeJFkUBZe1emH7q6CFkIkoMTUG9AD1GgGyotVRfnXcle1XpkOkVMDmqpgAwWBrewsuQlOuZnXbVaJZuI9Pda7d6b73/yf95+8P3z12N0sJvtNozc36zHWdERM6KGFw8XwCIUsS68KNBHgvXMUmlUc3kKwlpViXxo4f2HFnd0YCgab4wwwSRemSmnCRf2uC3Z9tLCwvvnDq90euXhJ94G87DrRo6Htj4wTHIcqn3EzxqMEElm7KkuE2hJDroJtWdCNOwJDhrM0yL9c3u5q11OkbKS1hUZz797PT5Kze6Q8v2DdeTRgDJgtdgb/VNAMdtOH5Hs/0hlxSJXUTNMvn33/3GY4f3NBwCggnxDfEjKxBIkhi8IXaobcNo+d72YNQdDkBVmC4xLc+3HXvcuqsVCx5WLJepjaGUOgae7AAj+ASe0DGJogyOC2yHQ4kYjTNai/4wXN/uX7px8+Ll9Rtbg7CoG42O6dhMoJWFDCVPmnTb8R2vg2FiEalw1HBny/qTR+576cljO+dapAGNrfR20g4KpnHgjZcmMWkbetuxvvH4Q48f2NWh7S9owJFm4HJst+k4PgIOh4nmVhcou7BNwMg+9h6QalFoFgajby1Qz7XpuYbrGo5r2l5YWp9tBkTgux+dP7e22U9Kx2/Qv5BQ8rgJ6SJ4iB3bcVu65eVwbBoZZdw2s/uXp7//9RM7Z1rq62ssQd1Cu2NggcQrIlZEk4wn7nr4wOqTR/YcWWzbSc8o5L5IGGeW5VtkPNwCKlhQ+gUwyVgKCUtR4Ye4VE8mSCr5OlWeQIr0pDoZnSTQouk6jemO3ZnRGtOl0y7dZmY3zNbU1Pyc+hqE6FRJX8dyXM/xmpbTlNvwZU4tMqLewfnW144e+OqxQx1iTrleUZbKDbVJ4ImXFEIhYBCqrGq2mjQhn545S1vBMiFNyI+JiMKiKICuLAMeLhj7SrDd9Rp8wjtglYyQj9WUIrOSYspPLn+RaHYbDa8p68ZM8jyBlowolfaKMm+bbsOwG6ncOUn1MmpU4bJb/OC5k9/+2on5js8KoHxZs9hTCSa1HEUPRIisRVmZkJIypDddr91owJ+bvX6X4i/i1eKC8R3Su16WbQKJd1ioei1nyv9MgClkTkEnAaA6BCZSzYK8I18FQrlxiXQHUoaxHOGm8PhU5FhuViZWGSw65b946tEXTx4/vGdZvliqRK0Emiya8SdlQH7GqS6b0ogQOpDoQPbtWPg3f/btJ47sWWhoZhkWeSg6k47Mb5uOKzdNbXXTFJ+PbwNjt0kwjhlY7h2KxsTuws/yxafx/UeVzvAfiiiBlZVmVXGPkLBdx2vYrm+5Tdo+afLyxCiiWac6unv+lZeeP7p/j2PQF1Ip1EIlCFRESITJJmdU/PGL8SaxJ/amaNKlV59cvf7TV3/9t794dWC0Unu6cmYMt9WqI/pCWtM8kWdqUl7HBWX8BRwsKMYTa30+lWwqFGXnhD/IVKZuST7QsWFjzjyXgNQtM6gtWmE9C+xs2CmH33zigb/+3otH96w0HPXdUI3sYJYvbViV4x+AxIYNiC3+zl+HUXL++q23Tp398avvXu4lge5r/hQrkKDSEMWaIc9ssskzXdVaqlgDoeJ6CYnJJggEkDqK5+Qfv0RqUFxoAlwfMkWzSFCVaZ0GbhEtOtV3v/r4N04ce/TI3pZHkZTmks/IU8XJwJPtXpAYlyN2JuL5Y5JX69ujn/7qrTdPnz97Y2MjyrLGoma6ML58PZ02E3knD73xkmxC4HT14/LFy8/9NMGjfsmtfbm3wzoUZ6hH0WZe6+prRJUdbhFs+xc6J4/s/c6zTz24b6XlkcwoLhmeoS0x+5dA3ROSxD/WRdKrABGhY4al/rPXf/3TV19/69TpsLWvsJqyOEq741iYmdNSIgHepn2lAoqL72zjYSdYFChUoIFWlkcZ1Fb5NFmDnpDPaDp1rB3efHjvjheffuJff/fFjguBCJ2yUMUukheiy/4YSOPp5evtDCEmkUdvwnKGhfLvR+nFazfeeu+Dn/36k2ubwxRLNzqV4xeWUwp5EUVy8xnXwQMMwzsTNGpktVw5k4NpFup/IlDHJccR71SeLK6CvlVl8y3/2ycffubEww8d2T/fdn36Nk2efagnVOp/RMiav4SHjWaC4wTSXUPeOZFkEBmq7MKfoRfCt6yMURCv39r4+OKV0xevnLm8do6I1J3cbtRuA3pjQlH5MqeEusCSfTLqHTpk47U8G4NdwS7fi8liM42aVbJ/YeqB3ctHD+49dnjv7p1LMxRluEPdJOJygSHfsMHiAusuprGx/imk8bTjozhXbqWLyRlEnrpBa6alnj/wRx0hcP4yWubMO6fPr/XjblZHtZ2jHaXZlXsxleXJbUrlkbv8AB6JDDZkJqqiotMUk5lV5mp5x6x2dtwT9x948qEjDx856LpAwd2WPAsrczor6gpGkhuMlAaqB+26CoTxxqh/ABKbmq6mVuMb2k6dyFAlEBWZIW8qITb1/cIAjY+m3hgEv/v4/AefXPjk4vVuQANqU+8dv5W5jdqSL5TJPVZAquIs3eLkOVllxYGWx1Uel+lotukcXFk8/sCBJx5+YHG62XZtT56KkmUQesO2fMcwHNgVnUWxtt3SsjGwh2BVkEihMap7QcowgCqRVSYnmLmoaWlijtIKZWkcBfT6UZz0+oPNrd6trd7t7SFiujuKB2ESxOmwqGlIMQHRxbSMwT8mEzEmdyGMDmlomw3PmvLduY6/MNNanO3MzU7NTU/TFHqe22j6nuc7tge7+67n2jYUJHHn2JplYWUXMArJHwVJhJackDzqTxwp4jm9D6vESUmcFGkMsGg0GtEmBGE0DKPeYLQ9HPZHI16GsfwHBRqsvCrGN+kEkih92i/LMS3ANDyn5fsz7dYUvW3TB4Lve+12u9lquZ6HxOSli0wRfznsJm5XNQzOJ5HG/1VlDIaNBUO8E0iw5xjJ5Ih/VGkRPjCJEcGjw3v8CUjynBIHWFlayN1htcUJ9BtFcRjEiCaUuzzBzuU+uDw2xtlqbIFEMZKn0PJFdzicztAhTH2vARyXpPE5gkJaRg6kk9yiEJ/QmQjpSxDXpdz6FUw2uTkGI4N/0Uvjt/6ZbJr2j6tOAuPzh8rEAAAAAElFTkSuQmCC";
document.getElementById('iProcurarNome').src="data:image/png;base64,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";
document.getElementById('iProcurarNumero').src=document.getElementById('iProcurarNome').src;
document.getElementById('iProcurarFoto').src=document.getElementById('iProcurarNome').src;

// https://www.freecodecamp.org/news/javascript-keycode-list-keypress-event-key-codes/
window.addEventListener("keydown", function (event) {
	  if (event.defaultPrevented) {
	    return; // Do nothing if the event was already processed
	  }
	  switch (event.key) {
		case "ArrowDown":
		   	aluno.Previous.click();
		   	break;
		case "ArrowUp":
		   	aluno.Next.click();
		   	break;
		case "F1":
		   	aluno.Novo.click();
		   	break;
		case "F2":
		   	aluno.Alterar.click();
		   	break;
		case "F3":
		   	aluno.Apagar.click();
		   	break;
		case "Escape":
		   	aluno.Limpar.click();
		   	break;
		case "Enter":
		   	aluno.ProcurarNome.click();
		   	break;
		case "F9":
		case "PageDown":
			if(<%=tlinha%>>1) {
				aluno.nLinha.value=<%=tlinha-1%>;
				aluno.Next.click();
			}
		   	break;
		case "F10":
		case "PageUp":
			if(<%=tlinha%>>1) {
				aluno.nLinha.value=2;
				aluno.Previous.click();
			}
		   	break;
		case "Insert":
			trocaSlide();
		case "Tab":
			aluno.ProcurarFoto.click();
		case "F12":
			timer.stop();
	    default:
	      return; // Quit when this doesn't handle the key event.
	  }
	  // Cancel the default action to avoid it being handled twice
	  event.preventDefault();
	}, true);
	// the last option dispatches the event to the listener first,
	// then dispatches event to window

/*
if (!(typeof num === 'undefined' || num === null))  {
	document.getElementById('Numero').value=num;
	document.getElementById('Comando').value='S'; 
	document.getElementById('aluno').submit();
}*/
</script>
</div>
<br>
<script src="scriptFoto.js"></script>
<a href="javascript:window.history.back()">Voltar</a>

</body>
</html>
