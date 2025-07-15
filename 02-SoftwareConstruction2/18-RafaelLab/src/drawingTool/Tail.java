package drawingTool;

import java.awt.Color;

public class Tail {
    private static final int BASE_WIDTH = 20;
    private static final int BASE_HEIGHT = 30;
    private static final Color DEFAULT_COLOR = new Color(139, 69, 19);
    private static final int NORMAL_Y_OFFSET = 30;
    private static final int DANCE_Y_OFFSET = 45;
    private static final int X_SHIFT = 15;

    private Color color;

    public Tail() {
        this.color = DEFAULT_COLOR;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void drawAt(int left, int bottom, double scale) {
        int scaledWidth = (int) (BASE_WIDTH * scale);
        int scaledHeight = (int) (BASE_HEIGHT * scale);

        Drawing.pen().setColor(this.color);
        Drawing.pen().fillOval(left, bottom, scaledWidth, scaledHeight);
    }

    public int getBaseWidth() {
        return BASE_WIDTH;
    }

    public int getBaseHeight() {
        return BASE_HEIGHT;
    }

    public int getBaseNormalYOffset() {
        return NORMAL_Y_OFFSET;
    }

    public int getBaseDanceYOffset() {
        return DANCE_Y_OFFSET;
    }

    public int getBaseXShift() {
        return X_SHIFT;
    }
}
