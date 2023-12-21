package GestAl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.time.Year;
import java.util.Base64;
import java.util.Calendar;

/**
 * Este projeto, promovido pelo Eng.º Porfírio Filipe, 
 * surge no âmbito da unidade curricular de Sistemas de Bases de Dados, 
 * enquadrada na Licenciatura em Engenharia Informática e Multimédia, 
 * do Instituto Superior de Engenharia de Lisboa, 
 * consiste na implementação parcial (em desenvolvimento) do protótipo de um gestor académico que, 
 * essencialmente, manipula inscrições de alunos em disciplinas de forma minimalista, 
 * com o objetivo de demonstrar possíveis abordagens de concretização, 
 * harmonizando tecnologias em atualização.
 * 
 */
public class Gestor {

	final public static String condAprov = " nota is not null and nota >=10 and nota <=20 ";
	
	static Configura cfg = new Configura();

	static Manipula dados = new Manipula(cfg);

	/**
	 * Pergunta ao utilizador o número de um aluno e o novo nome, procedendo à
	 * actualização do nome na base de dados.
	 * 
	 * @return true se correu bem
	 */
	public static boolean alterarAlNome() {
		Integer numero = Consola.getCNumAl();
		fichaAluno(numero.toString());
		String nome = Consola.getCNome();
		Consola.writeLine("Dados do aluno:");
		if (!dados.xDirectiva("update aluno set nome='" + nome + "' where numero=" + numero))
			return false;
		Consola.writeLine("Dados do aluno após alteração do nome:");
		fichaAluno(numero.toString());
		return true;
	}

	/**
	 * Pergunta ao utilizador o código de uma disciplina e a nova designação,
	 * procedendo à actualização da designação na base de dados.
	 * 
	 * @return true se correu bem
	 */
	public static boolean alterarDisDesg() {
		String codigo = Consola.getCCodDis();
		fichaDisciplina(codigo);
		String designacao = Consola.getCDsgDis();
		if (!dados.xDirectiva("update disciplina set designacao='" + designacao + "' where codigo='" + codigo + "'"))
			return false;
		Consola.writeLine("Dados da disciplina:");
		fichaDisciplina(codigo);
		return true;
	}

	/**
	 * Apaga, no contexto de uma transacão as tabelas 'aluno', 'disciplina', foto e
	 * 'inscricao'. Caso ocorra algum erro a transação é desfeita, repondo a
	 * situação anterior à execução
	 * 
	 * @return true se correu bem
	 */
	public static boolean apagarTabelas() {
		boolean ok = false;
		try {
			dados.getLigacao().setAutoCommit(false);
		} catch (SQLException e) {
			Consola.writeLine("O apagamento das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao' não teve sucesso.");
			e.printStackTrace();
			System.err.println("Autocommit, SQLException: " + e.getMessage());
			return false;
		}
		Consola.writeLine("Apagamento das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao'...");
		Consola.writeLine("Apagar Tabela 'inscricao'...");
		if (dados.xDirectiva("DELETE FROM INSCRICAO")) {
			Consola.writeLine("Tabela 'inscricao' apagada com sucesso!");
			Consola.writeLine("Apagar Tabela 'foto'...");
			if (dados.xDirectiva("DELETE FROM FOTO")) {
				Consola.writeLine("Tabela 'foto' apagada com sucesso!");
				Consola.writeLine("Apagar Tabela 'aluno'...");
				if (dados.xDirectiva("DELETE FROM ALUNO")) {
					Consola.writeLine("Tabela 'aluno' apagada com sucesso!");
					Consola.writeLine("Apagar Tabela 'disciplina'...");
					if (dados.xDirectiva("DELETE FROM DISCIPLINA")) {
						Consola.writeLine("Tabela 'disciplina' apagada com sucesso!");
						ok = true;
					}
				}
			}
		}
		if (ok)
			try {
				dados.getLigacao().commit();
				Consola.writeLine(
						"O apagamento das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao' foi concluido com sucesso.");
			} catch (SQLException e) {
				System.err.println("Commit, SQLException: " + e.getMessage());
				ok = false;
			}
		else
			try {
				dados.getLigacao().rollback();
				Consola.writeLine("O apagamento das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao' não teve sucesso.");
			} catch (SQLException e) {
				System.err.println("Rollback, SQLException: " + e.getMessage());
			}
		try {
			dados.getLigacao().setAutoCommit(true);
		} catch (SQLException e) {
			System.err.println("Autocommit, SQLException: " + e.getMessage());
		}
		return ok;
	}

	/**
	 * Carrega o conteudo da tabela 'aluno'. 
	 * Não faz commit nem rollback, porque vai ser executada no contexto de uma transação
	 * 
	 * @return true se correr bem
	 */
	public static boolean carregarAluno() {
		return dados.xDirectiva("insert into aluno values (1,'Álvaro ALVES BOTELHO','M'," + cfg.fmt(20, 10, 2000) + ")")
				&& dados.xDirectiva("insert into aluno values (2,'Abel Alves da Costa Pina','M'," + cfg.fmt(04, 05, 2000) + ")")
				&& dados.xDirectiva("insert into aluno values (3,'ABILIO DOS SANTOS DIAS Boavida','M'," + cfg.fmt(04, 01, 1999) + ")")
				&& dados.xDirectiva("insert into aluno values (4,'Abílio Boamorte dos Santos','M'," + cfg.fmt(06, 01, 2000) + ")")
				&& dados.xDirectiva("insert into aluno values (5,'ACACIO CARDOSO DA ROCHA','M'," + cfg.fmt(16, 12, 1999) + ")")
				&& dados.xDirectiva("insert into aluno values (6,'Acácio Cardoso do Nascimento','M'," + cfg.fmt(01, 02, 2000) + ")")
				&& dados.xDirectiva("insert into aluno values (7,'Adalberto Luís Marques Rabaça','M',"
						+ cfg.fmt(27, 12, 2000) + ")")
				&& dados.xDirectiva("insert into aluno values (8,'ADALBERTO LUIS MARTINHO DE MELO','M',"
						+ cfg.fmt(15, 12, 2000) + ")")
				&& dados.xDirectiva("insert into aluno values (9,'Adao DE ALMEIDA SILVARES','M'," + cfg.fmt(28, 02, 2000) + ")")
				&& dados.xDirectiva("insert into aluno values (10,'Aldina de Almeida Vasconcelos','F'," + cfg.fmt(8, 06, 1998) + ")")
				&& dados.xDirectiva("insert into aluno values (11,'ADAO FINO DA COSTA','M'," + cfg.fmt(30, 9, 2000) + ")")
				&& dados.xDirectiva("insert into aluno values (12,'Adélia Oliveira Pereira','F'," + cfg.fmt(30, 7, 2000) + ")")
				&& dados.xDirectiva("insert into aluno values (13,'ADELIA MARIA VAZ PESTANA DIAS','F',"
						+ cfg.fmt(30, 10, 1973) + ")")
				&& dados.xDirectiva("insert into aluno values (14,'Adelina AUGUSTO FERREIRINHA','F'," + cfg.fmt(18, 3, 1999) + ")")
				&& dados.xDirectiva("insert into aluno values (15,'Adérito Augusto Figueira','M'," + cfg.fmt(7, 7, 1997) + ")")
				&& dados.xDirectiva("insert into aluno values (16,'ZACARIAS MACHADO FERREIRA','M'," + cfg.fmt(7, 4, 1999) + ")")
				&& dados.xDirectiva("insert into aluno values (17,'ZACARIAS MAGALHAES FERNANDES','M'," + cfg.fmt(16, 4, 1998) + ")")
				&& dados.xDirectiva("insert into aluno values (18,'Zélia Maria Lima Ferro','F'," + cfg.fmt(2, 7, 1999) + ")")
				&& dados.xDirectiva("insert into aluno values (19,'Zélia Maria Lopes Dias Moreira','F',"
						+ cfg.fmt(7, 8, 1999) + ")")
				&& dados.xDirectiva("insert into aluno values (20,'Ágata Silva d''Almeida','F'," + cfg.fmt(7, 9, 1996) + ")")
				&& dados.xDirectiva("insert into aluno values (21,'António Fagundes Fraga','M'," + cfg.fmt(7, 11, 1996) + ")")
				&& dados.xDirectiva("insert into aluno values (22,'Abreu Poças PETAVY','M'," + cfg.fmt(7, 1, 1999) + ")")
				&& dados.xDirectiva("insert into aluno values (23,'Amanda JORGE DE ALPOIM E OSORIO DE VALDOLEIROS','F',"
						+ cfg.fmt(8, 3, 2001) + ")")
				&& dados.xDirectiva("insert into aluno values (24,'Maria ADILSON SALVE-RAINHA VICENTE','F'," + cfg.fmt(6, 10, 2002) + ")")
				&& dados.xDirectiva("insert into aluno values (25,'AFONSO MARIA PERESTRELLO CORTE-REAL PERDIGÃO','M',"
						+ cfg.fmt(9, 5, 1998) + ")")
				&& dados.xDirectiva("insert into aluno values (26,'PROFIRIO DIAS AGUIAR MOTA','M'," + cfg.fmt(8, 1, 1997) + ")")
				&& dados.xDirectiva("insert into aluno values (27,'Procópia Tinta Fina Taniças PATRAO CARNEIRO','F',"
						+ cfg.fmt(7, 1, 2001) + ")")
				&& dados.xDirectiva("insert into aluno values (28,'PRIYESKUMAR PRAVINCHANDRA NANDVANA DA SILVA','M',"
						+ cfg.fmt(1, 4, 1999) + ")")
				&& dados.xDirectiva("insert into aluno values (29,'PROTÁSIO DE MATOS CARNEIRO LEÃO','M',"
						+ cfg.fmt(1, 5, 2000) + ")")
				&& dados.xDirectiva("insert into aluno values (30,'BERNARDA PANTALEÃO NICO LOJA','M'," + cfg.fmt(9, 3, 1998) + ")");
	}

	/**
	 * Carrega o conteudo da tabela 'foto'. Não faz commit nem rollback, porque vai
	 * ser executada no contexto de uma transacção.
	 *
	 * @return true se correr bem
	 */
	public static boolean carregarFoto(String path) {
		boolean status=false;
		Connection conn=dados.getLigacao();
		try {// necessário para desbloquear o acesso á tabela aluno
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Statement stm = conn.createStatement();){
			ResultSet rs = stm.executeQuery("select numero from aluno order by numero");
			while (rs != null && rs.next()) {
				BigDecimal numero = rs.getBigDecimal("numero");
				String fich=path + "p" + numero + ".jpg";
				// Consola.writeLine("Carrega fotos em '"+path+"'!");
				File f = new File(fich);	 
		        // Checking if the specified file exists
		        if (f.exists())
		        	status=setFoto(fich, numero, dados);
		        else {
		        	Consola.writeLine("A foto '"+fich+"' não existe!");
		        	continue;
		        }
				if(status)
					Consola.writeLine("Carregou a foto '"+fich+"'!");
				else {
					Consola.writeLine("Falha no carregamento da foto '"+fich+"'...");
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
			status=false;
		}
		return status;
	}

	
	/**
	 * Mostra a foto de um aluno numa imagem
	 * 
	 * @param numero	do aluno
	 * @return			true se correr bem
	 */
	public static boolean showFoto(int numero) {
		byte[] buffer = getFoto(numero);
		if (buffer != null && buffer.length > 0)
			try {
				Foto ft=new Foto(); 
				ft.setFoto(buffer);
				ft.show("Fotografia nº "+numero); // mostra a imagem obtida
				Consola.writeLine("Fotografia apresentada com sucesso!");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				Consola.writeLine("Erro na apresentação da fotografia!");
			}
		return false;
	}
 
	/**
	 * Obtem a foto de um aluno em formato binário
	 * 
	 * @param numero 	do aluno
	 * @return			bytes da foto ou null se não existir
	 */
	public static byte[] getFoto(int numero) {
		try {
			PreparedStatement pstmt = dados.getLigacao().prepareStatement("SELECT conteudo FROM foto WHERE numero=?");
			pstmt.setInt(1, numero);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				/*
				 * InputStream input = rs.getBinaryStream("conteudo"); // get it from col name
				 * System.out.println("Dimensão da fotografia: " + input.available() +
				 * " bytes."); byte[] buffer = new byte[input.available()]; int nbytes =
				 * input.read(buffer); input.close();
				 */
				return rs.getBytes("conteudo");
			} else
				System.out.println("Sem fotografia!");
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Obtem a foto de um aluno em formato base64
	 * 
	 * @param numero 	do aluno
	 * @return			string com a foto ou null se não existir
	 */
	public static String getFoto64(int numero) {
		byte[] aux=getFoto(numero);
		if(aux==null)
			return null;
		return Base64.getEncoder().encodeToString(aux);
	}
	
	/**
	 * Atualiza a foto de um aluno na tabela das fotos
	 * 
	 * @param foto		nome do ficheiro com a fotografia
	 * @param numero	do aluno
	 * @return			true se correr bem
	 */
	public static boolean setFoto(String foto, BigDecimal numero, Manipula dados) {
		File ft = new File(foto);
		if(!ft.exists())
			return false;
		try (FileInputStream inputfile = new FileInputStream(ft);) {
			return setFoto(inputfile,numero, dados);
		} catch (FileNotFoundException e) {
			System.err.println("File '" + foto + "' not found!");
			e.printStackTrace();
		} catch (IOException e1) {
			System.err.println("File close error!");
			e1.printStackTrace();
		}
		return false;
	}
	 
	/**
	 * Atualiza a foto de um aluno na tabela das fotos
	 * 
	 * @param input		array com a fotografia
	 * @param numero	do aluno
	 * @return			true se correr bem
	 */
	public static boolean setFoto(byte[] input, BigDecimal numero, Manipula dados) {
		 ByteArrayInputStream byteStream = new ByteArrayInputStream(input);
		 boolean ret=setFoto(byteStream, numero, dados);
		 try {
			byteStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
		 return ret;
	}

	/**
	 * Atualiza a foto de um aluno na tabela das fotos
	 * 
	 * @param input		String com a fotografia em base64
	 * @param numero	do aluno
	 * @return			true se correr bem
	 */
	public static boolean setFoto64(String foto64, BigDecimal numero, Manipula dados) {
		byte[] imagedata = java.util.Base64.getDecoder().decode(foto64.substring(foto64.indexOf(",") + 1));
		InputStream targetStream = new ByteArrayInputStream(imagedata);
		boolean ret = setFoto(targetStream, numero, dados);
		try {
			targetStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
		return ret;
	}
	/**
	 * Atualiza a foto de um aluno na tabela das fotos
	 * 
	 * @param input		stream para acessso à fotografia
	 * @param numero	do aluno
	 * @return			true se correr bem
	 */
	public static boolean setFoto(InputStream input, BigDecimal numero, Manipula dados) {
		boolean status=false;
		// deve usar transação ou usar REPLACE
		Connection conn = dados.getLigacao();
		try (Statement stm = conn.createStatement();) {
			status = (stm.executeUpdate("DELETE FROM FOTO WHERE numero = " + numero)<=1);
		} catch (SQLException e) {
			System.err.println("Foto Delete Statement: SQL Exception!");
			System.out.println(e.getMessage());
		}
		if(status) {
			String SQL = "INSERT INTO FOTO (numero, conteudo) VALUES (?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(SQL);){
				// set parameters
				pstmt.setBigDecimal(1, numero);
				pstmt.setBinaryStream(2, input);
				// store in database
				status=(pstmt.executeUpdate() == 1);
			} catch (SQLException e) {
				System.err.println("Foto Insert Prepared Statement: SQL Exception!");
				System.out.println(e.getMessage());
				status=false;
			}
		}
		else {
			System.out.println("Não conseguiu apagar a fotografia!");
		}
	return status;
	}
	/**
	 * Carrega o conteudo da tabela 'disciplina'. Não faz commit nem rollback,
	 * porque vai ser executada no contexto de uma transação.
	 * 
	 * @return true se correr bem
	 */
	public static boolean carregarDisciplina() {
		if (!dados.xDirectiva("insert into Disciplina values ('SBD', 'Sistemas de Bases de Dados')"))
			return false;
		if (!dados.xDirectiva("insert into disciplina values ('SdI','Sistemas de Informação')"))
			return false;
		if (!dados.xDirectiva("insert into disciplina values ('SCD','Sistemas Computacionais Distribuídos')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('ICD', 'Infraestruturas\" Computacionais Distribuídas')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('CPS', 'Comunicações e Processamento de Sinais')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('FSO', 'Fundamentos, de Sistemas Operativos')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('IPM', 'Interfaces'' Pessoa-Máquina')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('MAE', 'Matemática Aplicada à Engenharia')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('MDP', 'Matemática Discreta e Programação')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('MSSN', 'Modelação e Simulação de Sistemas Naturais')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('PCM', 'Produção de Conteúdos Multimédia')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('PIV', 'Processamento de Imagem e Visão')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('RI', 'Redes de Internet')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('RSCM', 'Redes e Serviços de Comunicação Multimédia')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('SA', 'Sensores e Atuadores')"))
			return false;
		if (!dados.xDirectiva("insert into Disciplina values ('TI', 'Tecnologias de Informação')"))
			return false;
		return true;
	}

	/**
	 * Carrega o conteudo da tabela 'inscricao', recorrendo à execução de 'Batch'.
	 * Não faz commit nem rollback, porque vai ser executada no contexto de uma transação
	 * 
	 * @return true se correr bem
	 */
	public static boolean carregarInscricao() {
		String[] inserts = { 
				"insert into inscricao (numero, ano, nota, codigo) values (1, 2021, NULL, 'SBD')",
				"insert into inscricao (numero, ano, nota, codigo) values (2, 2020, 10.0, 'SBD')",
				"insert into inscricao (numero, ano, nota, codigo) values (3, 2020, 15.0, 'SBD')",
				"insert into inscricao (numero, ano, nota, codigo) values (4, 2020, 10.0, 'SBD')",
				"insert into inscricao (numero, ano, nota, codigo) values (6, 2021, NULL, 'SBD')",
				"INSERT INTO INSCRICAO (numero, codigo, ano, nota) VALUES (7, 'SBD', 2018, NULL),"+ 
																		 "(7, 'SBD', 2019, 18.0),"+
																		 "(7, 'SBD', 2020, 19.0),"+
																		 "(7, 'SBD', 2021, 17.0),"+
																		 "(7, 'SBD', 2023, NULL),"+
																		 "(7, 'SBD', 2022, 13.0),"+
																		 "(7, 'SdI', 2019, NULL),"+
																		 "(7, 'SdI', 2020, 12.0),"+
																		 "(7, 'SdI', 2021, 19.0),"+
																		 "(7, 'SdI', 2022, 17.0)",
				"insert into inscricao (numero, ano, nota, codigo) values (8, 2021, 15.0, 'SBD')",
				"insert into inscricao (numero, ano, nota, codigo) values (9, 2020, 13.0, 'SBD')",
				"insert into inscricao (numero, ano, nota, codigo) values (10,2021, NULL, 'SBD')",
				"insert into inscricao (numero, ano, nota, codigo) values (11,2021, 14.2, 'SBD')",
				"insert into inscricao (numero, ano, nota, codigo) values (12,2020, 18.0, 'SBD')",
				"insert into inscricao (numero, ano, nota, codigo) values (13,2020, 16.0, 'SBD')",
				"insert into inscricao (numero, ano, nota, codigo) values (14,2020, 14.0, 'SdI')",
				"insert into inscricao (numero, ano, nota, codigo) values (15,2020, 15.0, 'SdI')",
				"insert into inscricao (numero, ano, nota, codigo) values (16,2021, 11.0, 'SdI')",
				"insert into inscricao (numero, ano, nota, codigo) values (18,2020, 11.0, 'SdI')",
				"insert into inscricao (numero, ano, nota, codigo) values (19,2021, 13.1, 'SdI')",
				"insert into inscricao (numero, ano, nota, codigo) values (20,2021, 16.0, 'SdI')",
				"insert into inscricao (numero, ano, nota, codigo) values (21,2021, 17.0, 'SdI')",
				"insert into inscricao (numero, ano, nota, codigo) values (22,2021, 12.0, 'SdI')",
				"insert into inscricao (numero, ano, nota, codigo) values (14,2020, 13.0, 'ICD')",
				"insert into inscricao (numero, ano, nota, codigo) values (15,2020, 18.0, 'ICD')",
				"insert into inscricao (numero, ano, nota, codigo) values (15,2021, NULL, 'ICD')",
				"insert into inscricao (numero, ano, nota, codigo) values (16,2021, 13.0, 'ICD')",
				"insert into inscricao (numero, ano, nota, codigo) values (16,2022, NULL, 'SdI')",
				"insert into inscricao (numero, ano, nota, codigo) values (18,2020, 10.0, 'ICD')",
				"insert into inscricao (numero, ano, nota, codigo) values (19,2021, 18.1, 'ICD')",
				"insert into inscricao (numero, ano, nota, codigo) values (20,2020, 17.0, 'ICD')",
				"insert into inscricao (numero, ano, nota, codigo) values (21,2021, 15.0, 'ICD')",
				"insert into inscricao (numero, ano, nota, codigo) values (22,2021, 14.0, 'ICD')"};
		return dados.executaBatch(inserts);
	}

	/**
	 * Carrega, no contexto de uma transacção as tabelas 'aluno', 'disciplina' e
	 * 'inscricao'. Caso ocorra algum erro a transacção é desfeita, repondo a
	 * situação anterior à execução.
	 * 
	 * @return true se correu bem
	 */
	public static boolean carregarTabelas(String pathFotos) {
		boolean ok = false;
		Connection con=dados.getLigacao();
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			Consola.writeLine(
					"O carregamento das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao' não teve sucesso.");
			e.printStackTrace();
			System.err.println("Autocommit, SQLException: " + e.getMessage());
			return false;
		}
		Consola.writeLine("Carregamento das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao'...");
		Consola.writeLine("Carregar Tabela 'aluno'...");
		if (carregarAluno()) {
			Consola.writeLine("Tabela 'aluno' carregada com sucesso!");
			Consola.writeLine("Carregar Tabela 'disciplina'...");
			if (carregarDisciplina()) {
				Consola.writeLine("Tabela 'disciplina' carregada com sucesso!");
				Consola.writeLine("Carregar Tabela 'inscricao'...");
				if (carregarInscricao()) {
					Consola.writeLine("Tabela 'inscricao' carregada com sucesso!");
					Consola.writeLine("Carregar Tabela 'foto'...");
					if (carregarFoto(pathFotos)) {
						Consola.writeLine("Tabela 'foto' carregada com sucesso!");
						ok = true;
					}
				}
			}
		}
		if (ok)
			try {
				con.commit();
				Consola.writeLine(
						"O carregamento das Tabelas 'aluno', 'disciplina', 'inscricao' e 'foto' foi concluido com sucesso.");
			} catch (SQLException e) {
				System.err.println("Commit, SQLException: " + e.getMessage());
				ok = false;
			}
		else
			try {
				con.rollback();
				Consola.writeLine(
						"O carregamento das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao' não teve sucesso.");
			} catch (SQLException e) {
				System.err.println("Rollback, SQLException: " + e.getMessage());
			}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			System.err.println("Autocommit, SQLException: " + e.getMessage());
			ok=false;
		}
		dados.desligar();
		return ok;
	}

	
	/**
	 * Pergunta o número do aluno ao utilizador e apresenta o certificado de habilitacões, 
	 * com anos, disciplinas e respectivas notas de aprovação.
	 */
	public static void certificado() {
		Integer numero = Consola.getCNumAl();

		String directiva = 
				"SELECT MIN(ANO) ANO, (SELECT DESIGNACAO FROM DISCIPLINA D WHERE D.CODIGO=X.CODIGO) DESIGNACAO, X.NOTA NTA "+ 
                    "FROM INSCRICAO X,(SELECT NUMERO, CODIGO, MAX(NOTA) NOTA "+
                    					   "FROM INSCRICAO "+
                    					   "WHERE "+condAprov+" "+
                    					   "GROUP BY NUMERO, CODIGO) Y "+
                    "WHERE X.NUMERO="+numero+" AND X.NUMERO=Y.NUMERO AND X.CODIGO=Y.CODIGO AND X.NOTA=Y.NOTA "+
                    "GROUP BY X.NUMERO, X.CODIGO, X.NOTA "+
                    "ORDER BY 1, 2";
		System.out.print(directiva);
		try {
			ResultSet rs = dados.getResultado(directiva);
			Consola.writeLine("    ***** Certificado do aluno Nº " + numero + " ****");
			Consola.writeLine(
					Consola.fill("Ano", 5, " ") + Consola.fill("Disciplina", 60, " ") + Consola.fill("Nota", 4, " "));
			while (rs != null && rs.next()) {
				Consola.writeLine(
						Consola.fill(rs.getString("ano"), 5, " ") + Consola.fill(rs.getString("designacao"), 60, " ")
								+ Consola.fill(Consola.NotaToString(rs.getBigDecimal("nta")), 4, " "));
			} 
			if (rs != null)
				Consola.writeLine("    *****  =============================   ****\r\n");
			else
				Consola.writeLine("Não foram encontradas avaliações do aluno Nº " + numero + ".");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLException: " + e.getMessage());
		}
	}

	/**
	 * Cria a tabela 'aluno'. Não faz commit nem rollback, porque vai ser executada
	 * no contexto de uma transação
	 * 
	 * @return true se correr bem
	 */
	public static boolean criarTabAluno() {
		return dados.xDirectiva("create table aluno (" 
				+ "numero               decimal(5) not null,"
				+ "nome                 varchar(100) not null," 
				+ "genero               char(1) not null,"
				+ "nascido              date not null," 
				+ "constraint pk_aluno primary key (numero),"
				+ "constraint ck_genero check (genero IN ('f','m','x','F','M','X'))" 
				+ ")");
	}
	
	/**
	 * Cria a vista 'Inscricoes'. Não faz commit nem rollback, porque vai ser executada
	 * no contexto de uma transação
	 * 
	 * @return true se correu bem
	 */
	public static boolean criarVistaInscricoes() {
		return dados.xDirectiva("CREATE VIEW Inscricoes AS"+
				" SELECT  I.NUMERO,"+
						" I.CODIGO,"+
						" (SELECT DESIGNACAO FROM DISCIPLINA S WHERE S.CODIGO=I.CODIGO) DESIGNACAO,"+
						" MAX(I.ANO) ANO"+
					" FROM INSCRICAO I, DISCIPLINA D"+
					" WHERE I.CODIGO=D.CODIGO AND NOTA IS NULL"+ 
					" GROUP BY 1, 2"+
					" HAVING ANO=(SELECT MAX(ANO) FROM INSCRICAO N WHERE N.NUMERO=I.NUMERO AND N.CODIGO=I.CODIGO)"+ 
					" ORDER BY 1, 2"
					);
	}
	
	/**
	 * Cria a vista 'avaliacoes'. Não faz commit nem rollback, porque vai ser executada
	 * no contexto de uma transação
	 * 
	 * @return true se correu bem
	 */
	public static boolean criarVistaAvaliacoes() {
		return dados.xDirectiva("CREATE VIEW Avaliacoes AS"+
			" SELECT "+
		        " x.numero AS NUMERO,"+
				" MIN(x.ano) AS ANO,"+
				" z.DESIGNACAO,"+
				" x.nota AS NOTA"+
		    " FROM"+
				" (inscricao x,"+ 
		        " (SELECT i.numero AS numero, i.codigo AS codigo, MAX(i.nota) AS MaxNota"+
					" FROM inscricao i"+
					" WHERE i.nota >= 10 AND i.nota <= 20"+
					" GROUP BY 1 , 2) y),"+ 
				" disciplina z"+
			" WHERE"+
					" x.codigo 	= 	z.codigo"+
				" AND x.numero 	= 	y.numero"+
		        " AND x.codigo 	= 	y.codigo"+
		        " AND x.nota 	= 	y.MaxNota"+
		    " GROUP BY 1 , 3 , 4"+
		    " ORDER BY 1 , 2 , 3");		
	}
	
	/**
	 * Cria a vista  que lista os registos em forma de tabela. 
	 * Não faz commit nem rollback, porque vai ser executada
	 * no contexto de uma transação
	 * 
	 * @return true se correu bem
	 */
	public static boolean criarVistaLista() {
		String diretiva= "CREATE VIEW lista AS"+
				" select a.numero, nome,"+
				" if(codigo is null, '-',codigo) codigo,"+
				" if(nota is null,if(ano is null, '-','--?--'),nota) as nota,"+ 
				" if(ano is null, '-',ano) ano,"+ 
				" YEAR(curdate())-YEAR(nascido) -"+
				" ((MONTH(nascido) > MONTH(curdate())) OR"+
				" (MONTH(nascido) = MONTH(curdate())) AND"+
				" (DAY(nascido) > DAY(curdate()))) as idade,"+
				" nascido,"+
				" (select count(*) from disciplina where codigo not in (select codigo from inscricao n where nota is not null and n.numero=a.numero)) as faltam"+
				" from aluno a left join inscricao i on a.numero=i.numero"+ 
				" order by faltam, numero, codigo, nota desc, ano desc";
		if(cfg.getSGBD()==Configura.SGBD.MSSqlServer)
			diretiva = diretiva.replaceAll("if(", "iif(");
		return dados.xDirectiva(diretiva);
	}
	
	/**
	 * Cria a tabela 'disciplina'. Não faz commit nem rollback, porque vai ser
	 * executada no contexto de uma transação
	 * 
	 * @return true se correu bem
	 */
	public static boolean criarTabDisciplina() {
		return dados.xDirectiva("create table disciplina (" 
				+ "codigo               char(4) not null,"
				+ "designacao           char(60) not null," 
				+ "constraint pk_disciplina primary key (codigo),"
				+ "constraint ak_designacao UNIQUE (designacao)" 
				+ ")");
	}

	/**
	 * Cria a tabela 'foto'. Não faz commit nem rollback, porque vai ser executada
	 * no contexto de uma transacção.
	 * 
	 * @return true se correu bem
	 */
	public static boolean criarTabFoto() {
		if (cfg.getSGBD() == GestAl.Configura.SGBD.MySQL)  // funciona para o MySQL
			return dados.xDirectiva("CREATE TABLE foto (" + "  numero decimal(5) NOT NULL COMMENT 'Número do estudante',"
					+ "  conteudo mediumblob NOT NULL COMMENT 'Conteudo da fotografia',"
					+ "  CONSTRAINT pk_foto PRIMARY KEY (numero),"
					+ "  CONSTRAINT fk_aluno FOREIGN KEY (numero) REFERENCES aluno (numero) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ") COMMENT='Fotografias dos alunos'");
		// funciona para o SQLServer
		return dados.xDirectiva("CREATE TABLE foto (" + "  numero decimal(5) NOT NULL,"
				+ "  conteudo varbinary(max) NOT NULL," + "  CONSTRAINT pk_foto PRIMARY KEY (numero),"
				+ "  CONSTRAINT fk_foto FOREIGN KEY (numero) REFERENCES aluno (numero) ON DELETE CASCADE ON UPDATE CASCADE" + ")");
	}
	
	/**
	 * Cria a tabela 'inscricao'. Não faz commit nem rollback, porque vai ser
	 * executada no contexto de uma transação
	 * 
	 * @return true se correu bem
	 */
	public static boolean criarTabInscricao() {
		return dados.xDirectiva("create table inscricao (" 
				+ "numero               decimal(5) not null,"
				+ "codigo               char(4) not null," 
				+ "ano                  int not null,"
				+ "nota                 decimal(4,2) null,"
				+ "constraint pk_inscricao primary key (numero, codigo, ano),"
				+ "constraint fk1_inscricao FOREIGN KEY (codigo) REFERENCES disciplina (codigo) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "constraint fk2_inscricao FOREIGN KEY (numero) REFERENCES aluno (numero) ON UPDATE CASCADE,"
				+ "constraint ck_nota CHECK (nota IS NULL OR nota >= 0 AND nota<=20)" 
				+ ")");
	}

	/**
	 * Cria, no contexto de uma transacção as tabelas 'aluno', 'disciplina', foto e
	 * 'inscricao'. Caso ocorra algum erro a transacção é desfeita, repondo a
	 * situação anterior à execução.
	 */
	public static boolean criarTabelas() {
		boolean ok = false;
		Connection x=dados.getLigacao();
		try {
			x.setAutoCommit(false);
		} catch (SQLException e) {
			Consola.writeLine("Falhou a criação das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao'!");
			e.printStackTrace();
			return false;
		}
		Consola.writeLine("Criação das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao'...");
		Consola.writeLine("Criar Tabela 'aluno'...");
		if (criarTabAluno()) {
			Consola.writeLine("Tabela 'aluno' criada.");
			Consola.writeLine("Criar Tabela 'disciplina'...");
			if (criarTabDisciplina()) {
				Consola.writeLine("Tabela 'disciplina' criada.");
				Consola.writeLine("Criar Tabela 'foto'...");
				if (criarTabFoto()) {
					Consola.writeLine("Tabela 'foto' criada.");
					Consola.writeLine("Criar Tabela 'inscricao'...");
					if (criarTabInscricao()) {
						Consola.writeLine("Tabela 'inscricao' criada.");
						ok = true;
					} else {
						Consola.writeLine("Falhou a criação da tabela 'inscrição'!");
					}
				} else {
					Consola.writeLine("Falhou a criação da tabela 'foto'!");
				}
			} else {
				Consola.writeLine("Falhou a criação da tabela 'disciplina'!");
			}
		} else {
			Consola.writeLine("Falhou a criação da tabela 'aluno'!");
		}
		try {
			if (ok) {
				x.commit();
				Consola.writeLine("A criação das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao' foi concluida.");
			} else {
				x.rollback();
				Consola.writeLine("A criação das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao' não teve sucesso!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			x.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return ok;
	}
	
	/**
	 * Cria, no contexto de uma transacção as vistas 'inscricoes', 'avaliações' e 'resumo'
	 * Caso ocorra algum erro a transacção é desfeita, repondo a
	 * situação anterior à execução.
	 */
	public static boolean criarVistas() {
		boolean ok = false;
		try {
			dados.getLigacao().setAutoCommit(false);
		} catch (SQLException e) {
			Consola.writeLine("Falhou a criação das Vistas 'inscricoes', 'avaliações' e 'lista'!");
			e.printStackTrace();
			return false;
		}
		Consola.writeLine("Criação das Vistas 'inscricoes', 'avaliações' e 'lista'...");
		Consola.writeLine("Criar vista 'inscricoes'...");
		if (criarVistaInscricoes()) {
			Consola.writeLine("Vista 'inscricoes' criada.");
			Consola.writeLine("Criar Vista 'avaliaçoes'...");
			if (criarVistaAvaliacoes()) {
				Consola.writeLine("Vista 'avaliaçoes' criada.");
				Consola.writeLine("Criar Vista 'lista'...");
				if (criarVistaLista()) {
					Consola.writeLine("Vista 'lista' criada.");
					ok=true;
				} else {
					Consola.writeLine("Falhou a criação da Vista 'lista'!");
				}
			} else {
				Consola.writeLine("Falhou a criação da Vista 'avaliaçoes'!");
			}
		} else {
			Consola.writeLine("Falhou a criação da Vista 'inscricoes'!");
		}
		try {
			if (ok) {
				dados.getLigacao().commit();
				Consola.writeLine("A criação das Vistas 'inscricoes', 'avaliações' e 'lista' foi concluida.");
			} else {
				dados.getLigacao().rollback();
				Consola.writeLine("A criação das Vistas 'inscricoes', 'avaliações' e 'lista' não teve sucesso!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			dados.getLigacao().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return ok;
	}
	/**
	 * Faz um processamento estatístico sobre a tabela 'inscricao'.
	 * 
	 * @param codigo código da disciplina envolvida no processamento (pode ser null)
	 * @param cond   condição de selecção
	 * @param func   função de agregação
	 * @return valor da estatística
	 */
	public static BigDecimal estatistica(String codigo, String cond, String func) {
		Manipula local = new Manipula(new Configura());
		BigDecimal ret = null;
		String directiva = "select " + func + " from inscricao where " + cond;
		if (codigo != null)
			directiva = directiva + " and codigo='" + codigo + "'";
		try {
			ResultSet valor = local.getResultado(directiva);
			if (valor!=null && valor.next()) {
				ret = new BigDecimal(valor.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
		local.desligar();
		return ret;
	}

	/**
	 * Pede ao utilizador o nome de uma tabela e gera as instruções SQL Insert, que
	 * podem ser utilizadas para carregar a tabela
	 */
	public static void exportarTabela() {
		Consola.writeLine("Exporta o conteudo de uma tabela.");
		Consola.writeLine("Indique/escreva o nome de uma tabela, por exemplo:");
		dados.getTabelas(cfg.getDB());
		String tabela = Consola.readLine();
		if (tabela.length() > 0)
			dados.exportar(tabela);
	}

	/**
	 * Apresenta a ficha do aluno.
	 * 
	 * @param numero do aluno
	 */
	public static void fichaAluno(String numero) {
		Manipula local = new Manipula(new Configura());
		//Connection con = local.getLigacao();
		String directiva = "select numero, nome, genero, nascido from aluno where numero=" + numero;
		try {
			//con.setAutoCommit(false);
			ResultSet rs = local.getResultado(directiva);
			if (rs != null && rs.next()) {// só pode apanhar 1 linha
				Consola.writeLine("  ==================>");
				Consola.writeLine("  Número: " + rs.getString("numero") + "");
				Consola.writeLine("  Nome: \"" + Consola.proper(rs.getString("nome")) + "\"");
				Consola.writeLine("  Género: '" + rs.getString("genero") + "'");
				Consola.writeLine("  Nascido: " + Consola.DateToString(rs.getDate("nascido")));
				Consola.writeLine("  <==================");
			} else
				Consola.writeLine("Não foi encontrado o aluno como o número: " + numero + ".");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
		local.desligar();
	}
	
	

	/**
	 * Apresenta a ficha de uma disciplina.
	 * 
	 * @param codigo da disciplina
	 *
	 */
	public static void fichaDisciplina(String codigo) {
		Manipula local = new Manipula(new Configura());
		String directiva = "select codigo, designacao from disciplina where codigo='" + codigo + "'";
		try {
			ResultSet rs = local.getResultado(directiva);
			if (rs != null && rs.next()) {
				Consola.writeLine("  ==================>");
				Consola.writeLine("  Código: '" + rs.getString("codigo") + "'");
				Consola.writeLine("  Designação: '" + rs.getString("designacao") + "'");
				Consola.writeLine("  <==================");
			} else
				Consola.writeLine("Não foi encontrada a disciplina com o código: " + codigo + ".");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
		local.desligar();
	}

	/**
	 * Pergunta o número do aluno e o código da disciplina, realizando a inscrição
	 * no ano actual.
	 * 
	 * @return true se correu bem
	 */
	public static boolean inscricaoAluno() {
		Integer numero = Consola.getCNumAl();
		String codigo = Consola.getCCodDis();
		String ano = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		// pode não funcionar bem, deve usar-se a data do servidor, por exemplo, getDate() no sqlServer
		if (!dados.xDirectiva(
				"insert into inscricao (numero, ano, codigo) values (" + numero + ", " + ano + ", '" + codigo + "')")) {
			Consola.writeLine(
					"Não foi possivel realizar a inscrição do aluno Nº " + numero + " na disciplina '" + codigo + "'");
			return false;
		}
		Consola.writeLine("Foi realizada com sucesso a inscrição do aluno Nº " + numero + " na disciplina '" + codigo
				+ "' no ano " + ano + " .");
		return true;
	}

	/**
	 * Pergunta o código da disciplina, o ano de funcionamento, o número do aluno e
	 * a nota. Usando estes dados actualiza na tabela 'inscricao' a nota do ano, se
	 * ele ainda não tiver nota atribuida.
	 * 
	 * @return true se correu bem
	 */
	public static boolean lancarNota() {
		String codigo = Consola.getCCodDis();
		Integer ano = Consola.getCAnoDis();
		Integer numero = Consola.getCNumAl();
		BigDecimal nota = Consola.getCNotaDis();
		if (!dados.xDirectiva("update inscricao set nota=" + nota + " where numero=" + numero + " and ano=" + ano
				+ " and codigo='" + codigo + "' and nota is null")) {
			Consola.writeLine("Não foi possivel lançar a nota do aluno Nº " + numero + " na disciplina '" + codigo
					+ "' do ano de " + ano + ".");
			return false;
		}
		if (dados.isUpdated()) {
			Consola.writeLine("A nota " + Consola.NotaToString(nota) + " do aluno nº " + numero + " na disciplina '"
					+ codigo + "' do ano de " + ano + " foi lançada com sucesso.");
		} else
			Consola.writeLine("Confirme os dados fornecidos. Não foi possível lançar a nota do aluno Nº " + numero
					+ " na disciplina '" + codigo + "' relativa ao ano de " + ano + ".");
		return true;
	}

	/**
	 * Apresenta uma estatística de todos os alunos aprovados e reprovados, com a
	 * respectiva percentagem de aprovação
	 */

	public static void listarARP() {
		Consola.writeLine("    *****  Estatística Global  *****");
		Consola.writeLine("    " + Consola.fill("Aprov", 10, " ") + Consola.fill("Reprov", 10, " ")
				+ Consola.fill("Percentagem", 10, " "));
		BigDecimal nAprov = estatistica(null, condAprov, "count(*)");
		BigDecimal nReprov = estatistica(null, 
									" NOT (" + condAprov + ") and ano<="+Year.now().getValue(), 
									"count(*)");
		BigDecimal nTotal = nAprov.add(nReprov);
		String sPer = " -";
		if (BigDecimal.ZERO.compareTo(nTotal) != 0) {
			BigDecimal nPer = nAprov.divide(nTotal,3, RoundingMode.HALF_UP);
			sPer = NumberFormat.getPercentInstance().format(nPer);
		}
		Consola.writeLine("    " + Consola.fill(nAprov.toString(), 10, " ") + Consola.fill(nReprov.toString(), 10, " ")
				+ Consola.fill(sPer, 10, " "));
		Consola.writeLine("    ********************************\r\n");
	}

	/**
	 * Apresenta uma tabela ordenada por disciplina, com as respectivas notas
	 * mínima, máxima e média.
	 */
	public static void listarMMM() {
		String directiva = "select designacao, min(nota), max(nota), avg(nota) from inscricao as i, disciplina as d "
				+ "where i.codigo=d.codigo and " + condAprov + " group by designacao";
		try {
			ResultSet rs = dados.getResultado(directiva);
			Consola.writeLine("    ************************** Estatística de Notas *****************************");
			Consola.writeLine("    " + Consola.fill("Disciplina", 60, " ") + Consola.fill(" Min", 6, " ")
					+ Consola.fill(" Max", 6, " ") + Consola.fill("Média", 6, " "));
			Consola.writeLine("    =============================================================================");
			while (rs != null && rs.next()) {
				String designacao = rs.getString(1);
				BigDecimal nMin = rs.getBigDecimal(2);
				BigDecimal nMax = rs.getBigDecimal(3);
				BigDecimal nMed = rs.getBigDecimal(4);
				Consola.writeLine("    " 
								+ Consola.fill(designacao, 60, " ") + Consola.fill(Consola.NotaToString(nMin), 6, " ")
								+ Consola.fill(Consola.NotaToString(nMax), 6, " ")
								+ Consola.fill(Consola.NotaToString(nMed), 6, " "));
			}
			if (rs != null)
				Consola.writeLine(
						"    =============================================================================\r\n");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
	}

	/**
	 *  conta  as notas já lançadas
	 *  por isso pode emitir o certificado de habilitacões 
	 */
	public static String temCertificado(String numero) {
		if(numero==null || numero.compareTo("")==0)
			return "0";
		String directiva = 	"select count(numero) conta from avaliacoes where numero="+numero;
		try {
			ResultSet rs=dados.getResultado(directiva);
			if(rs!=null && rs.next())
				return rs.getString("conta");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
		return "0";
	}
	/**
	 *  Retorna a quantidade de inscricoes ativas do aluno
	 */
	public static String temInscricoes(String numero) {
		if(numero==null || numero.compareTo("")==0)
			return "0";
		String directiva = "select count(numero) conta from inscricoes where numero="+numero;
		try {
			ResultSet rs=dados.getResultado(directiva);
			if(rs!=null && rs.next())
				return rs.getString("CONTA");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
		return "0";
	}
	/**
	 * Retorna a quantidade de inscricoes ativas da disciplina
	 */
	public static String qInscricoes(String disc) {
		if(disc==null || disc.compareTo("")==0)
			return "0";
		String directiva = "select count(codigo) conta from inscricoes where codigo='"+disc+"'";
		try {
			ResultSet rs=dados.getResultado(directiva);
			if(rs!=null && rs.next())
				return rs.getString("CONTA");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
		return "0";
	}
	/**
	 * Executa a aplicação de Gestor Académico.
	 * 
	 * @param args nenhum
	 */
	public static void main(String[] args) {
		char op;
		do {
			Consola.writeLine("*** Menu do Gestor Académico ***");
			Consola.writeLine("0. Terminar");
			Consola.writeLine("1. Administração");
			Consola.writeLine("2. Alunos");
			Consola.writeLine("3. Disciplinas");
			Consola.writeLine("4. Avaliações");
			Consola.writeLine("5. Relatórios");
			op = Consola.readChar();
			switch (op) {
			case '1':
				do {
					Consola.writeLine("> Administração");
					Consola.writeLine("a. Criar tabelas e vistas");
					Consola.writeLine("b. Carregar tabelas");
					Consola.writeLine("c. Remover vistas e tabelas");
					Consola.writeLine("d. Apagar tabelas");
					Consola.writeLine("e. Exportar tabela");
					Consola.writeLine("z. Voltar");
					op = Consola.readChar();
					switch (op) {
					case 'a':
						if(criarTabelas()) 
							criarVistas();
						break;
					case 'b':
						carregarTabelas("src\\main\\webapp\\pessoas\\");
						break;
					case 'c':
						if(removerTabelas())
							removerVistas();
						break;
					case 'd':
						apagarTabelas();
						break;
					case 'e':
						exportarTabela();
						break;
					case 'z':
						break;
					default:
						Consola.writeLine("Opção inválida. Tente outra vez.");
					}
				} while (op != 'z');
				break;
			case '2':
				do {
					Consola.writeLine("> Alunos");
					Consola.writeLine("a. Novo aluno");
					Consola.writeLine("b. Alterar o nome");
					Consola.writeLine("c. Procurar pelo número");
					Consola.writeLine("d. Procurar pelo nome");
					Consola.writeLine("e. Procurar pela data de nascimento");
					Consola.writeLine("z. Voltar");
					op = Consola.readChar();

					switch (op) {
					case 'a':
						novoAluno();
						break;
					case 'b':
						alterarAlNome();
						break;
					case 'c':
						procurarAlNumero();
						break;
					case 'd':
						procurarAlNome();
						break;
					case 'e':
						procurarAlNasc();
						break;
					case 'z':
						break;
					default:
						Consola.writeLine("Opção inválida. Tente outra vez.");
					}
				} while (op != 'z');
				break;
			case '3':
				do {
					Consola.writeLine("> Disciplinas");
					Consola.writeLine("a. Nova disciplina");
					Consola.writeLine("b. Alterar a designação");
					Consola.writeLine("c. Procurar pelo código");
					Consola.writeLine("d. Procurar pela designação");
					Consola.writeLine("z. Voltar");
					op = Consola.readChar();

					switch (op) {
					case 'a':
						novaDisciplina();
						break;
					case 'b':
						alterarDisDesg();
						break;
					case 'c':
						procurarDisCodigo();
						break;
					case 'd':
						procurarDisDesg();
						break;
					case 'z':
						break;
					default:
						Consola.writeLine("Opção inválida. Tente outra vez.");
					}
				} while (op != 'z');
				break;
			case '4':
				do {
					Consola.writeLine("> Avaliações");
					Consola.writeLine("a. Inscrição");
					Consola.writeLine("b. Lançar Nota");
					Consola.writeLine("z. Voltar");
					op = Consola.readChar();

					switch (op) {
					case 'a':
						inscricaoAluno();
						break;
					case 'b':
						lancarNota();
						break;
					case 'z':
						break;
					default:
						Consola.writeLine("Opção inválida. Tente outra vez.");
					}
				} while (op != 'z');
				break;
			case '5':
				do {
					Consola.writeLine("> Relatórios");
					Consola.writeLine("a. Pauta da disciplina");
					Consola.writeLine("b. Certificado de habilitações");
					Consola.writeLine("c. Estatística global");
					Consola.writeLine("d. Estatística de notas");
					Consola.writeLine("z. Voltar");
					op = Consola.readChar();

					switch (op) {
					case 'a':
						pauta();
						break;
					case 'b':
						certificado();
						break;
					case 'c':
						listarARP();
						break;
					case 'd':
						listarMMM();
						break;
					case 'z':
						break;
					default:
						Consola.writeLine("Opção inválida. Tente outra vez.");
					}
				} while (op != 'z');
				break;
			case '0':

				break;
			default:
				Consola.writeLine("Opção inválida. Tente outra vez.");
			}
		} while (op != '0');
		Consola.writeLine("Terminou a execução do Gestor Académico.");
	}

	/**
	 * Pergunta o código e a designação da disciplina e insere a nova disciplina na
	 * respectiva tabela.
	 * 
	 * @return true se tudo correr bem
	 */
	public static boolean novaDisciplina() {
		String codigo = Consola.getCCodDis();
		String designacao = Consola.getCDsgDis();
		if (!dados.xDirectiva("insert into disciplina values ('" + codigo.toUpperCase() + "','" + designacao + "')"))
			return false;
		fichaDisciplina(codigo);
		return true;
	}

	/**
	 * No contexto de uma transação, pergunta o nome, o género e a data de
	 * nascimento do novo aluno. Faz a inserção dos dados na Base de Dados para
	 * determinar o número desse aluno. Por último, apresenta ao utilizador a ficha
	 * do aluno para confirmação dos dados, após a qual a transação é terminada (ou
	 * desfeita). 
	 * 
	 */
	public static void novoAluno() {
		boolean ok = false;
		try {
			Connection con = dados.getLigacao();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
			return;
		}
		Consola.writeLine("Inserção de dados de um novo aluno:");
		String nome = Consola.getCNome();
		String genero = Consola.getCGenAl();
		java.sql.Date nascido = Consola.getCNascAl();
		String directiva = "insert into aluno (numero, nome, genero, nascido) "+
								"select coalesce(max(numero), 0)+1, '" + nome.replaceAll("'", "''") + "','"
									+ genero + "'," + Configura.formatar(nascido) + " from aluno";
		if (dados.xDirectiva(directiva)) {
			try {
				directiva = "select numero, nome, genero, nascido from aluno where nome='" + nome + "' and nascido = " 
							+ Configura.formatar(nascido)	+ " order by numero desc";
				ResultSet rs = dados.getResultado(directiva);
				if (rs != null && rs.next()) {
					// fichaAluno(rs.getString("numero"));
					Consola.writeLine("  ==================>");
					Consola.writeLine("  Número: " + rs.getString("numero") + "");
					Consola.writeLine("  Nome: \"" + Consola.proper(rs.getString("nome")) + "\"");
					Consola.writeLine("  Género: '" + rs.getString("genero") + "'");
					Consola.writeLine("  Nascido: " + Consola.DateToString(rs.getDate("nascido")));
					Consola.writeLine("  <==================");
					String resp = null;
					do {
						Consola.writeLine("Os dados estão correctos (S/N)?");
						resp = Consola.readLine().substring(0, 1).toUpperCase();
						ok = resp.compareTo("S") == 0;
					} while (resp.compareTo("S") != 0 && resp.compareTo("N") != 0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("-----SQLException-----");
				System.err.println("SQLState:  " + e.getSQLState());
				System.err.println("Message:  " + e.getMessage());
				System.err.println("Vendor:  " + e.getErrorCode());
				ok = false;
			}
		}
		try {
			if (ok) {
				dados.getLigacao().commit();
				Consola.writeLine("Criação do aluno '" + nome + "' com sucesso.");
			} else {
				dados.getLigacao().rollback();
				Consola.writeLine("Não foi possível criar o aluno com os dados:");
				Consola.writeLine("  Nome: '" + nome + "'");
				Consola.writeLine("  Género: '" + genero + "'");
				Consola.writeLine("  Nascido: " + nascido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			dados.getLigacao().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pergunta o código da disciplina e ano de funcionamento, apresentando
	 * seguidamente a respectiva pauta com numero do aluno, nome do aluno e nota
	 * ordenada por número de aluno.
	 */
	public static void pauta() {
		String codigo = Consola.getCCodDis();
		Integer ano = Consola.getCAnoDis();
		String directiva = "select a.numero, nome, MAX(NOTA) NOTA "
				+ "from aluno as a, inscricao as i where a.numero=i.numero and i.codigo='"
				+ codigo + "' and ano = " + ano + " GROUP BY A.NUMERO, CODIGO order by a.numero";
		try {
			ResultSet rs = dados.getResultado(directiva);
			Consola.writeLine("           ***** Pauta da disciplina '" + codigo.trim() + "' no ano de " + ano + " ****");
			Consola.writeLine(Consola.fill("Nº", 5, " ") + Consola.fill("Nome", 60, " ") + Consola.fill("Nota", 4, " "));
			boolean vazio = false;
			while (rs != null && rs.next()) {
				vazio = false;
				Consola.writeLine(Consola.fill(rs.getString(1), 5, " ") + Consola.fill(rs.getString(2).trim(), 60, " ")
						+ Consola.fill(rs.getString(3)==null?"  -":rs.getString(3), 4, " "));
			}
			if (vazio)
				Consola.writeLine("Não foi encontrada a disciplina " + codigo + " do ano " + ano + ".");
			if (rs != null)
				Consola.writeLine("           *****  ===================================   ****\r\n");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
	}
	/**
	 * Pergunta uma data de nascimento para ser utilizada numa seleção de alunos.
	 * Como resultado apresenta o conjunto de fichas de alunos que satisfazem a data
	 * indicada.
	 */
	public static void procurarAlNasc() {
		boolean vazio = true;
		java.sql.Date nascido = Consola.getCNascAl();
		try {
			ResultSet rs = dados.getResultado("select numero, nome, genero, nascido from aluno where nascido ="
					+ Configura.formatar(nascido) + " order by numero desc");
			int indice = 1;
			while (rs != null && rs.next()) {
				vazio = false;
				Consola.writeLine(indice++ + " - Foi encontrado o aluno com os dados:");
				Consola.writeLine("  Número: " + rs.getString("numero") + "");
				Consola.writeLine("  Nome: '" + rs.getString("nome") + "'");
				Consola.writeLine("  Género: '" + rs.getString("genero") + "'");
				Consola.writeLine("  Nascimento: " + Consola.DateToString(rs.getDate("nascido")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (vazio)
			Consola.writeLine("A pesquisa com a data de nascimento '" + Consola.DateToString(nascido)
					+ "' não encontrou nenhum aluno.");
	}

	/**
	 * Pergunta uma express�o de pesquisa relativa ao nome para ser utilizada numa
	 * seleção de alunos. Como resultado apresenta o conjunto de fichas de alunos
	 * que satisfazem expressão indicada. Se for indicada uma expressão vazia são
	 * listadas todas as fichas.
	 */
	public static void procurarAlNome() {
		boolean vazio = true;
		String nome = null;
		do {
			Consola.writeLine("Indique a expressão para pesquisar pelo nome [%,_,...]:");
			nome = Consola.readLine();
			nome = nome.trim();
		} while (nome.length() > 100);
		String directiva;
		try {
			directiva = "select numero from aluno";
			if (nome.length() > 0)
				directiva = directiva + " where nome like '" + nome + "'";
			directiva = directiva + " order by numero";
			ResultSet rs = dados.getResultado(directiva);
			int indice = 1;
			while (rs != null && rs.next()) {
				vazio = false;
				Consola.writeLine(indice++ + " - Foi encontrado o aluno com os dados:");
				fichaAluno(rs.getString("numero"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
		if (vazio)
			Consola.writeLine("A pesquisa com a expressão '" + nome + "' não encontrou nenhum aluno.");
	}

	/**
	 * Pergunta um número de aluno para ser utilizado numa seleção de alunos. 
	 * Como resultado apresenta a ficha do aluno relativa ao número indicado.
	 */
	public static void procurarAlNumero() {
		Integer numero = Consola.getCNumAl();
		fichaAluno(numero.toString());
		showFoto(numero);
	}

	/**
	 * Pergunta um código de disciplina para ser utilizado numa seleção de
	 * disciplinas. Como resultado apresenta a ficha da disciplina relativa ao
	 * código indicado.
	 */
	public static void procurarDisCodigo() {
		String codigo = Consola.getCCodDis();
		Consola.writeLine("Dados da disciplina:");
		fichaDisciplina(codigo);
	}

	/**
	 * Pergunta uma expressão de pesquisa relativa à designação de disciplina para
	 * ser utilizada numa seleção de disciplinas. Como resultado apresenta o
	 * conjunto de fichas de disciplinas que satisfazem a express�o de pesquisa. Se
	 * for indicada uma express�o vazia são listadas todas as fichas.
	 */
	public static void procurarDisDesg() {
		String designacao = "";
		boolean vazio = true;
		do {
			Consola.writeLine("Indique a expressão para pesquisar pela designação [%,_,...]:");
			designacao = Consola.readLine();
			designacao = designacao.trim();
		} while (designacao.length() > 60);
		String directiva;
		try {
			directiva = "select codigo from disciplina";
			if (designacao.length() > 0)
				directiva = directiva + " where designacao like '" + designacao + "'";
			directiva = directiva + " order by codigo";
			ResultSet rs = dados.getResultado(directiva);
			int indice = 1;
			while (rs != null && rs.next()) {
				vazio = false;
				Consola.writeLine(indice++ + "-Foi encontrada a disciplina com os dados:");
				fichaDisciplina(rs.getString("codigo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("-----SQLException-----");
			System.err.println("SQLState:  " + e.getSQLState());
			System.err.println("Message:  " + e.getMessage());
			System.err.println("Vendor:  " + e.getErrorCode());
		}
		if (vazio)
			Consola.writeLine("A pesquisa com a express�o '" + designacao + "' n�o encontrou nenhuma disciplina.");
	}

	/**
	 * Remove, no contexto de uma transacção as tabelas 'aluno', 'disciplina', 'foto' e
	 * 'inscricao'. Caso ocorra algum erro a transacção é desfeita, repondo a
	 * situação anterior à execução.
	 * 
	 * @return true se correu bem
	 */

	public static boolean removerTabelas() {
		boolean ok = false;
		try {
			dados.getLigacao().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			Consola.writeLine("A remoção das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao' não teve sucesso.");
			System.err.println("Autocommit, SQLException: " + e.getMessage());
			return false;
		}
		Consola.writeLine("Removoção das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao'...");
		Consola.writeLine("Remover Tabela 'inscricao'...");
		if (dados.xDirectiva("DROP TABLE INSCRICAO")) {
			Consola.writeLine("Tabela 'inscricao' removida com sucesso!");
			Consola.writeLine("Remover Tabela 'foto'...");
			if (dados.xDirectiva("DROP TABLE FOTO")) {
				Consola.writeLine("Tabela 'foto' removida com sucesso!");
				Consola.writeLine("Remover Tabela 'aluno'...");
				if (dados.xDirectiva("DROP TABLE ALUNO")) {
					Consola.writeLine("Tabela 'aluno' removida com sucesso!");
					Consola.writeLine("Remover Tabela 'disciplina'...");
					if (dados.xDirectiva("DROP TABLE DISCIPLINA")) {
						Consola.writeLine("Tabela 'disciplina' removida com sucesso!");
						ok = true;
					}
				}
			}
		}
		if (ok)
			try {
				dados.getLigacao().commit();
				Consola.writeLine(
						"A remoção das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao' foi concluida com sucesso.");
			} catch (SQLException e) {
				System.err.println("Commit, SQLException: " + e.getMessage());
				ok = false;
			}
		else
			try {
				dados.getLigacao().rollback();
				Consola.writeLine(
						"A remoção das Tabelas 'aluno', 'disciplina', 'foto' e 'inscricao' não teve sucesso.");
			} catch (SQLException e) {
				System.err.println("Rollback, SQLException: " + e.getMessage());
			}
		try {
			dados.getLigacao().setAutoCommit(true);
		} catch (SQLException e) {
			System.err.println("Autocommit, SQLException: " + e.getMessage());
		}
		return ok;
	}
	/**
	 * Remove, no contexto de uma transacção as vistas 'inscricoes', 'avaliacoes' e 'resumo'
	 * Caso ocorra algum erro a transacção é desfeita, repondo a
	 * situação anterior à execução.
	 * 
	 * @return 		true se correu bem
	 */

	public static boolean removerVistas() {
		boolean ok = false;
		try {
			dados.getLigacao().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			Consola.writeLine("A remoção das Vistas 'inscricoes', 'avaliacoes' e 'resumo' não teve sucesso.");
			System.err.println("Autocommit, SQLException: " + e.getMessage());
			return false;
		}
		Consola.writeLine("Removoção das Vistas inscricoes', 'avaliacoes' e 'lista'...");
		Consola.writeLine("Remover Vista 'inscricoes'...");
		if (dados.xDirectiva("DROP VIEW inscricoes")) {
			Consola.writeLine("Vista 'inscricoes' removida.");
			Consola.writeLine("Remover Vista 'avaliacoes'...");
			if (dados.xDirectiva("DROP VIEW avaliacoes")) {
				Consola.writeLine("Vista 'avaliacoes' removida.");
				Consola.writeLine("Remover Vista 'lista'...");
				if (dados.xDirectiva("DROP VIEW lista")) {
					Consola.writeLine("Vista 'lista' removida.");
					ok = true;
				}
			}
		}
		if (ok)
			try {
				dados.getLigacao().commit();
				Consola.writeLine(
						"A remoção das Vistas 'inscricoes', 'avaliacoes' e 'lista' foi concluida.");
			} catch (SQLException e) {
				System.err.println("Commit, SQLException: " + e.getMessage());
				ok = false;
			}
		else
			try {
				dados.getLigacao().rollback();
				Consola.writeLine(
						"A remoção das Vistas 'inscricoes', 'avaliacoes' e 'lista' não teve sucesso!");
			} catch (SQLException e) {
				System.err.println("Rollback, SQLException: " + e.getMessage());
			}
		try {
			dados.getLigacao().setAutoCommit(true);
		} catch (SQLException e) {
			System.err.println("Autocommit, SQLException: " + e.getMessage());
		}
		return ok;
	}
}