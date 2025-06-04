package background;

import drawingTool.Drawing;
import java.awt.Color;

public class Moon {
	private final int SIZE = 150;
	private final int X_SHIFT = 15;
	private final Color GLOWING_MOON = new Color(254,252,215);
	private final Color SKY = new Color(0,68,129);
	
	public Moon() {
	}
	
	public void draw() {
		int xShift = SIZE / 3;
		int yShift = SIZE / 3;
		
		Drawing.getPen().setColor(GLOWING_MOON);
		Drawing.getPen().fillArc(xShift, yShift, SIZE, SIZE, 110, 180);
        Drawing.getPen().setColor(SKY);
        Drawing.getPen().fillOval(xShift + X_SHIFT, yShift, SIZE, SIZE);
		
	}
}
