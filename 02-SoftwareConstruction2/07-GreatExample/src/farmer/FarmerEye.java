package farmer;

import java.awt.Color;
import java.awt.Point;

import scene.Drawing;

public class FarmerEye {
	private int width;
	private int height;
	
	public FarmerEye(Point location, int width, int height, Point direction) {
		this.width=width;
		this.height=height;
	}
	
	public void drawAt(Point location, Point direction) {
		Drawing.pen().setColor(Color.green);
		switch(direction.x+direction.y) {
		case -1:
			Drawing.pen().fillOval(location.x, location.y, width, height);
			break;
		case 1:
			Drawing.pen().fillOval(location.x, location.y, width, height);
			break;
		case -10:
			Drawing.pen().fillOval(location.x, location.y, width, height);
			break;
		case 10:
			Drawing.pen().fillOval(location.x, location.y, width, height);
			break;
		default:
			break;
		}
	}
}
