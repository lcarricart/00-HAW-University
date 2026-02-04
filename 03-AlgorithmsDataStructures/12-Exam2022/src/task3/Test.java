package task3;

public class Test {
	public static void main(String[] args) {
		int[] testArray = {2, 0, 9, 7, 10};
		
		BalancedSortedBinaryTree.bubbleSort(testArray);
		
		for (int e: testArray) {
			System.out.println(e);
		}
	}
}
