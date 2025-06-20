package giraffe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GiraffeBreeder{
	private JButton colorButton = new JButton("CameloFARBElis");
	private JButton neckLengthButton = new JButton("Lange Nackt der Giraffe");
	private JButton tongueOutButton = new JButton("Ligma");
	private JButton backgroundButton = new JButton("Savanna");

	public GiraffeBreeder() {
		
		colorButton.setFocusable(false);
		colorButton.setBackground(Color.white);
		
		neckLengthButton.setFocusable(false);
		neckLengthButton.setBackground(Color.yellow);
		
		tongueOutButton.setFocusable(false);
		tongueOutButton.setBackground(Color.red);
		
		backgroundButton.setFocusable(false);
		backgroundButton.setBackground(Color.green);
		
		
	}
	
	public void addActionListener(ActionListener listener) {
		colorButton.addActionListener(listener);
		neckLengthButton.addActionListener(listener);
		tongueOutButton.addActionListener(listener);
		backgroundButton.addActionListener(listener);
	}

	public void addButtonsToAPanel(JFrame frame) {
		JPanel menu = new JPanel();
		menu.setBackground(Color.gray);
		menu.setLayout(new GridLayout(1, 1, 10, 10));

		menu.add(colorButton);
		menu.add(neckLengthButton);
		menu.add(tongueOutButton);
		menu.add(backgroundButton);
		

		menu.setBorder(BorderFactory.createRaisedBevelBorder());
		frame.add(menu, BorderLayout.NORTH);
	}

	public JButton colorButton() {
		return colorButton;
	}

	public JButton neckLengthButton() {
		return neckLengthButton;
	}

	public JButton tongueOutButton() {
		return tongueOutButton;
	}
	
	public JButton backgroundButton() {
		return backgroundButton;
	}

}
