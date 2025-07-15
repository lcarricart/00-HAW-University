package decorators;
import java.awt.Point;

import drawingTools.LocatedRectangle;

//public abstract class KangarooDecorator extends Kangaroo{
//    protected Kangaroo decoratedKangaroo;
//
//    public KangarooDecorator(Kangaroo kangaroo) {
//        super(kangaroo.width(), kangaroo.height(), kangaroo.address().x, kangaroo.address().y);
//        this.decoratedKangaroo = kangaroo;
//    }
//    @Override
//    public void draw() {
//        decoratedKangaroo.draw();
//    }
//}

// Decorator base
public abstract class KangarooDecorator implements LocatedRectangle {
    protected LocatedRectangle decorated;

    public KangarooDecorator(LocatedRectangle decorated) {
        this.decorated = decorated;
    }

    @Override
    public int width() { return decorated.width(); }
    @Override
    public int height() { return decorated.height(); }
    @Override
    public Point address() { return decorated.address(); }
    @Override
    public void draw() { decorated.draw(); }
    
    public LocatedRectangle getPreviousStageOfKangaroo() {
    	return decorated;
    }
}