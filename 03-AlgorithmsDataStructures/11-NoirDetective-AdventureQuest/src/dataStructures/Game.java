// It uses GraphStoryLine as the data structure to hold the story. 

package dataStructures;

import java.util.Scanner;

import scenes.NodeScene;
import scenesA.*;
import scenesB_Sal.*;
import scenesB_Vivian.*;
import scenesC.*;


public class Game {
	private GraphStoryLine storyLine;
	private AdjacencyRow currentRow;
	private NodeScene currentNode;
	private EndingScreen endingScreen; // I want the whole program to use the ssame ending screen ("global" access within the class)
	
	public Game() {
		ApartmentStart firstScene = new ApartmentStart("Apartment Start");
		storyLine = new GraphStoryLine(firstScene, "Apartment Start");
	}
	
	private void init() {
		currentRow = storyLine.getRootRow();
		currentNode = currentRow.getBaseNode();
		
		// (A) Start: Main character arrives to his apartment. Option to avoid / play the telephone voicemail
		TelephoneDialer dialer = new TelephoneDialer("Telephone Dialer");
		Sleep20Min sleep = new Sleep20Min("Sleep");
		storyLine.addNode(dialer, "Telephone Dialer");
		storyLine.addNode(sleep, "Sleep");
		storyLine.getAdjRow("Apartment Start").addNeighbour(dialer, "Press the dialer button.");
		storyLine.getAdjRow("Apartment Start").addNeighbour(sleep, "Ignore it. Go to sleep.");
		
		// (A) Option 1: Ignore and go to bed (20 minutes) / internal monologue (can be repeated 5 times, then GAME OVER)
		storyLine.getAdjRow("Sleep").addNeighbour(dialer, "Press the dialer button.");
		storyLine.getAdjRow("Sleep").addNeighbour(sleep, "Ignore it. Go to sleep (again).");
		
		// (A) Option 2: Voicemail sounds, 2 persons send messages with different cases. Urgency!!
		VivianStart vivianStart = new VivianStart("Vivian Start");
		SalStart salStart = new SalStart("Sal Start");
		VivianRoom209 room209 = new VivianRoom209("Room 209");
		storyLine.addNode(vivianStart, "Vivian Start");
		storyLine.addNode(salStart, "Sal Start");
		storyLine.addNode(room209, "Room 209");
		storyLine.getAdjRow("Telephone Dialer").addNeighbour(vivianStart, "Take Vivian's case.");
		storyLine.getAdjRow("Telephone Dialer").addNeighbour(salStart, "Take Sal's case.");
		
		// (B - VIVIAN) Detective visits the crime scene.
		// (B - VIVIAN) User can go in many direcitons as if physically walking with freedom through different rooms.
		VivianElevator elevatorScene = new VivianElevator("Elevator Scene");
		VivianStairs stairsScene = new VivianStairs("Stairs Scene");
		storyLine.addNode(elevatorScene, "Elevator Scene");
		storyLine.addNode(stairsScene, "Stairs Scene");
		storyLine.getAdjRow("Vivian Start").addNeighbour(elevatorScene, "Take the Elevator (fast but loud).");
		storyLine.getAdjRow("Vivian Start").addNeighbour(stairsScene, "Take the Stairs (exhausting).");
		
		// (B - VIVIAN) Option 1: Use the elevator --> Room 209
		storyLine.getAdjRow("Elevator Scene").addNeighbour(room209, "Traverse the corridor.");
		// (B - VIVIAN) Option 2: Use the stairs --> Room 209
		storyLine.getAdjRow("Stairs Scene").addNeighbour(room209, "Traverse the corridor.");
		// (B - VIVIAN) Common
		VivianLaptop laptopScene = new VivianLaptop("Vivian Laptop");
		storyLine.addNode(laptopScene, "Vivian Laptop");
		storyLine.getAdjRow("Room 209").addNeighbour(laptopScene, "Secure the laptop before the data is wiped.");
		
		// (C) Finally, the user talks to the main caller (client) and gives the conclusion. Based on the evidence that the detective identified, more options will be available at this conclusion stage.
		// (C) From a list of possible evidence, the player needs to select the ones that are coherent to the theory he/she's builiding in his/her mind. Theories for suspect / method / (...)
		// (C) An 80% correct answer will be good enough to pass the game, making it possible for the user to win --even with all the involved subjectivity.
		this.endingScreen = new EndingScreen("Ending Screen");
		storyLine.addNode(endingScreen, "Ending Screen");
		storyLine.getAdjRow("Vivian Laptop").addNeighbour(endingScreen, "Continue to score menu.");
		
		// (C - SAL)
		storyLine.getAdjRow("Sal Start").addNeighbour(endingScreen, "Continue to score menu.");
	}
	
	// Update the graph based on user decisions
	private void updateStory(int repeatSleep, boolean tookElevator) {
		// First possible GAME OVER (avoid dialer messages 3 times, sleeping)
		if (repeatSleep == 3) {
			storyLine.getAdjRow("Sleep").removeNeighbourFromNodeNamed("Telephone Dialer");
			storyLine.getAdjRow("Sleep").removeNeighbourFromNodeNamed("Sleep");
			
			EndingSal endingSal = new EndingSal("Ending Sal");
			storyLine.addNode(endingSal, "Ending Sal");
			
			storyLine.getAdjRow("Sleep").addNeighbour(endingSal, "Continue.");
			storyLine.getAdjRow("Ending Sal").addNeighbour(endingScreen, "Continue to score menu.");
		} else if (tookElevator) {
			VivianWindow windowScene = new VivianWindow("Vivian Window");
			storyLine.addNode(windowScene, "Vivian Window");
			storyLine.getAdjRow("Room 209").addNeighbour(windowScene, "(RUSH THE WINDOW) Tackle the silhouette before they make the fire escape.");
			storyLine.getAdjRow("Vivian Window").addNeighbour(endingScreen, "Continue to score menu.");
		}
	}
	
	// Cheap clear screen (100 empty lines)
	private void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
	
	public void start() {
		init();
		
        Scanner scanner = new Scanner(System.in);
        
        // Extra variables
        int repeatSleep = 0;			// If =3, then GAME OVER
        boolean tookElevator = false;
		
		currentNode.start();
		
		while (storyLine.getAdjRow(currentNode).getLength() != 0) {
			updateStory(repeatSleep, tookElevator);
			
			boolean tempFlag = false;
			tookElevator = false; // Resets the variable to avoid repetitions
			
			System.out.println("--------------------------------");
	        int i = 1;
	        for (Edge edge : currentRow.getNeighbours()) {
	            System.out.println(i + ". " + edge.getActionText());
	            i++;
	        }

	        int choice = -1;
	        while (!tempFlag) {
	        	System.out.print("> Option number: ");
	        	choice = scanner.nextInt(); 	// Read it
	        	
	        	if ((choice > 0) && (choice <= currentRow.getLength())) {	// If choice is between 0 and max number of options
	            	tempFlag = true;				
	                scanner.nextLine(); 		// Consume the leftover "Enter" key press
	            } else {
	                System.out.println("Jack is too tired. Pick a valid number.");
	            }
	        }
	        System.out.println("--------------------------------\n");
	        
	        int index = choice - 1;
	        currentNode = currentRow.getOneNeighbour(index);
	        
	        if (currentNode != null) {
	            currentRow = storyLine.getAdjRow(currentNode);
	            clearScreen();
	            currentNode.start();
	        	
	        }
	        
	        // (VIVIAN & Main Storyline) Check user decisions and updates variables
	        if (currentNode instanceof Sleep20Min) {
	        	repeatSleep++;
	        } else if (currentNode instanceof EndingSal) {
	        	repeatSleep = 0;
	        } else if (currentNode instanceof VivianElevator) {
	        	tookElevator = true;
	        } else if (currentNode instanceof VivianRoom209) {
	        	endingScreen.setPartialScore(80); 	// +80 points (ending is secured)
	        } else if (currentNode instanceof VivianWindow) {
	        	endingScreen.setPartialScore(20); 	// +20 points (special ending)
	        }
	        
	        // (SAL Storyline) Check user decisions and updates variables
	        if (currentNode instanceof SalStart) {
	        	endingScreen.setPartialScore(50); 	// +50 points (undeveloped, dead end)
	        }
		}
		scanner.nextLine();
		scanner.close();
	}
}
