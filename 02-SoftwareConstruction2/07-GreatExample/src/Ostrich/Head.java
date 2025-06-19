package Ostrich;

import java.awt.Color;

import scene.Drawing;

public class Head {
	private Eye ostrichEye;
	private Beak ostrichBeak;
	private HeadBase ostrichHeadBase;
	private Neck ostrichNeck;
	private int width, height;
	private Color headColor;
	
	public Head(int size, Color headColor) {
		this.width = size;
		this.height = size;
		this.headColor = headColor;
		ostrichBeak = new Beak(width);
		ostrichNeck = new Neck(width/4, height*4);
		ostrichHeadBase = new HeadBase(width, height);
		ostrichEye = new Eye(width, height); 
	}
	// creates default head(Size: 40, Color:light pink skin) 
	public Head() {
		this.width = 40;
		this.height = 40;
		this.headColor = Color.decode("#c2a9bd");
		this.ostrichNeck = new Neck(this.width/4, this.height*4);
		ostrichHeadBase = new HeadBase(width, height);
		ostrichEye = new Eye(width, height); 
	}
	
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(headColor);
		ostrichNeck.drawNeckAt(x + (width-width/2), y + (height-height/2));
		ostrichHeadBase.drawAt(x, y);
		ostrichEye.drawEyeAt(x + width/6, y + height/10);
		ostrichBeak.drawBeak(x + width/10, y + (height-(height/4))); 
		 // play with 2 & 3 for x offset
		
	}
	
	public int getWidth() {
		return this.width; 
	}
	
	public int getHeight() {
		return this.height; 
	}

}
