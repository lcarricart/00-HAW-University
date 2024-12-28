/*
 * Objective of the program: Write a program that prints the number of occurrences of small letters, capital letters, digits, and
 * other characters in a given string to the console. 
 */

#include <stdio.h>
#include <ctype.h>

int main(void)
{
	char sentence[100] = { "Es war eine Mutter, die hatte 4 Kinder:\nden Fruehling, den Sommer, den Herbst und Klaus-Guenter." };
	/* I could also define the string like 'char* sentence = "Hello";' but this comes with the implication that the compiler will store our string in a Read - only - memory,
	 * and therefore we won't be able to modify it.
	*/
	int smallLetters = 0;
	int capitalLetters = 0;
	int digits = 0;
	int otherSymbols = 0;
	char c = sentence[0];
	int i = 0;

	while (c != '\0')
	{
		if (isalnum(c))
		{
			if (islower(c))
			{
				smallLetters++;
			}
			else if (isupper(c))
			{
				capitalLetters++;
			}
			else // It must be a digit.
			{
				digits++;
			}
		}
		else
		{
			otherSymbols++;
		}

		i++;
		c = sentence[i];
	}

	printf("\"%s\"\n\n", sentence);
	printf("Small letters: %d\n", smallLetters);
	printf("Capital letters: %d\n", capitalLetters);
	printf("Digits: %d\n", digits);
	printf("Other symbols: %d\n", otherSymbols);

	getchar();
	return 0;
}