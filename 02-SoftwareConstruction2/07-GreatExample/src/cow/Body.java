package cow;
import java.awt.Color;

public class Body extends RectangularObject {
	private Spots spot1;
	private Spots spot2;
	private Spots spot3;
	private Spots spot4;
	private Legs leg1;
	private Legs leg2;
	private Legs leg3;
	private Legs leg4;
	private Udder udder;
	private Tail tail;
	boolean facingRight;
	
	public Body(int width, int height, Color spotColor, boolean facingRight) {
		super(width, height);
		this.facingRight = facingRight;
		spot1 = new Spots(height/2, height/2-height/4, spotColor);
		spot2 = new Spots(height/2, height/2-height/4, spotColor);
		spot3 = new Spots(height/2, height/2-height/4, spotColor);
		spot4 = new Spots(height/2 - height/10, height/3, spotColor);

		leg1 = new Legs(height/6, height - (height/2));
		leg2 = new Legs(height/6, height - (height/2) - (height/10));
		leg3 = new Legs(height/6, height - (height/2) - (height/10));
		leg4 = new Legs(height/6, height - (height/2));
	
		udder = new Udder(height/3, width/10);

		tail = new Tail(width/20, height/2);
	}
	
	public void drawAt(int left, int bottom) {
		super.drawAt(left, bottom);
		super.fillAt(left, bottom, Color.WHITE);
		
		spot1.drawAt(left + width - height/2, bottom);
		spot2.drawAt(left + width/2, bottom+height/3);
		spot3.drawAt(left, bottom+height - height/3);
		spot4.drawAt(left + width/10, bottom);

		//spot3.drawAt(left +width/3, bottom+width/8);
		//spot4.drawAt(left -width/5, bottom+width/4);

		leg1.drawAt(left, bottom + height);
		leg2.drawAt(left + height/3, bottom + height);
		leg3.drawAt(left + width - height/6 - height/3, bottom + height);
		leg4.drawAt(left + width - height/6, bottom + height);
		
		if (facingRight == false) {
			udder.drawAt(left + width/3, bottom + height);
			tail.drawAt(left - width/20, bottom);

		}
		else {
			udder.drawAt(left + 2*width/3, bottom + height);
			tail.drawAt(left + width, bottom);
		}
		//udder.drawAt(left + width - height/6 - height/3, bottom + height);
		//tail.drawAt(left + width, bottom);
	}
	
	public void setDirection(boolean direction) {
		facingRight=direction;
	}
}
