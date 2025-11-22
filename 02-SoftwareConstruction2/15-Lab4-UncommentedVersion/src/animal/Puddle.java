package animal;

import java.awt.Color;
import java.awt.Point;
import decorators.Hat;
import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class Puddle implements LocatedRectangle {
	private FrontBody dogFrontBody; 		//composite
	private Fur dogFur;						//composite
	private LocatedRectangle wrappedHead;	//aggregate
	
	private int sizePoodle;
    private int x, y;

    public Puddle(int heightPassed, int x, int y, LocatedRectangle wrappedHead) {
    	double sizeFrontBody = heightPassed;
    	
		this.x = x;
		this.y = y;
    	this.sizePoodle = (int) (heightPassed * 0.95);
		this.wrappedHead = wrappedHead;
		this.dogFur = new Fur();
		this.dogFrontBody = new FrontBody(sizeFrontBody, dogFur, wrappedHead);
    }
	
    @Override
    public Point address() {
    	int hatExtra = 0;
    	
        if (wrappedHead instanceof Hat concreteDecoratorHat) {
            hatExtra = concreteDecoratorHat.extraWidth();
        }
        
    	return new Point(x - hatExtra, wrappedHead.address().y);
    }

    @Override
    public int width() { 	
    	int hatExtra = 0;
    	
        if (wrappedHead instanceof Hat concreteDecoratorHat) {
            hatExtra = concreteDecoratorHat.extraWidth();
        }
    	
    	return (int) (dogFrontBody.getWidth() + dogFrontBody.getBackBody().getWidth() + dogFrontBody.getBackBody().getTail().getWidth() + hatExtra);
    }

    @Override
    public int height() {
    	return (int) (dogFrontBody.getHeight() + dogFrontBody.getLeg1().getHeight() + dogFrontBody.getWrappedHead().height());
    }

    @Override
    public void draw() {
		double yShift = (sizePoodle * 0.25);
		
		dogFrontBody.drawAt(x , (int) (y + yShift));
		
//        Drawing.getPen().setColor(Color.red);
//        Drawing.getPen().drawRect(address().x, address().y, width(), height());
    }
    
    public FrontBody getFrontBody() {
    	return dogFrontBody;
    }
}