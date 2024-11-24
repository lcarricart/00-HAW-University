#include <stdio.h>

int function1(int);
// int function1(int);
void function2();

// This program has a very interesting behavior where function2 returns void and despite of it the function terminates with a return 0, not finishing its whole instructions.

int main(void)
{
	printf("Hi: %d\n", function1(200));
	function2();

	printf("HI\n");

	return 0;
}

int function1(int a)
{
	return a-2;
}

void function2()
{
	printf("HEYY\n");
	return 0;
	printf("2nd HEYY");
}

//int function1(int a)
//{
//	return a-100;
//}