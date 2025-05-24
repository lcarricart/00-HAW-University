package drawingTool;

import java.util.ArrayList;
import animal.Puddle;

public class Scene {
    private int sceneWidth, sceneHeight;
    private ArrayList<PotentialPuddle> puddles;
    private int maxPuddles = 50;

    public Scene(int width, int height) {
        this.sceneWidth = width;
        this.sceneHeight = height;
        this.puddles = new ArrayList<>();
    }
    
    public void generateRandomPuddles() {
        // System.out.printf("Application width and height: %d, %d \n\n", applicationWidth, applicationHeight);
        int attempts = 0;
        int yLeftMargin = 10;
        int xBottomMargin = 50;
        int sizePuddle = 200;
        int separationMargin = sizePuddle - sizePuddle * (1/3);
        
        while (notMaxAmount(puddles) && notMaxAttempts(attempts)) {
            int x = RandomNumber.between(yLeftMargin, sceneWidth - separationMargin);
            int y = RandomNumber.between(xBottomMargin, sceneHeight - separationMargin);

            Puddle puddle = new Puddle(sizePuddle);
            PotentialPuddle candidate = new PotentialPuddle(puddle, x, y);

            boolean overlaps = false;
            int index = 0;
            // check each existing puddle until either all checked or an overlap found
            while (index < puddles.size() && !overlaps) {
                PotentialPuddle existing = puddles.get(index);
                overlaps = candidate.intersects(existing, separationMargin);
                index++;
            }

            if (!overlaps) {
                puddles.add(candidate);
            }
            
            attempts++;
        }
    }

    public void draw() {
        for (PotentialPuddle other : puddles) {
            other.draw();
        }
    }
    
    public boolean notMaxAmount(ArrayList<PotentialPuddle> puddles) {
        return (puddles.size() < maxPuddles);
    }
    
    public boolean notMaxAttempts(int attempts) {
        return (attempts < 300);
    }
}

