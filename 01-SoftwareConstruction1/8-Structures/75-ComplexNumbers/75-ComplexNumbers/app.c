/*******************************************************************************************************************
 * Objective of the program: Declare a structure containing the value of a complex number z = x + jy ∈ C represented by its
 real part x ∈ R and imaginary part y ∈ R. Furthermore, write following functions for complex numbers:
	▶ getComplexAbsolute() returns the absolute value |z| of z ∈ C
	▶ getComplexPhase() returns the phase (or angle) arg(z) of z ∈ C
	▶ addComplex() returns the sum z1 +z2 of complex numbers z1, z2 ∈ C
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

/* Pre-definitions */
#define _USE_MATH_DEFINES

/* Include files */
#include <stdio.h>
#include <math.h>

/* Structure complexNumber */
struct complexNumber
{
	double real;
	double imaginary;
	double absValue;
	double phase;
};

/* Prototypes */
double getComplexAbsolute(struct complexNumber z);
double getComplexPhase(struct complexNumber z);
struct complexNumber addComplex(struct complexNumber z1, struct complexNumber z2);

/* Main function */
int main(void)
{
	// Variable Definition
	struct complexNumber z1 = { 2, -2, 0, 0};
	struct complexNumber z2 = { -0.5, 0.7, 0, 0};
	struct complexNumber resultAddition;

	// Program Description
	printf("Program description: given two complex numbers in rectangular form, determine phase and magnitude of z1, and the resulting addition of z1 + z2\n\n");
	printf("z1 = %lf + (%lf) j\n", z1.real, z1.imaginary);
	printf("z2 = %lf + (%lf) j\n\n", z2.real, z2.imaginary);

	// Determine Phase and Magnitude of z1
	z1.absValue = getComplexAbsolute(z1);
	z1.phase = getComplexPhase(z1);

	// Perform z1 + z2
	resultAddition = addComplex(z1, z2);

	// Print Results
	printf("Absolute |z1|    = %.4lf\n", z1.absValue);
	printf("Phase    arg(z1) = %.2lf degrees\n", z1.phase);
	printf("Sum      z1 + z2 = %.1lf + (%.1lf) j\n", resultAddition.real, resultAddition.imaginary);

	return 0;
}

/* Determine the absolute value of a complex number
*
* @param z complex number
* @return magnitude of the complex number z
*/
double getComplexAbsolute(struct complexNumber z)
{
	return (sqrt(pow(z.real, 2) + pow(z.imaginary, 2)));
}

/* Determine the phase of a complex number
*
* @param z complex number
* @return phase of the complex number z in degrees
*/
double getComplexPhase(struct complexNumber z)
{
	double radiansPhase = atan2(z.imaginary, z.real);
	return (radiansPhase * 180 / M_PI);
}

/* Add two complex numbers
*
* @param z1 complex number 1
* @param z2 complex number 2
* @return addition of z1 + z2
*/
struct complexNumber addComplex(struct complexNumber z1, struct complexNumber z2)
{
	struct complexNumber result;

	result.real = z1.real + z2.real;
	result.imaginary = z1.imaginary + z2.imaginary;

	return result;
}