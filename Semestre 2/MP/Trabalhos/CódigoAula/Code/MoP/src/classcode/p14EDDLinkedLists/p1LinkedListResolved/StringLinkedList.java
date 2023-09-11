package classcode.p14EDDLinkedLists.p1LinkedListResolved;

/**
 * Primeira versão da list simples. Utiliza a nested class Node (também
 * designada de inner class)
 * 
 * Ver classe InnerClasses sobre explicações acerca de inner classes
 * 
 * Só implementa alguns métodos, deixa os outros para os alunos se divertirem.
 * 
 * @author António Teófilo
 * 
 */
public class StringLinkedList {
	protected Node head;

	public StringLinkedList() {
		head = null;
	}

	/**
	 * Adds a node at the start of the list. The added node has addData as its
	 * data. The added node will be the first node in the list.
	 */
	public void addANodeToHead(String addData) {
		head = new Node(addData, head);
	}

	/**
	 * Deletes head node
	 * 
	 */
	public String deleteHeadNode() {
		String str = null;
		if (head != null) {
			str = head.data;
			head = head.link;
		}
		return str;
	}

	/**
	 * Adds a node at the tail of the list. The added node has addData as its
	 * data. The added node will be the last node in the list.
	 */
	public void addANodeToTail(String addData) {
		Node newNode = new Node(addData, null);
		if (head == null) {
			head = newNode;
		} else {
			Node aux = head;
			while (aux.link != null) {
				aux = aux.link;
			}
			aux.link = newNode;
		}
	}

	/**
	 * Deletes tail node
	 * 
	 */
	public String deleteTailNode() {
		String str = null;
		if (head == null) {
			return null;
		}
		if (head.link == null) {
			// remocao do único elemento
			str = head.data;
			head = null;
		} else {
			// remocao normal do último elemento
			Node aux = head.link;
			Node previous = head;
			while (aux.link != null) {
				previous = aux;
				aux = aux.link;
			}
			str = aux.data;
			previous.link = null;
		}
		return str;
	}

	/**
	 * Shows the list
	 */
	public void showList() {
		Node aux = head;
		while (aux != null) {
			System.out.print(aux.data);
			aux = aux.link;
			if (aux != null)
				System.out.print(", ");
		}
		System.out.println();
	}

	public String getElementAt(int pos) {
		Node currElem = head;
		for (int i = 0; i < pos; i++) {
			if (currElem == null)
				return null;
			currElem = currElem.link;
		}
		return currElem == null ? null : currElem.data;
	}

	public boolean insertAt(String str, int pos) {
		if (pos < 0)
			throw new IllegalArgumentException("index negativo");
		if (pos == 0) {
			head = new Node(str, head);
			return true;
		}
		Node aux = head;
		for (int i = 0; i < pos - 1; i++) {
			if (aux == null)
				return false;
			aux = aux.link;
		}
		if (aux == null)
			return false;
		aux.link = new Node(str, aux.link);
		return true;
	}

	public String removeAt(int pos) {
		if (pos < 0)
			throw new IllegalArgumentException("index negativo");
		if (pos == 0) {
			if (head == null)
				return null;
			String str = head.data;
			head = head.link;
			return str;
		}
		Node aux = head;
		for (int i = 0; i < pos - 1; i++) {
			if (aux == null)
				return null;
			aux = aux.link;
		}
		if (aux.link == null)
			return null;
		String str = aux.link.data;
		aux.link = aux.link.link;
		return str;
	}

	/**
	 * Devolver o index da primeira string igual ao argumento passado Devolve -1
	 * caso não encontre
	 */
	public int IndexOf(String str) {
		Node currElem = head;
		int index = 0;
		while (currElem != null) {
			if (currElem.data != null && currElem.data.equals(str))
				return index;
			currElem = currElem.link;
			index++;
		}
		return -1;
	}

	// remove e devolve a primeira ocorrência do argumento recebido
	// caso não encontre devolve null
	public String removeElement(String str) {
		if (head == null)
			return null;

		// remoção à cabeça
		if (head != null && head.data != null && head.data.equals(str)) {
			head = head.link;
			return str;
		}
		// remoção no meio ou fim da lista
		Node previous = head;
		while (previous.link != null) {
			if (previous.link.data != null && previous.link.data.equals(str)) {
				previous.link = previous.link.link;
				return str;
			}
			previous = previous.link;
		}
		return null;
	}

	protected class Node {
		public String data;
		public Node link;

		public Node() {
			link = null;
			data = null;
		}

		public Node(String newData, Node linkValue) {
			data = newData;
			link = linkValue;
		}

		public String toString() {
			return data;
		}
	}

	private void printList(String prefix) {
		System.out.print(prefix);
		showList();
		System.out.println();
	}

	public static void main(String[] args) {
		StringLinkedList list = new StringLinkedList();
		System.out.println("Element at 0 -> " + list.getElementAt(0));
		list.addANodeToHead("One");
		list.addANodeToHead("Two");
		list.addANodeToHead("Three");
		list.showList();
		System.out.println();

		System.out.println("Element at 0 -> " + list.getElementAt(0));
		System.out.println("Element at 1 -> " + list.getElementAt(1));
		System.out.println("Element at 2 -> " + list.getElementAt(2));
		System.out.println("Element at 3 -> " + list.getElementAt(3));

		list.deleteHeadNode();
		list.deleteHeadNode();
		list.deleteHeadNode();

		list.printList("List -> ");

		System.out.println("InsertAt test====================");
		String str = "um";
		int pos = 0;
		System.out.println("InsertAt " + str + " at " + pos + " -> "
				+ list.insertAt(str, pos));
		list.printList("List -> ");

		str = "dois";
		pos = 0;
		System.out.println("InsertAt " + str + " at " + pos + " -> "
				+ list.insertAt(str, pos));
		list.printList("List -> ");

		str = "tres";
		pos = 1;
		System.out.println("InsertAt " + str + " at " + pos + " -> "
				+ list.insertAt(str, pos));
		list.printList("List -> ");

		str = "quatro";
		pos = 3;
		System.out.println("InsertAt " + str + " at " + pos + " -> "
				+ list.insertAt(str, pos));
		list.printList("List -> ");

		System.out.println("removeAt test====================");
		pos = 2;
		System.out.println("RemoveAt " + " at " + pos + " -> "
				+ list.removeAt(pos));
		list.printList("List -> ");

		pos = 0;
		System.out.println("RemoveAt " + " at " + pos + " -> "
				+ list.removeAt(pos));
		list.printList("List -> ");

		pos = 1;
		System.out.println("RemoveAt " + " at " + pos + " -> "
				+ list.removeAt(pos));
		list.printList("List -> ");

		pos = 0;
		System.out.println("RemoveAt " + " at " + pos + " -> "
				+ list.removeAt(pos));
		list.printList("List -> ");

		str = "quatro";
		pos = 0;
		System.out.println("InsertAt " + str + " at " + pos + " -> "
				+ list.insertAt(str, pos));
		list.printList("List -> ");

		System.out.println("addANodeToHead " + str);
		list.addANodeToHead(str);
		list.printList("List -> ");

		str = "segunda";
		System.out.println("addANodeToHead " + str);
		list.addANodeToHead(str);
		list.printList("List -> ");

		System.out.println("IndexOf Quatro -> " + list.IndexOf("quatro"));
		System.out.println("IndexOf cinco -> " + list.IndexOf("cinco"));
		System.out.println("IndexOf segunda -> " + list.IndexOf("segunda"));

		System.out.println("removeElement Quatro -> "
				+ list.removeElement("quatro"));
		list.printList("List -> ");
		System.out.println("removeElement cinco -> "
				+ list.removeElement("cinco"));
		list.printList("List -> ");
		System.out.println("removeElement segunda -> "
				+ list.removeElement("segunda"));
		list.printList("List -> ");

	}
}

// public String getElementAt(int pos) {
// Node currElem = head;
// for (int i = 0; i < pos; i++) {
// if (currElem == null)
// return null;
// currElem = currElem.link;
// }
// return currElem != null ? currElem.data : null;
// }
//
// public boolean insertAt(String str, int pos) {
// if (pos < 0)
// throw new IllegalArgumentException("index negativo");
// if (pos == 0) {
// head = new Node(str, head);
// return true;
// }
// Node currElem = head;
// for (int i = 0; i < pos - 1; i++) {
// if (currElem == null)
// return false;
// currElem = currElem.link;
// }
// currElem.link = new Node(str, currElem.link);
// return true;
// }
//
// public String removeAt(int pos) {
// if (pos < 0)
// throw new IllegalArgumentException("index negativo");
// // remoção à cabeça
// if (pos == 0) {
// if (head == null)
// return null;
// String data = head.data;
// head = head.link;
// return data;
// }
// // remoção no meio ou no fim da lista
// Node currElem = head;
// for (int i = 0; i < pos - 1; i++) {
// if (currElem == null)
// return null;
// currElem = currElem.link;
// }
// String data = currElem.link.data;
// currElem.link = currElem.link.link;
// return data;
// }

