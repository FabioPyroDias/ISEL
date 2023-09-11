package tp2.melhorprim;

import tp2.modprob.Problema;
import tp2.memproc.mem.No;
import tp2.pee.Procura;

public class ProcuraCustoUnif extends ProcuraMelhorPrim<Problema> implements Procura {
    @Override
    protected double f(No no) {
        return no.getCusto(); //Decide perante o custo de cada nó
    }
}
