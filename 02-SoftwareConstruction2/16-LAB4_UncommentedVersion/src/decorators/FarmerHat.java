package decorators;

import java.awt.Color;
import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class FarmerHat extends Hat {

    private final Color STRAW = new Color(230, 195, 105);
    private final Color BAND  = new Color(180, 0, 0);

    private final double brimWidth, domeHeight, size;
    private final int brimHeight;

    public FarmerHat(LocatedRectangle wrappedHead, double size) {
        super(wrappedHead, size);
        brimWidth 	 	= size / 3;
        domeHeight		= size / 4;
        this.brimHeight = (int)(brimWidth / 6);
        this.size		= size;
    }
    
    @Override
    public int extraHeight() {
        return (int)(domeHeight + brimHeight - brimHeight);  // Dome + Brim - part inside the head (also brim)
    }
    
    @Override
    public int extraWidth() {
    	return (int) (size / 12);
    }

    @Override
    public void drawAt(int left, int top, int headWidth, int headHeight) {
    	int brimLeft  = left - (int)(brimWidth / 4);
        int brimTop   = top;
        int brimW     = headWidth + (int)(brimWidth / 2);

        Drawing.getPen().setColor(STRAW);
        Drawing.getPen().fillOval(brimLeft, brimTop, brimW, brimHeight);

        // Hat Dome
        int domeW   = (int)(headWidth * 0.6);
        int domeX   = left + (int)(headWidth * 0.2);
        int domeTop = brimTop - (int)domeHeight;

        Drawing.getPen().fillOval(domeX, domeTop, domeW, (int)domeHeight);

        // Middle band
        int bandH   = (int)(domeHeight / 5);
        int bandY   = domeTop + (int)(domeHeight / 2);

        Drawing.getPen().setColor(BAND);
        Drawing.getPen().fillRect(domeX, bandY, domeW, bandH);
        
//        // Debug, draws a red SQUARE where the head reports its position
//	    Point addr = address();
//	    Drawing.getPen().setColor(Color.RED);
//	    Drawing.getPen().fillRect(addr.x, addr.y, 5, 5);
    }
}
