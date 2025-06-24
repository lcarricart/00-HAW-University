package objects;

import java.awt.Color;
import drawingTool.Drawing;

public class FarmerHat extends Hat {

    private static final Color FELT   = new Color(120, 84, 65);  // brown
    private static final Color RIBBON = new Color( 30, 30, 30);  // black

    private final double brimWidth;
    private final double crownHeight;

    public FarmerHat(double size) {
        super(size);
        brimWidth   = size / 4;
        crownHeight = size / 5;
    }

    @Override
    public void drawAt(int left, int bottom) {
        double xShiftHead = size / 6;
        double yShiftHead = size / 4;
        double headHeight = size / 2;
        int headTopY      = (int) (bottom - yShiftHead - headHeight);

        // Hat's brim
        int brimLeft   = (int) (left + xShiftHead - brimWidth / 2);
        int brimTopY   = headTopY - (int) (brimWidth / 4);
        int brimWidthPx  = (int) (size / 2 + brimWidth);
        int brimHeightPx = (int) (brimWidth / 4);

        Drawing.getPen().setColor(FELT);
        Drawing.getPen().fillRect(brimLeft, brimTopY, brimWidthPx, brimHeightPx);

        // Hat's crown
        int crownLeft   = (int) (left + xShiftHead + size / 20);
        int crownWidth  = (int) (size / 2 - size / 10);
        int crownTopY   = brimTopY - (int) crownHeight;

        Drawing.getPen().fillRect(crownLeft, crownTopY, crownWidth, (int) crownHeight);

        // Hat's ribbon
        int ribbonHeight = (int) (crownHeight / 5);
        int ribbonTopY   = crownTopY + (int) (crownHeight / 2);

        Drawing.getPen().setColor(RIBBON);
        Drawing.getPen().fillRect(crownLeft, ribbonTopY, crownWidth, ribbonHeight);
    }
    
    @Override
    public int getHeight() {
        return (int) (crownHeight);
    }
}
