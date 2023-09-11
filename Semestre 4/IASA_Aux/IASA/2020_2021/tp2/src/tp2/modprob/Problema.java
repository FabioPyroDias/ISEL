package tp2.modprob;

public abstract class Problema {
	private Operador[] operadores;
	private Estado estadoInicial;
	public Problema(Estado estadoInicial, Operador[] operadores) {
		this.estadoInicial = estadoInicial;
		this.operadores = operadores;
	}
	
	public Operador[] getOperadores() {
		return operadores;
	}
	
	public Estado getEstadoInicial() {
		return estadoInicial;
		
	}
	
	public abstract boolean objetivo(Estado estado);

}
