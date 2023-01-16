package SnakeGame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class ScreenStartJFrame extends JFrame{
	
	static final int SCREEN_HEIGHT =600;
	static final int SCREEN_WEIGTH =600;
	
	JLayeredPane lyPane =new JLayeredPane();
	
	
	
	public ScreenStartJFrame() {
		this.setSize(new Dimension(600, 600));
		
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
