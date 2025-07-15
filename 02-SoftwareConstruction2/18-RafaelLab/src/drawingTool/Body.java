package drawingTool;

import java.awt.Color;

public class Body {
    private static final int BODY_WIDTH = 120;
    private static final int BODY_HEIGHT = 160;
    private static final int OFFSET_X = 15;
    private static final int OFFSET_Y = 5;
    private static final Color DEFAULT_BROWN = new Color(139, 69, 19);

    private Color color;
    private Stomach stomach;

    public Body(Color color) {
        this.color = color;
        this.stomach = new Stomach();
    }

    // Set color and synchronize with stomach
    public void setColor(Color color) {
        this.color = color;

        if (!color.equals(DEFAULT_BROWN)) {
            stomach.setColor(color);
        } else {
            stomach.setColor(stomach.getDefaultBrown());
        }
    }

    public void drawAt(int left, int bottom, double scale) {
        int scaledWidth = (int) (BODY_WIDTH * scale);
        int scaledHeight = (int) (BODY_HEIGHT * scale);
        int scaledOffsetX = (int) (OFFSET_X * scale);
        int scaledOffsetY = (int) (OFFSET_Y * scale);

        Drawing.pen().setColor(color);
        Drawing.pen().fillOval(left + scaledOffsetX, bottom - scaledOffsetY, scaledWidth, scaledHeight);

        stomach.drawAt(left, bottom + (int) (stomach.getBaseYOffset() * scale), scale);
    }

    // Getters
    public int getBaseWidth() {
        return BODY_WIDTH;
    }

    public int getBaseHeight() {
        return BODY_HEIGHT;
    }

    public int getBaseXOffset() {
        return OFFSET_X;
    }

    public int getBaseYOffset() {
        return OFFSET_Y;
    }
}
