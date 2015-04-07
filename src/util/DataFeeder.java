package util;


import data.treegraph.*;


/*
 * create sample data for testing algorithm
 */
public class DataFeeder {

	//data: A > B > C > E > F; E > D > B; C > A; A > E
	public JGraph getSampleGraph1() {
		JGraph graph = new JGraph();
		
		graph.addDirectedNode("A", "B", 1);
		graph.addDirectedNode("B", "C", 1);
		graph.addDirectedNode("C", "E", 1);
		graph.addDirectedNode("E", "F", 1);
		graph.addDirectedNode("E", "D", 1);
		graph.addDirectedNode("D", "B", 1);
		graph.addDirectedNode("C", "A", 1);
		graph.addDirectedNode("A", "E", 1);
		
		return graph;
	}
	
	//data: 8>5>9; 8>4>11>3;  5>7>1; 7>12>2
	public BTree getUnbalancedTree() {
		BTree tree = new BTree();
		
        tree.setRoot(new BNode(8));

        tree.getRoot().setLeft(new BNode(5));
        
        tree.getRoot().getLeft().setLeft(new BNode(9));
        tree.getRoot().getLeft().setRight(new BNode(7));
        tree.getRoot().getLeft().getRight().setLeft(new BNode(1));
        tree.getRoot().getLeft().getRight().setRight(new BNode(12));
        tree.getRoot().getLeft().getRight().getRight().setLeft(new BNode(2));

        tree.getRoot().setRight(new BNode(4));
        tree.getRoot().getRight().setRight(new BNode(11));
        tree.getRoot().getRight().getRight().setLeft(new BNode(3));
		
		return tree;
	}
	
	//data: 2 > 4 > 7 > 9 > 8; 7 > 5 > 6; 4 > 3; 2 > 1 ;   
	public BSTree getBSTSample1() {
		BSTree bst = new BSTree();
		
		int[] array = new int[] { 2, 4, 7, 3, 1, 9, 5, 6, 8};
		for (int i : array) {
			BNode node = new BNode(i);
			bst.add(node);
		}
		return bst;
	}
	
	//data:
	public int[] getIncreasingSeq() {
		int[] array = new int[] { 1, 3, 4, 5, 6, 7, 8, 9 };
		return array;
	}
}
