package scene;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TestDrawingTool {
	private static JFrame applicationFrame;
	
	public TestDrawingTool(String title) {
		applicationFrame = new JFrame(title);
		Dimension screenSize = applicationFrame.getToolkit().getScreenSize();
		applicationFrame.setBounds(0, 0, screenSize.width, screenSize.height);
		/*applicationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		applicationFrame.setUndecorated(true);
		applicationFrame.setVisible(true);*/
		applicationFrame.add(new DrawingArea());
		//applicationFrame.setLayout(new BorderLayout(100, 500));
		applicationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		applicationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//applicationFrame.setUndecorated(true);
		applicationFrame.setVisible(true);
		//applicationFrame.add(new ButtonPanel(), BorderLayout.WEST);
		System.out.println("Game on");
		}
	
	public static void main(String[] args) {
		new TestDrawingTool("My house");
	}
	
	public static void exit() {
		applicationFrame.dispatchEvent(new WindowEvent(applicationFrame, WindowEvent.WINDOW_CLOSING));
	}
	
	public static Dimension screenSize() {
		return applicationFrame.getToolkit().getScreenSize();
	}
	
	public static JFrame getFrame() {
		return applicationFrame;
	}
}