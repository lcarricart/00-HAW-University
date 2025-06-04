package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Tail {
	private double lenght;
	private static final Color LIGHT_GRAY = new Color(224, 224, 224);
	
	public Tail(double lenght) {
		this.lenght = lenght;
	}
	
	public void drawAt (double left, double bottom)
	{
		Drawing.getPen().setColor(LIGHT_GRAY);
		Drawing.getPen().fillOval((int) left, (int) bottom, (int) lenght, (int) lenght);
	}
}
