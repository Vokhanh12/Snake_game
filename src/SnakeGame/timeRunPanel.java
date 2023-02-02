package SnakeGame;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import static SnakeGame.SystemConfig.*;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class timeRunPanel extends JPanel implements timeRunITF,ActionListener{
	
	
	static JLabel lbtimeRun = new JLabel("");
	
	JLayeredPane layPane = new JLayeredPane();
	
	Timer tmtimeRun;
	
	
	public timeRunPanel(){
			this.setOpaque(false);
			this.setSize(SCREEN_WIDTH,SCREEN_HEIGTH);
			this.setBounds(0, 100, SCREEN_WIDTH, SCREEN_HEIGTH-100);
			
			layPane.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGTH));
			layPane.setBackground(Color.blue);
			this.add(layPane);
			
			lbtimeRun.setOpaque(false);
			lbtimeRun.setBounds(0, 0, 600, 400);
			lbtimeRun.setHorizontalAlignment(SwingConstants.CENTER);
			lbtimeRun.setVerticalAlignment(SwingConstants.CENTER);
			lbtimeRun.setForeground(Color.WHITE);
			lbtimeRun.setFont(new Font("Verdana", Font.PLAIN, 80));
			layPane.add(lbtimeRun);

			
			// this line used to run time for game
			run();
			
			
		}
	
	@Override
	public void RemoveBackGround() {
		lbtimeRun.setOpaque(false);
		lbtimeRun.setText("");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		tmtimeRun = new Timer(delay_timeRun,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					if(TIME!=-2) {
						if(TIME==-1)
						{
						lbtimeRun.setText("");
						TIME--;
						}
						else
						{
						lbtimeRun.setText(""+TIME);
						TIME--;
						}
					}
					else {
						
						
						RemoveBackGround();
						tmtimeRun.stop();
						
						//this line set the Snake runned when the time finshed
						running = true;
						SetupGame = true;
					}
			}
			
		});
		tmtimeRun.start();
	}

	
	public void paintComponent(Graphics g) {
		if(TIME!=-2) {
		 Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(
	            RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setComposite(AlphaComposite.getInstance(
	            AlphaComposite.SRC_OVER, 0.5f));
	        g2d.setColor(Color.BLACK);
	        g2d.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGTH);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	
	
}
