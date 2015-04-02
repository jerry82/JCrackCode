package data.treegraph;

import java.util.*;

/*
 * Implementation of graph using: 
 * Adjacency List
 */
public class Graph {
	
	private HashMap<String, GNode> nodes = new HashMap<String, GNode>();
	
	public Graph() {
		
	}
	
	
	public void addDirectedNode(String v1, String v2, int value) {
		
		if (!nodes.containsKey(v1)) {
			nodes.put(v1, new GNode(v1));
		}
		
		if (!nodes.containsKey(v2)) {
			nodes.put(v2,  new GNode(v2));
		}
		
		
	}
	
}
