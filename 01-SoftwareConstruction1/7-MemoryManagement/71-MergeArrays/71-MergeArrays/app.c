/*******************************************************************************************************************
 * Objective of the program:  Write a function mergeArraysSorted() that receives two arrays, merges them to one, and
   returns the newly created array. The elements of the arrays passed as arguments to the function are sorted in 
   ascending order in the merged array. 
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

/* Include files */
#include <stdio.h>
#include <stdlib.h> // for malloc(), exit(), and perror()

/* Prototypes */
int* mergeArraySorted(int* array1, int* array2, int size1, int size2);

/* Main function */
int main(void)
{
	// Variable Definition
	const int arrayOne[] = { 2, 3, 3, 5, 7, 8 };
	const int arrayTwo[] = { 1, 2, 4, 7, 9 };
	int* mergedArray;
	int sizeArray1, sizeArray2, sizeMerged;

	// Program Description
	printf("Program description: I receive two unordered arrays of integers and create a new array where the elements are sorted in ascending order.\n\n");

	// Determine arrayOne and arrayTwo sizes
	sizeArray1 = sizeof(arrayOne) / sizeof(int);
	sizeArray2 = sizeof(arrayTwo) / sizeof(int);
	sizeMerged = sizeArray1 + sizeArray2;

	// Create merged array
	mergedArray = mergeArraySorted(arrayOne, arrayTwo, sizeArray1, sizeArray2);

	// Print array1
	printf("Array 1: [ ");
	for (int i = 0; i < sizeArray1; i++)
	{
		printf("%d ", arrayOne[i]);
	}
	printf("]\n");

	// Print array2
	printf("Array 2: [ ");
	for (int i = 0; i < sizeArray2; i++)
	{
		printf("%d ", arrayTwo[i]);
	}
	printf("]\n");

	/* Print result
	* 
	* It was enlightening to see how the size of this array is lost after passing it to main(). Therefore various solutions can be applied, among:
	*	- Create a variable "sizeFinalArray" in advance and change its value from inside the function.
	*	- Return a structure containing both the array and its size.
	*/
	printf("Merged:  [ ");
	for (int i = 0; i < sizeMerged; i++)
	{
		printf("%d ", mergedArray[i]);
	}
	printf("]\n");

	// Free allocated memory
	free(mergedArray);

	getchar();
	return 0;
}

/* Receive two arrays of integers and merges them while sorting them in ascending order.
*
* @param array1 first array of integers
* @param array2 second array of integers
* @param size1 size of the first array
* @param size2 size of the second array
* @return merged array sorted in ascending order
*/
int* mergeArraySorted(int* array1, int* array2, int size1, int size2)
{
	// Variable Definition
	int* jointArray;
	int temp;
	int j = 0;

	// Dynamic memory allocation
	jointArray = (int*)calloc(size1 + size2, sizeof(int));
	if (jointArray == NULL)
	{
		perror("Failed to allocate jointArray");
		exit(EXIT_FAILURE);
	}

	// Initialize jointArray
	for (int i = 0; i < size1; i++)
	{
		jointArray[i] = array1[i];
	}
	for (int i = size1; i < size1 + size2; i++)
	{
		jointArray[i] = array2[j];
		j++;
	}

	// Sort the elements in ascending order
	for (int i = 0; i < size1 + size2; i++)
	{
		for (j = i + 1; j < size1 + size2; j++)
		{
			if (jointArray[i] > jointArray[j])
			{
				// Exchange jointArray[i] <=> jointArray[j]
				temp = jointArray[i];
				jointArray[i] = jointArray[j];
				jointArray[j] = temp;
			}
		}
	}

	return jointArray;
}