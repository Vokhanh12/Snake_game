package SnakeGame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScreenGameJPanel extends JPanel{
	
	
	JLabel lb1 = new JLabel("HELLO1");
	JButton bt = new JButton("Start Game");
	
	public ScreenGameJPanel(){
		this.setSize(300,300);
		this.setBackground(new Color(0,0,0,50));
		
		
		
		this.add(bt);
		this.add(lb1);
		lb1.setBounds(200,200, 50, 50);
		bt.setBounds(100, 100, 100, 100);
		bt.setBackground(Color.red);
		
	}

}
