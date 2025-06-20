package scene;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.*;
 
public class JavaGUIMusicPlayerJFrame extends JFrame implements ActionListener {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField filePathField;
    private JButton playButton;
    private JButton pauseButton;
    private JButton chooseButton;
    private JButton loopButton;
    private boolean isPaused;
    private boolean isLooping = false;
    private JFileChooser fileChooser;
    private Clip clip;
    private long clipTime=0;
    private double volumeControl=-6;
    private double volumeGunControl=-6;
    
    public JavaGUIMusicPlayerJFrame() 
    {
        /*super("Music Player");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        
        filePathField = new JTextField(20);
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        chooseButton = new JButton("Choose File");
        loopButton = new JButton("Loop");
        isPaused = false;
        isLooping = false;
        playSound();
        
        playButton.addActionListener(this);
        pauseButton.addActionListener(this);
        chooseButton.addActionListener(this);
        loopButton.addActionListener(this);
        
        add(filePathField);
        add(chooseButton);
        add(playButton);
        add(pauseButton);
        add(loopButton);
        
        fileChooser = new JFileChooser(".");
        fileChooser.setFileFilter(new FileNameExtensionFilter("WAV Files", "wav", "MP3 Files", "mp3"));
        
        setSize(500, 100);
        setLocationRelativeTo(null);
        setVisible(true);*/
    }
    
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(".//resources//Farmhouse.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl = 
            	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            	gainControl.setValue((float) volumeControl); // Reduce volume by 10 decibels.
            clip.setMicrosecondPosition(clipTime);
            clip.start();
        } catch(Exception 	ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    
    public void playGunshot() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(".//resources//Gunshot.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl = 
            	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            	gainControl.setValue((float) volumeGunControl); // Reduce volume by 10 decibels.
            clip.setMicrosecondPosition(clipTime);
            clip.start();
        } catch(Exception 	ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    
    public void setVolume(double volumeControl) {
    	this.volumeControl=volumeControl;
    }
    
    public void setGunVolume(double volumeControl) {
    	this.volumeGunControl=volumeControl;
    }
    
 
    @Override
    public void actionPerformed(ActionEvent event) {
        
        if (event.getSource() == playButton) 
        {
            playMusic();
        } 
        else if (event.getSource() == pauseButton) 
        {
            pauseMusic();
        } 
        else if (event.getSource() == chooseButton) 
        {
            chooseFile();
        } 
        else if (event.getSource() == loopButton) 
        {
            toggleLoop();
        }
    }
    
    public void playMusic() {
        
        if (clip != null && clip.isRunning()) 
        {
            clip.stop();
        }
        
        try 
        {
            File file = new File(filePathField.getText());
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            
            if (isLooping) 
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            
            clip.start();
 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public void pauseMusic() {
    clipTime=clip.getMicrosecondPosition();
    
        if (clip != null && clip.isRunning()) 
        {
            clip.stop();
            isPaused = true;
            //pauseButton.setText("Resume");
        } 
        else if (clip != null && isPaused) 
        {
            clip.start();
            
            if(isLooping)
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            
            isPaused = false;
            //pauseButton.setText("Pause");
        }
    }
    
    private void chooseFile() 
    {
        fileChooser.setCurrentDirectory(new File("."));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            filePathField.setText(selectedFile.getAbsolutePath());
        }
    }
    
    private void toggleLoop() 
    {
        isLooping = !isLooping;
        if (isLooping) 
        {
            loopButton.setText("Stop Loop");
            
            if(clip.isRunning())
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } 
        }
        else 
        {
            loopButton.setText("Loop");
 
            if(clip.isRunning())
            {
                clip.loop(0);
            }
        }
    }
    
    //public static void main(String[] args) {
       // new JavaGUIMusicPlayerJFrame();
    //}
}
