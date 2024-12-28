/*
* Objective of the program:  In Exercise 54 on page 24 we have discussed a rotation of vectors x ∈ R2 by an angle α. Extent your solution by a 
* function rotateVector() that performs the rotation. Access the values of the vector to rotate by pointers and pointer operations.

* The '*' arent really necessary but it is important to practice pointer manipulation with both expressions.
*/

#define _CRT_SECURE_NO_DEPRECATE
#define _USE_MATH_DEFINES

#include <stdio.h>
#include <math.h>

void printRotatedVector(double* y, double* inputVector, double alpha);
void rotateVector(double* y, double* inputVector, double alpha);

int main(void)
{
	double alpha = 90;
	double a[2][2] =
	{
		{cos(alpha), -sin(alpha)},
		{sin(alpha), cos(alpha)}
	};
	double inputVector[2] = { 2.0 , 3.0 };
	double y[2] = { 0 };

	rotateVector(y, inputVector, alpha);
	printRotatedVector(y, inputVector, alpha);

	getchar();

	return 0;
}

void printRotatedVector(double* y, double* inputVector, double alpha)
{
	printf("Input Vector: (%.3lf %.3lf)^T\n", *inputVector, *(inputVector + 1));
	printf("Rotate by: %.3lf degrees\n", alpha);
	printf("Rotated vector: (%.3lf %.3lf)^T\n", *y, *(y + 1));
}

void rotateVector(double* y, double* inputVector, double alpha)
{
	double alphaRadians = 0;

	alphaRadians = alpha * M_PI / 180;
	*y = *inputVector * cos(alphaRadians) - *(inputVector + 1) * sin(alphaRadians);
	*(y + 1) = *inputVector * sin(alphaRadians) + *(inputVector + 1) * cos(alphaRadians);
}