package chick;

import java.awt.Color;

import scene.Drawing;

public class Crest {
	private int height;
	private int width;
	private int crestPosition;
	
	public Crest(int width, int height, int crestPosition) {
		this.width=width/16;
		this.height=height/8;
		this.crestPosition=crestPosition;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.red);
		Drawing.pen().fillRect(left+3*width/2+crestPosition*width, bottom-(height/10)-(height/10)*crestPosition*9, width, (height/10)+(height/10)*crestPosition*9);
		
	}
}

