package kangaroo;
import java.awt.*;

public class KangarooHead {                     ///Implementation of the KangarooHead class

    private int width, height;                  //Property - initialize width and height in KangarooHead class
    private Face face;                          //Property, composite : cannot exist independently
    private Ear earL;                           //Property, composite : cannot exist independently
    private Ear earR;                           //Property, composite : cannot exist independently

    public KangarooHead(int width, int height, Color color) { ///Constructor
        this.width = width;
        this.height = height;
        this.face = new Face(width * 8/10, height * 6/10, Color.ORANGE); //Creating an instance of the Face class
        this.earL = new Ear(width * 25/100,height * 2/10, Color.ORANGE); //Creating an instance of the Ear class
        this.earR = new Ear(width * 25/100,height * 2/10, Color.ORANGE); //Creating an instance of the Ear class
    }

    public void drawAt(int left, int bottom) {  ///Method
        int x = left + width / 2; //Calculating the center x-coordinate
        int y = bottom - height / 2; //Calculating the center y-coordinate
        face.drawAt(left, bottom); //Drawing the face
        earL.drawAt(left+ width / 9 - width /14, bottom-height / 3,135); //Drawing the left ear
        earR.drawAt(left + width - (width/10)- width /(309/100), bottom-height / 3, -225); //Drawing the right ear
    }

    public void print() {        //From the Lecture to check and print out in the main class
        System.out.println("KangarooBody:Total (width + height) = "+ (width + height)+ width + height);
    }

    public int width() {         //Getter for width
        return width;
    }
    public int height() {        //Getter for height
        return height;
    }

    public void setEyecolor(Color color) { //Setter for the color of the face
        face.setEyecolor(color);
    }

    public void setFaceColor(Color color) { //Setter for the color of the face
        face.setFaceColor(color);
    }
}
