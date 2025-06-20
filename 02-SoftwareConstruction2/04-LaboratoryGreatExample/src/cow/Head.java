package cow;
import java.awt.Color;

public class Head extends RectangularObject{

	private Eyes eye1;
	private Eyes eye2;
	private Nose nose;
	private Ears ear1;
	private Ears ear2;
	//private Horns horn1;
	//private Horns horn2;
	public Head(int width, int height) {
		super(width, height);
		eye1 = new Eyes(width/6, width/6);
		eye2 = new Eyes(width/6, width/6);
		nose = new Nose(width-width/2, width/3);
		ear1 = new Ears(width/7, (width/7)*2);
		ear2 = new Ears(width/7, (width/7)*2);
		//horn1 = new Horns(width/7, (width/7)*2);
		//horn2 = new Horns(width/7, (width/7)*2);
	}
	
	public void drawAt(int left, int bottom) {

		super.drawAt(left, bottom);
		super.fillAt(left, bottom, Color.WHITE);


		eye1.drawAt(left - width + ((width/6) / 2) + width, bottom - width/6 + width/6 +width / 3);
		eye2.drawAt(left - width/6 - ((width/6) / 2)+ width, bottom - width/6 + width/6+width / 3);
		nose.drawAt(left - width/2 - width /4+ width, bottom+width/4+width / 3);
		ear1.drawAt(left - (width/7), bottom - (width/7)*2+width / 3 + width/7);
		ear2.drawAt(left+ width, bottom - (width/7)*2+width / 3 + width/7);

		
	}
}
