package SnakeGame;

import static SnakeGame.SystemConfig.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.lang.Cloneable; 

public class GameJPanel extends JPanel implements ActionListener{
	
	
	static final int FRISTSCREEN_X=0;
	static final int FRISTSCREEN_Y=0;
	// fence UP,LEFT,DOWN,RIGHT
	static final int fenceUP_X[]= new int [(SCREEN_WIDTH/UNIT_SIZE)+2];
	static final int fenceUP_Y[]= {UNIT_SIZE} ;
	
	static final int fenceDOWN_X[]=new int [(SCREEN_WIDTH/UNIT_SIZE)+2];
	static final int fenceDOWN_Y[]= new int [(SCREEN_HEIGTH/UNIT_SIZE)+2];
	
	static final int fenceLEFT_X[]={UNIT_SIZE};
	static final int fenceLEFT_Y[]=new int[(SCREEN_HEIGTH/UNIT_SIZE)+2];
	
	static final int fenceRIGHT_X[]=new int [(SCREEN_WIDTH/UNIT_SIZE)+2];
	static final int fenceRIGHT_Y[]=new int [(SCREEN_HEIGTH/UNIT_SIZE)+2];

	//this line used to create the fence in the game
	
	final int X[]=new int [GAME_UNITS];
	final int Y[]=new int [GAME_UNITS];
	
	char directionRunX ='R';
	char directionRunY='U';
	
				
	char DirectionLR ='R';
	char DirectionUD ='D';
				
	
	int appleEaten;
	int appleX,appleY;
	
	char direction = 'R';
	
    boolean running = false;
    
	Timer timer;
	Random random;
	
	
    
    
	public GameJPanel() {
		
		random = new Random();
		
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGTH);
		this.setFocusable(true);
		this.setBackground(Color.black);
		this.addKeyListener(new MyKeyAdapter());
		
		
		SetGame();
		StartGame();
		
		
	}
	
	
	
	
	
	
	public void SetGame() {
		//SET LOCATION
		X[0] = UNIT_SIZE * 2;
		Y[0] = UNIT_SIZE * 2;
		
		//SET THE FENCES, THE MAP CAN'T RUN OVER 
		//HEIGTH=UP=DOWN,WIDTH=LEFT=RIGHT
		for(int i=0;i<=SCREEN_HEIGTH/UNIT_SIZE;i++)
		{
			fenceUP_X[i]=i*UNIT_SIZE;
			fenceDOWN_X[i]=i*UNIT_SIZE;
			fenceRIGHT_X[i]=i*UNIT_SIZE;
		}
		
		for(int i=0;i<=SCREEN_WIDTH/UNIT_SIZE;i++)
		{
			fenceDOWN_Y[i]=i*UNIT_SIZE;
			fenceLEFT_Y[i]=i*UNIT_SIZE;
			fenceRIGHT_Y[i]=i*UNIT_SIZE;
		}
		
		
		
	}
	
	public void toolSnake() {
		
		
		for(int i = 0;i<SCREEN_HEIGTH/UNIT_SIZE;i++)
		{
			if(DirectionLR == 'R')
			{
				X[0]+=UNIT_SIZE;
				
				
				if( X[0]==fenceRIGHT_X[(SCREEN_WIDTH/UNIT_SIZE)-1]) 
				{
					X[0]-=UNIT_SIZE;
					
					DirectionLR ='L';
					
					
					
					if(DirectionUD=='D')
					{
						Y[0]+=UNIT_SIZE;
						
						if(Y[0]==fenceDOWN_Y[(SCREEN_HEIGTH/UNIT_SIZE)-1])
						DirectionUD='U';
						
					}
					else if(DirectionUD=='U')
					{
						    Y[0]-=UNIT_SIZE;
							if(Y[0]==fenceUP_Y[0]+UNIT_SIZE)
								DirectionUD='D';

					}
				}
				
				break;
			}
			else if(DirectionLR == 'L')
				{
					X[0]-=UNIT_SIZE;
					
					if( X[0]==fenceLEFT_X[0]) 
					{
						X[0]+=UNIT_SIZE;
						
						DirectionLR ='R';
						
						
						
						if(DirectionUD=='D')
						{
							Y[0]+=UNIT_SIZE;
							
							if(Y[0]==fenceDOWN_Y[(SCREEN_HEIGTH/UNIT_SIZE)-2])
								DirectionUD='U';
							
						}
						else if(DirectionUD=='U')
						{
							    Y[0]-=UNIT_SIZE;
							    
							    if(Y[0]==fenceUP_Y[0]+UNIT_SIZE)
									DirectionUD='D';
						}
						
					}
					break;
					
				}
		}
	}		
			

	
	
	public void StartGame() {
		newApple();
		running =true;
		// what the fuck this line
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	public void StopGame() {
		running = false;
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
	    appleX=(random.nextInt((int)((SCREEN_WIDTH-UNIT_SIZE*4)/UNIT_SIZE))+2)*UNIT_SIZE; 
		appleY=(random.nextInt((int)((SCREEN_HEIGTH-UNIT_SIZE*4)/UNIT_SIZE))+2)*UNIT_SIZE; 
		

	}
	
	public void appleCheck() {
		
			
			if(X[0] == appleX && Y[0] == appleY) {
				bodyParts++;
				newApple();
				

			}
			
			for(int i = 1 ;i<bodyParts;i++) {
				
			if(X[i] == appleX && Y[i] == appleY) {
				 newApple();
				 break;
				
			}
			
			
			}
			
			
	}
		
		
	
	public void fenceCheck() {
		
			for(int j=1;j<=SCREEN_HEIGTH/UNIT_SIZE;j++) {
				
				if(X[0]==fenceUP_X[j] && Y[0]==fenceUP_Y[0]) 
				{
					StopGame();
					break;
				}
				
				if(X[0]==fenceDOWN_X[j] && Y[0]==fenceDOWN_Y[(SCREEN_HEIGTH/UNIT_SIZE)-2])
				{
					StopGame();
					break;
				}
				
				if(X[0]==fenceLEFT_X[0] && Y[0]==fenceLEFT_Y[j])
				{
					StopGame();
					break;
				}
				
				if(X[0]==fenceRIGHT_X[(SCREEN_WIDTH/UNIT_SIZE)-2] && Y[0]==fenceRIGHT_Y[j])
				{
					StopGame();
					break;
				}
				
				
				System.out.println("ERRO => fenceCHECK");
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
		
		//build a fence above
		g.fillRect(FRISTSCREEN_X,FRISTSCREEN_Y, SCREEN_WIDTH, UNIT_SIZE*2);
		//build a fence on the left
		g.fillRect(FRISTSCREEN_X,FRISTSCREEN_Y, UNIT_SIZE*2, SCREEN_HEIGTH);
		//build a fence on the right
		g.fillRect(SCREEN_WIDTH-UNIT_SIZE*2,FRISTSCREEN_Y, UNIT_SIZE*2, SCREEN_HEIGTH);
		//build a fence under
		g.fillRect(FRISTSCREEN_X,SCREEN_HEIGTH-UNIT_SIZE*2,SCREEN_WIDTH,UNIT_SIZE*2);
	
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
			fenceCheck();
			repaint();
		}
	
	
	}
}
