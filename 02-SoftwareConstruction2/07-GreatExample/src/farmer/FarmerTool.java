package farmer;

import java.awt.Point;

import background.LocatedRectangle;

public class FarmerTool {
	//private Gun rifle;
	
	public FarmerTool(LocatedRectangle farmer) {
		farmer.address();
		farmer.width();
		farmer.height();
	}
	
	public void drawAt(Point location) {
		
	}

}
