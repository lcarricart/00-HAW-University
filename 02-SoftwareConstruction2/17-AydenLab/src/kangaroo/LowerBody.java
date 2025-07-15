package kangaroo;

import java.awt.*;

import drawingTools.Drawing;

public class LowerBody {
    private int width, height; // Properties
    private Leg legL;                 //Property, composite : cannot exist independently
    private Leg legR;                 //Property, composite : cannot exist independently
    private Tail tail;                //Property, composite : cannot exist independently
    private Pocket pocket;            //Property, composite : cannot exist independently
    private Foot footL;               //Property, composite : cannot exist independently
    private Foot footR;               //Property, composite : cannot exist independently

    public LowerBody(int width, int height) { ///Constructor
        this.width = width;
        this.height = height;
        this.legL = new Leg(width * 3 / 10, height * 4 / 5); //Creating an instance of the Leg class
        this.legR = new Leg(width * 3 / 10, height * 4 / 5); //Creating an instance of the Leg class
        this.tail = new Tail(width * 7 / 5, height * 1 / 5); //Creating an instance of the Tail class
        this.pocket = new Pocket(width * 1 / 4, height * 3 / 5); //Creating an instance of the Pocket class
        this.footL = new Foot(width * 1 / 4, height * 4 / 5); //Creating an instance of the Foot class
        this.footR = new Foot(width * 1 / 4, height * 4 / 5); //Creating an instance of the Foot class
    }

    public void drawAt(int left, int bottom) { ///Method
        tail.drawAt(left - width * 4 / 5, bottom+height * 1 / 20, 45); //Drawing the tail
        Drawing.pen().setColor(Color.YELLOW);
        Drawing.pen().drawOval(left, bottom, width, height);
        Drawing.pen().setColor(Color.ORANGE);
        Drawing.pen().fillOval(left, bottom, width, height);
        footL.drawAt(left - width / 12, bottom + height * 13 / 10, +25); //Drawing the left foot
        footR.drawAt(left + width * 8 / 10, bottom + height * 13 / 10, -25); //Drawing the right foot
        legL.drawAt(left - width /20, bottom + height * 6/10); //Drawing the left leg
        legR.drawAt(left + width * 7/10, bottom + height * 6/10); //Drawing the right leg
        pocket.drawAt(left + width * 2 / 5, bottom + height * (3 / 4));
    }
}
