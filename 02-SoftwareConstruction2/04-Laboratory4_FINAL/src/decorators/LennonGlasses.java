package decorators;

import java.awt.Color;
import java.awt.Point;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class LennonGlasses extends Glasses {
    private final Color LENNON_FRAME = new Color(0, 180, 220);    // turquoise frame
    private final Color LENNON_LENS  = new Color(180, 220, 255);  // light-blue lens
	
	public LennonGlasses(LocatedRectangle wrappedHead, double size) {
		super(wrappedHead, size);	// This is calling already the super constructor and therefore I inherit size, lensDiameter and lensHeight
		this.size = size;
	}

	@Override
	public void drawAt(int left, int top, double yShiftEye, double xShiftEye1, double xShiftEye2) {
		double yShiftGlass = yShiftEye / 2;
		double xShiftGlass1 = xShiftEye1 / 1.9;
		double xShiftGlass2 = xShiftEye2 / 1.1;
		
		double lensY = top + yShiftGlass; // Lenses are drawn slightly above the eye.
        double lensLX = left + xShiftGlass1;
        double lensRX = left + xShiftGlass2;
        
        // left lens
        Drawing.getPen().setColor(LENNON_LENS);
        Drawing.getPen().fillOval((int) lensLX, (int) lensY, (int) lensDiameter, (int) lensDiameter);
        Drawing.getPen().setColor(LENNON_FRAME);
        Drawing.getPen().drawOval((int) lensLX, (int) lensY, (int) lensDiameter, (int) lensDiameter);

        // right lens
        Drawing.getPen().setColor(LENNON_LENS);
        Drawing.getPen().fillOval((int) lensRX, (int) lensY, (int) lensDiameter, (int) lensDiameter);
        Drawing.getPen().setColor(LENNON_FRAME);
        Drawing.getPen().drawOval((int) lensRX, (int) lensY, (int) lensDiameter, (int) lensDiameter);

        // bridge
        int bridgeY = (int) (lensY + lensDiameter / 2);
        Drawing.getPen().setColor(LENNON_FRAME);
        Drawing.getPen().drawLine((int) (lensLX + lensDiameter), bridgeY, (int) lensRX, bridgeY);

        // side arms
        int templeLength = (int) (size / 6);
        Drawing.getPen().setColor(LENNON_FRAME);
        Drawing.getPen().drawLine((int) (lensRX + lensDiameter), bridgeY, (int) (lensRX + lensDiameter + templeLength), (int) (bridgeY - lensDiameter / 3));
        
//        // Debug, draws a red SQUARE where the head reports its position
//	    Point addr = address();
//	    Drawing.getPen().setColor(Color.BLUE);
//	    Drawing.getPen().fillRect(addr.x, addr.y, 5, 5);
	}
}
