package decorators;

import java.awt.Point;

import drawingTool.LocatedRectangle;

public abstract class Hat extends AccessoryDecorator {
    protected final double size;

    protected Hat(LocatedRectangle wrappedHead, double size) {
    	super(wrappedHead);
        this.size = size;
    }

    // Template Method
    public abstract void drawAt(int left, int top, int headWidth, int headHeight);
    
    @Override
    public final void draw() {
    	super.draw(); // Draws whats before him
    	
    	// Actual position of the head
    	int headLeft = wrappedHead.address().x;
    	int headTop = wrappedHead.address().y;
    	int headWidth = wrappedHead.width();
    	int headHeight = wrappedHead.height();
    	
    	// Head top left position
    	drawAt(headLeft, headTop, headWidth, headHeight);
    }
    
    @Override
    public int height() {
        // Accounts for the head + the unimplemented extra height
        return wrappedHead.height() + extraHeight();
    }
    
    @Override
    public int width() {
    	int sizeHead = wrappedHead.width();
    	int sizeHeadWithHat = wrappedHead.width() + extraWidth();
    	int hatExtension = 0;
    	
    	if (sizeHeadWithHat > sizeHead) {
    		hatExtension = (sizeHeadWithHat - sizeHead) / 2;	// One half is inside the rectangle, but one half goes outside of it.
    	}
    	
    	return hatExtension;	// since all the head was already inside the rectangle, we consider this parameter as the extra width
    }
    
    @Override
    public Point address() {
        Point headAddr = wrappedHead.address();
        return new Point(headAddr.x, headAddr.y - extraHeight());
    }
    
    protected abstract int extraHeight();
    
    // This function helps the width() in Puddle class to adjust correctly accounting only for the small part of the hat that goes outside the LocatedRectangle box
    public int extraWidth() {
        return width() - wrappedHead.width();
    }
}
