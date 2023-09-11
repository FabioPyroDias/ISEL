package tp2.prof;

import tp2.modprob.Problema;
import tp2.memproc.MecanismoProcura;
import tp2.memproc.mem.MemoriaLIFO;
import tp2.memproc.mem.MemoriaProcura;
import tp2.pee.Procura;

public class ProcuraProf extends MecanismoProcura<Problema> implements Procura{ //memoria tipo lifo

	protected MemoriaProcura iniciarMemoria() {
		return new MemoriaLIFO();
	}
}
