package drawingTool;

import java.awt.Color;

public class Ear extends FaceFeature {
    private static final int EAR_WIDTH = 20;
    private static final int EAR_HEIGHT = 20;
    private static final Color EAR_COLOR = new Color(139, 69, 19);
    private static final int LEFT_EAR_OFFSET_X = -6;
    private static final int LEFT_EAR_OFFSET_Y = -16;
    private static final int RIGHT_EAR_OFFSET_X = 60;
    private static final int RIGHT_EAR_OFFSET_Y = -20;

    public Ear() {
        super(EAR_WIDTH, EAR_HEIGHT, EAR_COLOR);
    }

    public static int getLeftEarOffsetX() {
        return LEFT_EAR_OFFSET_X;
    }

    public static int getLeftEarOffsetY() {
        return LEFT_EAR_OFFSET_Y;
    }

    public static int getRightEarOffsetX() {
        return RIGHT_EAR_OFFSET_X;
    }

    public static int getRightEarOffsetY() {
        return RIGHT_EAR_OFFSET_Y;
    }
}