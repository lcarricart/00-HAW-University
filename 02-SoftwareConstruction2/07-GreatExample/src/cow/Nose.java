package cow;

public class Nose extends RectangularObject{

    private Nostril nostril1;
    private Nostril nostril2;
    private Lips lips;

    public Nose(int width, int height) {
        super(width, height);
        nostril1 = new Nostril(width / 5, width / 5);
        nostril2 = new Nostril(width / 5, width / 5);
        lips = new Lips(width - width / 5, width / 5);
    }

    public void drawAt(int left, int bottom) {
        super.drawAt(left, bottom);
        super.fillAt(left, bottom, java.awt.Color.WHITE);
        nostril1.drawAt(left, bottom);
        nostril2.drawAt(left + width - width/5, bottom);
        lips.drawAt(left + (width / 5)/2, bottom+height - width / 5);
    }

}
