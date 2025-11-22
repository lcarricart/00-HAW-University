package test;

import java.util.*;

public final class Node {
    private int value;
    Node parent;                      // package-private so SimpleIntTree can set it
    final List<Node> children = new ArrayList<>();

    public Node(int value) {          // public so callers can make standalone nodes if desired
        this.value = value;
    }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    public Node getParent() { return parent; }
    public List<Node> getChildren() { return Collections.unmodifiableList(children); }

    public int subtreeSize() {
        int s = 1;
        for (Node c : children) s += c.subtreeSize();
        return s;
    }
    
    public int height() {
        if (children.isEmpty()) return 0;
        int h = 0;
        for (Node c : children) h = Math.max(h, c.height());
        return h + 1;
    }

    @Override public String toString() { 
    	return Integer.toString(value); 
    }
}