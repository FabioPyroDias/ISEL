package tp2.melhorprim;

import tp2.memproc.ProcuraMelhorPrim;
import tp2.modprob.ProblemaHeur;
import tp2.memproc.mem.No;

public class ProcuraSofrega extends ProcuraMelhorPrim<ProblemaHeur> implements ProcuraHeur {
    @Override
    protected double f(No no) {
        //f(n) = h(n)
        return problema.heuristica(no.getEstado());
    }

}
