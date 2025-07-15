package drawingTool;

import java.awt.*;

public class Head {
    private static final int BASE_WIDTH = 80;
    private static final int BASE_HEIGHT = 80;
    private static final Color HEAD_COLOR = new Color(139, 69, 19);
    private static final int NORMAL_Y_OFFSET = 90;
    private static final int DANCE_Y_OFFSET = 100;
    private static final int X_OFFSET = 8;
    private static final int DANCE_X_SHIFT = 5;

    private Color color = HEAD_COLOR;

    private final Eye leftEye, rightEye;
    private final Ear leftEar, rightEar;
    private final Nose nose;
    private final Mouth mouth;

    public Head() {
        this.leftEye = new Eye();
        this.rightEye = new Eye();
        this.leftEar = new Ear();
        this.rightEar = new Ear();
        this.nose = new Nose();
        this.mouth = new Mouth();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Eye getLeftEye() {
        return leftEye;
    }

    public Eye getRightEye() {
        return rightEye;
    }

    public void drawAt(int left, int bottom, double scale) {
        Drawing.pen().setColor(color);
        Drawing.pen().fillOval(left, bottom, (int)(BASE_WIDTH * scale), (int)(BASE_HEIGHT * scale));
        leftEar.drawAt(left + (int)(Ear.getLeftEarOffsetX() * scale), bottom + (int)(Ear.getLeftEarOffsetY() * scale), scale);
        rightEar.drawAt(left + (int)(Ear.getRightEarOffsetX() * scale), bottom + (int)(Ear.getRightEarOffsetY() * scale), scale);
        leftEye.drawAt(left + (int)(Eye.getLeftEyeOffsetX() * scale), bottom + (int)(Eye.getLeftEyeOffsetY() * scale), scale);
        rightEye.drawAt(left + (int)(Eye.getRightEyeOffsetX() * scale), bottom + (int)(Eye.getRightEyeOffsetY() * scale), scale);
        nose.drawAt(left + (int)(nose.getBaseOffsetX() * scale), bottom + (int)(nose.getBaseOffsetY() * scale), scale);
        mouth.drawAt(left + (int)(mouth.getBaseOffsetX() * scale), bottom + (int)(mouth.getBaseOffsetY() * scale), scale);
    }

    public void resetColor() {
        this.color = HEAD_COLOR;
    }

    public int getBaseWidth() {
        return BASE_WIDTH;
    }

    public int getBaseHeight() {
        return BASE_HEIGHT;
    }

    public int getNormalYOffset() {
        return NORMAL_Y_OFFSET;
    }

    public int getDanceYOffset() {
        return DANCE_Y_OFFSET;
    }

    public int getXOffset() {
        return X_OFFSET;
    }

    public int getDanceXShift() {
        return DANCE_X_SHIFT;
    }
}
