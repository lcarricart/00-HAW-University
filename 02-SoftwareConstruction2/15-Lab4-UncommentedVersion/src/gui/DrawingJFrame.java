package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static gui.ConfigurationJPanel.EnumColor.*;

public class DrawingJFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private DrawingJPanel drawingJPanel;
    private ConfigurationJPanel configJPanel;
    private Color classicHead = Color.gray;
    private Color hotHead = new Color(197,70,68);
    private Color classicEyes = Color.BLACK;
    private Color alienEyes = new Color(225,0,152);

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
        
        drawingJPanel = new DrawingJPanel(frameW, frameH);
        configJPanel = new ConfigurationJPanel();
        
        // Adds the drawingJPanel to the frame, where the Poodles are drawn
        getContentPane().add(drawingJPanel, BorderLayout.CENTER);
        // Adds the ConfigurationJPanel to the same frame, and therefore they're placed together and can interact in the same frame window.
        getContentPane().add(configJPanel, BorderLayout.EAST);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        configJPanel.getClearPoodlesBtn().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	    drawingJPanel.getScene().setDrawGround(true);
        	    drawingJPanel.getScene().setDrawPoodles(false);
        	    drawingJPanel.repaint();
        	}
        });
        
        configJPanel.getRefreshAllBtn().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		drawingJPanel.getScene().setDrawGround(true);
        	    drawingJPanel.getScene().setDrawPoodles(true);
        	    
        	    int glassesState = configJPanel.getComboBox1State();
        	    int hatState 	 = configJPanel.getComboBox2State();
        	    drawingJPanel.getScene().getGround().setGlassesKind(glassesState);
        	    drawingJPanel.getScene().getGround().setHatKind(hatState);
        	    
        	    int colorState	 = configJPanel.getComboBox3State();
        	    if (colorState == HOT.ordinal()) {
        	    	drawingJPanel.getScene().getGround().setHeadColor(hotHead);
        	    	drawingJPanel.getScene().getGround().setIrisColor(classicEyes);
        	    } else if (colorState == ALIEN.ordinal()) {
        	    	drawingJPanel.getScene().getGround().setIrisColor(alienEyes);
        	    	drawingJPanel.getScene().getGround().setHeadColor(classicHead);
        	    } else if (colorState == CLASSIC.ordinal()) {
        	    	drawingJPanel.getScene().getGround().setIrisColor(classicEyes);
        	    	drawingJPanel.getScene().getGround().setHeadColor(classicHead);
        	    }
        	    
        	    drawingJPanel.repaint();
        	}
        });
    }
}