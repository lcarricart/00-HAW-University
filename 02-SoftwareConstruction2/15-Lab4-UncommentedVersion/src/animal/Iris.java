package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Iris {
	private double size;
	private Color chosenColor;
	private Color classicColor = Color.BLACK;
	
	public Iris(double size, Color chosenColor)
	{
		this.size = size;
		this.chosenColor = chosenColor;
	}
	
	public void drawAt(double left, double bottom)
	{
		Drawing.getPen().setColor(chosenColor);
		Drawing.getPen().drawOval((int) left, (int) bottom, (int) size, (int) size);
		Drawing.getPen().fillOval((int) left, (int) bottom, (int) size, (int) size);
		
		chosenColor = classicColor;
	}
}
