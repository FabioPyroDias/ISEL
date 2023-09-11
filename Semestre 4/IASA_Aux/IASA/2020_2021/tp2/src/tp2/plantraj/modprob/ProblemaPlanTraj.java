package tp2.plantraj.modprob;

import tp2.modprob.Estado;
import tp2.modprob.Problema;

public class ProblemaPlanTraj extends Problema {
	private EstadoLocalidade estadoFinal;
	public ProblemaPlanTraj(String locIni, String locFin, OperadorLigacao[] operadores) {
		super(new EstadoLocalidade(locIni), operadores);
		estadoFinal = new EstadoLocalidade(locFin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean objetivo(Estado estado) {
		// TODO Auto-generated method stub
		if(estado.equals(estadoFinal)) {
			return true;
		}
		return false;
	}

}
