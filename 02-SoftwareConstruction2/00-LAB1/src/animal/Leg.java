package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Leg
{
	private double lenght;
	private double width;
	private Paw dogPaw;
	
	public Leg(double lenght) 
	{
		this.lenght = lenght;
		this.width = lenght / 6;
		dogPaw = new Paw(width);
	}
	
	public void drawAt(double left, double bottom) 
	{
		Drawing.getPen().setColor(Color.LIGHT_GRAY);
		Drawing.getPen().drawRect((int) left, (int) bottom, (int) (width), (int) (lenght));
		Drawing.getPen().fillRect((int) left, (int) bottom, (int) (width), (int) (lenght));
		
		dogPaw.drawAt(left, (bottom + lenght));
	}
}
