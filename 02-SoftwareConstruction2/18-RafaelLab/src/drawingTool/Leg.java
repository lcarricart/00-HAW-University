package drawingTool;

import java.awt.Color;

public class Leg {
    private static final int RAW_WIDTH = 20;
    private static final int RAW_HEIGHT = 50;
    private static final int GAP_X = 20;
    private static final int SHIFT = 5;
    private static final int DANCE_FRONT_Y = 10;
    private static final int NORMAL_FRONT_Y = 30;
    private static final int BACK_Y = 140;
    private static final Color LEG_COLOR = new Color(100, 69, 19);

    private Claw claw;

    public Leg() {
        this.claw = new Claw();
    }

    public int getBaseWidth() {
        return RAW_WIDTH;
    }

    public int getBaseHeight() {
        return RAW_HEIGHT;
    }

    public int getBaseGapX() {
        return GAP_X;
    }

    public int getBaseShift() {
        return SHIFT;
    }

    public int getBaseDanceFrontY() {
        return DANCE_FRONT_Y;
    }

    public int getBaseNormalFrontY() {
        return NORMAL_FRONT_Y;
    }

    public int getBaseBackY() {
        return BACK_Y;
    }

    public void drawAt(int left, int bottom, double scale) {
        int scaledWidth = (int)(RAW_WIDTH * scale);
        int scaledHeight = (int)(RAW_HEIGHT * scale);
        Drawing.pen().setColor(LEG_COLOR);
        Drawing.pen().fillRect(left, bottom, scaledWidth, scaledHeight);
        claw.drawAt(left + (int)(2 * scale), bottom + scaledHeight, scale);
    }
}
