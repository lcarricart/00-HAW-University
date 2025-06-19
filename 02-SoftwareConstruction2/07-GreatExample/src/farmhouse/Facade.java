package farmhouse;

import java.awt.Color;

import java.awt.Point;

public class Facade {
	private Shack shack;
	private MainBuild mainBuild;
	
	public Facade(Point location, int width, int height) {
		shack= new Shack(new Point(location.x+6*width/10, location.y), 4*width/10, 9*height/10);
		setMainBuild(new MainBuild(location, 6*width/10, height));
	}
	
	public void drawAt() {
		shack.drawAt();
		getMainBuild().drawAt();
	}

	public MainBuild getMainBuild() {
		return mainBuild;
	}

	public void setMainBuild(MainBuild mainBuild) {
		this.mainBuild = mainBuild;
	}
}
