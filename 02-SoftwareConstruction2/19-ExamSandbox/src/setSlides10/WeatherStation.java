package setSlides10;

import java.util.ArrayList;

//Observer pattern: Concrete subject
public class WeatherStation implements Subject {
	private double temperature;
	private final ArrayList<Observer> subscribers = new ArrayList<>();
	
	public void setTemperature(double t) {
		temperature = t;
		notifyObservers();
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	@Override
	public void attach(Observer o) {
		subscribers.add(o);
	}

	@Override
	public void detach(Observer o) {
		subscribers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer anObserver : subscribers) {
			anObserver.update();
		}
	}
	
}
