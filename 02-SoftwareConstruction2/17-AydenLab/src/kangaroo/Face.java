package kangaroo;
import java.awt.*; //Importing the AWT package

import drawingTools.Drawing;

public class Face {

    private int width, height;                  //Property - initialize width and height in KangarooHead class
    private Eye eyeL;                           //Property
    private Eye eyeR;                           //Property
    private Mouth mouth;                        //Property
    private Nose nose;                          //Property
    private Color color;                        //Property to hold the color of the face

    public Face(int width, int height, Color color) { ///Constructor
        this.width = width;
        this.height = height;
        this.color = color; //Setting the color of the face
        this.eyeL = new Eye(width * 26/100,height * 2/10, Color.black); //Creating an instance of the Eye class
        this.eyeR = new Eye(width * 26/100,height * 2/10, Color.black); //Creating an instance of the Eye class
        this.mouth = new Mouth(width* 20/100,5/10, Color.PINK); //Creating an instance of the Mouth class
        this.nose = new Nose(width * 20/100,height * 15/100, Color.PINK); //Creating an instance of the Nose class
    }

    public void drawAt(int left, int bottom) {  ///Method

    // I used int[] which is an array of integers to define the points of the hexagon.
    // e.g. int[] numbers = {1, 2, 3, 4};
    // Then System.out.println(numbers[0]); will print out 1
    // System.out.println(numbers[3]); will print out 4

        // Define the Hexgon points for the face
        int[] xPoints = {
                left + width / 4,          // Top-left
                left + (3 * width) / 4,    // Top-right
                left + width,              // Right
                left + (3 * width) / 4,    // Bottom-right
                left + width / 4,          // Bottom-left
                left                      // Left
        };
        int[] yPoints = {
                bottom - height / 2,       // Top-left
                bottom - height / 2,       // Top-right
                bottom,                    // Right
                bottom + height / 2,       // Bottom-right
                bottom + height / 2,       // Bottom-left
                bottom                     // Left
        };
        int nPoints = xPoints.length;       // the number of vertices (corners) for the polygon shape (6 points in this case)

        // Draw the hexagon
        Drawing.pen().setColor(this.color); // Set the color for the face
        //if I use Drawing.pen().setColor(Color.ORANGE); it will always draw the face in orange color, instead of using the color field.
        //so this.color refers to the current color assigned to the face.


        Drawing.pen().fillPolygon(xPoints, yPoints, nPoints);

        // Draw the outline
        Drawing.pen().setColor(Color.YELLOW);
        Drawing.pen().drawPolygon(xPoints, yPoints, nPoints);

        // Draw the eyes, mouth, and nose
        eyeL.drawAt(left+(width/6), bottom+(height*(1/4)-(height /5))); //Drawing the left eye
        eyeR.drawAt(left+(width*(4)/6),bottom+(height*(1/4)-(height /5))); //Drawing the right eye
        mouth.drawAt(left+(width/2), bottom + (height / 4) + (height /4) ); //Drawing the mouth
        nose.drawAt(left+(width/2),bottom+(height/4)-(height*1/10)); //Drawing the nose
    }

    public void setEyecolor(Color color) { //Method to set the eye color
        //this.color = color;
        this.eyeL.setColor(color); //Setting the color of the left eye
        this.eyeR.setColor(color); //Setting the color of the right eye
    }

    public void setFaceColor(Color color) { //Method to set the face color
        this.color = color; //Setting the color of the face
    }
}
