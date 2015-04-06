package chap4;

import java.util.*;

import util.DataFeeder;
import data.treegraph.*;
import main.Chapter;

/*
 * solve Chapter 4.4: implement d linked list for BST with depth d
 * implement a BFS and mark the end point of child, 
 * change the endpoint to the last child of previous last child
 */
public class Chap44 extends Chapter {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataFeeder feed = new DataFeeder();
		List<LinkedList<BNode>> result = createLL(feed.getBSTSample1());
	}
	
	public List<LinkedList<BNode>> createLL(BSTree tree) {
		
		List<LinkedList<BNode>> lists = new ArrayList<LinkedList<BNode>>();
		
		Queue<BNode> queue = new LinkedList<BNode>();
		
		BNode root = tree.getRoot();
		BNode endNode = root;
		BNode tip = root;
		
		queue.add(root);
		LinkedList<BNode> tmpList = new LinkedList<BNode>();
		
		while (queue.size() > 0) {
			BNode cur = queue.poll();
			 
			BNode left = cur.getLeft();
			BNode right = cur.getRight();
			
			if (left != null) {
				tmpList.add(left);
				queue.add(left);
				tip = left;
			}
			if (right != null) {
				tmpList.add(right);
				queue.add(right);
				tip = right;
			}
			
			if (endNode.getData() == cur.getData()) {
				lists.add(tmpList);
				endNode = tip;
				
				System.out.println("add list >");				
				for (BNode node : tmpList) {
					System.out.format(" %d ", node.getData());
				}

				tmpList = new LinkedList<BNode>();
				System.out.println();
			}
		}
		return lists;
	}
}
