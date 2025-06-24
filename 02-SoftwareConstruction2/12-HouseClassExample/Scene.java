package house;

import java.awt.Color;
import java.util.ArrayList;

public class Scene {
	private ArrayList<House> houses;
	private int screenWidth;
	private int screenHeight;

	public Scene(int screenWidth, int screenHeight) {
		houses = new ArrayList<House>();
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		constructSomeHouses();
	}

	private void constructSomeHouses() {
		for (int i = 0; i < 5000; i++) {
			int width = RandomNumber.between(20, 200);
			int height = RandomNumber.between(20, 80);
			int x = RandomNumber.between(width, screenWidth - width);
			int y = RandomNumber.between(height, screenHeight - (height*4));
			int colorR = RandomNumber.between(0, 255);
			int colorG = RandomNumber.between(0, 255);
			int colorB = RandomNumber.between(0, 255);
			int colorA = RandomNumber.between(0, 255);
			
			House aHouse = new House(x, y, width, height, new Color(colorR, colorG, colorB, colorA));
			if ( vacantProperty(aHouse) ) {
				houses.add(aHouse);
			}
		}
	}

	private boolean vacantProperty(House aHouse) {
		boolean intersects = false;
		for(House h : houses) {
			intersects = intersects || h.intersects(aHouse);
		}
		return !intersects;
	}

	public void draw() {
		for (House aHouse : houses) {
			aHouse.draw();
		}
	}
}
