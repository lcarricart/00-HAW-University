package chick;

import java.awt.Color;

import scene.Drawing;

public class Eye {
	private int height;
	private int width;
	private Color color;
	
	public Eye(int width, int height, Color color) {
		this.width=width/10;
		this.height=height/10;
		this.color=color;
	}
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillOval(left+2*width, bottom+height, width, height);
	}
	
	public Color getColor() {
		return color;
	}
}
