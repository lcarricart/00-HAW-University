package drawingTool;

import java.awt.Color;

public class WandDecorator extends BearDecorator {
    private static final int WAND_WIDTH = 20;
    private static final int SEGMENT_HEIGHT = 8;
    private static final int WAND_OFFSET_X = 90;
    private static final int WAND_OFFSET_Y = -75;

    private static final Color[] SEGMENT_COLORS = {
        Color.GRAY,
        Color.BLACK,
        Color.GRAY
    };

    public WandDecorator(BearComponent component) {
        super(component);
    }

    @Override
    protected void drawDecoration(int left, int bottom) {
        double scale = getSize().getScale();
        int wandX = left + (int) (WAND_OFFSET_X * scale);
        int wandY = bottom - (int) (WAND_OFFSET_Y * scale);

        // Draw each wand segment in alternating colors
        for (int i = 0; i < 3; i++) {
            Drawing.pen().setColor(SEGMENT_COLORS[i]);
            Drawing.pen().fillRect(
                wandX + (int) (i * WAND_WIDTH * scale),
                wandY,
                (int) (WAND_WIDTH * scale),
                (int) (SEGMENT_HEIGHT * scale)
            );
        }
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
