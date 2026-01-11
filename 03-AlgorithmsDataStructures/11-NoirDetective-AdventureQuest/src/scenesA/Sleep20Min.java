// Repeatable scene. If user waits for 1 hour (three repeats), GAME OVER

package scenesA;

import scenes.NodeScene;

public class Sleep20Min extends NodeScene {
	public Sleep20Min(String uniqueName) {
		super(uniqueName);
	}
	
	@Override
	public void start() {
		System.out.println("I turn my back on it. The bedroom is darker. Safer. I collapse onto the mattress, arm over my eyes.");
		System.out.println("Just drift. Just let go. The traffic outside is a distant ocean. But the silence isn't empty.");
		System.out.println("");
		System.out.println("It's full of that light. I can feel it through the drywall. Pulsing. A red rhythm in the black.");
		System.out.println("I sleep, or I think I sleep... Then I eject awake, gasping air like I was drowning. The sheets are");
		System.out.println("twisted. My heart is hammering against my ribs.");
		System.out.println("");
		System.out.println("It’s no good. The unknown is heavy. It’s sitting on my chest. Who is it? What if it's too late?");
		System.out.println("The question mark is louder than the answer could ever be. I can't stay in this bed.");
		System.out.println("I have to know.");
		System.out.println("");
		System.out.println("(20 minutes have passed...)");
		System.out.println("");
	}
}
