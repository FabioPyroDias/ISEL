package classcode.p12Generics;

import java.util.Arrays;
import java.util.Collection;

public class C08TestExtendsWildcard {
	Pessoa[] pessoal = new Pessoa[100];
	int nPessoas = 0;

	// pode receber arrays de Pessoa ou classes derivadas
	public boolean addAll(Pessoa[] pessoas) {
		if (pessoal.length < pessoas.length + nPessoas)
			return false;
		for (Pessoa p : pessoas)
			pessoal[nPessoas++] = p;
		return true;
	}

	// com genéricos - desnecessário
	public <T extends Pessoa> boolean addAll2(T[] pessoas) {
		if (pessoal.length < pessoas.length + nPessoas)
			return false;
		for (Pessoa p : pessoas)
			pessoal[nPessoas++] = p;
		return true;
	}

	// com classes contentoras de pessoas- não aceita Collection de Aluno
	public boolean addAll(Collection<Pessoa> pessoas) {
		Pessoa[] novasPessoas = pessoas.toArray(pessoal);
		return addAll(novasPessoas);
	}

	// agora já aceita
	public boolean addAll2(Collection<? extends Pessoa> pessoas) {
		Pessoa[] novasPessoas = pessoas.toArray(pessoal);
		return addAll(novasPessoas);
	}

	// o mesmo método mas escrito de outra forma
	public <T extends Pessoa> boolean addAll3(Collection<T> pessoas) {
		Pessoa[] novasPessoas = pessoas.toArray(pessoal);
		return addAll(novasPessoas);
	}

	public String toString() {
		return Arrays.toString(Arrays.copyOf(pessoal, nPessoas));
	}

	public static void main(String[] args) {
		Pessoa[] people = { new Pessoa("Ana", 111111) };
		C06Aluno[] students = { new C06Aluno("Luís", 111112, 1000, 3) };

		C08TestExtendsWildcard staff = new C08TestExtendsWildcard();
		staff.addAll(people);
		staff.addAll(students);

		staff.addAll2(students);

		Collection<Pessoa> cp = Arrays.asList(new Pessoa("Ana", 111111));
		Collection<C06Aluno> ca = Arrays.asList(new C06Aluno("Luís", 111112,
				1000, 3));

		staff.addAll(cp);
		// staff.addAll(ca); // ERRO DE COMPILAÇÂO

		staff.addAll2(cp);
		staff.addAll2(ca);

		System.out.println("done");
	}
}
