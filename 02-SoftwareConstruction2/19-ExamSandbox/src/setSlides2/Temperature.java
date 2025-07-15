package setSlides2;

public class Temperature {
	private Temperature() { }
	
	public static double toFahrenheit(double celsius) {
		return celsius * 9/5 + 32;
	}
	
	public static double toCelcius(double fahrenheit) {
		return (fahrenheit - 32) * 5/9;
	}
}

/* Case 1: This is a good example of static methods, or class methods. These cases are used for
 * pure functions that depend only on its parameters. The moment that they depend on
 * properties, the usecase does not apply anymore.
 * 
 * Case 2: Class-wide information. Aggregates or reports data about the class as a whole,
 * not a single object. In that case, even if the function has a lot of properties and
 * complex behaviors, a static method could be used to change the value of that static
 * property. That works, but conceptually, some may argue that usning a Singleton would
 * be a better approach. 
 * 
 * Also, do not use static methods if overriding in subclasses is possible.
*/