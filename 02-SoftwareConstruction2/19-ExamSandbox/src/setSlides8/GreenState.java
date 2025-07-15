package setSlides8;

public class GreenState implements LightState {
	private final String color = "GREEN";
	
	public GreenState() { }
	
	public void next(TrafficLight tl) {
		tl.setState(TrafficLight.YELLOW);
		tl.setFlag(true);
	}
	
	@Override
	public String color() {
		return color;
	}
}
