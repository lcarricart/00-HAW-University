package state;

public class Closed extends State {
	private static final Closed INSTANCE = new Closed();
	
	private Closed() {}

	@Override
	public State close() {
		System.out.println("Closed --> Closed");
		return this; // return INSTANCE would also work because it is the only object (Singleton)
	}

	@Override
	public State open() {
		System.out.println("Closed --> Open");
		return Open.getInstance();
	}

	@Override
	public State lock() {
		System.out.println("Closed --> Locked");
		return Locked.getInstance();
	}

	@Override
	public State unlock() {
		System.out.println("Closed --> Closed (tried to unlock)");
		return this;
	}

	public static Closed getInstance() {
		return INSTANCE; // return "this" also works
	}
}
