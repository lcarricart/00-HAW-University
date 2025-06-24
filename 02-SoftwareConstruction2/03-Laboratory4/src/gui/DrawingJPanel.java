package gui;

import java.awt.Graphics;
import javax.swing.JPanel;

import drawingTool.Drawing;
import drawingTool.Scene;

/**
 * Being a subclass of JPanel means we implicitly inherit everything from JComponent:
 * add(...), setLayout(...), repaint(), etc.
 */
public class DrawingJPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private Scene scene;
    private int width, height;

    public DrawingJPanel(int width, int height) {
        super();
        
        this.width = width;
        this.height = height;
        
        scene = new Scene(width, height);
    }

    @Override
    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        Drawing.setPen(pen);
        scene.draw();
    }
    
    public void regenerateScene() {
        scene = new Scene(width, height);
        repaint(); // triggers paintComponent().
    }
    
    public Scene getScene() {
    	return scene;
    }
}
