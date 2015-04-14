package chap4.treegraph;

import java.util.*;

import main.*;
import util.*;
import data.treegraph.*;

/*
 * solve exercise 4.1:
 * find if there's route between 2 nodes.
 */
public class Chap42 extends Chapter {
	
	/*
	 * main running method
	 * @see main.Chapter#run()
	 */
	@Override
	public void run() {
		JGraph graph = DataFeeder.getSampleGraph1();
		boolean foundPath = false;
				
		foundPath = dfs("F", "A", graph);;		
		System.out.println(Boolean.toString(foundPath));
		
	}

	/*
	 * bread first search implementation
	 */
	public boolean bfs(String v1, String v2, JGraph graph) {
		
		boolean foundPath = false;
		
		Queue<GNode> queue = new LinkedList<GNode>();
		
		HashMap<String, GNode> nodes = graph.getNodes();
		GNode start = nodes.get(v1);
		GNode end = nodes.get(v2);
		
		if (start == null || end == null) 
			return foundPath;
		
		queue.add(start);
		
		while (queue.size() > 0) {
			GNode cur = queue.poll();
			
			//mark current node as visited
			cur.setVisited(true);
			
			HashMap<String, Integer> nbs = cur.getNeighbors();
			for (String n : nbs.keySet()) {
				
				GNode tmp = nodes.get(n);
				if (n.equals(v2)) {
					foundPath = true;
					break;
				}
				else if (!tmp.isVisited()) {
					queue.add(nodes.get(n));
					System.out.println("add: " + n);
				}
			}
			
			if (foundPath) 
				break;
		}
		
		return foundPath;
	}
	
	/*
	 * depth first search implementation
	 */
	public boolean dfs(String v1, String v2, JGraph graph) {
		
		boolean foundPath = false; 
		
		List<GNode> vNodes = new ArrayList<GNode>();
		Stack<GNode> stack = new Stack<GNode>();
		
		HashMap<String, GNode> nodes = graph.getNodes();
		GNode start = nodes.get(v1);
		GNode end = nodes.get(v2);
		
		if (start == null || end == null) 
			return foundPath;
		
		stack.push(start);
		start.setVisited(true);
		vNodes.add(start);
		
		while (!stack.isEmpty()) {
			GNode cur = stack.peek();
			
			//System.out.println("stack size->" + stack.size());
			//System.out.println("peek: " + cur.getName());
			HashMap<String, Integer> nbs = cur.getNeighbors();
			
			boolean isLeaf = true;
			for (String n : nbs.keySet()) {
				GNode tmp = nodes.get(n);
				if (tmp.isVisited()) 
					continue;
				
				if (tmp.getName().equals(n)) {
					return true;
				}
				//System.out.println("inspected: " + tmp.getName());
				tmp.setVisited(true);
				vNodes.add(tmp);
				stack.push(tmp);
				isLeaf = false;
				break;
			}
			
			if (isLeaf) {
				stack.pop();
				//System.out.println("pop: " + stack.pop().getName());
			}
		}
		
		/*
		for (GNode node : vNodes) {
			System.out.println(" " + node.getName() + " ");
		}*/
		
		return foundPath;
		
	}
}
