package background;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;
import drawingTool.RandomNumber;
import animal.Head;
import animal.Puddle;
import decorators.BeachGlasses;
import decorators.FarmerHat;
import decorators.JewishHat;
import decorators.LennonGlasses;
import decorators.PartyHat;

import java.awt.Color;
import java.util.ArrayList;

public class Ground {
	private final Color BROWN = new Color(104, 66, 53);
	private final int MAX_PUDDLES = 100;
	
	private Grass myGrass;								//composite
	private Puddle puddle;								//composite
    private ArrayList<LocatedRectangle> goodPuddles;	//aggregate
    private LocatedRectangle wrappedHead;				//aggregate
    
    private int screenWidth, screenHeight;
    private int yShiftGround;
    private int glassesKind = 0;
    private int hatKind = 0;
    private boolean randomizeGlasses = false;
    private boolean randomizeHat = false;
    private Color chosenHeadColor = Color.gray;
    private Color chosenIrisColor = Color.BLACK;
	
	public Ground (int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.goodPuddles = new ArrayList<>();
		this.yShiftGround = (int) (screenHeight * 0.3);
		
		myGrass = new Grass();
	}
	
	 public ArrayList<LocatedRectangle> getExistingPoodles() {
	    	return goodPuddles;
	    }
	    
	    public void setGlassesKind(int value) {
	    	if (value == 3) {
	    		randomizeGlasses = true;
	    	} else {
	    		randomizeGlasses = false;
	    		glassesKind = value;
	    	}
	    }
	    
	    public void setHatKind(int value) {
	    	if (value == 4) {
	    		randomizeHat = true;
	    	} else {
	    		randomizeHat = false;
	    		hatKind = value;
	    	}
	    }
	    
	    public void setHeadColor(Color value) {
	    	chosenHeadColor = value;
	    }
	    
	    public void setIrisColor(Color value) {
	    	chosenIrisColor = value;
	    }
	    
	    public Puddle getPoodle() {
	    	return puddle;
	    }
	
    public void generateRandomPuddles() {
        // This allows the repainting of the scene, because otherwise it would be filled with the same array list.
        goodPuddles.clear();
    	
        int attempts = 0;
        int xLeftMargin = 10;
        int minSize = 100;	//100
        int maxSize = 300;	//300
        
        while (notMaxAmount(goodPuddles) && notMaxAttempts(attempts)) {
        	int sizePuddle  = RandomNumber.between(minSize, maxSize);
        	int sizeHead = sizePuddle / 2;
            int screenMargin = maxSize;
        	
            int x 			 = RandomNumber.between(xLeftMargin, screenWidth - screenMargin);
            int y 			 = RandomNumber.between(yShiftGround, screenHeight - screenMargin);
            int headBottom   = (int) (y + sizeHead * 0.2);
            
            if (randomizeGlasses == true) { // RANDOM glasses ON
            	glassesKind = RandomNumber.between(0, 2);
            }
            
            if (randomizeHat == true) { // RANDOM hats ON
            	hatKind = RandomNumber.between(0, 3);
            }
            
            switch(glassesKind + hatKind) {
            case 0: // (0, 0)
            	wrappedHead = new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor); break;
            default:
            	switch(hatKind) {
            	case 0:
            		switch(glassesKind) {
            		//case 0:  (0, 0) done
            		case 1: // (0, 1)
            			wrappedHead = new LennonGlasses(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead); break;
            		default: // (0, 2)
            			wrappedHead = new BeachGlasses(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead); break;
            		} break;
            	case 1:
            		switch(glassesKind) {
            		case 0: // (1, 0)
            			wrappedHead = new FarmerHat(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead); break;
            		case 1: // (1, 1)
            			wrappedHead = new FarmerHat(new LennonGlasses(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead), sizeHead); break;
            		default: // (1, 2)
            			wrappedHead = new FarmerHat(new BeachGlasses(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead), sizeHead); break;
            		} break;
            	case 2:
            		switch(glassesKind) {
            		case 0: // (2, 0)
            			wrappedHead = new PartyHat(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead); break;
            		case 1: // (2, 1)
            			wrappedHead = new PartyHat(new LennonGlasses(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead), sizeHead); break;
            		default: // (2, 2)
            			wrappedHead = new PartyHat(new BeachGlasses(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead), sizeHead); break;
            		} break;
            	default:
            		switch(glassesKind) {
            		case 0: // (3, 0)
            			wrappedHead = new JewishHat(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead); break;
            		case 1: // (3, 1)
            			wrappedHead = new JewishHat(new LennonGlasses(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead), sizeHead); break;
            		default: // (3, 2)
            			wrappedHead = new JewishHat(new BeachGlasses(new Head(sizeHead, x, headBottom, chosenHeadColor, chosenIrisColor), sizeHead), sizeHead); break;
            		} break;
            	} break;
            }
            
            puddle = new Puddle(sizePuddle, x, y, wrappedHead);
            
            boolean overlaps = false;
            int i = 0;

            while (notLastElement(i, goodPuddles.size()) && !overlaps) {
                LocatedRectangle existing = goodPuddles.get(i);

                if (puddle.intersects(existing)) {
                    overlaps = true;
                }
                
                i++;
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
    
    private boolean notLastElement(int i, int size) {
    	return i < size;
    }
}
