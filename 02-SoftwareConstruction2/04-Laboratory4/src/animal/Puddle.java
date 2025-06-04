package animal;

import java.awt.Color;
import java.awt.Point;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;
import objects.Glasses;

public class Puddle implements LocatedRectangle {
	private FrontBody dogFrontBody; //composite
	private Fur dogFur;				//composite
	
	private int sizePoodle;
	private int heightPassed;
	private int width;
	
    private int x, y;

	public Puddle(int heightPassed, int x, int y) {
		double sizeFrontBody = heightPassed;
		
		this.x = x;
		this.y = y;
		this.heightPassed = heightPassed;
		this.width  = (int) (heightPassed * 1.08);
		this.sizePoodle = heightPassed;
		this.dogFur = new Fur();
		this.dogFrontBody = new FrontBody(sizeFrontBody, dogFur);
	}
	
	public Puddle(int heightPassed, int x, int y, Glasses myGlasses) {
		double sizeFrontBody = heightPassed;
		
		this.x = x;
		this.y = y;
		this.heightPassed = heightPassed;
		this.width  = (int) (heightPassed * 1.08);
		this.sizePoodle = heightPassed;
		
		this.dogFur = new Fur();
		this.dogFrontBody = new FrontBody(sizeFrontBody, dogFur, myGlasses);
	}
	
	public int getSize() {
		return sizePoodle;
	}
	
    @Override	// This is a getAddress() method
    public Point address() {
        return new Point(x, y);
    }

    @Override	// This is a getHeight() method
    public int width() {
    	return width;
    }

    @Override	// This is a getHeight() method
    public int height() {
        return heightPassed;
    }

    @Override
    public void draw() {
		double yShift = (heightPassed * 0.25);
		
		dogFrontBody.drawAt(x, (int) (y + yShift));
		
//        Drawing.getPen().setColor(Color.red);
//        Drawing.getPen().drawRect(address().x, address().y, width(), height());
    }
}