package animal;

import java.awt.Color;

import drawingTool.Drawing;
import objects.Glasses;

public class Head {
    private double size;
    private Eyes eye1, eye2;				//composite
    private Nose dogNose;					//composite
    private Glasses myGlasses;				//aggregate
    
    public Head(double size) {
        this.size = size;
        eye1 = new Eyes(size / 20);
        eye2 = new Eyes(size / 20);
        dogNose = new Nose(size / 20);
    }
    
    public Head(double size, Glasses myGlasses) {
        this.size = size;
        eye1 = new Eyes(size / 20);
        eye2 = new Eyes(size / 20);
        dogNose = new Nose(size / 20);
        this.myGlasses = myGlasses;
    }

    public void drawAt(int left, int bottom) {
        double xShiftHead = size / 6;
        double yShiftHead = size / 4;
        double widthHead = size / 2;
        double heightHead = size / 2;

        double xShiftEye1 = size / 4;
        double xShiftEye2 = size / 2;
        double yShiftEye = size / 8;

        double xShiftNose = size / 2.8;
        double yShiftNose = size / 20;

        Drawing.getPen().setColor(Color.GRAY);
        Drawing.getPen().drawOval((int) (left + xShiftHead), (int) (bottom - yShiftHead), (int) widthHead, (int) heightHead);
        Drawing.getPen().fillOval((int) (left + xShiftHead), (int) (bottom - yShiftHead), (int) widthHead, (int) heightHead);

        eye1.drawAt(left + xShiftEye1, bottom - yShiftEye);
        eye2.drawAt(left + xShiftEye2, bottom - yShiftEye);
        dogNose.drawAt(left + xShiftNose, bottom - yShiftNose);
        
        if (myGlasses != null) {
            myGlasses.drawAt(left, bottom, yShiftEye, xShiftEye1, xShiftEye2);
        }
    }
}
