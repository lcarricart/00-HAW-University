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
    
    private Puddle puddle;						//composite
    
    private LennonGlasses myLennonGlasses;		//composite
    private BeachGlasses myBeachGlasses;		//composite
	
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
            int separationMargin = maxSize;
        	
            int x 			 = RandomNumber.between(xLeftMargin, screenWidth - separationMargin);
            int y 			 = RandomNumber.between(yShiftGround, screenHeight - separationMargin);
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
		
    	// Draw the dogs at the end of the scene, so they overlap everything.
        for (LocatedRectangle other : goodPuddles) {
            other.draw();
        }
	}
    
    public boolean notMaxAmount(ArrayList<LocatedRectangle> puddles) {
    	return puddles.size() < MAX_PUDDLES;
    }
    
    public boolean counterNotMax(int i, ArrayList<LocatedRectangle> puddles) {
    	return i < puddles.size();
    }
    
    public boolean notMaxAttempts(int attempts) {
    	return attempts < 300;
    }
}
