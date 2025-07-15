/**
 * Provides a test application window with a panel "DrawingArea" and some "Buttons".
 * 
 * @author Björn Gottfried
 * @version 2.0
 */

package drawingTools;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

// listener , when I click on a button
public class DrawingTool extends JFrame implements ActionListener {
	private DrawingArea drawing;
	private Buttons buttons = new Buttons();
	private JPanel sliderPannel;

	public DrawingTool(String title) {		//Constructor
		super(title);
		
		setLayout(new BorderLayout());
		constructButtonMenu();
		constructDrawingArea();

		buttons.getSlider().addChangeListener(e -> {
			int value = buttons.getSlider().getValue();
			drawing.getScene().setNumberOfKangaroos(value);
			drawing.repaint();
		});

		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
	}
	
	private void constructButtonMenu() {
		buttons.addButtonsToAPanel(this);
		System.out.println("AAAAAAAAA> "+this+" BBBBBBBBBBBBB");
		buttons.addActionListener(this);
		sliderPannel = new JPanel();
	}

	private void constructDrawingArea() {
		drawing = new DrawingArea();
		add(drawing, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.getChangeBackgroundButton()) {
			tidyUpDrawingArea();
			int colorR = RandomNumber.between(0,  255);
			int colorG = RandomNumber.between(0,  255);
			int colorB = RandomNumber.between(0,  255);
			Color randomColor = new Color(colorR, colorG, colorB);
			drawing.getScene().setColor(randomColor); // Set color in Scene
			drawing.repaint();
		}
		else if (e.getSource() == buttons.getGloves()) {
			tidyUpDrawingArea();
			drawing.getScene().setKangaroosHaveGloves(true); // Set kangaroos to have gloves
			drawing.repaint();
		}
		else if (e.getSource() == buttons.getResetButton()) {
			tidyUpDrawingArea();
			drawing.getScene().setKangaroosHaveGloves(false); // Remove gloves
			drawing.getScene().setColor(Color.WHITE);         // Reset background
			drawing.repaint();
		}
		// self-directed study
		// Lab4 task : change the eye color but without decorator pattern
		// It changes the eye color of all kangaroos every time whenver the button is clicked
		// Why ? Since it directly sets the color on each kangaroo.
		else if (e.getSource() == buttons.getChagneEyecolorButton()) {
			tidyUpDrawingArea();
			int colorR = RandomNumber.between(0,  255);
			int colorG = RandomNumber.between(0,  255);
			int colorB = RandomNumber.between(0,  255);
			Color randomColor = new Color(colorR, colorG, colorB);
			drawing.getScene().setEyecolor(randomColor);
			drawing.repaint();
		}
		// Lab4 task : change the eye color using decorator pattern
		// The method decorateKangaroosWithRandomEyeColor() in Scene class wraps each kangaroo with an EyeColorDecorator only once.
		// After the first decoration, clicking the button again will wrap already-decorated kangaroos, which may not have any effect.
		else if (e.getSource() == buttons.decorateKangaroosWithRandomEyeColor()) {
			tidyUpDrawingArea();
			drawing.getScene().decorateKangaroosWithRandomEyeColor();
			drawing.repaint();
		}
		else if (e.getSource() == buttons.decorateKangaroosWithRandomFaceColor()) {
			tidyUpDrawingArea();
			drawing.getScene().decorateKangaroosWithRandomfaceColor();
			drawing.repaint();
		}
		else if (e.getSource() == buttons.decorationPatternAddCOrnHatButton()) {
			tidyUpDrawingArea();
			drawing.getScene().decorationPatternAddCOrnHatButton();
			drawing.repaint();
		}
		else if (e.getSource() == buttons.decorationPatternAddBowTimeButton()) {
			tidyUpDrawingArea();
			drawing.getScene().decorateionPatternAddBowtieButton();
			drawing.repaint();
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
