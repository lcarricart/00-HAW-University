package test;

public class Test {
	public static void main(String[] args) {
		Door myDoor = new Door();
		
		myDoor.open();
		myDoor.close();
		myDoor.lock();
		myDoor.lock();
		myDoor.unlock();
		myDoor.open();
		myDoor.lock();
	}
}
