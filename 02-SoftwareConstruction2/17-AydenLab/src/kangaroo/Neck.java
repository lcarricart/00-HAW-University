package kangaroo;
import java.awt.*; //Importing the AWT package

import drawingTools.Drawing;

public class Neck {

    private int width, height;      // Properties

    public Neck(int width, int height) { //Constructor
        this.width = width;
        this.height = height;
    }

    public void drawAt(int left, int bottom) { //Method
        Drawing.pen().setColor(Color.YELLOW);
        Drawing.pen().drawRect(left, bottom, width, height);
        Drawing.pen().setColor(Color.ORANGE);
        Drawing.pen().fillRect(left, bottom, width, height);
    }
}
