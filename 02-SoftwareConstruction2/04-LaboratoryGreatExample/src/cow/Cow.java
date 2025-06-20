package cow;
import java.awt.Point;

import background.LocatedRectangle;
import background.Speed;

public class Cow implements LocatedRectangle {
	private int width;
    private int headWidth;
	private int height;
    private int headHeight;
	private Body body;
	private Head head;
    private Point address;
	boolean facingRight;
	public Point speed;
	
	public Cow(int width, int height, java.awt.Color spotColor, Point address, boolean facingRight, Point speed) {
		this.speed=speed;
		this.width = width;
		this.height = height;
		body = new Body(width, height, spotColor, facingRight);
        this.headWidth = height;
        this.headHeight = height;
		head = new Head(headWidth, headHeight);
		this.address = address;
		this.facingRight = facingRight;
	}
	
	

	
	public void drawAt(int left, int bottom) {

		if (!facingRight == false) {
			head.drawAt(left, bottom);
			body.drawAt(left+headWidth, bottom+width / 4);
		}
		else {
			head.drawAt(left + width, bottom);
			body.drawAt(left, bottom+width / 4);
		}
	}
	
	public void setDirection(boolean direction) {
		body.setDirection(direction);
		facingRight=direction;
	}
	
	public void setSpeed(Point speed) {
		this.speed = new Point(speed.x, speed.y);
	}
	
	@Override
	public Point address() {
		return this.address;
	}

	@Override
	public int width() {
		return 5*this.width/3;// + this.headWidth;
	}

	@Override
	public int height() {
		return this.height*2;// + this.headHeight + this.height - (this.height/2);
	}

	@Override
	public void draw() {
		address.x+=speed.x;
		address.y+=speed.y;
		this.drawAt(this.address.x, this.address.y);
	}


	@Override
	public Point direction() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setAddress(Point location) {
		address=location;
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
		return speed;
	}

	
}