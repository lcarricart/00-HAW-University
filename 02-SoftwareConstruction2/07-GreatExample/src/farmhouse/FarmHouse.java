package farmhouse;

import java.awt.Point;

import background.LocatedRectangle;
import background.Speed;

public class FarmHouse implements LocatedRectangle{
	private Facade facade;
	private Roof roof;
	private Point location;
	private Point direction;
	private int width;
	private int height;
	
	public FarmHouse(Point location, int width, int height) {
		this.location=location;
		this.width=width;
		this.height=height;
		
		setFacade(new Facade(new Point(location.x+width/10, location.y+4*height/10), width-width/10, 6*height/10));
		roof = new Roof(location, width+width/10, 4*height/10);
	}
	
	public void drawAt(){
		getFacade().drawAt();
		roof.drawAt();
	}

	public Facade getFacade() {
		return facade;
	}

	public void setFacade(Facade facade) {
		this.facade = facade;
	}

	@Override
	public Point address() {
		// TODO Auto-generated method stub
		return new Point(location.x, location.y-80);
	}

	@Override
	public Point direction() {
		// TODO Auto-generated method stub
		return direction;
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public void draw() {
		drawAt();
		
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
