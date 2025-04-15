/*******************************************************************************************************************
 * Objective of the program: Make a Tic-Tac-Toe game against a machine, setting different difficulties.   
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

/* Include files */
#define _CRT_SECURE_NO_DEPRECATE
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

/* Prototypes */
void printTicTac(char** matrix);
void askUserInput(char** matrix);
void ticTacInitializer(char** matrix);
void computerTurn(char** matrix, int difficulty);
int winLose(char** matrix, char character);
int* positionDifficulty2(char** matrix, char character);

/* Main function */
int main(void)
{
	char** ticTac;
	int hasWon = 0;
	int difficulty;
	char cross = 'X';
	char circle = 'O';

	srand(time(NULL));

	ticTac = (char**) malloc(3 * sizeof(char*));
	if (ticTac == NULL) exit(EXIT_FAILURE);

	for (int i = 0; i < 3; i++)
	{
		ticTac[i] = (char*) malloc(3 * sizeof(char));
		if (ticTac[i] == NULL) exit(EXIT_FAILURE);
	}

	printf("Welcome to the Tic Tac Toe exam. I challenge you to a game against the PC! \nTo start, choose your difficulty level (1 - 3): ");
	while ((scanf("%d", &difficulty) != 1) && ((difficulty <= 3) || (difficulty >= 1)));
	printf("\nIntroduce the number of row and column that you'd like to play (<row> <column>):\n");

	ticTacInitializer(ticTac);

	do
	{
		printf("Your turn: ");

		askUserInput(ticTac);
		printTicTac(ticTac);
		hasWon = winLose(ticTac, cross);

		if (hasWon == 1)
		{
			printf("Congratulation!! You are victorious :)\n");
			getchar();
			return 0;
		}

		getchar();
		printf("Computer's turn:\n");

		computerTurn(ticTac, difficulty);
		printTicTac(ticTac);
		hasWon = winLose(ticTac, circle);

		if (hasWon == 1)
		{
			printf("It's a real pity, you've been beaten by a machine... :(\n");
			getchar();
			return 0;
		}

	} while (hasWon == 0);
	
	// Free space from bottom to top
	for (int i = 0; i < 3; i++)
	{
		free(ticTac[i]);
	}
	free(ticTac);

	return 0;
}

/* (Function description)
*
* @param (1st parameter) (description)
* @param (2nd parameter) (description)
* @return (retun variable/statement) (description)
*/
void ticTacInitializer(char** matrix)
{
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			matrix[i][j] = ' ';
		}
	}

}

/* (Function description)
*
* @param (1st parameter) (description)
* @param (2nd parameter) (description)
* @return (retun variable/statement) (description)
*/
void printTicTac(char** matrix)
{
	printf("\n-------------\n");
	for (int i = 0; i < 3; i++)
	{
		printf("|");
		for (int j = 0; j < 3; j++)
		{
			printf(" %c |", matrix[i][j]);
		}
		printf("\n-------------\n");
	}
	printf("\n");
}

/* (Function description)
*
* @param (1st parameter) (description)
* @param (2nd parameter) (description)
* @return (retun variable/statement) (description)
*/
void askUserInput(char** matrix)
{
	int selectedRow, selectedColumn;

	do
	{
		while(scanf("%d %d", &selectedRow, &selectedColumn) != 2);
		while (getchar() != '\n');

	} while (matrix[selectedRow - 1][selectedColumn - 1] != ' ');

	matrix[selectedRow - 1][selectedColumn - 1] = 'X';
}

/* (Function description)
*
* @param (1st parameter) (description)
* @param (2nd parameter) (description)
* @return (retun variable/statement) (description)
*/
void computerTurn(char** matrix, int difficulty)
{
	int response;
	int counter;
	int rowChoice, colChoice;
	int* bestMove;

	response = 0 + rand() % (4 - 0 + 1);

	switch (response)
	{
	case 0:
		printf("Interesting choice... but not better than mine!\n");
		break;
	case 1:
		printf("That catched me off guard. I'll try to be smarter next time.\n");
		break;
	case 2:
		printf("Hmm, I think I'm beginnig to understand what your plans are.\n");
		break;
	case 3:
		printf("You are taking too long, speed up mate.\n");
		break;
	case 4:
		printf("Professional moves require professional responses!\n");
		break;
	}

	switch (difficulty)
	{

	// Easy
	case 1:
		do
		{
			rowChoice = 0 + rand() % (2 - 0 + 1);
			colChoice = 0 + rand() % (2 - 0 + 1);
		} while (matrix[rowChoice][colChoice] != ' ');

		matrix[rowChoice][colChoice] = 'O';
		break;

	// Medium
	case 2:
		bestMove = positionDifficulty2(matrix, 'O');

		if (bestMove[0] == -1)
		{
			bestMove = positionDifficulty2(matrix, 'X');

			if (bestMove[0] == -1)
			{
				do
				{
					rowChoice = 0 + rand() % (2 - 0 + 1);
					colChoice = 0 + rand() % (2 - 0 + 1);
				} while (matrix[rowChoice][colChoice] != ' ');

				matrix[rowChoice][colChoice] = 'O';
			}
			else
			{
				rowChoice = bestMove[0];
				colChoice = bestMove[1];

				matrix[rowChoice][colChoice] = 'O';
			}
		}
		else
		{
			rowChoice = bestMove[0];
			colChoice = bestMove[1];

			matrix[rowChoice][colChoice] = 'O';
		}
		break;
	// Hard
	case 3:
		break;
	}
	
}

/* (Function description)
*
* @param (1st parameter) (description)
* @param (2nd parameter) (description)
* @return (retun variable/statement) (description)
*/
int winLose(char** matrix, char character)
{
	int counter;
	int step;

	// Horizontal check
	for (int i = 0; i < 3; i++)
	{
		counter = 0;

		for (int j = 0; j < 3; j++)
		{
			if (matrix[i][j] == character)
				counter++;
		}
		
		if (counter == 3)
		{
			return 1;
		}
	}

	// Vertical check
	for (int j = 0; j < 3; j++)
	{
		counter = 0;

		for (int i = 0; i < 3; i++)
		{
			if (matrix[i][j] == character)
				counter++;
		}

		if (counter == 3)
		{
			return 1;
		}
	}

	// Diagonal check 1
	counter = 0;
	for (int i = 0; i < 3; i++)
	{
		if (matrix[i][i] == character)
			counter++;
	}

	if (counter == 3)
	{
		return 1;
	}

	// Diagonal check 2
	counter = 0;
	step = 0;
	for (int j = 2; j >= 0; j--)
	{
		if (matrix[step][j] == character)
			counter++;
		step++;
	}

	if (counter == 3)
	{
		return 1;
	}

	return 0;
}

/* (Function description)
*
* @param (1st parameter) (description)
* @param (2nd parameter) (description)
* @return (retun variable/statement) (description)
*/
int* positionDifficulty2(char** matrix, char character)
{
	int* positionArray;
	int counter;
	int step2;

	positionArray = (int*)malloc(2 * sizeof(int));

	// Horizontal check
	for (int i = 0; i < 3; i++)
	{
		counter = 0;

		for (int j = 0; j < 3; j++)
		{
			if (matrix[i][j] == character)
				counter++;

			if (counter == 2)
			{
				for (int step = 0; step < 3; step++)
				{
					if (matrix[i][step] == ' ')
					{
						positionArray[0] = i;
						positionArray[1] = step;

						return positionArray;
					}
				}
			}
		}
	}

	// Vertical check
	for (int j = 0; j < 3; j++)
	{
		counter = 0;

		for (int i = 0; i < 3; i++)
		{
			if (matrix[i][j] == character)
				counter++;

			if (counter == 2)
			{
				for (int step = 0; step < 3; step++)
				{
					if (matrix[i][step] == ' ')
					{
						positionArray[0] = i;
						positionArray[1] = step;


						return positionArray;
					}
				}
			}
		}
	}

	// Diagonal check 1
	counter = 0;
	for (int i = 0; i < 3; i++)
	{
		if (matrix[i][i] == character)
			counter++;

		if (counter == 2)
		{
			for (int step = 0; step < 3; step++)
			{
				if (matrix[step][step] == ' ')
				{
					positionArray[0] = step;
					positionArray[1] = step;

					return positionArray;
				}
			}
		}
	}

	// Diagonal check 2
	counter = 0;
	step2 = 0;
	for (int j = 2; j >= 0; j--)
	{
		if (matrix[step2][j] == character)
			counter++;
		step2++;

		if (counter == 2)
		{
			step2 = 0;
			for (int step = 2; step >= 0; step--)
			{
				if (matrix[step2][step] == ' ')
				{
					positionArray[0] = step2;
					positionArray[1] = step;

					return positionArray;
				}
				step2++;
			}
		}
	}

	// Default case, if no specific position ensures win or avoids loose.
	positionArray[0] = -1;
	positionArray[1] = -1;

	return positionArray;
}