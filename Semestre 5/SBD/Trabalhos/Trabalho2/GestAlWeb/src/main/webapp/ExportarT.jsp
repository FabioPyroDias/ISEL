<!DOCTYPE html>
<html>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Exportação de Tabelas"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Exporta Tabelas">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Exportação de Tabelas">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="20nov2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Exportar Tabelas</title>
<script>
//Put the table into file
function save(table) {
	var a = document.getElementById("export");
	if(document.getElementById("SQL").checked) {
		a.download = table+".sql";
		a.href = "Export?Formato=SQL&Tabela="+table;
		a.click();
	}
	if(document.getElementById("XML").checked) {
		a.download = table+".xml";
		a.href = "Export?Formato=XML&Tabela="+table;
		a.click();			
	}
	if(document.getElementById("JSON").checked) {
		a.download = table+".json";
		a.href = "Export?Formato=JSON&Tabela="+table;
		a.click();
	}
	if(document.getElementById("CSV").checked) {
		a.download = table+".csv";
		a.href = "Export?Formato=CSV&Tabela="+table;
		a.click();
	}	
}
</script>
</head>
<body>
<a target="_self" id="export" style="display:none">Exporta Dados</a>  <!-- não é visivel  -->
<h1>Exportação de tabelas</h1>
<br/>
<div title="Formato de exportação das tabelas" id="xFormat" style="text-align: center; width: 30%; background-image: linear-gradient(to bottom left, goldenrod, gold); ">
<br/>
<fieldset>
	<legend>&nbsp;&nbsp;Formato de Exportação:&nbsp;&nbsp;</legend>
	<input checked title="Exporta no formato SQL" type="checkbox" id="SQL" name="SQL" value="SQL"><label for="SQL">SQL</label>&nbsp;&nbsp;
	<input title="Exporta no formato XML" type="checkbox" id="XML" name="XML" value="XML"><label for="XML">XML</label>&nbsp;&nbsp;
	<input title="Exporta no formato JSON" type="checkbox" id="JSON" name="JSON" value="JSON"><label for="JSON">JSON</label>&nbsp;&nbsp;
	<input title="Exporta no formato CSV" type="checkbox" id="CSV" name="CSV" value="CSV"><label for="CSV">CSV</label>
</fieldset>
</div>
<ul>
<li><a title="Exporta os alunos" onclick="save('aluno')" target="_self" href="ExportaT.jsp?Tabela=aluno">Aluno</a>
</li>
<li><a title="Exporta as disciplinas" onclick="save('disciplina')" target="_self" href="ExportaT.jsp?Tabela=disciplina">Disciplina</a>
</li>
<li><a title="Exporta as inscrições" onclick="save('inscricao')" target="_self" href="ExportaT.jsp?Tabela=inscricao">Inscrição</a>
</li>
<li><a title="Exporta as fotos" onclick="save('foto')" target="_self" href="ExportaT.jsp?Tabela=foto">Fotografia</a>
</li>
</ul>
<br>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>
