package state;

public abstract class State {
	public abstract State close();
	public abstract State open();
	public abstract State lock();
	public abstract State unlock();
}
