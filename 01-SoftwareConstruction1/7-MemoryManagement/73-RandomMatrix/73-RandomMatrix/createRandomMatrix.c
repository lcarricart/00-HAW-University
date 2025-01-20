/* Include Files */
#include <stdlib.h>

/* Allocates a 2-D int array and initializes it with random numbers
*
* @param rows amount of rows for the matrix
* @param columns amount of columns for the matrix
* @param min minimum value of the random generation
* @param max maximum value of the random generation
* @return (retun variable/statement) (description)
*/
int** createRandomMatrix(int rows, int columns, int min, int max)
{
	// Variable Definition
	int** randMatrix;
	int* data;

	// Dynamic Memory Allocation: create int** randMatrix
	randMatrix = (int**)malloc(rows * sizeof(int*) + rows * columns * sizeof(int));
	if (randMatrix == NULL)
	{
		perror("Failed memory allocation for randMatrix");
		exit(EXIT_FAILURE);
	}

	// Create int* data
	data = (int*)(randMatrix + rows);

	// Connect the pointers to the data
	for (int i = 0; i < rows; i++)
	{
		randMatrix[i] = data + i * columns;
	}

	// Initialize Matrix
	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < columns; j++)
		{
			// I can access the memory as: 1) pointer or 2) pointer to pointer. I choose the second way.
			randMatrix[i][j] = min + rand() % (max - min + 1);
		}
	}

	return randMatrix;
}