package data.treegraph;

import java.util.*;
/*
 * implementation of disjoint-set
 */
public class DisjointSet {

	private HashMap<String, String> parent;
	private HashMap<String, Integer> rank;
	
	public DisjointSet() {
		
	}
	
	public void makeSet(String name) {
		if (!parent.containsKey(name)) {
			parent.put(name, name);
			rank.put(name,  0);
		}
	}
	
	public String findRoot(String name) {
		String root = null;
		
		if (name == null) 
			return root;
		
		if (parent.get(name).equals(name)) {
			return name;
		}
		
		root = findRoot(parent.get(name));
		
		return root;
	}
	
	public void union(String node1, String node2) {
		String root1 = findRoot(node1);
		String root2 = findRoot(node2);
		
		//same set
		if (root1.equals(root2))
			return;
		
		int rank1 = rank.get(root1);
		int rank2 = rank.get(root2);
		
		if (rank1 > rank2) {
			parent.put(root2, root1);
		}
		else if (rank1 < rank2) {
			parent.put(root1, root2);
		}
		//select root2 parent
		else {
			parent.put(root1, root2);
			rank.put(root2, rank.get(root2) + 1);
		}
	}
	
	public HashMap<String, String> getParent() {
		return parent;
	}
	public void setParent(HashMap<String, String> parent) {
		this.parent = parent;
	}
	public HashMap<String, Integer> getRank() {
		return rank;
	}
	public void setRank(HashMap<String, Integer> rank) {
		this.rank = rank;
	}
}
