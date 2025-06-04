package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WelcomeMenuJFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private final MainWelcomeJFrame parentFrame;

    public WelcomeMenuJFrame(MainWelcomeJFrame parentFrame, int menuW, int menuH) {
        super("Welcome Menu");
        this.parentFrame = parentFrame;

        initialization(menuW, menuH);
    }

    private void initialization(int menuW, int menuH) {
        setSize(new Dimension(menuW, menuH));
        setLocationRelativeTo(parentFrame); // centre over background
        
        JPanel panel = new WelcomeMenuJPanel(parentFrame);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); // do not kill JVM if closed manually
        setVisible(true);
    }
}