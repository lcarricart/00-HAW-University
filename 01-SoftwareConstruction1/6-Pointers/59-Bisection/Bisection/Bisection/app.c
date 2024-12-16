// This program is a variation of 38-BisectionMethod, calculating thee zero-crossings of a function using pointers.


#include <stdio.h>
#include <math.h>

// Defines the function f(X) = X^2 - 2X - 1
double functionF(double x);

// Bisection Method
double bisectionMethod(double* xOne, double* xTwo, double precisioValue);

int main(void)
{
	printf("// This program calculates the zero-crossings of a function making use of the Bisection Method //\n\n");
	// This is our first guess, the zero-crossing will be between these two values
	double x1 = 0;
	double x2 = 4;
	double root = -90; // A value out of the range
	double precisionValue = 1e-6;

	double* pointerX1 = &x1;
	double* pointerX2 = &x2;

	root = bisectionMethod(pointerX1, pointerX2, precisionValue);

	if (root == -99)
	{
		printf("There are no zero-crossings between the selected range.\n\n");
		getchar();
	}
	else
	{
		printf("Zero crossing for f(x) = X^2 - 2X - 1 by bisection method:\n");
		printf("True interval size: %.13lf\n", precisionValue);
		printf("Stop interval size: %.13lf\n", fabs(x1 - x2));
		printf("Lower limit x0: %.13lf\n", x1);
		printf("Approximated x0: %.13lf\n", root);
		printf("Upper limit x0: %.13lf\n", x2);
		printf("Approximated f(x0): %.13lf\n\n", functionF(root));

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
double bisectionMethod(double* xOne, double* xTwo, double precision)
{
	double y1 = functionF(*xOne);
	double y2 = functionF(*xTwo);
	double xCenter = -200;
	double yCenter = -200;

	if ((y1 * y2) > 0)
	{
		return -99;
	}

	//If the signs are opposite, then there exists a zero in between
	while (((y1 * y2) < 0) && (fabs(*xOne - *xTwo) > precision))
	{
		xCenter = (1.0 / 2.0) * (*xOne + *xTwo);
		yCenter = functionF(xCenter);

		if ((yCenter < 0) && (y1 < 0))
		{
			*xOne = xCenter;
		}
		else
		{
			*xTwo = xCenter;
		}
	}

	return xCenter;
}