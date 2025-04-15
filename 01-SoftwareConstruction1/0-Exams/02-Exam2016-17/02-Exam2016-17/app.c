/*******************************************************************************************************************
 * Objective of the program: Vectors and prime numbers. Winter 2016/17.
 ******************************************************************************************************************* 
 * Assignment: 1st Exercise
 * 
 * Implement functionality for mathematical vectors a = (x,y)T with components x and y. Vectors shall be stored in
 * arrays of type double and size 2. Your implementation must fulfill all requirements stated in the following.
 *		 1. Define the constant DIM, which is used in main(), with an appropriate value.
 *		 2. Implement printVector2D() such that main() generates the console output below.
 *		 3. Implement the function vectorLength() returning the length |a| = x2 + y2 of a vector.
 *		 4. Implement the function scaleVector2D() that scales (i. e., multiplies) a vector a with a floating-point
 *			number k of type double.
 *		 5. Implement the function dotProduct2D() that calculates and returns the dot product a1·a2 = x1x2 +y1y2 
 *			of two vectors a1 = (x1,y1)T and a2 = (x2,y2)T.
 *		 6. Add missing function prototypes for all functions except for main().
 *		 7. Add all required include directives.
 *		 8. The parameter declarations of all functions except for scaleVector2D() must ensure that a function cannot
 *			change the values of arrays that are passed to the function.
 *		 9. The main() function must generate console output exactly as stated below.
 *******************************************************************************************************************
 * Expected console output:
 * 
 * Vectors:
 * a1 = (3.0 , 4.0)
 * a2 = (-2.0, 6.0)
 * 
 * Vector length :
 * | a1 | = 5.0
 * 
 * Scale a2 with 0.5:
 * a2 = (-1.0, 3.0)
 * 
 * Dot product :
 * <a1 , a2> = 9.0
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

/* Include files */
#define DIM 2
#include <stdio.h>
#include <math.h>

/* Prototypes */
void printVector2D(const double* inputArray, int size);
double vectorLenght(const double* inputArray, int size);
void scaleVector2D(double* inputArray, int size, double scalingFactor);
double dotProduct2D(const double* array1, const double* array2);

/* Main function */
int main(void)
{
	// Variable definitions
	double a1[DIM] = { 3, 4 };
	double a2[DIM] = { -2, 6 };
	double magnitudeA1, dotProduct;
	double scalingFactor = 0.5;

	// Task 2
	printf("Vectors:\n");
	printf("a1 = ");
	printVector2D(a1, DIM);

	printf("a2 = ");
	printVector2D(a2, DIM);

	// Task 3
	magnitudeA1 = vectorLenght(a1, DIM);

	printf("\nVector lenght:\n");
	printf("|a1| = %.1lf\n", magnitudeA1);

	// Task 4
	scaleVector2D(a2, DIM, scalingFactor);

	printf("\nScale a2 with %.1lf:\n", scalingFactor);
	printf("a2 = ");
	printVector2D(a2, DIM);

	// Task 5
	dotProduct = dotProduct2D(a1, a2);

	printf("\nDot product:\n");
	printf("<a1, a2> = %.1lf", dotProduct);

	getchar();
	return 0;
}

/* (Function description) */
void printVector2D(const double* inputArray, int size)
{
	printf("(");

	for (int i = 0; i < size; i++)
	{
		printf("%.1lf", *(inputArray + i));

		if (i < size - 1)
		{
			printf(", ");
		}
	}

	printf(")\n");
}

/* (Function description) */
double vectorLenght(const double* inputArray, int size)
{
	double temp = 0;
	
	for (int i = 0; i < size; i++)
	{
		temp += pow(*(inputArray + i), 2);
	}

	return sqrt(temp);
}

/* (Function description) */
void scaleVector2D(double* inputArray, int size, double scalingFactor)
{
	for (int i = 0; i < size; i++)
	{
		*(inputArray + i) *= scalingFactor;
	}
}

/* (Function description) */
double dotProduct2D(const double* array1,const double* array2)
{
	return ((array1[0] * array2[0] + array1[1] * array2[1]));
}