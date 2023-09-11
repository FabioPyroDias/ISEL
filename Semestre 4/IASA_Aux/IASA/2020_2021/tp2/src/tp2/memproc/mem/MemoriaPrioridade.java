package tp2.memproc.mem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MemoriaPrioridade extends MemoriaProcura {
	public MemoriaPrioridade(Comparator<No> comparador) {
		super(new PriorityQueue<No>(1,comparador));
		// TODO Auto-generated constructor stub
	}
}
