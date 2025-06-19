package farmer;

import java.awt.Color;
import java.awt.Point;

import scene.Direction;
import scene.Drawing;

public class Shoe {
	private int width;
	private int height;
	
	public Shoe(Point location, int width, int height, Point direction) {
		this.width=width;
		this.height=height;
	}
	
	public void drawAt(Point location, Point direction) {
		Drawing.pen().setColor(new Color(139,69,19,255));
		switch(Direction.getDirection(direction)) {
		case LEFT:
			Drawing.pen().fillRect(location.x-width/10, location.y, 11*width/10, height);
			break;
		case RIGHT:
			Drawing.pen().fillRect(location.x, location.y, 11*width/10, height);
			break;
		case UP:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			break;
		case DOWN:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			break;
		default:
			break;
		}
	}
}
