package SnakeGame;

import javax.swing.JFrame;





public class GameJFrame extends JFrame{
	
	GameJFrame(){
		this.add(new GameJPanel());
		this.setTitle("Game Snake a");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
		
		
		
		
	}

}
