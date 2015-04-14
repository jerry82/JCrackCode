package chap4.treegraph;

import util.DataFeeder;
import main.Chapter;
import data.treegraph.*;

/*
 * solve Chapter 4.6 if the tree is BST
 * algo: pick larger value, assume it's q;
 * find the last parent of q such that this p < parent < q
 * always check whether p is common ancestor of both
 */
public class Chap46a extends Chapter {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//data: 2 > 4 > 7 > 9 > 8; 7 > 5 > 6; 4 > 3; 2 > 1 ; 
		BSTree tree = DataFeeder.getBSTSample1();
		
		//assume p < q
		int p = 1, q = 7;
		BNode node = getCommonNode(tree, p, q);
		if (node != null)
			System.out.format(" %d %d > %d", p, q, node.getData());
		else 
			System.out.format(" %d %d > null", p, q);
	}
	
	/*
	 * this method use parent pointer
	 */
	public BNode getCommon(BSTree tree, int p, int q) {
		BNode node = null;
		
		BNode qnode = tree.getNode(tree.getRoot(), q);
		BNode tmp = qnode.getParent();
		
		while (tmp != null) {
			if (tmp.getData() == p) 
				return tmp;
			
			if (tmp.getData() > q) {
				tmp = tmp.getParent();
			}
			else if (tmp.getData() > p && tmp.getData() < q) {
				node = tmp;
				tmp = tmp.getParent();
			}
			else {
				break;
			}
		}
		
		
		return node;
	}
	
	/*
	 * without using the parent pointer:
	 * O(logn)
	 */
	public BNode getCommonNode(BSTree tree, int p, int q) {
		BNode node = tree.getRoot();
		
		while (node != null) {
			if (node.getData() < p) {
				node = node.getRight();
			}
			else if (node.getData() > q) {
				node = node.getLeft();
			}
			else if (node.getData() >= p && node.getData() <= q) {
				break;
			}
		}
		
		return node;
	}

}
