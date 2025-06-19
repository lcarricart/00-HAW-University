package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Eyeball {
	private int width;
	private int height;
	private Color color;
	private Pupil pupil; //aggregate

	public Eyeball(int width, int height) {
		this.width = width * 150/100;
		this.height = height * 190/100;
		pupil = new Pupil(width, height, color);
	}
		
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.decode("#ffffff"));
		Drawing.pen().fillOval(left, bottom, width, height);
		pupil.drawAt(left + 1 * width/2, bottom + 1 * height/4);
	}
}
