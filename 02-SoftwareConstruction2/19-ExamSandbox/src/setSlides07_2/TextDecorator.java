package setSlides07_2;

// Decorator pattern: decorator
public class TextDecorator implements Text {
	protected Text wrapped;
	
	public TextDecorator(Text wrapped) {
		this.wrapped = wrapped;
	}
	
	@Override
	public String render() {
		return wrapped.render();
	}
}
