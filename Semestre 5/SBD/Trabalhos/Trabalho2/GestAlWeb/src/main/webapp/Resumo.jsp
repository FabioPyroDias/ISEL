<!DOCTYPE html>
<html>
<%@ page import="GestAl.Manipula, GestAl.Configura, GestAl.Consola, GestAl.Data, java.math.RoundingMode, java.math.BigDecimal, java.sql.ResultSetMetaData, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page errorPage="error.jsp"%>
<%@ page isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page info="Resumo dos registos"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="pt">
<meta name="title" content="Resumo dos registos">
<meta name="keywords" content="ISEL, DEETC">
<meta name="description" content="Resumo do registos dos estudantes">
<meta name="owner" content="ISEL/DEETC - Doutor Porfírio Filipe">
<meta name="copyright" content="ISEL/DEETC/2012">
<meta name="createdate" content="06Dec2012">
<meta name="lastupdate" content="24dec2022">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link rel="stylesheet" type="text/css" href="styleTable.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleText.css" media="all"/>
<link rel="stylesheet" type="text/css" href="styleA.css" media="all"/>
<!--  <link href='https://fonts.googleapis.com/css?family=Style Script' rel='stylesheet'> -->
<!--  <script src="qrious.min.js"></script>  -->
<title>Resumo</title>
<%!
	/**
 	* Devolve lista de discplinas que falta obter aproveitamento
 	* 
 	* @param numero do aluno
 	* @return lista de disciplinas
 	*		
 	*/
 	int nDisciplinas=0;
	private String Disciplinas(String numero) throws SQLException{
		Manipula disp = new Manipula(new Configura());
		String lista = "";
		String select = "SELECT t1.designacao FROM disciplina t1"+ 
													" LEFT JOIN (SELECT designacao FROM avaliacoes"+
																				 " WHERE numero="+numero+") t2"+ 
			    									" ON(t1.designacao=t2.designacao)"+
											" WHERE t2.designacao is NULL ORDER BY t1.designacao"; 
		ResultSet rs = disp.getResultado(select);
		int rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
		nDisciplinas=0;
		String delimiter=", ";
		if(rowCount>0) {
			rs.beforeFirst();
			while (rs.next()) {
				if(nDisciplinas++==rowCount-1)
					delimiter=" e ainda ";
				lista=lista+delimiter+rs.getString("designacao");
			}
		}
		disp.desligar();
		if(lista.length()>0)	
			return lista.substring(2);
		return lista;
	}

	/**
	 * Apresenta resumo textual do registo do aluno.
	 * 
	 * @param numero do aluno
	 * @return resumo textual
	 */
	private String resumo(String numero) {
		Manipula local = new Manipula(new Configura());
		String texto="";
		String directiva = "select numero, nome, genero, nascido, (select coalesce(avg(nota),-1) from inscricao i where i.numero=a.numero) media from aluno a where numero=" + numero;
		try {
			ResultSet rs = local.getResultado(directiva);
			if (rs != null && rs.next()) {// só pode encontrar 1 linha
				if( rs.getString("genero").compareTo("F")==0)
					texto="A";
				else
					texto="O";
				texto=texto+"  estudante "+Consola.proper(rs.getString("nome"))+
					" com o número "+rs.getString("numero")+","+
					" "+Data.saber(rs.getDate("nascido").toLocalDate());
				String Disciplinas = Disciplinas(numero);
				BigDecimal med=rs.getBigDecimal("media");
				if(med.compareTo(new BigDecimal(-1))!=0) {
					if(nDisciplinas>0) {
						texto=texto+". A média do curso é atualmente "+Consola.NotaToString(med)+" valores.";
						texto=texto+" Para concluir o curso, falta obter aproveitamento ";
						if(nDisciplinas==1)
							texto=texto+"numa disciplina, designadamente "+Disciplinas+".";
						else
							texto=texto+" em "+nDisciplinas+" disciplinas, nomeadamente: "+Disciplinas+".";
					}
					else 
						texto=texto+". Concluiu o curso com média final de "+med.setScale(0, RoundingMode.HALF_UP)+" valores.";
				}
				else
					texto=texto+". Ainda não tem registadas avaliações.";
			}
		 	else
			  Consola.writeLine("Não foi encontrado o aluno como o número: " + numero + ".");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
		local.desligar();
		return texto;
	}
%>
</head>
<body style="text-align:center;">
<h2>Resumo dos Registos</h2>
<% 
Manipula dados = new Manipula( new Configura());
String directiva=
		"select numero from aluno order by numero";
ResultSet rs = dados.getResultado(directiva);
int rowCount = (rs!=null && rs.last()) ? rs.getRow() : 0;
if(rowCount>0) {
	rs.beforeFirst();
	%>
	<table style="width:60%" class="styled-table">
	<%
	while (rs.next()) {
		String numero=rs.getString("numero");
		%>
		<tr>
			<td>
				<a href="javascript:ck('<%=numero%>');">
					<img style="width: 1.4in; height: 1.8in;" id="img" 
						src='<%="FotoDown?numero="+numero%>' title="Fotografia do estudante"/></a>
			</td> 					
			<td style="text-align: justify;  text-justify: inter-word; font-family: 'Altura'; font-size: 2.0em;">
				<%String resumo=resumo(numero);%>
				<%=resumo%>
			</td>
			<!-- <td>
				 <canvas title="QRCode com dados do estudante!" 
		 	 		style="width: 95%; height: 95%; text-align: center; margin: auto;" id="qr<%=numero%>">
		 	 	</canvas>
		 	 	<script>
		 			new QRious({element: document.getElementById('qr<%=numero%>'),
							  	background: '#ffffff',
							  	backgroundAlpha: 1,
							  	foreground: '#5868bf',
							  	foregroundAlpha: 1,
							  	level: 'H',
							  	padding: 5,
							  	size: 256,
							  	value: '<%=resumo%>'}); 
		 	 	</script>
		 	 </td> -->
		</tr>
		<%}
%></table><%
} 
else {%>
	<script>alert("Não existem registos de estudantes!")</script>
<%}  
dados.desligar();%>
<script>
function ck(numero) {
	document.getElementById("Numero").value=numero;
	document.getElementById("myForm").submit();
}
</script>
<form id="myForm" action="Aluno.jsp" method="post">
  <input type="number" name="Numero" id="Numero"/>
  <input type="text" name="Comando" id="Comando" value="S"/>
</form>
<br>
<a href="javascript:window.history.back()">Voltar</a>
</body>
</html>
