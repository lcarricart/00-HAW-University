package house;

import java.awt.Color;

public class Facade {
	private Door entry; // aggregate
	private int width;
	private int height;
	private Color color;
	
	public Facade(int width, int height, Color color) {
		int entryHeight = height / 3;
		Color doorColor = Color.cyan;
		if (color == Color.blue) {
			doorColor = Color.yellow;
		}
		entry = new Door(width / 5, entryHeight, doorColor);
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(left, bottom, width, height);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect(left, bottom, width, height);
		entry.drawAt(left + (width / 2), bottom + height - entry.getHeight());
	}
}
