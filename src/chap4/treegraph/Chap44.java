package chap4.treegraph;

import java.util.*;

import util.DataFeeder;
import data.treegraph.*;
import main.Chapter;

/*
 * solve Chapter 4.4: implement d linked list for BST with depth d
 * implements a BFS, iterates through each level index to get new list 
 */
public class Chap44 extends Chapter {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<LinkedList<BNode>> result = createLL(DataFeeder.getBSTSample1());
	}
	
	public List<LinkedList<BNode>> createLL(BSTree tree) {
		
		List<LinkedList<BNode>> lists = new ArrayList<LinkedList<BNode>>();
		
		BNode root = tree.getRoot();
		
		if (root == null) 
			return lists;
		
		LinkedList<BNode> list = new LinkedList<BNode>();
		int level = 0;
		list.add(root);
		lists.add(0, list);
		showLL(list);

		while (true) {
			
			list = new LinkedList<BNode>();
			
			LinkedList<BNode> tmp = lists.get(level);

			if (tmp.size() > 0) {
				for (BNode node : tmp) {
					BNode left = node.getLeft();
					BNode right = node.getRight();
					if (left != null)
						list.add(left);
					if (right != null) 
						list.add(right);
				}
				lists.add(level + 1, list);
				level++;
				showLL(list);
			}
			else {
				break;
			}
		}
		
		return lists;
	}
	
	private void showLL(LinkedList<BNode> list) {
		for (BNode node : list) {
			System.out.format(" %d ", node.getData());
		}
		System.out.println();
	}
}
