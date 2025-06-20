package cow;
import java.awt.Color;

public class Spots extends RectangularObject {

    private Color spotColor;
    
    public Spots(int width, int height, java.awt.Color spotColor) {
        super(width, height);
        this.spotColor = spotColor;
    }
    
    public void drawAt(int left, int bottom) {
        super.fillAt(left, bottom, spotColor);
    }

}
