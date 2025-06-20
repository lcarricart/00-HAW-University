package chick;

import java.awt.Color;
import java.awt.Point;

import background.LocatedRectangle;
import background.Speed;
import scene.Drawing;

public class Chick implements LocatedRectangle {

	private UpperBody upperBody; // composite
	private LowerBody lowerBody; // composite
	private Point location;
	private int height;
	private int width;
	private Color color;
	private Point chickSpeed;
	private int id;

	public Chick(Point address, int width, int height, Color color, Point chickSpeed, int id) {
		this.chickSpeed = chickSpeed;
		this.color = color;
		this.width = width;
		this.height = height;
		this.id = id;
		height = height * 5 / 8;
		width = width * 5 / 6;
		location = new Point(address.x, address.y);
		upperBody = new UpperBody(width, height, color);
		lowerBody = new LowerBody(width, height);
	}

	public int getID() {
		return id;
	}

	public void drawAt(int left, int bottom) {
		lowerBody.drawAt(left + (3 * width / 9) * 5 / 6, bottom + (height / 2) * 5 / 8);
		upperBody.drawAt(left + (3 * width / 9) * 5 / 6, bottom + (height / 2) * 5 / 8, this.color);
	}

	public void drawAt(int left, int bottom, Color color) {
		lowerBody.drawAt(left + (3 * width / 9) * 5 / 6, bottom + (height / 2) * 5 / 8);
		upperBody.drawAt(left + (3 * width / 9) * 5 / 6, bottom + (height / 2) * 5 / 8, this.color);
	}

	public Point address() {
		return new Point(location);
	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}

	public boolean intersects(LocatedRectangle other) {
		return intersects(other, 0);
	}

	public void draw() {
		setAddress(location.x+chickSpeed.x, location.y+chickSpeed.y);
		drawAt(location.x, location.y);
	}

	public Color getColor() {
		return color;
	}

	public void setSpeed(Point speed) {
		chickSpeed = new Point(speed.x, speed.y);
	}

	public void setAddress(int x, int y) {
		location = new Point(x, y);
	}

	@Override
	public Point direction() {
		// TODO Auto-generated method stub
		return new Point(0,0);
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
	public Point getSpeed() {
		// TODO Auto-generated method stub
		return chickSpeed;
	}

}
