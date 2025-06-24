package drawingTool;

import background.Ground;
import background.Sky;

public class Scene {
	private int sceneWidth, sceneHeight;
    private Ground myGround;	//composite
    private Sky mySky;			//composite
    
    public Scene(int screenWidth, int screenHeight) {
    	this.sceneWidth = screenWidth;
    	this.sceneHeight = screenHeight;
    	this.myGround = new Ground(sceneWidth, sceneHeight);
    	this.mySky = new Sky(sceneWidth, sceneHeight);
    }

    public void draw() {    	
    	mySky.draw();
    	myGround.draw();
    }
    
    public void setGround() {
    	myGround.generateRandomPuddles();
    }
}
