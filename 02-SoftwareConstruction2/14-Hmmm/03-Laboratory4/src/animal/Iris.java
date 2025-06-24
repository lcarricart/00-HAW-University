package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Iris {
	private double size;
	
	public Iris(double size)
	{
		this.size = size;
	}
	
	public void drawAt(double left, double bottom)
	{
		Drawing.getPen().setColor(Color.BLACK);
		Drawing.getPen().drawOval((int) left, (int) bottom, (int) size, (int) size);
		Drawing.getPen().fillOval((int) left, (int) bottom, (int) size, (int) size);
	}
}
