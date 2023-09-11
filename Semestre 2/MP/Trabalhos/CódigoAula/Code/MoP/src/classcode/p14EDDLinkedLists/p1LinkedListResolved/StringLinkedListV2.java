package classcode.p14EDDLinkedLists.p1LinkedListResolved;

/**
 * Esta class extende a StringLinkedList existente no package anterior Na
 * verdade reimplementa os m�todos que faltavam.
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class StringLinkedListV2 extends StringLinkedList {

	public int IndexOf(String str) {
		if (head == null) {
			return -1;
		}
		int index = 0;
		Node aux = head;
		while (aux != null) {
			if (aux.data.equals(str)) {
				return index;
			}
			++index;
			aux = aux.link;
		}
		return -1;
	}

	public String getElementAt(int pos) {
		if (head != null) {
			Node aux = head;
			for (int i = 0; i < pos; ++i) {
				aux = aux.link;
				if (aux == null) {
					return null;
				}
			}
			return aux.data;
		}
		return null;
	}

	public boolean insertAt(String str, int pos) {
		if (pos < 0) {
			return false;
		}
		Node newNode = new Node(str, head);
		// inser��o � cabe�a
		if (pos == 0) {
			head = newNode;
			return true;
		}
		// inser��o sem ser � cabe�a
		if (head == null) {
			return false;
		}
		Node aux = head;
		for (int i = 0; i < pos - 1; ++i) {
			aux = aux.link;
			if (aux == null) {
				return false;
			}
		}
		newNode.link = aux.link;
		aux.link = newNode;
		return true;
	}

	public String removeAt(int pos) {
		// remo��es imposs�veis
		if (head == null || pos < 0) {
			return null;
		}
		String str;
		// remo��o � cabe�a
		if (pos == 0) {
			str = head.data;
			head = head.link;
			return str;
		}
		// remo��o sem ser � cabe�a
		Node aux = head;
		for (int i = 0; i < pos - 1; ++i) {
			aux = aux.link;
			if (aux == null) {
				return null;
			}
		}
		// verificar se terminou com elemento v�lido
		if (aux.link == null) {
			return null;
		}
		// devolver e remover o elemento
		str = aux.link.data;
		aux.link = aux.link.link;
		return str;
	}

	/**
	 * Remove a primeira ocorr�ncia de "elem"
	 */
	public String removeElement(String elem) {
		// remo��es imposs�veis
		if (head == null) {
			return null;
		}
		String str;
		// remo��o � cabe�a
		if (head.data.equals(elem)) {
			str = head.data;
			head = head.link;
			return str;
		}
		// remo��o sem ser � cabe�a
		Node aux = head;
		while (true) {
			if (aux.link == null)
				return null;
			if (aux.link.data.equals(elem))
				break;
			aux = aux.link;
		}
		// devolver e remover o elemento
		str = aux.link.data;
		aux.link = aux.link.link;
		return str;
	}

	// sugest�o de trabalho
	// remover todas as ocorr�ncias de um elemento
	// public String removeAllOccur(String elem) { }
}
