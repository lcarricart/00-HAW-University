#define _CRT_SECURE_NO_DEPRECATE	// This is to ensure the scanf() work properly.
									// "define"s must be written before any "include"

#include <stdio.h>

int main(void) {
	// How many seconds are there in a day?
	// First task
	int days = 7;
	int hours;
	int minutes;
	int seconds_week;
	int seconds_day;
	
	//Second task
	int remaining_days;
	int weeks_year;

	//Third task
	int age;
	char answer;
	int year_born;

	hours = days * 24;
	minutes = hours * 60;
	seconds_week = minutes * 60;

	seconds_day = 24 * 60 * 60;

	printf("A day has %d seconds, while a week has %d seconds", seconds_day, seconds_week);

	weeks_year = 365 / 4; // Amount of months in a year, times 4 weeks.
	remaining_days = 365 % 4;

	printf("\nA year has %d full weeks with %d day(s) remainig", weeks_year, remaining_days);

	printf("\nThe division of 365 by the amount of weeks, actually would give a real result: %.3f", 365 / 4.0);
	/* 
	Dividing 365 / 4 expressing them as integers should be fine, but since I define my result as a float, the compiler messes up and my results ends up being 0 instead of 91.
	This isn´t really common sense, so be careful when giving a pure integer to a float variable.
	*/

	printf("\n----------------------------------------------------------------------------");
	printf("\nWrite your age and after, answer if you had your birthday already during this year? (y/n)\n");
	scanf_s("%d %c", &age, &answer, 1);	//This special scanf() is designed to fix problems by itself. 1 is the size of the buffer for the char.

	/*
	Otherwise, and whats necessary for the exam, you can write the code the following way:
	
	#define _CRT_SECURE_NO_DEPRECATE

	scanf("%d", &age);
	getchar();				This line takes the remaining data and avoid possible problems with the input. 
							This includes the "Enter" key that stays in the buffer and is not the same data type as an integer.
							
							A good practice is to also clean the buffer, besides that getchar(). Example cases could be asking for two variables: 1) %.2f 2) %d.
							If I introduce 1,111111 then the first variable would catch 1,11 and the second one will catch the 1´s left in the buffer.
							This cleaning must be done in between, and not after the scanf().
	scanf("%c", &answer);
	getchar();
	or


	*/

	if (answer == 'y') {
		year_born = 2024 - age;
		printf("You were born in %d", year_born);
	}
	else if (answer == 'n') {
		year_born = 2023 - age;
		printf("You were born in %d", year_born);
	}
	else {
		printf("The answer introduced is not valid.");
	}
	
	getchar();
	return 0;
}