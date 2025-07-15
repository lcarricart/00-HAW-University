package decorators;

import java.awt.Point;
import drawingTool.LocatedRectangle;

public abstract class AccessoryDecorator implements LocatedRectangle {

    /** the object that was passed in and will be drawn first */
    protected final LocatedRectangle wrappedHead;

    protected AccessoryDecorator(LocatedRectangle wrappedHead) {
        this.wrappedHead = wrappedHead;
    }

    @Override 
    public Point address() { 
    	return wrappedHead.address(); 
    }
    
    @Override 
    public int width() { 
    	return wrappedHead.width();   
    }
    
    @Override
    public int height() {
    	return wrappedHead.height();
    }

    @Override
    public void draw() {
        wrappedHead.draw(); // Paints whats in the wrap, the other classes include their drawings after
    }
}
