package tp2.memproc;

import tp2.memproc.mem.MemoriaPrioridade;
import tp2.memproc.mem.MemoriaProcura;
import tp2.memproc.mem.No;
import tp2.modprob.Problema;

import java.util.Comparator;

public abstract class ProcuraMelhorPrim<P extends Problema> extends MecanismoProcura<P> implements Comparator<No> {
    @Override
    protected MemoriaProcura iniciarMemoria() {
        return new MemoriaPrioridade(this);
    }
    public int compare(No o1, No o2){
        return Double.compare(f(o1),f(o2));
    }

    protected abstract double f(No no);
}
