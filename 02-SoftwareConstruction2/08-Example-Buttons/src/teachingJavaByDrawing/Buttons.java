package teachingJavaByDrawing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buttons {
	private JButton housesButton = new JButton("Houses");
	private JButton treesButton = new JButton("Trees");
	private JButton villageButton = new JButton("Village");

	public void addActionListener(ActionListener listener) {
		housesButton.addActionListener(listener);
		treesButton.addActionListener(listener);
		villageButton.addActionListener(listener);
	}

	public void addButtonsToAPanel(JFrame frame) {
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(18, 1, 15, 20));

		menu.add(housesButton);
		menu.add(treesButton);
		menu.add(villageButton);

		menu.setBorder(BorderFactory.createRaisedBevelBorder());
		frame.add(menu, BorderLayout.WEST);
	}

	public JButton getHousesButton() {
		return housesButton;
	}

	public JButton getTreesButton() {
		return treesButton;
	}

	public JButton getVillageButton() {
		return villageButton;
	}
}
