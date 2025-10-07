package setSlides07_2;

// Decorator pattern: Concrete decorator
public class BracketDecorator extends TextDecorator {
	private Text wrapped;
	
	public BracketDecorator(Text wrapped) {
		super(wrapped);
		this.wrapped = wrapped;
	}
	
	@Override
	public String render() {
		return "[" + wrapped.render() + "]";
	}
}
