package bookcode.p12DynamicDataStructAndGenerics;

/**
 * A class that implements a node of a linked list of strings
 */
public class C04ListNode {

	// the data item
	private String data;
	// the reference to the next node
	private C04ListNode link;

	// constructor
	public C04ListNode() {
		link = null;
		data = null;
	}

	// constructor
	public C04ListNode(String newData, C04ListNode linkValue) {
		data = newData;
		link = linkValue;
	}

	public void setData(String newData) {
		data = newData;
	}

	public String getData() {
		return data;
	}

	public void setLink(C04ListNode newLink) {
		link = newLink;
	}

	public C04ListNode getLink() {
		return link;
	}
}