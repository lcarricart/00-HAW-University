package chick;

import java.awt.Color;

import farmer.ColorEye;
import scene.Drawing;
import scene.RandomNumGenerator;

public class Head {
	private Beak beak;	//composite
	private Eye eye;	//composite
	private Crest crestFront;	//composite
	private Crest crestMiddle;	//composite
	private Crest crestBack;	//composite
	private int height;
	private int width;
	public Head(int width, int height, Color color){
		this.width=4*width/10;
		this.height=4*height/10;
		int random=RandomNumGenerator.between(0,100);
		
		if(random%2==0)
			beak = new LargeBeak(width, height);
		else
			beak = new TinyBeak(width, height);
		
		if(random==0)
			eye = new BlindEye(width, height);
		else if(random>0&&random<26)
			eye = new ColorEye(width, height);
		else if(random>25)
			eye = new BlackEye(width, height);
		
		crestFront = new Crest(width, height, 1);
		crestMiddle = new Crest(width, height, 2);
		crestBack = new Crest(width, height, 3);
		}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.white);
		Drawing.pen().fillRect(left-width/2, bottom-height/2, width, height);
		beak.drawAt(left-width/2, bottom-height/2);
		eye.drawAt(left-width/2, bottom-height/2);
		crestFront.drawAt(left-width/2, bottom-height/2);
		crestMiddle.drawAt(left-width/2, bottom-height/2);
		crestBack.drawAt(left-width/2, bottom-height/2);
	}
	
	public void drawAt(int left, int bottom, Color color) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(left-width/2, bottom-height/2, width, height);
		beak.drawAt(left-width/2, bottom-height/2);
		eye.drawAt(left-width/2, bottom-height/2);
		crestFront.drawAt(left-width/2, bottom-height/2);
		crestMiddle.drawAt(left-width/2, bottom-height/2);
		crestBack.drawAt(left-width/2, bottom-height/2);
	}
}
