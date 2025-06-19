package state;

public class Locked extends State {
	private static final Locked INSTANCE = new Locked();

	private Locked() {}
	
	@Override
	public State close() {
		System.out.println("Locked --> Locked (tried to close)");
		return this;
	}

	@Override
	public State open() {
		System.out.println("Locked --> Locked (tried to open)");
		return this;
	}

	@Override
	public State lock() {
		System.out.println("Locked --> Locked");
		return this;
	}

	@Override
	public State unlock() {
		System.out.println("Locked --> Unlocked");
		return Unlocked.getInstance();
	}

	public static Locked getInstance() {
		return INSTANCE;
	}
}
