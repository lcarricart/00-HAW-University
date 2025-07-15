package decorators;
import java.awt.*;

import drawingTools.Drawing;
import drawingTools.LocatedRectangle;
import kangaroo.Kangaroo;

public class CornHatDecorator extends KangarooDecorator{

    public CornHatDecorator(LocatedRectangle kangaroo) {
        super(kangaroo);
    }

    //CornHatDecorator overrides the draw() method from LocatedRectangle (via KangarooDecorator)
    @Override
    public void draw() {
        super.draw();
        drawCornHat();
    }

    private void drawCornHat() {
        int x = address().x + (width() / 2) + (width() / 13);
        int y = address().y - (height() / 10)+ (height() / 10);
        int width = width() / 10;          // Make hat narrower
        int height = height() / 10;
        int[] xPoints = {x, x - width / 2, x + width / 2};
        int[] yPoints = {y, y + height, y + height};
        Graphics pen = Drawing.pen();
        pen.setColor(Color.RED);
        pen.fillPolygon(xPoints, yPoints, 3);
        pen.setColor(Color.ORANGE);
        pen.drawPolygon(xPoints, yPoints, 3);
    }

}
