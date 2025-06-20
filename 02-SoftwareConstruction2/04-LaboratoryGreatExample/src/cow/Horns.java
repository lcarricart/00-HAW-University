package cow;

public class Horns extends RectangularObject {

    public Horns(int width, int height) {
        super(width, height);
    }
    public void drawAt(int left, int bottom) {
        super.drawAt(left, bottom);
        super.fillAt(left, bottom, java.awt.Color.YELLOW);

    }
}


