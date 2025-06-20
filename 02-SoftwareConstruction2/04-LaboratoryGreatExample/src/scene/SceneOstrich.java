package scene;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import Ostrich.FeatherColorsInner;
import Ostrich.FeatherColorsOuter;
import Ostrich.Ostrich;
import Ostrich.SkinColors;
import background.LocatedRectangle;
import background.Speed;
import chick.Chick;
import cow.Cow;
import farmer.Farmer;
import farmhouse.FarmHouse;
import giraffe.Giraffe;
import horse.Horse;

public class SceneOstrich extends SceneSec{
	private static final int LENGTH = 900; //800;
	private static final int HEIGHT = 750; //500;
	private static final int XSTART = 50; //50;
	private static final int YSTART = 50; //300;
	private static final int FENCE = 50;
	private static final int MARGIN = 5;
	private static final int BULLETSPEED = 25;
	
	private ArrayList<Ostrich> ostriches = new ArrayList<Ostrich>();
	public  ArrayList<LocatedRectangle>parts = new ArrayList<LocatedRectangle>();
	public Farmer farmer;
	private Horse horse;
	private Giraffe giraffe;
	private Ostrich ostrich;
	private Point location;
	private int height, width;
	
	public SceneOstrich(int sceneIndex, Point location, int width, int height,  Farmer farmer){
		super(farmer, sceneIndex, new Rectangle(
				new Point(location.x, location.y), 
				new Dimension(width, height)),
				true);
		this.farmer= farmer;
		this.location=location;
		this.height=height;
		this.width=width;
		addNewOstrich();
		horse = new Horse(200, 75, new Point(1250,700), Color.black);
		giraffe = new Giraffe(new Point(1300,200), 8, 8, Color.orange);
		//ostrich = new Ostrich(100, new Point(100,100), Color.white, Color.black, Color.black); 
		addParts();
	}
	
	private void ostrichMovement() {
		for(Ostrich c: ostriches) {
			c.setSpeed(new Point(c.getSpeed().x, c.getSpeed().y));
			
			if(c.address().x<location.x || c.address().x+c.width()>width+location.x) {
				c.setSpeed(new Point(-c.getSpeed().x, c.getSpeed().y));
			}
			if(c.address().y<location.y || c.address().y+c.height()>height/2+location.y) {
				c.setSpeed(new Point(c.getSpeed().x, -c.getSpeed().y));
			}
			if(!vacantSpace(c)||!checkFarmer(c)) {
				c.setSpeed(new Point(-c.getSpeed().x, -c.getSpeed().y));
			}
		}
	}
	
	
	private void addParts() {
		parts.add(horse);
		parts.add(giraffe);
		for(LocatedRectangle p: ostriches)
			parts.add(p);
		
		super.setAnimal(parts);
	}
	
	private static FarmHouse initializeHouse() {
		return new FarmHouse(new Point(1000,20), 500, 350);
	}
	
	public void draw(Point lastKey, int darkness) {
		super.draw(lastKey, darkness);
		
		ostrichMovement();
	}
	
	
	public Farmer getFarmer() {
		return farmer;
	}
	
	public void addNewOstrich() {
		for(int i = 0; i < 5; i++) {
			Ostrich generated; 
			// generate a new object until there is no intersection in between
			do {
				// generate size and position
				int width = RandomNumGenerator.between(50, 75);
				int height = RandomNumGenerator.between(50, 100);
				int xSpeed = RandomNumGenerator.between(-3, 3);
				int ySpeed = RandomNumGenerator.between(-1, 2);
				int left = RandomNumGenerator.between(location.x, location.x+this.width-height-MARGIN-50);
				int bottom = RandomNumGenerator.between(location.y, location.y+this.height-height-MARGIN-250);
				SkinColors skinColor = SkinColors.values()[RandomNumGenerator.between(0, SkinColors.values().length - 1)];
				FeatherColorsInner innerColor = FeatherColorsInner.values()[RandomNumGenerator.between(0, FeatherColorsInner.values().length - 1)];
				FeatherColorsOuter outerColor = FeatherColorsOuter.values()[RandomNumGenerator.between(0, FeatherColorsOuter.values().length - 1)];
				generated = new Ostrich(height, new Point(left, bottom), skinColor.getColor(), innerColor.getColor(), outerColor.getColor(), new Point(xSpeed, ySpeed)); 
				
			} while(!vacantSpace(generated));
			ostriches.add(generated); 
		}
	}
	
	private boolean vacantSpace(Ostrich newOstrich) {
		boolean anyIntersection = false ;
		
		for (Ostrich o : ostriches) {
			if(!(o==newOstrich))
		anyIntersection = anyIntersection || o.intersects (newOstrich);
		}
		return !anyIntersection ;
		}
	

	public boolean checkFarmer(LocatedRectangle object) {
		boolean anyIntersection = false ;
		anyIntersection = farmer.intersects (object);
		
		return !anyIntersection ;
		}
	
	public SceneOstrich getScene() {
		return this;
	}
}
