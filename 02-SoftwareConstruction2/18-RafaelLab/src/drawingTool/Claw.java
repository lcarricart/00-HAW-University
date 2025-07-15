package drawingTool;

import java.awt.*;

public class Claw {
    private static final int CLAW_WIDTH = 5;
    private static final int CLAW_HEIGHT = 5;

    public void drawAt(int left, int bottom, double scale) {
        // Draw 3 scaled claw ovals horizontally
        int scaledWidth = (int) (CLAW_WIDTH * scale);
        int scaledHeight = (int) (CLAW_HEIGHT * scale);

        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().fillOval(left, bottom, scaledWidth, scaledHeight);
        Drawing.pen().fillOval(left + scaledWidth, bottom, scaledWidth, scaledHeight);
        Drawing.pen().fillOval(left + 2 * scaledWidth, bottom, scaledWidth, scaledHeight);
    }

    public static int getBaseWidth() {
        return CLAW_WIDTH;
    }

    public static int getBaseHeight() {
        return CLAW_HEIGHT;
    }
}
