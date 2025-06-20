package chick;

import java.awt.Color;

import scene.Drawing;

public class Leg {
	private Claw claw;	//composite
	private int width;
	private int height;
	private int legNumber;
	
	public Leg(int width, int height, int legNumber) {
		this.width=width/25;
		this.height=height/3;
		this.legNumber=legNumber;
		claw = new Claw(width, height);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.orange);
		Drawing.pen().fillRect(left+(6+legNumber*5)*3*width/4, bottom+height/5, width, height);
		claw.drawAt(left+(6+legNumber*5)*3*width/4, bottom+height/5+height);
	}
}
