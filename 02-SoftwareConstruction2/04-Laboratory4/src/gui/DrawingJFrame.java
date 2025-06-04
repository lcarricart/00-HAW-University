package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class DrawingJFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public DrawingJFrame(String title) {
        super(title);

        Dimension screen = this.getToolkit().getScreenSize();
        int frameW = screen.width;
        int frameH = screen.height;
        
        initialization(frameW, frameH);
    }
    
    private void initialization(int frameW, int frameH) {
    	setBounds(0, 0, frameW, frameH);
        getContentPane().setLayout(new BorderLayout());
        
        DrawingJPanel drawingJPanel = new DrawingJPanel(frameW, frameH);
        
        // Adds the drawingJPanel to the frame, where the Poodles are drawn
        getContentPane().add(drawingJPanel, BorderLayout.CENTER);
        // Adds the ConfigurationJPanel to the same frame, and therefore they're placed together and can interact in the same frame window.
        getContentPane().add(new ConfigurationJPanel(frameW, frameH, drawingJPanel), BorderLayout.EAST);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}