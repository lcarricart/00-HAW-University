package drawingTool;

import java.awt.Color;

public class Nose extends FaceFeature {
    private static final int NOSE_WIDTH = 10;
    private static final int NOSE_HEIGHT = 10;
    private static final int NOSE_OFFSET_X = 33;
    private static final int NOSE_OFFSET_Y = 38;

    public Nose() {
        super(NOSE_WIDTH, NOSE_HEIGHT, Color.BLACK);
    }

    public int getBaseOffsetX() {
        return NOSE_OFFSET_X;
    }

    public int getBaseOffsetY() {
        return NOSE_OFFSET_Y;
    }
}
