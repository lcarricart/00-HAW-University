package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ConfigurationJPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private DrawingJPanel drawingPanel;
	private final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 18);
    private final Font LABEL_FONT  = new Font("SansSerif", Font.PLAIN, 14);
//    private final Font FIELD_FONT  = new Font("SansSerif", Font.PLAIN, 14);
	private final Font BUTTON_FONT = new Font("SansSerif", Font.PLAIN, 14);

	public ConfigurationJPanel(int panelW, int panelH, DrawingJPanel drawingPanel) {
		super();
		this.drawingPanel = drawingPanel;
		initialization(panelW, panelH);
	}

	private void initialization(int panelW, int panelH) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(Box.createVerticalStrut(20));
		JLabel title = new JLabel("  Dynamic Controls  ");
		title.setFont(TITLE_FONT);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(title);
		add(Box.createVerticalStrut(15));

		JButton refreshBtn = new JButton("Refresh scene");
		refreshBtn.setFont(BUTTON_FONT);
		refreshBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(refreshBtn);
		add(Box.createVerticalStrut(20));

		refreshBtn.addActionListener(e -> drawingPanel.regenerateScene());

		JButton setGround = new JButton("Regenerate Poodles");
		setGround.setFont(BUTTON_FONT);
		setGround.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(setGround);
		add(Box.createVerticalStrut(20));

		setGround.addActionListener(this);
		
		// Units Slider
		JSlider unitsNumberSlider = new JSlider(0, 100, 10);
		JLabel slideLabel = new JLabel("  Volume  ");
		slideLabel.setFont(LABEL_FONT);
		slideLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		unitsNumberSlider.setPaintTrack(true);
		unitsNumberSlider.setPaintTicks(true);
		unitsNumberSlider.setPaintLabels(true);
		unitsNumberSlider.setMajorTickSpacing(25);
		unitsNumberSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	    add(slideLabel);  
	    add(unitsNumberSlider); 
	    add(Box.createVerticalStrut(20));
	    
	    // Combo Box (Glasses)
	    String[] options = {"John Lennon", "California Sunrise", "NONE :("};
        JLabel comboLabel = new JLabel("Choose your glasses");
        JComboBox<String> comboBox = new JComboBox<>(options);
        int desiredHeight = 20; // in pixels!
        
        comboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, desiredHeight));
        comboLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    add(comboLabel);
	    add(comboBox);
	    add(Box.createVerticalStrut(20));
	    
	    // Combo Box (Glasses)
	    String[] options2 = {"Farmer Hat", "Jewish Hat", "Party Hat", "NONE :("};
        JLabel comboLabel2 = new JLabel("Choose your hat");
        JComboBox<String> comboBox2 = new JComboBox<>(options2);
        
        comboBox2.setMaximumSize(new Dimension(Integer.MAX_VALUE, desiredHeight));
        comboLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
	    add(comboLabel2);
	    add(comboBox2);
	    add(Box.createVerticalStrut(20));
	    
	    // Combo Box (Color)
	    String[] options3 = {"Random!!", "Classic"};
        JLabel comboLabel3 = new JLabel("Poodle's Color");
        JComboBox<String> comboBox3 = new JComboBox<>(options3);
        
        comboBox3.setMaximumSize(new Dimension(Integer.MAX_VALUE, desiredHeight));
        comboLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
	    add(comboLabel3);
	    add(comboBox3);
	    add(Box.createVerticalStrut(20));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// The whole idea is to now paint by steps, instead of all at once. Those
		// "steps" happen when we press certain buttons.
		drawingPanel.getScene().setGround();
		drawingPanel.repaint();
	}
}
