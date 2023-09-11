package tp2.pee;

import tp2.modprob.Problema;

public interface Procura {
	public Solucao resolver(Problema problema);
	public Solucao resolver(Problema problema, int profMax);
	
}
