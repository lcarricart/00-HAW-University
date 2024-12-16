/*  Write a program that reads a single character from the keyboard and prints to the console, whether
 the character entered is a digit, small letter, capital letter, or neither a digit nor a letter.*/

#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>
#include <ctype.h>			// For islower(), isupper() functions.
#include <string.h>			// To operate arrays of characters, working as strings.

int main(void)
{
	char variable = ' ';
    char answer[50] = { ' ' };	// C language does not include a data type called "string" as C++ does. Therefore, I declare an array of characters

	printf("Introduce a character, and our program will inform you the kind of character received.\n");
	printf("Input = ");
	scanf("%c", &variable);
	getchar();
	printf("\n");

	if (isdigit(variable))
	{
		strcpy(answer, "Your input is indeed a digit!");
	}
	else if (islower(variable))
	{
		strcpy(answer, "Your input is indeed a lower case character!");
	}
	else if (isupper(variable))
	{
		strcpy(answer, "Your input is indeed an upper case character");
	}
	else
	{
		strcpy(answer, "Your input is neither a digit, nor a letter :(");
	}
	
	printf(answer);
	getchar();

	return 0;
}