package setSlides08;

public class YellowState implements LightState {
	private final String color = "YELLOW";
	
	public YellowState() { }
	
	public void next(TrafficLight tl) {
		if (tl.getFlag() == false) {
			tl.setState(TrafficLight.GREEN);
		} else if (tl.getFlag() == true) {
			tl.setState(TrafficLight.RED);
		}
	}
	
	@Override
	public String color() {
		return color;
	}
}
