package decorators;

import java.awt.Color;
import java.awt.Polygon;
import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class PartyHat extends Hat {
    private final Color BODY   = new Color(255, 100, 150); // Pink
    private final Color POMPOM = new Color(255, 220,  50); // Yellow
    private final double coneHeight;

    public PartyHat(LocatedRectangle wrappedHead, double size) {
        super(wrappedHead, size);
        this.coneHeight = size / 2.2;
    }

    @Override
    public int extraHeight() {
        return (int)(coneHeight + size / 20);  //coneHeight + pompom height
    }
    
    @Override
    public int extraWidth() {
    	return 0;
    }
    
    @Override
    public void drawAt(int left, int top, int headWidth, int headHeight) {
        
        // Cone
        int baseLeft  = left + (int)(headWidth * 0.15);
        int baseRight = left + (int)(headWidth * 0.85);
        int baseY     = top + (int)(size / 20);

        // The tip of the cone
        int tipX = left + (int)(headWidth * 0.5);
        int tipY = top - (int)coneHeight;

        // Main body
        Polygon cone = new Polygon( new int[] { tipX, baseLeft, baseRight }, new int[] { tipY, baseY, baseY}, 3);

        Drawing.getPen().setColor(BODY);
        Drawing.getPen().fillPolygon(cone);

        // Pompom
        int radius = (int)(size / 20);
        Drawing.getPen().setColor(POMPOM);
        Drawing.getPen().fillOval(tipX - radius, tipY - radius, radius * 2, radius * 2);
        
//        // Debug, draws a red SQUARE where the head reports its position
//	    Point addr = address();
//	    Drawing.getPen().setColor(Color.RED);
//	    Drawing.getPen().fillRect(addr.x, addr.y, 5, 5);
    }
}
