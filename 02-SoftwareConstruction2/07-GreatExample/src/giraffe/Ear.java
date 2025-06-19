package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Ear {
	private int width;
	private int height;
	private Color color;

	public Ear(int width, int height, Color color) {
		this.width = width * 160/100;
		this.height = height * 260/100;
		this.color = color;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillOval(left, bottom, width, height);
	}
}