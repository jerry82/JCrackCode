package chap4;

import data.treegraph.BNode;
import data.treegraph.BSTree;
import util.DataFeeder;
import main.Chapter;

/*
 * Solve Chapter 4.3: 
 * given sorted array, write algo to create binary Search tree minimal height
 * algo: left tree and right tree same number of nodes
 */
public class Chap43 extends Chapter {

	@Override
	public void run() {
		DataFeeder feeder = new DataFeeder();
		int[] data = feeder.getIncreasingSeq();

		BSTree bst = buildBST(data);
		bst.inOrder(bst.getRoot());
	}
	
	public BSTree buildBST(int[] array) {
		BSTree bst = new BSTree();
		
		BNode root = buildNode(bst, array, 0, array.length - 1);
		bst.setRoot(root);
		
		return bst;
	}
	
	public BNode buildNode(BSTree bst, int[] array, int start, int end) {
		
		BNode tmp = null;
		
		int mid = (start + end) / 2;
		if (start == end) {
			tmp = new BNode(array[start]);
			return tmp;
		}
		
		if (start > end) {
			return null;
		}

		int midV = array[mid];		
		
		BNode cur = new BNode(midV);
		BNode left = buildNode(bst, array, start, mid - 1);
		cur.setLeft(left);
		
		BNode right = buildNode(bst, array, mid + 1, end);
		cur.setRight(right);
		
		int leftV = cur.getLeft() == null ? -1 : cur.getLeft().getData();
		int rightV = cur.getRight() == null ? -1 : cur.getRight().getData();

		System.out.format("%d  %d %d \n", cur.getData(), leftV, rightV);
		
		return cur;
	}
}
