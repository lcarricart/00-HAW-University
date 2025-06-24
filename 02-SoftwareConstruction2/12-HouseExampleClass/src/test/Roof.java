package test;

public class Roof {
	private int width;
	private int height;
	
	public Roof(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().drawLine(left, bottom, left + width/2, bottom - height);
		Drawing.pen().drawLine(left + width/2, bottom - height, left + width, bottom);
	}

	public int getHeight() {
		return height;
	}

}
