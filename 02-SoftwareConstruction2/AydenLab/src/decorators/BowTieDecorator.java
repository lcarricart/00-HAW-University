package decorators;
import java.awt.*;

import drawingTools.Drawing;
import drawingTools.LocatedRectangle;
import kangaroo.Kangaroo;

public class BowTieDecorator extends KangarooDecorator{
    public BowTieDecorator(LocatedRectangle decoratedKangaroo) { // Constructor
        super(decoratedKangaroo);
    }

    //CornHatDecorator overrides the draw() method from LocatedRectangle (via KangarooDecorator)
    @Override
    public void draw() {
        super.draw();
        drawBowTie();
    }

    private void drawBowTie() {
        int x = address().x + (width() / 2) - (width() / 150);
        int y = address().y + (height() / 2) - (height() / 8);
        int width = width() / 12;
        int height = height() / 20;
        Graphics pen = Drawing.pen();
        pen.setColor(java.awt.Color.BLUE);
        // Left side
        pen.fillOval((int)(x - width * 0.6), y, width, height);
        // Right side
        pen.fillOval((int)(x + width * 0.6), y, width, height);
        // Center knot
        pen.fillOval(x+width/4, y+height/4, width/2, height/2);
    }
}
