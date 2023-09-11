package tp2.plantraj;

import tp2.modprob.Estado;
import tp2.memproc.ProcuraLarg;
import tp2.pee.PassoSolucao;
import tp2.pee.Solucao;
import tp2.plantraj.modprob.OperadorLigacao;
import tp2.plantraj.modprob.ProblemaPlanTraj;
import tp2.prof.ProcuraProf;
import tp2.prof.ProcuraProfIter;

public class PlaneadorTrajecto {
	static ProblemaPlanTraj problema = new ProblemaPlanTraj("Loc-0", "Loc-6", definirOperadores());

	public static void main(String[] args) {
		Solucao sol;
		ProcuraProfIter currentMecanismo = new ProcuraProfIter(1) ;
		ProcuraLarg currentMecanismo2 = new ProcuraLarg() ;
		ProcuraProf currentMecanismo3 = new ProcuraProf() ;
		
		sol = currentMecanismo3.resolver(problema,20);
		mostrarTrajeto(sol);
	}
	
	private static OperadorLigacao[] definirOperadores() {
		return new OperadorLigacao[]{
				new OperadorLigacao("Loc-0","Loc-1",5),
				new OperadorLigacao("Loc-0","Loc-2",25),
				new OperadorLigacao("Loc-1","Loc-3",12),
				new OperadorLigacao("Loc-1","Loc-6",5),
				new OperadorLigacao("Loc-2","Loc-4",30),
				new OperadorLigacao("Loc-3","Loc-2",10),
				new OperadorLigacao("Loc-3","Loc-5",5),
				new OperadorLigacao("Loc-4","Loc-3",2),
				new OperadorLigacao("Loc-5","Loc-6",8),
				new OperadorLigacao("Loc-5","Loc-4",10),
				new OperadorLigacao("Loc-6","Loc-3",15),	
		};
		
	}
	
	private static void mostrarTrajeto(Solucao solucao) {
		String trajeto = "";
		if(solucao != null){
			for(PassoSolucao passo : solucao){			
				Estado passo_string = passo.getEstado();
				System.out.println("[PASSO SOLUCAO] " + passo.toString());
			}
			System.out.println("Nós Explorados:" + solucao.getDimension());
			System.out.println();
		}
	}
}
