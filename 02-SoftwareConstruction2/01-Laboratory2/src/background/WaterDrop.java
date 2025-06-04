package background;

import drawingTool.Drawing;
import java.awt.Color;

public class WaterDrop {
	private int sizeX, sizeY;
	private static final Color DARK_BLUE = new Color(3,37,126);
	
	public WaterDrop(int sizeCloud) {
		this.sizeX = sizeCloud / 60;
		this.sizeY = sizeCloud / 5;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.getPen().setColor(DARK_BLUE);
		Drawing.getPen().fillOval(left, bottom, sizeX, sizeY);
	}
}
