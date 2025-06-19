package scene;

import java.awt.Color;
import java.awt.Point;

import background.LocatedRectangle;
import background.Speed;

public class Bullet implements LocatedRectangle{
	private Speed speed;
	private Point location;

	public Bullet(Point location, int direction, Speed speed) {
		this.location=location;
		 this.speed= speed;
		 //Scene.parts.add(returnBullet(this));
	}
	
	public Bullet(Point location, int direction, Speed speed, int xDir) {
		this.location=new Point(location.x, location.y);
		 this.speed= speed;
		 //Scene.parts.add(returnBullet(this));
	}
	
	public Bullet returnBullet(Bullet bullet) {
		return bullet;
	}
	@Override
	public Point address() {
		// TODO Auto-generated method stub
		return location;
	}
	
	public void setAddress() {
		location=new Point(location.x+speed.getXSpeed(),location.y+speed.getYSpeed());
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public void draw() {
		if(speed.getYSpeed()==0) {
			Drawing.pen().setColor(Color.black);
			Drawing.pen().drawRect(location.x, location.y, 10, 5);
			Drawing.pen().setColor(new Color(255,223,0,255));
			Drawing.pen().fillRect(location.x, location.y, 10, 5);
		}
		else
		{
			Drawing.pen().setColor(Color.black);
			Drawing.pen().drawRect(location.x, location.y, 5, 10);
			Drawing.pen().setColor(new Color(255,223,0,255));
			Drawing.pen().fillRect(location.x, location.y, 5, 10);
		}	
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
