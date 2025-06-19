package cow;

public class Nostril extends RectangularObject {

    public Nostril(int width, int height) {
        super(width, height);
    }

    public void drawAt(int left, int bottom) {
        super.fillAt(left, bottom, java.awt.Color.BLACK);
    }

}
