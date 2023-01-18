package SnakeGame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TranscriptJPanel extends JPanel{

	
	static final int SCREEN_WIDTH =600;
	static final int SCREEN_HEIGTH=100;
	
	JLayeredPane layPane = new JLayeredPane();
	
	
	
	
	 TranscriptJPanel() {
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGTH);
		this.setBounds(0, 0, SCREEN_WIDTH,SCREEN_HEIGTH);
		this.setBackground(Color.WHITE);
		
		layPane.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGTH));
		layPane.setBackground(Color.DARK_GRAY);
		
		
		this.add(layPane);
		
		JLabel lbScore= new JLabel("SCORE:");
		lbScore.setOpaque(true);
		lbScore.setBackground(Color.red);
		lbScore.setBounds(0, 0, SCREEN_WIDTH/2, SCREEN_HEIGTH);
		lbScore.setHorizontalAlignment(SwingConstants.CENTER);
		lbScore.setVerticalAlignment(SwingConstants.CENTER);
		layPane.add(lbScore);
		
		
		
		
		
		
	}
}
