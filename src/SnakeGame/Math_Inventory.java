package SnakeGame;

import java.util.Random;

public class Math_Inventory {
	public int getRandomNumber(int min, int max){

	    Random random = new Random();         
	    return random.nextInt() % (max - min) + max;

	}
}
