package SnakeGame;

import static SnakeGame.SystemConfig.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.lang.Cloneable; 

public class GameJPanel extends JPanel implements ActionListener{
	
    
	Random random;
	
	Game SnakeGameIn = new Game();
	MapGame MapGameIn = new MapGame();
    Snake SnakeAction = new Snake();
    
    JLabel timeLabel = new JLabel();
    
    int a = 3;
    
	public GameJPanel() {
		
		random = new Random();
		
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGTH);
		this.setFocusable(true);
		this.setBackground(Color.black);
		this.addKeyListener(new MyKeyAdapter());
		
		
		//Set the functions in game
		SnakeGameIn.SetGame();
		//Start the Game
		SnakeGameIn.StartGame(this);
		
		
		
	}
	
	
	// TODO Auto-run used to Draw map
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Timer newtimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		g.setColor(Color.BLUE);
		g.setFont(new Font("Ink Free",Font.BOLD,75));
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		
		g.drawString(""+String.valueOf(a), (100 - metrics.stringWidth(""+String.valueOf(a))), SCREEN_HEIGTH/2);
		
		a--;
		}});
		
		newtimer.start();		
		
		SnakeGameIn.timeCount(g);
		
		//Draw Map and GameOver
		if(running) {
		MapGameIn.SetMap(g);
		}
		else if(running == false && k==0) MapGameIn.GameOverDraw(g);
		
		}
	

	//Console PlayGAME
	public class MyKeyAdapter extends KeyAdapter{
		 @Override
		 public void keyPressed(KeyEvent e) {
			 
			 switch(e.getKeyCode()) {
			 case KeyEvent.VK_LEFT:
				 if(direction != 'R')
					 direction ='L';
				 break;
			 case KeyEvent.VK_RIGHT:
				 if(direction != 'L')
					 direction ='R';
				 break;
			 case KeyEvent.VK_UP:
				 if(direction != 'D')
					 direction ='U';
				 break;
			 case KeyEvent.VK_DOWN:
				 if(direction != 'U') 
					 direction ='D';
				 break;
				 
			 }
			 
		 }
		 
	}

	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(running) {
			SnakeAction.move();
			SnakeGameIn.appleCheck();
			MapGameIn.frenceCheck();
			repaint();
		}
	
	
	}
}
