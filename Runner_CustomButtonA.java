import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

//this file shows the benefits of creating a special class
//to create these custom button displays with the timer bar
//feature

public class Runner_CustomButtonA {

	private JFrame frame = new JFrame("Runner_CooldownButton");
	private JPanel panel = new JPanel();
	
	private CooldownBar cb1 = new CooldownBar("DASH");
	private CooldownBar cb2 = new CooldownBar("SHIELD");
	private CooldownBar cb3 = new CooldownBar("POTION");
	
	
	public Runner_CustomButtonA() {
		
		frame.setLocation(220,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 0;
		c1.gridwidth = 3;
		
		panel.setSize(new Dimension(999,700));
		frame.add(panel,c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 1;

		c2.insets = new Insets(10,10,10,10);
		
		frame.add(cb1.getFrame(), c2);
		

		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 1;
		
		c3.insets = new Insets(10,10,10,10);
		
		frame.add(cb2.getFrame(), c3);
		

		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 2;
		c4.gridy = 1;
		
		c4.insets = new Insets(10,10,10,10);
		
		frame.add(cb3.getFrame(), c4);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runner_CustomButtonA game = new Runner_CustomButtonA();
		
		
	}

}
