import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game {
	
	private int barLength = 200;
	private Timer cooldownTimer;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	
	private JFrame frame = new JFrame("Game");
	private JPanel panel = new JPanel() {
		
	
	};

	//KEY LISTENER KEY LISTENER KEY LISTENER KEY LISTENER KEY LISTENER KEY LISTENER
	private KeyListener kl = new KeyListener() {

		
		@Override
		public void keyTyped(KeyEvent e) {
		

			if (e.getKeyChar() == KeyEvent.VK_Q) {
				System.out.println("Q Pressed");
				
			}
				
			if (e.getKeyChar() == KeyEvent.VK_W) {
				System.out.println("W Pressed");
				
			}
			if (e.getKeyChar() == KeyEvent.VK_E) {
				System.out.println("E Pressed");
				
			}
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}; // END KEY LISTENER
	/*
	ActionListener buttonListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Button Pressed");
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			cooldownTimer = new Timer(10,timerListener);
			
			cooldownTimer.start();
		}
	};
	
	ActionListener timerListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Timer executed");
			barLength = barLength - 1;
			
			if (barLength == 0) {
				b1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				cooldownTimer.stop();
				barLength = 200;
			}
			panel.repaint();
		}	
	};
	*/
	
	//CONSTUCTORS CONTRUCTORS CONSTUCTORS CONTRUCTORS CONSTUCTORS CONTRUCTORS
	public Game() {
		
		
		int width = 1440;
		int height = 900;
		
		
		//DASH BUTTON
        frame.add(b1);
        b1.setSize(333, 80);
        b1.setLocation(0, 600);
        b1.setVisible(true);
        
        //IMAGE TO DASH BUTTON
        try {
            Image isword = ImageIO.read(getClass().getResource("DashIcon.png"));
            b1.setIcon(new ImageIcon(isword));
          } catch (Exception ex) {
            System.out.println(ex);
          }
  
        
        //SHIELD BUTTON
        frame.add(b2);
        b2.setSize(333, 80);
        b2.setLocation(333, 600);
        b2.setVisible(true);
        
        //IMAGE TO SHIELD BUTTON
        try {
            Image ishield = ImageIO.read(getClass().getResource("ShieldIcon.png"));
            b2.setIcon(new ImageIcon(ishield));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        //POTION BUTTON
        frame.add(b3);
        b3.setSize(333, 80);
        b3.setLocation(666, 600);
        b3.setVisible(true);
        
        //IMAGE TO POTION BUTTON
        try {
            Image ipotion = ImageIO.read(getClass().getResource("PotionIcon.jpeg"));
            b3.setIcon(new ImageIcon(ipotion));
          } catch (Exception ex) {
            System.out.println(ex);
          }
    
        
		
        //FRAME ATTRIBUTES
		frame.setSize(999, 700);
		frame.setLocation(width - 1220, height - 800);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(kl);
		frame.requestFocus();
		frame.setResizable(false);
		
		
		
	} //END GAME
	
	

	public static void main(String[] args) {
		
		Game game = new Game();
		
	} //end main
	
} //end class
