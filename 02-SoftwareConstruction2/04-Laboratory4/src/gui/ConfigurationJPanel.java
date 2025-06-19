package gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfigurationJPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private DrawingJPanel drawingPanel;
	private final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 18);
//    private final Font LABEL_FONT  = new Font("SansSerif", Font.PLAIN, 14);
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// The whole idea is to now paint by steps, instead of all at once. Those
		// "steps" happen when we press certain buttons.
		drawingPanel.getScene().setGround();
		drawingPanel.repaint();
	}
}
