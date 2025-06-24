package objects;

import java.awt.Color;
import drawingTool.Drawing;

public class JewishHat extends Hat {

    private static final Color STRAW = new Color(230, 195, 105);
    private static final Color BAND  = new Color(180,   0,   0);

    private final double brimWidth;
    private final double domeHeight;

    public JewishHat(double size) {
        super(size);
        brimWidth  = size / 3;
        domeHeight = size / 4;
    }

    @Override
    public void drawAt(int left, int bottom) {
        double xShiftHead = size / 6;
        double yShiftHead = size / 4;
        double headHeight = size / 2;
        double headWidth  = size / 2;
        int headTopY      = (int) (bottom - yShiftHead - headHeight);

        // Hat's brim
        int brimLeft  = (int) (left + xShiftHead - brimWidth / 2);
        int brimTop   = headTopY - (int) (brimWidth / 6);
        int brimW     = (int) (headWidth + brimWidth);
        int brimH     = (int) (brimWidth / 6);

        Drawing.getPen().setColor(STRAW);
        Drawing.getPen().fillOval(brimLeft, brimTop, brimW, brimH);

        // Hat Dome
        int domeW   = (int) (headWidth * 0.6);
        int domeX   = (int) (left + xShiftHead + headWidth * 0.2);
        int domeTop = brimTop - (int) domeHeight;

        Drawing.getPen().fillOval(domeX, domeTop, domeW, (int) domeHeight);

        // Middle band
        int bandH   = (int) (domeHeight / 5);
        int bandY   = domeTop + (int) (domeHeight / 2);

        Drawing.getPen().setColor(BAND);
        Drawing.getPen().fillRect(domeX, bandY, domeW, bandH);
    }
    
    @Override
    public int getHeight() {
        return (int) (domeHeight);
    }

}
