package chap4;

import main.Chapter;
import data.treegraph.*;
import util.*;

/*
 * solve Chapter 4.6: find common ancestor of 2 nodes
 * algo1: find if p, q on left or right:
 * if in left recursive to left node
 * if in right recursive to right node
 * if found if left and right > the current node is parent node
 * high complexity
 */
public class Chap46 extends Chapter {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataFeeder feed = new DataFeeder();
		
		//data: 8>5>9; 8>4>11>3;  5>7>1; 7>12>2
		BTree tree = feed.getUnbalancedTree();
		
		int n1 = 1, n2 = 3;
		BNode parent = getCommon(n1, n2, tree.getRoot());
		if (parent != null)
			System.out.format(" %d %d > %d \n", n1, n2, parent.getData());
		else 
			System.out.format(" %d %d > null \n", n1, n2);
	}
	
	public BNode getCommon(int p, int q, BNode node) {
		
		if (find(node.getLeft(), q) && find(node.getLeft(), p)) {
			return getCommon(p, q, node.getLeft());
		}
		else if (find(node.getRight(), q) && find(node.getRight(), p)) {
			return getCommon(p, q, node.getRight());
		}
		else 
			return node;
	}
	
	public boolean find(BNode node, int value) {
		boolean found = false; 
		
		if (node == null) {
			return found;
		}
		
		if (node.getData() == value) {
			return true;
		}
		
		found = find(node.getLeft(), value);
		if (!found)
			found = find(node.getRight(), value);
		
		return found; 
	}
	
}
