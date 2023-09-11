package tp2.melhorprim;

import tp2.memproc.ProcuraMelhorPrim;
import tp2.modprob.ProblemaHeur;
import tp2.memproc.mem.No;

public class ProcuraAA extends ProcuraMelhorPrim<ProblemaHeur> implements ProcuraHeur {
    @Override
    protected double f(No no) {
        //utiliza o custo e a heuristica das diferentes procuras
        //f(n) = h(n)+g(n)
        return problema.heuristica(no.getEstado()) + no.getCusto();
    }
}
