package dataStructures;

import scenes.NodeScene;

public class Edge {
	private NodeScene destination;
	private String actionText;
	
	public Edge(NodeScene destination, String actionText) {
		this.destination = destination;
		this.actionText = actionText;
	}
	
	public NodeScene getDestination() {
		return destination;
	}
	
	public String getActionText() {
		return actionText;
	}
}
