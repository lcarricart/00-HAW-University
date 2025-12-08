package test;

import java.util.ArrayList;
import java.util.LinkedList;
import nodes.*;	// Importing this class does not grant access to the protected methods, so everything is fine.
import treeManagement.TreeManager;

public class PatternRecognizer {
	private RootNode rootNode;
	private AbstractNode currentNode;
	private TreeManager patternsTreeManager; // So far I will not use this class
	
	public PatternRecognizer() {
		// RootNode always returns isValid() = true. It's an empty node that just points to the real first nodes (head of patternA/B/C/...)
		this.rootNode = new RootNode();
		
		// Possible patterns
		LinkedList<AbstractNode> patternA = new LinkedList<AbstractNode>();
		LinkedList<AbstractNode> patternB = new LinkedList<AbstractNode>();
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
		
		// Define patternB: +49 0175 477 7564
		patternB.add(new PlusNode());
		patternB.add(new DigitNode());
		patternB.add(new DigitNode());
		patternB.add(new SpaceNode());
		patternB.add(new DigitNode());
		patternB.add(new DigitNode());
		patternB.add(new DigitNode());
		patternB.add(new DigitNode());
		patternB.add(new SpaceNode());
		patternB.add(new DigitNode());
		patternB.add(new DigitNode());
		patternB.add(new DigitNode());
		patternB.add(new SpaceNode());
		patternB.add(new DigitNode());
		patternB.add(new DigitNode());
		patternB.add(new DigitNode());
		patternB.add(new DigitNode());
		
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
		linkNodes(patternB);
		linkNodes(patternC);
		
		// Link each header of the patterns to rootNode (THIS IS THE TREE ITSELF!)
		rootNode.setChild(0, patternA.get(0));
		rootNode.setChild(1, patternB.get(0));
		rootNode.setChild(2, patternC.get(0));
		
		// Since the tree is created, now I want to create an unnecessary TreeManager to define search algorithms and printing functions (if needed, so far I will not use it)
		this.patternsTreeManager = new TreeManager(rootNode);
	}
	
	public boolean check(String input) {
		int j = 0;
		boolean possibleFlag = false;
		boolean validFlag = true;
		
		// Crude implementation for this simple solution (I wanna know how many patterns are there inside rootNode)
		ArrayList<AbstractNode> childrenArray = (ArrayList<AbstractNode>) rootNode.getChildren();
		int numberChildren = childrenArray.size();
		
		// Check if it's possible to enter one of all patterns (A, B, C)
		while (j < numberChildren && !patternVisitedAndCorrect(possibleFlag, validFlag)) {
			int i = 0;
			currentNode = rootNode.getChild(j);
			possibleFlag = currentNode.isValid(input.charAt(0));
			
			// If possible, verify that the whole pattern is satisfied
			if (possibleFlag) {
				validFlag = true; // Reset the variable
				
				while ((i < input.length()) && validFlag && currentNode != null) {
					i++;
					
					currentNode = currentNode.getChild(0);
					
					if (currentNode != null && i < input.length()) {
						validFlag = currentNode.isValid(input.charAt(i));
					}
				}
			}
			
			j++;
		}
		
		// Later I can deal with the different cases
		if (validFlag == false) {
			// Pattern was broken ==> invalid input
			return false;
		} else if (currentNode != null) {
			// Input is incomplete
			return false;
		} else {
			// Input is valid!!
			return true;
		}
	}
	
	// Link Nodes from a List to its next
	private void linkNodes(LinkedList<AbstractNode> pattern) {
	    for (int i = 0; i < pattern.size() - 1; i++) {
	        // Tell Node K that Node K+1 is its child
	        pattern.get(i).setChild(0, pattern.get(i + 1));
	    }
	}
	
	// Helper method 1 to improve clarity of the if() statement in check() method
	private boolean patternVisitedAndCorrect(boolean possibleFlag, boolean validFlag) {
		return (possibleFlag == true && validFlag == true);
	}
}
