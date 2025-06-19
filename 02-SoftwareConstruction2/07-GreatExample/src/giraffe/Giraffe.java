package giraffe;

import java.awt.Point;

import background.LocatedRectangle;
import background.Speed;
import scene.Drawing;

import java.awt.Color;

public class Giraffe implements LocatedRectangle {
	private int width;
	private int height;
	private Point location;
	private Head head; //composite
	private Body body; //composite
	private Neck neck; //composite
	private Point speed;
	private ColorGiraffe[] color;
	
	public Giraffe(Point address, int width, int height, Color color) {
		location = address;
		this.width = width; //width of the entire figure
		this.height = height; //height of the entire figure
		neck = new Neck(width, height, color);
		head = new Head(width, height, color);
		body = new Body(width, height, color);
	}
	
	

	@Override
	public Point address() {
	    return location;
	}
	
	@Override
	public int width(){
	    return (head.getWidth() + body.getWidth());
	}
	
	@Override
	public int height (){
	    return (head.getHeight() + body.getHeight() + neck.getHeight());
	}
	
	@Override
	public void draw() {
		drawAt(location.x, location.y);
	}
	
	public void drawAt(int left, int bottom) {
		head.drawAt(left, bottom);
		neck.drawAt(left, bottom);
		body.drawAt(left, bottom);
		//Drawing.pen().drawRect(left, bottom, head.getWidth() + body.getWidth(), head.getHeight() + body.getHeight() + neck.getHeight());
	}

	public void setColor(ColorGiraffe[] color) {
		this.color = color;
	}

	public void changeSnout() {
		head.changeSnout();
	}

	@Override
	public Point direction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAddress(Point location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDirection(Point direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpeed(Point speed) {
		this.speed=new Point(speed.x, speed.y);
	}

	@Override
	public Point getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}
	
	
}