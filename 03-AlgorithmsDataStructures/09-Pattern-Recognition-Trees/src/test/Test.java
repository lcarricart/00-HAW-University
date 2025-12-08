/*******************************************************************************************************************
 * Objective: Use trees to create a pattern recognizer to validate the format of user input such as a phone number
 * (+49) 0175 445 7667 or email address. If the user input does not correlate to expected characters, then the output
 * is an error message.
 *******************************************************************************************************************
 * Remark: This pattern recognition actually makes more sense for complex patterns such as the ones found by compilers;
 * however, the purpose is to practice the use of <decision trees>.
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student, HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

package test;

import java.util.Scanner;

public class Test {
	private static PatternRecognizer myPhoneChecker; // static because we're in main and the compiler complains
	
	public static void main(String[] args) {
		boolean validInput;
		
		Scanner scanner = new Scanner(System.in);
		myPhoneChecker = new PatternRecognizer();
		
		System.out.println("Welcome to the Pattern Recognition Test");
		System.out.println("Please write down a phone number following any of the permitted formats:");
		System.out.println("    - (+49) 0175 477 7564");
		System.out.println("    - +49 0175 477 7564");
		System.out.println("    - 0175 477 7564\n");
		System.out.println("Phone number: ");
		
		String userInput = scanner.nextLine();
		
		validInput = myPhoneChecker.check(userInput);
		
		if (validInput) {
			System.out.println("\nThank you for respecting the specified format\n");
		} else {
			System.out.println("\nInvalid format\n");
		}
		
		scanner.close(); // Once I don't need anymore inputs
	}
}
