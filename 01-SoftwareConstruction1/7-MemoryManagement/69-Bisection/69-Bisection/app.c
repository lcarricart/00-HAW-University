/*******************************************************************************************************************
 * Objective of the program: In Exercise 38 on page 18 we have approximated a zero-crossing of f(x) = x^2 − 2x − 1 
   using the bisection method. Modify your solution so that the function bisection() returns a N × 2 matrix, where 
   each row contains the left and right borders xl and xr of an iteration step. 
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

/* Include files */
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/* Prototypes */
double f(double x);
double** bisectionMethod(double reference1, double reference2, double delta, int* numSteps);

/* Main function */
int main(void)
{
	// This is our first guess, the zero-crossing will be between these two values
	double x1 = 0;
	double x2 = 4;
	double delta = 1e-6;
	double** xLimits;
	int numberSteps;

	// Program description
	printf("Program description: calculating the zero-crossings of f(x) = x^2 - 2x - 1 making use of the Bisection Method. \n\n");

	xLimits = bisectionMethod(x1, x2, delta, &numberSteps);

	// Matrix not allocated correctly
	if (xLimits == NULL)
	{
		printf("An issue occurred while allocating space for the matrix.");
	}
	// No zero-crossings
	else if ((xLimits[0][0] == -99) && (xLimits[0][1] == -99))
	{
		printf("There are no zero-crossings between the selected range.");
	}
	// Correct case
	else
	{
		for (int i = 0; i < numberSteps; i++)
		{
			printf("Step %d: x0 in [%.6lf , %.6lf]\n", i, xLimits[i][0], xLimits[i][1]);
		}

		printf("Stopped at interval size: %.6lf", delta);

		// Free allocated memory
		free(xLimits);
	}

	getchar();
	return 0;
}

/* Defines the function f(x) = x^2 - 2x - 1
 * 
 * @param x Value x to calculate function for
 * @return y Value f(x)
*/
double f(double x)
{
	double y = x * x - 2 * x - 1;

	return y;
}

/* Bisection Method
 * 
 * @param xOne Left border value of the bisection method
 * @param xTwo Right border value of the bisection method
 * @param delta Method stops when interval size (xOne - xTwo) is smaller than delta
 * @param numberSteps [out] Number N of bisection steps
 * @return Nx2 matrix of approximated limits xOne and xTwo
*/
double** bisectionMethod(double xOne, double xTwo, double delta, int* numSteps)
{
	double y1, y2;
	double xCenter, yCenter;
	double** xLimits;
	double intervalSize;
	int columns = 2, pointerBytes, rowBytes;
	int i = 0;

	// Determine number of steps
	intervalSize = xTwo - xOne;
	*numSteps = 0;
	while (intervalSize > delta)
	{
		intervalSize *= 0.5;
		(*numSteps)++;
	}

	// Allocate matrix memory
	pointerBytes = *numSteps * sizeof(double*);
	rowBytes = *numSteps * columns * sizeof(double);
	xLimits = (double**)malloc(pointerBytes + rowBytes);
	if (xLimits == NULL)
		return NULL;

	/* Initialize row pointers (Because we just allocated space, and now we want an array of pointers, that will direct us to each specific row.
	   I guess it could have been done allocating a whole bunch of memory together instead of splitted in pieces.) */
	for (int i = 0; i < *numSteps; i++)
		xLimits[i] = (double*)(xLimits + *numSteps) + i * columns;

	// Initial function values
	y1 = f(xOne);
	y2 = f(xTwo);

	// Condition if no zero-crossings --> EXIT
	if (y1 * y2 > 0)
	{
		xLimits[0][0] = -99;
		xLimits[0][1] = -99;
		return xLimits;
	}

	// If the signs are opposite then there exists a zero in between, and Bisection method can be applied
	while ((y1 * y2 < 0) && (fabs(xOne - xTwo) > delta))
	{
		// Find the next value
		xCenter = (0.5) * (xOne + xTwo);
		yCenter = f(xCenter);

		// Replace the appropiate x variable (left or right one)
		if ((yCenter < 0) && (y1 < 0))
		{
			xOne = xCenter;
		}
		else
		{
			xTwo = xCenter;
		}

		// Store the values
		xLimits[i][0] = xOne;
		xLimits[i][1] = xTwo;

		// Increment the step
		i++;
	}

	return xLimits;
	}