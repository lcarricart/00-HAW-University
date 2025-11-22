package background;

import java.awt.Color;

import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Sky {
	private final Color SKY = new Color(0,68,129);
	private final Color CLOUD_COLOR = new Color(229,225,230);
	private final int MOON_MARGIN = 230;
	private final int MAX_Y_POSITION = 120;
	
	private int sceneWidth, sceneHeight;
	
	private Moon myMoon;		//composite
	private Cloud myCloud;		//composite
	
	public Sky(int sceneWidth, int sceneHeight) {
		this.sceneWidth = sceneWidth;
		this.sceneHeight = sceneHeight;
		this.myMoon = new Moon();
		this.myCloud = new Cloud(sceneWidth, CLOUD_COLOR);
	}
	
	public void draw() {
		int yEndCoordinate = sceneHeight;
		
		int isRainy = RandomNumber.between(0, 1);
		
		Drawing.getPen().setColor(SKY);
		Drawing.getPen().fillRect(0, 0, sceneWidth, yEndCoordinate);
		
		myCloud.draw(MOON_MARGIN, MAX_Y_POSITION, isRainy);
		myMoon.draw();
	}
	
	public Cloud getCloud() {
		return myCloud;
	}
}
