package scene;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import background.LocatedRectangle;
import background.Speed;
import chick.Chick;
import cow.Cow;
import cow.RandomNumber;

public class AnimalGenerator {
	
	private static final int LENGTH = 900; //800;
	private static final int HEIGHT = 750; //500;
	private static final int XSTART = 50; //50;
	private static final int YSTART = 50; //300;
	private static final int FENCE = 50;
	private static final int MARGIN = 5;
	
	private final int MAX_COW_WIDTH = 150;
	private final int MIN_COW_WIDTH = 75;
	private final int MAX_COW_HEIGHT = 75;
	private final int MIN_COW_HEIGHT = 50;
	
	
	public  ArrayList<LocatedRectangle>animals = new ArrayList<LocatedRectangle>();
	
	
	public AnimalGenerator(Rectangle rectangle, int quantity, int animal) {
		
	}
	
	
	public void addNewChick(int cycle, boolean hasColor) {
		int width = 43*RandomNumGenerator.between(1, 3);
		int height = 40*RandomNumGenerator.between(1, 3);
		int colorR = RandomNumGenerator.between(0, 255);
		int colorG = RandomNumGenerator.between(0, 255);
		int colorB = RandomNumGenerator.between(0, 255);
		int colorA = RandomNumGenerator.between(250, 255);
		int xSpeed = RandomNumGenerator.between(-3, 3);
		int ySpeed = RandomNumGenerator.between(-1, 2);
		int left = RandomNumGenerator.between(XSTART, LENGTH-width-MARGIN);
		int bottom = RandomNumGenerator.between(YSTART, HEIGHT-height-MARGIN);
		int id = cycle;
		if(xSpeed==0&&ySpeed==0) {
			ySpeed=1;
		}
		Point chickSpeed = new Point(xSpeed, ySpeed);
		Color color = new Color (colorR, colorG, colorB, colorA);
		Point address = new Point(left, bottom);
		Chick newChick;
		if (hasColor) {
			newChick = new Chick(address, width, width, color, chickSpeed, id);
		}
		else {
			newChick = new Chick(address, width, width, Color.white, chickSpeed, id);
		}
		
		if(vacantSpace(newChick)&&checkFarmer(newChick)) {
			animals.add(newChick);
		}
	}
	
	private boolean checkFarmer(Chick newChick) {
		// TODO Auto-generated method stub
		return true;
	}
	
	private Color getRandomColor() {
		int colorR = RandomNumber.between(0, 255);
		int colorG = RandomNumber.between(0, 255);
		int colorB = RandomNumber.between(0, 255);
		return new Color(colorR, colorG, colorB);
	}
	
	public boolean vacantSpace(LocatedRectangle object) {
		if(animals==null) {
			boolean anyIntersection = false ;
		
			for (LocatedRectangle a : animals) {
				anyIntersection = anyIntersection || a.intersects (object);
			}
			return !anyIntersection ;
			}
		else {
		return true;	
		}
	}

}
