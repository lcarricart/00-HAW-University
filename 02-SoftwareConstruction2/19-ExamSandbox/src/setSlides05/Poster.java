package setSlides05;

public class Poster implements Resizable {
	private int width, height;
	private String title;
	
	public Poster(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
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
	
	public String getTitle() {
		return title;
	}
}
