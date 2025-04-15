/*******************************************************************************************************************
 * Objective of the program: Vectors and prime numbers. Winter 2016/17.
 *******************************************************************************************************************
 * Assignment: 2nd Exercise 
 * Write a program that prints all prime numbers in the range from 1 to N to the console. Your implementation must
 * fulfill all requirements stated in the following sections.
 * 
 * Mathematical background:
 * An integer number k ≥ 2 is a prime number, if it has no positive divisor other than 1 
 * and itself. For instance, the number range from 1 to 10 contains the prime numbers 2, 3, 5, and 7. The integer 7 
 * is a prime number, because it can be divided by 1 and 7, only. In contrast, 9 is not a prime number, because it
 * can be divided by 3 (in addition to 1 and 9).
 * 
 * Typedefinitions and even numbers:
 *		1. Define an enumerated type named boolean. The enumeration defines constants FALSE with value 0 and TRUE with value 1.
 *		2. Implement the function isEven(), which returns a value corresponding to the logical true, only if the argument can be
 *		   divided by 2. (Note that numbers 2, 4, 6, 8, ... are called even numbers, while numbers 1, 3, 5, 7, ... are called odd numbers.)
 *		3. Implement the function isPrimeNumber(), which returns the constant TRUE, only if the integer argument k is a prime number. Implement the function as follows:
 *				(a) Return FALSE, if the number is too small (k ≤ 1).
 *				(b) Return FALSE, if the number is even and ≥ 4. Use the function isEven().
 *				(c) Run through all odd numbers m with 3 ≤ m < k/2, skipping even numbers. Return FALSE, if k can be divided by m without remainder.
 *				(d) Else return TRUE.
 * 
 * Main function: Implement the following functionality in the main() function. The sample user input and console output below shall clarify the requirements.
 *		4. Users are asked to enter a positive integer number.
 *		5. While the user input is not valid, users are asked to retry.
 *		6. The keyboard line buffer is emptied after each user input.
 *		7. The program prints to the console all prime numbers in the range from 1 to the number entered by the user, included.
 *		8. The prime numbers are printed in rows of 10 numbers each.
 *		9. The numbers are aligned to the right in each column.
 *		10. The number of prime numbers within the range is printed to the console
 *******************************************************************************************************************
 * Sample user input and console output
 * 
 * Invalid user input:
 * Enter maximum number to test : 0
 * Invalid input , must be positive integer . Retry : HAW Hamburg
 * Invalid input , must be positive integer . Retry : 11
 * 
 * Prime numbers in [1 , 11]:
 * 2 3 5 7 11
 * 
 * There are 5 prime numbers in [1, 11].ä
 * 
*******************************************************************************************************************
 * Rows and alignment: sample output 2
 * 
 * Enter maximum number to test : 250
 * Prime numbers in [1 , 250]:
 *   2   3  5    7  11  13  17  19  23  29 
 *  31  37  41  43  47  53  59  61  67  71 
 *  73  79  83  89  97 101 103 107 109 113
 * 127 131 137 139 149 151 157 163 167 173
 * 179 181 191 193 197 199 211 223 227 229
 * 233 239 241
 * 
 * There are 53 prime numbers in [1, 250].
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

enum {FALSE, TRUE};

/* Include files */
#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

/* Prototypes */
int isEven(int number);
int isPrimeNumber(int number);

/* Main function */
int main(void)
{
	// Variable Definitions
	int testNumber;
	int counter = 0;

	// Task 4, 5, 6. We do not have to check if the input is indeed an integer or if a tricky user tries to put a float.
	printf("Enter a maximum number to test: ");
	while ((scanf("%d", &testNumber) != 1) || (testNumber <= 0))
	{
		printf("Invalid input, must be positive integer. Retry: ");
		while (getchar() != '\n');
	}
	while (getchar() != '\n');

	// Task 7, 8, 9.
	printf("Prime numbers in [1, %d]:\n", testNumber);
	
	for (int i = 1; i <= testNumber; i++)
	{
		if (isPrimeNumber(i))
		{
			printf("%3d ", i);
			counter++;

			if ((counter % 10) == 0)
			{
				printf("\n");
			}
		}
	}

	//Task 10
	printf("\nThere are %d prime numbers in [1, %d]\n", counter, testNumber);

	getchar();
	return 0;
}


/* (Function description) */
int isEven(int number)
{
	return !(number % 2);
}

/* (Function description) */
int isPrimeNumber(int number)
{
	if (number <= 1)
	{
		return FALSE;
	}
	else if (isEven(number) && (number >= 4))
	{
		return FALSE;
	}
	else 
	{
		for (int m = 3; m < (number / 2); m = m + 2)
		{
			if ((number % m) == 0)
			{
				return FALSE;
			}
		}
	}

	return TRUE;
}