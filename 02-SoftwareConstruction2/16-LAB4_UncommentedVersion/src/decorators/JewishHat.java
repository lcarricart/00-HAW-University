package decorators;

import java.awt.Color;
import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class JewishHat extends Hat {

    private final Color FELT   = new Color(120, 84, 65);  // brown
    private final Color RIBBON = new Color( 30, 30, 30);  // black

    private final double brimWidth, crownHeight, size;
    private final int brimHeightPx;

    public JewishHat(LocatedRectangle wrappedHead, double size) {
        super(wrappedHead, size);
        brimWidth   = size / 4;
        crownHeight = size / 5;
        this.brimHeightPx = (int)(brimWidth / 4);
        this.size = size;
    }

    @Override
    public int extraHeight() {
        return (int) (crownHeight + brimHeightPx - brimHeightPx); // We account for the brimHeight and for the portion of the hat inside the heat (also brim)
    }
    
    @Override
    public int extraWidth() {
    	return (int) size / 15;
    }
    
    @Override
    public void drawAt(int left, int top, int headWidth, int headHeight) {
    	int brimLeft   = left - (int)(brimWidth / 4);
        int brimTopY   = top + (int) (brimHeightPx / 8);
        int brimWidthPx  = headWidth + (int)(brimWidth / 2);

        Drawing.getPen().setColor(FELT);
        Drawing.getPen().fillRect(brimLeft, brimTopY, brimWidthPx, brimHeightPx);

        // Hat's crown
        int crownLeft   = left + (int)(headWidth * 0.1);
        int crownWidth  = (int)(headWidth * 0.8);
        int crownTopY   = brimTopY - (int)crownHeight;

        Drawing.getPen().fillRect(crownLeft, crownTopY, crownWidth, (int)crownHeight);

        // Hat's ribbon
        int ribbonHeight = (int)(crownHeight / 5);
        int ribbonTopY   = crownTopY + (int)(crownHeight / 2);

        Drawing.getPen().setColor(RIBBON);
        Drawing.getPen().fillRect(crownLeft, ribbonTopY, crownWidth, ribbonHeight);
        
//        // Debug, draws a red SQUARE where the head reports its position
//	    Point addr = address();
//	    Drawing.getPen().setColor(Color.RED);
//	    Drawing.getPen().fillRect(addr.x, addr.y, 5, 5);
    }
}
