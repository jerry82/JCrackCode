package data.treegraph;

/*
 * implementation of binary tree
 * to be completed ...
 */
public class BTree {
	
	public BNode getRoot() {
		return root;
	}

	public void setRoot(BNode root) {
		this.root = root;
	}
	
	/*
	 * traversal
	 */
	public void inOrder(BNode node) {
		
		if (node == null) 
			return;
		
		inOrder(node.getLeft());
		System.out.format(" %d ", node.getData());
		inOrder(node.getRight());
	}

	private BNode root;
}
