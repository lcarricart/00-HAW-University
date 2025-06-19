package chick;

import java.awt.Color;

import scene.Drawing;

public class LowerBody {
	private Leg legLeft;	//composite
	private Leg legRight;	//composite
	private int height;
	private int width;
	
	public LowerBody(int width, int height) {
		this.width=7*width/10;
		this.height=height/15;
		legLeft = new Leg(width, height, 1);
		legRight = new Leg(width, height, 2);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.black);
		Drawing.pen().fillRect(left+(width/9), bottom+9*height, width, height);
		legLeft.drawAt(left+(width/9), bottom+9*height);
		legRight.drawAt(left+(width/9), bottom+9*height);
	}
}
