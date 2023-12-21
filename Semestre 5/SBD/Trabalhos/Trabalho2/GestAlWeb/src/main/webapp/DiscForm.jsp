<!DOCTYPE html>
<html>
<%@ page import="GestAl.*, java.sql.ResultSetMetaData, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Manipulação da Disciplina"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Tratar Disciplina">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Tratamento de disciplina">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="20nov2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<title>Tratar Disciplina (não está em uso)</title>
</head>
<body>

<% 

String comando=request.getParameter("Comando");
if(comando==null) comando="";

String codigo=request.getParameter("Codigo");
String designacao=request.getParameter("Designacao");

System.out.println("Dados");
System.out.println("comando: "+comando);
System.out.println("codigo: "+codigo);
System.out.println("designacao: "+designacao);


String codigoOld=request.getParameter("CodigoOld");
String designacaoOld=request.getParameter("DesignacaoOld");

if(comando.compareTo("I")==0){
	Configura cfgaux = new Configura();
	Manipula dados = new Manipula(cfgaux);
	String directiva = "insert into disciplina (codigo, designacao) values("
		+ Consola.ValorS(codigo) 
		+", "
		+ Consola.ValorS(designacao)
		+ ")";
	if (dados.xDirectiva(directiva)) {
		%> <script>alert('A disciplina foi criada com sucesso!');</script>
		<%
	}
	else {
		%> <script>alert('Ocorreu uma falha na criação da disciplina...');</script>;
		<%}
	dados.desligar();
}  // fim do insert

// procura pelo código
if(comando.compareTo("S")==0){
	Configura cfgaux = new Configura();
	Manipula dados = new Manipula(cfgaux);
	String directiva= "SELECT codigo, designacao FROM disciplina "
			+ "where "
			+ Consola.IgualS("codigo", codigo) 
			+" order by codigo";
	ResultSet rs = dados.getResultado(directiva);
	System.out.println(directiva);
	if (rs!=null && rs.next()) {  // considera a linha com o codigo mais baixo 
		codigo=rs.getString("codigo");
		designacao=rs.getString("designacao");
	}
	dados.desligar();
}  // fim da procura

if(comando.compareTo("U")==0){ // verifica antes de fazer a actualização se o registo se mantém
	Configura cfgaux = new Configura();
	Manipula dados = new Manipula(cfgaux);
	String directiva = "update disciplina set "
			+ "codigo="+Consola.ValorS(codigo)+", " 
			+ "designacao="+Consola.ValorS(designacao)
		    + " where "
			+ Consola.IgualS("codigo", codigoOld)+" AND " 
			+ Consola.IgualS("designacao", designacaoOld);
	if (dados.xDirectiva(directiva)) {
		%> <script>alert('A disciplina foi alterada com sucesso! <%=dados.getAfetadas()%>');</script>
		<%
		}
			else
				{
		%> <script>alert('Ocorreu uma falha na alteração da disciplina...');</script>;
		<%
 }
 	dados.desligar();
 }  // fim da alteração

 if(comando.compareTo("D")==0){
 	Configura cfgaux = new Configura();
 	Manipula dados = new Manipula(cfgaux);
 	String directiva = "delete from disciplina where codigo="
 		+ Consola.ValorS(codigo);
 	if (dados.xDirectiva(directiva)) {
 %> <script>alert('A disciplina foi apagada com sucesso! <%=dados.getAfetadas()%>');</script>
		<%
	}
	else
		%> <script>alert('Ocorreu uma falha no apagamento da disciplina...');</script>;
		<%
	dados.desligar();
}  // fim do apagar


if(codigo==null) codigo="";
if(designacao==null) designacao="";

%>

<div style="text-align:center;color:#0000FF">

<form name="disciplina" action="" method="post">

<br>
<input type="submit" value="Novo" onclick="Comando.value='I'">
<input type="submit" value="Alterar" onclick="Comando.value='U'">
<input type="submit" value="Apagar" onclick="Comando.value='D'">
<input type="reset" value="Limpar"><br>

<br>
<label for="Codigo">Código: </label>
<input maxlength="4" size="4" type="text" name="Codigo" placeholder="A-Z0-9" pattern="[a-zA-Z0-9 àáãâéêíóõôúç\-]{2,4}" 
					title="Código da disciplina" required>
<button formnovalidate="formnovalidate" type="submit" onclick="Comando.value='S'">Procurar</button>
<br>
<br>
<label for="Designacao">Designação: </label>
<input maxlength="60" size="60" type="text" name="Designacao" placeholder="Alfanumérico" pattern="[a-zA-Z0-9 àáãâéêíóõôúç\-]+" 
					title="Designação da disciplina" required>
<br>

<input type="hidden" name="Comando" value="<%=comando%>">
<input type="hidden" name="CodigoOld" value="<%=codigo%>">
<input type="hidden" name="DesignacaoOld" value="<%=designacao%>">
</form>

<script>
disciplina.Codigo.value='<%=codigo%>';
disciplina.Designacao.value='<%=designacao%>';

</script>
</div>

<br>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>
