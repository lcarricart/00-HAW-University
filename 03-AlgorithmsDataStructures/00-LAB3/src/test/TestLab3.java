package test;

/* This generics exercise makes no sense. The "correct" implementations don't really make proper use of generics.
 * The UML SortedBinaryTree<E> class description provided in the Laboratory Task makes sense but does not use the 
 * E type at any point; therefore, E is unnecessary.
 */
public class TestLab3 {
	public TestLab3() {
		init();
	}
	
	private void init() {
		// Define points for a tree1
		Sensor point1 = new Sensor("Root", 8);
		Sensor point2 = new Sensor("A", 10);
		Sensor point3 = new Sensor("B", 3);
		Sensor point4 = new Sensor("C", 1);
		Sensor point5 = new Sensor("D", 6);
		Sensor point6 = new Sensor("E", 9);
		Sensor point7 = new Sensor("F", 7);
		Sensor point8 = new Sensor("G", 14);
		Sensor point9 = new Sensor("G", 80);
		
		// Define the points of Tree2
		Sensor point10 = new Sensor("Root", 80);
		Sensor point11 = new Sensor("A", 100);
		Sensor point12 = new Sensor("B", 30);
		Sensor point13 = new Sensor("C", 10);
		Sensor point14 = new Sensor("D", 60);
		Sensor point15 = new Sensor("E", 90);
		Sensor point16 = new Sensor("F", 70);
		Sensor point17 = new Sensor("G", 140);
		
		// Define the tree using the root as initializer
		SortedBinaryTree myTree1 = new SortedBinaryTree(point1);
		SortedBinaryTree myTree2 = new SortedBinaryTree(point10);
		
		// Insert points (Nodes) to the tree 1
		myTree1.insert(point2);
		myTree1.insert(point3);
		myTree1.insert(point4);
		myTree1.insert(point5);
		myTree1.insert(point6);
		myTree1.insert(point7);
		myTree1.insert(point8);
		myTree1.insert(point9);
		
		// Insert points (Nodes) to the tree 2
		myTree2.insert(point11);
		myTree2.insert(point12);
		myTree2.insert(point13);
		myTree2.insert(point14);
		myTree2.insert(point15);
		myTree2.insert(point16);
		myTree2.insert(point17);
		
		//myTree.printLevelOrder();
		System.out.println("[Iterator Visualization]");
		System.out.print("Tree1: ");
		// Print the values using an iterator (in-order printing)
		for (Node s : myTree1) {
			System.out.print(s.getKey() + " ");
		}
		
		System.out.print("\nTree2: ");
		for (Node s : myTree2) {
			System.out.print(s.getKey() + " ");
		}
		
//		// Print the raw tree in a visually attractive way
//		myTree1.printGrid();
//		
//		// Print Test Results
//		printTestResults(myTree1);
//        
//        // Test methods for completeness
//        testSucc(myTree1, 6);  // Expected 7
//        testSucc(myTree1, 8);  // Expected 9
//        testSucc(myTree1, 9);  // Expected 10
//        testSucc(myTree1, 14); // Expected null (is max)
//        
//        // Merge Tree2 inside Tree1
//        myTree1.merge(myTree2);
//        
//        myTree1.printGrid();
        
        System.out.println("\n\n[Merged (Unbalanced) Tree Grid]");
        myTree1.merge(myTree2);
        myTree1.printGrid();
        
        System.out.println("[Balancing tree...]");
        myTree1.balance();
        
        System.out.println("\n[Merged (Balanced) Tree Grid]");
        myTree1.printGrid();
	}
	
	// Helper for printing successor tests clearly
    private void testSucc(SortedBinaryTree tree, int key) {
    	Sensor input = new Sensor("temp", key);
        Sensor s = (Sensor) tree.succ(input);
        
        if (s == null) {
        	System.out.println("SUCC(" + key + "): " + "null");
        } else {
        	System.out.println("SUCC(" + key + "): " + s.getKey());
        }
    }
    
	// Print test results to verify that all relevant methods in SortedBinaryTree are working as expected
    private void printTestResults(SortedBinaryTree myTree1) {
        System.out.println("\n--- TEST RESULTS ---");
        
        Sensor minNode = (Sensor) myTree1.min();
        Sensor maxNode = (Sensor) myTree1.max();
        
        if (minNode == null) {
        	System.out.println("MIN Value: " + "null" + " (Expected: 1)");
        } else {
        	System.out.println("MIN Value: " + minNode.getKey() + " (Expected: 1)");
        }
        
        if (maxNode == null) {
        	System.out.println("MAX Value: " + "null" + " (Expected: 14)");
        } else {
        	System.out.println("MAX Value: " + maxNode.getKey() + " (Expected: 14)");
        }

        int searchKey = 6;
        int missingKey = 99;
        Sensor foundNode = (Sensor) myTree1.find(new Sensor("dummy", searchKey));
        Sensor missingNode = (Sensor) myTree1.find(new Sensor("dummy", missingKey));
        
        if (foundNode == null) {
        	System.out.println("FIND(" + searchKey + "): " + "Not Found");
        } else {
        	System.out.println("FIND(" + searchKey + "): " + "Found Node with Key " + foundNode.getKey());
        }

        if (missingNode == null) {
        	System.out.println("FIND(" + missingKey + "): " + "Correctly returned null");
        } else {
        	System.out.println("FIND(" + missingKey + "): " + "Found " + missingNode.getKey());
        }
    }
    
    public static void main(String[] args) {	
		new TestLab3();
	}
}
