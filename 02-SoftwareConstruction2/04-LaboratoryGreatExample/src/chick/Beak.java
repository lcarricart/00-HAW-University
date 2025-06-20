package chick;

import java.awt.Color;

import scene.Drawing;

public class Beak {
	private int height;
	private int width;
	
	public Beak(int width, int height){
		this.width=width/4;
		this.height=height/12;
	}
		
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.orange);
		Drawing.pen().fillRect(left-width/2, bottom+2*height, width, height);
	}
}
