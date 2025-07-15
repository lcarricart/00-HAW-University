package decorators;

import java.awt.Color;
import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class BeachGlasses extends Glasses {
    private final Color BEACH_FRAME = new Color(20, 20, 20);
    private final Color BEACH_LENS  = new Color(213,194,165);  
	
	public BeachGlasses(LocatedRectangle wrappedHead, double size) {
		super(wrappedHead, size);
	}

	@Override
	public void drawAt(int left, int top, double yShiftEye, double xShiftEye1, double xShiftEye2) {
		double yShiftGlass = yShiftEye / 1.35;
		double xShiftGlass1 = xShiftEye1 / 1.9;
		double xShiftGlass2 = xShiftEye2 / 1.1;
		
		double lensY = top + yShiftGlass; // Lenses are drawn slightly above the eye.
        double lensLX = left + xShiftGlass1 ;
        double lensRX = left + xShiftGlass2;
        
        int bridgeY = (int) (lensY + lensDiameter / 2);
        int bridgeX = (int) (lensLX + lensDiameter);
        int bridgeWidth = (int) (lensRX - bridgeX);
        
        // Draw bridge
        Drawing.getPen().setColor(BEACH_FRAME);
        Drawing.getPen().fillRect(bridgeX, bridgeY, bridgeWidth, (int) (lensHeight / 4));
        
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
        
        int templeLength = (int) (size / 6);
        Drawing.getPen().setColor(BEACH_FRAME);
        Drawing.getPen().drawLine((int) (lensRX + lensDiameter), bridgeY, (int) (lensRX + lensDiameter + templeLength), (int) (bridgeY - lensDiameter / 3));
        
//        // Debug, draws a red SQUARE where the head reports its position
//	    Point addr = address();
//	    Drawing.getPen().setColor(Color.BLUE);
//	    Drawing.getPen().fillRect(addr.x, addr.y, 5, 5);
	}
}
