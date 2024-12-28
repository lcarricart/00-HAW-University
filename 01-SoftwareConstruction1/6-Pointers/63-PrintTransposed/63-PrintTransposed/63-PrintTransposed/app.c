/*
* Objetctive of the program: Write a function that receives a matrix A ∈ Z_M×N and prints the corresponding transposed matrix A_T to the console. Pass A as pointer
* to an one-dimensional array of data type int to the function. 
* 
* Since we haven't yet covered memory allocation, I must establish fixed values for the matrix, and therefore it doesn't make sense to code user input.
*/

#include <stdio.h>

// The function understands my matrix as an array, even though it is a matrix, because it only receives the address.
void transposedMatrix(const int* rawMatrix, int* resultMatrix, int rows, int columns);

// The input of rows and columns gets inverted inside the function. rows --> columns.
void printTransposed(const int* matrixTransposed, int columns, int rows);

// Print the original matrix in its regular format of columns and rows.
void printOriginal(const int* originalMatrix, int rows, int columns);

int main(void)
{
	int matrix[5][2] = 
	{ {1, 2},
	  {3, 4},
	  {5, 6},
	  {7, 8},
	  {9, 10},
	};
	int matrixTransposed[2][5] = { 0 };
	int rows, columns;
	
	rows = sizeof(matrix) / sizeof(*matrix);
	columns = sizeof(*matrix) / sizeof(int);

	transposedMatrix(matrix, matrixTransposed, rows, columns);

	printf("Original Matrix:\n");
	printOriginal(matrix, rows, columns);

	printf("\nMatrix Transposed:\n");
	printTransposed(matrixTransposed, rows, columns);

	return 0;
}

// The function understands my matrix as an array, even though it is a matrix, because it only receives the address.
void transposedMatrix(const int* rawMatrix, int* resultMatrix, int rows, int columns)
{
	// The exercise requires me to manipulate the data as a one dimensional array.

	// I define this variables only to make it clear for external readers.
	int rowsT = columns;
	int columnsT = rows;

	for (int i = 0; i < rowsT; i++)
	{
		for (int j = 0; j < columnsT; j++)
		{
			resultMatrix[i * columnsT + j] = rawMatrix[j * columns + i];
		}
	}
}

// The input of rows and columns gets inverted inside the function. rows --> columns.
void printTransposed(const int* matrixTransposed, int columns, int rows)
{
	for (int i = 0; i < rows; i++)
	{
		printf("| ");
		for (int j = 0; j < columns; j++)
		{
			printf("%d ", matrixTransposed[i * columns + j]);
		}
		printf("|\n");
	}
}

void printOriginal(const int* originalMatrix, int rows, int columns)
{
	for (int i = 0; i < rows; i++)
	{
		printf("| ");
		for (int j = 0; j < columns; j++)
		{
			printf("%d ", originalMatrix[i * columns + j]);
		}
		printf("|\n");
	}
}

// Key take-homes:
// - The double pointer manipulation is only using 'malloc' and allocating all at once in memory.