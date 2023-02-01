package SnakeGame;

import static SnakeGame.SystemConfig.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.Timer;
public class Game implements SystemAction,AppleAction,ActionListener{
	
	static final int DELAYCOUNT=1000;
	
	Timer tmTimeCount;
	
	
	Game(){
		

	}
	
	
	@Override
	public void StartGame(GameJPanel gamePanel) {
		// TODO Auto-generated method stub
		appleCreate();
		timerSnake = new Timer(DELAY,gamePanel);
		timerSnake.start();
	}

	@Override
	public void StopGame() {
		// TODO Auto-generated method stub
		running = false;
		saveScore();
		
	}

	@Override
	public void SetGame() {
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

	@Override
	public void saveScore() {
		// TODO Auto-generated method stub
		int SCORE=bodyParts-firstScore;
		String newLine = System.getProperty("line.separator");
		
		try(FileOutputStream fileStream = new FileOutputStream(fileScore,true)){
			
			OutputStreamWriter Writer = new OutputStreamWriter(fileStream);
			
			Writer.write(String.valueOf(SCORE));
			Writer.write(newLine);
	        
	        Writer.close();
			
		}
		catch(Exception ex) {
			 ex.getStackTrace();
		}	
	}

	@Override
	public void appleCheck() {
		// TODO Auto-generated method stub
		if(X[0] == appleX && Y[0] == appleY) {
			bodyParts++;
			appleCreate();
			

		}
		
		for(int i = 1 ;i<bodyParts;i++) {
			
		if(X[i] == appleX && Y[i] == appleY) {
			 appleCreate();
			 break;
			
		}
		
		
		}
	}

	@Override
	public void appleCreate() {
		// TODO Auto-generated method stub
	    appleX=(randomSnake.nextInt((int)((SCREEN_WIDTH-UNIT_SIZE*4)/UNIT_SIZE))+2)*UNIT_SIZE; 
		appleY=(randomSnake.nextInt((int)((SCREEN_HEIGTH-UNIT_SIZE*4)/UNIT_SIZE))+2)*UNIT_SIZE; 
	}

	@Override
	public void GameOverDraw(Graphics g) {
		// TODO Auto-generated method stub
		if(running == false && TIME == 0)
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free",Font.BOLD,75));
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2, SCREEN_HEIGTH/2);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}


	
	
			
			
	
	
}
