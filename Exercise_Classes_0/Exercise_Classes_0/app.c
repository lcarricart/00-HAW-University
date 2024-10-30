// EXTRA Challenge: Do the same with characters with ASCII formats converted into numbers, using '\n' or 'z' for example.
// Objective: analyze the size of a random value.
#include <stdio.h>

int main(void)
{
	// Multiple possibilities for input
	unsigned short num0 = 5;
	unsigned int num1 = 0;
	unsigned long num2 = 0;
	unsigned long long num3 = 0;

	unsigned long long temp = 0;
	unsigned long long num = 1;
	int i = 0;

	// Count the number of extra numbers you would need to add until it overflows.
	while(num > temp){
		i++;
		temp = num;
		num += 1;
	} 

	printf("The size of your number %Lf is %Lf", num0, (num0 + i));

	return 0;
}

