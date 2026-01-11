// This scene is reachable after the user attempts to sleep 5 times (1 hour)

package scenesA;

import scenes.NodeScene;

public class EndingSal extends NodeScene {
	public EndingSal(String uniqueName) {
		super(uniqueName);
	}
	
	@Override
	public void start() {
		System.out.println("I pull the pillow over my head. Ignore it. Just ignore it. The sleep is heavy now, dragging me");
		System.out.println("down like an anchor. It will go away if I just stay q————");
		System.out.println("");
		System.out.println("CRASH.");
		System.out.println("");
		System.out.println("The sound isn't in my head. It's the front door. The lock explodes inward with the sickening sound");
		System.out.println("of wood and twisted metal. Dust flies into the bedroom.");
		System.out.println("I scramble up, tangling in the sheets, reaching for a gun that isn't there. The hallway light blinds me.");
		System.out.println("");
		System.out.println("A shadow fills the doorframe. Massive. Shoulders like a bull. Sal. He’s breathing hard. He wipes sweat from");
		System.out.println("his forehead with a handkerchief.");
		System.out.println("");
		System.out.println("\"I warned you, Jack,\" he grunts, stepping over the debris. \"I said don't make me come up here.\"");
		System.out.println("");
		System.out.println("He doesn't wait for an excuse. The crowbar in his hand swings down. The world goes white, then red,");
		System.out.println("then absolute black.");
		System.out.println("");
		System.out.println("*** GAME OVER ***");
	}
}
