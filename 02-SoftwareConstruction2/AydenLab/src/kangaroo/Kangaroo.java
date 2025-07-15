package kangaroo;
import java.awt.*; //Importing the AWT package
import java.awt.Color; //Importing the Color class from the AWT package

import drawingTools.LocatedRectangle;

public class Kangaroo extends Animal implements LocatedRectangle {                        ///Implementation of the Kangaroo class
    private int width, height;                ///Properties : fields, attributes, instance variables, represent state
    private int left, bottom;
    private KangarooHead kangarooHead;      ///Property, composite : cannot exist independently , Kangaroo has KangarooHead as an object and will probably have more obejects as domain classes.
    private KangarooBody kangarooBody;      ///Property, composite : cannot exist independently ,Kangaroo has KangarooBody as an object and will probably have more obejects as domain classes.
    private Point address; // Address of the kangaroo, used to determine where to draw it on the canvas.

    // Properties are conisdered as a vaiable that are used to store the state of an object.

    // Constructor : initializes the properties of the Kangaroo class.
    public Kangaroo(int width, int height, int left, int bottom) { ///Constructor : initializes the properties.
        super(width, height, left, bottom); // Calling the constructor of the superclass from the Animal class
        this.width = width;
        this.height = height;
        this.left = left;
        this.bottom = bottom;
        kangarooHead = new KangarooHead(width / 3, height / 3, Color.ORANGE);
        kangarooBody = new KangarooBody(width * 2 / 3, height * 2 / 4, Color.ORANGE);
    }

    // Parameters are considered as a variable that are used to pass the value to the method.
    // e.g. width, height, color in the constructor. also left and bottom in the drawAt method.

    public void drawAt(int left, int bottom) { ///Method : Shows the state, Change the state, It can be consiser as a function or message.
        int x = address().x;
        int y = address().y;

        int offSetX = address().x + (width - kangarooBody.width()) / 2 + (width * 140/100);
        int offSetY = address().y + (height - kangarooBody.height()) / 4+ (width * 40/100);

        int offSetXHead = address().x + (width - kangarooHead.width()) / 2 + (width * 10/100);
        int offSetYHead = address().y + (height - kangarooHead.height()) / 4 + (width * 30/1000);

        kangarooBody.drawAt(offSetX, offSetY);
        kangarooHead.drawAt(offSetXHead, offSetYHead);

    }
    // Getters and Setters for the properties
    public Point getAddress() {
        return address; // Getter for the address property
    }
    public void setAddress(Point address) {
        this.address = address; // Setter for the address property
    }

    public void setWidth(int width) {
        this.width = width; // Setter for the width property
    }

    public void setHeight(int height) {
        this.height = height; // Setter for the height property
    }

    //Lab4 task : change the eye color
    //Kangaroo should have a setEyeColor(Color color) method that calls head.setEyecolor(color).
    //KangarooHead already has setEyecolor(Color color) that calls face.setEyecolor(color).
    //Face should have setEyecolor(Color color) that sets the color for the eyes.
    public void setEyeColor(Color color) {
        kangarooHead.setEyecolor(color); // Setter for the eye color of the kangaroo head
    }

    public void setFaceColor(Color color) {
        kangarooHead.setFaceColor(color); // Setter for the face color of the kangaroo head
    }

    //메소드 재정의(@Override) 개념
    //메소드 오버라이딩은 상속된 메소드의 내용이 자식 클래스에 맞지 않을 경우, 자식 클래스에서 동일한 메소드를 재정의하는 것을 말한다.
    //@override
    //@Override annotation above the width() and height() methods mean these methods are implementing (overriding) the methods declared in the LocatedRectangle interface.
    //These @Override are implementation of the LocatedRectangle interface, which requires the Kangaroo class to provide implementations for the address(), width(), height(), and draw() methods.
    //@Override indicates a method is being redefined from a superclass or interface.
    //We can consider Kangaroo class as a child, (subclass) of the Animal class (superclass), and the LocatedRectangle interface is implemented by the Kangaroo class.
    //The @Override annotation is used because these methods (address(), width(), height(), draw()) are declared in the LocatedRectangle interface.
    @Override
    public Point address() {
        return new Point(left, bottom);
    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public void draw() {
        // This method is not implemented in the Kangaroo class, but it is required by the LocatedRectangle interface.
        // It can be used to draw the kangaroo on a canvas or a graphics context.
        // For now, we will leave it empty.
        drawAt(left, bottom); // Returning 0 as a placeholder
//        Drawing.pen().setColor(Color.BLUE);
//        Drawing.pen().drawRect(address().x, address().y, width, height); // Draw a rectangle to represent the kangaroo
    }


    // Comments for self-study:
    // Local variables are considered as a variable that are used to store the value temporarily in the method.
    // It's defined within methods
    // e.g. x and y in the drawAt method, left and bottom in the drawAt method. : I will make x and y soon to avoid using magical values

}
