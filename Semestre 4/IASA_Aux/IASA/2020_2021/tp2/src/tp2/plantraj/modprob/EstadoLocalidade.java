package tp2.plantraj.modprob;

import tp2.modprob.Estado;

public class EstadoLocalidade extends Estado {
	private String localidade;
	public EstadoLocalidade(String localidade) {
		this.localidade = localidade;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.localidade.hashCode();
	}
	
	public String toString() {
		return this.localidade;
	}

}
