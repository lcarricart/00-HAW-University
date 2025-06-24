package animal;

import java.awt.Color;
import java.awt.Point;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class Pig implements LocatedRectangle{
	
	private Body body;
    private Head head;
    
    private int x ,y, boundWidth, boundHeight, width, height;
    
    public Pig(int width, int height) {
        this(width, height, 0, 0, 0);
    }

    public Pig(int width, int height, int x, int y, int shirtCondition) {
    	
        this.width = width;
        this.height = height;
        this.body = new Body(width, height, shirtCondition);
        this.head = new Head(width, height);
        setPosition(x, y);
    }

    public void setPosition(int x, int y) {
    	
        this.x = x;
        this.y = y;
        
        this.boundWidth = width * 15 / 10;
        this.boundHeight = height * 12 / 10;
    }

    public void drawAt(int left, int bottom) {
       
        body.drawAt(left, bottom, width, height);
        head.drawAt(left + width*85/100, bottom - height*3/10, width, height);
    }
    
    @Override
    public void draw() {
    	
//    	Drawing.getPen().setColor(Color.RED);
//    	Drawing.getPen().fillRect(x - boundWidth / 10, y - boundHeight * 8 / 10, boundWidth, boundHeight);
    	
        drawAt(x, y);
    }

    @Override
    public Point address() {
        int xPosition = x - boundWidth / 10;
        int yPosition = y - boundHeight * 8 / 10;
        return new Point(xPosition, yPosition);
    }

    @Override
    public int width() {
        return boundWidth;
    }

    @Override
    public int height() {
        return boundHeight;
    }
}

