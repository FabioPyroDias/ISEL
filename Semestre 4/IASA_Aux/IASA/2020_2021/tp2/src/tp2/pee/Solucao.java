package tp2.pee;

import java.util.Iterator;

public interface Solucao extends Procura, Iterable<PassoSolucao>{
	public Iterator<PassoSolucao> iterator();
	public int getDimension();
	public double getCusto();
}
