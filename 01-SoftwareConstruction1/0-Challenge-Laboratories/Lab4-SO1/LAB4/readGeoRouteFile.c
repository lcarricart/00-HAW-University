#define _CRT_SECURE_NO_DEPRECATE
#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

// Read coordinates from a .txt file
void readGeoRouteFile(char* fileName, double arrays[][2], int arraySize)
{
	FILE* file;
	char buffer[256]; // Buffer to read each line of the file
	double latitudeTemp = 0;
	double longitudeTemp = 0;

	// Open the file in read mode
	file = fopen(fileName, "r");
	if (file == NULL) {
		printf("Error: Could not open file %s\n", fileName);
		return; // Exit the function
	}

	// Read each line and store the latitude and longitude values
	int i = 0;
	while (fgets(buffer, sizeof(buffer), file) != NULL) {
		// Parse the line into latitude and longitude
		if (sscanf(buffer, "%lf,%lf", &latitudeTemp, &longitudeTemp) == 2) {
			if (i < arraySize) { // Ensure we don't exceed the array bounds
				arrays[i][0] = latitudeTemp;
				arrays[i][1] = longitudeTemp;
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