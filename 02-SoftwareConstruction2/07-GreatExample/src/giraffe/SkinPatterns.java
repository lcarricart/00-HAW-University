package giraffe;

import java.awt.Color;

import scene.RandomNumGenerator;

public class SkinPatterns {
	private int width;
	private int height;
	private Color color;
	
	public SkinPatterns(int width, int height, Color color) {
		this.width = width * 95/100;
		this.height = height * 90/100;
		ColorSkinPatterns randomColor = ColorSkinPatterns.values()[RandomNumGenerator.between(0, ColorSkinPatterns.values().length - 1)];
		this.color = randomColor.getColor();
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
	