/*******************************************************************************************************************
 * Objective of the program: Resolution of the WiSe 2019/2020 SO1 Exam.
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

/* Structures */
struct properties
{
	int characters;
	int words;
	int sentences;
	int syllables;
	double readibility;
};

/* Include files */
#include <stdio.h>
#include <string.h>

/* Prototypes */
int getCharacterCount(char* wordSample, char c);
int getNumberOfWords(char* sentence);
int getNumberOfSentences(char* sentence);
int getNumberOfSyllablesInWord(char* word);

/* Main function */
int main(void)
{
	// Variable Definition


	// Program Description
	printf("SO1 Exam WiSen 2019 / 2020\n\n");
	

	return 0;
}

/* Counts number of specific characters in a given sentence.
*
* @param (1st parameter) (description)
* @param (2nd parameter) (description)
* @return (retun variable/statement) (description)
*/
int getCharacterCount(char* wordSample, char c)
{
	int counter = 0;
	int i = 0;

	while (wordSample[i] != '\0')
	{
		if (wordSample[i] == c)
			counter++;

		i++;
	}

	return counter;
}

/* Counts number of words in a sentence
*
* @param (1st parameter) (description)
* @param (2nd parameter) (description)
* @return (retun variable/statement) (description)
*/
int getNumberOfWords(char* sentence)
{
	int count;

	count = getCharacterCount(sentence, ' ');

	return count + 1;
}

/* Counts number of sentences in a paragraph considering them as the amount of . ; ? !
*
* @param (1st parameter) (description)
* @param (2nd parameter) (description)
* @return (retun variable/statement) (description)
*/
int getNumberOfSentences(char* sentence)
{
	int count;

	count = getCharacterCount(sentence, '.') + getCharacterCount(sentence, ';') + getCharacterCount(sentence, '?') + getCharacterCount(sentence, '!');

	return count;
}

/* Counts the number of syllables in a word
*
* @param (1st parameter) (description)
* @param (2nd parameter) (description)
* @return (retun variable/statement) (description)
*/
int getNumberOfSyllablesInWord(char* word)
{
	int i = 0;
	int count = 0;
	int numChars = strlen(word);

	if (numChars <= 3)
	{
		count = 1;
	}
	else
	{
		while (word[i] != '\0')
		{
			if ((word[i] == 'a') || (word[i] == 'e') || (word[i] == 'i') || (word[i] == 'o') || (word[i] == 'u'))
			{
				count++;
			}
		}
	}
	
	return count;
}