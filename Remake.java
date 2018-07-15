import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author brian.tu
 *
 * This is the the Assignment 2 Game which is still currently in BETA. 
 * This is a graphics game that is about a character who attacks and kills monsters coming in his way.
 * By doing this, the character remains still, but the background and ground image and graphics are in a moving motion.
 * The character is given abilities Attack, Defense, and Potion which are set the JButtons and have cooldown timers set to them.
 * 
 */
public class Remake {
	
	AnimatingPanel apanel = new AnimatingPanel(); //calls the AnimatingPanel class
    Character character = new Character(); //calls the Character class
	
	int barLength1 = 329; //bar length for dash button, b1
	int barLength2 = 329; // bar length for defense button, b2
	int barLength3 = 329; //bar length for potion button, b3
   
	private char[][] mapData = new char[18][100];
	
	private Timer timer1;
	private Timer timer2;
	private Timer timer3;
	private JFrame frame = new JFrame("Game");
	private JPanel panel = new JPanel() {
		
		public void paint(Graphics g) {
			
			//COLOURS
			Color myColour = new Color(140, 140, 140, 127); // the fourth int called alpha sets the shade of the bar. 
			Color brown = new Color(102, 51, 0);
			
			g.setColor(myColour); 
			
			//COOLDOWN BARS
			g.fillRect(2, 580, barLength1, 20); //makes the cooldown bar for b1
			g.fillRect(335, 580, barLength2, 20); //makes the cooldown bar for b2
			g.fillRect(668, 580, barLength3, 20); //makes the cooldown bar for b3
			
			//GROUND MAP
			int xloc = 0;
			int yloc = 397;
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
	
	/**
	 * This button listener checks which of the three buttons are pressed and then starts a timer for the cooldown bar. 
	 * It must check which button is pressed so it knows which bar is disabled to be ready for cooldown.  
	 * Once the timer starts, it moves into the timer listener. 
	 */
	ActionListener btnListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
	
			JButton temp = (JButton)(e.getSource()); //e.getSource checks the object of which the event intially occured.  
			
			if (temp == b1) {
				System.out.println("Button 1 pressed");
				b1.setEnabled(false);
				timer1 = new Timer(10, btntimerListener);
				timer1.start();
			}

			else if (temp == b2) {
				System.out.println("Button 2 pressed");
				b2.setEnabled(false);
				timer2 = new Timer(10, btntimerListener);
				timer2.start();
			}

			else if (temp == b3) {
				System.out.println("Button 3 pressed");
				b3.setEnabled(false);
				timer3 = new Timer(10, btntimerListener);
				timer3.start();
			}
			
		
		}
		
		
	};
	
	/**
	 * The button timer listener checks the disabled button so it can begin the bar to cooldown. 
	 * When the bar length of the cooldown goes down to 0, the button is re-enabled and the bar is set back to its original length.
	 */
	ActionListener btntimerListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (b1.isEnabled() == false) {
				
				barLength1 --;	
			
				if (barLength1 == 0) {
					b1.setEnabled(true);
					timer1.stop();
					barLength1 = 329;
					
				}	
				
			}
			
			else if (b2.isEnabled() == false) {
				
				barLength2 --;	
			
				if (barLength2 == 0) {
					b2.setEnabled(true);
					timer2.stop();
					barLength2 = 329;
					
				}	
				
			}
			
			else if (b3.isEnabled() == false) {
				
				barLength3 --;	
			
				if (barLength3 == 0) {
					b3.setEnabled(true);
					timer3.stop();
					barLength3 = 329;
					
				}	
				
			}
			panel.repaint();
			
		}
		
	};
	
	//CONSTRUCTORS
	public Remake() {
		
		//DASH BUTTON
        b1.setSize(333, 80);
        b1.setLocation(0, 600);
        b1.setVisible(true);
        b1.addActionListener(btnListener);
        frame.add(b1);
        
        // try catch reads the imported image or gif and then prints it out. 
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
		
		character.setLocation(0, 400);
		character.setSize(200,180);
		frame.add(character);
		
		frame.addKeyListener(kl);
		frame.requestFocus();
		
		
	}
	
	
	public static void main(String[] args) {
		
		Remake game = new Remake();
		
		
	} // end main

} // end class
