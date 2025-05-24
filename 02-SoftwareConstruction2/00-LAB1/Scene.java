package drawingTool;

import java.awt.Point;
import java.util.ArrayList;
import animal.Puddle;

public class Scene {
	private int applicationWidth, applicationHeight;
    private ArrayList<PositionedPuddle> puddles;

    public Scene(int width, int height) {
    	applicationWidth = width;
    	applicationHeight = height;
    	
        puddles = new ArrayList<>();
        int maxPuddles = 50;
        int attempts = 0;
        int yLeftMargin = 10;
        int xBottomMargin = 50;
        int sizePuddle = 400;
        int scaling = sizePuddle - sizePuddle * (1/3);
        
        System.out.printf("Application width and height: %d, %d \n\n", applicationWidth, applicationHeight);

        //Puddles fitting screen only
        while (puddles.size() < maxPuddles && attempts < 300) {
        	int x = RandomNumber.between(yLeftMargin, applicationWidth - 180);
        	int y = RandomNumber.between(xBottomMargin, applicationHeight - 180);
            
            Puddle puddle = new Puddle(sizePuddle);
            PositionedPuddle newPuddle = new PositionedPuddle(puddle, x, y);

            boolean overlaps = false;
            for (PositionedPuddle other : puddles) {
                if (newPuddle.intersects(other, scaling)) {
                    overlaps = true;
                    break;
                }
            }

            if (!overlaps) {
                puddles.add(newPuddle);
            }

            attempts++;
        }
    }

    public void draw() {
        for (PositionedPuddle puddle : puddles) {
            puddle.draw();
        }
    }

    private class PositionedPuddle implements LocatedRectangle {
        Puddle puddle;
        int x, y;
        int width = 60;
        int height = 40;

        PositionedPuddle(Puddle puddle, int x, int y) {
            this.puddle = puddle;
            this.x = x;
            this.y = y;
        }

        @Override
        public Point address() {
            return new Point(x, y);
        }

        @Override
        public int width() {
            return width;
        }

        @Override
        public int height() {
            return height;
        }

        @Override
        public void draw() {
            puddle.drawAt(x, y);
        }
    }
}
