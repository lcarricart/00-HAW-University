/* An electric current of I = 20 mA flows through the protecting series resistor R = 150 ohm of a diode. Write a program using the data type int, only,
* which calctulates and prints:
* 
* a) the voltage U = R.I at the resistance
* b) the power P = U.I consumed at the resistor.
*/

#include <stdio.h>

int main(void)
{
	int current = 20;		// Measured in mili Ampere.
	int resistance = 150;	// Measured in Ohms.
	int voltage = 0;		// U = R.I will result in mili Volts.
	int power = 0;

	voltage = current * resistance;		// 3,000 mili Volts.
	power = voltage * current;			// 3,000 mV * 20 mA = 60,000 mili * mili [Watts] =  60,000 micro Watts (Actually the result is 60 mili Watts)

	printf("Considering a current of %d mA on a resistance of %d Ohm the calculated values are:\n", current, resistance);
	printf("      a) Voltage = %d mV\n", voltage);
	printf("      b) Power = %d micro Watts\n", power);
	getchar();

	return 0;
}

// This exercise proves how messy it gets to try to use scales like "mili" with integer variables. It gets confusing very easily.