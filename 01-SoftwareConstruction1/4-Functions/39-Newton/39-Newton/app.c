/*
 * Objective of the program: In Exercise 38 we have approximated a zero-crossing of f(x) = x2−2x−1 by the bisection method. Another wide-spread approach is the method by
 Newton1. Starting at a value x0 a zero-crossing is determined iteratively as follows:  xn+1 = xn − (f(xn) / f′(xn)).

 Implement Newton’s method analogous to Exercise 38 in a function newton(). It expects the start value x0, the stop condition ∆x, and the maximum number of iterations as arguments.
 The function ends the iterations and returns the current x value, when the value has changed by less than ∆x in a step (i. e., |xn+1 − xn| < ∆x) or the maximum number of iterations
 has been reached.

 Apply the method for f(x) = x^2 − 2x − 1 with f′(x) = 2x − 2 and the start values x0 = 0 and x0 = 4
*/
#define _CRT_SECURE_NO_DEPRECATE

#include <stdio.h>

double originalFunction(double x);
double derivativeFunction(double x);
double newton(double startValue, double precision, int iterations);

int main(void)
{
	double rootGuess = -999;
	double precision = 0;
	int iterations = 20;
	double approxRoot = -999;
	char trash;

	printf("Function of the program: Approximate the zero-crossings of f(x) = x^2 - 2x - 1 using Newton's method and given parameters introduced by the user:\n- Initial guess\n- Precision\n\n");

	printf("Introduce your first guess for the value of the root: ");
	if (scanf("%lf", &rootGuess) != 1)
		return 1;
	while (((trash = getchar()) != '\n') && (trash != EOF));

	printf("Introduce the desired precision (stop condition): ");
	if (scanf("%lf", &precision) != 1)
		return 1;
	while (((trash = getchar()) != '\n') && (trash != EOF));

	approxRoot = newton(rootGuess, precision, iterations);

	printf("\nApproximated x0: %.9lf", approxRoot);
	printf("\nApproximated f(x0): %.9lf", originalFunction(approxRoot));

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

double newton(double startValue, double precision, int iterations)
{
	double root;
	double nextValue = startValue;
	double temp;
	int i = 0;

	do
	{
		temp = nextValue;
		nextValue = temp - (originalFunction(temp) / derivativeFunction(temp));
		i++;
	} while ((fabs(nextValue - temp) > precision) && (i <= iterations));

	return root = nextValue;
}