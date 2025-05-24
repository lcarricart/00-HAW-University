package animal;

public class Puddle {
	private FrontBody dogFrontBody;
	
	public Puddle(int heightPassed) {
		double sizeFrontBody = heightPassed;
		
		this.dogFrontBody = new FrontBody(sizeFrontBody);
	}
	
	public void drawAt(int left, int bottom)
	{
		dogFrontBody.drawAt(left, bottom);
	}
}