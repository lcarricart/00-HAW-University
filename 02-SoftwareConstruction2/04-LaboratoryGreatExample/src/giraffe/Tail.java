package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Tail {

	private int width;
	private int height;
	private Color color;
	private Tailhair tailhair; //aggregate
	
	public Tail(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
		tailhair = new Tailhair(width, height);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(left, bottom, width * 70/100, height * 1000/100);
		tailhair.drawAt(left, bottom + 10 * height);
	}

	public int getWidth(){
	    return width;
	}
}
