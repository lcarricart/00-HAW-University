package nodes;

public class RootNode extends AbstractNode {

	@Override
	public boolean isValid(char c) {
		// Needs to be always true because it's an empty root containing all the possible patterns
		return true;
	}
}
