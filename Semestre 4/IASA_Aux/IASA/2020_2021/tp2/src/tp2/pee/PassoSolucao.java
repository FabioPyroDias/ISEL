package tp2.pee;

import tp2.modprob.Estado;
import tp2.modprob.Operador;

public interface PassoSolucao{
	public Estado getEstado();
	public Operador getOperador();
	public double getCusto();
}
