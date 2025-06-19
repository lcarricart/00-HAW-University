package farmer;

import java.awt.Color;
import java.awt.Point;

import scene.Direction;
import scene.Drawing;

public class FarmerHead {
	private int width;
	private int height;
	//private Hat hat;
	private FarmerEye farmerEyeRight;
	private FarmerEye farmerEyeLeft;
	private Mouth mouth;
	private Nose nose;
	private Hair hair;
	
	public FarmerHead (Point location, int width, int height, Point direction) {
		this.width=width;
		this.height=height;
		hair = new Hair(location, width, height/4, direction);
		nose = new Nose(new Point(location.x+width/2-width/8,location.y+height/2), width/8, height/8, direction);
		mouth = new Mouth(new Point(location.x+width/2-width/8,location.y+3*height/4), width/8, height/12, direction);
		farmerEyeLeft=new FarmerEye(new Point(location.x+width/3, location.y+height/3), width/5, height/3, direction);
		farmerEyeRight=new FarmerEye(new Point(location.x+2*width/3, location.y+height/3), width/5, height/3, direction);
	}
	
	public void drawAt(Point location, Point direction) {
		Drawing.pen().setColor(new Color(244,164,96, 255));
		switch(Direction.getDirection(direction)) {
		case LEFT:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			hair.drawAt(new Point(location.x, location.y), direction);
			farmerEyeLeft.drawAt(new Point(location.x+width/3-width/5, location.y+height/3), direction);
			farmerEyeRight.drawAt(new Point(location.x+2*width/3-width/5, location.y+height/3), direction);
			nose.drawAt(new Point(location.x+width/2-width/5,location.y+height/2+height/16), direction);
			mouth.drawAt(new Point(location.x+width/2-width/6,location.y+height/16+3*height/4), direction);
			break;
		case RIGHT:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			hair.drawAt(new Point(location.x, location.y), direction);
			farmerEyeLeft.drawAt(new Point(location.x+width/3, location.y+height/3), direction);
			farmerEyeRight.drawAt(new Point(location.x+2*width/3, location.y+height/3), direction);
			nose.drawAt(new Point(location.x+width/2+width/8,location.y+height/2+height/16), direction);
			mouth.drawAt(new Point(location.x+width/2+width/8,location.y+3*height/4+height/16), direction);
			break;
		case UP:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			hair.drawAt(new Point(location.x, location.y), direction);
			break;
		case DOWN:
			Drawing.pen().fillRect(location.x, location.y, width, height);
			hair.drawAt(new Point(location.x, location.y), direction);
			farmerEyeLeft.drawAt(new Point(location.x+width/5, location.y+height/3), direction);
			farmerEyeRight.drawAt(new Point(location.x+3*width/5, location.y+height/3), direction);
			nose.drawAt(new Point(location.x+width/2-width/16,location.y+height/2+height/16), direction);
			mouth.drawAt(new Point(location.x+width/2-width/16,location.y+3*height/4+height/16), direction);
			break;
		default:
			break;
		}
	}
}
