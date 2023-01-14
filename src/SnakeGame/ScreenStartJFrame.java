package SnakeGame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ScreenStartJFrame extends JFrame{
	
	
	
	
	
	public ScreenStartJFrame() {
		this.setSize(750,750);
		
		this.setTitle("Game Start");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		
		
		this.add(new ScreenGameJPanel());
		this.add(new ScreenStartJPanel());
		
	}

}
