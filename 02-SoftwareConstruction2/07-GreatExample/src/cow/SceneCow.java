package cow;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import background.Fence;
import background.LocatedRectangle;
import background.Speed;
import chick.Chick;
import farmer.Farmer;
import scene.Drawing;
import scene.RandomNumGenerator;
import scene.SceneSec;
import scene.TestDrawingTool;

public class SceneCow extends SceneSec{
	private Point location;
	private int width;
	private int height;
	private final int SIZE = 15;
	private final int MAX_COW_WIDTH = 150;
	private final int MIN_COW_WIDTH = 75;
	private final int MAX_COW_HEIGHT = 75;
	private final int MIN_COW_HEIGHT = 50;
	private ArrayList<Cow> cows; // aggregate
	public ArrayList<LocatedRectangle>parts = new ArrayList<LocatedRectangle>();
	private Farmer farmer;
	private Fence fence;
	
	public SceneCow(int sceneIndex, Point location, int width, int height, Farmer farmer) {
		super(farmer, sceneIndex, new Rectangle(new Point(location.x, location.y+50), new Dimension(width, height)), true);
		this.farmer=farmer;
		this.location=location;
		this.width = width;
		this.height = height;
		this.cows = new ArrayList<Cow>();
		makeSomeCows();
		
		for(LocatedRectangle p: cows)
			parts.add(p);
		super.setAnimal(parts);
		
	}

	private Color getRandomColor() {
		int colorR = RandomNumber.between(0, 255);
		int colorG = RandomNumber.between(0, 255);
		int colorB = RandomNumber.between(0, 255);
		return new Color(colorR, colorG, colorB);
	}
	
	public ArrayList<Cow> getArray() {
		return cows;
	}
	
	private boolean vacantSpace(Cow newCow) {
		boolean anyIntersection = false;
		for (Cow c : this.cows)
			if(!(cows.indexOf(c)==cows.indexOf(newCow))) {
				anyIntersection = anyIntersection || c.intersects(newCow,5);
			}
		return !anyIntersection;
	}
	public boolean vacantSpace(LocatedRectangle object) {
		return super.vacantSpace(object);
		}
	
	public SceneCow getSceneCow() {
		return this;
	}

	private void addNewCow() {
		Color spotColor = this.getRandomColor();
		boolean facingRight = RandomNumber.between(0, 1) == 1;
		int width = RandomNumber.between(MIN_COW_WIDTH, MAX_COW_WIDTH);
		int height = RandomNumber.between(MIN_COW_HEIGHT, MAX_COW_HEIGHT);
		int xSpeed = RandomNumGenerator.between(-1, 1);
		int ySpeed = RandomNumGenerator.between(-1, 2);
		Cow newCow = new Cow(width, height, spotColor,
				new Point(RandomNumber.between(location.x, this.width-width), RandomNumber.between(location.y, this.height-height)), facingRight, new Point(xSpeed, ySpeed));
		
		if (this.vacantSpace(newCow)) {
			this.cows.add(newCow);
		}
	}
	
	private void makeSomeCows() {
		for (int i = 0; i < SIZE; i++) {
			addNewCow();
		}
	}
	
	private void cowMovement() {
		for(Cow c: cows) {
			c.setSpeed(new Point(c.getSpeed().x, c.getSpeed().y));
			
			if(c.address().x<location.x || c.address().x+c.width()>width+location.x) {
				c.setSpeed(new Point(-c.getSpeed().x, c.getSpeed().y));
				c.setDirection(c.getSpeed().x<0);
			}
			if(c.address().y<location.y || c.address().y+c.height()>height+location.y) {
				c.setSpeed(new Point(c.getSpeed().x, -c.getSpeed().y));
			}
			if(!vacantSpace(c)||!checkFarmer(c)) {
				c.setSpeed(new Point(-c.getSpeed().x, -c.getSpeed().y));
				c.setDirection(c.getSpeed().x<0);
			}
		}
	}
	
	public boolean checkFarmer(LocatedRectangle object) {
		boolean anyIntersection = false ;
		anyIntersection = farmer.intersects (object);
		
		return !anyIntersection ;
		}

	public void draw(Point lastKey, int darkness) {
		super.draw(lastKey, darkness);
		
		cowMovement();
	}
	private void drawDarkness(int darkness) {
		Drawing.pen().setColor(new Color(0,0,0, darkness));
		Drawing.pen().fillRect(0, 0, TestDrawingTool.screenSize().width, TestDrawingTool.screenSize().height);
	}
}
