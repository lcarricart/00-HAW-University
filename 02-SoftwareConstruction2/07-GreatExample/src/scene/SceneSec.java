package scene;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import background.Fence;
import background.LocatedRectangle;
import background.Speed;
import chick.Chick;
import cow.Cow;
import cow.SceneCow;
import farmer.Farmer;
import farmhouse.FarmHouse;

public class SceneSec implements Scenes{
	private static final int BULLETSPEED = 25;
	
	private int sceneIndex;
	private Farmer farmer;
	private BulletField bulletField;
	private Bullet bullet;
	private Background background;
	private SceneCow sceneCow;
	private Fence fence;
	private Rectangle rectangle;
	protected ArrayList<LocatedRectangle>animals = new ArrayList<LocatedRectangle>();
	public  ArrayList<LocatedRectangle>parts = new ArrayList<LocatedRectangle>();	

	public SceneSec(Farmer farmer, int sceneIndex, Rectangle rectangle) {
		fence = new Fence(new Point(rectangle.x, rectangle.y-50), rectangle.width, rectangle.height);
		this.rectangle=rectangle;
		this.sceneIndex=sceneIndex;
		this.farmer=farmer;
		background= new Background(rectangle);
		bulletField=new BulletField();
	}
	
	public SceneSec(Farmer farmer, int sceneIndex, Rectangle rectangle, boolean fenceExists) {
		fence = new Fence(new Point(rectangle.x, rectangle.y-50), rectangle.width, rectangle.height);
		addParts();
		this.rectangle=rectangle;
		this.sceneIndex=sceneIndex;
		this.farmer=farmer;
		background= new Background(rectangle);
		bulletField=new BulletField();
	}
	
	public SceneSec(Farmer farmer, int sceneIndex, Rectangle rectangle, boolean fenceExists, FarmHouse farmHouse) {
		fence = new Fence(new Point(rectangle.x, rectangle.y-50), rectangle.width, rectangle.height);
		addParts(farmHouse);
		this.rectangle=rectangle;
		this.sceneIndex=sceneIndex;
		this.farmer=farmer;
		background= new Background(rectangle);
		bulletField=new BulletField();
	}
	
	private void movement() {
		for(LocatedRectangle c: animals) {
			c.setSpeed(new Point(c.getSpeed().x, c.getSpeed().y));
			
			if(c.address().x<rectangle.x || c.address().x+c.width()>rectangle.width+rectangle.x) {
				c.setSpeed(new Point(-c.getSpeed().x, c.getSpeed().y));
			}
			if(c.address().y<rectangle.y || c.address().y+c.height()>rectangle.height+rectangle.y) {
				c.setSpeed(new Point(c.getSpeed().x, -c.getSpeed().y));
			}
			if(!vacantSpace(c)||!checkFarmer(c)) {
				c.setSpeed(new Point(-c.getSpeed().x, -c.getSpeed().y));				
			} 
		}
}
	
	public void draw(Point lastKey, int darkness) {
		background.draw();
		farmer.setDirection(lastKey);
		
		//Drawing.pen().setColor(Color.black);
		
		switch(sceneIndex) {
		case 6:
			//fence.drawAt();
			movement();
			for (LocatedRectangle c : parts) {
				c.draw();
			}
		case 7:
			fence.drawAt();
			for (LocatedRectangle c : animals) {
				c.draw();
			}
			break;
		/*case 0,1,2,3,4,5,9,10,14,15,19,20,24:
			for (LocatedRectangle c : parts) {
				c.draw();
			}
			break;*/
		default:
			for (LocatedRectangle c : parts) {
				c.draw();
			}
			break;
			
		}
		farmer.draw(sceneIndex);
		drawBulletField();
		bulletHit(sceneIndex);
		drawDarkness(darkness);
	}
	
	private void drawDarkness(int darkness) {
		Drawing.pen().setColor(new Color(0,0,0, darkness));
		Drawing.pen().fillRect(0, 0, TestDrawingTool.screenSize().width, TestDrawingTool.screenSize().height);
	}
	
	public void drawBulletField() {
		bulletField.drawBulletField();
	}
	
	public Farmer getFarmer() {
		return farmer;
	}

	@Override
	public boolean checkFarmer(LocatedRectangle object) {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public void bulletHit(int sceneIndex) {
		boolean hit=false;
		
			for (Bullet b : bulletField.getArray()) {
				for(LocatedRectangle c : animals) {
					if(b.intersects (c)) {
						parts.remove(c);
						animals.remove(c);
						bulletField.getArray().remove(b);
						hit=true;
					break;
					}
				}
				if(hit)
					break;
			}

	}
	
	private void addParts() {
		parts.add(fence.getFenceColumnLeft());
		parts.add(fence.getFenceColumnRight());
		parts.add(fence.getFenceRowHigh());
		parts.add(fence.getFenceRowLow());
	}
	
	private void addParts(LocatedRectangle farmHouse) {
		parts.add(fence.getFenceRowHigh());
		parts.add(fence.getFenceRowLow());
		parts.add(fence.getFenceColumnLeft());
		parts.add(fence.getFenceColumnRight());
		parts.add(farmHouse);
	}
	
	public void setAnimal(ArrayList<LocatedRectangle> animals){
		this.animals=animals;
		for(LocatedRectangle a: animals)
			parts.add(a);
	}
	
	public void setParts(ArrayList<LocatedRectangle> parts){
		for(LocatedRectangle a: parts)
			animals.add(a);
	}
	
	public boolean vacantSpace(LocatedRectangle object) {
		if(animals!=null) {
			boolean anyIntersection = false ;
			
			for (LocatedRectangle p : parts) {
				if(!(object==p))
				anyIntersection = anyIntersection || p.intersects (object);
			}
			for (LocatedRectangle p : animals) {
				if(!(object==p))
				anyIntersection = anyIntersection || p.intersects (object);
			}
			return !anyIntersection ;
			}
		else {
		return true;	
		}
	}
	

	@Override
	public void addBullet(Point direction) {
		
		switch(Direction.getDirection(direction)) {
		case RIGHT:
			bullet= new Bullet(new Point(farmer.address().x+direction.x+farmer.width(),farmer.address().y+4*farmer.height()/10), direction.x, new Speed(new Point(BULLETSPEED*direction.x,0)));
			break;
		case LEFT:
			bullet= new Bullet(new Point(farmer.address().x+direction.x-10,farmer.address().y+4*farmer.height()/10), direction.x, new Speed(new Point(BULLETSPEED*direction.x,0)));
			break;
		case DOWN:
			bullet= new Bullet(new Point(farmer.address().x+2*farmer.width()/8,farmer.address().y+9*farmer.height()/10), direction.y, new Speed(new Point(0,BULLETSPEED*direction.y)));
			break;
		case UP:
			bullet= new Bullet(new Point(farmer.address().x+5*farmer.width()/8,farmer.address().y-10), direction.y, new Speed(new Point(0,BULLETSPEED*direction.y)));
			break;
		default:
			break;
		}
		
		bulletField.addBullet(bullet);
	}

	
	public int sceneManager(int index, ArrayList<Scenes> scenes) {
	
		if(farmer.address().x<0-farmer.width()/2) {
			farmer.setAddress(new Point(TestDrawingTool.screenSize().width-farmer.width()/2,farmer.address().y));
			if(scenes.get(index-1).checkFarmer())
				return index-1;
			else {
				farmer.setAddress(new Point(0-farmer.width()/2,farmer.address().y));
				return index;
			}
		}
		
		if(farmer.address().y>TestDrawingTool.screenSize().height-farmer.height()/2) {
			farmer.setAddress(new Point(farmer.address().x, 0-farmer.height()/2));
			if(scenes.get(index+5).checkFarmer())
				return index+5;
			else {
				farmer.setAddress(new Point(farmer.address().x, TestDrawingTool.screenSize().height-farmer.height()/2));
				return index;
			}
		}
		
		if(farmer.address().y<0-farmer.height()/2) {
			farmer.setAddress(new Point(farmer.address().x, TestDrawingTool.screenSize().height-farmer.height()/2));
			if(scenes.get(index-5).checkFarmer())
				return index-5;
			else {
				farmer.setAddress(new Point(farmer.address().x, 0-farmer.height()/2));
				return index;
			}
		}
		
		if(farmer.address().x>TestDrawingTool.screenSize().width-farmer.width()/2) {
			farmer.setAddress(new Point(0-farmer.width()/2,farmer.address().y));
			if(scenes.get(index+1).checkFarmer())
				return index+1;
			else {
				farmer.setAddress(new Point(TestDrawingTool.screenSize().width-farmer.width()/2,farmer.address().y));
				return index;
			}
		}
		
		return index;
	}


	@Override
	public void bulletHit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIndex(int sceneIndex) {
		// TODO Auto-generated method stub
		this.sceneIndex=sceneIndex;
	}

	@Override
	public boolean checkFarmer() {
		boolean anyIntersection = false ;
		
		for (LocatedRectangle p : parts) {
			anyIntersection = anyIntersection || p.intersects (farmer);
		}
		return !anyIntersection ;
	}
	
}
