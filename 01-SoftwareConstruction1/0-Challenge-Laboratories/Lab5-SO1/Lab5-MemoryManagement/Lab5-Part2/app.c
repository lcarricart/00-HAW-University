/*
 * Objective of the program (Part 2!):
 * 
 * The main purpose of Part 2 is to reimplement the solution by using structures.
 * 
 * Preparation:
 *		▶ Create a copy of your Visual Studio project solving the first assignment.
 *		▶ Use one of the projects to keep the solution for the first assignment, the other project to create a program implementing the technical requirements below.
 *		▶ As usual, keep both projects in a single Visual Studio solution.
 * 
 * Technical requirements:
 *		▶ Introduce a structure struct geoCoord holding the latitude and longitude (not the name) of a single geographic coordinate.
 *		▶ Modify your program so that it uses the structure to store the coordinates of the waypoints. The functionality implemented in the first assignment must not be changed.
*/

#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>
#include <stdlib.h>  // Needed for malloc() and free()

struct geoCoord
{
	double latitude;
	double longitude;
} coords;

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
	printf("We're currently inside Part 2 of the program, where we implement dynamically allocated arrays of structures to solve\nthe same exercise.\n\n");

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

	// Creating array of structures, dynamically.
	struct geoCoord* coordinates = (struct geoCoord*)malloc(amountWaypoints * sizeof(struct geoCoord));

	// Checks that the allocation was successful.
	if (coordinates == NULL)
	{
		printf("Error: Could not allocate memory.\n");
		return 1;
	}

	printf("Enter your waypoints following the format \"<latitude> <longitude>\"\n");
	for (int i = 0; i < amountWaypoints; i++)
	{
		printf("Waypoint %d: ", i + 1);
		(scanf("%lf %lf", &coordinates[i].latitude, &coordinates[i].longitude) == 2) ? (temp = TRUE) : (temp = FALSE);
		while (((bufferTrash = getchar()) != '\n') && (bufferTrash != EOF));

		// In case the input is incorrect.
		while (temp == FALSE)
		{
			printf("Invalid input, try again with two numeric values (e.g. 41.40338 2.17403)\nInput: ");
			(scanf("%lf %lf", &coordinates[i].latitude, &coordinates[i].longitude) == 2) ? (temp = TRUE) : (temp = FALSE);
			while (((bufferTrash = getchar()) != '\n') && (bufferTrash != EOF));
		}
	}

	for (int i = 0; i < amountWaypoints - 1; i++)
	{
		totalDistance += distanceKm(coordinates[i].latitude, coordinates[i].longitude, coordinates[i + 1].latitude, coordinates[i + 1].longitude);
	}

	printf("\nBy taking this route you will travel %.2lf km", totalDistance);

	// Frees the allocated memory
	free(coordinates);

	getchar();
	return 0;
}