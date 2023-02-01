package SnakeGame;


import java.io.File;
import java.util.Random;

import javax.swing.Timer;

public final class SystemConfig {
	
	static final int SCREEN_HEIGTH =600;
	static final int SCREEN_WIDTH =600;
	
	static final int UNIT_SIZE=50;
	static final int GAME_UNITS=(SCREEN_HEIGTH*SCREEN_WIDTH)/UNIT_SIZE;
	static final int DELAY=150;
	
	static int bodyParts =3;
	static int firstScore=bodyParts;
	
	static final File fileScore = new File("C:\\Users\\Khanh\\eclipse-workspace\\Game\\ScoreGame.txt");
	
	static final int X[]=new int [GAME_UNITS];
	static final int Y[]=new int [GAME_UNITS];
	
	
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
	
	static char directionRunX ='R';
	static char directionRunY='U';
	
				
	static char DirectionLR ='R';
	static char DirectionUD ='D';
				
	
	static int appleEaten;
	static int appleX,appleY;
	
	static char direction = 'R';
	
    static boolean running = false;
    
    static Timer timerSnake;
    
    static Random randomSnake = new Random();
    
    
    
	static int delay_timeRun=1000;
	static int TIME=5;

    
    
    


}

