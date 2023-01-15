package SnakeGame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ScreenStartJFrame extends JFrame{
	
	static final int SCREEN_HEIGHT =300;
	static final int SCREEN_WEIGTH =300;
	
	
	
	public ScreenStartJFrame() {
		this.setSize(SCREEN_WEIGTH,SCREEN_HEIGHT);
		
		this.setTitle("Game Start");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		
		
		this.add(new ScreenStartJPanel());
		this.add(new ScreenGameJPanel());

		
	}

}
