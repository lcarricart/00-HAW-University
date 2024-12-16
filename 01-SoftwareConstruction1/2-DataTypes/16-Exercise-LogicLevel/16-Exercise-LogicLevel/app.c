/* When connecting a Bluetooth module HC-06 to an Arduino Nano R3, the voltage level of the RX
 signal must be reduced from 5 V to about 3.3 V. A simple approach for this is a voltage divider, expressed as 

 \( U_{RX} = \frac{R_2}{R_1 + R_2} \ U_0  \)									[Voltage divider formula]

  However, taking the current I_RX into the RXD pin into account, results in

  \( U_{RX} = \frac{R_2}{R_1 + R_2} \ \left( U_0 - R_1 I_{RX} \right) \)		[Voltage divider formula, considering I in the expression]

 Write a program that reads the values of the the resistors R1 and R2 from the keyboard prints
 URX for load currents IRX = 0 mA and IRX = 0,5 mA, respectively. Which of the resistor values
 1 kΩ, 1.5 kΩ, 2.2 kΩ, and 4.7 kΩ should you use for R1 and R2, when the logic level URX must
 not drop below 3 V?
*/

#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

int main(void)
{
	int r1 = 0;
	int r2 = 0;
	float voltageRX = 0;
	
	float I_RX_DISCONNECTED = 0;				// Current sent from digital port False.
	float I_RX_CONNECTED = 0.0005;			// Current sent from digital port True.
	short VOLTAGE_SUPPLY = 5;

	printf("Introduce the value of the resistors R1 and R2 in Ohms. Possible values are 1000, 1500, 2200, and 4700.\n");
	printf("R1 = ");
	scanf("%d", &r1);
	getchar();

	printf("R2 = ");
	scanf("%d", &r2);
	getchar();

	if ((r1 != 1000 && r1 != 1500 && r1 != 2200 && r1 != 4700) || (r2 != 1000 && r2 != 1500 && r2 != 2200 && r2 != 4700))		// Could be simplified using a function that verifies correct values.
	{
		printf("\nThe selected values are incorrect. Try again considering the possible values.\n");
		return 2222;					// Any non-zero is False.
	}

	voltageRX = ((float) (r2) / (r1 + r2)) * (VOLTAGE_SUPPLY - r1 * I_RX_DISCONNECTED);
	printf("\nThe voltage value U_RX when the device is disconnected is %.3f", voltageRX);

	voltageRX = ((float) (r2) / (r1 + r2)) * (VOLTAGE_SUPPLY - r1 * I_RX_CONNECTED);
	printf("\nThe voltage value U_RX when the device is connected is %.3f", voltageRX);
	/* Connecting a device makes a small current load flow through the circuit, which will produce a voltage drop in the resistances.
	Therefore, we need to ensure that despite that voltage drop, the pair of resistances chosen for the voltage divider supports still the voltage needed for a
	signal representing "TRUE", 3V */

	getchar();

	return 0;
}