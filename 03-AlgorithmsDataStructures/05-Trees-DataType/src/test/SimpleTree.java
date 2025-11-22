package test;

import java.util.*;

public class SimpleTree {
    private Node root;
    private int size;
    
    public SimpleTree() {
    	this.root = new Node(rootValue, null);
        this.size = 1;
    }
    
    public Node setRoot(int value) {
        clear();
        root = new Node(value, null);
        size = 1;
        return root;
    }
    
    public Node getRoot() {
        return root;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public int size() {
        return size;
    }
    
    public void clear() {
        root = null;
        size = 0;
    }
    
    public int height() {
        if (root == null) return -1; // empty tree convention
        return root.height();
    }
    
    // Helpers
    
    private int height() {
        if (children.isEmpty()) return 0;
        int h = 0;
        for (Node c : children) h = Math.max(h, c.height());
        return h + 1;
    }
}
