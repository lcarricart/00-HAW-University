#define _CRT_SECURE_NO_DEPRECATE
#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

// Read "GeoPoints.txt" and pass its values to one array of strings and one matrix of coordinates.
void readGeoPointsFile(char* fileName2, char locations[][50], double coordinatesPart2[][2], int arraySize2) {
// I pass array[][2] so that the compiler can make the right calculation with *(array + (i * cols + j)). Otherwise it would handle matrixes erroneously.
	FILE* file;
	char buffer[256];
	double latitudeTemp = 0;
	double longitudeTemp = 0;

	// Open the file in read mode
	file = fopen(fileName2, "r");
	if (file == NULL) {
		printf("Error: Could not open file %s\n", fileName2);
		return; // Exit the function
	}

	// Read each line and store the latitude and longitude values
	int i = 0;
	while (fgets(buffer, sizeof(buffer), file) != NULL) {
		// Parse the line into latitude and longitude
		if (sscanf(buffer, "%[^|]|%lf|%lf", locations[i], &latitudeTemp, &longitudeTemp) == 3) {
			if (i < arraySize2) { // Ensure we don't exceed the array bounds
				coordinatesPart2[i][0] = latitudeTemp;
				coordinatesPart2[i][1] = longitudeTemp;
				i++;
			}
			else {
				printf("Warning: File contains more data than the array can store.\n");
				break;
			}
		}
		else {
			printf("Warning: Could not parse line: %s", buffer);
		}
	}

	// Close the file
	fclose(file);
}
