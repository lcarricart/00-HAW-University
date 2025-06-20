package background;

import java.awt.Color;
import java.awt.Point;

import scene.Drawing;

public class FenceColumn implements LocatedRectangle {
	@SuppressWarnings("unused")
	private int width;
	private int height;
	private Point location;
	
	public FenceColumn(Point location, int width, int height) {
		this.width=width;
		this.height=height;
		this.location=location;
	}
	public void drawAtRight() {
		Drawing.pen().setColor(new Color(165,42,42,255));
		Drawing.pen().fillRect(location.x-20, location.y, 20, height+50);
		Drawing.pen().setColor(new Color(128,0,0,255));
		for(int i=0; i<10; i++)
			Drawing.pen().fillRect(location.x-20, location.y+i*(height+50)/10, 22, 20);
		Drawing.pen().fillRect(location.x-20, location.y+height+1, 22, 50);
	}
	
	public void drawAtLeft() {
		Drawing.pen().setColor(new Color(165,42,42,255));
		Drawing.pen().fillRect(location.x-20, location.y, 20, height+50);
		Drawing.pen().setColor(new Color(128,0,0,255));
		for(int i=0; i<10; i++)
			Drawing.pen().fillRect(location.x-22, location.y+i*(height+50)/10, 22, 20);
		Drawing.pen().fillRect(location.x-22, location.y+height+1, 22, 50);
	}
	
	public void drawAtRight(int pillars) {
		Drawing.pen().setColor(new Color(165,42,42,255));
		Drawing.pen().fillRect(location.x-20, location.y, 20, height+50);
		Drawing.pen().setColor(new Color(128,0,0,255));
		for(int i=0; i<pillars; i++)
			Drawing.pen().fillRect(location.x-20, location.y+i*(height+50)/pillars, 22, 20);
		Drawing.pen().fillRect(location.x-20, location.y+height+1, 22, 50);
	}
	
	public void drawAtLeft(int pillars) {
		Drawing.pen().setColor(new Color(165,42,42,255));
		Drawing.pen().fillRect(location.x-20, location.y, 20, height+50);
		Drawing.pen().setColor(new Color(128,0,0,255));
		for(int i=0; i<pillars; i++)
			Drawing.pen().fillRect(location.x-22, location.y+i*(height+50)/pillars, 22, 20);
		Drawing.pen().fillRect(location.x-22, location.y+height+1, 22, 50);
	}
	@Override
	public Point address() {
		// TODO Auto-generated method stub
		return new Point(location.x-20, location.y);
	}
	@Override
	public int width() {
		// TODO Auto-generated method stub
		return 20;
	}
	@Override
	public int height() {
		// TODO Auto-generated method stub
		return height;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		drawAtLeft();
		drawAtRight();
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
