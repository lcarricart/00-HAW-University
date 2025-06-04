package animal;

import objects.Glasses;

public class Puddle {
	private FrontBody dogFrontBody; //composite
	private Fur dogFur;				//composite
	

	public Puddle(int heightPassed) {
		double sizeFrontBody = heightPassed;
		
		this.dogFur = new Fur();
		this.dogFrontBody = new FrontBody(sizeFrontBody, dogFur);
	}
	
	public Puddle(int heightPassed, Glasses myGlasses) {
		double sizeFrontBody = heightPassed;
		
		this.dogFur = new Fur();
		this.dogFrontBody = new FrontBody(sizeFrontBody, dogFur, myGlasses);
	}

	public void drawAt(int left, int bottom) {
		dogFrontBody.drawAt(left, bottom);
	}
}