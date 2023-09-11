package tp2.plantraj.modprob;

import tp2.modprob.Estado;
import tp2.modprob.Operador;

public class OperadorLigacao implements Operador{
	private int custoLigacao;
	private EstadoLocalidade estadoOrigem,estadoDestino;

	
	public OperadorLigacao(String locIni, String locFin,int  custo) {
		this.custoLigacao = custo;
		estadoOrigem = new EstadoLocalidade(locIni);		
		estadoDestino = new EstadoLocalidade(locFin);
	}
	@Override
	public Estado aplicar(Estado estado) {
		if(estado.equals(this.estadoOrigem)){
			return this.estadoDestino;
		}
		return null;
	}

	@Override
	public float custo(Estado estado, Estado estadoSuc) {
		// TODO Auto-generated method stub
		return this.custoLigacao;
	}

}
