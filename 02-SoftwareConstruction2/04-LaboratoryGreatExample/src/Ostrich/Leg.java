package Ostrich;

import java.awt.Color;

import scene.Drawing;

public class Leg {
	private int width, height;
	private Color legColor;
	
	public Leg(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		legColor = color;
	}
	
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(legColor);
		Drawing.pen().fillRect(x, y, width, height);
		Drawing.pen().fillRect(x-(width+(width/2)), y+height, height/8, width - (width*1/5));
		Drawing.pen().setColor(Color.orange);
		Drawing.pen().fillRect(x-(width*2), y+(height+height/40), height/18, width/3);
	}

}
