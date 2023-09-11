package classcode.p14EDDLinkedLists.p1LinkedListResolved;

/**
 * Nesta lista a cabeca também é também um Node. Na prática é implementado com a
 * referencia head a apontar para um Node.
 * 
 * Este tipo de cabeca facilita as operações na lista, uma vez que a situação
 * excepcional de manipulação à cabeça deixa de ser tratada como caso especial.
 * 
 * @author António Teófilo
 * 
 */
public class C1StringLinkedListHeadAsNode {
	protected Node head;

	public C1StringLinkedListHeadAsNode() {
		head = new Node(null, null); // link as null
	}

	/**
	 * Adds a node at the start of the list. The added node has addData as its
	 * data. The added node will be the first node in the list.
	 */
	public void addANodeToHead(String addData) {
		head.link = new Node(addData, head.link);
	}

	/**
	 * Deletes head node
	 * 
	 */
	public String deleteHeadNode() {
		String str = null;
		if (head.link != null) {
			str = head.link.data;
			head.link = head.link.link;
		}
		return str;
	}

	/**
	 * Adds a node at the tail of the list. The added node has addData as its
	 * data. The added node will be the last node in the list.
	 */
	public void addANodeToTail(String addData) {
		Node newNode = new Node(addData, null);

		Node aux = head;
		while (aux.link != null) {
			aux = aux.link;
		}
		aux.link = newNode;
	}

	/**
	 * Deletes tail node
	 * 
	 */
	public String deleteTailNode() {
		String str = null;
		// verificar se lista vazia
		if (head.link == null) {
			return null;
		}
		// lista nao vazia
		Node aux = head;
		while (aux.link.link != null) {
			aux = aux.link;
		}
		str = aux.link.data;
		aux.link = null;
		return str;
	}

	/**
	 * Shows the list
	 */
	public void showList() {
		Node currNode = head.link;
		while (currNode != null) {
			System.out.print(currNode.data);
			currNode = currNode.link;
			if(currNode!= null)
				System.out.print(", " );
		}
		System.out.println();
	}

	public String getElementAt(int pos) {
		System.out.println("Not done...");
		// TODO
		return null;
	}

	public boolean insertAt(String str, int pos) {
		System.out.println("Not done...");
		// TODO
		return false;
	}

	public String removeAt(int pos) {
		System.out.println("Not done...");
		// TODO
		return null;
	}

	public int IndexOf(String str) {
		System.out.println("Not done...");
		// TODO
		return -1;
	}

	public String removeElement(String str) {
		System.out.println("Not done...");
		// TODO
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
}
