package setSlides03;

public class House {
	Facade aFacade;
	
	public House() {
		this.aFacade = new Facade();
	}
	
	public void drawAt(int left, int bottom) {
		// Draws itself.
		aFacade.drawYourself(left, bottom);
	}
}
