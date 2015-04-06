package chap4;

import data.treegraph.*;
import main.Chapter;
import util.*;
/* 
 * solve Chapter 4.5: find next note (in-order traverse) of BST, node has pointer to its 
 * parents 
 * algo: 
 * 1. node has right child, go right and turn left all the way from that right child
 * 2. node has no right child, go up until the value > its value
 */
public class Chap45 extends Chapter {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataFeeder feed = new DataFeeder();
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		for (int i : arr) {
			BNode tmp = nextInOrder(feed.getBSTSample1(), i);
			
			if (tmp != null)
				System.out.format(" %d > %d \n", i, tmp.getData());
			else 
				System.out.format(" %d > null \n", i);	
		}
		
		
	}
	
	public BNode nextInOrder(BSTree tree, int curVal) {
		BNode next = null;
		
		BNode cur = tree.getRoot();
		if (cur == null) 
			return null;
		
		//find the node
		while (true) {
			
			if (curVal > cur.getData()) {
				cur = cur.getRight();
			}
			else if (curVal < cur.getData()) {
				cur = cur.getLeft();
			}
			else {
				//found node
				break;
			}
			
			if (cur == null) {
				break;
			}
		}
		
		//found the cur node
		if (cur != null) {
			//case 1: no right child 
			if (cur.getRight() == null) {
				
				BNode tmp = cur; 
				
				while (tmp != null) {
					tmp = tmp.getParent();
					if (tmp != null) {
						if (tmp.getData() > curVal) {
							next = tmp;
							break;
						}		
					}
				}
				
			}
			//case 2: has right child
			else {
				BNode tmp = cur.getRight();
				while (tmp != null) {
					next = tmp;
					tmp = tmp.getLeft();
				}
			}
		}
		
		
		return next;
	}

}
