package tp2;

import java.util.Iterator;
import java.util.LinkedList;

import tp2.memproc.mem.No;
import tp2.modprob.Problema;
import tp2.pee.PassoSolucao;
import tp2.pee.Solucao;

public class Percurso implements Solucao{
	private LinkedList<PassoSolucao> percurso = new LinkedList<PassoSolucao>();
	
	@Override
	public Iterator<PassoSolucao> iterator() {
		// TODO Auto-generated method stub
		return percurso.iterator();
	}

	@Override
	public int getDimension() {
		// TODO Auto-generated method stub
		return this.percurso.size();
	}
	
	public void juntarInicio(No no) {
		percurso.addFirst(no);
	}
	
	@Override
	public double getCusto() {
		return percurso.getLast().getCusto();
	}

	@Override
	public Solucao resolver(Problema problema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solucao resolver(Problema problema, int profMax) {
		// TODO Auto-generated method stub
		return null;
	}

}
