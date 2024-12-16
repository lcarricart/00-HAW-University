// Purpose of the program: determine the size of the data types 'char' and 'int' in standard bytes.

#include <stdio.h>

int main(void)
{
	printf("// Purpose of the program: determine the size of the data types 'char' and 'int' in standard bytes //\n\n");

	char characters[2] = { 0 };
	int integers[2] = { 0 };
	int size1 = sizeof(characters[0]) / sizeof(char);
	int size2 = sizeof(integers[0]) / sizeof(int);

	printf("Address of char[0]: %p\n", characters);
	printf("Address of char[1]: %p\n", (characters + 1));
	printf("Size of char in memory: %d bytes\n\n", size1);

	printf("Address of int[0]: %p\n", &integers[0]);
	printf("Address of int[1]: %p\n", &integers[1]);
	printf("Size of int in memory: %d bytes\n\n", size2);

	// In Part 2 I shall access the individual bytes of an 'unsigned' variable by a pointer of type 'char*'
	unsigned value = 0;
	unsigned* pointer1 = &value;
	char* pointer2 = &value;

	printf("Address (unsigned*): %p\n", pointer1);
	printf("Address (char*): %p\n\n", pointer2);
	*(pointer2 + 0) = 1;
	printf("Set byte 1 at address %p to: %d\n", pointer1, value);
	*(pointer2 + 1) = 1;
	printf("Set byte 2 at address %p to: %d\n", (pointer1 + 1), value);
	*(pointer2 + 2) = 1;
	printf("Set byte 3 at address %p to: %d\n", (pointer1 + 2), value);
	*(pointer2 + 3) = 1;
	printf("Set byte 4 at address %p to: %d\n\n", (pointer1 + 3), value);

	getchar();
	return 0;
}

// This is all very technical. Now the question is, what are the take-aways from this exercise?
/*
*	- Little-endian: Common in x86 architecture, makes the LSB be stored first in memory.
*	- Byte-level manipulation: by defining an unsigned value with a char* pointer you can manipulate individual bytes of the variable.
* This is a powerful technique for debugging data stored in memory, and for modifying data at low level (e.g.: embedded systems or network protocols).
*	- Binary data parsing, memory optimization, cross-platform programming.
*	- There are a lot more take-home's. I can study this in more detail.
* 
* An additional main take-home is how pointers store the memory address of a variable but interpret the data differently depending on the assigned pointer type:
*	- unsigned* interprets the address as a 4-byte integer.
*	- char* interprets the same address as a single byte (because its made to store chars, of size = 1).
*/