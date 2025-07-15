package drawingTool;

import java.awt.Color;

public enum BearColor {
    BROWN(new Color(139, 69, 19)),
    DARK_BROWN(new Color(100, 50, 10)),
    BLACK(Color.BLACK);

    private final Color color;

    BearColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
