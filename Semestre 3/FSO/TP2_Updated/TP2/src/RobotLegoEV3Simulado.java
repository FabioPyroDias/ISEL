public class RobotLegoEV3Simulado extends RobotLego{
	protected int sensorToque = 0;
	protected int sensorDist = 60;


	@Override
	protected boolean OpenEV3(String name) {
		System.out.println("A liga��o ao robot " + name + " foi estabelecida.");		
		return true;
	}

	@Override
	protected void CloseEV3() {
		System.out.println("A liga��o ao robot foi fechada.");
	}

	@Override
	protected void Reta(int distancia) {
		System.out.println("Foi executado uma Reta com " + distancia + " cm de dist�ncia.");
	}

	@Override
	protected void CurvarEsquerda(float raio, int angulo) {
		System.out.println("Foi executado uma Curva � Esquerda com " + raio + " cm de raio e com �ngulo de " + angulo + " graus.");
	}

	@Override
	protected void CurvarDireita(float raio, int angulo) {
		System.out.println("Foi executado uma Curva � Direita com " + raio + " cm de raio e com �ngulo de " + angulo + " graus.");
	}

	@Override
	protected void Parar(boolean assincrono) {
		System.out.println("Foi executado uma Paragem com valor assincrono: " + assincrono);
	}

	@Override
	protected void SetVelocidade(int percentagem) {
		System.out.println("A velocidade foi definida para " + percentagem + " por cento.");
	}

	@Override
	protected float SensorAngulo(int sensor) {
		float minimumValue = 0;
		float maximumValue = 360;
		
		float random = (float) (minimumValue + Math.floor(Math.random() * (maximumValue - minimumValue + 1)));
		System.out.println("Foi passado o " + sensor + " como parametro para o Sensor Angulo e foi devolvido " + random + " graus.");
		return random;
	}

	@Override
	protected int SensorToque(int sensor) {
		// int minimumValue = 0;
		// int maximumValue = 1;
		//int random = (int) (minimumValue + Math.floor(Math.random() * (maximumValue - minimumValue + 1)));
		// System.out.println("Foi passado o " + sensor + " como parametro para o Sensor Toque e foi devolvido o valor " + random + ".");
		return this.sensorToque;
	}

	@Override
	protected float SensorUS(int sensor) {
		// float minimumValue = 0;
		// float maximumValue = 255;
		
		// float random = (float) (minimumValue + Math.floor(Math.random() * (maximumValue - minimumValue + 1)));
		// System.out.println("Foi passado o " + sensor + " como parametro para o Sensor US e foi devolvida distancia " + random + " cm de um objecto.");
		return this.sensorDist;		
	}

	@Override
	protected float SensorLuz(int sensor) {
		float minimumValue = 0;
		float maximumValue = 100;
		
		float random = (float) (minimumValue + Math.floor(Math.random() * (maximumValue - minimumValue + 1)));
		System.out.println("Foi passado o " + sensor + " como parametro para o Sensor Luz e foi devolvido o valor " + random + " intensidade luminosa reflectida.");
		return random;
	}
	
	// Simular toque
	protected void setSensorToque(int valor) {
		this.sensorToque = valor;
	}

	// Simular distancia
	protected void setSensorDist(int valor) {
		this.sensorDist = valor;
	}

	
	@Override
	protected boolean isSimulado() {
		return true;
	}	
}