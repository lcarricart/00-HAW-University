package textConversion;

public class UpLowConverter extends GeneralConverter {

	@Override
	protected String applyCaseConversion(String txt) {
		String conversion1 = txt.toLowerCase();
		return conversion1;
	}
	
	// In Java you cant modify characters in a String the way you can in C. You can create a char[] array first, and do a similar manipulation
	// char type is a primitive type and has no instance methods of its own. You can use static helpers onf the Character wrappper?
	@Override
	protected String enhanceConvertedText(String txt) {
		String conversion2;
		char[] myCharArray = txt.toCharArray();
		char upperCharacter;
		
		// Its more efficient to ommit the if() and run the for loop every i = i + 2, but less clear
		for (int i = 0; i < txt.length(); i++) {
			if (i % 2 == 0) {
				upperCharacter = Character.toUpperCase(myCharArray[i]);
				myCharArray[i] = upperCharacter;
			}
		}
		
		conversion2 = new String(myCharArray);
		return conversion2;
	}
}
