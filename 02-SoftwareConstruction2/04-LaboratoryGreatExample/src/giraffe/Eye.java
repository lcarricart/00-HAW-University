package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Eye extends BlackOval{

	private Eyeball eyeball; //aggregate

	public Eye(int width, int height, Color color) {
		super (width, height, color);
		eyeball = new Eyeball(width, height);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(getColor());
		Drawing.pen().fillOval(left, bottom, getWidth(), getHeight());
		eyeball.drawAt(left, bottom + getHeight()/4);
	}
}
