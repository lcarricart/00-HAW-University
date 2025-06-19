package giraffe;

import java.awt.Color;

import scene.Drawing;

public class NeckPatterns extends SkinPatterns{
	
	public NeckPatterns(int width, int height, Color color) {
		super (width, height, color);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(getColor());
		int neckPatWidth = getWidth() * 2/4;
		int neckPatHeight = getHeight() * 3/4;
		int xPoints[] = {left, left + neckPatWidth, left, left - neckPatWidth, left - 2 * neckPatWidth, left - neckPatWidth};
		int yPoints[] = {bottom, bottom + neckPatHeight, bottom + 2 * neckPatHeight, bottom + 2 * neckPatHeight, bottom + neckPatHeight, bottom};
		int nPoints = 6;
		Drawing.pen().fillPolygon(xPoints, yPoints, nPoints);
	}

}
