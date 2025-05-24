package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Eyes 
{
	private double size;
	private Iris dogIris;
	
	public Eyes(double size) 
	{
		this.size = size;
		double eyeSize = size / 2;
		
		dogIris = new Iris(eyeSize);
	}
	
	public void drawAt(double left, double bottom) 
	{
		Drawing.getPen().setColor(Color.WHITE);
		Drawing.getPen().drawOval((int) left, (int) bottom, (int) size, (int) size);
		Drawing.getPen().fillOval((int) left, (int) bottom, (int) size, (int) size);
		
		dogIris.drawAt(left, bottom);
	}
}