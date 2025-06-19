package farmer;

import java.awt.Color;
import java.awt.Point;

import scene.Direction;
import scene.Drawing;

public class Hair {
	private int width;
	private int height;
	
	public Hair(Point location, int width, int height, Point direction) {
		this.width=width;
		this.height=height;
	}
	
	public void drawAt(Point location, Point direction) {
		Drawing.pen().setColor(new Color(255,215,0, 255));
		switch(Direction.getDirection(direction)) {
		case LEFT:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			Drawing.pen().fillRect(location.x+width-width/4, location.y+height, width/4, height);
			break;
		case RIGHT:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			Drawing.pen().fillRect(location.x, location.y+height, width/4, height);
			break;
		case UP:
			Drawing.pen().fillRect(location.x, location.y, width, 3*height);
			break;
		case DOWN:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			break;
		default:
			break;
		}
	}
	
}


