/*  Write a program that prompts users to enter a time period in seconds. Print the period formatted
hh:mm:ss (h: hours, m: minutes, s: seconds) to the console. Hint: The format specifier %02d
 formats an integer value to have at least n digits and adds leading zeros, if required.
 */

#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

int main(void)
{
	int timePeriod = 0;		// Representing seconds.
	int hours = 0;
	int minutes = 0;
	int seconds = 0;

	printf("Introduce a time period in seconds: ");
    if (scanf("%d", &timePeriod) != 1) {
        printf("Error reading input.\n");
        return 1;	// Erratic return. It could also be a return 99; Any non-zero is possible, and I can specify myself different error displays depending on the return value.
    }
	getchar();

	hours = timePeriod / 3600;						// Results are truncated into ints.
	minutes = (timePeriod - hours * 3600) / 60; 
	seconds = timePeriod - hours * 3600 - minutes * 60;

	printf("\nYour introduced period represents (hh:mm:ss): %02d:%02d:%02d", hours, minutes, seconds);

	getchar();

	return 0;		// Successful return.
}