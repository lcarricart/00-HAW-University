// Calculate a matrix-vector multiplication and print the result. We multiply a (3x3) x (3x1) = (3x1)

#include <stdio.h>

int main(void)
{
	int coeficientsMatrix[3][3] = 
	{	{1, 2, 0},
		{0, 2, 1},
		{3, 0, 1}
	};

	int incognitaVector[3] = {2, 3, 1};
	double solutionVector;


	soultionVector =
	{
		( coeficientsMatrix[0][0] * incognitaVector[0] + coeficientsMatrix[0][1] * incognitaVector[1] + coeficientsMatrix[0][2] * incognitaVector[2] ),
		( coeficientsMatrix[1][0] * incognitaVector[0] + coeficientsMatrix[1][1] * incognitaVector[1] + coeficientsMatrix[1][2] * incognitaVector[2] ),
		( coeficientsMatrix[2][0] * incognitaVector[0] + coeficientsMatrix[2][1] * incognitaVector[1] + coeficientsMatrix[2][2] * incognitaVector[2] ),
	}
	printf("");

	return 0;
}