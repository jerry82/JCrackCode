package data.treegraph;

import java.util.*;

/*
 * Implementation of graph using: 
 * Adjacency List
 */
public class JGraph {
	
	private HashMap<String, GNode> nodes = new HashMap<String, GNode>();
	
	public HashMap<String, GNode> getNodes() {
		return nodes;
	}

	public void setNodes(HashMap<String, GNode> nodes) {
		this.nodes = nodes;
	}

	public JGraph() {
		
	}
	
	/*
	 * add edge, default value of edge = 1
	 */
	public void addDirectedNode(String v1, String v2, int value) {
		
		if (!nodes.containsKey(v1)) {
			nodes.put(v1, new GNode(v1));
		}
		
		if (!nodes.containsKey(v2)) {
			nodes.put(v2,  new GNode(v2));
		}
		
		GNode node1 = nodes.get(v1);
		
		HashMap<String, Integer> neighbors = node1.getNeighbors();
		if (!neighbors.containsKey(v2))
			neighbors.put(v2, 1);
	}
}
