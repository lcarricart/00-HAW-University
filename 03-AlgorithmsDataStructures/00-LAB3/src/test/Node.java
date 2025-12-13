package test;

public abstract class Node {
	private Node parent, left, right;
	private int key; // Our value (key for ordering; if timestamp, its already ordered)
	
	public Node(int key) {
		this.key = key;
	}
	
	// Copy constructor that doesn't copy the parent, left, or right. It just gives you a new node with the same data stored in it
	public Node(Node toBeCopied) {
		this.key = toBeCopied.getKey();
	}
	
	public int getKey() {
		return key;
	}
	
	public Node getParent() {
		return parent;
	} 
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left= left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
}
