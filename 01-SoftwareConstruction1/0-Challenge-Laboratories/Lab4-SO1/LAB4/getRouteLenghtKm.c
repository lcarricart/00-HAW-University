#include <stdio.h>

// Calculates accurate global distance using the formula (15.4)
double distanceKm(double lat1, double lon1, double lat2, double lon2);

// Determines the distance of a route in km.
double getRouteLenghtKm(double* array, int rows, int cols)
{
	double answer = 0;
	double latitude1 = 0;
	double longitude1 = 0;
	double latitude2 = 0;
	double longitude2 = 0;
	int geoPointIndicator = 0;

	printf("Partial sum of distances: \n");

	for (int i = 0; i < rows - 1; i = i++)
	{
		latitude1 = *(array + (i * cols + 0));
		longitude1 = *(array + (i * cols + (0 + 1)));
		latitude2 = *(array + ((i + 1) * cols + 0));
		longitude2 = *(array + ((i + 1) * cols + (0 + 1)));

		answer += distanceKm(latitude1, longitude1, latitude2, longitude2);

		printf("- Point 0 to %d: %.4lf km\n", (geoPointIndicator + (i + 1)), answer);

		// This is the usual way of covering all indexes in a flat matrix (array) in memory. The intuitive *((array + j) + i) doesnt iterate well.

		// WHY DO WE MANIPULATE THE ARRAY IN THIS WAY? 
		// If your function receives a pointer, like double* array, along with int rows and int cols, then you are essentially dealing with a one - 
		// dimensional array of double that you are conceptually treating as 2D.In this scenario, you do not have direct array[i][j] syntax available
		// because the compiler only knows array as a single pointer.You must do the indexing yourself.
	}

	printf("\n");

	return answer;
}