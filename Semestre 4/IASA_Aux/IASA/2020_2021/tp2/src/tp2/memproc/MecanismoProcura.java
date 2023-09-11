package tp2.memproc;

import tp2.modprob.Estado;
import tp2.modprob.Operador;
import tp2.Percurso;
import tp2.modprob.Problema;
import tp2.memproc.mem.MemoriaProcura;
import tp2.memproc.mem.No;
import tp2.pee.Solucao;

public abstract class MecanismoProcura<P extends Problema> {
	private MemoriaProcura memoriaProcura;
	private Problema problema;
	public MecanismoProcura() {
		this.problema = null;
		this.memoriaProcura = iniciarMemoria();
	};
	
	protected abstract MemoriaProcura iniciarMemoria(); 
	
	public Solucao resolver(Problema problema) {
		return this.resolver(problema, Integer.MAX_VALUE);
	}
	
	public Solucao resolver(Problema problema, int profMax) {
		memoriaProcura.limpar();
		this.problema = problema;
		No no_inicial = new No(this.problema.getEstadoInicial());
		memoriaProcura.inserir(no_inicial);
		while(!memoriaProcura.fronteiraVazia()){
			No no = memoriaProcura.remover();
			
			if(problema.objetivo(no.getEstado())) {
				return this.gerarSolucao(no);
			}else {
				if(no.getProfundidade() < profMax) this.expandir(no);
			}
		}
		
		return null;
	
	}
	
	private void expandir(No no) {
		Estado estado = no.getEstado();
		Operador[] operadores = problema.getOperadores();
		
		for(Operador operador : operadores) {
			Estado estadoSuc = operador.aplicar(estado);
			if(estadoSuc != null) {
				No noSuc =  new No(estadoSuc, operador,no);
				memoriaProcura.inserir(noSuc);
			}		
		}
		
	}
	private Solucao gerarSolucao(No noFinal){
		Percurso percurso = new Percurso();
		No no = noFinal;
		while(no!=null) {
			percurso.juntarInicio(no);
			no = no.getAntecessor();
		}
		
		return percurso;
	}
	
}
