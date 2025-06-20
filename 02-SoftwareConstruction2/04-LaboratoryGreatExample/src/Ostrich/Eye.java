package Ostrich;

import java.awt.Color;

import scene.Drawing;

public class Eye {
	
	private Sclera sclera;
	private Iris iris;
	private int width, height;
	
	public Eye(int headWidth, int headHeight) {
		this.width = headWidth;
		this.height = headHeight;
		this.sclera = new Sclera(headWidth * 1/4, headHeight * 1/4);
		this.iris = new Iris(headWidth * 1/8, headHeight * 1/8); //10
	}
	
	public void drawEyeAt(int x, int y) {
		Drawing.pen().setColor(Color.white);
		sclera.drawAt(x, y);
		Drawing.pen().setColor(Color.black);
		iris.drawAt(x + width/13, y + height/12);
	}
	
}

