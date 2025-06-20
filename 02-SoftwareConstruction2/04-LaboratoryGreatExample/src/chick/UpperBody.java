package chick;

import java.awt.Color;

import scene.Drawing;

public class UpperBody {
	private Head head;	//composite
	private Wing wing;	//composite
	private Tail tail;	//composite
	private int height;
	private int width;
	public UpperBody(int width, int height, Color color){
		this.width=8*width/10;
		this.height=6*height/10;
		head = new Head(width, height, color);
		wing = new Wing(width, height);
		tail = new Tail(width, height, color);
	}

	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.white);
		Drawing.pen().fillRect(left, bottom, width, height);
		head.drawAt(left, bottom);
		wing.drawAt(left, bottom);
		tail.drawAt(left, bottom);
	}
	
	public void drawAt(int left, int bottom, Color color) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(left, bottom, width, height);
		tail.drawAt(left, bottom, color);
		head.drawAt(left, bottom, color);
		wing.drawAt(left, bottom);
	}
}