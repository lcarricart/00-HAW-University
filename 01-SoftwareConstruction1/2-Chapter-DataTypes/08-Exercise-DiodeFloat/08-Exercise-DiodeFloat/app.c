/* An electric current of I = 20 mA flows through the protecting series resistor R = 150 ohm of a diode. Write a program using the data type float,
* which calctulates and prints:
*
* a) the voltage U = R.I at the resistance
* b) the power P = U.I consumed at the resistor.
*/

#include <stdio.h>

int main(void)
{
	float current = 0.02;		// Measured in Ampere.
	float resistance = 150;	// Measured in Ohms.
	float voltage = 0;		// U = R.I will result in Volts.
	float power = 0;

	voltage = current * resistance;		// 3 Volts.
	power = voltage * current;			// 3 V * 0.02 A = 0.06 W

	printf("Considering a current of %.2f A on a resistance of %.0f Ohm the calculated values are:\n", current, resistance);
	printf("      a) Voltage = %.0f Volts\n", voltage);
	printf("      b) Power = %.2f Watts\n", power);
	getchar();

	return 0;
}
