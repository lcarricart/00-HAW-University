/*******************************************************************************************************************
 * Objective of the program: Write a function createRandomArray() that allocates an int array and initializes it
   with random numbers:
		▶ Users are prompted in main() to enter the number of elements and the minimal and maximal allowed random values.
		▶ Implement createRandomArray() and main() in different source files.
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

/* Pre-definitions */
#define _CRT_SECURE_NO_DEPRECATE

/* Include files */
#include <stdio.h>
#include <stdlib.h>

/* Prototypes */
extern int* createRandomArray(int amountElements, int minValue, int maxValue);

/* Main function */
int main(void)
{
	// Variable Definition
	int numElements, minimumValue, maximumValue;
	int trash;
	int* randArray;
	
	// Program Description
	printf("Program description: create a randomly initialized array based on user input such as: \n- Number of elements \n- Minimum posible random numnber \n- Maximum possible random number\n\n");

	// User Input
	printf("Enter the array size and data range (with spaces: \"size min max\"): ");
	if (scanf("%d %d %d", &numElements, &minimumValue, &maximumValue) != 3)
	{
		perror("User input unsuccessful");
		exit(EXIT_FAILURE);
	}
	while ((trash = getchar()) != '\n');

	// Create Random Array
	randArray = createRandomArray(numElements, minimumValue, maximumValue);

	// Print Result
	printf("Random Array: [ ");
	for (int i = 0; i < numElements; i++)
	{
		printf("%d ", randArray[i]);
	}
	printf("]\n");

	// Free Allocated Memory
	free(randArray);

	getchar();
	return 0;
}