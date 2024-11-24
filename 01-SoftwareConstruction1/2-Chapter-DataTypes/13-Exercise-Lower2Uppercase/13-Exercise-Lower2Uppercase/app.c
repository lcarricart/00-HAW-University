/* Write a program that prompts users to enter a small letter (a -z) and prints the corresponding capital letter (A - Z) to the console. Find a solution that does
* not contain a fixed number to be substracted from small letters in the source code (do not apply the solution using ASCII).
*/

#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>
#include <ctype.h>				// To include the char functions.

int main(void)
{
	char letter = ' ';

	printf("Introduce a letter to be converted into lower or uppercase: ");
	scanf("%c", &letter);		// & indicator is very important.
	getchar();					// This takes the remainder (usually the Enter pressed)

	if (islower(letter))
	{
		letter = toupper(letter);
	}
	else if (isupper(letter))
	{
		letter = tolower(letter);
	}

	printf("Your new letter is %c !", letter);
	getchar();

	return 0;
}