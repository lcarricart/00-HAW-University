/*******************************************************************************************************************
 * Objective of the program: Implement the Template Method by creating a Hot Drink Preparer. The backbone methods 
 * will be:
 * 		1) boilWater()
 * 		2) brewDrink()
 * 		3) pourIntoCup()
 *  	4) addCondiments()
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

package test;

import drink.*;

public class Test {
	
	public static void main(String[] args) {
		CoffeeMaker		  myCoffee  = new CoffeeMaker();
		TeaMaker 		  myTea 	= new TeaMaker();
		HotChocolateMaker myChoco 	= new HotChocolateMaker();
		
		System.out.println("Make a coffee!");
		myCoffee.makeDrink();
		
		System.out.println("\nMake a tea!");
		myTea.makeDrink();
		
		System.out.println("\nMake a hot chocolate!");
		myChoco.makeDrink();
	}
}
