package drawingTool;

import java.awt.Color;

public class FaceFeature {
    protected final int baseWidth;
    protected final int baseHeight;
    protected Color color;

    // Constructor
    public FaceFeature(int baseWidth, int baseHeight, Color color) {
        this.baseWidth = baseWidth;
        this.baseHeight = baseHeight;
        this.color = color;
    }

    // Setters
    public void setColor(Color color) {
        this.color = color;
    }

    // Drawing
    public void drawAt(int left, int bottom, double scale) {
        int width = (int) (baseWidth * scale);
        int height = (int) (baseHeight * scale);

        Drawing.pen().setColor(color);
        Drawing.pen().fillOval(left, bottom, width, height);
    }

    // Getters
    public int getBaseWidth() {
        return baseWidth;
    }

    public int getBaseHeight() {
        return baseHeight;
    }
}
