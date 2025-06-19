package background;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;
import drawingTool.RandomNumber;
import animal.Puddle;
import objects.LennonGlasses;
import objects.BeachGlasses;

import java.awt.Color;
import java.util.ArrayList;

public class Ground {
	private final Color BROWN = new Color(104, 66, 53);
	private final int MAX_PUDDLES = 100;
	
	private Grass myGrass;								//composite
    private ArrayList<LocatedRectangle> goodPuddles;	//aggregate
    private int screenWidth, screenHeight;
    private int yShiftGround;
    
    private Puddle puddle;								//composite
    
    private LennonGlasses myLennonGlasses;				//composite
    private BeachGlasses myBeachGlasses;				//composite
	
	public Ground (int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.goodPuddles = new ArrayList<>();
		this.yShiftGround = (int) (screenHeight * 0.3);
		
		myGrass = new Grass();
	}
	
    public void generateRandomPuddles() {
        // System.out.printf("Application width and height: %d, %d \n\n", applicationWidth, applicationHeight);
        int attempts = 0;
        int xLeftMargin = 10;
        int minSize = 100;	//100
        int maxSize = 300;	//300
        
        // This allows the repainting of the scene, because otherwise it would be filled with the same array list.
        goodPuddles.clear();
        
        while (notMaxAmount(goodPuddles) && notMaxAttempts(attempts)) {
        	int sizePuddle  = RandomNumber.between(minSize, maxSize);
        	int sizeGlasses = sizePuddle / 2;
            int sreenMargin = maxSize;
        	
            int x 			 = RandomNumber.between(xLeftMargin, screenWidth - sreenMargin);
            int y 			 = RandomNumber.between(yShiftGround, screenHeight - sreenMargin);
            int wearsGlasses = RandomNumber.between(0, 2);
            
            if (wearsGlasses == 0) {
            	puddle = new Puddle(sizePuddle, x, y);
            } else if (wearsGlasses == 1) {
            	myLennonGlasses = new LennonGlasses(sizeGlasses);
            	puddle = new Puddle(sizePuddle, x, y, myLennonGlasses);
            } else if (wearsGlasses == 2) {
            	myBeachGlasses = new BeachGlasses(sizeGlasses);
            	puddle = new Puddle(sizePuddle, x, y, myBeachGlasses);
            }

            boolean overlaps = false;
            
            // !!!!!!!!!!!!!!!! CHANGE THIS TO A WHILE LOOP, very simple !!!!!!!!!!!!!!!!!!!!!!!
            for (LocatedRectangle existing : goodPuddles) {
                if (puddle.intersects(existing)) {
                    overlaps = true;
                    break;
                }
            }

            if (!overlaps) {
                goodPuddles.add(puddle);
            }
            
            attempts++;
        }
    }
    
	public void draw() {
		Drawing.getPen().setColor(BROWN);
		Drawing.getPen().fillRect(0, yShiftGround, screenWidth, screenHeight);
		
		myGrass.draw(yShiftGround, screenWidth, screenHeight);
		
    	// Drawing happens after drawing all other objects, so they overlap them
		drawGoodPoodles();
	}
	
	public void drawGoodPoodles() {
        for (LocatedRectangle other : goodPuddles) {
            other.draw();
        }
	}
    
    private boolean notMaxAmount(ArrayList<LocatedRectangle> puddles) {
    	return puddles.size() < MAX_PUDDLES;
    }
    
    private boolean notMaxAttempts(int attempts) {
    	return attempts < 300;
    }
    
    public ArrayList<LocatedRectangle> getExistingPoodles() {
    	return goodPuddles;
    }
    
    public void setExistingPoodles(int location) {
    	// IF touched point is in between the rectangle of a Poodle, then remove it from the ArrayList goodPuddles. Redrawing shouldnt happen inside a setter() I think
    }
}
