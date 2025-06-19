package farmer;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import scene.DrawingArea;
import scene.Scenes;

public class FarmerMovement{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean keyPressed=false;
	private int key;
	private Farmer farmer;
	private int sceneIndex;
	private ArrayList<Scenes> scenes = new ArrayList<Scenes>();

	public FarmerMovement(Farmer farmer, int sceneIndex, ArrayList<Scenes> scenes) {
		this.sceneIndex=sceneIndex;
		this.scenes=scenes;
		this.farmer=farmer;
		this.scenes=scenes;
	}
	public void setScenes(int index) {
		this.sceneIndex=index;
	}
	
	public void setKey(int key) {
		this.key=key;
	}

	public void moveFarmer(int sceneIndex) {
		final int step=35;
		
	            if(key==KeyEvent.VK_LEFT){
	            		farmer.setAddress(new Point((farmer.address().x - step), farmer.address().y));
	            		while(!scenes.get(sceneIndex).vacantSpace(farmer))
	            			farmer.setAddress(new Point((farmer.address().x + 1), farmer.address().y));
	            	}
	            if(key==KeyEvent.VK_RIGHT){
	            		farmer.setAddress(new Point((farmer.address().x + step), farmer.address().y));
	            		while(!scenes.get(sceneIndex).vacantSpace(farmer))
	            			farmer.setAddress(new Point((farmer.address().x - 1), farmer.address().y));
	            	}
	            if(key==KeyEvent.VK_UP){
	            		farmer.setAddress(new Point(farmer.address().x, farmer.address().y - step));
	            		while(!scenes.get(sceneIndex).vacantSpace(farmer))
	            			farmer.setAddress(new Point(farmer.address().x, farmer.address().y + 1));
	            	}
	            if(key==KeyEvent.VK_DOWN){
	            		farmer.setAddress(new Point(farmer.address().x, farmer.address().y + step));
	            		while(!scenes.get(sceneIndex).vacantSpace(farmer))
	            			farmer.setAddress(new Point(farmer.address().x, farmer.address().y - 1));
	            	}
	}
	
	/*	
	public void Idle(boolean keyPressed) {
		if(!keyPressed) {
			int count[]= {0,0,0,0};

        	while(!scene.vacantSpace(scene.farmer)) {
        		scene.farmer.setAddress(new Point(scene.farmer.address().x, scene.farmer.address().y - 1));
        		count[0]++;
        	}
        	scene.farmer.setAddress(new Point(scene.farmer.address().x, scene.farmer.address().y + 1*count[0]));
        	
        	while(!scene.vacantSpace(scene.farmer)) {
        		scene.farmer.setAddress(new Point(scene.farmer.address().x, scene.farmer.address().y + 1));
        		count[1]++;
        	}
        	scene.farmer.setAddress(new Point(scene.farmer.address().x, scene.farmer.address().y - 1*count[1]));
        	
        	while(!scene.vacantSpace(scene.farmer)) {
        		scene.farmer.setAddress(new Point((scene.farmer.address().x + 1), scene.farmer.address().y));
        		count[2]++;
        	}
        	scene.farmer.setAddress(new Point((scene.farmer.address().x - 1*count[2]), scene.farmer.address().y));
        	
        	while(!scene.vacantSpace(scene.farmer)) {
        		scene.farmer.setAddress(new Point((scene.farmer.address().x - 1), scene.farmer.address().y));
        		count[3]++;
        	}
        	scene.farmer.setAddress(new Point((scene.farmer.address().x + 1*count[3]), scene.farmer.address().y));
        	
        	int min=10;
        	for(int i=0; i<4; i++) {
        		for(int j=1; j<4; j++) {
        			if(returnLowest(count[i], count[j])<min)
        					min=returnLowest(count[i], count[j]);
        		}
        	}
        	if(min==count[0]) {
        		scene.farmer.setAddress(new Point(scene.farmer.address().x, scene.farmer.address().y - 1*min));
        	}
        	else if(min==count[1]) {
        		scene.farmer.setAddress(new Point(scene.farmer.address().x, scene.farmer.address().y + 1*min));
        	}
        	else if(min==count[2]) {
        		scene.farmer.setAddress(new Point((scene.farmer.address().x + 1*min), scene.farmer.address().y));
        	}
        	else if(min==count[3]) {
        		scene.farmer.setAddress(new Point((scene.farmer.address().x - 1*min), scene.farmer.address().y));
        	}
		}
	}*/
}
