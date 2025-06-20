package scene;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import background.LocatedRectangle;
import background.Speed;

public class Beach implements LocatedRectangle{
	
	private int width, height;
	private Point location;
	private Beach beach;
	private boolean corner;
	private Direction dir;
	
	public Beach(Rectangle rectangle) {
		this.height=rectangle.height;
		this.width=rectangle.width;
		this.location=rectangle.getLocation();
	}
	
	public Beach(Rectangle rectangle, Direction dir) {
		this.dir=dir;
		this.height=rectangle.height;
		this.width=rectangle.width;
		this.corner=true;
		this.location=rectangle.getLocation();
	}

	@Override
	public Point address() {
		// TODO Auto-generated method stub
		if(location.x>0)
			return new Point(location.x+30, location.y);
		else
			return new Point(location.x-30, location.y);
			
	}

	@Override
	public Point direction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return height-100;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		if(!corner) {
			Drawing.pen().setColor(new Color(194, 178, 128, 255));
			Drawing.pen().fillRect(location.x-4*width/20, location.y-4*height/20, width+4*width/10, height+4*height/10);
			Drawing.pen().setColor(Color.blue);
			Drawing.pen().fillRect(location.x, location.y, width, height);
		}
		else
		{
			switch(dir) {
			case UP:
				Drawing.pen().setColor(new Color(194, 178, 128, 255));
				Drawing.pen().fillRect(location.x, location.y, width, height+2*height/10);
				Drawing.pen().setColor(Color.blue);
				Drawing.pen().fillRect(location.x, location.y, width, height);
				break;
			case LEFT:
				Drawing.pen().setColor(new Color(194, 178, 128, 255));
				Drawing.pen().fillRect(location.x, location.y, width+2*width/10, height);
				Drawing.pen().setColor(Color.blue);
				Drawing.pen().fillRect(location.x, location.y, width, height);
				break;
			case DOWN:
				Drawing.pen().setColor(new Color(194, 178, 128, 255));
				Drawing.pen().fillRect(location.x, location.y-2*height/10, width, height+2*height/10);
				Drawing.pen().setColor(Color.blue);
				Drawing.pen().fillRect(location.x, location.y, width, height);
				break;
			case RIGHT:
				Drawing.pen().setColor(new Color(194, 178, 128, 255));
				Drawing.pen().fillRect(location.x-2*width/10, location.y, width+2*width/10, height);
				Drawing.pen().setColor(Color.blue);
				Drawing.pen().fillRect(location.x, location.y, width, height);
				break;

			}	
		}
	}

	@Override
	public void setAddress(Point location) {
		// TODO Auto-generated method stub
		this.location=location;
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		this.width=width;
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		this.height=height;
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
