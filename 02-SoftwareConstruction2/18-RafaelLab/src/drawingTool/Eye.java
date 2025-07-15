package drawingTool;

import java.awt.Color;

public class Eye extends FaceFeature {
    private static final int EYES_WIDTH = 8;
    private static final int EYES_HEIGHT = 8;
    private static final Color EYES_COLOR = Color.BLACK;
    private static final int LEFT_EYE_OFFSET_X = 20;
    private static final int LEFT_EYE_OFFSET_Y = 20;
    private static final int RIGHT_EYE_OFFSET_X = 50;
    private static final int RIGHT_EYE_OFFSET_Y = 20;

    public void setColor(Color color) {
        this.color = color;
    }
    
    public Eye() {
        super(EYES_WIDTH, EYES_HEIGHT, EYES_COLOR);
    }

    public static int getLeftEyeOffsetX() {
        return LEFT_EYE_OFFSET_X;
    }

    public static int getLeftEyeOffsetY() {
        return LEFT_EYE_OFFSET_Y;
    }

    public static int getRightEyeOffsetX() {
        return RIGHT_EYE_OFFSET_X;
    }

    public static int getRightEyeOffsetY() {
        return RIGHT_EYE_OFFSET_Y;
    }
}