package kangaroo;
import java.awt.*; //Importing the AWT package

import drawingTools.Drawing;

public class Pocket {

    private int width, height;      // Properties

    public Pocket(int width, int height) { //Constructor
        this.width = width;
        this.height = height;
    }

    public void drawAt(int left, int bottom) { //Method
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawRect(left, bottom, width, height);
        Drawing.pen().setColor(Color.ORANGE);
        Drawing.pen().fillRect(left, bottom, width, height);
    }
}
