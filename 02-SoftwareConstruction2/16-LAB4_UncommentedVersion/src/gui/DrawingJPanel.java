package gui;

import java.awt.Graphics;
import javax.swing.JPanel;

import background.Scene;
import drawingTool.Drawing;

public class DrawingJPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private Scene scene;

    public DrawingJPanel(int width, int height) {
        super();
        
        scene = new Scene(width, height);
    }

    public Scene getScene() {
    	return scene;
    }
    
    @Override
    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        Drawing.setPen(pen);
        scene.draw();
    }
}
