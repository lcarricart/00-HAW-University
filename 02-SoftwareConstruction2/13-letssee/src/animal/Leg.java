package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Leg
{
	private double lenght;
	private double width;
	private Paw dogPaw;		//composite
	private Fur dogFur;		//aggregate
	
	public Leg(double lenght, Fur dogFur) 
	{
		this.lenght = lenght;
		this.width = lenght / 6;
		this.dogFur = dogFur;
		
		dogPaw = new Paw(width);
	}
	
	public void drawAt(double left, double bottom) 
	{
		int shape = 1;		//rectangle
		
		Drawing.getPen().setColor(Color.LIGHT_GRAY);
		Drawing.getPen().drawRect((int) left, (int) bottom, (int) (width), (int) (lenght));
		Drawing.getPen().fillRect((int) left, (int) bottom, (int) (width), (int) (lenght));
		
		dogFur.draw((int) left, (int) bottom, width, lenght, shape);
		dogPaw.drawAt(left, (bottom + lenght));
	}
}
