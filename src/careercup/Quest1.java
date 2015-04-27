package careercup;

import chap4.treegraph.*;
import data.treegraph.*;
import util.*;
/* 
 * write a function that counts the nodes in BS-tree whose values fit in the given range
 * 
 */

public class Quest1 {
	
	public void run() {
		BSTree tree = DataFeeder.getBSTSample1();
		tree.inOrder(tree.getRoot());
		
		int low = 1, high = 2;
		int count = countNode(tree.getRoot(), low, high);
		
		System.out.format("no %d -> %d: %d", low, high, count);
	}
	
	private int countNode(BNode node, int low, int high) {

		if (node == null) 
			return 0;
		
		int val = node.getData();
		
		if (val < low) 
			return countNode(node.getRight(), low, high);
		
		if (val > high) 
			return countNode(node.getLeft(), low, high);
		
		int result = 1 + countNode(node.getLeft(), low, high) + countNode(node.getRight(), low, high);
		
		return result;
	}
}
