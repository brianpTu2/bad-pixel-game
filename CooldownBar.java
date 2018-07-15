import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CooldownBar {
	
	
	private Timer cooldownTimer;
	private int barLength = 195;
	private JButton cooldownButton;
	
	private JPanel panel = new JPanel();
	private JPanel barPanel = new JPanel() {
		
		public void paint(Graphics g) {
			
			int shade = 127;
			Color myColour = new Color(140, 140, 140, shade);
			g.setColor(myColour);
			g.fillRect(3, 0, barLength, 30);
		}
	};
	
	ActionListener timerListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Timer executed");
			barLength = barLength - 1;
			
			if (barLength == 0) {
				cooldownButton.setEnabled(true);
				cooldownTimer.stop();
				barLength = 200;
			}
			barPanel.repaint();
		}
		
		
	};
	
	ActionListener buttonListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Button Pressed");
			cooldownButton.setEnabled(false);
			cooldownTimer = new Timer(10,timerListener);
			
			cooldownTimer.start();
			
			
		}
		
		
		
	};
	
	public CooldownBar(String name) {
		
	
			
		cooldownTimer = new Timer(1000, timerListener);
			
	     panel.setLayout(new BorderLayout());
			
			
		 barPanel.setPreferredSize(new Dimension(200,40));
		 panel.add(barPanel,BorderLayout.NORTH);
	
		 cooldownButton = new JButton(name);
		 cooldownButton.setPreferredSize(new Dimension(200, 200));
		 cooldownButton.addActionListener(buttonListener);
		 panel.add(cooldownButton, BorderLayout.SOUTH);
	
		 
	}
	
	public JPanel getFrame() { return panel; }
	
	public static void main(String[] args) {
		
		
	}
}
