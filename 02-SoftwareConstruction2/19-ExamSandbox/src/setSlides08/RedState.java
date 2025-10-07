package setSlides08;

public class RedState implements LightState {
	private final String color = "RED";
	
	public RedState() { }
	
	public void next(TrafficLight tl) {
		tl.setState(TrafficLight.YELLOW);
		tl.setFlag(false);
	}
	
	@Override
	public String color() {
		return color;
	}
}
