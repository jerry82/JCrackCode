package chap4;

import main.Chapter;
import util.DataFeeder;
import data.treegraph.*;

/*
 * solve problem Chapter 4.2:
 * check whether binary tree is balanced
 * alg: if left and right tree balance and different of max depth from left,right < 1
 */
public class Chap41 extends Chapter {

	/*
	 * main running method
	 * @see main.Chapter#run()
	 */
	@Override
	public void run() {
		DataFeeder df = new DataFeeder();
		BTree tree = df.getUnbalancedTree();
		
		tree.inOrder(tree.getRoot());
		
		int depth = getMaxDepth(tree.getRoot());
		
		System.out.format("\ndepth: %d\n", depth);
		
	}
	
	public int getMaxDepth(BNode node) {
		
		int depth = 0;
		
		if (node == null) {
			return depth;
		}
		
		BNode left = node.getLeft();
		BNode right = node.getRight();
		
		if (left == null && right == null) {
			return depth;
		}

		int leftD = getMaxDepth(left);
		int rightD = getMaxDepth(right);
		
		depth = (leftD > rightD) ? leftD + 1 : rightD + 1;
		
		if ((Math.abs(leftD - rightD)) > 1) {
			System.out.format("\n un-balanced at: %d \n", node.getData());
		}

		
		return depth;
	}
}
