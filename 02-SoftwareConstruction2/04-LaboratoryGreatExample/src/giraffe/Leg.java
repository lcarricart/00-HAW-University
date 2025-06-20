package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Leg {

	private int width;
	private int height;
	private Color color;
	private Hoof hoof; //aggregate
	
	public Leg(int width, int height, Color color) {
		this.width = width * 150/100;
		this.height = height * 1400/100;
		this.color = color;
		hoof = new Hoof(width, height);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(left, bottom, width, height); 
		hoof.drawAt(left, bottom + height);
	}
	
	public int getHeight() {
	    return height + hoof.getHeight();
	}

}
