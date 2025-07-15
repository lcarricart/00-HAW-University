package drawingTool;

import java.awt.Color;

public class Stomach {
    private static final int BASE_WIDTH = 60;
    private static final int BASE_HEIGHT = 80;
    private static final int OFFSET_X = 45;
    private static final int OFFSET_Y = 30;
    private static final Color STOMACH_BROWN = new Color(205, 133, 63);

    private Color color;

    public Stomach() {
        this.color = STOMACH_BROWN;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void drawAt(int left, int bottom, double scale) {
        int scaledWidth = (int) (BASE_WIDTH * scale);
        int scaledHeight = (int) (BASE_HEIGHT * scale);
        int scaledOffsetX = (int) (OFFSET_X * scale);

        Drawing.pen().setColor(this.color);
        Drawing.pen().fillOval(left + scaledOffsetX, bottom, scaledWidth, scaledHeight);
    }

    public int getBaseWidth() {
        return BASE_WIDTH;
    }

    public int getBaseHeight() {
        return BASE_HEIGHT;
    }

    public int getBaseXOffset() {
        return OFFSET_X;
    }

    public int getBaseYOffset() {
        return OFFSET_Y;
    }

    public int getWidth() {
        return BASE_WIDTH;
    }

    public int getHeight() {
        return BASE_HEIGHT;
    }

    public int getXOffset() {
        return OFFSET_X;
    }

    public Color getDefaultBrown() {
        return STOMACH_BROWN;
    }
}
