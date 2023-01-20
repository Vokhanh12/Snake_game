package SnakeGame;

import static SnakeGame.SystemConfig.DirectionLR;
import static SnakeGame.SystemConfig.DirectionUD;
import static SnakeGame.SystemConfig.SCREEN_HEIGTH;
import static SnakeGame.SystemConfig.SCREEN_WIDTH;
import static SnakeGame.SystemConfig.UNIT_SIZE;
import static SnakeGame.SystemConfig.X;
import static SnakeGame.SystemConfig.Y;
import static SnakeGame.SystemConfig.bodyParts;
import static SnakeGame.SystemConfig.direction;
import static SnakeGame.SystemConfig.fenceDOWN_Y;
import static SnakeGame.SystemConfig.fenceLEFT_X;
import static SnakeGame.SystemConfig.fenceRIGHT_X;
import static SnakeGame.SystemConfig.fenceUP_Y;

public class Snake implements SnakeAction{

	@Override
	public void move() {
		// TODO Auto-generated method stub
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

	@Override
	public void toolMove() {
		// TODO Auto-generated method stub
			
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
				
		
	}


