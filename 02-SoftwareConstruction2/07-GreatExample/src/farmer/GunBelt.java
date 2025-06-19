package farmer;

import java.awt.Point;
import java.util.ArrayList;

import background.LocatedRectangle;
import background.Speed;
import scene.Direction;

public class GunBelt implements LocatedRectangle{
	private int index;
	private Point location;
	private Point direction;
	private ArrayList<LocatedRectangle> guns = new ArrayList<LocatedRectangle>();
	private Pistol pistol;
	
	public GunBelt(Point location, int width, int height) {
		this.location=location;
		pistol = new Pistol(location, width, height, direction);
		guns.add(pistol);
	}
	
	public GunBelt(LocatedRectangle farmer) {
		
	}
	
	public void drawGun(Point location, int index) {
		setIndex(index);
		setAddress(location);
		drawWithIndex();
	}
	
	public void setAddress(Point address) {
		this.location=address;
	}
	
	private void addGun(LocatedRectangle gun) {
		guns.add(gun);
	}
	
	public void setIndex(int index) {
		this.index=index;
	}
	
	private void drawWithIndex() {
		switch(this.index) {
		case 0:
			switch(Direction.getDirection(direction)) {
			case LEFT:
				pistol.drawPistol(location, direction);
				break;
			case RIGHT:
				pistol.drawPistol(new Point(location.x, location.y), direction);
				break;
			case UP:
				pistol.drawPistol(new Point(location.x, location.y), direction);
				break;
			case DOWN:
				pistol.drawPistol(new Point(location.x, location.y-5), direction);
				break;
			default: 
				break;
			}
			
			case 1: //here goes the rifle
				break;
		}
	}

	@Override
	public Point address() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point direction() {
		// TODO Auto-generated method stub
		return direction;
	}

	@Override
	public void setDirection(Point direction) {
		// TODO Auto-generated method stub
		this.direction=direction;
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
	public void setSpeed(Point speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getSpeed() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
