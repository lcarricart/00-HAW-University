package background;

import java.awt.Color;
import java.awt.Point;

import scene.Drawing;

public class FenceRow implements LocatedRectangle {
	private int width;
	private Point location;
	
	public FenceRow(Point location, int width, int height) {
		this.width=width;
		this.location=location;
	}
	
	
	public void drawAt() {
		Drawing.pen().setColor(new Color(165,42,42,255));
		Drawing.pen().fillRect(location.x-20, location.y, width+40, 15);
		Drawing.pen().fillRect(location.x-20, location.y+25, width+40, 15);
		Drawing.pen().setColor(new Color(128,0,0,255));
		for(int i=0; i<10; i++)
			Drawing.pen().fillRect(location.x-20+i*(width+40)/10, location.y-2, 20, 52);
	}
	
	public void drawAt(int pillars) {
		Drawing.pen().setColor(new Color(165,42,42,255));
		Drawing.pen().fillRect(location.x-20, location.y, width+40, 15);
		Drawing.pen().fillRect(location.x-20, location.y+25, width+40, 15);
		Drawing.pen().setColor(new Color(128,0,0,255));
		for(int i=0; i<pillars; i++)
			Drawing.pen().fillRect(location.x-20+i*(width+40)/pillars, location.y-2, 20, 52);
	}

	@Override
	public Point address() {
		// TODO Auto-generated method stub
		return new Point(location.x+20, location.y);
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public void draw() {
		drawAt();
		
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
	public void setSpeed(Point speed) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Point getSpeed() {
		// TODO Auto-generated method stub
		return null;
	}




}
