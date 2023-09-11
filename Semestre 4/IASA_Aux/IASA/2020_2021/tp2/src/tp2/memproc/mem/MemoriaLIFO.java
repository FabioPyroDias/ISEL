package tp2.memproc.mem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class MemoriaLIFO extends MemoriaProcura{

	public MemoriaLIFO() {
		super(Collections.asLifoQueue(new LinkedList<No>()));
		
		// TODO Auto-generated constructor stub
	}

}
