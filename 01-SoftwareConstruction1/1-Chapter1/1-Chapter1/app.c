#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

int main(void) {
	float temp_fahrenheit = 0;
	float temp_celcius = 0;

	printf("Enter the temprature in degrees Fahrenheit: ");
	scanf("%f", &temp_fahrenheit);
	getchar();

	temp_celcius = (temp_fahrenheit - 32) * (5.0 / 9);
	printf("\nThe temperature provided corresponds to %0.2f in degrees Celcius", temp_celcius);
	getchar();

	return 0;
}