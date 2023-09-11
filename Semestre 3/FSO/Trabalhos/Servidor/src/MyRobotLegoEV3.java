import robot.RobotLegoEV3;

public class MyRobotLegoEV3 extends RobotLego{
	
	private RobotLegoEV3 robot;
	
	public MyRobotLegoEV3()
	{
		robot = new RobotLegoEV3();
	}

	@Override
	protected boolean OpenEV3(String name) {
		return robot.OpenEV3(name);
	}

	@Override
	protected void CloseEV3() {
		robot.CloseEV3();
	}

	@Override
	protected void Reta(int distancia) {
		System.out.println("teste");
		robot.Reta(distancia);
	}

	@Override
	protected void CurvarEsquerda(float raio, int angulo) {
		robot.CurvarEsquerda(raio, angulo);
	}

	@Override
	protected void CurvarDireita(float raio, int angulo) {
		robot.CurvarDireita(raio, angulo);
	}

	@Override
	protected void Parar(boolean assincrono) {
		robot.Parar(assincrono);
	}

	@Override
	protected void SetVelocidade(int percentagem) {
		robot.SetVelocidade(percentagem);
	}

	@Override
	protected float SensorAngulo(int sensor) {
		return robot.SensorAngulo(sensor);
	}

	@Override
	protected int SensorToque(int sensor) {
		return robot.SensorToque(sensor);
	}

	@Override
	protected float SensorUS(int sensor) {
		return robot.SensorUS(sensor);
	}

	@Override
	protected float SensorLuz(int sensor) {
		return robot.SensorLuz(sensor);
	}
}