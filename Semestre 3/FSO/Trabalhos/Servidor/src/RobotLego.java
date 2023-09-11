public abstract class RobotLego {	
	protected abstract boolean OpenEV3(String name);
	protected abstract void CloseEV3();
	protected abstract void Reta(int distancia);
	protected abstract void CurvarEsquerda(float raio, int angulo);
	protected abstract void CurvarDireita(float raio, int angulo);
	protected abstract void Parar(boolean assincrono);
	protected abstract void SetVelocidade(int percentagem);
	protected abstract float SensorAngulo(int sensor);
	protected abstract int SensorToque(int sensor);
	protected abstract float SensorUS(int sensor);
	protected abstract float SensorLuz(int sensor);
}