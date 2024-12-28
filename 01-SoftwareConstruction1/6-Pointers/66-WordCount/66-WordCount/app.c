/*
 * Objective of the program:  Write a function numberWords() that determines the number of words (i. e., character sequences
 * divided by blank spaces) in a string passed as argument. Verify the function using strings entered by users.  
*/

#define _CRT_SECURE_NO_DEPRECATE

#include <stdio.h>
#include <string.h>

#define MAX_SIZE 100

int numberOfWords(char* string);

int main(void)
{
	char inputString[MAX_SIZE] = { " " };
	int wordCounter = 0;
	int trash;

	printf("Welcome to the program 66 of SO1. I determine the number of words in a string!\n\n");
	printf("Enter text: ");
	/* scanf("%s", inputString);
	 * This way of scanning doesn't help for this exercise, since scanf() will stop at any kinda whitespace. Instead we have two alternatives:
	 * 
	 * 1) Use scanf("%[^\n]") to take all characters up until the newline. [^\n] is called a 'scanset' and behaves as a string format specifier
	 * (strings are scansets terminating with \0 --> [^\0]. With this we are just changing what is our ending character).
	 * You often need to clear any leftover newline in the buffer before using this, using while (((trash = getchar()) != '\n') && (trash != EOF)).
	 * 
	 * 2) Use fgets(inputString, MAX_SIZE, stdin). The third parameter is the stream from which to read. 'stdin' typically means keyboard input.
	 * fgets reads characters until one of these happens:
	 *		- A newline ('\n') is read.
	 *		- MAX_SIZE - 1 characters are read.
	 *		- End Of File (EOF) is encountered.
	 * When fgets encounters a newline ('\n'), it includes that newline in the string (unless the buffer is too small).
	 * It then places a '\0' (null terminator) at the end of the string to mark its end in memory.
	 * You should also clean the buffer after using it if your input was bigger than the buffer size.
	*/
	while (((trash = getchar()) != '\n') && (trash != EOF));

	wordCounter = numberOfWords(inputString);

	printf("\nNumber of words: %d", wordCounter);

	getchar();
	return 0;
}

int numberOfWords(char* string)
{
	int i = 0;
	int blankCounter = 0;
	char c = string[i];

	while (c != '\0')
	{
		if (c == ' ')
		{
			blankCounter++;
		}

		i++;
		c = string[i];
	}

	return (blankCounter + 1);
}