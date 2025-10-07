package setSlides8;

/* TrafficLight.java  (context) */
public class TrafficLight {
    // Singletons for every colour, otherwise we create a new Green() every single time. Not okay. 
    static final RedState    RED    = new RedState();
    static final GreenState  GREEN  = new GreenState();
    static final YellowState YELLOW = new YellowState();

    private LightState state = GREEN;	 //initialization
    private boolean cameFromGreen = true;		 //flag

    public void setState(LightState s) { state = s; }        // package-private
    public LightState getState() { return state; }
    
    public void setFlag(boolean value) { cameFromGreen = value; }
    public boolean getFlag() { return cameFromGreen; }

    // "this" delegates. Passing this TrafficLight instance so the state can call setState()
    public void tick() { state.next(this); }
    public String display() { return state.color(); }
}
