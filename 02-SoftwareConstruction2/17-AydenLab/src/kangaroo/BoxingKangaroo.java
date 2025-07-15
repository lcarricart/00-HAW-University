package kangaroo;
import java.awt.*;

import drawingTools.Drawing;

public class BoxingKangaroo extends Kangaroo{
    public BoxingKangaroo(int width, int height, int left, int bottom) {        //construction
        super(width, height, left, bottom);
//        this.color = Color.RED; // Set the color to red for the boxing kangaroo
    }



    @Override
    public void draw(){
        super.draw();
        drawGloves();
    }

    public void drawGloves() {
        Graphics pen = Drawing.pen();
        pen.setColor(Color.RED);
        // Example: draw two ovals as gloves at the kangaroo's hands
        // Calculate glove size and position based on width and height
        int gloveWidth = (int)(width() * 0.15);
        int gloveHeight = (int)(height() * 0.15);

        // Right glove (relative to body)
        int rightGloveX = address().x + (int)(width() * 0.80);
        int rightGloveY = address().y + (int)(height() * 0.60);

        // Left glove (relative to body)
        int leftGloveX = address().x + (int)(width() * 0.18);
        int leftGloveY = address().y + (int)(height() * 0.60);

        pen.fillOval(rightGloveX, rightGloveY, gloveWidth, gloveHeight);
        pen.fillOval(leftGloveX, leftGloveY, gloveWidth, gloveHeight);

    }
}
