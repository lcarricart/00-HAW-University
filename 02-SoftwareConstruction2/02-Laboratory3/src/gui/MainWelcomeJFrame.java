/*******************************************************************************************************************
 * Objective of the program: Re-use the source code provided by the professor to get familiar with Java´s syntaxes
 * and draw objects on the screen.
 *******************************************************************************************************************
 * Pitfalls:
 * - Tried declaring an array of coordinates directly in the body of a class. Solution: open curly brackets.
 * - It's not extremely clear how the method paintComponent() inside the panels is being called
 *******************************************************************************************************************
 * Author: Luciano Carricart, https://github.com/lcarricart/
 * Status: Information Engineering student at HAW Hamburg, Germany.
 * Profile: https://www.linkedin.com/in/lucianocarricart/
 *******************************************************************************************************************/

package gui;

// Import libraries
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/* 
 * This JFrame is the full-screen background window. It shows a {@link MainBackgroundJPanel} and, once visible, opens {@link WelcomeMenuJFrame} in the centre. After the
 * user presses “Continue”, both this frame and the menu frame close, handing control to {@link DrawingJFrame}. 
 */
public class MainWelcomeJFrame extends JFrame {
    // The actual numeric value (here 1L) is arbitrary; you can pick any long literal.
    private static final long serialVersionUID = 1L;

    public MainWelcomeJFrame(String title) {
        super(title); // inherit JFrame initialisation

        // Make this window full-screen
        Dimension screen = this.getToolkit().getScreenSize();
        int frameW = screen.width;
        int frameH = screen.height;
        int menuW = frameW  / 3;
        int menuH = frameH / 3;
        
        initialization(frameW, frameH, menuW, menuH);
    }
    
    // This is where my program starts
    public static void main(String[] args) {
        new MainWelcomeJFrame("SO2 — Welcome");
    }
    
    private void initialization(int frameW, int frameH, int menuW, int menuH) {
    	setBounds(0, 0, frameW, frameH);
        // Add the sky background panel
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new MainBackgroundJPanel(), BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        new WelcomeMenuJFrame(this, menuW, menuH);
    }
}














// I couldn't find JFrame library (or superclass), but this is what it looks like:
// The constructor is overloaded and accepts many parameters. If passed one value it automatically sets it as the title.

//package javax.swing;
//
//import java.awt.GraphicsConfiguration;
//import java.awt.HeadlessException;
//
///**
// * A top‐level window with a title and a content pane.
// */
//public class JFrame extends Frame {
//    private static final String ROOTPANE_BUTTON_KEY = "RootPane.windowDecorationButton"; // (internal detail)
//
//    /**
//     * Creates a <code>JFrame</code> that is initially invisible
//     * and has no title.
//     *
//     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
//     *         returns true
//     */
//    public JFrame() throws HeadlessException {
//        this("", (GraphicsConfiguration) null);
//    }
//
//    /**
//     * Creates a <code>JFrame</code> that is initially invisible
//     * and has the specified title.
//     *
//     * @param title  the String to display in the frame's title bar
//     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
//     *         returns true
//     */
//    public JFrame(String title) throws HeadlessException {
//        this(title, (GraphicsConfiguration) null);
//    }
//
//    /**
//     * Creates a <code>JFrame</code> that is initially invisible
//     * and is given a specific GraphicsConfiguration.
//     *
//     * @param gc  the GraphicsConfiguration of the target screen device
//     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
//     *         returns true
//     */
//    public JFrame(GraphicsConfiguration gc) throws HeadlessException {
//        this("", gc);
//    }
//
//    /**
//     * Creates a <code>JFrame</code> that is initially invisible,
//     * has the specified title, and uses the specified GraphicsConfiguration.
//     *
//     * @param title  the String to display in the frame's title bar
//     * @param gc     the GraphicsConfiguration of the target screen device
//     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
//     *         returns true
//     */
//    public JFrame(String title, GraphicsConfiguration gc) throws HeadlessException {
//        super(title, gc);
//        // …internal initialization (look‐and‐feel, root pane, etc.) happens here…
//        setRootPane(createRootPane());
//        // …more initialization…
//    }
//
//    // …plus various protected/private methods …
//}
