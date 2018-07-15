import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class Character extends JPanel{

        private Image runnerImage;
        

        public Character() {
            initImages();
         
        }
       
        
        @Override
        protected void paintComponent(Graphics g) {
          
            g.drawImage(runnerImage, 0, 0, getWidth(), getHeight(), this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(350, 350);
        }
        


        private void initImages() {
            try {
            	runnerImage = new ImageIcon(getClass().getResource("WalkMove.gif")).getImage();
                
                
            } catch (Exception ex) {
                
            	System.out.println(ex);
            }
        }
       
      
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Character();
            }
        });
    } //end main
} //end class
