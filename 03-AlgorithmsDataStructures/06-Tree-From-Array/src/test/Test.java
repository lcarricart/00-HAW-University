/* The following tree will be created
 * 
 * 									1
 * 						L:2			|				R:3
 * 				L:9		|		R:8			L:66		|		R:20
 * 			L:1	|	R:2		L:9	|	R:7		|			L:10	|			 
 * 							
 */

package test;

public class Test {
	public static void main(String[] args) {		
		System.out.println("A tree has been created based on the internal template!");
		Tree myTree = new Tree(1);
		
		myTree.getRoot().setLeft(2).setLeft(9).setLeft(1);
		myTree.getRoot().getLeft().getLeft().setRight(2);
		
		myTree.getRoot().getLeft().setRight(8).setLeft(9);
		myTree.getRoot().getLeft().getRight().setRight(7);
		
		myTree.getRoot().setRight(3).setRight(20).setLeft(10);
		myTree.getRoot().getRight().setLeft(66);
		
		myTree.print();
	}
}
