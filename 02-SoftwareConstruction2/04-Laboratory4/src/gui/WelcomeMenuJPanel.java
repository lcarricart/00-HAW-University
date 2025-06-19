package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WelcomeMenuJPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MainWelcomeJFrame parentFrame;
	
	private final Color LIGHT_BLUE = new Color(245, 245, 250);
	private final Font TITLE_FONT  = new Font("SansSerif", Font.BOLD, 18);
    private final Font LABEL_FONT  = new Font("SansSerif", Font.PLAIN, 14);
    private final Font FIELD_FONT  = new Font("SansSerif", Font.PLAIN, 14);
    private final Font BUTTON_FONT = new Font("SansSerif", Font.PLAIN, 14);

	
    public WelcomeMenuJPanel(MainWelcomeJFrame parentFrame) {
    	super();	// This would otherwise happen anyway but under the hood.
    	this.parentFrame = parentFrame;
    	
    	initialization();
    }
    
    private void initialization() {
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	setBackground(LIGHT_BLUE);
    	
    	JLabel title = new JLabel("Welcome to the SO2 Laboratory!");
    	title.setFont(TITLE_FONT);
    	title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);
        add(Box.createVerticalStrut(15));	// Leaves a vertical empty space
        
        JTextField authors = new JTextField("Authors: Luciano & Kristian");
        authors.setFont(FIELD_FONT);
        authors.setEditable(false);
        authors.setMaximumSize(authors.getPreferredSize());
        authors.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(authors);
        add(Box.createVerticalStrut(15));
        
        JLabel greetingLabel = new JLabel("Say Hi! to the developers:");
        greetingLabel.setFont(LABEL_FONT);
        greetingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(greetingLabel);
        add(Box.createVerticalStrut(5));
        
        JTextField greetingField = new JTextField(20);
        greetingField.setFont(FIELD_FONT);
        greetingField.setMaximumSize(greetingField.getPreferredSize());
        greetingField.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(greetingField);
        add(Box.createVerticalStrut(20));
        
        JButton continueBtn = new JButton(" Continue");
        continueBtn.setFont(BUTTON_FONT);
        continueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(continueBtn);
        add(Box.createVerticalStrut(20));
        
        JButton exitBtn = new JButton("Exit NOW");
        exitBtn.setFont(BUTTON_FONT);
        exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(exitBtn);
        add(Box.createVerticalStrut(20));
        
        JButton fakeBtn = new JButton("I am fake!");
        fakeBtn.setFont(BUTTON_FONT);
        fakeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(fakeBtn);
        
        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose(); // close background
                new DrawingJFrame("SO2 Drawing Window"); // open drawing stage
            }
        });
        
        exitBtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        
        fakeBtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		fakeBtn.setVisible(false);
        		
                JLabel fakeActionMessage = new JLabel(">:(");
                fakeActionMessage.setFont(LABEL_FONT);
                fakeActionMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(fakeActionMessage);
        	}
        });
    }
}
