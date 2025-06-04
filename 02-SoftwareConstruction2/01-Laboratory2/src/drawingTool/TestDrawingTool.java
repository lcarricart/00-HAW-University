/*******************************************************************************************************************
 * Objective of the program: Re-use the source code provided by the professor to get familiar with Java´s syntaxes
 * and draw objects in the screen.
 *******************************************************************************************************************
 * Pitfalls:
 * - Tried declaring an array of coordinates directly in the body of a class. Solution: open curly brackets.
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

// Selected package (information for the linker probably)
package drawingTool;

// Import libraries
import java.awt.Dimension;
import javax.swing.JFrame;

// Creates a kinda main class that makes use of all other classes
public class TestDrawingTool {
	private JFrame applicationFrame;
	
	public TestDrawingTool(String title) {
		applicationFrame = new JFrame(title);
		// Screen size automatically calculated
		Dimension screenSize = applicationFrame.getToolkit().getScreenSize();
		applicationFrame.setBounds(0, 0, screenSize.width, screenSize.height);
		applicationFrame.add(new DrawingArea(screenSize.width, screenSize.height));
		applicationFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestDrawingTool("Testing Ground");
	}
}