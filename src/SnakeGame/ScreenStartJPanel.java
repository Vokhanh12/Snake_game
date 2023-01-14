package SnakeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ScreenStartJPanel extends JPanel implements ActionListener
{
	static final int SCREEN_WIDTH=300;
	static final int SCREEN_HEIGTH=300;

	
	JLabel lb1 = new JLabel("HELLO");
	
	JLayeredPane layeredPaned = new JLayeredPane();
	
	
	public ScreenStartJPanel() {
		
		this.setSize(300,300);
		this.setBounds(250, 250, 300, 300);
		this.setBackground(Color.blue);
		
		this.add(lb1);
		lb1.setBounds(100, 100, 50, 50);
		

		
		

	}
	
	
	// TODO Auto-run used to Draw map
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	
}
