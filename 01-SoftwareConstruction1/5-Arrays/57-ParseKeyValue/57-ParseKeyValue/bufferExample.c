/*
 * Objective of the program: Write a program that prompts users to enter data in the format key=value (e. g., ”university =HAW
 Hamburg”). Print the parsed inputs for key and value in separate rows to the console. 
*/

#define _CRT_SECURE_NO_DEPRECATE

#include <stdio.h>

#define MAX_SIZE 30

int main(void)
{
	char keyName[MAX_SIZE];
	char keyValue[MAX_SIZE];
	int trash;

	printf("Enter key and value (formatted \"keyName = password\"): ");
	scanf("%s = %s", &keyName, &keyValue);

	while ( ((trash = getchar()) != '\n') && (trash != EOF));
	/* This way of clearing the buffer is the standard but not trivial, since we are making heavy use of ASCII values.
	 * Zooming out we have an operator && analyzing two conditions.
	 * 
	 * First condition: (c = getchar()) != '\n'. Another operand != appear, evaluating two other subconditions.
	 *		 First subcondition: The function getchar() takes the first character inside the buffer, and that char is attributted to the variable 'c'.
	 *		 Second subcondition: c != '\n'. Takes the ASCII values of both characters and compares them.
	 * 
	 * Second condition: c != EOF. End-of-file doesn't only refer to a file but indeed it represents the number -1, which does not clash with ASCII's ranging from 0 to 255.
	 * It is a macro (const) defined in 'stdio.h', and a sentinel value used to indicate that no more input is available from a data stream.
	 * 
	 * Why do we look for a '\n' to signify the end of the string? If a user enters "Hello\n" we wanna store just "Hello". This is done automatically by scanf(), which stores all
	 * characters until encountering any whitespace (' ', '\n', 'tab'). This will make '\n' to remain in the buffer, forcing us to clean it.
	 * Our new string will have the content "Hello", which char by char would be 'Hello\0'.
	 * 
	 * Lastly, 'trash' must be an int, but why? getchar can return all possible unsgined char ASCII values (0 - 255) plus de EOF (-1). Defining 'char trash' wont consider the case -1.
	*/

	printf("\nKey: %s", keyName);
	printf("\nValue: %s", keyValue);

	getchar();
	return 0;
}