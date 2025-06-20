package farmhouse;

import java.awt.Color;
import java.awt.Point;

import scene.Drawing;

public class MainBuild {
	private Door door;
	private Point location;
	private Windows window;
	private int width;
	private int height;
		
	public MainBuild(Point location, int width, int height) {
		this.location=location;			
		this.width=width;
		this.height=height;
		setDoor(new Door(new Point(location.x+3*width/10, location.y+4*height/10), 3*width/10, 6*height/10));
		window= new Windows(new Point(location.x+7*width/10, location.y+2*height/10), width/5, height/5, new Color(255,215,0,255));
	}
	public void drawAt() {
		Drawing.pen().setColor(new Color(222,184,135, 255));
		Drawing.pen().fillRect(location.x, location.y, width, height);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect(location.x, location.y, width, height);
		getDoor().drawAt();
		window.drawAt();
	}
	public Door getDoor() {
		return door;
	}
	public void setDoor(Door door) {
		this.door = door;
	}
}
