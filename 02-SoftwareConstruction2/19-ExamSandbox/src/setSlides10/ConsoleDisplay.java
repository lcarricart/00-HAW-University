package setSlides10;

//Observer pattern: Concrete observer
public class ConsoleDisplay implements Observer {
	private WeatherStation station;
	private double temp;
	
	public ConsoleDisplay(WeatherStation station) {
		this.station = station;
	}
	
	@Override
	public void update() {
		temp = station.getTemperature();
		System.out.println(temp + "°C");
	}
}
