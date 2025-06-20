package giraffe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scene.DrawingArea;
import scene.TestDrawingTool;

public class ColorChooserPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton color1, color2, color3, color4;
	private JButton color5, color6, color7, color8;
	private JButton color9, color10, color11, color12;
	private JButton color13, color14, color15, color16;
	private TestDrawingTool tool;
	
	public ColorChooserPanel(DrawingArea drawing){
		//tool = new TestDrawingTool(null);
		setLayout(new BorderLayout());
		JLabel windowHeader = new JLabel("Color up, life is fruity-ful!");
		add(windowHeader, BorderLayout.NORTH);
		
		JPanel colorPicker = new JPanel();
		add(colorPicker, BorderLayout.CENTER);
		colorPicker.setLayout(new GridLayout(4, 4, 4, 4));
		
		color1 = defineButton("ORIGINAL", colorPicker, "#F0A22E");
		color2 = defineButton("CHERRY", colorPicker, "#B40000");
		color3 = defineButton("RASPBERRY", colorPicker, "#D32375");
		color4 = defineButton("MANDARIN", colorPicker, "#F78C18");
		color5 = defineButton("GRAPE", colorPicker, "#9618B1");
		color6 = defineButton("KIWI", colorPicker, "#91D863");
		color7 = defineButton("AVOCADO", colorPicker, "#66B52A");
		color8 = defineButton("BANANA", colorPicker, "#F4F644");
		color9 = defineButton("POMELO", colorPicker, "#E07B60");
		color10 = defineButton("APPLE", colorPicker, "#18F710");
		color11 = defineButton("PLUM", colorPicker, "#440B34");
		color12 = defineButton("MANGO", colorPicker, "#F4D320");
		color13 = defineButton("TAMARIND", colorPicker, "#76561D");
		color14 = defineButton("BLUEBERRY", colorPicker, "#522DDD");
		color15 = defineButton("PAPAYA", colorPicker, "#F1653C");
		color16 = defineButton("APRICOT", colorPicker, "#FBCEB1");
	}
	
	private JButton defineButton(String title, JPanel colorPicker, String hex) {
		JButton button = new JButton(title);
		button.addActionListener(this);
		button.setBackground(Color.decode(hex));
		colorPicker.add(button);
		return button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action performed!!!");
	
		
		if (e.getSource() == color1) {
			//getScene.setColor();
		} else if (e.getSource() == color2) {

		} else if (e.getSource() == color3) {
			
		} else if (e.getSource() == color4) {
			
		} else if (e.getSource() == color5) {
			
		} else if (e.getSource() == color6) {
			
		} else if (e.getSource() == color7) {
			
		} else if (e.getSource() == color8) {
			
		} else if (e.getSource() == color9) {
			
		} else if (e.getSource() == color10) {
			
		} else if (e.getSource() == color11) {
			
		} else if (e.getSource() == color12) {
			
		} else if (e.getSource() == color13) {
			
		} else if (e.getSource() == color14) {
			
		} else if (e.getSource() == color15) {
			
		} else if (e.getSource() == color16) {
			
		}
		
	}

}
