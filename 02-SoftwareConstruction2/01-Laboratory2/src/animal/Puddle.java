package animal;

public class Puddle {
	private FrontBody dogFrontBody; //composite
	private Fur dogFur;

	public Puddle(int heightPassed) {
		double sizeFrontBody = heightPassed;
		
		this.dogFur = new Fur();
		this.dogFrontBody = new FrontBody(sizeFrontBody);
	}

	public void drawAt(int left, int bottom) {
		dogFrontBody.drawAt(left, bottom);
	}
}