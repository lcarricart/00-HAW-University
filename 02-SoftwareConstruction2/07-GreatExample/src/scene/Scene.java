package scene;

import java.awt.Color;
import javax.swing.*;

import Ostrich.Ostrich;
import background.Fence;
import background.LocatedRectangle;
import background.Speed;
import chick.Chick;
import cow.Cow;
import farmer.Farmer;
import farmhouse.FarmHouse;
import giraffe.Giraffe;
import horse.Horse;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Point;
import java.util.ArrayList;

public class Scene extends SceneSec{
	private static final int LENGTH = 900; //800;
	private static final int HEIGHT = 750; //500;
	private static final int XSTART = 50; //50;
	private static final int YSTART = 50; //300;
	private static final int FENCE = 50;
	private static final int MARGIN = 5;
	private static final int BULLETSPEED = 25;
	
	private ArrayList<LocatedRectangle> chicks = new ArrayList<LocatedRectangle>();
	public  ArrayList<LocatedRectangle>parts = new ArrayList<LocatedRectangle>();
	public Farmer farmer;
	private Horse horse;
	private Giraffe giraffe;
	private boolean color;
	
	public Scene(int sceneIndex, Farmer farmer, boolean color){
		super(farmer, sceneIndex, new Rectangle(new Point(XSTART, YSTART+FENCE), new Dimension(LENGTH, HEIGHT)), true, initializeHouse());
		this.color=color;
		this.farmer= farmer;
		for(int i = 0; i<25; i++) {
			addNewChick(i);
		}
		horse = new Horse(200, 75, new Point(1350,700), Color.black);
		giraffe = new Giraffe(new Point(1450,200), 8, 8, Color.orange);
		parts.add(horse);
		parts.add(giraffe);
		//super.setAnimal(parts);
		super.setParts(chicks);
	}
	
	private static FarmHouse initializeHouse() {
		return new FarmHouse(new Point(1000,20), 500, 350);
	}
	
	
	public Farmer getFarmer() {
		return farmer;
	}
	
	public void draw(boolean colorExists, boolean hitBox, Point lastKey, int darkness) {
		super.draw(lastKey, darkness);
		farmer.setDirection(lastKey);
		//chickMovement(colorExists, hitBox);
	}
	
	public void draw(Point lastKey, int darkness) {
		super.draw(lastKey, darkness);
		farmer.setDirection(lastKey);
		//chickMovement(false, false);
	}
	
	/*private void chickMovement(boolean colorExists, boolean hitBox) {
			for(LocatedRectangle c: chicks) {
				c.setSpeed(new Point(c.getSpeed().x, c.getSpeed().y));
				
				if(c.address().x<XSTART || c.address().x+c.width()>LENGTH+XSTART) {
					c.setSpeed(new Point(-c.getSpeed().x, c.getSpeed().y));
				}
				if(c.address().y<YSTART || c.address().y+c.height()>HEIGHT+YSTART) {
					c.setSpeed(new Point(c.getSpeed().x, -c.getSpeed().y));
				}
				if(!vacantSpace(c,1)||!checkFarmer(c)) {
					c.setSpeed(new Point(-c.getSpeed().x, -c.getSpeed().y));				
				} 
				if (hitBox)
					c.hitBoxVisible(c);
			}
	}*/
	
	/*public void drawHouse() {
		farmHouse.drawAt();
		Drawing.pen().setColor(new Color(218,165,32, 255));
		Drawing.pen().fillRect(farmHouse.getFacade().getMainBuild().getDoor().getLocation().x, farmHouse.getFacade().getMainBuild().getDoor().getLocation().y+farmHouse.getFacade().getMainBuild().getDoor().getHeight(), farmHouse.getFacade().getMainBuild().getDoor().getWidth(), 1000);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect(farmHouse.getFacade().getMainBuild().getDoor().getLocation().x, farmHouse.getFacade().getMainBuild().getDoor().getLocation().y+farmHouse.getFacade().getMainBuild().getDoor().getHeight(), farmHouse.getFacade().getMainBuild().getDoor().getWidth(), 1000);
	}*/
	
	private void drawDarkness(int darkness) {
		Drawing.pen().setColor(new Color(0,0,0, darkness));
		Drawing.pen().fillRect(0, 0, TestDrawingTool.screenSize().width, TestDrawingTool.screenSize().height);
	}
	
	public void addNewChick(int cycle) {
		int width = 43*RandomNumGenerator.between(1, 3);
		int height = 40*RandomNumGenerator.between(1, 3);
		int colorR = RandomNumGenerator.between(0, 255);
		int colorG = RandomNumGenerator.between(0, 255);
		int colorB = RandomNumGenerator.between(0, 255);
		int colorA = RandomNumGenerator.between(250, 255);
		int xSpeed = RandomNumGenerator.between(-1, 1);
		int ySpeed = RandomNumGenerator.between(-1, 1);
		int left = RandomNumGenerator.between(XSTART, LENGTH-width-MARGIN);
		int bottom = RandomNumGenerator.between(YSTART, HEIGHT-height-MARGIN);
		int id = cycle;
		if(xSpeed==0&&ySpeed==0) {
			ySpeed=1;
			xSpeed=1;
		}
		Point chickSpeed = new Point(xSpeed, ySpeed);
		Color color = new Color (colorR, colorG, colorB, colorA);
		Point address = new Point(left, bottom);
		Chick newChick;
		if (this.color) {
			newChick = new Chick(address, width, width, color, chickSpeed, id);
		}
		else {
			newChick = new Chick(address, width, width, Color.white, chickSpeed, id);
		}
		
		if(vacantSpace(newChick,1)&&checkFarmer(newChick)) {
			chicks.add(newChick);
			parts.add(newChick);
		}
	}
	
	public boolean vacantSpace(LocatedRectangle object) {
		return super.vacantSpace(object);
		}
	
	private boolean vacantSpace(LocatedRectangle newChick, int x) {
		boolean anyIntersection = false ;
		
		for (LocatedRectangle c : chicks) {
			if(!(c==newChick))
					anyIntersection = anyIntersection || c.intersects (newChick);
		}
		return !anyIntersection ;
	}
	
	public Scene getScene() {
		return this;
	}
	
	public boolean checkFarmer(LocatedRectangle object) {
		boolean anyIntersection = false ;
		anyIntersection = farmer.intersects (object);
		
		return !anyIntersection ;
		}
}
