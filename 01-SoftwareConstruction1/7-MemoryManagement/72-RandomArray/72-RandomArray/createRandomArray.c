/* Include files */
#include <stdlib.h>

/* Allocates an int array and initializes it with random numbers
*
* @param amountElements amount of elements contained in the array
* @param minValue maximum value of the random generation
* @param maxValue minimum value of the random generation
* @return pointer to an array of size "amountElements", randomly initialized
*/
int* createRandomArray(int amountElements, int minValue, int maxValue)
{
	// Variable Definition
	int* randomArray;

	// Dynamic Memory Allocation
	randomArray = (int*)calloc(amountElements, sizeof(int));
	if (randomArray == NULL)
	{
		perror("Memory allocation for randomArray failed");
		exit(EXIT_FAILURE);
	}

	for (int i = 0; i < amountElements; i++)
	{
		// Stablish minValue as the offset, and limit the result to the range [minValue, maxValue]
		randomArray[i] = minValue + rand() % (maxValue - minValue + 1);
	}

	return randomArray;
}