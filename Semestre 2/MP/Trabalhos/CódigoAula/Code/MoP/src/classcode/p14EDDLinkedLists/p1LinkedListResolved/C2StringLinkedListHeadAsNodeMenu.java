package classcode.p14EDDLinkedLists.p1LinkedListResolved;

import java.util.Scanner;

public class C2StringLinkedListHeadAsNodeMenu {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		C1StringLinkedListHeadAsNode theStringLinkedListHeadAsNode = new C1StringLinkedListHeadAsNode();

		char opcao;
		do {
			System.out.println();
			System.out.print("List -> ");
			theStringLinkedListHeadAsNode.showList();
			System.out.println("Menu: ");
			System.out.println("a : addANodeToHead");
			System.out.println("b : deleteHeadNode");
			System.out.println("c : addANodeToTail");
			System.out.println("d : deleteTailNode");
			System.out.println("e : IndexOf");
			System.out.println("f : getElementAt");
			System.out.println("g : insertAt");
			System.out.println("h : removeAt");
			System.out.println("i : removeElement");

			System.out.println("x : terminar");
			System.out.print(" -> ");
			opcao = Character.toLowerCase(in.next().charAt(0));
			switch (opcao) {
			case 'a':
				System.out.print("Introduza um String -> ");
				String aux1 = in.next();
				theStringLinkedListHeadAsNode.addANodeToHead(aux1);
				break;
			case 'b':
				String retVal1 = theStringLinkedListHeadAsNode.deleteHeadNode();
				System.out.println("Foi devolvido o valor -> " + retVal1);
				break;
			case 'c':
				System.out.print("Introduza um String -> ");
				String aux2 = in.next();
				theStringLinkedListHeadAsNode.addANodeToTail(aux2);
				break;
			case 'd':
				String retVal2 = theStringLinkedListHeadAsNode.deleteTailNode();
				System.out.println("Foi devolvido o valor -> " + retVal2);
				break;
			case 'e':
				System.out.print("Introduza um String -> ");
				String aux7 = in.next();
				int retVal6 = theStringLinkedListHeadAsNode.IndexOf(aux7);
				System.out.println("Foi devolvido o valor -> " + retVal6);
				break;
			case 'f':
				System.out.print("Introduza um int -> ");
				int aux3 = in.nextInt();
				String retVal3 = theStringLinkedListHeadAsNode
						.getElementAt(aux3);
				System.out.println("Foi devolvido o valor -> " + retVal3);
				break;
			case 'g':
				System.out.print("Introduza um String -> ");
				String aux4 = in.next();
				System.out.print("Introduza um int -> ");
				int aux5 = in.nextInt();
				boolean retVal4 = theStringLinkedListHeadAsNode.insertAt(aux4,
						aux5);
				System.out.println("Foi devolvido o valor -> " + retVal4);
				break;
			case 'h':
				System.out.print("Introduza um int -> ");
				int aux6 = in.nextInt();
				String retVal5 = theStringLinkedListHeadAsNode.removeAt(aux6);
				System.out.println("Foi devolvido o valor -> " + retVal5);
				break;
			case 'i':
				System.out.print("Introduza um String -> ");
				String aux0 = in.next();
				String retVal0 = theStringLinkedListHeadAsNode
						.removeElement(aux0);
				System.out.println("Foi devolvido o valor -> " + retVal0);
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
