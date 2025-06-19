package Ostrich;

import java.awt.Color;
import java.awt.Point;

import scene.Drawing;

public class Hat {
	
	private Point referenceLocation;
	private Color hatColor;
	private int x, y, size;
	
	public Hat(Ostrich ostrich, Color color) {
		referenceLocation = ostrich.address();
		hatColor = color;
		x = referenceLocation.x + ostrich.width()/9;
		size = ostrich.width()/8;
		x = referenceLocation.x + ostrich.width()/40;
		y = referenceLocation.y - ostrich.width()/9;
		
	}
	
	public void drawRegular() {
		Drawing.pen().setColor(hatColor);
		Drawing.pen().fillRect(x, y, size, size);
		Drawing.pen().fillRect(x-size/2, y+size/2+(size/10), size*2, size/2);
		
		
	}
	
	public void drawBaseball() {
		Drawing.pen().setColor(hatColor);
		Drawing.pen().fillOval(x+size/10, y + size/2, size, size/2);
		Drawing.pen().fillRect(x+size/10, y+size/2+(size/3), size + (size/2), size/4);
		
		
	}
	
	

}
