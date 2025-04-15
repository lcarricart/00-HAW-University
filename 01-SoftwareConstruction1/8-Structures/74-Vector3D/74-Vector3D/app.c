/*******************************************************************************************************************
 * Objective of the program:  Declare a structure representing vectors x = (x,y,z)T ∈ R3. Furthermore, write a function
   scalarProduct() that returns the scalar or dot product of two vectors x, y ∈ R3.
		-  x · y = x1.y1 + x2.y2 + x3.y3  
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

/* Include files */
#include <stdio.h>

/* Prototypes */
int scalarProduct(struct vector v1, struct vector v2);

/* Structure vector */
struct vector {
	int x;
	int y;
	int z;
};

/* Main function */
int main(void)
{
	// Variable Definition
	struct vector vector1;
	int result1, result2, result3;

	// Vector 1 Initialization
	vector1.x = 2;
	vector1.y = -3;
	vector1.z = 1;

	// Vector 2 Initialization
	struct vector vector2 = { 5, 3, 2 };

	// Vector 3 Initialization
	struct vector vector3 = { 4, 4, 4 };

	// Program Description
	printf("Program description: return the scalar product of two vectors.\n\n");
	printf("v1 = ( %d, %d, %d )\n", vector1.x, vector1.y, vector1.z);
	printf("v2 = ( %d, %d, %d )\n", vector2.x, vector2.y, vector2.z);
	printf("v3 = ( %d, %d, %d )\n\n", vector3.x, vector3.y, vector3.z);

	// Perform Scalar Product of two vectors
	result1 = scalarProduct(vector1, vector2);
	result2 = scalarProduct(vector2, vector3);
	result3 = scalarProduct(vector3, vector1);

	// Print Results
	printf("<v1, v2> = %d\n", result1);
	printf("<v1, v3> = %d\n", result3);
	printf("<v2, v3> = %d\n", result2);

	getchar();
	return 0;
}

/* Performs scalar product between two vectors of size 3.
*
* @param v1 vector number 1
* @param v2 vector number 2
* @return result of the scalar product between both vectors
*/
int scalarProduct(struct vector v1, struct vector v2)
{
	return ((v1.x * v2.x) + (v1.y * v2.y) + (v1.z * v2.z));
}