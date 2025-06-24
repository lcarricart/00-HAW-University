package test;

import java.awt.Color;
import java.awt.Point;

public class House implements LocatedRectangle {
	private int x;
	private int y;
	private int width;
	private int height;
	private Facade facade; // composite
	private Roof roof; // composite
	
	public House(int x, int y, int width, int height, Color facadeColor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		facade = new Facade(width, height, facadeColor);
		roof = new Roof(width, height/4);
	}
	
	public void drawAt(int left, int bottom) {
		facade.drawAt(left, bottom);
		roof.drawAt(left, bottom);
	}

	public void draw() {
		drawAt(x, y);
	}

	@Override
	public Point address() {
		return new Point(x, y);
	}

	@Override
	public int width() {
		return width;
	}

	@Override
	public int height() {
		return height + roof.getHeight();
	}
}