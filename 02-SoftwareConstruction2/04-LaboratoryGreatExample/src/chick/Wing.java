package chick;

import java.awt.Color;

import scene.Drawing;

public class Wing {
	private int height;
	private int width;
	
	public Wing(int width, int height) {
		this.width=width;
		this.height=height;
	}
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawLine(left+2*width/10, bottom, left+4*width/10, bottom+(4*height/10));
		Drawing.pen().drawLine(left+4*width/10, bottom+(4*height/10), left+8*width/10, bottom+(5*height/10));
	}
}
