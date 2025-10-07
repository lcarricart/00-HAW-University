package setSlides07;

public class Rectangle extends Shape {
	private double width, height;
	
	public Rectangle(String name, double width, double height) {
		super(name);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double area() {
		return width * height;
	}
}
