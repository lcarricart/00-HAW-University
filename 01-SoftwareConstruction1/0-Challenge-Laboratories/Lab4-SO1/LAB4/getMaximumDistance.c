// Calculates accurate global distance using the formula (15.4)
double distanceKm(double lat1, double lon1, double lat2, double lon2);

// Determines two geographical points with the largest distance in between, and returns the value in km.
double getMaximumDistance(char locations[][50], double coordinatesPart2[][2], int sizeRows, int* maxIndex1, int* maxIndex2)
{
	double distanceTemp = 0;
	double max = 0;

	for (int j = 0; j < sizeRows; j++)
	{
		for (int i = 0; (i < sizeRows); i++)
		{
			distanceTemp = distanceKm(coordinatesPart2[j][0], coordinatesPart2[j][1], coordinatesPart2[i][0], coordinatesPart2[i][1]);

			if (distanceTemp > max)
			{
				max = distanceTemp;
				*maxIndex1 = j;
				*maxIndex2 = i;
			}
		}
	}

	return max;
}