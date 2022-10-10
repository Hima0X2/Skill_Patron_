package quiz;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class Ques extends JFrame implements ActionListener {	
	JButton submitButton, clearButton, nextButton,showButton;
	ButtonGroup options;
	JRadioButton ans1, ans2, ans3, ans4;
	public static int count = 0;
	public static int time = 0; 
	public static int score = 0; 
	JLabel qLists1, qno;
	String q[][] = new String[10][10];
	String ansList[][] = new String[7][1];
	String qAns[][] = new String[10][2];
	private Label label;
	boolean ok=true;
	Ques() {
		setBounds(250, 50, 900, 600);
		getContentPane().setBackground(new Color(246, 246, 246));
		setLayout(null);
		setResizable(false);
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/image.jpg"));
		JLabel iconLabel = new JLabel(icon);
		iconLabel.setBounds(80, 10, 200, 200);
		add(iconLabel);
		JLabel nameLabel = new JLabel("Total Time:-  30 sec");
		nameLabel.setBounds(500, 40, 300, 50);
		nameLabel.setFont(new Font("MV Boil", Font.BOLD, 18));
		nameLabel.setForeground(new Color(1, 84, 134));
		add(nameLabel); 
		qno = new JLabel("");
		qno.setBounds(100, 250, 20, 15);
		qno.setFont(new Font("MV Boil", Font.BOLD, 16));
		qno.setForeground(new Color(1, 84, 134));
		add(qno);
		
		qLists1 = new JLabel("");
		qLists1.setBounds(150, 250, 600, 20);
		qLists1.setFont(new Font("MV Boil", Font.BOLD, 16));
		qLists1.setForeground(new Color(1, 84, 134));
		add(qLists1);
		
	 	q[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";
	
        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";
	
        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";
	
        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";
	
	    q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
	    q[4][1] = "Stack";
	    q[4][2] = "String memory";
	    q[4][3] = "Random storage space";
	    q[4][4] = "Heap memory";
	    
	    q[5][0] = "What is the 16-bit compiler allowable range for integer constants?";
	    q[5][1] = "-3.4e38 to 3.4e38";
	    q[5][2] = "-32767 to 32768";
	    q[5][3] = "-32668 to 32667";
	    q[5][4] = "-32768 to 32767";
	 
	    q[6][0] = "main()  \n"
	    		+ "{printf(\"Coder\");  \n"
	    		+ "main();}  \n"
	    		+ "What will be the output of this program?";
	    q[6][1] = "Wrong statement";
	    q[6][2] = "It will keep on printing Coder";
	    q[6][3] = "It will Print Coder once";
	    q[6][4] = "None of the these";
	    
	//ans
        qAns[0][1] = "JDB";
        qAns[1][1] = "int";
        qAns[2][1] = "java.util package";
        qAns[3][1] = "Marker Interface";
        qAns[4][1] = "Heap memory"; 
        qAns[5][1]="-32768 to 32767";
        qAns[6][1]="It will keep on printing Coder";
        
		ans1 = new JRadioButton("");
		ans1.setBounds(160, 300, 400, 30);
		ans1.setFont(new Font("MV Boil", Font.PLAIN, 16));
		ans1.setForeground(new Color(1, 84, 134));
		ans1.setBackground(new Color(246, 246, 246)); 
		ans1.setFocusable(false); 
		add(ans1);

		ans2 = new JRadioButton("");
		ans2.setBounds(160, 330, 400, 30);
		ans2.setFont(new Font("MV Boil", Font.PLAIN, 16));
		ans2.setBackground(new Color(246, 246, 246));
		ans2.setForeground(new Color(1, 84, 134));
		ans2.setFocusable(false); 
		add(ans2);

		ans3 = new JRadioButton("");
		ans3.setBounds(160, 360, 400, 30);
		ans3.setFont(new Font("MV Boil", Font.PLAIN, 16));
		ans3.setBackground(new Color(246, 246, 246));
		ans3.setForeground(new Color(1, 84, 134));
		ans3.setFocusable(false); 
		add(ans3);

		ans4 = new JRadioButton("");
		ans4.setBounds(160, 390, 400, 30);
		ans4.setFont(new Font("MV Boil", Font.PLAIN, 16));
		ans4.setBackground(new Color(246, 246, 246));
		ans4.setForeground(new Color(1, 84, 134));
		ans4.setFocusable(false);  
		add(ans4);
		
		options = new ButtonGroup();
		options.add(ans1);
		options.add(ans2);
		options.add(ans3);
		options.add(ans4);
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(100, 480, 110, 35);
		clearButton.setHorizontalAlignment(JLabel.CENTER);
		clearButton.setFont(new Font("MV Boil", Font.BOLD, 18));
		clearButton.setBackground(new Color(1, 84, 134));
		clearButton.setForeground(new Color(255, 255, 255)); 
		clearButton.setFocusable(false); 
		clearButton.addActionListener(this);
		add(clearButton);
		
		nextButton = new JButton("Next");
		nextButton.setBounds(550, 480, 110, 35);
		nextButton.setHorizontalAlignment(JLabel.CENTER);
		nextButton.setFont(new Font("MV Boil", Font.BOLD, 18));
		nextButton.setBackground(new Color(1, 84, 134));
		nextButton.setForeground(new Color(255, 255, 255)); 
		nextButton.setFocusable(false); 
		nextButton.addActionListener(this);
		add(nextButton);

		submitButton = new JButton("Submit");
		submitButton.setBounds(700, 480, 110, 35);
		submitButton.setHorizontalAlignment(JLabel.CENTER);
		submitButton.setFont(new Font("MV Boil", Font.BOLD, 18));
		submitButton.setBackground(new Color(1, 84, 134));
		submitButton.setForeground(new Color(255, 255, 255)); 
		submitButton.setFocusable(false); 
		submitButton.addActionListener(this);
		add(submitButton);
		start(0);
		
		showButton=new JButton("Show Answer");
		showButton.setBounds(450, 430, 150, 35);
		showButton.setHorizontalAlignment(JLabel.CENTER);
		showButton.setFont(new Font("MV Boil", Font.BOLD, 16));
		showButton.setBackground(new Color(1, 84, 134));
		showButton.setForeground(new Color(255, 255, 255)); 
		showButton.setFocusable(false); 
		add(showButton);
		showButton.addActionListener(this);
		label=new Label();
		label.setBounds(630, 430, 200, 35);
		label.setForeground(new Color(1, 84, 134)); 
		label.setFont(new Font("MV Boil", Font.BOLD, 16));
		add(label);
		setVisible(true);
	}
	public void start(int count) {
		qno.setText("" + (count + 1) + ". ");
		qLists1.setText(q[count][0]);
		ans1.setText(q[count][1]);
		ans1.setActionCommand(q[count][1]);
		ans2.setText(q[count][2]);
		ans2.setActionCommand(q[count][2]);
		ans3.setText(q[count][3]);
		ans3.setActionCommand(q[count][3]);
		ans4.setText(q[count][4]);
		ans4.setActionCommand(q[count][4]);
		options.clearSelection();
		
	}
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource() == nextButton) {
			label.setText("");
			showButton.setText("Show Answer");
			ok=true;
			repaint();
			if(options.getSelection() == null) {
				ansList[count][0] ="";
			}else {
				ansList[count][0] = options.getSelection().getActionCommand();
			}
			count++;
			start(count);
		}else if(e.getSource() == clearButton) { 
			options.clearSelection();
		}
		//System.out.println(qAns[count][1]);
		if(e.getSource()==showButton&&ok==true) {
			label.setText(qAns[count][1]);
			showButton.setText("Hide Answer");
			ok=false;
		}
		else if(e.getSource()==showButton&&ok==false) {
			label.setText("");
			showButton.setText("Show Answer");
			ok=true;
		}
		if(e.getSource() == submitButton) { 
			if(options.getSelection() == null) {
				ansList[count][0] ="";
			}else {
				ansList[count][0] = options.getSelection().getActionCommand();
			} 
			for(int i=0; i<ansList.length; i++) {
				if(ansList[i][0].equals(qAns[i][1])) {
					score += 5;
				}
			} 
        	this.setVisible(false);  
        	new ScoreBoard(score);
        	count = 0;
			} 
	}
	
	public void paint(Graphics g){
        super.paint(g); 
        String t = "Total Time Left:- " + time; 
		g.setFont(new Font("MV Boil", Font.BOLD, 18));
		g.setColor(Color.RED);
        g.drawString(t, 506, 150);
        time++;
        try {
        	Thread.sleep(1010);
        	repaint();
        }catch(Exception e) {}
        
        if(time ==  30 ) {
        	this.setVisible(false);
        	new ScoreBoard(score).setVisible(true);  
        	time = 0; 
        	start(0);
		}  

        if(count == 6) { 
			nextButton.setEnabled(false);
			submitButton.setEnabled(true);
		}else if(count != 6) {  
			submitButton.setEnabled(false);
		}
        
	}
	public static void main(String[] args) {
		new Ques();
	}  
}
