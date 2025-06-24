package background;

import java.awt.Color;

import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class LightSky {
	private final Color SKY = new Color(123,178,221);
	private final Color CLOUD_COLOR = new Color(229,225,230);
	private final int SUN_MARGIN = 230;
	private final int MAX_Y_POSITION = 120;
	
	private int sceneWidth, sceneHeight;
	
	private Sun mySun;
	private Cloud myCloud;		//composite
	
	public LightSky(int sceneWidth, int sceneHeight) {
		this.sceneWidth = sceneWidth;
		this.sceneHeight = sceneHeight;
		this.myCloud = new Cloud(sceneWidth, CLOUD_COLOR);
		this.mySun = new Sun();
	}
	
	public void draw() {
		int yEndCoordinate = sceneHeight;
		
		int isRainy = RandomNumber.between(0, 1);
		
		Drawing.getPen().setColor(SKY);
		Drawing.getPen().fillRect(0, 0, sceneWidth, yEndCoordinate);
		myCloud.draw(SUN_MARGIN, MAX_Y_POSITION, isRainy);
		mySun.draw();
		
	}
}