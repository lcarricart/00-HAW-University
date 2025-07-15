package kangaroo;
import java.awt.*;

import drawingTools.Drawing;

public class Animal {                           //Animal class is the superclass
    protected int width, height, left, bottom; // Properties
    protected Color color;

    public Animal(int width, int height, int left, int bottom) { // Constructor
        this.width = width;
        this.height = height;
        this.left = left;
        this.bottom = bottom;
    }

    public void drawAt(int left, int bottom) { // Method to draw the animal
        Graphics2D g2 = (Graphics2D) Drawing.pen();
        g2.setColor(color);
        g2.fillRect(left, bottom, width, height); // Draw a rectangle as a placeholder for the animal
    }
}
