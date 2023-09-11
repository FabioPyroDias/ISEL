package classcode.p06ClassesAndObjects;

public class C000 {

	static int x = 10 * m1();

	int y = 30;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m1();
		// m2();
		x = 20;
		// x = y;
	}

	public static int m1() {
		return 0;
	}

	public void m2() {
		m1();
		y = 10;
		x = 20;
	}

	public int m3() {
		m2();
		return 0;
	}

}

class ContaStatic {
	static double saldo = 0.0;

	static double[] saldos = new double[20];

	static String[] nomes = new String[20];

	static void depositar(double valor) {
		if (valor <= 0)
			throw new IllegalArgumentException(
					"O valor a depositar tem de ser maior que zero: " + valor);

		saldo += valor;
	}

	static void printSaldo() {
		System.out.println("O saldo corrente é: " + saldo);
	}

	public static void main(String[] args) {
		printSaldo();
		depositar(2000);
		printSaldo();
		depositar(1000);
		printSaldo();
		depositar(2000);
		printSaldo();
	}

}

class Conta {
	double saldo;
	String nome;
	int nif;
	String morada;

	void depositar(double valor) {
		if (valor <= 0)
			throw new IllegalArgumentException(
					"O valor a depositar tem de ser maior que zero: " + valor);

		saldo += valor;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Conta de " + nome + " com saldo " + saldo;
	}

	

//	public Conta() {
//		System.out.println("construtor...");
//	}
		
}

class X {
	void m1() {
		X x1 = new X();
		System.out.println(x1);
	}
}

class Banco {

	public static void main(String[] args) {
		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		Conta conta4 = new Conta();

		Conta[] contas = new Conta[100];
		contas[0] = conta1;
		contas[1] = conta2;

		for (int i = 2; i < contas.length; i++) {
			contas[i] = new Conta();
		}

		conta1.nome = "António José";
		conta4.saldo = 344.66;

		conta2.depositar(300);
		conta3.depositar(200);

	}
}
