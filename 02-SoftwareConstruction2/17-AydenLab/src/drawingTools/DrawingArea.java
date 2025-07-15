/**
 * Provides a panel which can be used for drawing.
 *
 * @author Björn Gottfried
 * @version 1.0
 */

package drawingTools;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;
	private Scene scene;	// same as main we did in the lecture

	public DrawingArea() {
		scene = new Scene(); //Creating a scene object
		setBackground(Color.white); //Setting the background color to white
	}

	@Override
	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		Drawing.set(pen);
		setBackground(scene.getColor());
		scene.draw();
	}

	public Scene getScene() {
		return scene;
	}
}
