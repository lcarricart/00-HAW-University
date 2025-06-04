package animal;

import java.awt.Color;
import drawingTool.Drawing;
import objects.Glasses;


public class FrontBody {
	private double lenght;
	private BackBody dogBackBody;	//composite
	private Leg leg1, leg2;			//composite
	private Head dogHead;			//composite
	private Fur dogFur;				//aggregate

	public FrontBody(double lenght, Fur dogFur) {
		double sizeHead = lenght / 2;
		double sizeLeg = lenght / 3;
		this.lenght = lenght;
		this.dogFur = dogFur;

		dogBackBody = new BackBody(lenght, dogFur);
		leg1 = new Leg(sizeLeg, dogFur);
		leg2 = new Leg(sizeLeg, dogFur);
		dogHead = new Head(sizeHead);
	}
	
	public FrontBody(double lenght, Fur dogFur, Glasses myGlasses) {
		double sizeHead = lenght / 2;
		double sizeLeg = lenght / 3;
		this.lenght = lenght;
		this.dogFur = dogFur;

		dogBackBody = new BackBody(lenght, dogFur);
		leg1 = new Leg(sizeLeg, dogFur);
		leg2 = new Leg(sizeLeg, dogFur);
		dogHead = new Head(sizeHead, myGlasses);
	}

	public void drawAt(int left, int bottom) {
		double radiusFrontBody = lenght / 2;

		double xShiftBackBody = lenght / 4;
		double yShiftBackBody = lenght / 7;

		double xShiftLeg1 = lenght / 6;
		double xShiftLeg2 = xShiftLeg1 + lenght / 6;
		double yShiftLeg = lenght / 3;
		
		double yShiftHead = lenght / 15;
		
		int shape = 0;	//oval

		Drawing.getPen().setColor(Color.lightGray);
		Drawing.getPen().drawOval(left, (int) (bottom), (int) (radiusFrontBody), (int) (radiusFrontBody));
		Drawing.getPen().fillOval(left, (int) (bottom), (int) (radiusFrontBody), (int) (radiusFrontBody));

		dogBackBody.drawAt(left + (xShiftBackBody), (bottom + (yShiftBackBody)));
		leg1.drawAt((int) (left + xShiftLeg1), (int) (bottom + yShiftLeg));
		leg2.drawAt((int) (left + xShiftLeg2), (int) (bottom + yShiftLeg));
		
		// I draw it after the parts so the biggest Fur isn't drawn before the small one.
		dogFur.draw(left, bottom, radiusFrontBody, radiusFrontBody, shape);
		dogHead.drawAt(left, (int) (bottom - yShiftHead));
	}

}
