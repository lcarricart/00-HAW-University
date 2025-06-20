package scene;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import background.Fence;

public class PauseMenu extends JPanel implements ActionListener, ChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isPaused=false;
	private Dimension size;
	private Dimension screenSize;
	private JLabel textField;
	private JLabel musicAdj;
	private JLabel musicAdj2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JPanel panel;
	private JPanel panel2;
	private JSlider jSlider;
	private JSlider jSlider2;
	private JSlider jSlider3;
	private Fence fence;
	private DrawingArea drawingArea;
	
	public PauseMenu(Dimension dimension, DrawingArea drawingArea) {
		this.drawingArea=drawingArea;
		JPanel jp=new JPanel();
		JPanel jp2= new JPanel();
		JPanel jp3= new JPanel();
		JPanel jpBack= new JPanel();
		JPanel jpSand=new JPanel();
		screenSize=TestDrawingTool.screenSize();
		fence=new Fence(new Point(screenSize.width/2-screenSize.width/8,screenSize.height/4), screenSize.width/4,5*screenSize.height/8);
		size=new Dimension(dimension);
		
		
		setLayout(null);
		setBounds(new Rectangle(new Point(0,0), screenSize));
		jpSand.setBounds(screenSize.width/2-screenSize.width/5,screenSize.height/7, 4*screenSize.width/10,4*screenSize.height/5);
		jpSand.setLayout(new BorderLayout());
		jpSand.setBackground(new Color(194, 178, 128, 255));
		jpBack.setBounds(screenSize.width/3,screenSize.height/5, screenSize.width/3,4*screenSize.height/5);
		jpBack.setLayout(new BorderLayout());
		jpBack.setBackground(new Color(34,139,34, 255));
		
		
		
		jp.setBounds(screenSize.width/2-screenSize.width/14,screenSize.height/2+2*screenSize.height/40+50, screenSize.width/7,screenSize.height/15);
		jp.setLayout(new BorderLayout());
		jp2.setBounds(screenSize.width/2-screenSize.width/14,screenSize.height/2+2*screenSize.height/40+50+screenSize.height/12, screenSize.width/7,screenSize.height/15);
		jp2.setLayout(new BorderLayout());
		jp3.setBounds(screenSize.width/2-screenSize.width/14,screenSize.height/2+2*screenSize.height/40+50+screenSize.height/6, screenSize.width/7,screenSize.height/15);
		jp3.setLayout(new BorderLayout());
		setBackground(new Color( 34, 88, 203,255));
		
		
		textField= new JLabel("Pause");
		textField.setForeground(Color.black);
		textField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
		button1=defineButton("Resume");
		button2=defineButton("Flip Time");
		button3=defineButton("Exit Game");
		jSlider=defineSlider(" Music Volume", jp);
		jSlider2=defineSlider(" Game Volume", jp2);
		jSlider3=defineSlider(" Gun Volume", jp3);
		textField.setBounds(new Rectangle(new Point(screenSize.width/2-screenSize.width/20,screenSize.height/3), new Dimension(screenSize.width/5,screenSize.height/20)));
		button1.setBounds(new Rectangle(new Point(screenSize.width/2-screenSize.width/30,screenSize.height/2-2*screenSize.height/40), new Dimension(screenSize.width/15,screenSize.height/30)));
		button2.setBounds(new Rectangle(new Point(screenSize.width/2-screenSize.width/30,screenSize.height/2), new Dimension(screenSize.width/15,screenSize.height/30)));
		button3.setBounds(new Rectangle(new Point(screenSize.width/2-screenSize.width/30,screenSize.height/2+2*screenSize.height/40), new Dimension(screenSize.width/15,screenSize.height/30)));
		
		add(textField);
		add(button1);
		add(button2);
		add(button3);
		add(jp);
		add(jp2);
		add(jp3);
        setVisible(false);
	}
	
	public void switchPause() {
		if(!isPaused) {
			fence.drawAt();
			draw();
			System.out.println("Pause: " + isPaused);
		}
		isPaused=!isPaused;
		setVisible(isPaused);
		fence.drawAt();
		System.out.println("Pause: " + isPaused);
	}
	
	public void draw() {
		Drawing.pen().setColor(new Color(192, 192, 192, 220));
		Drawing.pen().fillRect(0, 0, size.width, size.height);
	}
	
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		Drawing.set(pen);
		Drawing.pen().setColor(new Color(194, 178, 128, 255));
		Drawing.pen().fillRect(screenSize.width/2-screenSize.width/3,screenSize.height/7, 2*screenSize.width/3,4*screenSize.height/5);
		Drawing.pen().setColor(new Color(34,139,34, 255));
		Drawing.pen().fillRect(screenSize.width/2-screenSize.width/3+100,screenSize.height/5, 2*(screenSize.width/3)-200,4*screenSize.height/5);
		Drawing.pen().setColor(new Color(205,133,63,255));
		Drawing.pen().fillRect(screenSize.width/2-screenSize.width/8,screenSize.height/4+50, screenSize.width/4,5*screenSize.height/8);
		fence.drawAt(5,10);
	}
	
	private JButton defineButton(String title) {
		JButton button = new JButton(title);
		button.addActionListener(this);
		return button;
	}
	
	private JSlider defineSlider(String title, JPanel jp) {
		JSlider slider = new JSlider(0, 100);
		JLabel label = new JLabel(title);
		//label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
		slider.addChangeListener(this);
		slider.setMajorTickSpacing(25);
	    slider.setMinorTickSpacing(25);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);
		jp.add(slider, BorderLayout.SOUTH);
		jp.add(label, BorderLayout.NORTH);
		return slider;
	}
	
	public void stateChanged(ChangeEvent e) {
		
	    JSlider source = (JSlider)e.getSource();
	    if (!source.getValueIsAdjusting()) {
	        	
	        } else {
	        	if(jSlider==(JSlider)e.getSource())
	        		drawingArea.setMusicVolume((int)source.getValue());
	        	if(jSlider3==(JSlider)e.getSource())
	            	drawingArea.setGunVolume((int)source.getValue());
	        }
	    }
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1){
			System.out.println("Resume button");
			drawingArea.play();
		}
		else if(e.getSource()==button2) {
			drawingArea.flipDayNight();
		}
		else if(e.getSource()==button3) {
			System.out.println("Game closed");
			TestDrawingTool.exit();
		}
		else if(e.getSource()==button4) {
			System.out.println("Button 4 has been pushed");
		}
	}
}
