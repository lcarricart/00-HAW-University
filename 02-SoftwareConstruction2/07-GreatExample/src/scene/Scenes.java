package scene;

import java.awt.Point;
import java.util.ArrayList;

import background.LocatedRectangle;
import farmer.Farmer;

public interface Scenes {
	public Farmer getFarmer();
	public boolean checkFarmer(LocatedRectangle object);
	public void bulletHit();
	public void setIndex(int sceneIndex);
	public boolean vacantSpace(LocatedRectangle object);
	public void addBullet(Point direction);
	public int sceneManager(int index, ArrayList<Scenes> scenes);
	void bulletHit(int sceneIndex);
	void draw(Point lastKey, int darkness);
	public boolean checkFarmer();
}
