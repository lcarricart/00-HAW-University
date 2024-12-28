/*
 * Objective of the program: Write a function that determines the number of vocals, consonants, and digits in a string passed
 * as argument. Do this by running through the string using a pointer. 
*/

#include <stdio.h>
#include <ctype.h>
#include <string.h>

void stringAnalyzer(char* inputString, int size, int* numVocals, int* numConsonants, int* numDigits);

int main(void)
{
	char* string = "1, 2 oder 3 - du musst dich entscheiden, drei Felder sind frei !";
	/* Defining the string in this fashion I can't modify it since its store in ROM but I allocate just the amount of characters it needs.
	 * Else, I would have higher complexity determening the size of the string. 
	*/
	int stringSize = 0;
	int vocals = 0;
	int consonants = 0;
	int digits = 0;

	/* 
	 * stringSize = sizeof(string) / sizeof(char); 
	 * This is just a formality, since sizeof(char) = 1.
	 * 
	 * This line of code does't work in this case because we declared our variable as a pointer, not as a string. Therefore sizeof() returns the size of the pointer.
	 * In order to get the size of our string, we then need the library 'string.h' and understand how does this work.
	 * strlen() returns the size of the string without including the null terminator. Therefore, sizeof(stringLiteral) = strlen(stringPointer) + 1;
	*/ 

	stringSize = strlen(string) + 1;

	stringAnalyzer(string, stringSize, &vocals, &consonants, &digits);

	printf("String: %s\n", string);
	printf("Vocals: %d\n", vocals);
	printf("Consonants: %d\n", consonants);
	printf("Digits: %d\n", digits);

	getchar();
	return 0;
}

void stringAnalyzer(char* inputString, int size, int* numVocals, int* numConsonants, int* numDigits)
{
	char c = ' ';

	for (int i = 0; i < size; i++)
	{
		c = *(inputString + i);
		if (isalpha(c))
		{
			if ((c != 'a') && (c != 'e') && (c != 'i') && (c != 'o') && (c != 'u'))
			{
				*(numConsonants) += 1;
			}
			else
			{
				*(numVocals) += 1;
			}
		}
		else if (isdigit(c))
		{
			*(numDigits) += 1;
		}
	}
}