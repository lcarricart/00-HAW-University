/*
 * Objective of the program:  Write a function isEqualArrays() that expects two arrays of same size and returns a logical true, if and only if the corresponding
 * values of both arrays are equal. Else the function shall return false.
*/

#include <stdio.h>

#define ARRAY_SIZE 5

enum Booleans {FALSE = 0, TRUE}; // Remember that enumerations start with the value 1, unless stated differently.

int isEqualArrays(int* array1, int* array2, int size);
void arrayPrinter(int* array, int size);

int main(void)
{
	int a[ARRAY_SIZE] = { 6, 5, 9, 11, 20 };
	int b[ARRAY_SIZE] = { 6, 5, 9, 11, 20 };
	int c[ARRAY_SIZE] = { 6, 7, 9, 11, 20 };

	// Prints the arrays.
	printf("Arrays:");
	printf("\na: ");
	arrayPrinter(a, ARRAY_SIZE);
	printf("\nb: ");
	arrayPrinter(b, ARRAY_SIZE);
	printf("\nc: ");
	arrayPrinter(c, ARRAY_SIZE);

	// Shows if they are equal or not.
	printf("\n\nCompare arrays value by value: \n");

	printf("Is a same as b?: ");
	if (isEqualArrays(a, b, ARRAY_SIZE))
	{
		printf("true\n");
	}
	else
	{
		printf("false\n");
	}

	printf("Is a same as c?: ");
	if (isEqualArrays(a, c, ARRAY_SIZE))
	{
		printf("true\n");
	}
	else
	{
		printf("false\n");
	}

	printf("Is b same as c?: ");
	if (isEqualArrays(b, c, ARRAY_SIZE))
	{
		printf("true\n");
	}
	else
	{
		printf("false\n");
	}

	getchar();
	return 0;
}

void arrayPrinter(int* array, int size)
{
	printf("| ");
	for (int i = 0; i < size; i++)
	{
		printf("%d ", array[i]);
	}
	printf("|");
}

int isEqualArrays(int* array1, int* array2, int size)
{
	int result = TRUE; // Remember this are just numbers. Enummerations only improve readability.

	for (int i = 0; i < size; i++)
	{
		if (array1[i] != array2[i])
		{
			result = FALSE;
		}
	}

	return result;
}