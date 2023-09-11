package classcode.p14EDDLinkedLists.p1LinkedList;

import java.util.Scanner;

public class C03StringLinkedListMenu {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		C02StringLinkedList theStringLinkedList = new C02StringLinkedList();

		char opcao;
		do {
			System.out.print("\nLista -> ");
			theStringLinkedList.showList();

			System.out.println("Menu: ");
			System.out.println("a : removeElement");
			System.out.println("b : addANodeToHead");
			System.out.println("c : deleteHeadNode");
			System.out.println("d : addANodeToTail");
			System.out.println("e : deleteTailNode");
			System.out.println("f : showList");
			System.out.println("g : getElementAt");
			System.out.println("h : insertAt");
			System.out.println("i : removeAt");
			System.out.println("j : IndexOf");
			System.out.println("x : terminar");
			System.out.print(" -> ");
			opcao = Character.toLowerCase(in.next().charAt(0));
			switch (opcao) {
			case 'a':
				System.out.print("Introduza um String -> ");
				String aux0 = in.next();
				String retVal0 = theStringLinkedList.removeElement(aux0);
				System.out.println("Foi devolvido o valor -> " + retVal0);
				break;
			case 'b':
				System.out.print("Introduza um String -> ");
				String aux1 = in.next();
				theStringLinkedList.addANodeToHead(aux1);
				break;
			case 'c':
				String retVal1 = theStringLinkedList.deleteHeadNode();
				System.out.println("Foi devolvido o valor -> " + retVal1);
				break;
			case 'd':
				System.out.print("Introduza um String -> ");
				String aux2 = in.next();
				theStringLinkedList.addANodeToTail(aux2);
				break;
			case 'e':
				String retVal2 = theStringLinkedList.deleteTailNode();
				System.out.println("Foi devolvido o valor -> " + retVal2);
				break;
			case 'f':
				theStringLinkedList.showList();
				break;
			case 'g':
				System.out.print("Introduza um int -> ");
				int aux3 = in.nextInt();
				String retVal3 = theStringLinkedList.getElementAt(aux3);
				System.out.println("Foi devolvido o valor -> " + retVal3);
				break;
			case 'h':
				System.out.print("Introduza um String -> ");
				String aux4 = in.next();
				System.out.print("Introduza um int -> ");
				int aux5 = in.nextInt();
				boolean retVal4 = theStringLinkedList.insertAt(aux4, aux5);
				System.out.println("Foi devolvido o valor -> " + retVal4);
				break;
			case 'i':
				System.out.print("Introduza um int -> ");
				int aux6 = in.nextInt();
				String retVal5 = theStringLinkedList.removeAt(aux6);
				System.out.println("Foi devolvido o valor -> " + retVal5);
				break;
			case 'j':
				System.out.print("Introduza um String -> ");
				String aux7 = in.next();
				int retVal6 = theStringLinkedList.IndexOf(aux7);
				System.out.println("Foi devolvido o valor -> " + retVal6);
				break;
			case 'x':
				break;
			default:
				System.out.println("opcao Inválida");
			} // end switch
		} while (opcao != 'x');

		in.close();
	} // end main
} // end
