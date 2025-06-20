package farmhouse;

import java.awt.Color;
import java.awt.Point;
import java.awt.Window;

import scene.Drawing;

public class Shack {
	private Point location;
	private int width;
	private int height;
	private Windows window;
		
	public Shack(Point location, int width, int height) {
		this.location=location;			
		this.width=width;
		this.height=height;
		window=new Windows(new Point(location.x+width/3, location.y+height/4), width/3, height/3, new Color(255,215,0, 255));
	}
	public void drawAt() {
		Drawing.pen().setColor(new Color(222,184,135, 255));
		Drawing.pen().fillRect(location.x, location.y, width, height);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect(location.x, location.y, width, height);
		window.drawAt();
	}
}
