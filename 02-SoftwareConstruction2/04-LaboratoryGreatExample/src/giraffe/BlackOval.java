package giraffe;

import java.awt.Color;

public class BlackOval {
	private int width;
	private int height;
	private Color color;
	
	public BlackOval(int width, int height, Color color) {
		this.width = width * 160/100;
		this.height = height * 260/100;
		this.color = Color.black;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Color getColor() {
		return color;
	}
}
