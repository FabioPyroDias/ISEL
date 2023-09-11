package tp2.memproc;

import tp2.memproc.mem.MemoriaFIFO;
import tp2.memproc.mem.MemoriaProcura;

public class ProcuraLarg extends MecanismoProcura {

	@Override
	protected MemoriaProcura iniciarMemoria() {
		// TODO Auto-generated method stub
		return new MemoriaFIFO();
	}
	
}
