package background;

import java.awt.Point;

public class Speed {
	private Point speed;
	
	public Speed(Point speed) {
		this.speed=speed;
	}
	
	public Point getSpeed() {
		return speed;
	}
	
	public void setSpeed(Point speed) {
		this.speed=speed;
	}
	
	public int getXSpeed() {
		return speed.x;
	}
	
	public int getYSpeed() {
		return speed.y;
	}
}
