package tp2.memproc.mem;
import java.util.Queue;
import tp2.modprob.Estado;
import java.util.HashMap;

public class MemoriaProcura {
	protected Queue<No> fronteira;
	protected HashMap<Estado,No> explorados;
	
	public MemoriaProcura(Queue<No> fronteira) {
		this.fronteira = fronteira;
		this.explorados = new HashMap<Estado,No>();

	}


	public void limpar() {
		this.fronteira.clear();
		this.explorados.clear();
	}
	
	public void inserir(No no) {
		this.fronteira.add(no);
	}

	public No remover() { //remove o head da lista
		return this.fronteira.remove();
	}
	
	public boolean fronteiraVazia() {
		return this.fronteira.isEmpty();
	}
	
}
//TODO: