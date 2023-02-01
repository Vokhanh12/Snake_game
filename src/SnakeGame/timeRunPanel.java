package SnakeGame;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import static SnakeGame.SystemConfig.*;

import java.awt.Color;
import java.awt.Dimension;
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
			
			lbtimeRun.setOpaque(true);
			lbtimeRun.setBackground(Color.BLACK);
			lbtimeRun.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGTH-100);
			lbtimeRun.setHorizontalAlignment(SwingConstants.CENTER);
			lbtimeRun.setVerticalAlignment(SwingConstants.CENTER);
			lbtimeRun.setForeground(Color.WHITE);
			layPane.add(lbtimeRun);

			
			
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
					if(TIME!=-1) {
					lbtimeRun.setText(""+TIME);
					TIME--;
					}
					else {
						RemoveBackGround();
						tmtimeRun.stop();
						
						//this line set the Snake runned when the time finshed
						running = true;
					}
			}
			
		});
		tmtimeRun.start();
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	
	
}
