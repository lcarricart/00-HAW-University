package kangaroo;

import java.awt.*;

public class KangarooBody { ///Implementation of the KangarooBody class

    private int width;                //Property - initialize width in KangarooBody class
    private int height;               //Property - initialize height in KangarooBody class
    private UpperBody upperBody;       //Property, composite : cannot exist independently - initialize upperBody in KangarooBody class
    private LowerBody lowerBody;       //Property, composite : cannot exist independently - initialize lowerBody in KangarooBody class

// Question: Should KangarooHead be a property of KangarooBody? or should it be a property of Kangaroo?
//    private KangarooHead kangarooHead; //Property, composite : cannot exist independently - initialize kangarooHead in KangarooBody class

    public KangarooBody(int width, int height, Color color) { ///Constructor
        this.width = width;
        this.height = height;
        this.upperBody = new UpperBody(width *2/3, height/2); //Creating an instance of the UpperBody class
        this.lowerBody = new LowerBody(width * 3/4, height * 2 / 5); //Creating an instance of the LowerBody class
    }

    public void drawAt(int left, int bottom) { ///Method
        lowerBody.drawAt(left + (width - (width *288/100)), bottom + (height /10)*3);
        upperBody.drawAt(left + (width - (width *285/100)), bottom - (height / 20));
    }

    public void print() {       //From the Lecture to check and print out in the main class
        System.out.println("KangarooBody:Total (width + height) = "+ (width + height)+ width + height);
    }

    public int width() {        //Getter for width
        return width;
    }
    public int height() {       //Getter for height
        return height;
    }
}
