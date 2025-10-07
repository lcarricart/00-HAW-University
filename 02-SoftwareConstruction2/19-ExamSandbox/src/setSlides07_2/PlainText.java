package setSlides07_2;

// Decorator pattern: Concrete component
public class PlainText implements Text {
	private String content;
	
	public PlainText(String content) {
		this.content = content;
	}
	
	@Override
	public String render() {
		return content;
	}
}
