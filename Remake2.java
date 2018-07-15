import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Remake2 {
	
	int barLength1 = 329;
	int barLength2 = 329;
	int barLength3 = 329;
	
	
	
   AnimatingPanel apanel = new AnimatingPanel();
   
   Character character = new Character();
	
	private char[][] mapData = new char[15][100];
	
	private Timer timer;
	private JFrame frame = new JFrame("Game");
	private JPanel panel = new JPanel() {
		
		public void paint(Graphics g) {
			Color myColour = new Color(140, 140, 140, 127);
			Color brown = new Color(102, 51, 0);
			g.setColor(myColour);
			
			//COOLDOWN BARS
			g.fillRect(2, 580, barLength1, 20);
			g.fillRect(335, 580, barLength2, 20);
			g.fillRect(668, 580, barLength3, 20);
			
			//GROUND MAP
			int xloc = 0;
			int yloc = 426;
			for (int r = 0; r < mapData.length; r = r + 1) {
				for (int c = 0; c < mapData[r].length; c = c + 1) {
					if (mapData[r][c] == 'G') {
						g.setColor(Color.DARK_GRAY);
						g.fillRect(xloc, yloc, 10, 10);
					}
					if (mapData[r][c] == 'M') {
						g.setColor(Color.GRAY);
						g.fillRect(xloc, yloc, 10, 10);
					}
					if (mapData[r][c] == 'W') {
						g.setColor(brown);
						g.fillRect(xloc, yloc, 10, 10);
					}
					xloc = xloc + 10;
				}
				xloc = 0;
				yloc = yloc + 10;
			}
		}
		
	};
	
	
	private JButton b1 = new JButton();
	private JButton b2 = new JButton();
	private JButton b3 = new JButton();
	
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
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	ActionListener btnListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
	
			JButton temp = (JButton)(e.getSource());
			
			if (temp == b1) {
				System.out.println("Button 1");
			}

			else if (temp == b2) {
				System.out.println("Button 2");
			}

			else if (temp == b3) {
				System.out.println("Button 3");
			}
			
			
			System.out.println("Button Pressed");
			b1.setEnabled(false);
			timer = new Timer(10, btntimerListener);
			timer.start();
		}
		
		
	};
	
	ActionListener btntimerListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			barLength1 --;	
			
			if (barLength1 == 0) {
				b1.setEnabled(true);
				timer.stop();
				barLength1 = 329;
				
			}	
			panel.repaint();
			
		}
		
	};
	
	public Remake2() {
		
		//DASH BUTTON
        b1.setSize(333, 80);
        b1.setLocation(0, 600);
        b1.setVisible(true);
        b1.addActionListener(btnListener);
        frame.add(b1);
        
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
        b2.addActionListener(btnListener);
        frame.add(b2);
        
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
        b3.addActionListener(btnListener);
        frame.add(b3);
        
        //IMAGE TO POTION BUTTON
        try {
            Image ipotion = ImageIO.read(getClass().getResource("PotionIcon.jpeg"));
            b3.setIcon(new ImageIcon(ipotion));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        //PRINT MAP
        for (int r = 0; r < mapData.length; r = r + 1) {
			for (int c = 0; c <mapData[r].length; c = c + 1) {
				int rand = (int)(Math.random()*30);
				
				if (rand < 25) {
					mapData[r][c] = 'G';
					
				}
				else if (rand == 26 || rand == 27) {
					mapData[r][c] = 'M';
				}
				else {
					mapData[r][c] = 'W';
				}
			}
		}
        
       
        
        
        //FRAME ATTRIBUTES
        frame.setSize(999, 700);
		frame.setLocation(220, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		
		apanel.setLocation(0, 0);
		apanel.setSize(999, 400);
		frame.add(apanel);
		
		frame.addKeyListener(kl);
		frame.requestFocus();
		
		
	}
	
	
	public static void main(String[] args) {
		
		Remake2 game = new Remake2();
		
		
	} // end main

} // end class
