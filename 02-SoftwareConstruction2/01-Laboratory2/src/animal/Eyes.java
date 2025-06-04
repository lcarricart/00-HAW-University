package animal;

import java.awt.Color;

public class Eyes extends EyeShape {
	private Iris dogIris;		//composite
	
	public Eyes(double size) {
		super(size, Color.WHITE);
		double irisSize = size / 2;
		
		dogIris = new Iris(irisSize);
	}
	
	public void drawAt(double left, double bottom) {
		super.drawAt(left, bottom);
		dogIris.drawAt(left, bottom);
	}
}