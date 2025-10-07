package setSlides05;

public class Photo implements Resizable {
	private int width, height;
	
	public Photo(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void resize(int factor) {
		width *= factor;
		height *= factor;
	}
}
