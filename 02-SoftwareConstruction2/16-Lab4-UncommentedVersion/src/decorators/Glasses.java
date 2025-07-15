package decorators;

import drawingTool.LocatedRectangle;

// I'm using an abstract class just to define the constructor. If not for that, an interface was just enough.
public abstract class Glasses extends AccessoryDecorator {
	protected double size, lensDiameter, lensHeight;
    
    public Glasses(LocatedRectangle wrappedHead, double size) { 
    	super(wrappedHead);
    	this.size = size;
        this.lensDiameter = size / 8;
        this.lensHeight = lensDiameter / 2;
    }
    
    public abstract void drawAt(int left, int top, double yShiftEye, double xShiftEye1, double xShiftEye2);
    
    @Override
    public final void draw() {
    	super.draw();
    	
    	// Get the actual position and dimensions of the head
    	int headX = wrappedHead.address().x;
    	int headY = wrappedHead.address().y;
    	int headWidth = wrappedHead.width();
    	int headHeight = wrappedHead.height();
    	
    	// Positions relative to the head's actual position
        double yShiftEye = headHeight * 0.62;
        double xShiftEye1 = headWidth * 0.15;
        double xShiftEye2 = headWidth * 0.55;
        
        // Head top left position
        drawAt(headX, headY, yShiftEye, xShiftEye1, xShiftEye2);
    }
}
