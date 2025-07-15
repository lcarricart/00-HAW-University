package drawingTool;

import java.awt.Point;

public class BrownBear implements BearComponent {
    private static final int RECTANGLE_WIDTH = 150;
    private static final int RECTANGLE_HEIGHT = 300;

    private int x;
    private int y;
    private Size size;
    private BearColor bearColor;
    private Pose pose;
    
    private Leg frontLeftLeg;
    private Leg frontRightLeg;
    private Leg backLeftLeg; 
    private Leg backRightLeg;
    private Head head;
    private Body body;
    private Tail tail;

    public BrownBear(int x, int y, Size size, BearColor color, Pose pose) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.bearColor = color;
        this.pose = pose;

        this.body = new Body(bearColor.getColor());
        this.head = new Head();
        this.tail = new Tail();
        this.frontLeftLeg = new Leg();
        this.frontRightLeg = new Leg();
        this.backLeftLeg = new Leg();
        this.backRightLeg = new Leg();
    }
    
    public Head getHead() {
        return this.head;  // Expose head for decorators
    }

    public void drawAt(int left, int bottom) {
        this.x = left;
        this.y = bottom;
        double scale = size.getScale();

        // Body measurements
        int bodyWidth = getScaled(body.getBaseWidth());
        int bodyCenterX = left + bodyWidth / 2;
        int headWidth = getScaled(head.getBaseWidth());
        int tailWidth = getScaled(tail.getBaseWidth());

        // Leg measurements
        int legGapX = getScaled(frontLeftLeg.getBaseGapX());
        int legWidth = getScaled(frontLeftLeg.getBaseWidth());
        int legShift = getScaled(frontLeftLeg.getBaseShift());

        // Leg positioning
        int frontY;
        if (pose == Pose.DANCING) {
            frontY = bottom + getScaled(frontLeftLeg.getBaseDanceFrontY());
        } else {
            frontY = bottom + getScaled(frontLeftLeg.getBaseNormalFrontY());
        }
        int backY = bottom + getScaled(frontLeftLeg.getBaseBackY());

        int frontLeftX = bodyCenterX - legGapX - legWidth / 2 + legShift + 5;
        int frontRightX = bodyCenterX + legGapX - legWidth / 2 + legShift + 5;

        // Draw components
        body.drawAt(left, bottom, scale);
        frontLeftLeg.drawAt(frontLeftX, frontY, scale);
        frontRightLeg.drawAt(frontRightX, frontY, scale);
        backLeftLeg.drawAt(frontLeftX, backY, scale);
        backRightLeg.drawAt(frontRightX, backY, scale);

        // Head positioning
        int headX = left + (bodyWidth - headWidth) / 2 + getScaled(head.getXOffset());
        int headY;
        if (pose == Pose.DANCING) {
            headY = bottom - getScaled(head.getDanceYOffset());
            headX += getScaled(head.getDanceXShift());
        } else {
            headY = bottom - getScaled(head.getNormalYOffset());
        }
        head.drawAt(headX, headY, scale);

        // Tail positioning
        int tailX = left - tailWidth + getScaled(tail.getBaseXShift());
        int tailY;
        if (pose == Pose.DANCING) {
            tailY = bottom + getScaled(tail.getBaseDanceYOffset());
        } else {
            tailY = bottom + getScaled(tail.getBaseNormalYOffset());
        }
        tail.drawAt(tailX, tailY, scale);
    }

    private int getScaled(int baseValue) {
        return (int)(baseValue * size.getScale());
    }

    public void draw() {
        drawAt(x, y);
    }

    @Override
    public Point address() {
        return new Point(x, y);
    }

    @Override
    public int width() {
        return getScaled(RECTANGLE_WIDTH);
    }

    @Override
    public int height() {
        return getScaled(RECTANGLE_HEIGHT);
    }
    
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setBearColor(BearColor color) {
        this.bearColor = color;
        body.setColor(color.getColor());
        tail.setColor(color.getColor());
    }

    public void setPose(Pose pose) {
        this.pose = pose;
    }

    public Size getSize() {
        return size;
    }

    public BearColor getBearColor() {
        return bearColor;
    }

    public Pose getPose() {
        return pose;
    }
}