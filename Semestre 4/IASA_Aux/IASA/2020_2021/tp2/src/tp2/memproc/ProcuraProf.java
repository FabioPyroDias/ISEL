package tp2.memproc;

import tp2.memproc.mem.MemoriaLIFO;
import tp2.memproc.mem.MemoriaProcura;

public class ProcuraProf extends MecanismoProcura {
	@Override
	protected MemoriaProcura iniciarMemoria() {
		// TODO Auto-generated method stub
		return new MemoriaLIFO();
	}


}
