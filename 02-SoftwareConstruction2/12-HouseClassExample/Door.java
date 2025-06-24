package house;

import java.awt.Color;

public class Door {
	private int width;
	private int height;
	private Color color;
	
	public Door(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void drawAt(int left, int bottom) {
		Color oldColor = Drawing.pen().getColor();
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(left, bottom, width, height);
		Drawing.pen().setColor(Color.BLACK);
		Drawing.pen().drawRect(left, bottom, width, height);
		Drawing.pen().setColor(oldColor);
	}
}
