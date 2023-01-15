package SnakeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ScreenStartJPanel extends JPanel implements ActionListener
{
	static final int SCREEN_WIDTH=300;
	static final int SCREEN_HEIGTH=300;

	
	JButton btStart = new JButton("Start Game");
	JButton btOptions = new JButton("Options");
	JButton btClose = new JButton("Close");
	
	JLayeredPane layeredPaned = new JLayeredPane();
	
	
	public ScreenStartJPanel() {
		
		//Setting Panel
		this.setSize(300,300);
		this.setBounds(0, 0, 300, 300);
		this.setBackground(new Color(0,0,0,100));
		
		//Add Item
		this.add(btStart);
		btStart.setBounds(90, 50, 100, 50);
		this.add(btOptions);
		btOptions.setBounds(90, 100, 100, 50);
		this.add(btClose);
		btClose.setBounds(90, 150, 100, 50);
		
		btStart.addActionListener(this);
		btClose.addActionListener(this);
		btOptions.addActionListener(this);
		
		

	}
	
	
	// TODO Auto-run used to Draw map
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btStart)
		{
			new GameJFrame(); 
		}
		
		if(e.getSource()==btOptions)
		{
			//set Option
		}
		
		if(e.getSource()==btClose)
		{
			//close Window
			System.exit(0);
		}
	
	
	}
}
