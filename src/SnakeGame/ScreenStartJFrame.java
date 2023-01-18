package SnakeGame;


import static SnakeGame.SystemConfig.*;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class ScreenStartJFrame extends JFrame{


	
	public static JLayeredPane lyPane =new JLayeredPane();
	
	
	
	public ScreenStartJFrame() {
		this.setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGTH));
		
		this.setTitle("Game Start");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		this.add(lyPane);
		
		//new ScreenGameJPanel()
		//new ScreenStartJPanel()
		lyPane.add(new ScreenGameJPanel(),0,0);
		lyPane.add(new ScreenStartJPanel(),1,1);
		
		
		

		
	}

}
