package chap4.treegraph;

import util.DataFeeder;
import main.Chapter;
import data.treegraph.BNode;
import data.treegraph.BSTree;

/* 
 * solve chapter 4.7: check whether T2 is subtree of T1 (T1 has million of nodes)
 * algo: find root T2 in T1 and do (pre-order) check every node
 * complexity: N + M (N -> time to find out root2 on T1, M number of node on T2)
 */
public class Chap47 extends Chapter {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BSTree tree1 = DataFeeder.getBSTSample1();
		BSTree tree2 = DataFeeder.getBSTSample2();
		
		boolean result = checkSubtree(tree1, tree2);
		String display = !result ? "NOT a subtree" : "INDEED a subtree";
		System.out.println(display);
	}
	
	public boolean checkSubtree(BSTree tree1, BSTree tree2) {
		boolean result = false; 
		
		BNode root2 = tree2.getRoot();
		if (root2 == null) 
			return result;
		
		BNode node = getNode(root2.getData(), tree1.getRoot());
		boolean[] results = new boolean[] { true };
		int[] calls = new int[] { 0 };
		checkPreorder(node, root2, results, calls);
		
		result = results[0];
		
		System.out.println("found: " + node.getData());
		System.out.println("calls: " + calls[0]);
		
		return result;
	}
	
	private void checkPreorder(BNode node1, BNode node2, boolean[] results, int[] calls) {
		
		if (!results[0])
			return;
		
		if (node1 == null) 
			return;
		
		calls[0]++;
		//System.out.println("call node1: " + node1.getData());
		
		if (node2 == null) {
			results[0] = false; 
			return;
		}
		
		if (node1.getData() != node2.getData()) {
			results[0] = false;
			return;
		}
		else {
			checkPreorder(node1.getLeft(), node2.getLeft(), results, calls);
			checkPreorder(node1.getRight(), node2.getRight(), results, calls);
		}
	}
	
	
	//O(n) for searching within normal binary tree (i don't use BST property here)
	private BNode getNode(int val, BNode node1) {
		BNode result = null;
		
		if (node1 == null) 
			return null;
		
		if (node1.getData() == val) 
			return node1;
		else {
			result = getNode(val, node1.getLeft());
			if (result == null) 
				result = getNode(val, node1.getRight());
			else 
				return result;
		}
			
		return result;
	}

}
