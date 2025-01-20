/*******************************************************************************************************************
 * Objective of the program: Write a function substring() that receives a string and indices m and n, m ≤ n and 
   returns the substring from index m to n included.
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

/* Pre-definitions */
#define _CRT_SECURE_NO_DEPRECATE

/* Include files */
#include <stdio.h>
#include <string.h>
#include <stdlib.h> // !!!! Don't forget of adding this library for malloc() and calloc()

/* Prototypes */
char* substring(char* originalString, int m, int n);

/* Main function */
int main(void)
{
	// Variable Definition
	const char* originalStr = "The Globe Sessions";
	char* finalStr;
	int m = -1, n = -1;
	int trash;

	// Program Description
	printf("Program description: From the given phrase indicate the indices m & n (m <= n) in order to receive \nthe substring delimited by the character numbers m to n included.\n");
	printf("- Example: \"The Globe Sessions\", 5:7. \n- Result: \"lob\" \n\n");

	// User Input
	printf("Original string: \"The Globe Sessions\"\n");
	printf("Enter indices of substring (formatted \"first:last\"): ");
	if (scanf("%d:%d", &m, &n) != 2)
		return 1;
	while ((trash = getchar()) != '\n');

	// Create substring
	finalStr = substring(originalStr, m, n);
	printf("Substring: \"%s\"", finalStr);
	
	// Free allocated memory
	free(finalStr);

	getchar();
	return 0;
}

/* Receives a full string and returns just a section of it.
*
* @param originalString full string to be shortened
* @param m initial character position from where to start
* @param n last character position, delimiting the end of the desired string
* @return string delimited by n & m
*/
char* substring(char* originalString, int m, int n)
{
	// Variable Definition
	char* finalString;
	int sizeFinal;
	int j = 0;

	// Determine the size of final string. +1 refers to including the last character m-n.
	sizeFinal = n - m + 1;

	/* Dynamic memory allocation. + 1 refers to allocating space for the null terminator.
	 * Failing to allocate that extra space and writing over it leads in completely unexpected behavior.
	 */
	finalString = (char*)calloc(sizeFinal + 1, sizeof(char));
	if (finalString == NULL)
		return 1;

	for (int i = m; i <= n; i++)
	{
		*(finalString + j) = *(originalString + i);
		j++;
	}

	return finalString;
}