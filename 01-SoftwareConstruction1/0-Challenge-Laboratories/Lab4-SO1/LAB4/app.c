/* 
* This program is splitted into two different parts.
* Part 1 reads the coordinates of a route, from point 0 to 8, and determines the overall distance in km.
* Part 2 considers a set of geographical locations, determines the largest distance between two of them.
*/ 

/* Key take-aways:
*	- Functions dont print outputs. In any case they could return a defined error value and main() will take care of the printing.
*	- Writing an if-statement after the while-loop is a clean way of handling responses like 'N' or 'n'.
*	- '_CRT_SECURE_NO_DEPRECATE' is use to handle cases where I scan a variable of a larger size than the variable I will store it in. 
*/
#define _CRT_SECURE_NO_DEPRECATE

#include <stdio.h>
#include <stdlib.h> // To use system("cls") clearing the screen.

// Determines the distance of a route in km.
extern double getRouteLenghtKm(double* array, int rows, int cols);

// Prints all the locations stored into the array, ensuring that the .txt file was read correctly.
extern void arrayPrinter(double* arrayLatitude, int sizeRows, int sizeCols);

// Read coordinates from a .txt file
extern void readGeoRouteFile(const char* filename, double arrays[][2], int arraySize);

// Convert degrees to radians
extern double toRadians(double degrees);

// Read "GeoPoints.txt" and pass its values to one array of strings and one matrix of coordinates.
extern void readGeoPointsFile(char* fileName2, char locations[][50], double coordinatesPart2[][2], int arraySize2);
 
// Determines two geographical points with the largest distance in between, and returns the value in km.
extern double getMaximumDistance(char locations[][50], double coordinatesPart2[][2], int sizeRows, int* maxIndex1, int* maxIndex2);

int main(void)
{
	// The first bracket of 'arrays[][]'  corresponds to the number of arrays contained in my 2-D matrix.
	// The second bracket makes reference to the amount of values contained in each of them.
	// !!! With this line Im fixing the size of my array and the code is not prepared to read an amount of values higher than the size of the array !!!
	double arrays[9][2] = { 0 }; 
	char* fileName = "C:\\Users\\luchi\\Desktop\\aFile.txt"; // File to read from. Dont forget to use "\\" instead of "\".
	char* fileName2 = "C:\\Users\\luchi\\source\\repos\\lcarricart\\HAW-University\\01-SoftwareConstruction1\\0-Challenge-Laboratories\\Lab4-SO1\\GeoPoints.txt";
	double routeLenght = 0;
	double maximum = 0;
	char selection = ' ';
	char repeat = ' ';

	// ------------------------------------------------------Part 1!---------------------------------------------------------

	// Calls the function to read coordinates from the file
	readGeoRouteFile(fileName, arrays, 9);

	// Calculates the amount of rows and columns in the array in order to use arrayPrinter(). This checks that the information is stored correctly.
	int sizeRows1 = sizeof(arrays) / sizeof(arrays[0]);
	int sizeCols1 = sizeof(arrays[0]) / sizeof(arrays[0][0]);

	// ------------------------------------------------------Part 2!---------------------------------------------------------
	printf("This part of the program reads a set of geographical locations, and determines the largest distance between two of them.\n\n");
	char locations[7][50] = { 0 };
	double coordinatesPart2[7][2] = { 0 };
	int maxIndex1 = -1;
	int maxIndex2 = -1;
	//------------------------------------------> !!! ASK ABOUT THIS !!! <-------------------------------------
	// I didnt want to make this solution. I actually tried to pass an array indexes[2] with a pointer int* indexPointer = indexes. This didnt work. Can we try it?

	// Calculates the amount of rows and columns of the new matrix in order to use arrayPrinter().
	int sizeRows2 = sizeof(coordinatesPart2) / sizeof(coordinatesPart2[0]);
	int sizeCols2 = sizeof(coordinatesPart2[0]) / sizeof(coordinatesPart2[0][0]);

	// Calls the function to read coordinates from the file
	readGeoPointsFile(fileName2, locations, coordinatesPart2, sizeRows2);

	maximum = getMaximumDistance(locations, coordinatesPart2, sizeRows2, &maxIndex1, &maxIndex2);

	do
	{
		system("cls");
		printf("Welcome to the LAB4 exercise of Software Construction 1!\n\n");

		printf("------------------------------------------------------Part 1!---------------------------------------------------------\n");
		printf("1 - Prints the array storing data from GeoRoute.txt to double checks that the trasnfer was successful.\n");
		printf("2 - Calculates the total route lenght between the points 0 and 8.\n");
		printf("------------------------------------------------------Part 2!---------------------------------------------------------\n");
		printf("3 - Prints the matrix storing data from GeoPoints.txt to double check that the transfer was successful.\n");
		printf("4 - Considering the set of geographical locations, determines the largest distance between two of them.\n");
		printf("--------------------------------------------------Extra Commands!-----------------------------------------------------\n");
		printf("E - Exits the program.\n");
		printf("R - Restarts the program.\n\n");

		printf("Type your desired command: ");
		scanf("%c", &selection);
		getchar();
		printf("\n");

		switch (selection)
		{
		case '1':
		{
			// Prints 'arrays'
			system("cls");
			printf("1 - Prints the array storing data from GeoRoute.txt to double checks that the trasnfer was successful.\n");
			arrayPrinter((double*)arrays, sizeRows1, sizeCols1); // This is passing the address of the initial value of the array, and from there I can operate its whole.

			printf("Would you like to continue? (Y/N): ");
			scanf("%c", &repeat);
			getchar();
			break;
		}
		case '2':
		{
			// Calculates the overall distance in km, considering all geographical points.
			system("cls");
			printf("2 - Calculates the total route lenght between the points 0 and 8.\n");
			routeLenght = getRouteLenghtKm((double*)arrays, sizeRows1, sizeCols1);
			printf("Total route lenght between the points: \n- %.4lf km\n\n", routeLenght);

			printf("Would you like to continue? (Y/N): ");
			scanf("%c", &repeat);
			getchar();
			break;
		}
		case '3':
		{
			// Prints 'coordinatesPart2'. 
			system("cls");
			printf("3 - Prints the matrix storing data from GeoPoints.txt to double check that the transfer was successful.\n");
			arrayPrinter(coordinatesPart2, sizeRows2, sizeCols2);

			printf("Would you like to continue? (Y/N): ");
			scanf("%c", &repeat);
			getchar();
			break;
		}
		case '4':
		{
			// Calculates the largest distance among a set of geographical points.
			system("cls");
			printf("4 - Considering thee set of geographical locations, determines the largest distance between two of them.\n\n");
			printf("The two locations that are the farthest apart are:\n");
			printf("1. %s (%lf, %lf)\n", locations[maxIndex1], coordinatesPart2[maxIndex1][0], coordinatesPart2[maxIndex1][1]);
			printf("2. %s (%lf, %lf)\n", locations[maxIndex2], coordinatesPart2[maxIndex2][0], coordinatesPart2[maxIndex2][1]);
			printf("Maximum Distance: %.2lf km\n\n", maximum);

			printf("Would you like to continue? (Y/N): ");
			scanf("%c", &repeat);
			getchar();
			break;
		}
		case 'E':
		case 'e':
		{
			system("cls");
			printf("Thanks for trying out my program. Goodbye! :)");
			repeat = 'N';

			getchar();
			break;
		}
		default:
		{
			system("cls");
			printf("You've entered an invalid command.\n\n");

			printf("Would you like to continue? (Y/N): ");
			scanf("%c", &repeat);
			getchar();
			break;
		}

		}
	} while (repeat == ('Y' | 'y'));
	
	getchar();

	return 0;
}

/* 
* Key take - home's of this exercise:
* - 'External' and 'static' linkage between different files.
* - All functions and variables are declared 'external' by default, and that's why my program was working without and #include
* (the explicit declaration is kinda obvious)
*/