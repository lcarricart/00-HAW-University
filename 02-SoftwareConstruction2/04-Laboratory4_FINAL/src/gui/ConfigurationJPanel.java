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
    private String[] options = {"NONE :(", "John Lennon", "California Sunrise", "Random!"};
    private String[] options2 = {"NONE :(", "Farmer Hat", "Party Hat", "Jewish Hat", "Random!"};
    private String[] options3 = {"Classic", "Hot Head", "Alien Eyes"};
	
    private JButton refreshAllBtn = new JButton("Refresh All");
    private JButton clearPoodlesBtn = new JButton("Clear Poodles");
    private JSlider volumeSlider = new JSlider(0, 100, 10);
    private JComboBox<String> comboBox = new JComboBox<>(options);
    private JComboBox<String> comboBox2 = new JComboBox<>(options2);
    private JComboBox<String> comboBox3 = new JComboBox<>(options3);
	
	private final Font TITLE_FONT = new Font("Lucida Bright	", Font.BOLD, 18);
	private final Font BUTTON_FONT = new Font("Lucida Bright", Font.PLAIN, 14);

	public ConfigurationJPanel() {
		super();
		initialization();
	}
	
	// Can I use the first two for something?
	public enum EnumGlasses {
	    NO_GLASSES, LENNON, BEACH, RANDOM_GLASSES;
	}
	public enum EnumHat {
	    NO_HAT, FARMER, PARTY, JEWISH, RANDOM_HAT;
	}
	public enum EnumColor {
		CLASSIC, HOT, ALIEN;
	}

	private void initialization() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Title of the JPanel
		add(Box.createVerticalStrut(20));
		JLabel title = new JLabel("  Dynamic Controls  ");
		title.setFont(TITLE_FONT);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(title);
		add(Box.createVerticalStrut(15));

		// Refresh Scene button
		refreshAllBtn.setFont(BUTTON_FONT);
		refreshAllBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(refreshAllBtn);
		add(Box.createVerticalStrut(20));

		// Set Ground button
		clearPoodlesBtn.setFont(BUTTON_FONT);
		clearPoodlesBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(clearPoodlesBtn);
		add(Box.createVerticalStrut(20));
		
		// Volume Slider
		JLabel slideLabel = new JLabel("  Volume  ");
		slideLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		volumeSlider.setPaintTrack(true);
		volumeSlider.setPaintTicks(true);
		volumeSlider.setPaintLabels(true);
		volumeSlider.setMajorTickSpacing(25);
		volumeSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	    add(slideLabel);  
	    add(volumeSlider); 
	    add(Box.createVerticalStrut(20));
	    
	    // Combo Box (Glasses)
        JLabel comboLabel = new JLabel("Choose your glasses");
        int desiredHeight = 20; // in pixels!
        
        comboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, desiredHeight));
        comboBox.setFont(BUTTON_FONT);
        comboLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    add(comboLabel);
	    add(comboBox);
	    add(Box.createVerticalStrut(20));
	    
	    // Combo Box (Glasses)
        JLabel comboLabel2 = new JLabel("Choose your hat");
        
        comboBox2.setMaximumSize(new Dimension(Integer.MAX_VALUE, desiredHeight));
        comboBox2.setFont(BUTTON_FONT);
        comboLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
	    add(comboLabel2);
	    add(comboBox2);
	    add(Box.createVerticalStrut(20));
	    
	    // Combo Box (Color)
        JLabel comboLabel3 = new JLabel("Poodle's Color");
        
        comboBox3.setMaximumSize(new Dimension(Integer.MAX_VALUE, desiredHeight));
        comboBox3.setFont(BUTTON_FONT);
        comboLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
	    add(comboLabel3);
	    add(comboBox3);
	    add(Box.createVerticalStrut(20));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	public JButton getClearPoodlesBtn() {
		return clearPoodlesBtn;
	}
	
	public JButton getRefreshAllBtn() {
		return refreshAllBtn;
	}
	
	public JSlider getVolumeSlider() {
		return volumeSlider;
	}
	
	// 0.NONE	1.Lennon	2.Beach 	3.Random
    public int getComboBox1State() {
        return comboBox.getSelectedIndex();
     }
    
	// 0.NONE	 1.Farmer	 2.Party	3.Jewish 	4.Random
    public int getComboBox2State() {
    	return comboBox2.getSelectedIndex();
     }
    
	// 0.Classsic	 1.Hot Head 	2.Alien Eyes
    public int getComboBox3State() {
    	return comboBox3.getSelectedIndex();
     }
}
