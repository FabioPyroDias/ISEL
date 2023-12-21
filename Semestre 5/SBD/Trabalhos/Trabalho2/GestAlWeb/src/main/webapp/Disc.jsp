<!DOCTYPE html>
<html>
<%@ page import="disciplina.*"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Manipulação de disciplinas"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <!--  charset=ISO-8859-1 -->
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Manutenção de disciplinas">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Manutenção de disciplinas">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="28Dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Manutenção de Disciplina</title>
<body>
<a style="display:none;" id="go" target="_parent" href="DiscTabela.jsp">Fechar</a>
<%
String codigo = request.getParameter("Codigo");
String designacao = request.getParameter("Designacao");
String parent = request.getParameter("parent");
if(parent!=null && parent.compareTo("true")==0){%>
	<script>
		document.getElementById("go").click();
	</script>
<%
} 
String titulo="";
String accao="";
if(codigo!=null && codigo.compareTo("")!=0) {
	titulo="Atualiza Disciplina";
	accao="DiscEdit";
}
else {
	codigo="";
	designacao="";
	titulo="Nova Disciplina";
	accao="DiscSave";
}
%>
<script>
	function gerarCodigo(dsg) {
		if("<%=codigo%>"=="")
			document.getElementById("Codigo").value=dsg.match(/\b(\w)/g).join('').toUpperCase();
	}
	window.setTimeout(() => myForm.Designacao.focus(), 0);
	
	String.prototype.toTitleCase = function() {
		  var i, j, str, lowers, uppers;
		  str = this.replace(/([^\W_]+[^\s-]*) */g, function(txt) {
			if(txt==='de '||txt==='dos '||txt==='do '||txt==='das '||txt==='da '||txt==='e ')
				return txt;
		    return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
		  });

		  /* Certain minor words should be left lowercase unless 
		  // they are the first or last words in the string
		  lowers = ['A', 'An', 'The', 'And', 'But', 'Or', 'For', 'Nor', 'As', 'At', 
		  'By', 'For', 'From', 'In', 'Into', 'Near', 'Of', 'On', 'Onto', 'To', 'With'];
		  for (i = 0, j = lowers.length; i < j; i++)
		    str = str.replace(new RegExp('\\s' + lowers[i] + '\\s', 'g'), 
		      function(txt) {
		        return txt.toLowerCase();
		      });
		  
		  // Certain words such as initialisms or acronyms should be left uppercase
		  uppers = ['Id', 'Tv'];
		  for (i = 0, j = uppers.length; i < j; i++)
		    str = str.replace(new RegExp('\\b' + uppers[i] + '\\b', 'g'), uppers[i].toUpperCase()); */
		  
		  return str; 
		}
</script>
<h1><%=titulo%></h1>
<form id="myForm" name="myForm" action="<%=accao%>" method="post">
<table>
	<tr><td style="text-align:right"><label for="Designacao">Designação:  </label>
		</td>
		<td>
			<input value="<%=designacao.replaceAll("\"","&#34;")%>" type="hidden" id="DesignacaoOld" name="DesignacaoOld"/>
			<!-- style="text-transform: capitalize;" -->
			<input  onkeyup="gerarCodigo(this.value);" onblur="gerarCodigo(this.value);this.value=this.value.toTitleCase();" 
					value="<%=designacao.replaceAll("\"","&#34;")%>" maxlength="60" size="60" type="text" 
					id="Designacao" name="Designacao" 
					placeholder="Alfanumérico" pattern="[a-zA-Z0-9 ÁÉÍÓÚàáãâéêíóõôúç\-]{6,60}" 
					title="Designação da disciplina" required>
			
	    </td>
	</tr>
	<tr><td style="text-align:right"><label for="Codigo">Código:  </label>
		</td>
		<td>
			<input value="<%=codigo.replaceAll("\"","&#34;")%>" type="hidden" id="CodigoOld" name="CodigoOld"/>
			<input value="<%=codigo.replaceAll("\"","&#34;")%>" maxlength="4" size="4" type="text" id="Codigo" name="Codigo" 
					placeholder="A-Z0-9" pattern="[a-zA-Z0-9àáãâéêíóõôúç\-]{2,4}" 
					title="Código da disciplina" required>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:right">
		<br>
		<%if(codigo!=null && codigo.length()!=0) {%>
			<button title="Atualiza a disciplina">Atualizar</button>
			<button title="Apaga a disciplina" onclick="document.getElementById('myForm').action='DiscDelete'">Apagar</button>
			<%}%>
		<button title="Acrescenta a disciplina nova" 
		onclick="myForm.action='DiscSave'; myForm.DesignacaoOld.value='';myForm.CodigoOld.value='';">Acrescentar</button>
		<button title="Fecha o formulário" onclick="document.getElementById('go').click();">Fechar</button></td>
	</tr>
</table>
</form>
</body>
</html>