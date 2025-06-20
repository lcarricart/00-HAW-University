package scene;

import java.awt.Point;
import java.util.ArrayList;

public class BulletField {
	public ArrayList<Bullet>bullets = new ArrayList<Bullet>();
	private Bullet bullet;
	
	public BulletField() {
		
	}
	
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
	}
	
	public void drawBulletField() {
		for(Bullet b: bullets) {
			b.draw();
			b.setAddress();
		}
	}
	
	public ArrayList<Bullet> getArray() {
		return bullets;
	}
	
}
