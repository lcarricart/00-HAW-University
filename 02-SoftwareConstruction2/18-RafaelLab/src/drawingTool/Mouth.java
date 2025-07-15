package drawingTool;

import java.awt.Color;

public class Mouth {
    private static final int CENTER_X_OFFSET = 9;
    private static final int LEFT_X_OFFSET = 3;
    private static final int RIGHT_X_OFFSET = 15;
    private static final int VERTICAL_OFFSET = 10;
    private static final int SMILE_OFFSET = 15;
    private static final int MOUTH_OFFSET_X = 30;
    private static final int MOUTH_OFFSET_Y = 50;

    public int getBaseOffsetX() {
        return MOUTH_OFFSET_X;
    }

    public int getBaseOffsetY() {
        return MOUTH_OFFSET_Y;
    }

    public void drawAt(int left, int bottom, double scale) {
        int centerX = (int)(CENTER_X_OFFSET * scale);
        int leftX = (int)(LEFT_X_OFFSET * scale);
        int rightX = (int)(RIGHT_X_OFFSET * scale);
        int vertical = (int)(VERTICAL_OFFSET * scale);
        int smile = (int)(SMILE_OFFSET * scale);
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawLine(left + centerX, bottom + smile, left + leftX, bottom + vertical);
        Drawing.pen().drawLine(left + centerX, bottom + smile, left + rightX, bottom + vertical);
    }
}
