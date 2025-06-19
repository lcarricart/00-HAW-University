package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Ossicone {
	private int width;
	private int height;
	private Color color;

	public Ossicone(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillOval(left, bottom, width * 140/100, height * 740/100);
		Drawing.pen().setColor(Color.decode("#000000"));
		Drawing.pen().fillOval(left + 1 * height/4, bottom - 3 * height/4, width, height);
	}
	
	public int getHeight() {
	    return height;
	}

}