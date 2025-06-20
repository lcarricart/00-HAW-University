package scene;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JTextField textField;
	private JButton expectedButton;
	
	public ButtonPanel() {
		setLayout(new BorderLayout(100, 50));
		
		textField= new JTextField("Next Button to be pushed: 3");
		add(textField, BorderLayout.WEST);
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1,1, 5, 10));
		add(jp, BorderLayout.SOUTH);
		
		
		button1=defineButton("1", jp);
		button2=defineButton("2", jp);
		button3=defineButton("3", jp);
		button4=defineButton("4", jp);
		expectedButton=null;
		InstructionUser();
		
		/*button1 = new JButton("1");
		button1.addActionListener(this);
		jp.add(button1);
		
		button2 = new JButton("2");
		button2.addActionListener(this);
		jp.add(button2);
		
		button3 = new JButton("3");
		button3.addActionListener(this);
		jp.add(button3);
		
		button4 = new JButton("4");
		button4.addActionListener(this);
		jp.add(button4);
		
		/*button1 = new JButton("1");
		add(button1, BorderLayout.CENTER);
		
		button2 = new JButton("2");
		add(button2, BorderLayout.CENTER);*/
		
		/*for(int i=0; i<4; i++) {
			button3 = new JButton(Integer.toString(i));
			add(button3, BorderLayout.CENTER);
		}
		
		button3 = new JButton("3");
		button4 = new JButton("4");*/
	}

	private void InstructionUser() {
		int i=randNumberBetween(1,4);
		textField.setText("Push button " + i);
		switch(i) {
		case 1: expectedButton = button1; break;
		case 2: expectedButton = button2; break;
		case 3: expectedButton = button3; break;
		case 4: expectedButton = button4; break;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action performed!!");
		if(e.getSource()==button1){
			//System.out.println("Button 1 has been pushed");
			verifyPushButton(button1);
		}
		else if(e.getSource()==button2) {
			//System.out.println("Button 2 has been pushed");
			verifyPushButton(button2);
		}
		else if(e.getSource()==button3) {
			//System.out.println("Button 3 has been pushed");
			verifyPushButton(button3);
		}
		else if(e.getSource()==button4) {
			//System.out.println("Button 4 has been pushed");
			verifyPushButton(button4);
		}
	}
	
	private void verifyPushButton(JButton pushedButton) {
		if(pushedButton==expectedButton) {
			InstructionUser();
		}
		else {
			System.out.println("GAME OVER");
			System.exit(0);
		}
	}
	
	private JButton defineButton(String title, JPanel jp) {
		JButton button = new JButton(title);
		button.addActionListener(this);
		jp.add(button);
		return button;
	}
	
	private int randNumberBetween(int min, int max) {
		return (int) (Math.random()*((max-min)+1)+min);
	}
}
