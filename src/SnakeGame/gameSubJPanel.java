package SnakeGame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class gameSubJPanel extends JPanel implements ActionListener{

	static final int GAMESUB_SCREEN_WIDTH=600;
	static final int GAMESUB_SCREEN_HEIGTH=600;
	
	static final int DELAYSUB = 1000;
	
	Timer timer;
	
	
	gameSubJPanel(){
		this.setSize(new Dimension(GAMESUB_SCREEN_WIDTH,GAMESUB_SCREEN_HEIGTH));
		this.setOpaque(false);
		
		counterNumber();
		
	}
	
	
	public void counterNumber() {
		
		timer = new Timer(DELAYSUB,this);
		timer.start();
		
	}
	
	
	
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		
		 Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(
	            RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setComposite(AlphaComposite.getInstance(
	            AlphaComposite.SRC_OVER, 0.5f));
	        g2d.setColor(Color.RED);
	        g2d.fillRect(100, 100, 400, 400);
	        
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
