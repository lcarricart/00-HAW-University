package objects;

import java.awt.Color;

import drawingTool.Drawing;

public class LennonGlasses extends Glasses {
    private static final Color LENNON_FRAME = new Color(0, 180, 220);    // turquoise frame
    private static final Color LENNON_LENS  = new Color(180, 220, 255);  // light-blue lens
	
	public LennonGlasses(double size) {
		super(size);	// This is calling already the super constructor and therefore I inherit size, lensDiameter and lensHeight
	}

	@Override
	public void drawAt(int left, int bottom, double yShiftEye, double xShiftEye1, double xShiftEye2) {
        double lensY   = bottom - yShiftEye - lensDiameter / 15;
        double lensLX = left + xShiftEye1 - lensDiameter / 3;
        double lensRX = left + xShiftEye2 - lensDiameter / 3;
        int bridgeY = (int) (lensY + lensDiameter / 3);
        
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

        // bridge between lenses
        Drawing.getPen().setColor(LENNON_FRAME);
        Drawing.getPen().drawLine((int) (lensLX + lensDiameter), bridgeY, (int) lensRX, bridgeY);

        // optional temples (side arms)
        int templeLength = (int) (size / 6);
        Drawing.getPen().setColor(LENNON_FRAME);
        Drawing.getPen().drawLine((int) (lensRX + lensDiameter), bridgeY, (int) (lensRX + lensDiameter + templeLength), (int) (bridgeY - lensDiameter / 3));
        Drawing.getPen().drawLine((int) lensLX, bridgeY, (int) (lensLX - templeLength), (int) (bridgeY - lensDiameter / 3));
	}
}
