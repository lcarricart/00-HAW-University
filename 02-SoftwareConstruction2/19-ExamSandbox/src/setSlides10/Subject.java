package setSlides10;

// Observer pattern: Subject interface
public interface Subject {
	public void attach(Observer o);
    public void detach(Observer o);
    public void notifyObservers();
}
