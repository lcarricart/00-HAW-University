package farmer;

import java.awt.Color;
import java.awt.Point;

import scene.Direction;
import scene.Drawing;

public class FarmerTorso {
	private int width;
	private int height;
	
	public FarmerTorso(Point location, int width, int height, Point direction) {
		this.width=width;
		this.height=height;
	}
	
	public void drawAt(Point location, Point direction) {
		Drawing.pen().setColor(Color.red);
		switch(Direction.getDirection(direction)) {
		case LEFT:
			Drawing.pen().fillRect(location.x+width/6, location.y, 7*width/10, height);
			Drawing.pen().fillRect(location.x-5+7, location.y+2*height/10-5, 3*width/10, 4*height/10);
			Drawing.pen().setColor(new Color(244,164,96, 255));
			Drawing.pen().fillRect(location.x-width/10+7, location.y+2*height/10-width/20, 1*width/10, 4*height/10);
			break;
		case RIGHT:
			Drawing.pen().fillRect(location.x+width/8, location.y, 7*width/10, height);
			Drawing.pen().fillRect(location.x+width-3*width/10, location.y+2*height/10-5, 3*width/10, 4*height/10);
			Drawing.pen().setColor(new Color(244,164,96, 255));
			Drawing.pen().fillRect(location.x+width-6, location.y+2*height/10-width/20, 1*width/10, 4*height/10);
			break;
		case UP:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			break;
		case DOWN:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			Drawing.pen().setColor(new Color(244,164,96, 255));
			Drawing.pen().fillRect(location.x, location.y+height-height/10, width/5, height/5);
			Drawing.pen().fillRect(location.x+width-2*width/11, location.y+height-height/10, 2*width/11, height/5);
			break;
		default:
			break;
		}
	}
}
