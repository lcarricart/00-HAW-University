package cow;

public class Nipples extends RectangularObject {
    
    public Nipples(int width, int height) {
        super(width, height);
    }
    
    public void drawAt(int left, int bottom) {
        super.drawAt(left, bottom);
        super.fillAt(left, bottom, java.awt.Color.PINK);
    }
}
