package objects;

// I'm using an abstract class just to define the constructor. If not for that, an interface was just enough.
public abstract class Glasses {
	protected double size, lensDiameter, lensHeight;
    
    public Glasses(double size) {    	
    	this.size = size;
        this.lensDiameter = size / 8;
        this.lensHeight   = lensDiameter / 2;
    }
    
    // Forces implementation
    public abstract void drawAt(int left, int bottom, double yShiftEye, double xShiftEye1, double xShiftEye2);
}
