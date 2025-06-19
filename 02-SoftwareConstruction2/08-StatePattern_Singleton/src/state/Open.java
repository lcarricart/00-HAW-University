package state;

public class Open extends State {
	private static final Open INSTANCE = new Open();
	
	private Open() {}
	
	@Override
	public State close() {
		System.out.println("Open --> Closed");
		return Closed.getInstance();
	}

	@Override
	public State open() {
		System.out.println("Open --> Open");
		return INSTANCE;
	}

	@Override
	public State lock() {
		System.out.println("Open --> Open (tried to lock)");
		return this;
	}

	@Override
	public State unlock() {
		System.out.println("Open --> Open (tried to unclock)");
		return this;
	}
	
	public static Open getInstance() {
		return INSTANCE;
	}
}
