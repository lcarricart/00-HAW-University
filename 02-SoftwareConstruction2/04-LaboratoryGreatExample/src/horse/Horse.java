package horse;

import java.awt.*;

import background.LocatedRectangle;
import background.Speed;

public class Horse implements LocatedRectangle{ // composite
	private int width;
	private int height;
	private Point point;
	private Point locatedRectPoint;
	private Torso torso; // composite
	private Head head; // composite
	private Color color;

	public Horse(int width, int height, Point point, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
		this.point = new Point(point.x, point.y);
		this.locatedRectPoint = new Point(this.point.x - this.width / 4, this.point.y - this.height);
		this.torso = new Torso(this.width, this.height, this.point, this.color);
		this.head = new Head(this.width / 4, this.width / 2, new Point(this.point.x, this.point.y - (this.width / 3)), this.color);
	}
	
	public void drawAt() {
		this.torso.drawAt();
		this.head.drawAt();
	}

	@Override
	public Point address() {
		return this.locatedRectPoint;
	}

	@Override
	public int width() {
		return (int)(this.width * 1.5);
	}

	@Override
	public int height() {
		return this.height * 3;
	}

	@Override
	public void draw() {
		this.drawAt();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getSpeed() {
		// TODO Auto-generated method stub
		return null;
	}

}