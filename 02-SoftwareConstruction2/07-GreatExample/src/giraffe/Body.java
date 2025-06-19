package giraffe;

import java.awt.Color;

import scene.Drawing;

public class Body {

	private int width;
	private int height;
	private Color color;
	private Leg rightFrontLeg; //aggregate
	private Leg leftFrontLeg; //aggregate
	private Leg rightHindLeg; //aggregate
	private Leg leftHindLeg; //aggregate
	private Tail tail; //aggregate
	private BodyPatterns bottomrightpattern; //aggregate
	private BodyPatterns bottomcenterpattern; //aggregate
	private BodyPatterns bottomleftpattern; //aggregate
	private BodyPatterns middlerightpattern; //aggregate
	private BodyPatterns middleleftpattern; //aggregate
	private BodyPatterns toprightpattern; //aggregate
	private BodyPatterns topcenterpattern; //aggregate
	private BodyPatterns topleftpattern; //aggregate
	
	public Body(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
		rightFrontLeg = new Leg(width, height, color);
		leftFrontLeg = new Leg(width, height, color);
		rightHindLeg = new Leg(width, height, color);
		leftHindLeg = new Leg(width, height, color);
		tail = new Tail(width, height, color);
		bottomrightpattern = new BodyPatterns(width, height, color);
		bottomcenterpattern = new BodyPatterns(width, height, color);
		bottomleftpattern = new BodyPatterns(width, height, color);
		middlerightpattern = new BodyPatterns(width, height, color);
		middleleftpattern = new BodyPatterns(width, height, color);
		toprightpattern = new BodyPatterns(width, height, color);
		topcenterpattern = new BodyPatterns(width, height, color);
		topleftpattern = new BodyPatterns(width, height, color);
	}
	
	public void drawAt(int left, int bottom) {
		int legLength = 65 * height/2;
		int bottomPatternHeight = 101 * height/4;
		int middlePatternHeight = 99 * height/4;
		int topPatternHeight = 97 * height/4;
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(left + 4 * width, bottom + 24 * height, width * 1350/100, height * 700/100);
		Drawing.pen().fillRect(left + 7 * width/2, bottom + 49 * height/2, width * 1400/100, height * 700/100);
		Drawing.pen().fillRect(left + 3 * width, bottom + 25 * height, width * 1450/100, height * 700/100);
		Drawing.pen().fillRect(left + 7 * width/2, bottom + 51 * height/2, width * 1400/100, height * 700/100);
		rightFrontLeg.drawAt(left + 16 * width, bottom + legLength);
		leftFrontLeg.drawAt(left + 14 * width, bottom + legLength);
		rightHindLeg.drawAt(left + 6 * width, bottom + legLength);
		leftHindLeg.drawAt(left + 4 * width, bottom + legLength);
		tail.drawAt(left + 3 * width, bottom + 25 * height);
		bottomrightpattern.drawAt(left + 26 * width/2, bottom + bottomPatternHeight);
		bottomcenterpattern.drawAt(left + 18 * width/2, bottom + bottomPatternHeight);
		bottomleftpattern.drawAt(left + 10 * width/2, bottom + bottomPatternHeight);
		middlerightpattern.drawAt(left + 22 * width/2, bottom + middlePatternHeight);
		middleleftpattern.drawAt(left + 14 * width/2, bottom + middlePatternHeight);
		toprightpattern.drawAt(left + 27 * width/2, bottom + topPatternHeight);
		topcenterpattern.drawAt(left + 19 * width/2, bottom + topPatternHeight);
		topleftpattern.drawAt(left + 11 * width/2, bottom + topPatternHeight);
	}
	
	public int getHeight() {
	    return (24 * height - 7 * height) + rightFrontLeg.getHeight();
	}
	
	public int getWidth() {
	    return (145/100 * width + 3 * width);
	}

}
