package background;

import drawingTool.Drawing;
import java.awt.Color;

public class Sun {
	private final int SIZE = 150;
	private final int X_SHIFT = 15;
	private final Color GLOWING_MOON = new Color(255,243,109);
	
	public Sun() {
	}
	
	public void draw() {
		int xShift = SIZE / 3;
		int yShift = SIZE / 3;
		
		Drawing.getPen().setColor(GLOWING_MOON);
        Drawing.getPen().fillOval(xShift + X_SHIFT, yShift, SIZE, SIZE);
	}
}
