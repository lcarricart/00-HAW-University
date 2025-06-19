package farmhouse;

import java.awt.Color;
import java.awt.Point;

import scene.Drawing;

public class Windows {
	private Point location;
	private int width;
	private int height;
	private Color color;
		
	public Windows(Point location, int width, int height, Color color) {
		this.location=location;			
		this.width=width;
		this.height=height;
		this.color=color;
	}
	
	public void drawAt() {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(location.x, location.y, width, height);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect(location.x, location.y, width, height);
	}
}
