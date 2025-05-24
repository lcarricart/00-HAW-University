package background;

import java.awt.Color;
import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Cloud {
	private static final int SIZE_Y = 110;
	private static final int SIZE_X = 150;
	private static final Color LIGHT_GRAY = new Color(229,225,230);
	
	private static final int NUMBER_CLOUDS = 5;
	private static final int NUMBER_SUB_PARTS = 3;
	private static final int SUB_PARTS_SHIFT = SIZE_X / 2;
	private static final int MAX_Y_POSITION = 120;
	
	private static final int WATER_DROP_SHIFT_1 = SIZE_X / 2;
	private static final int WATER_DROP_SHIFT_2 = (int) (SIZE_X * 1.5);
	private static final int WATER_DROP_SHIFT_3 = (int) SIZE_X;
	private static final int WATER_DROP_SHIFT_Y = (int) (SIZE_Y / 1.2);
	private static final int WATER_DROP_SEPARATION = 32;
	
	private int sceneWidth;
	private WaterDrop waterDrop1, waterDrop2, waterDrop3, waterDrop4, waterDrop5, waterDrop6, waterDrop7, waterDrop8; 	//composite
	
	public Cloud(int sceneWidth) {
		this.sceneWidth = sceneWidth;
		this.waterDrop1 = new WaterDrop(SIZE_X);
		this.waterDrop2 = new WaterDrop(SIZE_X);
		this.waterDrop3 = new WaterDrop(SIZE_X);
		this.waterDrop4 = new WaterDrop(SIZE_X);
		this.waterDrop5 = new WaterDrop(SIZE_X);
		this.waterDrop6 = new WaterDrop(SIZE_X);
		this.waterDrop7 = new WaterDrop(SIZE_X);
		this.waterDrop8 = new WaterDrop(SIZE_X);
	}
	
	public void draw() {
		int x, y;
		int i, j;
		
		for (i = 0; i < NUMBER_CLOUDS; i++) {
			x = RandomNumber.between(0, sceneWidth);
			y = RandomNumber.between(0, MAX_Y_POSITION);
			
			for (j = 0; j < NUMBER_SUB_PARTS; j++) {
				Drawing.getPen().setColor(LIGHT_GRAY);
				Drawing.getPen().fillOval(x, y, SIZE_X, SIZE_Y);
				Drawing.getPen().fillOval(x + SUB_PARTS_SHIFT, y, SIZE_X, SIZE_Y);
				Drawing.getPen().fillOval(x + SUB_PARTS_SHIFT * 2, y, SIZE_X, SIZE_Y);
			}
			
			waterDrop1.drawAt(x + WATER_DROP_SHIFT_1, y + WATER_DROP_SHIFT_Y);
			waterDrop2.drawAt(x + WATER_DROP_SHIFT_1, y + WATER_DROP_SHIFT_Y + WATER_DROP_SEPARATION);
			waterDrop3.drawAt(x + WATER_DROP_SHIFT_1, y + WATER_DROP_SHIFT_Y + WATER_DROP_SEPARATION * 2);
			
			waterDrop4.drawAt(x + WATER_DROP_SHIFT_2, y + WATER_DROP_SHIFT_Y);
			waterDrop5.drawAt(x + WATER_DROP_SHIFT_2, y + WATER_DROP_SHIFT_Y + WATER_DROP_SEPARATION);
			waterDrop6.drawAt(x + WATER_DROP_SHIFT_2, y + WATER_DROP_SHIFT_Y + WATER_DROP_SEPARATION * 2);
			
			waterDrop7.drawAt(x + WATER_DROP_SHIFT_3, y + WATER_DROP_SHIFT_Y);
			waterDrop8.drawAt(x + WATER_DROP_SHIFT_3, y + WATER_DROP_SHIFT_Y + WATER_DROP_SEPARATION);
		}
	}
}
