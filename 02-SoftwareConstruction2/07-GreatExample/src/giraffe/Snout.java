package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Snout {
	private int width;
	private int height;
	private Color color;
	private Nostril rightNostril; //aggregate
	private Nostril leftNostril; //aggregate
	private Tongue tongue;
	private boolean tongueVisible;

	public Snout(int width, int height) {
		this.width = width * 4;
		this.height = height * 3;
		rightNostril = new Nostril (width, height, color);
		leftNostril = new Nostril (width, height, color);
		tongue = new Tongue (width, height, color);
		tongueVisible = false;
	}
	
	public boolean isTongueVisible() {
		return tongueVisible;
	}
	
	public void setTongueVisible(boolean tongueVisible) {
		this.tongueVisible = tongueVisible;
	}

	public void drawAt(int left, int bottom) {
		if(isTongueVisible()) {
			tongue.drawAt(left + 3 * width/10, bottom + height/4);
		}
		Drawing.pen().setColor(Color.decode("#FFC847"));
		Drawing.pen().fillOval(left, bottom, width, height);
		Drawing.pen().drawOval(left, bottom, width, height);
		rightNostril.drawAt(left + 6 * width/10, bottom + height/4);
		leftNostril.drawAt(left + 3 * width/10, bottom + height/4);
		
	}

	public int getWidth(){
	    return width;
	}
}
	