package chap4;

import main.Chapter;
import util.DataFeeder;
import data.treegraph.*;

/*
 * solve problem Chapter 4.2:
 * check whether binary tree is balanced
 */
public class Chap41 extends Chapter {

	/*
	 * main running method
	 * @see main.Chapter#run()
	 */
	public void run() {
		DataFeeder df = new DataFeeder();
		BTree tree = df.getUnbalancedTree();
		
		tree.inOrder(tree.getRoot());
		
	}
}
