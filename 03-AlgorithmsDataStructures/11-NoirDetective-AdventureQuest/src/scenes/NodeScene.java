// A NodeScene needs to be a unique / repeatable scene where there are printed messages. They should not end with decisions, that logic should be externalized.
// Each subclass of NodeScene contains fixed messages depending on the scenario. Otherwise I would have had to pass all the story through parameters (a mess).

package scenes;

public abstract class NodeScene {
	private String uniqueName; // it is the UID. Something could be improved to not duplicate this name and the UID of the AdjacencyRow
	
	public NodeScene(String uniqueName) {
		this.uniqueName = uniqueName;
	}
	
	// Where the plot will be printed (will be called from the Graph once the connections are made)
	public abstract void start();
	
	public String getUniqueName() {
		return uniqueName;
	}
}
