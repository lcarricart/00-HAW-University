package test;

public class Node {
	private int value;
	private Node leftNode = null;
	private Node rightNode = null;
	
	public Node(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int number) {
		value = number;
	}
	
	// Wild implementation but allows you to set a whole branch of a tree at once.
	public Node setLeft(int value) {
		leftNode = new Node(value);
		return leftNode;
	}
	
	// Wild implementation but allows you to set a whole branch of a tree at once.
	public Node setRight(int value) {
		rightNode = new Node(value);
		return rightNode;
	}
	
	public Node getLeft() {
		return leftNode;
	}
	
	public Node getRight() {
		return rightNode;
	}
}
