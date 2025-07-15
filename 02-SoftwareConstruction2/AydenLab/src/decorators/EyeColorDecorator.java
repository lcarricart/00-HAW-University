package decorators;

import java.awt.*;

import drawingTools.LocatedRectangle;
import kangaroo.Kangaroo;

public class EyeColorDecorator extends KangarooDecorator {
    private Color eyeColor; // Eye object to be decorated

    public EyeColorDecorator(LocatedRectangle kangaroo, Color eyeColor) {
        super(kangaroo);
        this.eyeColor = eyeColor; // Initialize the eye object
    }

    //EyeColorDecorator overrides draw() from LocatedRectangle (via KangarooDecorator).
    @Override
    public void draw() {
        if (decorated instanceof Kangaroo) {
            ((Kangaroo) decorated).setEyeColor(eyeColor);
        }
        super.draw();
    }
}
