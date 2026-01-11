/*******************************************************************************************************************
 * Objective: A text-based story game, where different paths are represented by an adjacency list (more convenient
 * for the purpose of this application). Edges connect multiple storylines, sometimes leading to the same outcome.
 *******************************************************************************************************************
 * Context: A noir detective story, where the user resolves a crime in the style of Sherlock H.
 *******************************************************************************************************************
 * Potential improvements: 
 * 			- Include clock management to make the text appear in real-time, and not all together (major improvem.)
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student, HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

package application;

import dataStructures.Game;

public class Application {
	private static Game noirDetective;
	
	public static void main(String[] args) {
		// Do it as Gottfried showed during LAB3
		
		noirDetective = new Game();
		noirDetective.start();
	}
}
