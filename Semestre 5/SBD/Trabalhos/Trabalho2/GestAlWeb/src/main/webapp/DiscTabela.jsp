<!DOCTYPE html>
<html>
<%@ page import="disciplina.*, GestAl.*, java.io.IOException, java.util.List"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Visualização de disciplinas"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <!--  charset=ISO-8859-1 -->
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Visualização de disciplinas">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Visualização de disciplinas">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="28Dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<title>Visualização de Disciplinas</title>
<link rel="stylesheet" type="text/css" href="styleTable.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<style>
  	iframe {color:blue;
  		  	display:none; 
  		  	width:100%;
  		  	height:200px; 
  		  	margin:auto; 
  		  	text-align:center;}
 
</style>
</head>
<body style="width:75%; margin:auto; text-align:center;">
<h1>Disciplinas</h1>

<%
List<Disc> list=DiscDao.getAllDisc();
%>
<script>
function go (url, target, c, d) {
	document.getElementById("Codigo").value=c;
	document.getElementById("Designacao").value=d;
	document.getElementById("Frm").action=url;
	document.getElementById("Frm").target=target;
	document.getElementById("Frm").submit();
	if(target!="_self")
		document.getElementById(target).style.display="block";
}
</script>

<form  style="display:none" id="Frm" name="Frm" method="post">
			<input id="Codigo" name="Codigo">
			<input id="Designacao" name="Designacao">
</form>

<table border='1' class="styled-table" >
	<tr><th>Código
		</th>
	    <th><a onclick="style.display='none';" title="Clique para acrescenter uma disciplina nova" 
	           href='javascript:go("Disc.jsp","iDisc", "","");'>Designação</a>
	           <iframe id="iDisc" name="iDisc"></iframe>
	    </th>
	    <th>Inscrições
		</th>
	</tr>
<%for(Disc d:list){ %>
	<tr>
		<td title="Clique para consultar pauta">
		<a href='javascript:go("Pauta.jsp","_self","<%=d.getCodigo()%>","");'>
		<%=d.getCodigo()%></a>
		</td>
		<td style="text-align: left" title="Clique para editar">
			<a onclick="style.display='none';" 
			<% String aux= d.getDesignacao();
			   aux=aux.replaceAll("\"","\\\\\"");
			   aux=aux.replaceAll("\'","&#39;");%>
			href='javascript:go("Disc.jsp","iDisc<%=d.getCodigo()%>", "<%=d.getCodigo()%>","<%=aux%>");'>
			<%=d.getDesignacao()%></a>
			<iframe id="iDisc<%=d.getCodigo()%>" name="iDisc<%=d.getCodigo()%>"></iframe>
		</td>
		<td title="Clique para visualizar inscrições ativas">
		<a href='javascript:go("Inscricoes.jsp","_self","<%=d.getCodigo()%>","<%=aux%>");'>
				<%=Gestor.qInscricoes(d.getCodigo())%></a>
		</td>
	</tr>
<%}%>
</table>
<br>
<div style="width:95%; margin:auto; text-align:center;">
<a href="javascript:window.history.back()">Voltar</a>
</div>
</body>
</html>