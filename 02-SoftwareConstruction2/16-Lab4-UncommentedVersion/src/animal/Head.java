package animal;

import java.awt.Color;
import java.awt.Point;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class Head implements LocatedRectangle {
    private double headSize, headHeight, headWidth;
    private int left, top;
    private Color chosenHeadColor;
    
    private Eyes eye1, eye2;				//composite
    private Nose dogNose;					//composite
    
    public Head(double size, int left, int top, Color chosenHeadColor, Color chosenIrisColor) {
        this.headSize = size;
        this.headHeight = size / 2;
        this.headWidth = size / 2;
        this.left = left;
        this.top = top;
        this.chosenHeadColor = chosenHeadColor;
        
        eye1 = new Eyes(size / 20, chosenIrisColor);
        eye2 = new Eyes(size / 20, chosenIrisColor);
        dogNose = new Nose(size / 20);
    }

    // The head method cant have a drawAt because it knows its own position
    public void drawAt() {
        Drawing.getPen().setColor(chosenHeadColor);
        Drawing.getPen().fillOval(left, top, (int) headWidth, (int) headHeight);
        
        double xShiftEye1 = headWidth * 0.2;
        double xShiftEye2 = headWidth * 0.6;
        double yShiftEye  = headHeight * 0.3;

        eye1.drawAt(left + xShiftEye1, top + yShiftEye);
        eye2.drawAt(left + xShiftEye2, top + yShiftEye);

        double xShiftNose = headWidth * 0.3 - (headSize / 40.0);
        double yShiftNose = headHeight * 0.5;

        dogNose.drawAt(left + xShiftNose, top + yShiftNose); 
    }

	@Override
	public Point address() {
		return new Point(left, top);
	}

	@Override
	public int width() {
		return (int) headWidth;
	}

	@Override
	public int height() {
		return (int) (headHeight - headHeight/2.8); // head height - embedded head height
	}

	@Override
	public void draw() { 
	    drawAt(); 
	    
//	    // Debug, draws a red SQUARE where the head reports its position
//	    Point addr = address();
//	    Drawing.getPen().setColor(Color.RED);
//	    Drawing.getPen().fillRect(addr.x, addr.y, 5, 5);
	}
}
