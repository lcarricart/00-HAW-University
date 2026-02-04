// This exercises is inspired on task 3, and is not likely to appear in the exam. However, it is good practice for Java and the subject.

package task3;

public class BalancedSortedBinaryTree {
	Node root;
	
	public BalancedSortedBinaryTree(int[] array) {
		int average = 0;
		int[] arrayNoRoot = new int[array.length - 1];
		
		average = findAverage(array);
		arrayNoRoot = extractRoot(array, average);
		bubbleSort(arrayNoRoot);
	}
	
	private int findAverage(int[] array) {
		int sum = 0;
		
		for (int e : array) {
			sum += e;
		}
		
		return sum / array.length;
	}
	
	private int[] extractRoot(int[] array, int average) {
		int difference;
		int smallestIndex = 0;
		int smallestDifference = 10000; // a big number
		
		for (int i = 0; i < array.length; i++) {
			difference = Math.abs(array[i] - average);
			
			if (difference < smallestDifference) {
				smallestDifference = difference;
				smallestIndex = i;
			}
		}
		this.root = new Node(array[smallestIndex]);
		
		int[] resultingArray = new int[array.length - 1];
		int j = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (i != smallestIndex) {
				resultingArray[j] = array[i];
				j++;
			}
		}
		
		return resultingArray;
	}
	
	public static void bubbleSort(int[] array) {
		int minValue;
		int minIndex;
		
		for (int i = 0; i < array.length; i++) {
			minValue = array[i];
			minIndex = i;
			
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < minValue) {
					minValue = array[j];
					minIndex = j;
				}
			}
			
			swap(array, i, minIndex);
		}
	}
	
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
