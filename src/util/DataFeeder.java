package util;


import data.treegraph.*;


/*
 * create sample data for testing algorithm
 */
public class DataFeeder {

	private DataFeeder() {
		
	}
	
	//data: A > B > C > E > F; E > D > B; C > A; A > E
	public static JGraph getSampleGraph1() {
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
	public static BTree getUnbalancedTree() {
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
	public static BSTree getBSTSample1() {
		BSTree bst = new BSTree();
		
		int[] array = new int[] { 2, 4, 7, 3, 1, 9, 5, 6, 8};
		for (int i : array) {
			BNode node = new BNode(i);
			bst.add(node);
		}
		return bst;
	}
	
	//data: 7 > 5 > 6; 7 > 9 > 8
	public static BSTree getBSTSample2() {
		BSTree bst = new BSTree();
		
		int[] array = new int[] { 7, 5, 9, 6, 8};
		for (int i : array) {
			BNode node = new BNode(i);
			bst.add(node);
		}
		return bst;
	}
	
	//data:
	public static int[] getIncreasingSeq() {
		int[] array = new int[] { 1, 3, 4, 5, 6, 7, 8, 9 };
		return array;
	}
	
	//ab20 ag90 ad80, bf10, cf50 cd10 ch20, dc10, dg20, 
	//eg30, eb50, fc10, fd40, ga20, 
	public static JGraph getDjikstraGraphSample1() {
		JGraph graph = new JGraph();
		
		graph.addDirectedNode("A", "B", 20);
		graph.addDirectedNode("A", "G", 90);
		graph.addDirectedNode("A", "D", 80);
		graph.addDirectedNode("B", "F", 10);
		graph.addDirectedNode("C", "F", 50);
		
		graph.addDirectedNode("C", "D", 10);
		graph.addDirectedNode("C", "H", 20);
		graph.addDirectedNode("D", "C", 10);
		graph.addDirectedNode("D", "G", 20);
		graph.addDirectedNode("E", "G", 30);
		
		graph.addDirectedNode("E", "B", 50);
		graph.addDirectedNode("F", "C", 10);
		graph.addDirectedNode("F", "D", 40);
		graph.addDirectedNode("G", "A", 20);
		
		return graph;
	}
	
	public static int[] getUnsortedArray1() {
		return new int[] { 5, 2, 6, 1 ,3, 2, 4, 4};
	}
	
	public static int[] getUnsortedArray2() {
		return new int[] { 170, 45, 75, 90, 802, 24, 2, 66 };
	}
	
	public static int[] getUnsortedArray3() {
		return new int[] { 9, 179, 139, 38, 10, 5, 36 };
	}
	
	public static float[] getUnsortedFloatArray1() {
		float[] arr = new float[] {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};
		return arr;
	}
	
	public static int[] getUnsortedArray4() {
		return new int[] { 41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61}; 
	}
}
