package kangaroo;

import java.awt.*;

import drawingTools.Drawing;

public class Mouth {

    private int width, height;      // Properties

    public Mouth(int width, int height, Color color) { //Constructor
        this.width = width;
        this.height = height;
    }

    public void drawAt(int left, int bottom) { //Method
        Drawing.pen().setColor(Color.RED);
        Drawing.pen().drawOval(left, bottom, width, height);
        Drawing.pen().fillOval(left, bottom, width, height);
    }
}