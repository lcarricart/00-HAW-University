package farmhouse;

import java.awt.Color;
import java.awt.Point;

import scene.Drawing;

public class Door {
	private Point location;
	private int width;
	private int height;
		
	public Door(Point location, int width, int height) {
		this.location=location;			
		this.width=width;
		this.height=height;
	}
	
	public void drawAt() {
		Drawing.pen().setColor(new Color(139,69,19, 255));
		Drawing.pen().fillRect(location.x, location.y, width, height);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect(location.x, location.y, width, height);
	}
	
	public Point getLocation() {
		return location;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
