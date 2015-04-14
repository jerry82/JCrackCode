package chap4.treegraph;

import java.util.ArrayList;

import main.*;
import util.*;
import data.treegraph.*;

/*
 * solve Chapter 4.8: given a binary tree and sum, print all path sum up = that sum.
 * algo: uses 2 recursions, 1 recursion is to traverse through a tree, another is 
 * to find the node start from that traversing node.
 * - this is a tree not a graph so path will move downward
 * - when we find a path, move to the end till (there would be negative value)
 */
public class Chap48 extends Chapter {
	
	@Override
	public void run() {
		BSTree tree = DataFeeder.getBSTSample1();
		
		printPath(22, tree);
	}
	
	//the algorithm will deal with Binary Tree (BSTree is just the example)
	public void printPath(int sum, BSTree tree) {
		preOrder(tree.getRoot(), sum);
	}
	
	private void preOrder(BNode node, int sum) {
		if (node == null) {
			return;
		}
		
		trace(node, sum, new ArrayList<BNode>());
		preOrder(node.getLeft(), sum);
		preOrder(node.getRight(), sum);
		
	}
	
	//find path with sum = sum starting at root "node"
	// use in order traverse find on both side
	private void trace(BNode node, int sum, ArrayList<BNode> buffer) {
		if (node == null) 
			return;
		
		if (node.getData() > sum) {
			return;
		}
		
		buffer.add(node);
		if (node.getData() == sum) {
			//output node
			printArray(buffer);
		}
		
		ArrayList<BNode> newBuffer1 = (ArrayList<BNode>) (buffer.clone());
		trace(node.getLeft(), sum - node.getData(), newBuffer1);
		
		ArrayList<BNode> newBuffer2 = (ArrayList<BNode>) (buffer.clone());
		trace(node.getRight(), sum - node.getData(), newBuffer2);
	}
	
	private void printArray(ArrayList<BNode> buffer) {
		for (BNode node : buffer) {
			System.out.format(" %d ", node.getData());
		}
		System.out.println();
	}
}
