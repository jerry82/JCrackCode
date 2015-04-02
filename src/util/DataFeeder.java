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
}
