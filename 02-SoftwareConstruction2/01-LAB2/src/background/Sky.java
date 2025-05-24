package background;

import java.awt.Color;

import drawingTool.Drawing;

public class Sky {
	private static final Color BRIGHT_NAVY = new Color(75,104,184);
	private int sceneWidth, sceneHeight;
	
	private Sun mySun;		//composite
	private Cloud myCloud;	//composite
	
	public Sky(int sceneWidth, int sceneHeight) {
		this.sceneWidth = sceneWidth;
		this.sceneHeight = sceneHeight;
		this.mySun = new Sun();
		this.myCloud = new Cloud(sceneWidth);
	}
	
	public void draw() {
		int yEndCoordinate = sceneHeight;
		
		Drawing.getPen().setColor(BRIGHT_NAVY);
		Drawing.getPen().fillRect(0, 0, sceneWidth, yEndCoordinate);
		
		myCloud.draw();
		mySun.draw();
	}
}
