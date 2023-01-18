package SnakeGame;

import static SnakeGame.SystemConfig.SCREEN_HEIGTH;
import static SnakeGame.SystemConfig.SCREEN_WIDTH;

public final class SystemConfig {
	
	static final int SCREEN_HEIGTH =600;
	static final int SCREEN_WIDTH =600;
	
	static final int UNIT_SIZE=50;
	static final int GAME_UNITS=(SCREEN_HEIGTH*SCREEN_WIDTH)/UNIT_SIZE;
	static final int DELAY=150;
	
	static int bodyParts =3;
	
	

}

