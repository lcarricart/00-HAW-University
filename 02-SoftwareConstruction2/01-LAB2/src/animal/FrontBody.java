package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class FrontBody {
	private double lenght;
	private BackBody dogBackBody;	//composite
	private Leg leg1, leg2;			//composite
	private Head dogHead;			//composite

	public FrontBody(double lenght) {
		double sizeHead = lenght / 2;
		double sizeLeg = lenght / 3;
		this.lenght = lenght;

		dogBackBody = new BackBody(lenght);
		leg1 = new Leg(sizeLeg);
		leg2 = new Leg(sizeLeg);
		dogHead = new Head(sizeHead);
	}

	public void drawAt(int left, int bottom) {
		double radiusFrontBody = lenght / 2;

		double xShiftBackBody = lenght / 4;
		double yShiftBackBody = lenght / 7;

		double xShiftLeg1 = lenght / 6;
		double xShiftLeg2 = xShiftLeg1 + lenght / 6;
		double yShiftLeg = lenght / 3;
		
		double yShiftHead = lenght / 15;

		Drawing.getPen().setColor(Color.lightGray);
		Drawing.getPen().drawOval(left, (int) (bottom), (int) (radiusFrontBody), (int) (radiusFrontBody));
		Drawing.getPen().fillOval(left, (int) (bottom), (int) (radiusFrontBody), (int) (radiusFrontBody));

		dogHead.drawAt(left, (int) (bottom - yShiftHead));
		dogBackBody.drawAt(left + (xShiftBackBody), (bottom + (yShiftBackBody)));
		leg1.drawAt((int) (left + xShiftLeg1), (int) (bottom + yShiftLeg));
		leg2.drawAt((int) (left + xShiftLeg2), (int) (bottom + yShiftLeg));
	}

}
