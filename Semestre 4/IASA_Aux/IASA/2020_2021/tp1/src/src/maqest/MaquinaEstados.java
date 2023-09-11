package maqest;

public class MaquinaEstados<EV> {
	private Estado<EV> estado;
	public MaquinaEstados(Estado<EV> estado) {
		this.estado = estado;
	}
	public Estado<EV> getEstado() {
		return this.estado;
	}
	public void processar(EV evento) {
		//Atualizar estado da máquina de estados
		Estado<EV> estadoSeguinte = estado.processar(evento);
		if(estadoSeguinte != null) {
			this.estado = estadoSeguinte;
		}
	}
}
