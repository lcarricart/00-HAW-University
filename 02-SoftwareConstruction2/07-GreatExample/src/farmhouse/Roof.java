package farmhouse;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;

import scene.Drawing;

public class Roof {
	private Point location;
	private int width;
	private int height;
		
	public Roof(Point location, int width, int height) {
		this.location=location;			
		this.width=width;
		this.height=height;
	}
	
	public void drawAt() {
		Drawing.pen().setColor(new Color(178,34,34, 255));
		Point p1 = new Point(location.x, location.y+height);
		Point p2 = new Point(location.x + 3*width/20, location.y);
		Point p2r = new Point(location.x + 10*width/20, location.y);
		Point p3 = new Point(location.x + 6*width/10, location.y+height/2);
		Point p4 = new Point(location.x + 9*width/10, location.y+height/2);
		Point p5 = new Point(location.x + 10*width/10, location.y+height);
		Polygon p=new Polygon();
		p.addPoint(p1.x,p1.y);
		p.addPoint(p2.x,p2.y);
		p.addPoint(p2r.x,p2r.y);
		p.addPoint(p3.x,p3.y);
		p.addPoint(p4.x,p4.y);
		p.addPoint(p5.x,p5.y);
		Drawing.pen().fillPolygon(p);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawPolygon(p);
	}	
}
