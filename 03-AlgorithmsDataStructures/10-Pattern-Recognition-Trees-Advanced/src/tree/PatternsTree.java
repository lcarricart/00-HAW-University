package tree;

import java.util.LinkedList;

import nodes.AbstractNode;
import nodes.DigitNode;
import nodes.ParenthesisClosedNode;
import nodes.ParenthesisOpenNode;
import nodes.PlusNode;
import nodes.RootNode;
import nodes.SpaceNode;

// This class contains all the pre-defined patterns in the form of a tree. Furthermore, it provides tree management methods.
public class PatternsTree {
	private RootNode rootNode;
	
	public PatternsTree() {
		init();
	}
	
	public RootNode getRoot() {
		return rootNode;
	}
	
	public boolean searchNode(AbstractNode node) {
		// TODO (if needed)
		return false;
	}
	
	public void printTree() {
		// TODO (if needed)
	}
	
	// Initializing helper function inside the class constructor
	private void init() {
		// RootNode always returns isValid() = true. It's an empty node that just points to the real first nodes (head of patternA/B/C/...)
		this.rootNode = new RootNode();
		
		// Possible patterns
		LinkedList<AbstractNode> patternA = new LinkedList<AbstractNode>();
		LinkedList<AbstractNode> patternB = new LinkedList<AbstractNode>();
		LinkedList<AbstractNode> patternB1 = new LinkedList<AbstractNode>();
		LinkedList<AbstractNode> patternB2 = new LinkedList<AbstractNode>();
		LinkedList<AbstractNode> patternC = new LinkedList<AbstractNode>();
		
		// Define patternA: (+49) 0175 477 7564
		patternA.add(new ParenthesisOpenNode());
		patternA.add(new PlusNode());
		patternA.add(new DigitNode());
		patternA.add(new DigitNode());
		patternA.add(new ParenthesisClosedNode());
		patternA.add(new SpaceNode());
		patternA.add(new DigitNode());
		patternA.add(new DigitNode());
		patternA.add(new DigitNode());
		patternA.add(new DigitNode());
		patternA.add(new SpaceNode());
		patternA.add(new DigitNode());
		patternA.add(new DigitNode());
		patternA.add(new DigitNode());
		patternA.add(new SpaceNode());
		patternA.add(new DigitNode());
		patternA.add(new DigitNode());
		patternA.add(new DigitNode());
		patternA.add(new DigitNode());
		
		// Define patternB header: +
		patternB.add(new PlusNode());
		
		// Define patternB1: 49 0175 477 7564
		patternB1.add(new DigitNode());
		patternB1.add(new DigitNode());
		patternB1.add(new SpaceNode());
		patternB1.add(new DigitNode());
		patternB1.add(new DigitNode());
		patternB1.add(new DigitNode());
		patternB1.add(new DigitNode());
		patternB1.add(new SpaceNode());
		patternB1.add(new DigitNode());
		patternB1.add(new DigitNode());
		patternB1.add(new DigitNode());
		patternB1.add(new SpaceNode());
		patternB1.add(new DigitNode());
		patternB1.add(new DigitNode());
		patternB1.add(new DigitNode());
		patternB1.add(new DigitNode());
		
		// Define patternB2: 966 0175 477 7564
		patternB2.add(new DigitNode());
		patternB2.add(new DigitNode());
		patternB2.add(new DigitNode());
		patternB2.add(new SpaceNode());
		patternB2.add(new DigitNode());
		patternB2.add(new DigitNode());
		patternB2.add(new DigitNode());
		patternB2.add(new DigitNode());
		patternB2.add(new SpaceNode());
		patternB2.add(new DigitNode());
		patternB2.add(new DigitNode());
		patternB2.add(new DigitNode());
		patternB2.add(new SpaceNode());
		patternB2.add(new DigitNode());
		patternB2.add(new DigitNode());
		patternB2.add(new DigitNode());
		patternB2.add(new DigitNode());
		
		// Define patternC: 0175 477 7564
		patternC.add(new DigitNode());
		patternC.add(new DigitNode());
		patternC.add(new DigitNode());
		patternC.add(new DigitNode());
		patternC.add(new SpaceNode());
		patternC.add(new DigitNode());
		patternC.add(new DigitNode());
		patternC.add(new DigitNode());
		patternC.add(new SpaceNode());
		patternC.add(new DigitNode());
		patternC.add(new DigitNode());
		patternC.add(new DigitNode());
		patternC.add(new DigitNode());
		
		// Link each Node to the next one. The List knows that they're linked, but every Node is not aware of that
		linkNodes(patternA);
		linkNodes(patternB1);
		linkNodes(patternB2);
		linkNodes(patternC);
		
		// Link each header of the patterns to rootNode (THIS IS THE TREE ITSELF!)
		rootNode.setChild(0, patternA.get(0));
		rootNode.setChild(1, patternB.get(0));
		rootNode.getChild(1).setChild(0, patternB1.get(0));
		rootNode.getChild(1).setChild(1, patternB2.get(0));
		rootNode.setChild(2, patternC.get(0));
	}
	
	// Link Nodes from a List to its next
	private void linkNodes(LinkedList<AbstractNode> pattern) {
	    for (int i = 0; i < pattern.size() - 1; i++) {
	        // Tell Node K that Node K+1 is its child
	        pattern.get(i).setChild(0, pattern.get(i + 1));
	    }
	}
}
