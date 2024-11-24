// Task 1: Print all fields of a chessboard in a 2-dimensional matrix style board.

#include <stdio.h>

int main(void)
{
	short i;						// Vertical variable
	char j;							// Horizontal variable
	short temp;						// Horizontal variable 2

	printf("This is the display of a chess board!\n");

	for (i = 8; i >= 0; i--)
	{
		printf("+");

		for (temp = 1; temp < 9; temp++)
		{
			printf("----+");
		}
		
		printf("\n");

		for (j = 'a'; j < 'i' && i >= 1; j++)		// This extra condition && is to print one more straight line avoiding this for.
		{
			printf("| %c%d ", j, i);
		}

		// I could ideally remove this if, somehow smarter. It avoids the last "|" in the display.
		(i >= 1) ? printf("|\n") : 0;
		//if (i >= 1) {
		//	printf("|\n");
		//}
	}

	return 0;
}