package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Hoof {

	private int width;
	private int height;
	
	public Hoof(int width, int height) {
		this.width = width * 150/100;
		this.height = height;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.decode("#000000"));
		Drawing.pen().fillRect(left, bottom, width, height);
	}

	public int getHeight (){
	    return height;
	}

}