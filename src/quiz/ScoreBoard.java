package quiz;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.*;

public class ScoreBoard extends JFrame implements ActionListener{

	JButton cancel, play, show,high;
	int max,num;
	String name,winner,compare;
	public ScoreBoard(int scores) { 
		setBounds(250, 50, 700, 600);
		getContentPane().setBackground(new Color(246, 246, 246));
		setLayout(null);
		setResizable(false);
		 
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/image.jpg"));
		JLabel iconLabel = new JLabel(icon);
		iconLabel.setBounds(80, 150, 200, 200);
		add(iconLabel);
	
		JLabel titleLabel = new JLabel("Java Quiz ");
		titleLabel.setBounds(280, 40, 400, 30);
		titleLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
		titleLabel.setForeground(new Color(1, 84, 134)); 
		add(titleLabel);
		
		JLabel label=new JLabel(Quiz.nameTextField.getText());
		label.setBounds(350, 150,400, 30);
		label.setFont(new Font("MV Boil", Font.BOLD, 24));
		label.setForeground(new Color(1, 84, 134));
		add(label);
		
		String name=Quiz.nameTextField.getText();
		
		JLabel score = new JLabel("Your score is " + scores);
		score.setBounds(350, 250, 400, 30);
		score.setFont(new Font("MV Boil", Font.BOLD, 24));
		score.setForeground(new Color(1, 84, 134)); 
		add(score);
		try {
			FileWriter fw = new FileWriter("file.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(name+'\t'+scores+'\n');
			bw.close();
			
			FileWriter fw1 = new FileWriter("num.txt", true);
			BufferedWriter bw1 = new BufferedWriter(fw1);
			bw1.append(String.valueOf(scores)+'\n');
			bw1.close();
			
			FileWriter fw3 = new FileWriter("name.txt", true);
			BufferedWriter bw3 = new BufferedWriter(fw3);
			bw3.append(name+'\n');
			bw3.close();
			
		} catch (Exception e) {
		}
		high = new JButton("High Score");
		high.setBounds(350, 350, 300, 30);
		high.setForeground(new Color(246, 246, 246));
		high.setBackground(new Color(1, 84, 134));
		high.setFont(new Font("MV Boil", Font.BOLD, 18));
		high.addActionListener(this);
		add(high);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(530, 450, 100, 40);
		cancel.setForeground(new Color(246, 246, 246));
		cancel.setBackground(new Color(1, 84, 134));
		cancel.setFont(new Font("MV Boil", Font.BOLD, 18));
		cancel.addActionListener(this);
		cancel.setFocusable(false);
		add(cancel);
		
		play = new JButton("Play Again");
		play.setBounds(40, 450, 165, 40);
		play.setForeground(new Color(246, 246, 246));
		play.setBackground(new Color(1, 84, 134));
		play.setFont(new Font("MV Boil", Font.BOLD, 18));
		play.addActionListener(this);
		play.setFocusable(false);
		add(play);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) { 
		if(e.getSource() == cancel) {
			System.exit(0);
		}else if(e.getSource() == play) {
			this.setVisible(false);
			new Quiz().setVisible(true);
		}
		else if(e.getSource() == high) {
			try {
				 Scanner fileScanner = new Scanner(new File("num.txt"));
				 Scanner fileScannername = new Scanner(new File("name.txt"));
			         max = fileScanner.nextInt();
			         winner=fileScannername.nextLine();
			        while (fileScanner.hasNextInt()) {
			             num = fileScanner.nextInt();
			             name= fileScannername.nextLine();
			            if (num > max) {
			                max=num;
			                winner=name;
			            }
			        }
				high.setText(winner+" = "+max);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
