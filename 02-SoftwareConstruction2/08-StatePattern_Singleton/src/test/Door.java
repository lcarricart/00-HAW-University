package test;

import state.Open;
import state.State;

public class Door {
	private State doorCondition = Open.getInstance(); //starts open
	
	public Door() {	}
	
	public void open() {
		doorCondition = doorCondition.open();
	}
	
	public void close() {
		doorCondition = doorCondition.close();
	}
	
	public void lock() {
		doorCondition = doorCondition.lock();
	}
	
	public void unlock() {
		doorCondition = doorCondition.unlock();
	}
	
	public State getDoorCondition() {
		return doorCondition;
	}
}
