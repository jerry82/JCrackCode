package data.treegraph;

/*
 * implementation of linked list node
 */
public class LLNode {
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LLNode getNext() {
		return next;
	}
	public void setNext(LLNode next) {
		this.next = next;
	}
	private int data;
	private LLNode next;
}
