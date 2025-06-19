package cow;

public class Legs extends RectangularObject {

    public Legs(int width, int height) {
        super(width, height);
    }
    
    public void drawAt(int left, int bottom) {
        super.drawAt(left, bottom);
        super.fillAt(left, bottom, java.awt.Color.WHITE);
    }
}
