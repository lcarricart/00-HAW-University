/* Overall weight Determine the overall weight wchess of all wheat grains, assuming a weight of
 55 mg / grain. Calculate the relation p to the weight wworld of the worldwide wheat production
 in 2015, being about 735.8 million tons: p = w_chess / w_world
*/

#include <stdio.h>

int main(void)
{
	const double NUMBER_GRAINS_CHESS = 1.8446744073709551615e19;		// Total amount of grains
	const short WEIGHT_GRAIN_MG = 55;								// Measured in mg
	const double WEIGHT_WORLDWIDE_MG = 735.8e17;					// Weight of the worldwide wheat production
	long double relationP = 0;									// Relation to the worldwide wheatr production
	char trash;													// Variable introduced to avoid warnings

	relationP =  (NUMBER_GRAINS_CHESS * WEIGHT_GRAIN_MG) / (long double) WEIGHT_WORLDWIDE_MG;

	printf("The relation P between the overall weight in the chess board and the weight of the worldwide wheat production is:\n");
	printf("P = %Lf", relationP);

	trash = getchar();
	return 0;
}

/* It is very interesting how changing "double" to "unsigned long long int" makes the program fail in calculations.
This is despite of the variables fitting inside "unsigned long long int". I suspect that the problem comes on the temp variable
holding the value of WEIGHT_CHESS * WEIGHT_GRAIN

Nowadays, saving space with short and int doesnt make sense because modern machines have more than enough space.
At the same time, C is optimized for data types int (that fit exactly the architecture of your machine) and using short
is actually not more efficient, in terms of calculation power. Only for a washing machine you would care about a short and int and double.
Use all data types the same for the calc of doubke to make sure that you dojnt loose value
*/ 