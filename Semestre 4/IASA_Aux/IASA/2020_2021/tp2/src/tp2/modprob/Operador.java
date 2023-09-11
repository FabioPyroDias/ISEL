package tp2.modprob;

import tp2.modprob.Estado;

public interface Operador {
	public Estado aplicar(Estado estado);
	public float custo(Estado estado, Estado estadoSuc);
}
