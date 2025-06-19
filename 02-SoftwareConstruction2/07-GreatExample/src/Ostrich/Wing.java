package Ostrich;

import java.awt.Color;

import scene.Drawing;

public class Wing {
	private int size;
	private Color innerColor, outerColor; 
	private final int vertNumber;
	private int[] xSet;
	private int[] ySet;

	public Wing(int size, Color inColor, Color outColor) {
		this.size = size;
		innerColor = inColor;
		outerColor = outColor;
		this.vertNumber = 3;
		this.xSet = new int[vertNumber];
		this.ySet = new int[vertNumber]; 
	}
	
	
	public void setWingX(int x) {
		xSet[0] = x;
		xSet[1] = x + size*3/2; 
		xSet[2] = x + size*2;
	}
	
	public void setWingY(int y) {
		ySet[0] = y;
		ySet[1] = y;
		ySet[2] = y + (size+(size/5)); 
	}
	
	public void drawWing(int x, int y) {
		this.setWingX(x);   
		this.setWingY(y);  
		Drawing.pen().setColor(outerColor); 
		Drawing.pen().fillPolygon(xSet, ySet, vertNumber);
		Drawing.pen().setColor(innerColor);
		this.setWingX(x+(size/12));
		this.setWingY(y+(size/30));
		Drawing.pen().fillPolygon(xSet, ySet, vertNumber);
	}


}
