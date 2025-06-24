package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class BackBody 
{
	private double lenght;
	private Leg leg3, leg4;	//composite
	private Tail dogTail;	//composite
	private Fur dogFur;		//aggregate
	
	public BackBody(double lenght, Fur dogFur) 
	{
		this.lenght = lenght;
		this.dogFur = dogFur;
		double sizeLeg = lenght / 5;
		double sizeTail = lenght / 8;
		
		leg3 = new Leg(sizeLeg, dogFur);
		leg4 = new Leg(sizeLeg, dogFur);
		dogTail = new Tail(sizeTail, dogFur);
	}
	
	public void drawAt(double left, double bottom) 
	{
		double widthBackBody = lenght * 0.75;
		double heightBackBody = lenght / 3;
		
		double xShiftLeg1 = lenght / 2.5;
		double xShiftLeg2 = lenght / 2;
		double yShiftLeg = lenght / 3.2;
		
		double xShiftTail = lenght * 0.7;
		double yShiftTail = lenght / 9;
		
		int shape = 0;		//oval
		
		Drawing.getPen().setColor(Color.lightGray);
		Drawing.getPen().drawOval((int)left, (int)bottom, (int)(widthBackBody), (int)(heightBackBody));
		Drawing.getPen().fillOval((int)left, (int)bottom, (int)(widthBackBody), (int)(heightBackBody));
		
		leg3.drawAt((int) (left + xShiftLeg1), (int) (bottom + yShiftLeg));
		leg4.drawAt((int) (left + xShiftLeg2), (int) (bottom + yShiftLeg));
		dogFur.draw((int) left, (int) bottom, widthBackBody, heightBackBody, shape);
		dogTail.drawAt((left + xShiftTail), (bottom + yShiftTail));
	}
}
