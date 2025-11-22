package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Tail {
	private double lenght;
	private Fur dogFur;
	private final Color LIGHT_GRAY = new Color(224, 224, 224);
	
	public Tail(double lenght, Fur dogFur) {
		this.lenght = lenght;
		this.dogFur = dogFur;
	}
	
	public void drawAt (double left, double bottom)
	{
		int shape = 0;		//oval
		
		Drawing.getPen().setColor(LIGHT_GRAY);
		Drawing.getPen().fillOval((int) left, (int) bottom, (int) lenght, (int) lenght);
		
		dogFur.draw((int) left, (int) bottom, lenght, lenght, LIGHT_GRAY, shape);
	}
	
	public double getWidth() {
		return lenght - lenght/3; // tail - embedded tail
	}
}
