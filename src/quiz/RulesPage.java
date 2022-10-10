package quiz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.*;
  
public class RulesPage extends JFrame implements ActionListener{

	JButton previewButton, startButton;
	
	RulesPage(String userName) { 
		setBounds(250, 100, 500, 500);
		getContentPane().setBackground(new Color(246, 246, 246));
		setLayout(null);
		setResizable(false);
		
		JLabel titleLabel = new JLabel("Rules of the Java Quzies.");
		titleLabel.setBounds(80, 30, 400, 30);
		titleLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
		titleLabel.setForeground(new Color(1, 84, 134)); 
		add(titleLabel);
		
		JTextArea rulesText = new JTextArea( );
		rulesText.setBounds(10, 80, 450, 200);
		rulesText.setFont(new Font("MV Boil", Font.PLAIN, 16)); 
		rulesText.setBackground(new Color(246, 246, 246));
		rulesText.setForeground(new Color(1, 84, 134));  
		rulesText.setText( 
			"1. For this quiz, you have some knowledge about java.\n"
			+ "2. Total time to complete this quiz is 30 sec.\n"
			+ "3. Total number of qustions are 7.\n"
			+ "4. 5 marks for every Correct ans.\n\n"
			+"5.If doesn't submit in 30 sec then Score will be 0.\n"
			+ "  Next - For going to next qustions.\n\n" 
			+ "  Submit - For sumbit the quiz."
			
		);
		rulesText.setEditable(false);
		add(rulesText);
		
		JLabel noteLabel = new JLabel();
		noteLabel.setBounds(20, 300, 450, 30);
		noteLabel.setFont(new Font("Ink Free", Font.BOLD, 18));
		noteLabel.setForeground(Color.RED);
		noteLabel.setText(
				"Note:- If you do not submit it will submit after 30 sec."
				);
		add(noteLabel);
		
		JLabel nameLabel = new JLabel("Name:  " +  userName);
		nameLabel.setBounds(100, 330, 300, 30);
		nameLabel.setFont(new Font("Ink Free", Font.BOLD, 18));
		nameLabel.setForeground(new Color(1, 84, 134)); 
		add(nameLabel);
		
		previewButton = new JButton("Back");
		previewButton.setBounds(130, 400, 110, 35);
		previewButton.setHorizontalAlignment(JLabel.CENTER);
		previewButton.setFont(new Font("MV Boil", Font.BOLD, 18));
		previewButton.setBackground(new Color(1, 84, 134));
		previewButton.setForeground(new Color(255, 255, 255));
		previewButton.setFocusable(false); 
		previewButton.addActionListener(this);
		add(previewButton);
		startButton = new JButton("Start Quiz");
		startButton.setBounds(280, 400, 150, 35);
		startButton.setHorizontalAlignment(JLabel.CENTER);
		startButton.setFont(new Font("MV Boil", Font.BOLD, 18));
		startButton.setBackground(new Color(1, 84, 134));
		startButton.setForeground(new Color(255, 255, 255)); 
		startButton.setFocusable(false); 
		startButton.addActionListener(this);
		add(startButton);
		setVisible(true);
	}  
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == previewButton) {
			this.setVisible(false);
			new Quiz().setVisible(true);
		}else if(e.getSource() == startButton) {
			this.setVisible(false);
			new Ques().setVisible(true);
		}
	}
}
