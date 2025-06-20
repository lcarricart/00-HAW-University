package scene;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import background.LocatedRectangle;
import chick.Chick;
import cow.SceneCow;
import farmer.Farmer;
import graphicState.State;
import graphicState.TimeRunningState;
import graphicState.TimeStopState;

public class DrawingArea extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private static final int NIGHT=200;
	private static final int DAY=10;
	private static final int HOUR=10;
	private static final int TIMETICK=120;
	private static final int fps=16;
	
	private boolean isGettingDark=true;
	private boolean firstMoment=true;
	private boolean keyPressed=false;
	private boolean isTimeRunning=true;
	private int counter=0;
	private int darkness=0;
	private int sceneIndex=12;
	
	private Scene scene;
	private SceneSec sceneEast;
	private SceneSec sceneSouth;
	private SceneSec sceneSouthEast;
	private SceneCow sceneCow;
	private SceneGenerator sceneGenerator;
	private PauseMenu pauseMenu;
	private Farmer farmer;
	private JLabel timer;
	private JavaGUIMusicPlayerJFrame audioMusicPlayer;
	private JavaGUIMusicPlayerJFrame audioGunPlayer;
	private Point lastKey=new Point(-1,0);
	private ArrayList<Scenes> scenes = new ArrayList<Scenes>();
	private static State graphicState;
	
	public DrawingArea() {
		farmer= new Farmer(new Point(1100, 400), 150, 150, 0, scenes);
		sceneGenerator= new SceneGenerator(farmer);
		setLayout(null);
		setFocusable(true);
		addKeyListener(this);
		timer=new JLabel("Time: " + counter);
		timer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		timer.setBounds(10,0,100,50);
		pauseMenu=new PauseMenu(TestDrawingTool.screenSize(), this);
		audioMusicPlayer=new JavaGUIMusicPlayerJFrame();
		audioGunPlayer=new JavaGUIMusicPlayerJFrame(); 
		audioMusicPlayer.playSound();
		add(timer);
		add(pauseMenu);
		addScenes();
		graphicState=TimeRunningState.getInstance(this);
	}

	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		Drawing.set(pen);
		
		if(firstMoment) {
			firstMoment=false;
		}
		else
		{
			daylight();
			
			sceneIndex=scenes.get(sceneIndex).sceneManager(sceneIndex, scenes);
			scenes.get(sceneIndex).setIndex(sceneIndex);
			scenes.get(sceneIndex).draw(lastKey, darkness);
			if(counter%60==0) {
				defineTimer(counter);
			}
			counter++;
		}
		if(graphicState==TimeRunningState.getInstance(this)) {
			try {
				Thread.sleep(fps);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
	
	private void addScenes() {
		for(Scenes s: sceneGenerator.generate()) {
			scenes.add(s);
		}
	}
	
	public void daylight() {
		if(darkness>NIGHT)
			isGettingDark=false;
		else if(darkness<DAY)
			isGettingDark=true;
		
		if(counter%TIMETICK==0&&isGettingDark) {
			darkness+=HOUR;
		}
		else if(counter%TIMETICK==0&&!isGettingDark) {
			darkness-=HOUR;
		}
	}
	
	public void flipDayNight(){
		if(!isGettingDark||darkness>NIGHT-NIGHT/4)
			darkness=0;
		else
			darkness=NIGHT;
		isGettingDark=!isGettingDark;
	}
	
	public void defineTimer(int counter) {
		this.remove(timer);
		timer= new JLabel("Time: " + counter/60);
		timer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		timer.setBounds(10,0,100,50);
		add(timer);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		keyPressed=true;
		int key = e.getKeyCode();
		
		if(graphicState==TimeRunningState.getInstance(this)) {
			farmer.setKey(key);
		}
				
		if(key==KeyEvent.VK_SPACE)
			if(graphicState==TimeRunningState.getInstance(this)) {
	            scenes.get(sceneIndex).addBullet(lastKey);
	            audioGunPlayer.playGunshot();
	        }
		
	    if(key==KeyEvent.VK_ESCAPE)
	         if(graphicState==TimeRunningState.getInstance(this)) {
	        	setTimeStop();
	         }
	         else if(graphicState==TimeStopState.getInstance(this))
	         {
	            setTimeRunning();
	     }
	    lastKey=Direction.keyToPoint(key, lastKey);
	}  
	
	public void keyReleased(KeyEvent e) {
		keyPressed=false;
		farmer.setKey(0);
	}
	
	public void pause() {
		isTimeRunning=false;
		pauseMenu.switchPause();
		audioMusicPlayer.pauseMusic();
	}
	
	public void play() {
		isTimeRunning=true;
		pauseMenu.switchPause();
		audioMusicPlayer.playSound();
		repaint();
	}
	
    public void setTimeStop() {
   	 graphicState = graphicState.timeStopped();
   }
    
    public void setTimeRunning() {
   	 graphicState = graphicState.timeFlows();
   }
	
	public void setMusicVolume(int control) {
		double volumeControl;
		volumeControl=10*Math.log(((double)control/100)); //20 * np.log10((value + 1) / 1
		audioMusicPlayer.setVolume(volumeControl);
	}
	
	public void setGunVolume(int control) {
		double volumeControl;
		volumeControl=10*Math.log(((double)control/100)); //20 * np.log10((value + 1) / 1
		audioGunPlayer.setGunVolume(volumeControl);
	}
	
	public int returnLowest(int x, int y) {
		if (x>y)
			return y;
		else
			return x;
	}	
}