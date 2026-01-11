// I want a behavior that goes like adjacencyList.get(IntroNode) OR adjacencyList.get(CrimeSceneNode) but it isn't possible.
// Therefore I wanna replicate this doing adjacencyList.get("Intro Node") OR adjacencyList.get("Crime Scene Node")
// For this I need a class called AdjacencyRow that stores both the List of neighbors for each node and a String containing its own name (name of the node)

package dataStructures;

import java.util.ArrayList;
import java.util.Iterator;

import scenes.NodeScene;

public class AdjacencyRow {
	private String uid;
	private NodeScene baseNode;	// Knows its base node but it is not stored in the list of neighbors
	private ArrayList<Edge> neighbours = new ArrayList<Edge>(); // Originally I wanted to keep this as a List of NodeScenes, but I missed a logic for the connection between nodes. This is why List<Edge> works better now
	
	public AdjacencyRow(NodeScene baseNode, String uid) {
		this.uid = uid;
		this.baseNode = baseNode;
	}
	
	public void addNeighbour(NodeScene destination, String actionText) {
		Edge edge = new Edge(destination, actionText);
		neighbours.add(edge);
	}
	
	public void removeNeighbourFromNodeNamed(NodeScene node) {
		// This intuitive implementation crashes because I modify the Object I am iterating through in real-time
//		for (Edge edge : neighbours) {
//			if (edge.getDestination() == node) {
//				neighbours.remove(edge);
//			}
//		}
		
		// This implementation solves the issue
		Iterator<Edge> iterator = neighbours.iterator();
		while (iterator.hasNext()) {
		    Edge edge = iterator.next();
		    if (edge.getDestination() == node) {
		        iterator.remove(); // Safe! The iterator updates its state. This iterator is remote controlling my neighbours variable (doesn't handle a copy of it)
		    }
		}
	}
	
	public void removeNeighbourFromNodeNamed(String uid) {
		// Similar to what was explained in the previous function overload of "removeNeighbourFromNodeNamed()", the use of the iterator is the correct approach
		Iterator<Edge> iterator = neighbours.iterator();
		while (iterator.hasNext()) {
		    Edge edge = iterator.next();
		    if (edge.getDestination().getUniqueName() == uid) {
		        iterator.remove(); // Safe! The iterator updates its state. This iterator is remote controlling my neighbours variable (doesn't handle a copy of it)
		    }
		}
	}
	
	public String getUID() {
		return uid;
	}
	
	public NodeScene getBaseNode() {
		return baseNode;
	}
	
	public ArrayList<Edge> getNeighbours() {
		return neighbours;
	}
	
	public NodeScene getOneNeighbour(int index) {
		return neighbours.get(index).getDestination();
	}
	
	public int getLength() {
		return neighbours.size();
	}
	
	public boolean contains(NodeScene node) {
		boolean contained = false;
		
		for (Edge edge : neighbours) {
			if (edge.getDestination() == node) {
				contained = true;
			}
		}
		
		return contained;
	}
}
