package aMain;

import java.util.ArrayList;

import setSlides02.*;
import setSlides04.*;
import setSlides05.*;
import setSlides07.*;
import setSlides07_2.*;
import setSlides08.*;
import setSlides09.*;
import setSlides10.*;

public class TestClass {
//	------------------------- setSlides4 -------------------------
	private static ArrayList<Message> allMessages = new ArrayList<Message>();	// I use static so the compiler doesnt complain, but it makes sense anyway bc the testClass is only one, so static doesnt change anything
//	------------------------- setSlidesX -------------------------
	
	
	
	public static void main(String[] args) {

//		------------------------- setSlides2 -------------------------
//      BankAccount alice = new BankAccount(1_000);
//      BankAccount bob   = new BankAccount(2_000);
//
//      System.out.println(alice.yearlyInterest()); // 20.0
//      System.out.println(bob.yearlyInterest());   // 40.0
//
//      BankAccount.setAnnualInterestRate(0.03);   // one call, changes all
//
//      System.out.println(alice.yearlyInterest()); // 30.0
//      System.out.println(bob.yearlyInterest());   // 60.0
		
//		------------------------- setSlides4 -------------------------
//		EmailMessage emailMessage = new EmailMessage("Luciano", "PostOffice", "Dear department");
//		SmsMessage smsMessage = new SmsMessage("Luciano", "Amani", "Dear wife");
//		
//		allMessages.add(emailMessage);
//		allMessages.add(smsMessage);
//		
//		for (Message aMessage : allMessages) {
//			aMessage.send();
//		}
		
//		------------------------- setSlides5 -------------------------
//		Resizable[] picturesArray = {
//			new Photo(1, 1),
//			new Poster(3, 2, "John Mayer")
//		};
//		
//		for (Resizable aPicture : picturesArray) {
//			System.out.println("Original size: " + aPicture.getWidth() + " x " + aPicture.getHeight());
//		}
//		
//		Photo pic1 = (Photo) picturesArray[0];
//		pic1.resize(2);
//		System.out.println("New size of picture 1: " + pic1.getWidth() + " x " + pic1.getHeight());
//		
//		Poster pic2 = (Poster) picturesArray[1];
//		
//		if (pic1.fitsInside(pic2)) {
//			System.out.println("Picture 1 fits inside picture 2");
//		} else {
//			System.out.println("Picture 1 DOESNT fit inside picture 2");
//		}
		
//		------------------------- setSlides7 -------------------------	
//		Shape[] shapes = {
//			    new Rectangle("poster",  3, 2),
//			    new Rectangle("screen", 16, 9),
//			    new Circle   ("coin",   1)
//			};
//		for (Shape s : shapes) { s.report(); }
		
//		------------------------- setSlides7.2 -------------------------
//		Text t = new BracketDecorator(new BoldDecorator(new BracketDecorator(new PlainText("hello"))));
//		System.out.println(t.render());
		
//		------------------------- setSlides8 -------------------------
//		TrafficLight mySemaphore = new TrafficLight();
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.println(mySemaphore.display());
//			mySemaphore.tick();
//		}
//		
//		------------------------- setSlides9 -------------------------
//		CoffeeMachine cm = null;
//		
//		try {
//			cm = new CoffeeMachine(400, 50);
//			
//		    cm.brew(CoffeeType.ESPRESSO);
//		    cm.brew(CoffeeType.AMERICANO);
//		    cm.brew(CoffeeType.LATTE);        // triggers exception
//		} catch (OutOfIngredientException ex) {
//		    System.out.println("\nMachine error: " + ex.getMessage());
//		} finally {
//			if (cm != null) {
//				cm.close();
//			}
//		}
//		
//		------------------------- setSlides10 -------------------------
		WeatherStation ws = new WeatherStation();
		Observer c  = new ConsoleDisplay(ws);
		Observer f  = new FahrenheitDisplay(ws);

		ws.attach(c);
		ws.attach(f);

		ws.setTemperature(20);   // should print both °C and °F
		ws.setTemperature(30);   // prints updated values

		ws.detach(c);
		ws.setTemperature(25);   // only °F display prints
				
	}
}
