/*******************************************************************************************************************
 * Objective of the program:  Write a function createRandomMatrix() that allocates a 2-D int array and initializes
   it with random numbers:
		▶ Users are prompted in main() to enter the number of rows and columns as well as the minimal and maximal 
		  allowed random values.
		▶ Implement createRandomMatrix() and main() in different source files.
	    ▶ The function createRandomMatrix() shall call malloc() only once, allocating memory for pointers to the 
		  rows as well as the values stored in the matrix. Initialize pointers to the rows appropriately. 
   
   Motivation: creating a 2D array with only one call of malloc() allows you to manipulate the array[i][j] and also
   allocating memory in a contiguous chunk. This has practical applications.
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
extern int** createRandomMatrix(int rows, int columns, int min, int max);

/* Main function */
int main(void)
{
	// Variable Definition
	int rows, columns;
	int minimum, maximum;
	int trash;
	int** randomMatrix;

	// Program Description
	printf("Program description: allocates a 2-D int array and initializes it with random numbers, following the parameters introduced by the user\n\n");

	// User Input
	printf("Enter matrix size and data range (with spaces: \"rows columns min max\"): ");
	if (scanf("%d %d %d %d", &rows, &columns, &minimum, &maximum) != 4)
	{
		perror("Unsuccessful user input");
		exit(EXIT_FAILURE);
	}
	while ((trash = getchar()) != '\n');

	// Create Random Matrix. The result I get is a flattened array (it lost sense of its dimensions).
	randomMatrix = createRandomMatrix(rows, columns, minimum, maximum);

	// Print Result
	printf("Random Matrix:\n");
	for (int i = 0; i < rows; i++)
	{
		printf("[ ");
		for (int j = 0; j < columns; j++)
		{
			printf("%d ", randomMatrix[i][j]);
		}
		printf("]\n");
	}

	// Free Allocated Memoery
	free(randomMatrix);

	getchar();
	return 0;
}