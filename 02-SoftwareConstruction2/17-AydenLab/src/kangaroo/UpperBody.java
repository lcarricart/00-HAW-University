package kangaroo;

import java.awt.*;

import drawingTools.Drawing;

public class UpperBody {
    private int width, height; // Properties
    private Arm armL;                 //Property, composite : cannot exist independently
    private Arm armR;                 //Property, composite : cannot exist independently
    private Neck neck;                //Property, composite : cannot exist independently

    public UpperBody(int width, int height) { //Constructor
        this.width = width;
        this.height = height;
        this.armL = new Arm(width /5, height * 4/5); //Creating an instance of the Arm class
        this.armR = new Arm(width /5, height * 4/5); //Creating an instance of the Arm class
        this.neck = new Neck((width / 5)*(20/10), (height / 5)*(40/10)); //Creating an instance of the Neck class
    }

    public void drawAt(int left, int bottom) { ///Method
        neck.drawAt(left + (width / (389/100)), bottom - (height /2)); //Creating an instance of the Neck class
        Drawing.pen().setColor(Color.ORANGE);
        Drawing.pen().fillRoundRect(left, bottom, width, height, width / 2, height / 2);
        armL.drawAt(left - width / 10, bottom + height /4, 25); //Drawing the left arm
        armR.drawAt(left + width - width/ 10, bottom + height /4,-25); //Drawing the right arm
    }
}
