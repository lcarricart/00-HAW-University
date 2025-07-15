package drawingTool;

import java.awt.Color;

public class HatDecorator extends BearDecorator {

    private static final int HAT_BRIM_WIDTH = 50;
    private static final int HAT_BRIM_HEIGHT = 5;
    private static final int HAT_CROWN_WIDTH = 30;
    private static final int HAT_CROWN_HEIGHT = 25;
    private static final int HAT_OFFSET_X = 40;
    private static final int HAT_OFFSET_Y = 90;

    // Constructor
    public HatDecorator(BearComponent bear) {
        super(bear);
    }

    // Decoration logic
    @Override
    protected void drawDecoration(int left, int bottom) {
        double scale = getSize().getScale();
        Drawing.pen().setColor(Color.BLACK);

        // Draw brim (wide part at bottom)
        int brimX = left + (int) (HAT_OFFSET_X * scale);
        int brimY = bottom - (int) (HAT_OFFSET_Y * scale);
        Drawing.pen().fillRect(
            brimX,
            brimY,
            (int) (HAT_BRIM_WIDTH * scale),
            (int) (HAT_BRIM_HEIGHT * scale)
        );

        // Draw crown (tall part above brim)
        int crownX = left + (int) ((HAT_OFFSET_X + (HAT_BRIM_WIDTH - HAT_CROWN_WIDTH) / 2) * scale);
        int crownY = brimY - (int) (HAT_CROWN_HEIGHT * scale);
        Drawing.pen().fillRect(
            crownX,
            crownY,
            (int) (HAT_CROWN_WIDTH * scale),
            (int) (HAT_CROWN_HEIGHT * scale)
        );
    }

    @Override
    public void draw() {
        drawAt(getX(), getY());
    }

    @Override
    public void setBearColor(BearColor color) {
        component.setBearColor(color);
    }

    @Override
    public void setPose(Pose pose) {
        component.setPose(pose);
    }
}
