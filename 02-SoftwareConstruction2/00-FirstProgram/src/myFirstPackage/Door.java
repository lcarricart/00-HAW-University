package myFirstPackage;

public class Door {
	private int width, height;
	
	public Door(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public void print()
	{
		System.out.println("Width = " + width + " Height = " + height);
	}
}
