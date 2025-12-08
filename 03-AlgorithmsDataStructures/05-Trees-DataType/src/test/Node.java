/*
 * METHODS
 * - getValue()
 * - setValue()
 * - getParent()
 * - getChildren()
 * - subTreeSize()
 * - height()
 */

package test;

import java.util.*;

public class Node {
	private int value; 
	private Node parent;
	private List<Node> children;
	
	public Node(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void addChild(Node child) {
		
	}
}