package farmer;

import java.awt.Color;
import java.awt.Point;

import scene.Direction;
import scene.Drawing;

public class Pistol extends Gun{
	private int width;
	private int height;
	
	public Pistol(Point location, int width, int height, Point direction) {
		super(location, width, height);
		this.width=width;
		this.height=height;
		// TODO Auto-generated constructor stub
		//super.draw();
	}

	public void drawPistol(Point location, Point direction) {
		switch(Direction.getDirection(direction)) {
		case LEFT:
			Drawing.pen().setColor(Color.white);
			Drawing.pen().fillRect(location.x, location.y, width, height);
			break;
		case RIGHT:
			Drawing.pen().setColor(Color.white);
			Drawing.pen().fillRect(location.x, location.y, width, height);
			break;
		case DOWN:
			Drawing.pen().setColor(Color.white);
			Drawing.pen().fillRect(location.x, location.y, height, width);
			break;
		case UP:
			Drawing.pen().setColor(Color.white);
			Drawing.pen().fillRect(location.x, location.y, height, width);
			break;
		default:
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
	

}
