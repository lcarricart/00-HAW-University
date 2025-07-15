package kangaroo;
import java.awt.*;

import drawingTools.Drawing;

public class Ear {

    private int width, height;      // Properties

    public Ear(int width, int height, Color color) { //Constructor
        this.width = width;
        this.height = height;
    }

    public void drawAt(int left, int bottom, double angleDegrees) { //Method
        // Define the points for a triangular ear shape
        int[] xPoints = {left, left + width / 3, left + width, left + width / 2};
        int[] yPoints = {bottom + height, bottom, bottom + height / 2, bottom + height};
        int nPoints = xPoints.length;

        // Draw the ear shape
        Graphics2D g2 = (Graphics2D) Drawing.pen();
        java.awt.geom.AffineTransform old = g2.getTransform(); // Save the current transformation, rotate the context
        g2.rotate(Math.toRadians(angleDegrees), left + width / 2.0, bottom + height / 2.0);

        Drawing.pen().setColor(Color.ORANGE);
        Drawing.pen().fillPolygon(xPoints, yPoints, nPoints);
        Drawing.pen().setColor(Color.YELLOW);
        Drawing.pen().drawPolygon(xPoints, yPoints, nPoints);

        g2.setTransform(old); // Restore the original transformation so that it doesn't affect other drawings.
    }
}
