package drawingTool;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;
    private Scene scene;

    public DrawingArea(int width, int height) {
        scene = new Scene(width, height);
    }
	
	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		
		Drawing.setPen(pen);
	
		scene.generateRandomPuddles();
		scene.draw();

//		Puddle dog1 = new Puddle (size);
//		dog1.drawAt(600, 400);
	}
}