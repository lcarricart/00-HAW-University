package treeManagement;

import nodes.AbstractNode;
import nodes.RootNode;

/* This class is kind of unnecessary because the tree is in fact the node (all its addChild methods and so on). This class is created to separate the algorithmic seach 
 * implementation and printing the tree (in case it is desired)
 * 
 * So far, I will not use this class
*/
public class TreeManager {
	private RootNode root;
	
	public TreeManager(RootNode root) {
		this.root = root;
	}
	
	public boolean searchNode(AbstractNode node) {
		// TODO (if needed)
		return false;
	}
	
	public void printTree() {
		// TODO (if needed)
	}
}
