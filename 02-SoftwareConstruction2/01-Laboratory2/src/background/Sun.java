package background;

import drawingTool.Drawing;
import java.awt.Color;

public class Sun {
	private static final int SIZE = 150;
	private static final Color ANOTHER_YELLOW = new Color(251,219,101);
	
	public Sun() {
	}
	
	public void draw() {
		int xShift = SIZE / 3;
		int yShift = SIZE / 3;
		
		Drawing.getPen().setColor(ANOTHER_YELLOW);
		Drawing.getPen().fillOval(xShift, yShift, SIZE, SIZE);
		
	}
}
