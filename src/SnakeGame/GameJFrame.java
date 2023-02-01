package SnakeGame;

import static SnakeGame.SystemConfig.*;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;





public class GameJFrame extends JFrame{
	
	public static JLayeredPane lyPane =new JLayeredPane();
	
	
	GameJFrame(){
		this.setSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGTH));
		this.setTitle("Game Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		this.add(lyPane);
		
		lyPane.add(new GameJPanel(),1,1);
		lyPane.add(new gameSubJPanel(),2,2);
		lyPane.add(new TranscriptJPanel(),3,3);
		lyPane.add(new timeRunPanel(),4,4);

		
		
		
		
		
		
		
		
		
		
	}

}
