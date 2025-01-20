/*
 * Objective of the program:  In Exercise 39 on page 18 we have approximated a zero-crossing of f(x) = x2−2x−1 using Newton’s method. Modify your solution
 so that the function newton() receives the number N of iterations instead of the stopping condition ∆x, and returns an array containing the approximations
 x1, x2, . . ., xN. 
*/
#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double originalFunction(double x);
double derivativeFunction(double x);
void newton(double startValue, double precision, int iterations, double* roots);

int main(void)
{
	double rootGuess = -999;
	double precision = 0.0000000001;
	int iterations;
	int trash;

	printf("Function of the program: Approximate the zero-crossings of f(x) = x^2 - 2x - 1 using Newton's method and given \nparameters introduced by the user: \n- Initial guess \n- Number of iterations \n\n");

	printf("Introduce your first guess for the value of the root: ");
	if (scanf("%lf", &rootGuess) != 1)
		return 1;
	while (((trash = getchar()) != '\n') && (trash != EOF));

	printf("Introduce the desired amount of iterations: ");
	if (scanf("%d", &iterations) != 1)
		return 1;
	while (((trash = getchar()) != '\n') && (trash != EOF));

	if (iterations <= 0)
	{
		printf("\nInvalid number of iterations :(");
		return 0;
	}

	// I create an initialized array.
	double* rootsArray = (double*)calloc(iterations, sizeof(double));

	newton(rootGuess, precision, iterations, rootsArray);

	for (int i = 0; i < iterations; i++)
	{
		printf("\nx_%d = %.9lf", i, *(rootsArray + i));
	}

	free(rootsArray);

	getchar();
	return 0;
}

double originalFunction(double x)
{
	double y;
	y = (x * x) - (2 * x) - 1;
	return y;
}

double derivativeFunction(double x)
{
	double y;
	y = (2 * x) - 1;
	return y;
}

void newton(double startValue, double precision, int iterations, double* roots)
{
	double nextValue = startValue;
	double temp;
	int i = 0;

	do
	{
		temp = nextValue;			// I could eliminate this variable but it would compromise readability.
		nextValue = temp - (originalFunction(temp) / derivativeFunction(temp));

		*(roots + i) = nextValue;
		i++;
	} while ((fabs(nextValue - temp) > precision) && (i < iterations));
}

/*
 * Key take-homes:
 *		- I was calling calloc() without including <stdlib.h>!!!!
 *		- I was calling fabs() without <math.h>!!!!
*/