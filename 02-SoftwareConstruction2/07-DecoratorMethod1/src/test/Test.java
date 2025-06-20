/*******************************************************************************************************************
 * Objective of the program: Implement the Decorator Method by 
 *******************************************************************************************************************
 * Theory: Decorators (or Wrappers) provide a flexible alternative to subclassing for extending functionality, by 
 * attaching additional responsibilities to an object dinamically. 
 * 
 * Use a Decorator for responsibilities that can be withdrawn (decorations).
 *******************************************************************************************************************
 * Motivation: Sometimes we wanna add responsibilities to individual objects, not to an entire class. For example, a
 * graphical user interface toolkit should let you add properties like border or behaviors, such as scrolling, to any
 * component. The goal is to add responsibilities to an object <after> it has been created, without touching its class
 * or rewriting huge inheritance trees. The typical alternative creates class <explosions> since it locks behaviors at
 * compile-time (e.g.: CoffeeWithMilkAndSugarAndSoy). The decorator keeps one interface constant and composes
 * independent, stackable wrappers at runtime.
 * 
 * One way to add responsibilities is with inheritance. Inheriting a border from annother class puts a border around
 * every subclass instance. This is inflexible, however, because the choice of border is made statically. A client
 * can't control how and when to decorate the component with a border.
 * 
 * A more flexible approach is to enclose the component in another object that adds the border. The enclosing object
 * is called a decorator. The decorator conforms to the interface of the component it decorates so that its presence
 * is transparent to the component's client. The decorator forwards requests to the component and may perform
 * additional actions, such as drawing a border, before or after forwarding. Transparency lets you nest decorators 
 * recursively, thereby allowing an unlimited number of added responsibilities.
 *******************************************************************************************************************
 * Key Participants:
 * 		- Component Interface: VisualComponent, defines the interface for objects that can have responsibilities added
 *		to them dynamically.
 *		- Concrete Component: TextView, defines an object to which additional responsibilities can be attached.
 *		- Decorator (base class): holds a reference to a Component object and defines the interface that conforms to
 *		Component's interface (VisualComponent).
 *		- Concrete Decorator: BorderDecorator / ScrollDecorator, adds responsibilities to the component.
 *******************************************************************************************************************
 * Example: Suppose we have a TextView object that displays text in a window. TextView has no scroll bars by default,
 * because we might not always need them. When we do, we can use a ScrollDecorator to add them. Suppose we also want
 * to add a thich black border around the TextView. We can use BorderDecorator to add this as well. 
 * 
 * ScrollDecorator and BorderDecorator classes are subclasses of Decorator, and abstract class for visual components
 * that decorate other visual components. 
 * 		- BorderDecorator(ScrollDecorator(TextView));
 * 		- ScrollDecorator(BorderDecorator(TextView));
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

package test;

import pizza.*;

public class Test {
	public static void main(String[] args) {
		Margherita		myMarga   = new Margherita();
		QuattroFormaggi myQuattro = new QuattroFormaggi();
		
		System.out.println("The cost of a Margherita is $" + myMarga.cost());
		System.out.println("The ingredients of a Margherita are: " + myMarga.description() + "\n");
		
		System.out.println("The cost of a Quattro Formaggi is $" + myQuattro.cost());
		System.out.println("The ingredients of a Quattro Formaggi are: " + myQuattro.description() + "\n");
	}
}
