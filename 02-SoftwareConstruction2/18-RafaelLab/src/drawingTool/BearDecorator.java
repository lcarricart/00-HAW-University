package drawingTool;

import java.awt.Point;

public abstract class BearDecorator implements BearComponent {
    protected BearComponent component;

    public BearDecorator(BearComponent component) {
        this.component = component;
    }
    
    protected abstract void drawDecoration(int left, int bottom);

    @Override
    public void drawAt(int left, int bottom) {
        component.drawAt(left, bottom);
        drawDecoration(left, bottom);
    }

    @Override
    public Size getSize() {
        return component.getSize();
    }

    @Override
    public Pose getPose() {
        return component.getPose();
    }

    @Override
    public BearColor getBearColor() {
        return component.getBearColor();
    }

    @Override
    public int width() {
        return component.width();
    }

    @Override
    public int height() {
        return component.height();
    }

    @Override
    public boolean intersects(LocatedRectangle other) {
        return component.intersects(other);
    }

    @Override
    public Point address() {
        return component.address();
    }

    @Override
    public int getX() {
        return component.getX();
    }

    @Override
    public int getY() {
        return component.getY();
    }

    public BrownBear getBaseBear() {
        BearComponent current = component;

        while (current instanceof BearDecorator decorator) {
            current = decorator.component;
        }

        return (BrownBear) current;
    }
}
