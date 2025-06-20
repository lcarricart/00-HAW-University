package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Tailhair {

	private int width;
	private int height;
	
	public Tailhair(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.decode("#000000"));
		Drawing.pen().fillRect(left, bottom, width * 70/100, height * 500/100);
	}
}
