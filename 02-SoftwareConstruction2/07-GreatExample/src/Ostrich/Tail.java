package Ostrich;

import java.awt.Color;

import scene.Drawing;

public class Tail {
	private int size;
	private Color tailColor;
	private final int vertNumber;
	private int[] xSet;
	private int[] ySet;

	public Tail(int size, Color tColor) {
		this.size = size;
		tailColor = tColor;
		this.vertNumber = 3;
		this.xSet = new int[vertNumber];
		this.ySet = new int[vertNumber];
	}

	public void setTailX(int x) {
		xSet[0] = x;
		xSet[1] = x + size;
		xSet[2] = x + size;
	}

	public void setTailY(int y) {
		ySet[0] = y;
		ySet[1] = y;
		ySet[2] = y - size;
	}

	public void drawTail(int x, int y) {
		Drawing.pen().setColor(tailColor);
		this.setTailX(x);
		this.setTailY(y);
		Drawing.pen().fillPolygon(xSet, ySet, vertNumber);
		this.setTailX(x-(size/10));
		Drawing.pen().fillPolygon(xSet, ySet, vertNumber);
		this.setTailX(x-(size/5));
		Drawing.pen().fillPolygon(xSet, ySet, vertNumber);
	}

}
