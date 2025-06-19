package cow;

public class Tail extends RectangularObject {

    public Tail(int width, int height) {
        super(width, height);
    }
    
    public void drawAt(int left, int bottom) {
        super.fillAt(left, bottom, java.awt.Color.BLACK);

    }
}
