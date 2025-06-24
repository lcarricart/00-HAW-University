package objects;

import java.awt.Color;
import java.awt.Polygon;
import drawingTool.Drawing;

public class PartyHat extends Hat {

    private static final Color BODY   = new Color(255, 100, 150); // Pink
    private static final Color POMPOM = new Color(255, 220,  50); // Yellow

    private final double coneHeight;

    public PartyHat(double size) {
        super(size);
        coneHeight = size / 2.2;
    }

    @Override
    public void drawAt(int left, int bottom) {
        double xShiftHead = size / 6;
        double yShiftHead = size / 4;
        double headHeight = size / 2;
        double headWidth  = size / 2;
        int headTopY      = (int) (bottom - yShiftHead - headHeight);

        // The cone
        int baseLeft  = (int) (left + xShiftHead + headWidth * 0.15);
        int baseRight = (int) (left + xShiftHead + headWidth * 0.85);
        int baseY     = headTopY;

        int tipX      = (int) (left + xShiftHead + headWidth * 0.5);
        int tipY      = (int) (headTopY - coneHeight);

        // The Body
        Polygon cone = new Polygon(
            new int[] { tipX, baseLeft, baseRight },
            new int[] { tipY, baseY,    baseY     }, 3);

        Drawing.getPen().setColor(BODY);
        Drawing.getPen().fillPolygon(cone);

        // Circle
        int r = (int) (size / 20);
        Drawing.getPen().setColor(POMPOM);
        Drawing.getPen().fillOval(tipX - r, tipY - r, r * 2, r * 2);
    }
    
    @Override
    public int getHeight() {
        return (int) (coneHeight);
    }

}
