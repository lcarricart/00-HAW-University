#include <stdio.h>

// Prints all the locations stored into the array
void arrayPrinter(double* array, int rows, int cols)
{
	printf("After reading .txt file, the content of the array is:\n");

	for (int i = 0; i < rows; i++)
	{
		printf("{");

		for (int j = 0; j < cols; j++)
		{
			printf(" %lf ", *((array + i * cols) + j));
			// Same behavior as *(array + (i * cols + j))
		}
		printf("}\n");
	}

	printf("\n");
}