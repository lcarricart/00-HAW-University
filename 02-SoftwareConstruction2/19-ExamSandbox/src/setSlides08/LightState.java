package setSlides8;

public interface LightState {
    void next(TrafficLight tl);   // transition
    String color();               // "RED", "GREEN", "YELLOW"
}