package data.treegraph;

/*
 * implementation of Binary Search Tree
 */
public class BSTree extends BTree {
	
	/*
	 * add new node
	 */
	public void add(BNode node) {
		
		if (this.getRoot() == null) {
			this.setRoot(node);
		}
		
		//traverse 
		BNode cur = this.getRoot();
		int nodeVal = node.getData();
		
		while (cur != null) {
			if (nodeVal < cur.getData()) {
				if (cur.getLeft() == null) {
					cur.setLeft(node);
					node.setParent(cur);
					break;
				}
				
				//node is there
				if (cur.getLeft().getData() == nodeVal) {
					break;
				}
				
				cur = cur.getLeft();
			}
			else if (nodeVal > cur.getData()) {
				if (cur.getRight() == null) {
					cur.setRight(node);
					node.setParent(cur);
					break;
				}
				
				//node is there
				if (cur.getRight().getData() == nodeVal) {
					break;
				}
				cur = cur.getRight();
			}
			//node is there
			else {
				break;
			}
		}
	}
	
	public BNode getNode(BNode cur, int val) {
		
		if (cur == null) {
			return null;
		}
		
		if (val < cur.getData())
			return getNode(cur.getLeft(), val);
		else if (val > cur.getData()) 
			return getNode(cur.getRight(), val);
		else 
			return cur;
	}
}
