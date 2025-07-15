package kangaroo;

import java.awt.*;
import java.awt.Color; //Importing the Color class from the AWT package

import drawingTools.Drawing;
public class Eye {

    private int width, height;      // Properties
    private Color color;

    public Eye(int width, int height, Color color) { //Constructor
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void drawAt(int left, int bottom) { //Method
        // Draw the outer eye shape (almond-like)
        int[] xPoints = {left, left + width / 2, left + width, left + width / 2};
        int[] yPoints = {bottom + height / 2, bottom, bottom + height / 2, bottom + height};
        Drawing.pen().setColor(Color.WHITE);
        Drawing.pen().fillPolygon(xPoints, yPoints, xPoints.length);

        // Draw the pupil (centered circle)
        int pupilWidth = width / 2;
        int pupilHeight = height / 2;
        int pupilLeft = left + (width - pupilWidth) / 2;
        int pupilBottom = bottom + (height - pupilHeight) / 2;
        Drawing.pen().setColor(this.color);
        Drawing.pen().fillOval(pupilLeft, pupilBottom, pupilWidth, pupilHeight);
    }

    public void setColor(Color color) {
        this.color = color; // Method to change the color of the eye
    }
}
