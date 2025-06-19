package farmer;

import java.awt.Color;
import java.awt.Point;

import scene.Drawing;

public class FarmerLegs {
	private int width;
	private int height;
	private Shoe shoeLeft;
	private Shoe shoeRight;
	
	public FarmerLegs(Point location, int width, int height, Point direction) {
		this.width=width;
		this.height=height;
		shoeLeft= new Shoe(new Point(location.x, location.y+2*height/3), 4*width/9, height/3+1, direction);
		shoeRight= new Shoe(new Point(location.x+6*width/10, location.y+2*height/3), 4*width/9, height/3+1, direction);
	}
	
	public void drawAt(Point location, Point direction) {
		Drawing.pen().setColor(new Color(0,0,128, 255));
		switch(direction.x+direction.y) {
		case -1:
			Drawing.pen().fillRect(location.x, location.y, 4*width/9, height);
			Drawing.pen().fillRect(location.x+5*width/9, location.y, 4*width/9, height);
			Drawing.pen().fillRect(location.x, location.y, 35*width/34, height/4);
			shoeLeft.drawAt(new Point(location.x, location.y+2*height/3), direction);
			shoeRight.drawAt(new Point(location.x+5*width/9, location.y+2*height/3), direction);
			break;
		case 1:
			Drawing.pen().fillRect(location.x, location.y, 4*width/9, height);
			Drawing.pen().fillRect(location.x+5*width/9, location.y, 4*width/9, height);
			Drawing.pen().fillRect(location.x-width/18, location.y, width, height/4);
			shoeLeft.drawAt(new Point(location.x, location.y+2*height/3), direction);
			shoeRight.drawAt(new Point(location.x+5*width/9, location.y+2*height/3), direction);
			break;
		case -10:
			Drawing.pen().fillRect(location.x, location.y, 4*width/9, height);
			Drawing.pen().fillRect(location.x+5*width/9, location.y, 4*width/9, height);
			Drawing.pen().fillRect(location.x, location.y, 9*width/10, height/4);
			shoeLeft.drawAt(new Point(location.x, location.y+2*height/3), direction);
			shoeRight.drawAt(new Point(location.x+5*width/9, location.y+2*height/3), direction);
			break;
		case 10:
			Drawing.pen().fillRect(location.x, location.y, 4*width/9, height);
			Drawing.pen().fillRect(location.x+5*width/9, location.y, 4*width/9, height);
			Drawing.pen().fillRect(location.x, location.y, 9*width/10, height/4);
			shoeLeft.drawAt(new Point(location.x, location.y+2*height/3), direction);
			shoeRight.drawAt(new Point(location.x+5*width/9, location.y+2*height/3), direction);
			break;
		default:
			break;
		}
	}
}
