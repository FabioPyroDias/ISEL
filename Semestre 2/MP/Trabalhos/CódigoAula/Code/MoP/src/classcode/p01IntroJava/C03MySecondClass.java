package classcode.p01IntroJava;

/**
 *  Uma classe existe dentro de um package. Para se utilizar qualquer 
 *  classe num programa é necessário especificar o package de cada uma.
 *  java.util.Scanner(System.in) que está dentro do main, refere a classe
 *  java.util.Scanner que portanto está dentro do package java.util. No 
 *  se se declara o import de java.util.Scanner ou java.util.* a classe 
 *  Scanner fica acessível sem se ter de indicar a localização completa 
 *  do seu package cada vez que se pretende utilizar uma referêcnia a
 *  Scanner, tal como acontece em "Scanner keyboard = ".
 *  
 *  
 *  Um import permite declarar a localização de uma classe ou conjunto de 
 *  classes, o que pertime utilizar essa(s) classe(s) sem se ter que indicar 
 *  sempre o seu package. 
 */
import java.util.Scanner;

/**
 * Programa que calcula o dobro de um valor introduzido pelo utilizador
 */
public class C03MySecondClass {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		System.out.println("Olá pessoal.");

		// Declarar uma variável do tipo java.util.Scanner que é uma classe
		// auxiliar que permite a leitura da consola de uma forma prática
		Scanner keyboard = new java.util.Scanner(System.in);

		// Indicar ao utilizador que deve introduzir um inteiro
		System.out.print("Introduza um inteiro -> ");

		// Ler um inteiro da consola e colocá-lo na variável val
		int val = keyboard.nextInt();

		// Mostrar na consola o valor lido, para verificar que a leitura está
		// correcta
		System.out.println("O inteiro lido foi -> " + val);

		// Calcular o dobro do valor recebido. Facil...
		int dobro = val * 2;

		// Escrever na consola o resultado, com um texto esclarecedor
		System.out.println("O dobro  de " + val + " é -> " + dobro);

		// fechar o keyboard - é necessário para libertar os recursos
		keyboard.close();
	}
}
