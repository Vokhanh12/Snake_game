package SnakeGame;

import static SnakeGame.SystemConfig.*;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ScreenStartJPanel extends JPanel implements ActionListener
{


	
	JButton btStart = new JButton("Start Game");
	JButton btOptions = new JButton("Options");
	JButton btClose = new JButton("Close");
	
	JLayeredPane layeredPaned = new JLayeredPane();
	
	
	public ScreenStartJPanel() {
		
		//Setting Panel
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGTH);
		this.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGTH);
		
		
		
		this.setLayout(null);
		
		this.setOpaque(false);

		
		//Add Item
		this.add(btStart);
		btStart.setBounds((SCREEN_WIDTH-100)/2, 150, 100, 50);
		this.add(btOptions);
		btOptions.setBounds((SCREEN_WIDTH-100)/2, 230, 100, 50);
		this.add(btClose);
		btClose.setBounds((SCREEN_WIDTH-100)/2, 310, 100, 50);
		
		btStart.addActionListener(this);
		btClose.addActionListener(this);
		btOptions.addActionListener(this);
		
		

	}
	
	
	protected void paintComponent(Graphics g) {
	      
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
