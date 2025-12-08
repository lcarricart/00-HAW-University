package test;

import nodes.*;		// Importing this class does not grant access to the protected methods, so everything is fine.

public class PatternRecognizer {
	private ParenthesisOpenNode rootNode;
	private AbstractNode currentNode;
	
	public PatternRecognizer() {
		// I start with a parenthesis because I'm defining the start of my pattern always to start with a parenthesis (for the area code)
		// Sometimes, programmers use a "Dummy Node" or a "Start Node" at the very beginning that doesn't actually check anything. It just points to the real first node.
		this.rootNode = new ParenthesisOpenNode();
		
		// Define the pattern
		AbstractNode pattern[] = new AbstractNode[19];
		pattern[0] = rootNode;
		pattern[1] = new PlusNode();
		pattern[2] = new DigitNode();
		pattern[3] = new DigitNode();
		pattern[4] = new ParenthesisClosedNode();
		pattern[5] = new SpaceNode();
		pattern[6] = new DigitNode();
		pattern[7] = new DigitNode();
		pattern[8] = new DigitNode();
		pattern[9] = new DigitNode();
		pattern[10] = new SpaceNode();
		pattern[11] = new DigitNode();
		pattern[12] = new DigitNode();
		pattern[13] = new DigitNode();
		pattern[14] = new SpaceNode();
		pattern[15] = new DigitNode();
		pattern[16] = new DigitNode();
		pattern[17] = new DigitNode();
		pattern[18] = new DigitNode();
		
		// Establish the Linked List (I'm not using the Java class, but this is the behavior of my Node class)
		for (int i = 0; i < pattern.length - 1; i++) {
			pattern[i].setNext(pattern[i+1]);
		}
	}
	
	public boolean check(String input) {
		int i = 0;
		boolean validFlag = true;
		
		validFlag = rootNode.isValid(input.charAt(0));
		currentNode = rootNode.getNext();
		
		while ((i < input.length()-1)  && validFlag && currentNode != null) {
			i++;
			validFlag = currentNode.isValid(input.charAt(i));
			currentNode = currentNode.getNext();
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
}
