package chap4.treegraph;

import java.util.*;
import data.treegraph.*;
import main.*;
import util.*;

/*
 * implementation of Djikstra's algorithm:
 * Given a weight graph, find shortest path from 1 node to all of the other nodes
 * 
 */
public class Chap49 extends Chapter{

	@Override
	public void run() {
		JGraph graph = DataFeeder.getDjikstraGraphSample1();
		runDT(graph.getNodes().get("A"), graph);
	}
	
	private void runDT(GNode root, JGraph graph) {
		if (root == null) { 
			System.out.println("cannot find node");
			return;
		}
		
		HashMap<String, Path> neighbors = new HashMap<String, Path>();
		HashMap<String, GNode> nodes = graph.getNodes();
		
		
		//1. build up temp hashmap to store the minimum path, exclude the starting node
		for (String name : nodes.keySet()) {
			if (name.equals(root.getName())) {
				continue;
			}
			neighbors.put(name, new Path());
		}
		
		//2. main algorithm
		GNode cur = root;
		cur.setVisited(true);
		while(true) {
			//calculate path
			HashMap<String, Integer> nbs = cur.getNeighbors();
			if (nbs != null) {
				String from = cur.getName();
				for (String nbName : nbs.keySet()) {
					if (nbName == root.getName()) 
						continue;
					Path path = neighbors.get(nbName);
					int cost = nbs.get(nbName);
					if (cur != root)
						cost = nbs.get(nbName) + neighbors.get(cur.getName()).getValue();
					
					System.out.print(" " + nbName);
					if (path.getValue() >= cost) {
						path.setValue(cost);
						path.setName(from);
					}
				}
				System.out.println();
			}
			
			//get next min-cost and unvisited node
			String uNode = getMinUnvisitedNode(neighbors, nodes);
			showNeighbors(neighbors);
			//break while loop if == null -> done
			if (uNode != null) {
				cur = nodes.get(uNode);
				cur.setVisited(true);
				System.out.println("pick: " + cur.getName());
			}
			else {
				System.out.println("end");
				break;
			}
			
			Scanner scan=new Scanner(System.in);
			//scan.nextLine();
	
		}
	}
	
	private String getMinUnvisitedNode(HashMap<String, Path> neighbors, HashMap<String, GNode> nodes) {
		String node = null;
		int min = Integer.MAX_VALUE;
		
		for (String name : neighbors.keySet()) {
			if (!nodes.get(name).isVisited()) {
				Path path = neighbors.get(name);
				if (path.getValue() < min) {
					min = path.getValue();
					node = name;
				}
			}
		}
		
		return node;
	}
	
	private void showNeighbors(HashMap<String, Path> nb) {
		for (String name : nb.keySet()) {
			Path path = nb.get(name);
			if (nb.get(name).getValue() < Integer.MAX_VALUE)
				System.out.format("->%s (%d|%s)", name, path.getValue(), path.getName());
			else 
				System.out.format("->%s (INF)", name);
		}
	}
	
	public class Path {
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getName() {
			return from;
		}
		public void setName(String from) {
			this.from = from;
		}
		private int value = Integer.MAX_VALUE;
		private String from;
		
		public Path() {
			
		}
	}
	
}
