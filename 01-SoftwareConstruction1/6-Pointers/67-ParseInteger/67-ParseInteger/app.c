/*
 * Objective of the program: Write a function toInteger() that converts a string passed as argument in a value of data type int. 
*/

#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>
#include <string.h>
#include <math.h>

int toInteger(char* inputString);

int main(void)
{
	char string[50] = { " " };
	int number;
	int trash;

	printf("Program: insert a non-negative integer, to be processed into the system.\n\n");
	printf("Enter the number: ");

	if (scanf("%s", string) == 0)
	{
		return 1;
	}
	while (((trash = getchar()) != '\n') && (trash != EOF));

	number = toInteger(string);

	printf("x + 1 = %d", number + 1);

	getchar();
	return 0;
}

int toInteger(char* inputString)
{
	int returnValue = 0;
	int size;
	int tempNumber;
	int j;
	
	size = strlen(inputString);		// Remember that strlen() doesnt include the '\0'
	j = size - 1;					// If size = 1, I want my function 'pow(10, 0)' and therefore we start with (size - 1).

	for (int i = 0; i < size; i++)
	{
		// Here I'm operating ASCII values. Therefore a char transofrmed into an integer should be diminished by 48 (ASCII = '0').
		tempNumber = inputString[i] - 48;
		
		returnValue += tempNumber * pow(10, j);

		j--;						// It's true that j will end up in -1 but it won't be used in the last instance.
	}

	return returnValue;
}