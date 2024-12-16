// Objective of the program: Write a program that calculates a matrix-vector multiplication and prints the result to the console.
// The example case proposes a 3x3 matrix.

#include <stdio.h>

int main(void)
{
	int a[3][3] =
	{
		{1, 2, 0},
		{0, 2, 1},
		{3, 0, 1}
	};
	int x[3] = { 2, 3, 1 };
	int y[3] = {0};
	int i = 0;

	y[0] = (a[0][0] * x[0]) + (a[0][1] * x[1]) + (a[0][2] * x[2]);
	y[1] = (a[1][0] * x[0]) + (a[1][1] * x[1]) + (a[1][2] * x[2]);
	y[2] = (a[2][0] * x[0]) + (a[2][1] * x[1]) + (a[2][2] * x[2]);

	printf("Matrix A: \n");

	for (i = 0; i < 3; i++)
	{
		printf("| ");
		for (int j = 0; j < 3; j++)
		{
			printf("%d ", a[i][j]);
		}
		printf("|\n");
	}

	printf("\nVector x:\n");

	for (i = 0; i < 3; i++)
	{
		printf("| %d |\n", x[i]);
	}

	printf("\ny = A * x \n\nSolution Vector y: \n");

	for (i = 0; i < 3; i++)
	{
		printf("| %d |\n", y[i]);
	}

	getchar();

	return 0;
}