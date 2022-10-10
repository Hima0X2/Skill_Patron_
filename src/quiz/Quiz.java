package quiz;

import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {


	JButton startButton, exitButton;
	static JTextField nameTextField;
	
	Quiz() {
		setBounds(200, 100, 790, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(246, 246, 246));
		setLayout(null); 
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/image.jpg"));
		
		JLabel iconLabel = new JLabel(icon);
		iconLabel.setBounds(0, 0, 320, 450);
		add(iconLabel);
		
		JLabel titleLabel = new JLabel("Java Quzies");
		titleLabel.setBounds(280, 40, 300, 50);
		titleLabel.setFont(new Font("Ink Free", Font.BOLD, 35));
		titleLabel.setForeground(new Color(1, 84, 134));
		add(titleLabel);
		
		JTextArea descLabel = new JTextArea(1, 3); 
		descLabel.setText( 
			 "Hello!!, we are Java Quzies App. We are to\n"
			 + "test your knowledge."
			 + "\nWe will happy to have you here." 
				);
		descLabel.setBounds(380, 130, 400, 80);
		descLabel.setFont(new Font("MV Boil", Font.PLAIN, 16));
		descLabel.setForeground(new Color(1, 84, 134));
		descLabel.setBackground(new Color(246, 246, 246));
		descLabel.setEditable(false);
		add(descLabel);

		JLabel nameLabel = new JLabel("Enter your name ");
		nameLabel.setBounds(380, 240, 300, 18);
		nameLabel.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		nameLabel.setForeground(new Color(1, 84, 134));
		add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(380, 270, 250, 30);
		nameTextField.setFont(new Font("Viner Hand ITC", Font.PLAIN, 16));
		nameTextField.setForeground(new Color(1, 84, 134));
		nameTextField.setBackground(new Color(246, 246, 246));
		add(nameTextField);
	
		startButton = new JButton("Start");
		startButton.setBounds(380, 350, 100, 35);
		startButton.setHorizontalAlignment(JLabel.CENTER);
		startButton.setFont(new Font("MV Boil", Font.BOLD, 18));
		startButton.setBackground(new Color(1, 84, 134));
		startButton.setForeground(new Color(255, 255, 255));
		startButton.setFocusable(false); 
		startButton.addActionListener(this);
		add(startButton);

		exitButton = new JButton("Exit");
		exitButton.setBounds(600, 350, 100, 35);
		exitButton.setHorizontalAlignment(JLabel.CENTER);
		exitButton.setFont(new Font("MV Boil", Font.BOLD, 18));
		exitButton.setBackground(new Color(1, 84, 134));
		exitButton.setForeground(new Color(255, 255, 255));
		exitButton.setFocusable(false);
		exitButton.addActionListener(this);
		add(exitButton);
		
		setResizable(false); 
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			String name = nameTextField.getText();
			this.setVisible(false);
			new RulesPage(name);
		}if(e.getSource() == exitButton) {
			System.exit(0);
		}	
	}
	public static void main(String[] args) { 
		new Quiz();
	}

}
