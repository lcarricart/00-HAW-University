/*
 * Objective of the program (Part 1!):
 * Let’s book a (virtual) travel! For this, write a program fulfilling the requirements in this and the following section.  
 * 
 * Customer requirements:
 *	▶ Users shall enter the number of waypoints (i. e., place of departure and the destinations).
 * 	▶ Users shall enter the geographic coordinates of all waypoints.
 * 	▶ After correct user input the program shall print the overall length of the route to the console. Copy and re-use functions written in prior lab assignments.
 * 
 * Technical requirements:
 *	▶ In case of invalid input, the application will repeat the request until users enter correct data.
 *	▶ Dynamically allocate 1-D arrays to hold the latitudes and the longitudes of the waypoints.
 *	▶ Make sure to free dynamically allocated memory before the application exits.
 * 
 */

#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>
#include <stdlib.h>  // Needed for malloc() and free()

enum { FALSE, TRUE };

// Function defined in an external re-used file.
double distanceKm(double lat1, double lon1, double lat2, double lon2);

int main(void)
{
	int amountWaypoints = 0;
	int temp;					// Multi-purpose variable.
	int bufferTrash;
	double totalDistance = 0;

	printf("Welcome to the challenge exercise of SO1's Laboratory 5. The purpose of this program is to have a user entering\n");
	printf("different waypoints for his/her trip and calculating the overall lenght of the selected route. Let's dive into it!\n\n");

	printf("Enter the number of waypoints for your trip: ");
	(scanf("%d", &amountWaypoints) == 1) ? (temp = TRUE) : (temp = FALSE);
	while (((bufferTrash = getchar()) != '\n') && (bufferTrash != EOF));

	// In case the input is incorrect.
	while ((amountWaypoints < 0) || (temp == FALSE))
	{
		printf("Invalid input, try again this time with an integer number greater or equal to 0: ");
		(scanf("%d", &amountWaypoints) == 1) ? (temp = TRUE) : (temp = FALSE);
		while (((bufferTrash = getchar()) != '\n') && (bufferTrash != EOF));
	}

	// Creating longitude and latitude arrays, dynamically.
	double* latitude = (double*)malloc(amountWaypoints * sizeof(double));
	double* longitude = (double*)malloc(amountWaypoints * sizeof(double));

	// Checks that the allocation was successful for both.
	if (latitude == NULL || longitude == NULL)
	{
		printf("Error: Could not allocate memory.\n");
		return 1;
	}

	printf("Enter your waypoints following the format \"<latitude> <longitude>\"\n");
	for (int i = 0; i < amountWaypoints; i++)
	{
		printf("Waypoint %d: ", i + 1);
		(scanf("%lf %lf", &latitude[i], &longitude[i]) == 2) ? (temp = TRUE) : (temp = FALSE);
		while (((bufferTrash = getchar()) != '\n') && (bufferTrash != EOF));

		// In case the input is incorrect.
		while (temp == FALSE) 
		{
			printf("Invalid input, try again with two numeric values (e.g. 41.40338 2.17403)\nInput: ");
			(scanf("%lf %lf", &latitude[i], &longitude[i]) == 2) ? (temp = TRUE) : (temp = FALSE);
			while (((bufferTrash = getchar()) != '\n') && (bufferTrash != EOF));
		}
	}

	for (int i = 0; i < amountWaypoints - 1; i++)
	{
		totalDistance += distanceKm(latitude[i], longitude[i], latitude[i + 1], longitude[i + 1]);
	}

	printf("\nBy taking this route you will travel %.2lf km", totalDistance);

	// Frees the allocated memory
	free(latitude);
	free(longitude);

	getchar();
	return 0;
}