package animal;

import java.awt.Color;

import drawingTool.Drawing;

public class EyeShape {
	private double size;
	private Color color;
	
	public EyeShape(double size, Color color) {
		this.size = size;
		this.color = color;
	}
	
	public void drawAt(double left, double bottom) {
		Drawing.getPen().setColor(color);
		Drawing.getPen().drawOval((int) left, (int) bottom, (int) size, (int) size);
		Drawing.getPen().fillOval((int) left, (int) bottom, (int) size, (int) size);
	}
}
