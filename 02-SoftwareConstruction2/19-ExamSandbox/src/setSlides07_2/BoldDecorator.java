package setSlides07_2;

// Decorator pattern: Concrete decorator
public class BoldDecorator extends TextDecorator {
	private Text wrapped;
	
	public BoldDecorator(Text wrapped) {
		super(wrapped);
		this.wrapped = wrapped;
	}
	
	@Override
	public String render() {
		return "*" + wrapped.render() + "*";
	}
}
