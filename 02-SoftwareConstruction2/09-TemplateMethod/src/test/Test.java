/*******************************************************************************************************************
 * Objective of the program: Implement the Template Method by creating a text converter. The backbone methods will
 * be:
 * 		1) printOriginal()
 * 		2) applyCaseConversion()
 * 		3) enhanceConvertedText()
 *  	4) printConverted()
 *******************************************************************************************************************
 * Theory: This method is used to define the skeleton of an algorithm, delegating some steps to subclasses.
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

package test;

import textConversion.*;

public class Test {
	public static void main(String[] args) {
		UpperConverter upperConv = new UpperConverter();
		LowerConverter lowerConv = new LowerConverter();
		UpLowConverter upLowConv = new UpLowConverter();
		
		System.out.println("Lets start the text conversion!");
		upperConv.convertText("This text will be upper case");
		lowerConv.convertText("This TEXT WILL be lower case");
		upLowConv.convertText("This text will be a mix of cases");
	}
}
