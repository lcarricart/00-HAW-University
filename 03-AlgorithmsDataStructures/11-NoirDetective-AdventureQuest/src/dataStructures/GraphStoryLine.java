package dataStructures;

import java.util.ArrayList;

import scenes.NodeScene;

public class GraphStoryLine {
	private AdjacencyRow rootRow;
	private ArrayList<AdjacencyRow> adjacencyList = new ArrayList<AdjacencyRow>();
	
	public GraphStoryLine(NodeScene root, String uid) {
		rootRow = new AdjacencyRow(root, uid);
		adjacencyList.add(rootRow);
	}
	
	// Add a NodeScene to the graph --> add an AdjacencyRow to the adjacencyList
	public void addNode(NodeScene node, String uid) {
		boolean flag = false;
		
		for (AdjacencyRow row : adjacencyList) {
			if (row.getUID() == uid) {
				flag = true;
			}
		}
		
		if (!flag) {
			AdjacencyRow nodeRow = new AdjacencyRow(node, uid);
			adjacencyList.add(nodeRow);
		} else {
			System.out.println("The chosen UID \"" + uid + "\" is already a Node of the adjacencyList");
			System.out.println("PROGRAM FAIL");
		}
	}
	
	// Remove nodes for when the user triggers stuff in the game (e.g.: a GAME OVER scene)
	public void removeNode(NodeScene node) {
		AdjacencyRow chosenRow = getAdjRow(node);
		adjacencyList.remove(chosenRow);
		
		// Clear all references to this item in the other neighbour lists of the adjacencyList
		for (AdjacencyRow row : adjacencyList) {
			if (row.contains(node)) {
				row.removeNeighbourFromNodeNamed(node);
			}
		}
	}
	
	// Return a Row if the UID matches; else return NULL.
	public AdjacencyRow getAdjRow(String uid) {
		for (AdjacencyRow row : adjacencyList) {
			if (row.getUID() == uid) {
				return row;
			}
		}
		
		return null;
	}
	
	// Return a Row if the baseNode matches; else return NULL.
	public AdjacencyRow getAdjRow(NodeScene baseNode) {
		for (AdjacencyRow row : adjacencyList) {
			if (row.getBaseNode() == baseNode) {
				return row;
			}
		}
		
		return null;
	}
	
	// One cannot operate just with this node information but needs to handle more complex logic from the moment of call (once knowing the rootNode, it can identify the rootList --> position 0 I guess also works but unflexible)
	public AdjacencyRow getRootRow() {
		return rootRow;
	}
}
