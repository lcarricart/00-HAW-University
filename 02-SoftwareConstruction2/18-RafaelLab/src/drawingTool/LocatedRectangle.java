package drawingTool;

import java.awt.Point;

public interface LocatedRectangle {
    public Point address();
    public int width();
    public int height();
    
    int getX();
    int getY();

    public default boolean intersects(LocatedRectangle other) {
        return !(leftOf(other) || rightOf(other) || above(other) || below(other));
    }

    private boolean leftOf(LocatedRectangle other) {
        return this.address().x + this.width() < other.address().x;
    }

    private boolean rightOf(LocatedRectangle other) {
        return this.address().x > other.address().x + other.width();
    }

    private boolean above(LocatedRectangle other) {
        return this.address().y - this.height() > other.address().y;
    }

    private boolean below(LocatedRectangle other) {
        return this.address().y < other.address().y - other.height();
    }
}
