package kangaroo;

import java.awt.*;

import drawingTools.Drawing;

public class Leg {

    private int width, height;      // Properties

    public Leg(int width, int height) { //Constructor
        this.width = width;
        this.height = height;
    }

    public void drawAt(int left, int bottom) { //Method
        Drawing.pen().setColor(Color.YELLOW);
        Drawing.pen().drawOval(left, bottom, width, height);
        Drawing.pen().setColor(Color.ORANGE);
        Drawing.pen().fillOval(left, bottom, width, height);
    }
}
