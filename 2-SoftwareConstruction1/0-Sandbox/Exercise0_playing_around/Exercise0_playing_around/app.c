// Objective: create a program that requests your age and tell you in which year were you born. 
#define _CRT_SECURE_NO_DEPRECATE

#include <stdio.h>			// To include the scanf() function

int main(void) {
	char answer_play = ' ';
	int age = 0;
	char answer_birth = ' ';
	int year_born = 0;

	printf("Lets play a game! You'll write your age and I'll tell when were your born. \n");
	printf("Ready? (y/n): ");
	scanf("%c", &answer_play);
	getchar();
	printf("\n");

	if (answer_play == ('y' | 'Y')) {	// The use of || is different.
		printf("Enter your age: ");
		scanf("%u", &age);	// Unsigned integer. I should have actually defined age as a uint8_t, but since the set of uint8_t is smaller than int, it's all OK.
							// There are also uint16_t, uint32_t, and uint64_t
		getchar();

		printf("\Did your birthday pass already this year? (y/n): ");
		scanf("%c", &answer_birth);
		getchar();

		if (answer_birth == ('y' | 'Y')) {
			year_born = 2024 - age;
		}
		else if (answer_birth == ('n' | 'N')) {
			year_born = 2023 - age;
		}
		else {
			printf("\nYour answer is not recognized as valid. Restart the program!");
			getchar();
			return 0;		// I'm trynna end my program here like in a 'break' style.
		}

		printf("ANDD.......\n...\n...\nYou were born in %d!", year_born);
		printf("\nThanks for playing :)");
		getchar();
	}
	else if (answer_play == ('n' | 'N')) {
		printf("Okay... Maybe next time :(");
		getchar();
	}
	else {
		printf("Your answer doesn't lead anywhere. Close the program and try again!");
		getchar();
	}
	return 0;
}