package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WelcomeMenuJFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private MainWelcomeJFrame parentFrame;
    private WelcomeMenuJPanel welcMenuPanel;
    private Clip clip;
    private int clipTime = 0;
    private double volumeControl = -6;

    public WelcomeMenuJFrame(MainWelcomeJFrame parentFrame, int menuW, int menuH) {
        super("Welcome Menu");
        this.parentFrame = parentFrame;

        initialization(menuW, menuH);
        playSound();
    }

    private void initialization(int menuW, int menuH) {
        setSize(new Dimension(menuW, menuH));
        setLocationRelativeTo(parentFrame); // centre over background
        
        welcMenuPanel = new WelcomeMenuJPanel(parentFrame);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(welcMenuPanel, BorderLayout.CENTER);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); // do not kill JVM if closed manually
        setVisible(true);
    }
    
    private void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(".//music//gameSong2.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue((float) volumeControl); // Reduce volume by 10 decibels.
            clip.setMicrosecondPosition(clipTime);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch(Exception 	ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}