package decorators;

import java.awt.Point;
import drawingTool.LocatedRectangle;

public abstract class AccessoryDecorator implements LocatedRectangle {
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
        wrappedHead.draw();
    }
}
