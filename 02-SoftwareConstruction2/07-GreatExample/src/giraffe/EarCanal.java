package giraffe;

import java.awt.Color;

import scene.Drawing;

public class EarCanal extends BlackOval{

	public EarCanal(int width, int height, Color color) {
		super (width, height, color);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(getColor());
		Drawing.pen().fillOval(left, bottom, getWidth() * 70/100, getHeight() * 80/100);
	}
}
