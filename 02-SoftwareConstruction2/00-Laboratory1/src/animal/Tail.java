package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Tail {
	private double lenght;
	private Color lightGray = new Color(224, 224, 224);
	
	public Tail(double lenght) {
		this.lenght = lenght;
	}
	
	public void drawAt (double left, double bottom)
	{
		Drawing.getPen().setColor(lightGray);
		Drawing.getPen().drawOval((int) left, (int) bottom, (int) lenght, (int) lenght);
		Drawing.getPen().fillOval((int) left, (int) bottom, (int) lenght, (int) lenght);
	}
}
