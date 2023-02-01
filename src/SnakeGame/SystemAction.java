package SnakeGame;

import java.awt.Graphics;

public interface SystemAction {
	
	void StartGame(GameJPanel gamePanel);
	
	void GameOverDraw(Graphics g);
	
	void StopGame();
	
	void SetGame();
	
	void saveScore();
	
	
	
}
