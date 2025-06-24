package drawingTool;

import background.Ground;
import background.LightSky;
import background.Sky;

public class Scene {
	private int sceneWidth, sceneHeight;
    private Ground myGround;	//composite
    private Sky mySky;			//composite
    private LightSky myLightSky;
    
    public Scene(int screenWidth, int screenHeight) {
    	this.sceneWidth = screenWidth;
    	this.sceneHeight = screenHeight;
    	this.myGround = new Ground(sceneWidth, sceneHeight);
    	this.mySky = new Sky(sceneWidth, sceneHeight);
    	this.myLightSky = new LightSky(sceneWidth, sceneHeight);
    }

    public void drawSky() {    	
    	mySky.draw();
    	myGround.draw();
    }
    public void drawLightSky() {    	
    	myLightSky.draw();
    	myGround.draw();
    }
    
    
    public void setGround() {
    	myGround.generateRandomPuddles();
    }
}
