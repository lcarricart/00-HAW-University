package Ostrich;

import scene.Drawing;

public class Neck {
	private int width, height;

	public Neck(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void drawNeckAt(int x, int y) {
		Drawing.pen().fillRect(x, y, width, height);
		Drawing.pen().fillRect(x, y + height, height/6, width);
	}

}
