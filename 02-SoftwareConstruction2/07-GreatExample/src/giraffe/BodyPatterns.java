package giraffe;

import java.awt.Color;

import scene.Drawing;

public class BodyPatterns extends SkinPatterns{
	
	public BodyPatterns(int width, int height, Color color) {
		super (width, height, color);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(getColor());
		int xPoints[] = {left, left + getWidth(), left + getWidth()/2, left - getWidth()/2, left - getWidth()};
		int yPoints[] = {bottom, bottom + getHeight()/2, bottom + getHeight(), bottom + getHeight(), bottom + getHeight()/2};
		int nPoints = 5;
		Drawing.pen().fillPolygon(xPoints, yPoints, nPoints);
	}

}