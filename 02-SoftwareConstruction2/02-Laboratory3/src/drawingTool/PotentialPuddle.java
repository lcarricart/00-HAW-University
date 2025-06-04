package drawingTool;

import java.awt.Point;
import animal.Puddle;

public class PotentialPuddle implements LocatedRectangle {
    Puddle puddle; //aggregate
    int x, y;
    int width;
    int height;

    public PotentialPuddle(Puddle puddle, int x, int y) {
        this.puddle = puddle;
        this.x = x;
        this.y = y;
    }

    @Override
    public Point getAddress() {
        return new Point(x, y);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void draw() {
        puddle.drawAt(x, y);
    }
}