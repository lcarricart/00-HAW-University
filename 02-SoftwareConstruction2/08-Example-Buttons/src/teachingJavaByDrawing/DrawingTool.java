/**
 * Provides a test application window with a panel "DrawingArea" and some "Buttons".
 * 
 * @author Björn Gottfried
 * @version 2.0
 */

package teachingJavaByDrawing;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DrawingTool extends JFrame implements ActionListener {
	private DrawingArea drawing;
	private Buttons buttons = new Buttons();

	public DrawingTool(String title) {
		super(title);
		
		setLayout(new BorderLayout());

		constructButtonMenu();
		constructDrawingArea();

		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);

		setVisible(true);
	}
	
	private void constructButtonMenu() {
		buttons.addButtonsToAPanel(this);
		buttons.addActionListener(this);
	}

	private void constructDrawingArea() {
		drawing = new DrawingArea();
		add(drawing, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.getHousesButton()) {
			tidyUpDrawingArea();
			drawing.getVillage().setHouses();
		} else if (e.getSource() == buttons.getTreesButton()) {
			tidyUpDrawingArea();
			drawing.getVillage().setTrees();
		} else if (e.getSource() == buttons.getVillageButton()) {
			tidyUpDrawingArea();
			drawing.getVillage().setVillage();
		}
	}

	private void tidyUpDrawingArea() {
		drawing.removeAll();
		drawing.revalidate();
		drawing.repaint();		
	}
	
	public static void main(String[] args) {
		new DrawingTool("Draw a house");
	}
}
