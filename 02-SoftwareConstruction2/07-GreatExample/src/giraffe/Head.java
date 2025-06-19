package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Head {
	
	private int width;
	private int height;
	private Color color;
	private Eye rightEye; //aggregate
	private Eye leftEye; //aggregate
	private Snout snout; //aggregate
	private Ear rightEar; //aggregate
	private Ear leftEar; //aggregate
	private EarCanal earCanal; //aggregate
	private Ossicone rightOssicone; //aggregate
	private Ossicone leftOssicone; //aggregate
	
	public Head(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
		rightEye = new Eye(width, height, color);
		leftEye = new Eye(width, height, color);
		snout = new Snout(width, height);
		rightEar = new Ear(width, height, color);
		leftEar = new Ear(width, height, color);
		earCanal = new EarCanal(width,height, color);
		rightOssicone = new Ossicone(width, height, color);
		leftOssicone = new Ossicone(width, height, color);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillOval(left + 27 * width/2, bottom - height/2, width * 600/100, height * 500/100);
		Drawing.pen().fillOval(left + 30 * width/2, bottom + 7 * height/3, width * 700/100, height * 295/100);
		
		rightOssicone.drawAt(left + 16 * width, bottom - 2 * height);
		leftOssicone.drawAt(left + 29 * width/2, bottom - 2 * height);
		snout.drawAt(left + 39 * width/2, bottom + 5 * height/2);
		rightEar.drawAt(left + 35 * width/2, bottom - 3 * height/4);
		leftEar.drawAt(left + 25 * width/2, bottom);
		earCanal.drawAt(left + 51 * width/4, bottom + height/4);
		rightEye.drawAt(left + 37 * width/2, bottom + 1 * height/2);
		leftEye.drawAt(left + 34 * width/2, bottom + 1 * height/2);
	}
	
	public int getHeight() {
	    return (5 * height) + rightOssicone.getHeight();
	}
	
	public int getWidth() {
	    return (15 * width) - (7 * width);
	}

	public void changeSnout() {
		snout.setTongueVisible( !snout.isTongueVisible() );
	}
}
