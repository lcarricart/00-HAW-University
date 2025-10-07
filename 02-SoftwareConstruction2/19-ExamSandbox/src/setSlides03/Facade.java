package setSlides3;

import java.util.ArrayList;

public class Facade {
	private ArrayList<Door> doors = new ArrayList<>(); // This initializes the List
	
	public Facade() {
		
	}
	
	public void addDoor(Door d) {
		boolean flag = false;
		
		for (Door aDoor : doors) {
			if (aDoor == d) {
				flag = true;
			}
		}
		
		if (flag == false) {
			doors.add(d);
		}
	}
	
	public void drawYourself(int left, int bottom) {
		//Facade draws itself simulation comment
		int i = 1;
		for (Door aDoor : doors) {
			aDoor.drawYourself(left + i*50, bottom);
			i++;
		}
	}
}
