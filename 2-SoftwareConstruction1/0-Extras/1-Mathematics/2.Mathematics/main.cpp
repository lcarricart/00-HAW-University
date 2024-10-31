/**************************************************************************************************

Mathematics I
Autor: J. Nieder
Datum: 16.10.2023

Kurzbeschreibung:
Basic calculations with natural numbers

**************************************************************************************************/
#define _CRT_SECURE_NO_WARNINGS		// Schaltet Visual Studio Warnungen bei der Benutzung von scanf ab
#include <stdio.h>					// Standard Bibliothek
#include <stdlib.h>					// enth�lt Funktionen wie system ("PAUSE"), system("cls") etc.
#include <conio.h>					// enth�lt _getch() zur Abfrage einer Tastatureingabe
#include <math.h>					// Mathe-Bibliothek, enth�lt u.a. sqrt()

void ggTkgV();						// Funktion zur Berechnung von ggT und kgV
void primecheck();					// Funktion zur �berpr�fung auf Primzahl
void primelist();					// Funktion zur Erstellung einer Primzahlliste
void primefactors();				// Funktion zur Zerlegung einer Zahl in ihre Primfaktoren
unsigned long int Teiler(unsigned long int n);		// Funktion zur Bestimmung eines Teilers einer Zahl n
void Modulo(void);					// Division with remainder

//Men�f�hrung, gibt Men�text auf dem Konsolenbildschirm aus und steuert dei Tastaturabfrage
void main()
{
	// Deklaration der Variablen
	char ch = 0;							// Eingabe eines Zeichens �ber die die Tastatur mit _getch() aus <conio.h>

	while (ch != 'e')					// Wiederholt das Men�, solange nicht die Taste 'e' f�r Ende des Programms eingegeben wird													// Wiederholt das Men�, solange nicht die Taste e f�r Ende des Programms eingegeben wird
	{
		system("cls");
		printf("Program for basic Calulations with Natural Numbers\n\n");
		printf("1: Greatest Common Divider GCD and Least Common Multiple LCM\n");
		printf("2: Check Number if it is Prime\n");
		printf("3: List of Primes\n");
		printf("4: Calculation of Prime Factors\n");
		printf("5: Division with Remainder (Modulo)\n");
		printf("e: End of Program\n");
		printf("\nPlease choose Operation and enter corresponding key!\n");

		ch = _getch();										// liest ein Zeichen von der Tastatur, das die Men�auswahl steuert

		/* Umsetzung der Men�auswahl. Aus Datensicherheitsgr�nden wird nach jeder Noteneingabe
		und vor jeder Bildschirmausgabe einmal die komplette Liste als Datei ausgegeben */
		switch (ch)
		{
			/* 1: Greatest Common Divider GCD and Least Common Multiple LCM ****/
		case '1':
			ggTkgV();
			break;
			/* 2: Check Number if it is Prime ****/
		case '2':
			primecheck();
			break;
			/* 3: List of Primes to an upper limit ****/
		case '3':
			primelist();
			break;
			/* 4: Calculation of Prime Factors ****/
		case '4':
			primefactors();
			break;
			/* 5: Division with Remainder (Modulo) ****/
		case '5':
			Modulo();
			break;
			/*e: Ende des Programms ***/
		case 'e':
			break;
		default:
			printf("Wrong Input. Press keys 1-4 or e for proper Operation!\n");
			system("PAUSE");
		}
	}
	return;
}

// Funktion zur Berechnung von ggT und kgV
void ggTkgV()
{
	char c;								// zur Tastaturabfrage
	unsigned long int a0;
	unsigned long int a1;
	unsigned long int z0;
	unsigned long int z1;
	unsigned long int zz;

	do {
		system("cls");					// clear screen
		printf("Greatest Common Divisor GCD and Least Common Multiple LCM\n");
		printf("\nEnter Number 1: ");
		scanf("%d", &a0);
		while (getchar() != '\n') continue; // clears keyboard buffer
		printf("Enter Number 2: ");
		scanf("%d", &a1);
		while (getchar() != '\n') continue; // clears keyboard buffer
		z0 = a0;
		z1 = a1;
		if (z0 < z1)					// swap numbers, if z0 is smaler than z1
		{
			zz = z1;
			z1 = z0;
			z0 = zz;
		}

		while (z0 % z1)					// Euclidian Algorithm
		{
			zz = z1;					// the old z1 gets into intermediate storage zz
			z1 = z0 - (z0 / z1) * z1;   // equals to z1=z0%z1
			z0 = zz;					// the old z1 gets z0 out of the intermediate storage zz
		}
		printf("\nGCD = %lu   LCM = %lu", z1, a0 * a1 / z1);
		printf("\nGCD %lu * LCM %lu = %lu", z1, a0 * a1 / z1, a0 * a1);
		printf("\nNo1 %lu * No2 %lu = %lu", a0, a1, a0 * a1);
		printf("\n\nNew calculation (any key =yes, n =no) ? \n");
		c = _getch();
	} while (c != 'n');
	return;
}

// Funktion zur �berpr�fung auf Primzahl
void primecheck() {
	char c;								// zur Tastaturabfrage
	unsigned long int n;				// zu untersuchende nat�rliche Zahl


	do {
		system("cls");						// l�scht Konsolenbildschirm
		printf("Prime Check");
		printf("\nPlease enter a natural number n>1: ");
		scanf("%d", &n);
		while (getchar() != '\n') continue; // clears keyboard buffer

		if ((n == 2) || Teiler(n) == 1)
		{
			printf("n= %d is a prime\n", n);
		}
		else
		{
			printf("n= %d is not a prime\n", n);
		}
		printf("New calculation (any key =yes, n =no) ? ");
		c = _getch();
	} while (c != 'n');
	return;
}


void primelist()
{
	char c;								// zur Tastaturabfrage
	unsigned long int n;				// zu untersuchende nat�rliche Zahl
	unsigned long int k;				// Laufvariable k
	unsigned long int i;				// Laufvariable i
	int prim = 1;						// if i is a prime then prim = 1 else prim = 0

	do {
		system("cls");						// l�scht Konsolenbildschirm
		printf("Prime List");
		printf("\nPlease enter a natural number as the upper limit of a prime list: ");
		scanf("%i", &n);
		while (getchar() != '\n') continue; // clears keyboard buffer

		//Abschnitt Berechnung und Ausgabe
		for (k = 2; k <= n; k++)			// �u�ere Schleife bis zur Obergrenze n
		{
			for (i = 2; i < k; i++)			// innere Schleife, pr�ft, ob k einen Teiler hat
			{
				if (k % i == 0)				// sobald die zu pr�fende Zahl k durch eine Zahl i teilbar ist (k modulo (%) i = 0, d.h. k ist durch i ohne Rest teilbar), ist k keine Primzahl, d.h. prim=0
				{
					prim = 0;
					i = k;					// Die Laufvariable wird auf den h�chsten Wert gesetzt, damit die for-Schleife beendet wird
				}
			}
			if (prim) printf("%d ", k);		// wenn die i-Schleife durchgelaufen ist, ohne da� k durch eine der Zahlen i teilbar ist, dann bleibt prim = 1 (prim) oder (prim==1), d.h. dann ist k eine Primzahl und wird ausgegeben
			prim = 1;						// Zur�cksetzen des Primzahlindikators auf 1
		}

		printf("\nNew calculation (any key =yes, n =no) ? \n");
		c = _getch();
	} while (c != 'n');
	return;
}
// Funktion zur Zerlegung einer Zahl in ihre Primfaktoren
void primefactors()
{
	char c;								// zur Tastaturabfrage
	unsigned long int a;				// Anzahl der mit Primfaktoren belegten Elemente des Primfaktorfeldes primfaktoren
	unsigned long int k;				// Laufvariable des Primfaktorenfeldes primfaktoren k<=a
	unsigned long int i;				// Teiler der aktuell untersuchten Zahl
	unsigned long int n;				// zu untersuchende nat�rliche Zahl
	unsigned long int z;				// die um den zuvor bestimmten Primfaktor (Teiler) dividierte Zahl als neue Ausgangszahl zur Primfaktorzerlegung
	unsigned long int primfaktoren[1000] = { 0 };// Primfaktorfeld, speichert alle Primfaktoren der Zahl n in den Elementen 0->a, a<=100


	do {
		system("cls");						// l�scht Konsolenbildschirm
		printf("Calculation of Prime Factors");
		printf("\nPlease enter a natural number n>1: ");
		scanf("%i", &n);
		while (getchar() != '\n') continue; // clears keyboard buffer
		a = 0;
		k = 0;
		z = n;
		i = Teiler(n);
		if (i == 1)
		{
			printf("n= %d is prime\n", n);
			k = 1;
			primfaktoren[0] = 1;
			primfaktoren[1] = n;
		}
		else
		{
			while (i != 1)
			{
				primfaktoren[k] = i;
				k++;
				printf("n has the divisor %d\n", i);
				z = z / i;
				i = Teiler(z);
			}
			printf("n has the divisor %d\n", z);
			primfaktoren[k] = z;
		}
		printf("Prime factors cross check:\n");
		n = 1;
		for (i = 0; i < k; i++) {
			printf("%d*", primfaktoren[i]);
			n = n * primfaktoren[i];
		}
		printf("%d = %d\n", primfaktoren[i], n * primfaktoren[i]);
		printf("New calculation (any key =yes, n =no) ? \n");
		c = _getch();
	} while (c != 'n');
	return;
}

// Funktion zur Bestimmung eines Teilers einer Zahl n>2
unsigned long int Teiler(unsigned long int n)
{
	unsigned long int i;						// Laufvariable zur Primfaktorzerlegung
	unsigned long int wn = (int)floor(sqrt(n));	// Wurzel der zu untersuchenden Zahl als Obergrenze der zu untersuchenden Teilern

	if (n == 2)
	{
		return 1;
	}
	if (n % 2 == 0)
	{
		return 2;
	}
	i = 3;
	while (i <= wn) {
		if (n % i == 0)
		{
			return i;
		}
		i = i + 2;
	}
	return 1;
}

// Division with remainder
void Modulo(void)
{
	unsigned long int a;			// 1st integer number for modulo
	unsigned long int b;			// 1nd integer number for modulo
	char c = 0;						// zur Tastaturabfrage

	while (c != 'n')
	{
		system("cls");					// clear screen
		printf("Division a/b with Remainder (Modulo)\n");
		printf("\nEnter integer Number a: ");
		scanf("%d", &a);
		while (getchar() != '\n') continue; // clears keyboard buffer
		printf("Enter integer Number b: ");
		scanf("%d", &b);
		while (getchar() != '\n') continue; // clears keyboard buffer
		printf("Division     a/b      : %d\n", a / b);
		printf("Remainder of a/b      : %d\n", a % b);
		printf("a = %d * %d + %d = %d\n\n", (a / b), b, a % b, a);
		printf("New calculation (any key =yes, n =no) ? ");
		c = _getch();
	}
	return;
}