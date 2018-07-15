import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Game2_JW2 {

	//Fields
	//GUI******************************************
	private JFrame frame = new JFrame("Game_JW2");
	
	private JPanel panelMain = new JPanel() {
		
		public void paint(Graphics g) {
			
			
			//Step 1: Draw Map
			int xloc = 0;
			int yloc = 0;
			for (int r = 0; r < mapData.length; r = r + 1) {
				for (int c = 0; c < mapData[r].length; c = c + 1) {
					if (mapData[r][c] == 'G') {
						g.setColor(Color.GREEN);
						g.fillRect(xloc, yloc, 10, 10);
					}
					if (mapData[r][c] == 'M') {
						g.setColor(Color.GRAY);
						g.fillRect(xloc, yloc, 10, 10);
					}
					if (mapData[r][c] == 'W') {
						g.setColor(Color.BLUE);
						g.fillRect(xloc, yloc, 10, 10);
					}
					xloc = xloc + 10;
				}
				xloc = 0;
				yloc = yloc + 10;
			}
			//Step 2: Draw Man
			g.setColor(Color.RED);
			
			g.fillRect(playerX, playerY, 10, 10);
		
		}

	};

	private JButton b1 = new JButton("Jab");
	private JButton b2 = new JButton("Swing");

	private JButton b3 = new JButton("Eat Cookie");
	private JButton b4 = new JButton("Drink Milk");
	
	private JTextArea textArea = new JTextArea();
	private JTextField textField = new JTextField();
	private JButton submit = new JButton ("submit");
	
	
	//Listeners************************************
	//Need Key Listener to register when we move the player
	
	private KeyListener kl = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("Key Pressed");

			if (e.getKeyChar() == KeyEvent.VK_W) {
				playerY = playerY - 10;
				System.out.println("UP");
				
			}
			else if (e.getKeyChar() == KeyEvent.VK_D) {
				playerX = playerX + 10;
				
			}
			if (e.getKeyChar() == KeyEvent.VK_S) {
				playerY = playerY + 10;
				
			}
			if (e.getKeyChar() == KeyEvent.VK_A) {
				playerX = playerX - 10;
				
			}
			
			panelMain.repaint(); //repaint to reposition man
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	};
	
	
	private ActionListener submitAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Get Text
			String text = textField.getText();
			
			//Clear textField
			textField.setText("");
		
			//Print to textArea
			textArea.append("\n"+text);
			
			//set the focus on the frame to 
			//allow keylistener to work again
			frame.requestFocus();
		}
			
		
	
	};
	//Game Variable********************************
	//Player Variables
	private int playerX = 0;
	private int playerY = 0;
	
	private char[][] mapData = new char[50][50];
	
	
	//Construtors:
	public Game2_JW2() {
		
		//Setup Game Back End
		for (int r = 0; r < mapData.length; r = r + 1) {
			for (int c = 0; c <mapData[r].length; c = c + 1) {
				int rand = (int)(Math.random()*30);
				//System.out.println(rand);
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
		
		//Second pass and evalue each square.  If it is water look all 8 directions and then possibly change to water 90
		
		//Setup Game Front End
		//sets frame location
		frame.setLocation(100, 100);
		//SetLayoutManager
		frame.setLayout(new GridBagLayout());
		
		//CODE TO ADD PANEL
		//special object that gives the GUI manager
		//instructions on how to add an object
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 0;
		c1.gridwidth = 2;
		panelMain.setPreferredSize(new Dimension(500,500));
		
		frame.add(panelMain,c1);
		
		//CODE TO ADD BUTTON 1
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 1;
		c2.weightx = 50;
		
		frame.add(b1,c2);
		
		//CODE TO ADD BUTTON 2
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 1;
		c3.anchor = GridBagConstraints.CENTER;
		c3.weightx = 50;
		frame.add(b2,c3);

		//CODE TO ADD BUTTON 3
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 0;
		c4.gridy = 2;
		c4.weightx = 1.0;
		
		frame.add(b3,c4);
		
		//CODE TO ADD BUTTON 4
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 1;
		c5.gridy = 2;
		c5.anchor = GridBagConstraints.CENTER;
		c5.weightx = 1.0;
		frame.add(b4,c5);
		
		//CODE TO ADD TEXT AREA
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 2;
		c6.gridy = 0;
		c6.anchor = GridBagConstraints.NORTH;
		c6.fill = GridBagConstraints.BOTH;
		
		textArea.setRows(30);
		textArea.setColumns(30);
		textArea.setFocusable(false);
		textArea.setEnabled(false);
			
		frame.add(textArea,c6);
	
		//CODE TO ADD SUBMIT BUTTON
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 2;
		c7.gridy = 2;
		c7.gridwidth = 2;
		c7.fill = GridBagConstraints.BOTH;
		
		submit.addActionListener(submitAction);
		frame.add(submit, c7);
		
		//CODE TO ADD TEXTFIELD
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 2;
		c8.gridy = 1;
		c8.gridwidth = 2;
		c8.fill = GridBagConstraints.BOTH;
	
		frame.add(textField, c8);
		
		

		frame.addKeyListener(kl);
		
		//FINALIZE FRAME SETUP
		frame.setResizable(false);
		frame.pack(); //packs all the elements so it sets the size of the screen automatically
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.requestFocus(); //You have to set the focus to this
	}
	
	
	
	public static void main(String[] args) {
		
		
		Game2_JW2 game = new Game2_JW2();
		
		
	}

	
	
}
