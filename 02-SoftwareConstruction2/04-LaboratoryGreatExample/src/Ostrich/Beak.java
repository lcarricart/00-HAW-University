package Ostrich;

import java.awt.Color;

import scene.Drawing;

public class Beak {
	private int size;
	private final int vertNumber;
	private int[] xSet;
	private int[] ySet;

	public Beak(int size) {
		this.size = size;
		this.vertNumber = 3;
		this.xSet = new int[vertNumber];
		this.ySet = new int[vertNumber]; 
	}
	
	
	public void setBeakX(int x) {
		xSet[0] = x;
		xSet[1] = x - size; //- x/5;
		xSet[2] = x;
	}
	
	public void setBeakY(int y) {
		ySet[0] = y;
		ySet[1] = y + size/3;
		ySet[2] = y - size/2; 
	}
	
	public void drawBeak(int x, int y) {
		this.setBeakX(x);   
		this.setBeakY(y);  
		Drawing.pen().setColor(Color.orange); 
		Drawing.pen().fillPolygon(xSet, ySet, vertNumber);
	}


}


