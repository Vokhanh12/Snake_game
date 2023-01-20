package SnakeGame;

import static SnakeGame.SystemConfig.FRISTSCREEN_X;
import static SnakeGame.SystemConfig.FRISTSCREEN_Y;
import static SnakeGame.SystemConfig.SCREEN_HEIGTH;
import static SnakeGame.SystemConfig.SCREEN_WIDTH;
import static SnakeGame.SystemConfig.UNIT_SIZE;
import static SnakeGame.SystemConfig.X;
import static SnakeGame.SystemConfig.Y;
import static SnakeGame.SystemConfig.appleX;
import static SnakeGame.SystemConfig.appleY;
import static SnakeGame.SystemConfig.bodyParts;
import static SnakeGame.SystemConfig.fenceDOWN_X;
import static SnakeGame.SystemConfig.fenceDOWN_Y;
import static SnakeGame.SystemConfig.fenceLEFT_X;
import static SnakeGame.SystemConfig.fenceLEFT_Y;
import static SnakeGame.SystemConfig.fenceRIGHT_X;
import static SnakeGame.SystemConfig.fenceRIGHT_Y;
import static SnakeGame.SystemConfig.fenceUP_X;
import static SnakeGame.SystemConfig.fenceUP_Y;

import java.awt.Color;
import java.awt.Graphics;

public class MapGame extends Game implements FrenceAction{

	
	
	
	
	@Override
	public void frenceSet(Graphics g) {
		// TODO Auto-generated method stub
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

	@Override
	public void frenceCheck() {
		// TODO Auto-generated method stub
		for(int j=1;j<=SCREEN_HEIGTH/UNIT_SIZE;j++) {
			
			if(X[0]==fenceUP_X[j] && Y[0]==fenceUP_Y[0]) 
			{
				super.StopGame();
				break;
			}
			
			if(X[0]==fenceDOWN_X[j] && Y[0]==fenceDOWN_Y[(SCREEN_HEIGTH/UNIT_SIZE)-2])
			{
				super.StopGame();
				break;
			}
			
			if(X[0]==fenceLEFT_X[0] && Y[0]==fenceLEFT_Y[j])
			{
				super.StopGame();
				break;
			}
			
			if(X[0]==fenceRIGHT_X[(SCREEN_WIDTH/UNIT_SIZE)-2] && Y[0]==fenceRIGHT_Y[j])
			{
				super.StopGame();
				break;
			}
			
			
		}
	}
	
	
	
	public void DrawMap(Graphics g) {
		
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
	
	
	public void SetMap(Graphics g) {
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
			
			DrawMap(g);
			
		}
	
	
}
