package farmer;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import background.LocatedRectangle;
import background.Speed;
import scene.Drawing;
import scene.Scenes;

public class Farmer implements LocatedRectangle {
	private int width;
	private int height;
	private Point direction;
	private Point location;
	private FarmerBody farmerBody;
	private FarmerMovement farmerMovement;
	//private FarmerTool gun;
	
	public Farmer(Point location, int width, int height, int sceneIndex, ArrayList<Scenes> scenes) {
		this.location=location;
		this.width=width;
		this.height=height;
		farmerBody= new FarmerBody(location, width, height);
		farmerMovement = new FarmerMovement(this, 0, scenes);
	}
	
	public void setAddress(Point location) {
		this.location=location;
	}
	
	public void setKey(int key) {
		farmerMovement.setKey(key);
	}
	@Override
	public Point address() {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return width;
	}
	public void setWidth(int width) {
		this.width=width;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return height;
	}
	
	public void setHeight(int height) {
		this.height=height;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		farmerBody.draw(location);
	}
	
	public void draw(int index) {
		// TODO Auto-generated method stub
		farmerMovement.moveFarmer(index);
		farmerBody.draw(location);
		
	}

	@Override
	public Point direction() {
		// TODO Auto-generated method stub
		return direction;
	}



	@Override
	public void setDirection(Point direction) {
		// TODO Auto-generated method stub
		this.direction=direction;
		farmerBody.setDirection(direction);
	}

	@Override
	public void setSpeed(Point speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getSpeed() {
		// TODO Auto-generated method stub
		return null;
	}



}

