package background;

public class Scene {
	private int sceneWidth, sceneHeight;
	private boolean drawPoodles = false;
	private boolean drawGround = true;
	
    private Ground myGround;	//composite
    private Sky mySky;			//composite
    
    public Scene(int screenWidth, int screenHeight) {
    	this.sceneWidth = screenWidth;
    	this.sceneHeight = screenHeight;
    	this.myGround = new Ground(sceneWidth, sceneHeight);
    	this.mySky = new Sky(sceneWidth, sceneHeight);
    }

    public void draw() {    	
    	if (drawGround) {
    		mySky.draw();
        	myGround.draw();
    	}
    	
    	// Drawing happens after drawing all other objects, so they overlap them
    	if (drawPoodles) {         
    		myGround.generateRandomPuddles();
            myGround.drawGoodPoodles();
        }
    }
    
    public void setDrawPoodles(boolean value) {
        drawPoodles = value;
    }
    
    public void setDrawGround(boolean value ) {
    	drawGround = value;
    }

    public Ground getGround() {
    	return myGround;
    }
    
    public Sky getSky() {
    	return mySky;
    }
}
