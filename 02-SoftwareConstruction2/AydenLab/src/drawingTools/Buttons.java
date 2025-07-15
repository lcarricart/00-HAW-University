package drawingTools;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.JLabel;

public class Buttons {
	private JButton changeBackgroundButton = new JButton("Change Background Color");
	private JButton glovesButton = new JButton("Add Gloves to Kangaroos");
	private JButton resetButton = new JButton("reset");
	private JButton chagneEyecolorButton = new JButton("Change Eye Color");
	private JButton decorationPatternChageEyecolorButton = new JButton("Change Eye Color with Pattern");
	private JButton decorationPatternChangeFacecolorButton = new JButton("Change Face Color with Pattern");
	private JButton decorationPatternAddCOrnHatButton = new JButton("Add Corn Hat to Kangaroos");
	private JButton decorationPatternAddBowTimeButton = new JButton("Add Bow Tie to Kangaroos");
	private JSlider slider = new JSlider(1, 10, 5);

	public void addActionListener(ActionListener listener) {
//		add action listeners to buttons
		changeBackgroundButton.addActionListener(listener);
		glovesButton.addActionListener(listener);
		resetButton.addActionListener(listener);
		chagneEyecolorButton.addActionListener(listener);
		decorationPatternChageEyecolorButton.addActionListener(listener);
		decorationPatternChangeFacecolorButton.addActionListener(listener);
		decorationPatternAddCOrnHatButton.addActionListener(listener);
		decorationPatternAddBowTimeButton.addActionListener(listener);
		slider.addChangeListener(e -> {
			int value = slider.getValue();
		});
	}

	public void addButtonsToAPanel(JFrame frame) {
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(18, 1, 15, 20));
//		add buttons to the menu
		menu.add(changeBackgroundButton);
		menu.add(glovesButton);
		menu.add(resetButton);
		menu.add(chagneEyecolorButton);
		menu.add(decorationPatternChageEyecolorButton);
		menu.add(decorationPatternChangeFacecolorButton);
		menu.add(decorationPatternAddCOrnHatButton);
		menu.add(decorationPatternAddBowTimeButton);
		menu.add(new JLabel("Number"));
		menu.add(slider);
		menu.setBorder(BorderFactory.createRaisedBevelBorder());
		frame.add(menu, BorderLayout.WEST);
	}

//	get buttons from the Buttons class
	public JButton getChangeBackgroundButton() {
		return changeBackgroundButton;
	}

	public JButton getGloves() {
		return glovesButton;
	}

	public JButton getResetButton() {
		return resetButton;
	}

	public JButton getChagneEyecolorButton() {
		return chagneEyecolorButton;
	}

	public JButton decorateKangaroosWithRandomEyeColor() {
		return decorationPatternChageEyecolorButton;
	}

	public JButton decorateKangaroosWithRandomFaceColor() {
		return decorationPatternChangeFacecolorButton;
	}

	public JButton decorationPatternAddCOrnHatButton() {
		return decorationPatternAddCOrnHatButton;
	}

	public JButton decorationPatternAddBowTimeButton() {
		return decorationPatternAddBowTimeButton;
	}

	public JSlider getSlider() {
		return slider;
	}
}
