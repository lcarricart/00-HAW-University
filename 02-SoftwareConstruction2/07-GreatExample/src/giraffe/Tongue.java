package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Tongue {
	private int width;
	private int height;
	private Color color;

	public Tongue(int width, int height, Color color) {
		this.width = width * 2;
		this.height = height * 5;
		this.color = color;
	}	
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.red);
		Drawing.pen().fillOval(left, bottom, width, height );

	}
}


