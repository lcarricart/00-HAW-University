package cow;

public class Lips extends RectangularObject {

    public Lips(int width, int height) {
        super(width, height);
    }

    public void drawAt(int left, int bottom) {
        //Drawing.pen().fillRect(left - noseWidth - noseWidth/3 + height*2 - height/2 , bottom + noseWidth - height, width, height);
        super.fillAt(left, bottom, java.awt.Color.BLACK);
    }

}
