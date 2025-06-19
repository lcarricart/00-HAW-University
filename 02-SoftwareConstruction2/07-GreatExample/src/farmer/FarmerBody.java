package farmer;

import java.awt.Color;
import java.awt.Point;

import scene.Direction;

public class FarmerBody {
	private int width;
	private int height;
	private Point direction;
	private GunBelt gunBelt;
	private FarmerHead farmerHead;
	private FarmerTorso farmerTorso;
	private FarmerLegs farmerLegs;
	
	public FarmerBody (Point location, int width, int height) {
		this.width=width;
		this.height=height;
		farmerHead= new FarmerHead(new Point(location.x+width/4, location.y+height/10), width/2, height/3, direction);
		farmerTorso=new FarmerTorso(new Point(location.x+width/4, location.y+height/10+height/3), 3*width/4, height/3, direction);
		farmerLegs=new FarmerLegs(new Point(location.x+width/4+width/8, location.y+height/10+height/3+height/3), width/2, height-(height/10+width/2+height/6), direction);
		gunBelt = new GunBelt(new Point(location.x, location.y+3*height/10), width/5, height/10);
	}
	public void draw(Point location) {
		switch(Direction.getDirection(direction)) {
		case LEFT:
			farmerHead.drawAt(new Point(location.x+width/4, location.y+height/10), direction);
			farmerTorso.drawAt(new Point(location.x+width/8, location.y+height/10+height/3), direction);
			farmerLegs.drawAt(new Point(location.x+width/8+width/8, location.y+height/10+2*height/3), direction);
			gunBelt.drawGun(new Point(location.x, location.y+4*height/10), 0);
			break;
		case RIGHT:
			farmerHead.drawAt(new Point(location.x+width/4, location.y+height/10), direction);
			farmerTorso.drawAt(new Point(location.x+width/8, location.y+height/10+height/3), direction);
			farmerLegs.drawAt(new Point(location.x+width/8+width/8, location.y+height/10+2*height/3), direction);
			gunBelt.drawGun(new Point(location.x+width-width/5, location.y+4*height/10), 0);
			break;
		case UP:
			gunBelt.drawGun(new Point(location.x+6*width/10, location.y), 0);
			farmerHead.drawAt(new Point(location.x+width/4, location.y+height/10), direction);
			farmerTorso.drawAt(new Point(location.x+width/8, location.y+height/10+height/3), direction);
			farmerLegs.drawAt(new Point(location.x+width/8+width/8, location.y+height/10+2*height/3), direction);
			break;
		case DOWN:
			farmerHead.drawAt(new Point(location.x+width/4, location.y+height/10), direction);
			farmerTorso.drawAt(new Point(location.x+width/8, location.y+height/10+height/3), direction);
			farmerLegs.drawAt(new Point(location.x+width/8+width/8, location.y+height/10+2*height/3), direction);
			gunBelt.drawGun(new Point(location.x+2*width/10, location.y+7*height/10), 0);
			break;
			default:
				break;
		}
		
	}
	
	public void setDirection(Point direction) {
		this.direction=direction;
		gunBelt.setDirection(direction);
	}
	

}

