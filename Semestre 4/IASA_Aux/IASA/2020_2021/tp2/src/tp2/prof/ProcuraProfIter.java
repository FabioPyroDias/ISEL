package tp2.prof;

import tp2.modprob.Problema;
import tp2.pee.Solucao;

public class ProcuraProfIter extends ProcuraProf{
	private int incProf = 0;
	
	public ProcuraProfIter(int incProf) {
		super();
		this.incProf = incProf;	
	}
	
	
	public int getIncProf() {
		return this.incProf;
	}
	
	public void setIncProf(int incProf) {
		this.incProf = incProf;
	}
	
	
	public Solucao resolver(Problema problema, int profMax) {
	
		for(int i = 0;i<profMax;i++) {
			Solucao sol = super.resolver(problema, profMax);
			if(sol!=null) return sol;
		}
		
		System.out.println(4);
		return null;		
	}
}
