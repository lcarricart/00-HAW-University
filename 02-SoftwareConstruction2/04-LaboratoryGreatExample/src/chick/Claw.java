package chick;

import scene.Drawing;

public class Claw {
	private int height;
	private int width;
	
	public Claw(int width, int height) {
		this.height=height/11;
		this.width=width/10;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().fillRect(left-6*width/10, bottom, width, height);
	}
}