package task3;

public class Node {
	int value;
	int left;
	int right;
	
	public Node(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setLeft(int newNode) {
		this.left = newNode;
	}
	
	public void setRight(int newNode) {
		this.right = newNode;
	}
	
	public int getLeft() {
		return left;
	}
	
	public int getRight() {
		return right;
	}
}
