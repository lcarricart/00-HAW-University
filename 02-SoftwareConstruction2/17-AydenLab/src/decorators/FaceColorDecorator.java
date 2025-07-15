package decorators;

import java.awt.*;

import drawingTools.LocatedRectangle;
import kangaroo.Kangaroo;

public class FaceColorDecorator extends KangarooDecorator {
    private Color faceColor; // Eye object to be decorated

    public FaceColorDecorator(LocatedRectangle kangaroo, Color faceColor) {
        super(kangaroo);
        this.faceColor = faceColor; // Initialize the eye object
    }

    //FaceColorDecorator overrides draw() from LocatedRectangle (via KangarooDecorator).
    @Override
    public void draw() {
    	LocatedRectangle current = decorated;	// decorated variable is coming (inherited) from the super class KangarooDecorator
    	
    	super.draw();
        while (!(current instanceof Kangaroo)) {
        	current = ((KangarooDecorator) current).getPreviousStageOfKangaroo();
        }
        ((Kangaroo) current).setFaceColor(faceColor);
	}	
}
