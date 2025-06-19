package farmer;

import java.awt.Point;

import background.LocatedRectangle;
import background.Speed;
import scene.Bullet;

public class Gun implements LocatedRectangle{
	private Point location;
	private Point direction; 
	private int width;
	private int height;
	private Bullet bullet;
	
	public Gun(Point location, int width, int height) {
		this.location=location;
		this.width=width;
		this.height=height;
		}

	public void shoot(int direction) {
		
		//BulletField.addBullet(location, direction, new Speed(new Point(3,3)));
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
		this.direction=direction;
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
