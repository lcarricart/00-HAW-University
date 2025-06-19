package Ostrich;
import java.awt.Color;
import java.awt.Point;

import background.LocatedRectangle;
import background.Speed;

public class Ostrich implements LocatedRectangle {
	private Head ostrichHead;
	private Body ostrichBody;
	private Point location;
	private Color outer;
	private Point speed;
	private int bodySize; 
	
// instanciate with a location	
	public Ostrich(int size, int x, int y, Color skin, Color inner, Color outer) {
		location = new Point(x, y); 
		bodySize = size;
		this.outer = outer;
		ostrichHead = new Head(size/3, skin);
		ostrichBody = new Body(size, skin, inner, outer);
		
	}
// instanciate with a point
		public Ostrich(int size, Point location, Color skin, Color inner, Color outer, Point speed) {
			this.location = location; 
			bodySize = size;
			this.outer = outer;
			this.speed=speed;
			ostrichHead = new Head(size/3, skin);
			ostrichBody = new Body(size, skin, inner, outer);
			
		}

// no location provided
	public Ostrich(int size, Color skin, Color inner, Color outer) {
		location = null; 
		bodySize = size;
		this.outer = outer;
		ostrichHead = new Head(size/3, skin);
		ostrichBody = new Body(size, skin, inner, outer);
		
	}
	
	public void setSpeed(Point speed) {
		this.speed =new Point(speed.x, speed.y);
	}
	
	public Point getSpeed() {
		Point speed;
			speed = new Point(this.speed.x, this.speed.y);
		return speed;
	}
	
	public void addHat(Hat hat) {
		hat.drawRegular(); 
	}
	
	
	public void drawAt(int x, int y) {
		ostrichHead.drawAt(x, y);
		ostrichBody.drawAt(x + bodySize/3, y + (bodySize*3/2 - bodySize/5));
		
	}
	
	public Color getOuterColor() {
		return outer;
	}

	@Override
	public Point address() {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return bodySize*2;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return bodySize*3;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		location.x+=speed.x;
		location.y+=speed.y;
		this.drawAt(location.x, location.y);
		
	}
	@Override
	public Point direction() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAddress(Point location) {
		// TODO Auto-generated method stub
		this.location=location;
		
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

	

}
