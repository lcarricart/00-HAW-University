package cow;

import scene.Drawing;

public class RectangularObject {

    protected int width;
	protected int height;

    public RectangularObject(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void drawAt(int left, int bottom) {
        Drawing.pen().setColor(java.awt.Color.BLACK);
        Drawing.pen().drawRect(left, bottom, width, height);
    }

    public void fillAt(int left, int bottom, java.awt.Color color) {
        Drawing.pen().setColor(color);
        Drawing.pen().fillRect(left, bottom, width, height);
    }
}
