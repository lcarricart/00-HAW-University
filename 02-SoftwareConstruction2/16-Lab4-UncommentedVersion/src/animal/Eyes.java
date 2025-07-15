package animal;

import java.awt.Color;

import drawingTool.Drawing;

public class Eyes {
	private Iris dogIris;				//composite
	
	private Color eyeColor = Color.WHITE;
	private double size;
	
	public Eyes(double size, Color chosenIrisColor) {
		double irisSize = size / 2;
		this.size = size;
		
		dogIris = new Iris(irisSize, chosenIrisColor);
	}
	
	public void drawAt(double left, double bottom) {
		Drawing.getPen().setColor(eyeColor);
		Drawing.getPen().drawOval((int) left, (int) bottom, (int) size, (int) size);
		Drawing.getPen().fillOval((int) left, (int) bottom, (int) size, (int) size);
		
		dogIris.drawAt(left, bottom);
	}
}