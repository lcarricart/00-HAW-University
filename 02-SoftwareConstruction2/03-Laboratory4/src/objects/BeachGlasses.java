package objects;

import java.awt.Color;

import drawingTool.Drawing;

public class BeachGlasses extends Glasses {
    private static final Color BEACH_FRAME = new Color(20, 20, 20);    // dark black frame
    private static final Color BEACH_LENS  = new Color(213,194,165);   // slightly lighter lens
	
	public BeachGlasses(double size) {
		super(size);		// This is calling already the super constructor and therefore I inherit size, lensDiameter and lensHeight
	}

	@Override
	public void drawAt(int left, int bottom, double yShiftEye, double xShiftEye1, double xShiftEye2) {
        double lensY   = bottom - yShiftEye - lensDiameter / 20;
        double lensLX = left + xShiftEye1 - lensDiameter / 3;
        double lensRX = left + xShiftEye2 - lensDiameter / 3;
        int bridgeY = (int) (lensY + lensDiameter / 3);
        int bridgeX = (int) (lensLX + lensDiameter);
        
        // Draw bridge
        Drawing.getPen().setColor(BEACH_FRAME);
        Drawing.getPen().fillRect(bridgeX, bridgeY, (int) (lensDiameter*2.5), (int) (lensHeight / 4));
        
        // Draw left lens        
        Drawing.getPen().setColor(BEACH_FRAME);
        Drawing.getPen().drawRect((int) lensLX, (int) lensY, (int) lensDiameter, (int) lensHeight);
        Drawing.getPen().setColor(BEACH_LENS);
        Drawing.getPen().fillRect((int) lensLX, (int) lensY, (int) lensDiameter, (int) lensHeight);

        // Draw right lens        
        Drawing.getPen().setColor(BEACH_FRAME);
        Drawing.getPen().drawRect((int) lensRX, (int) lensY, (int) lensDiameter, (int) lensHeight);
        Drawing.getPen().setColor(BEACH_LENS);
        Drawing.getPen().fillRect((int) lensRX, (int) lensY, (int) lensDiameter, (int) lensHeight);
	}
}
