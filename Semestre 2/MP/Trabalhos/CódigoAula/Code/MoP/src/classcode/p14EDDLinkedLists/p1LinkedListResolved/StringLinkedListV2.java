package classcode.p14EDDLinkedLists.p1LinkedListResolved;

/**
 * Esta class extende a StringLinkedList existente no package anterior Na
 * verdade reimplementa os métodos que faltavam.
 * 
 * @author António Teófilo
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
		// inserção à cabeça
		if (pos == 0) {
			head = newNode;
			return true;
		}
		// inserção sem ser à cabeça
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
		// remoções impossíveis
		if (head == null || pos < 0) {
			return null;
		}
		String str;
		// remoção à cabeça
		if (pos == 0) {
			str = head.data;
			head = head.link;
			return str;
		}
		// remoção sem ser à cabeça
		Node aux = head;
		for (int i = 0; i < pos - 1; ++i) {
			aux = aux.link;
			if (aux == null) {
				return null;
			}
		}
		// verificar se terminou com elemento válido
		if (aux.link == null) {
			return null;
		}
		// devolver e remover o elemento
		str = aux.link.data;
		aux.link = aux.link.link;
		return str;
	}

	/**
	 * Remove a primeira ocorrência de "elem"
	 */
	public String removeElement(String elem) {
		// remoções impossíveis
		if (head == null) {
			return null;
		}
		String str;
		// remoção à cabeça
		if (head.data.equals(elem)) {
			str = head.data;
			head = head.link;
			return str;
		}
		// remoção sem ser à cabeça
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

	// sugestão de trabalho
	// remover todas as ocorrências de um elemento
	// public String removeAllOccur(String elem) { }
}
