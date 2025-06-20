package scene;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

public class Background {
	private Point location;
	private int width;
	private int height;
	
	public Background(Point location, int width, int height) {
		this.width=width;
		this.height=height;
		this.location=location;
	}
	
	public Background(Rectangle rectangle) {
		this.width=rectangle.width;
		this.height=rectangle.height;
		this.location=rectangle.getLocation();
	}
	
	public void draw() {
		Drawing.pen().setColor(new Color(34,139,34, 255));
		Drawing.pen().fillRect(0,0, TestDrawingTool.screenSize().width,TestDrawingTool.screenSize().height);
		Drawing.pen().setColor(new Color(205,133,63,255));
		Drawing.pen().fillRect(location.x, location.y, width, height);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect(location.x, location.y, width, height);
	}
	
	public void draw(Rectangle rectangle) {
		Drawing.pen().setColor(new Color(34,139,34, 255));
		Drawing.pen().fillRect(rectangle.x,rectangle.y, rectangle.width,rectangle.height);
		Drawing.pen().setColor(new Color(205,133,63,255));
		Drawing.pen().fillRect(location.x, location.y, width, height);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect(location.x, location.y, width, height);
	}
}
