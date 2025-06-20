package textConversion;

public abstract class GeneralConverter {
	// This "superclass" constructor is actually calling super() from the parent class Object(). Object is ultimately a parent of all classes ever created.
	// The protected word indicates that it is only visible to subclasses. 
	// This constructor is generally not needed because one understands that abstract classes are not instantiatable.
	// protected GeneralConverter() { }
	
	// Fixed workflow, defined as final
	public final void convertText(String text) {
		String convertedText;
		
		printOriginal(text);
		convertedText = applyCaseConversion(text);
		convertedText = enhanceConvertedText(convertedText);
		printConverted(convertedText);
	}
	
	// Defined as final, can't be changed
	protected final void printOriginal(String txt) {
		System.out.printf("\nOriginal text: %s\n", txt);
	}
	
	// Forces subclasses to have their own implementation
	protected abstract String applyCaseConversion(String txt);
	
	// A hook with a default "do-nothing" implementation that subclasses may override
	protected String enhanceConvertedText(String convTxt) {
		return convTxt;
	}
	
	// Can't be changed
	protected final void printConverted(String convTxt) {
		System.out.printf("Converted text: %s\n", convTxt);
	}
}
