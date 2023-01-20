package SnakeGame;

import java.awt.Graphics;

public interface SystemAction {
	
	void StartGame(GameJPanel gamePanel);
	
	void GameOver(Graphics g);
	
	void StopGame();
	
	void SetGame();
	
	void saveScore();
	
}
