package tp2.melhorprim;
import tp2.pee.Solucao;

public abstract interface ProcuraHeur {

    Solucao resolver(ProcuraHeur problema);

    Solucao resolver(ProcuraHeur problema, int profMax);
}
