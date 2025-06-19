package chick;

import java.awt.Color;

import scene.Drawing;

public class Tail {
	private int height;
	private int width;
	public Tail(int width, int height, Color color) {
		this.width=width/6;
		this.height=6*height/10;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.white);
		Drawing.pen().fillRect(left+42*width/10, bottom-height/3, width, height);

	}
	
	public void drawAt(int left, int bottom, Color color) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(left+42*width/10, bottom-height/3, width, height);
	}
}
