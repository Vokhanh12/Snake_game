package SnakeGame;

import java.util.ArrayList;
import java.util.Collections;

import static SnakeGame.SystemConfig.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class TranscriptJPanel extends JPanel implements ActionListener{

	static final int TRANSCRIPT_SCREEN_WIDTH =600;
	static final int TRANSCRIPT_SCREEN_HEIGTH=100;
	
	
	int SCORE=bodyParts;
	
	Timer timer;
	
	JLayeredPane layPane = new JLayeredPane();
	
	JLabel lbScore= new JLabel();
	JLabel maxScore = new JLabel();
	
	
	 TranscriptJPanel() {
		 
		this.setSize(TRANSCRIPT_SCREEN_WIDTH, TRANSCRIPT_SCREEN_HEIGTH);
		this.setBounds(0, 0, TRANSCRIPT_SCREEN_WIDTH,TRANSCRIPT_SCREEN_HEIGTH);
		this.setBackground(Color.WHITE);
		
		layPane.setPreferredSize(new Dimension(TRANSCRIPT_SCREEN_WIDTH,TRANSCRIPT_SCREEN_HEIGTH));
		layPane.setBackground(Color.DARK_GRAY);
		
		
		this.add(layPane);
		
		
		lbScore.setOpaque(true);
		lbScore.setBackground(Color.BLACK);
		lbScore.setBounds(0, 0, TRANSCRIPT_SCREEN_WIDTH/2, TRANSCRIPT_SCREEN_HEIGTH);
		lbScore.setHorizontalAlignment(SwingConstants.CENTER);
		lbScore.setVerticalAlignment(SwingConstants.CENTER);
		lbScore.setForeground(Color.WHITE);
		layPane.add(lbScore);
		
		maxScore.setOpaque(true);
		maxScore.setBackground(Color.BLUE);
		maxScore.setBounds(SCREEN_WIDTH/2, 0,TRANSCRIPT_SCREEN_WIDTH/2, TRANSCRIPT_SCREEN_HEIGTH);
		maxScore.setHorizontalAlignment(SwingConstants.CENTER);
		maxScore.setVerticalAlignment(SwingConstants.CENTER);
		maxScore.setForeground(Color.WHITE);
		
		maxScore.setText("MAX SCORE:"+(char)Integer.parseInt(scoreFindMax()));
		layPane.add(maxScore);
		
		StartScore();
		
		
		
	}
	 
	 public String scoreFindMax() {
		 
		 int scoreMax=0;
		 
		 ArrayList<String> ScoreSnake = new ArrayList<String>();
		 
		 try(FileInputStream fileStream = new FileInputStream(fileScore)){
			 
			 InputStreamReader reader = new InputStreamReader(fileStream);
			 
			 int Character;
			 while((Character = reader.read()) != -1) {
				 ScoreSnake.add(String.valueOf(Character));
			 }
			 
			 Collections.sort(ScoreSnake);
			 
		 }
		 catch(Exception ex) {
			 
		 }
		 return ScoreSnake.get(ScoreSnake.size()-1);
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
