package data.treegraph;

import java.util.HashMap;

/*
 * implementation of graph node
 * 
 */
public class GNode {
	
	private String name; 
	private HashMap<String, Integer> neighbors = new HashMap<String, Integer>();
	private boolean visited;
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Integer> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(HashMap<String, Integer> neighbors) {
		this.neighbors = neighbors;
	}
	
	public GNode(String name) {
		this.name = name;
	}
	
}
