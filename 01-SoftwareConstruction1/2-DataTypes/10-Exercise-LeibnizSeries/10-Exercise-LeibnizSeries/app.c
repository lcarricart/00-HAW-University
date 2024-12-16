/* According to Gottfried Wilhelm Leibniz the number "pi" can be calculated by following series expansion with n --> infinity:
* 
* pi approximates to = 4 . Summation_from{n=0}to{N}[ (-1)^n / (2n + 1)]
*/

#include <stdio.h>
#include <math.h>		// To enable powers, using the function pow(). " ^ " DOES NOT REPRESENT A POWER.

int main(void)
{
	float piApproximation = 0;
	float summation;
	short numberN;
	short temp;

	printf("The approximation of Pi depends on the level of accuracy you would like to reach, established by the value of N.\n");
	printf("Therefore, we will make an analysis of the approximation for values of N between 0 and 6.\n\n");

	for (numberN = 0; numberN < 7; numberN++)
	{
		summation = 0;

		for (temp = 0; temp <= numberN; temp++)
		{
			summation += ( pow(-1, temp) ) / (2 * temp + 1);	// Without this casting Im performing int / int = int
		}
		piApproximation = 4 * summation;

		printf("For N = %d, the approximation of Pi is %.4f\n", numberN, piApproximation);
	}

	getchar();

	return 0;
}