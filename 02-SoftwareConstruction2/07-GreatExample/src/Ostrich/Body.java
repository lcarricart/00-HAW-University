package Ostrich;

import java.awt.Color;

import scene.Drawing;

public class Body {
	private int width, height;
	private Torso ostrichTorso;
	private Color skinColor, innerColor, outerColor;
	private Feathers innerLayer, outerLayer; 
	private Wing ostrichWing;
	private Tail ostrichTail;
	private Leg leftLeg, rightLeg;
	
	public Body(int size, Color skin, Color fInner, Color fOuter) {
		width = size;
		height = size/2; 
		skinColor = skin;
		innerColor = fInner;
		outerColor = fOuter; 
		ostrichTorso = new Torso(width, height);
		ostrichTail = new Tail(width/2, innerColor);
		innerLayer = new Feathers(width+(size/10), height);
		outerLayer = new Feathers(width+(size/8), height);
		ostrichWing = new Wing(width/2, innerColor, outerColor);
		leftLeg = new Leg(width/13, height*3, skinColor);
		rightLeg = new Leg(width/13, height*3, skinColor);
	}
	
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(skinColor);
		ostrichTorso.drawAt(x, y);
		ostrichTail.drawTail(x+(width/2), y+(height/2));
		Drawing.pen().setColor(innerColor);
		innerLayer.drawAt(x - width/10, y-(width/25));
		Drawing.pen().setColor(outerColor);
		outerLayer.drawAt(x - width/8, y - height/5);
		ostrichWing.drawWing(x, y);
		leftLeg.drawAt(x+width/3, (y+height) - (height/25));
		rightLeg.drawAt((x+width/3) + width/4 ,(y+height) - (height/25));	
	}

}
