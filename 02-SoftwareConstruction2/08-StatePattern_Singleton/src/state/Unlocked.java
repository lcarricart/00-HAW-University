package state;

public class Unlocked extends State {
	private static final Unlocked INSTANCE = new Unlocked();
	
	private Unlocked() {}
	
	@Override
	public State close() {
		System.out.println("Unlocked --> Unlocked (tried to close)");
		return this;
	}

	@Override
	public State open() {
		System.out.println("Unlocked --> Open");
		return Closed.getInstance();
	}

	@Override
	public State lock() {
		System.out.println("Unlocked --> Locked");
		return Locked.getInstance();
	}

	@Override
	public State unlock() {
		System.out.println("Unlocked --> Unlocked");
		return this;
	}
	
	public static Unlocked getInstance() {
		return INSTANCE;
	}

}
