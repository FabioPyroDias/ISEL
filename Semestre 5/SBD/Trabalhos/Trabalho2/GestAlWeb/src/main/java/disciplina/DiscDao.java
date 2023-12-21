package disciplina;

import java.util.*;

import GestAl.Manipula;

import java.sql.*;

public class DiscDao {


	public static int save(Disc d) {
		if (d.getCodigo() == null || d.getCodigo().compareTo("") == 0 || d.getDesignacao() == null || d.getDesignacao().compareTo("") == 0)
			return 0;
		Manipula dados = new Manipula();
		dados.xDirectiva("INSERT INTO disciplina (codigo, designacao) VALUES ('"+d.getCodigo().replaceAll("'","''")+"','"
		+d.getDesignacao().trim().replaceAll("'","''")+"')");
		int status=dados.linhasAfetadas;
		dados.desligar();
		return status;
	}

	public static int update(Disc d, Disc o) {
		if (d.getCodigo() == null || d.getCodigo().compareTo("") == 0 || d.getDesignacao() == null || d.getDesignacao().compareTo("") == 0 ||
			o.getCodigo() == null || o.getCodigo().compareTo("") == 0 || o.getDesignacao() == null || o.getDesignacao().compareTo("") == 0)
			return 0;
		Manipula dados = new Manipula();
		dados.xDirectiva("UPDATE disciplina"+
							" SET "+
								" codigo='"+d.getCodigo().replaceAll("'","''")+"', "+ 
								" designacao='"+d.getDesignacao().trim().replaceAll("'","''")+"'"+
							" WHERE"+
								" codigo='"+o.getCodigo().replaceAll("'","''")+"' AND"+ 
								" designacao='"+o.getDesignacao().replaceAll("'","''")+"'");
		int status=dados.linhasAfetadas;
		dados.desligar();
		return status;
	}

	public static int delete(Disc d) {
		if (d.getCodigo() == null || d.getCodigo().compareTo("") == 0 || d.getDesignacao() == null || d.getDesignacao().compareTo("") == 0)
			return 0;
		Manipula dados = new Manipula();
		dados.xDirectiva("DELETE FROM disciplina"+
								" WHERE"+
									" codigo='"+d.getCodigo().replaceAll("'","''")+"' AND"+ 
									" designacao='"+d.getDesignacao().replaceAll("'","''")+"'");
		int status=dados.linhasAfetadas;
		dados.desligar();
		return status;
	}

	public static Disc getDiscByCodigo(String codigo) {
		if (codigo == null || codigo.compareTo("") == 0) {
			return null;
		}
		Disc d = new Disc();
		Manipula dados = new Manipula();
		ResultSet rs = dados.getResultado("SELECT codigo, designacao FROM disciplina WHERE codigo='"+codigo.replaceAll("'","''")+"'");
		try {
			if (rs.next()) {
				d.setCodigo(rs.getString("codigo"));
				d.setDesignacao(rs.getString("designacao"));
			}
			else
				d=null;
		} catch (SQLException e) {
			System.err.println("Erro no Select: (" + e.getErrorCode() + ") " + e.getMessage());
			d=null;
		}
		dados.desligar();
		return d;
	}

	public static List<Disc> getAllDisc() {
		List<Disc> list = new ArrayList<Disc>();
		Manipula dados = new Manipula();
		ResultSet rs = dados.getResultado("SELECT codigo, designacao FROM disciplina ORDER BY codigo");
		try {
			while (rs.next()) {
				Disc d = new Disc();
				d.setCodigo(rs.getString("codigo"));
				d.setDesignacao(rs.getString("designacao"));
				list.add(d);
			}
		} catch (SQLException e) {
			System.err.println("Erro no Select: (" + e.getErrorCode() + ") " + e.getMessage());
		}
		dados.desligar();
		return list;
	}
}
