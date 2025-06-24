package animal;

import java.awt.Point;
import drawingTool.LocatedRectangle;
import objects.Glasses;
import objects.Hat;

public class Puddle implements LocatedRectangle {
	private FrontBody dogFrontBody; //composite
	private Fur dogFur;				//composite
	private Hat myHat;
	
	private int sizePoodle;
	private int heightPassed;
	private int width;
	
    private int x, y;

	public Puddle(int heightPassed, int x, int y) {
		double sizeFrontBody = heightPassed;
		
		this.x = x;
		this.y = y;
		this.heightPassed = (int) (heightPassed * 0.95);
		this.width  = (int) (heightPassed * 1.08);
		this.sizePoodle = heightPassed;
		this.dogFur = new Fur();
		this.dogFrontBody = new FrontBody(sizeFrontBody, dogFur);
	}
	
	public Puddle(int heightPassed, int x, int y, Glasses myGlasses) {
		double sizeFrontBody = heightPassed;
		
		this.x = x;
		this.y = y;
		this.heightPassed = (int) (heightPassed * 0.95);
		this.width  = (int) (heightPassed * 1.08);
		this.sizePoodle = heightPassed;
		this.dogFur = new Fur();
		this.dogFrontBody = new FrontBody(sizeFrontBody, dogFur, myGlasses);
	}
	
	public Puddle(int heightPassed, int x, int y, Glasses myGlasses, Hat myHat) {
		double sizeFrontBody = heightPassed;
		
		this.x = x;
		this.y = y;
		this.heightPassed = (int) (heightPassed * 0.95);
		this.width  = (int) (heightPassed * 1.08);
		this.sizePoodle = heightPassed;
		this.dogFur = new Fur();
		this.dogFrontBody = new FrontBody(sizeFrontBody, dogFur, myGlasses, myHat);
		this.myHat = myHat; // Used to recalculate the size of the rectangle only
	}
	
	public Puddle(int heightPassed, int x, int y, Hat myHat) {
		double sizeFrontBody = heightPassed;
		
		this.x = x;
		this.y = y;
		this.heightPassed = (int) (heightPassed * 0.95);
		this.width  = (int) (heightPassed * 1.08);
		this.sizePoodle = heightPassed;
		this.dogFur = new Fur();
		this.dogFrontBody = new FrontBody(sizeFrontBody, dogFur, myHat);
		this.myHat = myHat; // Used to recalculate the size of the rectangle only
	}
	
	public int getSize() {
		return sizePoodle;
	}
	
    @Override	// This is a getAddress() method
    public Point address() {
    	if (myHat == null) {
    		return new Point(x, y);
    	} else {
    		return new Point(x, y - myHat.getHeight());
    	}
    }

    @Override	// This is a getHeight() method
    public int width() {
    	return width;
    }

    @Override	// This is a getHeight() method
    public int height() {
    	if (myHat == null) {
    		return heightPassed;
    	} else {
    		return heightPassed + myHat.getHeight();
    	}
    }

    @Override
    public void draw() {
		double yShift = (heightPassed * 0.25);
		
		dogFrontBody.drawAt(x, (int) (y + yShift));
		
//        Drawing.getPen().setColor(Color.red);
//        Drawing.getPen().drawRect(address().x, address().y, width(), height());
    }
}