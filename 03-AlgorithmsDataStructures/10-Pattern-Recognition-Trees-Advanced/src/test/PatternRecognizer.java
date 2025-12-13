package test;

import java.util.ArrayList;
import java.util.LinkedList;
import nodes.*;	// Importing this class does not grant access to the protected methods, so everything is fine.
import tree.PatternsTree;

public class PatternRecognizer {
	private AbstractNode currentNode;
	private PatternsTree patternsTree;
	
	public PatternRecognizer() {
		// Since the tree is created, now I want to create an unnecessary TreeManager to define search algorithms and printing functions (if needed, so far I will not use it)
		this.patternsTree = new PatternsTree();
	}
	
	// The function should contain a recursive function that checks for available brnahces every time it enters a node
	public boolean check(String input) {
		int j = 0;
		boolean possibleFlag = false;
		boolean validFlag = true;
		
		currentNode = patternsTree.getRoot();
		
		// Here I need the recursive function that would do the same for every node it enters
		
		
		// Crude implementation for this simple solution (I wanna know how many patterns are there inside rootNode)
		ArrayList<AbstractNode> childrenArray = (ArrayList<AbstractNode>) currentNode.getChildren();
		int numberChildren = childrenArray.size();
		
		// Check if it's possible to enter one of all patterns (A, B, C)
		while (j < numberChildren && !patternVisitedAndCorrect(possibleFlag, validFlag)) {
			int i = 0;
			currentNode = patternsTree.getRoot().getChild(j);
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
	
	// Helper function 1 to improve clarity of the if() statement in check() method
	private boolean patternVisitedAndCorrect(boolean possibleFlag, boolean validFlag) {
		return (possibleFlag == true && validFlag == true);
	}
	
//	// Helper recursive function to generalize the tree functionality, accepting sub branches anywhere
//	private boolean[] recursiveCheck() {
//		
//	}
}
