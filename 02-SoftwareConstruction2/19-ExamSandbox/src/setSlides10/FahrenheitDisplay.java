package setSlides10;

//Observer pattern: Concrete observer
public class FahrenheitDisplay implements Observer {
	private WeatherStation station;
	private double temp;
	
	public FahrenheitDisplay(WeatherStation station) {
		this.station = station;
	}
	
	@Override
	public void update() {
		temp = station.getTemperature();
		temp = temp * 9 / 5 + 32;
		System.out.println(temp + "°F");
	}
}
