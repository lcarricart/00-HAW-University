// This program calculates the zero-crossings of a function making use of the Bisection Method.

#include <stdio.h>
#include <math.h>

// Defines the function f(X) = X^2 - 2X - 1
double functionF(double x);

// Bisection Method
double bisectionMethod(double reference1, double reference2);

int main(void)
{
	printf("// This program calculates the zero-crossings of a function making use of the Bisection Method //\n\n");
	// This is our first guess, the zero-crossing will be between these two values
	double x1 = 0;
	double x2 = 4;
	double root = -90; // A value out of the range

	root = bisectionMethod(x1, x2);

	if (root == -99)
	{
		printf("There are no zero-crossings between the selected range.");
		getchar();
	}
	else
	{
		printf("The zero of the function is located at %.6lf", root);
		getchar();
	}

	return 0;
}

// Defines the function f(X) = X^2 - 2X - 1
double functionF(double x)
{
	double y = x * x - 2 * x - 1;

	return y;
}

// Bisection Method
double bisectionMethod(double xOne, double xTwo)
{
	double y1 = functionF(xOne);
	double y2 = functionF(xTwo);
	double xCenter = -200;
	double yCenter = -200;

	if (y1 * y2 > 0)
	{
		return -99;
	}

	//If the signs are opposite, then there exists a zero in between
	while ((y1 * y2 < 0) && (fabs(xOne - xTwo) > 1e-6))
	{
		xCenter = (1.0 / 2.0) * (xOne + xTwo);
		yCenter = functionF(xCenter);

		if ((yCenter < 0) && (y1 < 0))
		{
			xOne = xCenter;
		}
		else
		{
			xTwo = xCenter;
		}
	}

	return xCenter;
}