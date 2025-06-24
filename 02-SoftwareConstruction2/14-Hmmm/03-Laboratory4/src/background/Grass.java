package background;

import drawingTool.Drawing;
import java.awt.Color;

public class Grass {
	private final Color DARK_GREEN = new Color(21,71,52);
	
	public Grass() {
		
	}
	
	public void draw(int yStartCoordinate, int screenWidth, int screenHeight) {
		int yStartCoordinate2 = yStartCoordinate - 15;
		int yEndCoordinate = screenHeight - (yStartCoordinate / 10);
		
		for (int y = yStartCoordinate2; y < yEndCoordinate; y = y + 15) {
			if (y % 2 == 0) {
				for (int x = -7; x < screenWidth; x = x + 10) {
					Drawing.getPen().setColor(Color.BLACK);
					Drawing.getPen().drawOval(x, y, 12, 20);
					Drawing.getPen().setColor(DARK_GREEN);
					Drawing.getPen().fillOval(x, y, 12, 20);
				}
			} else {
				for (int x = -15; x < screenWidth; x = x + 12) {
					Drawing.getPen().setColor(Color.BLACK);
					Drawing.getPen().drawOval(x, y, 12, 20);
					Drawing.getPen().setColor(DARK_GREEN);
					Drawing.getPen().fillOval(x, y, 12, 20);
				}
			}
			
			
		}
	}
}

