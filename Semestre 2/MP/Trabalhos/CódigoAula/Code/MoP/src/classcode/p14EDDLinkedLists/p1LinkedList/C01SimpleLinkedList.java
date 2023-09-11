package classcode.p14EDDLinkedLists.p1LinkedList;

public class C01SimpleLinkedList {

	public static String toString(Node node) {
		StringBuilder sb = new StringBuilder(100);
		sb.append('[');
		while (node != null) {
			sb.append(node.data);
			node = node.link;
			if (node != null)
				sb.append(", ");
		}
		sb.append(']');
		return sb.toString();
	}

	public static void main(String[] args) {

		Node n3 = new Node("três", null);
		Node n2 = new Node("dois", n3);
		Node n1 = new Node("um", n2);
		System.out.println(toString(n1));

		Node head = new Node("um", new Node("dois", new Node("três", null)));
		System.out.println(toString(head));
	}

}

class Node {
	public String data;
	public Node link;

	public Node(String newData, Node nextNode) {
		data = newData;
		link = nextNode;
	}

	public String toString() {
		return data + " " + link;
	}

}
