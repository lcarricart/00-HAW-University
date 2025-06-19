package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Nostril extends BlackOval {

	public Nostril(int width, int height, Color color) {
		super (width, height, color);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(getColor());
		Drawing.pen().fillOval(left, bottom, getWidth() * 50/160, getHeight() * 100/260);
	}
}
