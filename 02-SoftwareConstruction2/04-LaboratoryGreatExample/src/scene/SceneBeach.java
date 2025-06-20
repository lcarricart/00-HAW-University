package scene;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import background.LocatedRectangle;
import chick.Chick;
import farmer.Farmer;

public class SceneBeach extends SceneSec{
	
	private Farmer farmer;
	private Beach beach;
	private int sceneIndex;

	public SceneBeach( int sceneIndex, Rectangle rectangle, Farmer farmer) {
		super(farmer, sceneIndex, rectangle);
		this.farmer=farmer;
		this.sceneIndex=sceneIndex;
		beach= new Beach(rectangle);
		super.parts.add(beach);
		// TODO Auto-generated constructor stub
	}
	
	public SceneBeach( int sceneIndex, Rectangle rectangle,Rectangle rectangle2, Farmer farmer, Direction dir) {
		super(farmer, sceneIndex, new Rectangle());
		this.farmer=farmer;
		this.sceneIndex=sceneIndex;
		switch(dir) {
		case UP_LEFT:
			super.parts.add(new Beach(rectangle, Direction.UP));
			super.parts.add(new Beach(rectangle2, Direction.LEFT));
			break;
		case UP_RIGHT:
			super.parts.add(new Beach(rectangle, Direction.UP));
			super.parts.add(new Beach(rectangle2, Direction.RIGHT));
			break;
		case DOWN_RIGHT:
			super.parts.add(new Beach(rectangle, Direction.DOWN));
			super.parts.add(new Beach(rectangle2, Direction.RIGHT));
			break;
		case DOWN_LEFT:
			super.parts.add(new Beach(rectangle, Direction.DOWN));
			super.parts.add(new Beach(rectangle2, Direction.LEFT));
			break;
		default:
			break;
		}
		// TODO Auto-generated constructor stub
	}
	

	
	public void draw(Point lastKey, int darkness) {
		super.draw(lastKey, darkness);
		farmer.setDirection(lastKey);
	}
	
	public boolean vacantSpace(LocatedRectangle object) {
		return super.vacantSpace(object);
		}
	
	public SceneBeach getScene() {
		return this;
	}
	
	public boolean checkFarmer(LocatedRectangle object) {
		boolean anyIntersection = false ;
		anyIntersection = farmer.intersects (object);
		
		return !anyIntersection ;
		}

}
