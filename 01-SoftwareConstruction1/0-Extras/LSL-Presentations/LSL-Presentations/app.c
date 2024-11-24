#include<stdio.h>

float Partial_Prod_of_Fracts(int, int);

void main()
{
	float y = 0;
	y = Partial_Prod_of_Fracts(2,2);

	printf("The partial product of fractions is %f \n", y);
}

float Partial_Prod_of_Fracts(int from, int to)
{
	float answer = 1;
	int powerOfNumber;

	for (int i = from; i <= to; i++)
	{
		powerOfNumber = (i % 2 == 0) ? -1 : 1;

		answer *= (powerOfNumber * (1 / (float)i));	// Very careful w/ casting.
	}
	return answer;
}