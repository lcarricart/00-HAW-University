// Create a program that tells how many seconds are there in X days. How many days are in Y seconds?
// Then write a random amount of days and return how many years is that, with what remainder of days.

#define _CRT_SECURE_NO_DEPRECATE
#include<stdio.h>	// To include the scanf() function

int main(void) {
	float days = 0;
	float hours = 0;
	float minutes = 0;
	float seconds = 0;

	int years = 0;
	int remaining_days = 0;

	printf("Write the amount of days to be processed: ");
	scanf("%f", &days);
	getchar();

	hours = 24 * days;
	minutes = 60 * hours;
	seconds = 60 * minutes;

	printf("%0.0f days correspond to %0.0f seconds.\n\n", days, seconds);
	printf("Now! Give me an amount of seconds: ");
	scanf("%f", &seconds);
	getchar();

	minutes = seconds / 60;
	hours = minutes / 60;
	days = hours / 24;

	printf("%0.0f seconds are %0.4f days!\n\n", seconds, days);
	printf("Give me an amount of days, and I'll tell how many years is that. If the amount if not round, I'll express also the remaining days.\n");
	printf("Days: ");
	scanf("%f", &days);
	getchar();

	years = days / 365;					// Since years is an int, truncation happens automatically.
	remaining_days = (int)days % 365;	// Modulo only works for integer operations, so I must cast it.
	printf("%0.0f days represent %d year/s and %d days.\n", days, years, remaining_days);
	getchar();

	return 0;
}