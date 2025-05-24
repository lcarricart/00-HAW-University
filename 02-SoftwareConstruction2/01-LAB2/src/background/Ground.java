package background;

import drawingTool.Drawing;
import drawingTool.PotentialPuddle;
import drawingTool.RandomNumber;
import animal.Puddle;

import java.awt.Color;
import java.util.ArrayList;

public class Ground {
	private static final Color BROWN = new Color(104, 66, 53);
	private static final int MAX_PUDDLES = 50;
	
	private Grass myGrass;
    private ArrayList<PotentialPuddle> puddles;
    private int screenWidth, screenHeight;
    private int yShiftGround;
	
	public Ground (int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.puddles = new ArrayList<>();
		this.yShiftGround = (int) (screenHeight * 0.3);
		
		myGrass = new Grass();
	}
	
    public void generateRandomPuddles() {
        // System.out.printf("Application width and height: %d, %d \n\n", applicationWidth, applicationHeight);
        int attempts = 0;
        int xLeftMargin = 10;
        int minSize = 10;
        int maxSize = 300;
        
        while (notMaxAmount(puddles) && notMaxAttempts(attempts)) {
        	int sizePuddle = RandomNumber.between(minSize, maxSize);
            int separationMargin = maxSize; // sizePuddle - sizePuddle * (1/3);
        	
            int x = RandomNumber.between(xLeftMargin, screenWidth - separationMargin);
            int y = RandomNumber.between(yShiftGround, screenHeight - separationMargin);

            Puddle puddle = new Puddle(sizePuddle);
            PotentialPuddle candidate = new PotentialPuddle(puddle, x, y);

            boolean overlaps = false;
            int i = 0;
            
            while (counterNotMax(i, puddles) && (!overlaps)) {
            	overlaps = candidate.intersects(puddles.get(i), separationMargin);
            	i++;
            }
            
            if (!overlaps) {
                puddles.add(candidate);
            }
            
            attempts++;
        }
    }
    
	public void draw() {
		Drawing.getPen().setColor(BROWN);
		Drawing.getPen().fillRect(0, yShiftGround, screenWidth, screenHeight);
		
		myGrass.draw(yShiftGround, screenWidth, screenHeight);
		
    	// Draw the dogs at the end of the scene, so they overlap everything.
        for (PotentialPuddle other : puddles) {
            other.draw();
        }
	}
    
    public boolean notMaxAmount(ArrayList<PotentialPuddle> puddles) {
    	return puddles.size() < MAX_PUDDLES;
    }
    
    public boolean counterNotMax(int i, ArrayList<PotentialPuddle> puddles) {
    	return i < puddles.size();
    }
    
    public boolean notMaxAttempts(int attempts) {
    	return attempts < 300;
    }
}
