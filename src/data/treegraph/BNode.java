package data.treegraph;

/*
 * implementation of Node for Binary Tree
 */
public class BNode {
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BNode getLeft() {
		return left;
	}
	public void setLeft(BNode left) {
		this.left = left;
	}
	public BNode getRight() {
		return right;
	}
	public void setRight(BNode right) {
		this.right = right;
	}
	
	public BNode(int data) {
		this.data = data;
	}
	
	public BNode getParent() {
		return parent;
	}
	
	public void setParent(BNode parent) {
		this.parent = parent;
	}
	
	private int data;
	private BNode left;
	private BNode right;
	private BNode parent;
}
