package test;

import java.util.*;

public class Tree {
	private Node root = null;
	
	public Tree(int root) { 
		this.root = new Node(root);
	}
	
	public Node getRoot() {
		return root;
	}
	
	public boolean isEmpty() {
		boolean result = false;
		
		if (root == null) {
			result = true;
		}
		
		return result;
	}
	
	public void clear() {
		root = null;
	}
	
	public int height() {
		int height = 0;
		
		
		
		return height;
	}
	
	// This is a levelOrder tree traversion algorithm
	public void print() {
		// "Queue" class is just an interface. The LinkedList class makes a FIFO queue, can add/remove
		Queue<Node> q = new LinkedList<>();
		Node node;
		
		q.add(root);
		while (!q.isEmpty()) {
			node = q.poll();		// Removes and returns head; returns null if empty
			System.out.print(node.getValue());
			System.out.print(" | ");
			
			if (node.getLeft() != null) {
				q.add(node.getLeft());
			}
			
			if (node.getRight() != null) {
				q.add(node.getRight());
			}
		}
	}
}
