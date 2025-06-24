package house;

/**
 * Provides a panel which can be used for drawing.
 * 
 * @author Björn Gottfried
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;
	private Scene myScene;
	
	public DrawingArea() {
		super();
		Dimension screenSize = getToolkit().getScreenSize();		
		myScene = new Scene(screenSize.width, screenSize.height);
	}

	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		Drawing.set(pen);
		myScene.draw();
	}
}