/* 
 * Objective of the program : Write a function that calculates the standard deviation of components in a vector x = (x1, x2, ..., xn). Due to learning purposes, dynamic memory allocation done
 * automatically by the compiler must not be used; instead, later we will use functions like 'malloc()' to do it. So far, we avoid all this and keep the sizes constant.
 */ 

#include <stdio.h>
#include <math.h>

#define ARRAY_SIZE 7	// 'define' is written before 'include' mainly when they affect the included libraries. Otherwise it is good practice to define it after them.
						/* 
						 * The array size must be a constant value.Why ? This ensures portability with all C standards. Before C99 dynamic memory allocation for arrays wasnt allowed.
						 * However, after C11 this option became optional, giving users the option to enable of disable this capability (due to optimization purposes). Therefore, not all
						 * modern standards are compatible with dynamic array sizes defined this way.
						*/

double standardDeviation(const double* array, int size);
// We declare the variable 'array' as a pointer to constant data, ín order to secure the content of the array. If we'd like to not modify the pointer, that would be double* const array.

int main(void)
{
	double dataArray[ARRAY_SIZE] = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.5, 7.0 };
	double deviation;

	deviation = standardDeviation(dataArray, ARRAY_SIZE);

	printf("Data: ");
	for (int i = 0; i < ARRAY_SIZE; i++)
	{
		printf("%.1lf ", dataArray[i]);
	}
	printf("\nStatistical standard deviation = %.1lf", deviation);

	getchar();
	return 0;
}

double standardDeviation(const double* array, int size)
// C does not support passing entire arrays by value directly. Only pointers can be passed, which refer to the original array.
{
	double deviationValue = 0;
	double meanValue = 0;
	double temp = 0;
	double temp2 = 0;
	int i;

	for (i = 0; i < size; i++)
	{
		temp += array[i];
	}
	meanValue = (1.0 / size) * temp;

	temp = 0;
	for (i = 0; i < size; i++)
	{
		temp += pow((array[i] - meanValue), 2);
	}
	temp2 = (1.0 / (size - 1)) * temp;

	deviationValue = sqrt(temp2);

	return deviationValue;
}