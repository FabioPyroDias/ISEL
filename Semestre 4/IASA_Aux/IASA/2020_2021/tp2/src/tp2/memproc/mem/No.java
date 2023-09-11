package tp2.memproc.mem;

import tp2.modprob.Estado;
import tp2.modprob.Operador;
import tp2.pee.PassoSolucao;

public class No implements PassoSolucao{
	private int profundidade = 0;
	private double custo = 0;
	private Estado estado;
	private Operador operador;
	private No antecessor;
	public No(Estado estado) {
		this.estado = estado;
	}
	
	public No(Estado estado, Operador operador, No antecessor) {
		this.estado = estado;
		this.operador = operador;
		this.antecessor = antecessor;
		
		if(this.antecessor != null) {
			this.profundidade = this.antecessor.profundidade + 1;
			this.custo = operador.custo(antecessor.getEstado(), estado) + antecessor.getCusto();
		}

	}
	
	public Estado getEstado() {
		return this.estado;
		
	}
	public Operador getOperador() {
		return this.operador;
	}
	public No getAntecessor() {
		return this.antecessor;
		
	}
	public int getProfundidade(){
		return this.profundidade;
		
	}
	public double getCusto() {
		return this.custo;
		
	}
	
	@Override
	public String toString() {
		return this.getCusto() + " - " + this.getEstado();
	}

}
