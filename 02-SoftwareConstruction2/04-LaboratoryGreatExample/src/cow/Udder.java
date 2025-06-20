package cow;

public class Udder extends RectangularObject{
    
    private Nipples nipple1;
    private Nipples nipple2;
    private Nipples nipple3;
    private Nipples nipple4;
    private boolean facingRight;

    public Udder(int width, int height) {
        super(width, height);

        nipple1 = new Nipples(3, 5);
        nipple2 = new Nipples(3, 5);
        nipple3 = new Nipples(3, 5);
        nipple4 = new Nipples(3, 5);
    }
    public void drawAt(int left, int bottom) {
    	if(facingRight==true) {
    		super.drawAt(left - width, bottom);
    		super.fillAt(left - width, bottom, java.awt.Color.PINK);
    		nipple1.drawAt(left- width, bottom + height);
    		nipple2.drawAt(left + width/3 - width, bottom + height);
    		nipple3.drawAt(left + width/3 + width/5 - width, bottom + height);
    		nipple4.drawAt(left + width/3 + width/3 + width/8 - width, bottom + height);
        
    	}
    	else
    	{
    		super.drawAt(left - width, bottom);
            super.fillAt(left - width, bottom, java.awt.Color.PINK);
            nipple1.drawAt(left - width, bottom + height);
            nipple2.drawAt(left + width/3 - width, bottom + height);
            nipple3.drawAt(left + width/3 + width/5 - width, bottom + height);
            nipple4.drawAt(left + width/3 + width/3 + width/8 - width, bottom + height);
    	}
        
    }
    public void setDirection(boolean direction) {
		facingRight=direction;
	}
}
