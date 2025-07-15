package drawingTool;

import java.awt.Color;

public class HeadColorDecorator extends BearDecorator {
    private final Color headColor;

    public HeadColorDecorator(BearComponent component, Color headColor) {
        super(component);
        this.headColor = headColor;
    }

    @Override
    protected void drawDecoration(int left, int bottom) {
        BrownBear baseBear = getBaseBear();
        baseBear.getHead().setColor(headColor);
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
