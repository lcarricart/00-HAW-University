// Objective of the program: Apply a so-called 'median filter' commonly used for noise reduction. Compute the data by triads.

#include <stdio.h>

void medianFilter(int* original, int* filtered, int size);

int main(void)
{
	int originalData[15] = { 95, 91, 211, 97, 89, 96, 94, 3, 91, 94, 92, 96, 93, 97, 94 };
	int filteredData[15] = { 0 };
	int sizeArray;

	sizeArray = sizeof(originalData) / sizeof(int);

	medianFilter(originalData, filteredData, sizeArray);

	printf("The original set of data is:\n");
	printf("|");

	for (int i = 0; i < sizeArray; i++)
	{
		printf(" %d |", originalData[i]);
	}

	printf("\n\nAfter processing the data through the median filter:\n");
	printf("|");

	for (int i = 0; i < sizeArray; i++)
	{
		printf(" %d |", filteredData[i]);
	}


	getchar();
	return 0;
}

void medianFilter(int* original, int* filtered, int size)
{
	filtered[0] = original[0];
	filtered[size] = original[size];

	for (int i = 1; i < size - 1; i++)
	{
		if ((original[i - 1] >= original[i]) && (original[i - 1] >= original[i + 1]))		// The greatest
		{
			if ((original[i] >= original[i + 1]))
			{
				filtered[i] = original[i];
			}
			else
			{
				filtered[i] = original[i + 1];
			}
		}
		else if ((original[i - 1] <= original[i]) && (original[i - 1] <= original[i + 1]))	// The smallest
		{
			if ((original[i] <= original[i + 1]))
			{
				filtered[i] = original[i];
			}
			else
			{
				filtered[i] = original[i + 1];
			}
		}
		else																				// Not the greatest, nor the smallest.
		{
			filtered[i] = original[i - 1];
		}
	}

	filtered[size - 1] = original[size - 1];
}