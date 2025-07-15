package kangaroo;
import java.awt.Color; //Importing the Color class from the AWT package

import drawingTools.Drawing;

public class Nose {

    private int width, height;      // Properties

    public Nose(int width, int height, Color color) { //Constructor
        this.width = width;
        this.height = height;
    }

    public void drawAt(int left, int bottom) { //Method
        Drawing.pen().setColor(Color.PINK);
        Drawing.pen().drawOval(left, bottom, width, height);
        Drawing.pen().fillOval(left, bottom, width, height);
    }
}
