package reacao;

import java.util.HashMap;
import java.util.Map;

import maqest.Estado;
import maqest.MaquinaEstados;

public abstract class ComportMaqEst implements Comportamento{
	private MaquinaEstados<Estimulo> maqEst;
	private Map<Estado<Estimulo>, Comportamento> comportamentos = new HashMap<Estado<Estimulo>, Comportamento>(); //hashmaps
	
	public ComportMaqEst() {
		maqEst = iniciar();
		
	}
	
	
	public Estado<Estimulo>  getEstado() {
		return maqEst.getEstado();
	}
	
	@Override
	public Accao ativar(Estimulo estimulo) { 
		Estado<Estimulo> estado = maqEst.getEstado(); //Obter estado
		Comportamento comportamento = comportamentos.get(estado); //Com o estado, obter o comportamento que corresponde a determinado estado
		
		Accao accao = (comportamento != null ? comportamento.ativar(estimulo) : null);
		maqEst.processar(estimulo);
		return  accao;
	}

	public ComportMaqEst comport(Estado<Estimulo> estado , Comportamento comport) {
		this.comportamentos.put(estado,comport);
		return this;
	}

	protected abstract MaquinaEstados<Estimulo> iniciar();
}
