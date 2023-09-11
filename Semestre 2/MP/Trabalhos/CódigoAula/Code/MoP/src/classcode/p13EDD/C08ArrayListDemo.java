package classcode.p13EDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class C08ArrayListDemo {

	public static void main(String[] args) {

		// um ArrayList de Strings
		ArrayList<String> al1 = new ArrayList<String>(Arrays.asList("um",
				"dois", "três"));
		System.out.println(al1);

		ArrayList<String> al2 = new ArrayList<String>(Arrays.asList("cinco",
				"seis", "sete"));
		System.out.println(al2);

		ArrayList<ArrayList<String>> aal = new ArrayList<ArrayList<String>>();
		aal.add(al1);
		aal.add(al2);

		System.out.println(aal);

	}
}

// cenário de: Agência - tema - assunto - notícia
class Noticia {
	private String titulo;
	private String texto;
	private Date data;
	List<Noticia> noticiasRelacionadas = new ArrayList<Noticia>();

	public Noticia(String titulo, String texto, Date data) {
		this.titulo = titulo;
		this.texto = texto;
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}

// neste caso um assunto é ele próprio um arrayList pelo que permite chamar os
// métodos de ArrayList directamnet sobre ele - é um caso só exemplificativo
class Assunto extends ArrayList<Noticia> {
	private static final long serialVersionUID = 2438685905533040703L;
	String name;

}

class Tema {
	String name;
	List<Assunto> assuntos = new ArrayList<Assunto>();

	public Tema(String name) {
		this.name = name;
	}
}

class Agencia {
	String name;
	List<Tema> temas = new ArrayList<Tema>();

	public Agencia(String name) {
		this.name = name;
	}
}