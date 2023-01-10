package SnakeGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class GameJPanel extends JPanel implements ActionListener{
	
	static final int FRISTSCREEN_X=0;
	static final int FRISTSCREEN_Y=0;
	static final int SCREEN_HEIGTH = 600;
	static final int SCREEN_WIDTH = 600;
	static final int UNIT_SIZE=50;
	static final int GAME_UNITS=(SCREEN_HEIGTH*SCREEN_WIDTH)/UNIT_SIZE;
	static final int DELAY=100;
	
	final int X[]=new int [GAME_UNITS];
	final int Y[]=new int [GAME_UNITS];
	
	int bodyParts =6;
	
	int appleEaten;
	int appleX,appleY;
	
	char direction = 'R';
	
    boolean running = false;
	
	Timer timer;
	Random random;
	
	
    
    
	public GameJPanel() {
		
		random = new Random();
		
		this.setPreferredSize(new Dimension(SCREEN_HEIGTH,SCREEN_WIDTH));
		this.setFocusable(true);
		this.setBackground(Color.black);
		this.addKeyListener(new MyKeyAdapter());
		
		
		SetGame();
		StartGame();
		
		
	}
	
	
	public void SetGame() {
		X[0] = UNIT_SIZE * 2;
		Y[0] = UNIT_SIZE * 2;
	}
	
	public void StartGame() {
		newApple();
		running =true;
		// what the fuck this line
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	public void StopGame(Graphics g) {
		
	}
	
	public void move() {
		
		for(int i = bodyParts-1;i>0;i--) {
			X[i]=X[i-1];
			Y[i]=Y[i-1];
		}
		
		switch(direction) {
		case 'U':
			Y[0]=Y[0]-UNIT_SIZE;
			break;
		case 'D':
			Y[0]=Y[0]+UNIT_SIZE;
			break;
		case 'L':
			X[0]=X[0]-UNIT_SIZE;
			break;
		case 'R':
			X[0]=X[0]+UNIT_SIZE;
			break;
		}
		
	}
	
	public void newApple() {
		appleX=(random.nextInt((int)((SCREEN_WIDTH-UNIT_SIZE*2)/UNIT_SIZE))+1)*UNIT_SIZE; 
		appleY=(random.nextInt((int)((SCREEN_HEIGTH-UNIT_SIZE*2)/UNIT_SIZE))+1)*UNIT_SIZE;  
	}
	
	public void appleCheck() {
		if(X[0] == appleX && Y[0] == appleY) {
			bodyParts++;
			newApple();
		}
		
		
	}
	
	public void collectionCheck() {
		
		
		
		
	}
	
	
	// TODO Auto-run used to Draw map
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		
	}

	
	public void drawMap(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(FRISTSCREEN_X,FRISTSCREEN_Y, SCREEN_WIDTH, UNIT_SIZE);
		g.fillRect(FRISTSCREEN_X,FRISTSCREEN_Y, UNIT_SIZE, SCREEN_HEIGTH);
		g.fillRect(SCREEN_WIDTH-UNIT_SIZE,FRISTSCREEN_Y, UNIT_SIZE, SCREEN_HEIGTH);
		g.fillRect(FRISTSCREEN_X,SCREEN_HEIGTH-UNIT_SIZE,SCREEN_WIDTH,UNIT_SIZE);
	
	}
	
	public void draw(Graphics g) {
		//DrawLine Down
		
		g.setColor(Color.blue);
		
		for(int i=0;i<UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE,FRISTSCREEN_Y,i*UNIT_SIZE,SCREEN_HEIGTH);
		}
		
		for(int i=0;i<UNIT_SIZE;i++) {
			g.drawLine(FRISTSCREEN_X,UNIT_SIZE*i,SCREEN_WIDTH,i*UNIT_SIZE);
		}
		
		g.setColor(Color.green);
		g.fillRect(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
		
		//Draw body Snake
		for(int i=0;i<bodyParts;i++) {
			
			if(i==0) 
			{
				g.setColor(Color.red);
				g.fillRect(X[i],Y[i],UNIT_SIZE,UNIT_SIZE);
			}
			else
			{
				g.setColor(Color.yellow);
				g.fillRect(X[i],Y[i],UNIT_SIZE,UNIT_SIZE);
			}
			
		}
		
		//Draw Map
		drawMap(g);
		
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
			move();
			appleCheck();
			
			
			}
			repaint();
	}
	
	
}
