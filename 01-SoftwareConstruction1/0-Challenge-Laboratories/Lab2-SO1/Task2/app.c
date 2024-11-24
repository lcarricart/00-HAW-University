/*  Task 2: Write a table that prints :
* 
*	a) Sequential numbering of the chessboard fields.
*   b) Number of grains on the specific field.
*   c) Sum of grain on all fields up to the specific field.
*/

#include <stdio.h>

int main(void)
{
	short field;
	unsigned long long int onField = 1;							// Failing to use "unsigned" would drive us out of scope.
	unsigned long long int  sum = 0;
	short charLenght = 0;										// Used to store the size of different printf's.
	
	short charField = printf("Field |") - 1;					// -1 to avoid the "|"
	short charOnField = printf(" On field %11s", "|") - 1;		// -1 to avoid the "|"
	short charSum = printf(" Sum %29s", "\n") - 1;				// -1 to avoid the "\n"
	// Improve this line of code.

	// I think I need an array in order to automate this.
	// !! Think further how to automate this while loops properly. Automation every 8 displays (every line of the chess board)

	// Hereby I will approach the numeric solution, without format
	for (field = 1; field < 65; field++)
	{
		if (field == 1 || ((field - 1) % 8 == 0))				// This (field - 1) allows me to print the eight row first, and the the divinding line.
		{
			charLenght = charField;
			while (charLenght-- > 0)
			{
				printf("-");
			}
			printf("+");

			charLenght = charOnField;
			while (charLenght-- > 0)
			{
				printf("-");
			}
			printf("+");

			charLenght = charSum;
			while (charLenght-- > 0)
			{
				printf("-");
			}
			printf("\n");
		}

		sum += onField;
		
		printf("%6d|", field);
		printf("%20.0llu|", onField);
		printf("%21.0llu (= %.1e)", sum, (double)sum);				// %e is only valid for float numbers, therefore casting is necessary.

		onField *= 2;
		
		printf("\n");
	}

	// The code below is highly inefficient but would be solved using functions.
	charLenght = charField;
	while (charLenght-- > 0)
	{
		printf("-");
	}
	printf("+");

	charLenght = charOnField;
	while (charLenght-- > 0)
	{
		printf("-");
	}
	printf("+");

	charLenght = charSum;
	while (charLenght-- > 0)
	{
		printf("-");
	}
	printf("\n");

	return 0;
}