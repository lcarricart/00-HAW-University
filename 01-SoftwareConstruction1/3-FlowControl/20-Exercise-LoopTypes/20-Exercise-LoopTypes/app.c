/* Calculate the sum of the numbers from 1 to 100 using a do/while loop */

#include <stdio.h>

int main(void)
{
	int answer = 0;
	short temp = 1;

	do
	{
		answer += temp;
		temp++;
	} while (temp <= 100);

	printf("The sum of the numbers from 1 to 100 results in %d", answer);
	getchar();

	return 0;
}