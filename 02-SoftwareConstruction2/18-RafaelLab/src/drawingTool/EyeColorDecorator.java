package drawingTool;

import java.awt.Color;

public class EyeColorDecorator extends BearDecorator {
    private final Color eyeColor;

    public EyeColorDecorator(BearComponent component, Color eyeColor) {
        super(component);
        this.eyeColor = eyeColor;
    }

    @Override
    protected void drawDecoration(int left, int bottom) {
        // Eye color is updated directly on the head before drawing.
    }

    @Override
    public void drawAt(int left, int bottom) {
        BrownBear baseBear = getBaseBear();
        Head head = baseBear.getHead();
        head.getLeftEye().setColor(eyeColor);
        head.getRightEye().setColor(eyeColor);
        super.drawAt(left, bottom);
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
