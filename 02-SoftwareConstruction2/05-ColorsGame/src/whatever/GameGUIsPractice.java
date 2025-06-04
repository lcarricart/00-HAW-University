/*******************************************************************************************************************
 * Objective of the program: Re-use the source code provided by the professor to get familiar with Java´s syntaxes
 * and draw objects in the screen.
 *******************************************************************************************************************
 * Pitfalls:
 * - Tried declaring an array of coordinates directly in the body of a class. Solution: open curly brackets.
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

// Selected package (information for the linker probably)
package whatever;

import java.awt.BorderLayout;
import java.awt.Color;
// Import libraries
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.*;

// Creates a kinda main class that makes use of all other classes
public class GameGUIsPractice extends JFrame implements ActionListener {
	private JPanel gamePanel;
	private JTextField infoField;
	private JButton b1, b2, b3, b4;
	
	public GameGUIsPractice(String title) {
		setLayout(new BorderLayout());
		
		infoField = new JTextField();
		infoField.setText("red");
		add(infoField, BorderLayout.NORTH);
		
		gamePanel = new JPanel();
		
		add(gamePanel, BorderLayout.CENTER);
		gamePanel.setLayout(new GridLayout(2, 2, 10, 10));
		
		// Screen size automatically calculated
		Dimension screenSize = getToolkit().getScreenSize();
		
		// Screen size position
		int x = screenSize.width / 4;
		int y = screenSize.height / 4;
		setBounds(x,y, screenSize.width / 2, screenSize.height / 2);
		
		initButtons();
		
		setVisible(true);
		
		// IMPORTANT to not consume Heap!! 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initButtons() {
		b1 = createButton(Color.red);
		b2 = createButton(Color.green);
		b3 = createButton(Color.yellow);
		b4 = createButton(Color.blue);
	}
	
	//Helper Function
	private JButton createButton(Color c) {
		JButton b = new JButton();
		b.setBackground(c);
		b.addActionListener(this);
		gamePanel.add(b);
		return b;
	}
	
	private void randomTextColor() {
		int min = 0;
		int max = 3;
		
		int i = RandomNumber.between(min, max);
		
		switch (i) {
		case 0:
			infoField.setForeground(Color.green);
			break;
		case 1:
			infoField.setForeground(Color.pink);
			break;
		case 2:
			infoField.setForeground(Color.red);
			break;
		default:
			infoField.setForeground(Color.blue);
			break;
		}
	}
	
	public static void main(String[] args) {
		new GameGUIsPractice("Testing Ground");
	}

	@Override // because it implements ActionListener
	public void actionPerformed(ActionEvent e) {
		JButton x = (JButton)e.getSource();
		if (x.getBackground() == Color.red && (infoField.getText().equals("red"))) {
			System.out.println("red");
			change();
		} else if (x.getBackground() == Color.blue && (infoField.getText().equals("blue"))) {
			System.out.println("blue");
			change();
		} else if (x.getBackground() == Color.yellow && (infoField.getText().equals("yellow"))) {
			System.out.println("yellow");
			change();
		} else if (x.getBackground() == Color.green && (infoField.getText().equals("green"))) {
			System.out.println("green");
			change();
		} else {
			System.out.println("GAME OVER");
			System.exit(0);
		}
	}

	private void change() {
		changeButtonColors();
		changeInfoField();
	}
	
	private void changeInfoField() {
		randomTextColor();
		
		int min = 0;
		int max = 3;
		
		int randColor = RandomNumber.between(min, max);
		
		switch (randColor) {
		case 0:
			infoField.setText("red");
			break;
		case 1:
			infoField.setText("blue");
			break;
		case 2:
			infoField.setText("green");
			break;
		default:
			infoField.setText("yellow");
			break;
		}
	}
	
	private void changeButtonColors() {
		int min = 0;
		int max = 3;
		
		int i = RandomNumber.between(min, max);
		
		if (i == 0) {
			b1.setBackground(Color.red);
			b2.setBackground(Color.blue);
			b3.setBackground(Color.yellow);
			b4.setBackground(Color.green);
		} else if (i == 1) {
			b1.setBackground(Color.blue);
			b2.setBackground(Color.green);
			b3.setBackground(Color.red);
			b4.setBackground(Color.yellow);
		} else if (i == 2) {
			b1.setBackground(Color.yellow);
			b2.setBackground(Color.red);
			b3.setBackground(Color.green);
			b4.setBackground(Color.blue);
		} else {
			b1.setBackground(Color.blue);
			b2.setBackground(Color.red);
			b3.setBackground(Color.green);
			b4.setBackground(Color.yellow);
		}
	}
}