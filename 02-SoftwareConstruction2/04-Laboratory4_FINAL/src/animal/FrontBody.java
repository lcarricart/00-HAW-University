package animal;

import java.awt.Color;
import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class FrontBody {
	private double sizeFrontBody;
	private BackBody dogBackBody;			//composite
	private Leg leg1, leg2;					//composite
	private Fur dogFur;						//aggregate
	private LocatedRectangle wrappedHead;	//aggregate, decorated head

	public FrontBody(double lenght, Fur dogFur, LocatedRectangle wrappedHead) {
		double sizeLeg = lenght / 3;
		this.sizeFrontBody = lenght;
		this.dogFur = dogFur;
		this.wrappedHead = wrappedHead;

		dogBackBody = new BackBody(lenght, dogFur);
		leg1 = new Leg(sizeLeg, dogFur);
		leg2 = new Leg(sizeLeg, dogFur);
	}

	public void drawAt(int left, int bottom) {
		double radiusFrontBody = sizeFrontBody / 2;

		double xShiftBackBody = sizeFrontBody / 4;
		double yShiftBackBody = sizeFrontBody / 7;

		double xShiftLeg1 = sizeFrontBody / 6;
		double xShiftLeg2 = xShiftLeg1 + sizeFrontBody / 6;
		double yShiftLeg = sizeFrontBody / 3;
		
		int shape = 0;	//oval

		Drawing.getPen().setColor(Color.lightGray);
		Drawing.getPen().drawOval(left, (int) (bottom), (int) (radiusFrontBody), (int) (radiusFrontBody));
		Drawing.getPen().fillOval(left, (int) (bottom), (int) (radiusFrontBody), (int) (radiusFrontBody));

		dogBackBody.drawAt(left + (xShiftBackBody), (bottom + (yShiftBackBody)));
		leg1.drawAt((int) (left + xShiftLeg1), (int) (bottom + yShiftLeg));
		leg2.drawAt((int) (left + xShiftLeg2), (int) (bottom + yShiftLeg));
		
		// I draw it after the parts so the biggest Fur isn't drawn before the small one.
		dogFur.draw(left, bottom, radiusFrontBody, radiusFrontBody, shape);
		wrappedHead.draw();
	}
	
	public Leg getLeg1() {
		return leg1;
	}
	
	public LocatedRectangle getWrappedHead() {
		return wrappedHead;
	}
	
	public BackBody getBackBody() {
		return dogBackBody;
	}
	
	public double getHeight() {
		return sizeFrontBody / 2;
	}
	
	public double getWidth() {
		return sizeFrontBody / 2;
	}
}
