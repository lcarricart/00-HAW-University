package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Generic extends Node is a type bound; we accept any Element that extends Node. The class is also defining two different generics, one
 * for the data type of Node, and one for the Node.
 */
public class SortedBinaryTree implements Iterable<Node> {
	private Node root;
	
	public SortedBinaryTree(Node root) {
		this.root = root;
		root.setLeft(null);
		root.setRight(null);
		root.setParent(null);
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void insert(Node newNode) {
		insertRecursive(root, newNode); // Following structure: current, Node to be added, parent
	}
	
	// Probably part of the iterator pattern, explained in the lecture slides "04 - Foundations of graph and tree structures"
	public TreeIterator iterator() {
		TreeIterator myIterator = new TreeIterator(this);
		return myIterator;
	}
	
	public void printGrid() {
        if (root == null) {
            System.out.println("(Empty Tree)");
            return;
        }
        
        int maxLevel = getHeight(root);
        List<List<String>> rows = new ArrayList<>();
        
        // Initialize the grid with spaces
        for (int i = 0; i < maxLevel + 1; i++) {
            List<String> row = new ArrayList<>();
            // Width of the grid is roughly 2^height - 1
            int width = (int) Math.pow(2, maxLevel) - 1; 
            for (int j = 0; j < width; j++) {
                row.add(" "); // Empty cell
            }
            rows.add(row);
        }

        // Fill the grid recursively
        fillGrid(root, 0, 0, rows.get(0).size(), rows);

        // Print the grid
        //System.out.println("--- Visual Tree Grid ---\n");
        for (List<String> row : rows) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println(); 
            System.out.println(); 
        }
    }

    // Helper to fill the grid (recursively places nodes in the middle of their allocated window)
    private void fillGrid(Node node, int level, int left, int right, List<List<String>> rows) {
        if (node == null) return;

        int mid = (left + right) / 2;
        rows.get(level).set(mid, String.valueOf(node.getKey()));

        fillGrid(node.getLeft(), level + 1, left, mid, rows);
        fillGrid(node.getRight(), level + 1, mid + 1, right, rows);
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }
   

    public Node find(Node k) {
        Node tempNode = root;
        
        while (tempNode != null) {
            if (k.getKey() == tempNode.getKey()) {
                return tempNode;
            } 
            else if (k.getKey() < tempNode.getKey()) {
                tempNode = tempNode.getLeft();
            } 
            else {
                tempNode = tempNode.getRight();
            }
        }
        return null;
    }

    
    public Node succ(Node k) {
    	
        Node node = find(k);
        if (node == null) {
        	return null;
        }

        if (node.getRight() != null) {
        	Node tempNode = node.getRight();
            while (tempNode.getLeft() != null) {
                tempNode = tempNode.getLeft();
            }
            return tempNode;
        }

        Node parent = node.getParent();
        while (parent != null && node == parent.getRight()) {
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }
	
	public Node min() {
		Node tempNode = root;
		
		while(tempNode.getLeft() != null) {
			tempNode = tempNode.getLeft();
		}
		
		return tempNode;
	}

	public Node max() {
		Node tempNode = root;
		
		while(tempNode.getRight() != null) {
			tempNode = tempNode.getRight();
		}
		
		return tempNode;
	}
	
	public void printLevelOrder() {
		/* In Java, Queue is an interface, not a class. This means it defines what a queue should do (methods like add, poll, peek), but it does not provide the code for how to store the data.
		 * To create a queue, you must choose a specific implementation (a concrete class that acts as the underlying data structure). Even if LinkedLists allow to access elements in the middle,
		 * Java puts "blinders" on the variable and you won't be able to use something like .get(3)
		 */
		Queue<Node> queue = new LinkedList<>();
		Node myNode;
		
		queue.add(root);

		while (!queue.isEmpty()) {
			myNode = queue.poll();
			System.out.println(myNode.getKey() + " ");
			
			if (myNode.getLeft() != null) {
				queue.add(myNode.getLeft());
			}
			
			if (myNode.getRight() != null) {
				queue.add(myNode.getRight());
			}
		}
	}
	
	// Helper function. Insert a node in a tree (EQUAL CASE does nothing)
	private void insertRecursive(Node current, Node newOne) {
		if (newOne.getKey() < current.getKey()) {
			if (current.getLeft() != null) {
				insertRecursive(current.getLeft(), newOne);
			} else {
				current.setLeft(newOne);
				newOne.setParent(current);
			}
		} else if (newOne.getKey() > current.getKey()) {
			if (current.getRight() != null) {
				insertRecursive(current.getRight(), newOne);
			} else {
				current.setRight(newOne);
				newOne.setParent(current);
			}
		}
	}

	public void merge(SortedBinaryTree myTree2) {		
		for (Node currentNode : myTree2) {
			/* You need to create a copy because the node I will insert has a left() and right() already, and I would be modifying myTree2
			 * A Copy Constructor can help me deal with this.
			 */
			Sensor copyNode = new Sensor((Sensor) currentNode);
			this.insert((Node) copyNode); // Dont use generics! Sol Imran and myo
		}
	}
	
	public void balance() {
        List<Node> nodes = new ArrayList<>();
        for (Node node : this) {
            nodes.add(node);
        }

        this.root = buildBalancedTree(nodes, 0, nodes.size() - 1, null);
    }

    private Node buildBalancedTree(List<Node> nodes, int start, int end, Node parent) {
        if (start <= end) {
	        int middle = (start + end) / 2;
	        Node node = nodes.get(middle);
	
	        node.setParent(parent);
	        node.setLeft(buildBalancedTree(nodes, start, middle - 1, node));
	        node.setRight(buildBalancedTree(nodes, middle + 1, end, node));
	
	        return node;
        }
        return null;
    }
}
