package SnakeGame;


import static SnakeGame.SystemConfig.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class TranscriptJPanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH =600;
	static final int SCREEN_HEIGTH=100;
	
	
	int SCORE=bodyParts;
	
	Timer timer;
	
	JLayeredPane layPane = new JLayeredPane();
	
	JLabel lbScore= new JLabel();
	
	
	
	 TranscriptJPanel() {
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGTH);
		this.setBounds(0, 0, SCREEN_WIDTH,SCREEN_HEIGTH);
		this.setBackground(Color.WHITE);
		
		layPane.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGTH));
		layPane.setBackground(Color.DARK_GRAY);
		
		
		this.add(layPane);
		
		
		lbScore.setOpaque(true);
		lbScore.setBackground(Color.red);
		lbScore.setBounds(0, 0, SCREEN_WIDTH/2, SCREEN_HEIGTH);
		lbScore.setHorizontalAlignment(SwingConstants.CENTER);
		lbScore.setVerticalAlignment(SwingConstants.CENTER);
		layPane.add(lbScore);
		
		StartScore();
		
		
		
	}
	 
	 public void StartScore() {
			// what the fuck this line
			timer = new Timer(DELAY,this);
			timer.start();
		}

	 public void Update() {
		 
		 SCORE = bodyParts-3;
		 lbScore.setText("SCORE:"+SCORE);

		 
		 
	 }
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			Update();
	}
}
