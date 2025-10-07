package setSlides08;

public interface LightState {
    public void next(TrafficLight tl);   // transition
    public String color();               // "RED", "GREEN", "YELLOW"
}