package farmer;

import java.awt.Color;
import java.awt.Point;

import scene.Drawing;

public class Mouth {
	private int width;
	private int height;
	
	public Mouth(Point location, int width, int height, Point direction) {
		this.width=width;
		this.height=height;
	}
	
	public void drawAt(Point location, Point direction) {
		Drawing.pen().setColor(new Color(250,128,114, 255));
		switch(direction.x+direction.y) {
		case -1:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			break;
		case 1:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			break;
		case -10:
			break;
		case 10:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			break;
		default:
			break;
		}
	}
}
