package kangaroo;
import java.awt.*; //Importing the AWT package

import drawingTools.Drawing;

public class Tail {

    private int width, height;      // Properties

    public Tail(int width, int height) { //Constructor
        this.width = width;
        this.height = height;
    }

    public void drawAt(int left, int bottom, double angleDegrees) { //Method
        // Draw the tail as an oval shape
        Graphics2D g2 = (Graphics2D) Drawing.pen();
        java.awt.geom.AffineTransform old = g2.getTransform(); // Save the current transformation, rotate the context
        g2.rotate(Math.toRadians(angleDegrees), left + width / 2.0, bottom + height / 2.0);

        Drawing.pen().setColor(Color.YELLOW);
        Drawing.pen().drawOval(left, bottom, width, height);
        Drawing.pen().setColor(Color.ORANGE);
        Drawing.pen().fillOval(left, bottom, width, height);

        g2.setTransform(old); // Restore the original transformation so that it doesn't affect other drawings.
    }
}
