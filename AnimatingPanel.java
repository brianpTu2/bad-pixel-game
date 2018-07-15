import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author brian.tu
 *
 * This class takes the background image and moves the image from right to left. 
 */
class AnimatingPanel extends JPanel {
   
        private int DIM_W = 999;
        private int DIM_H = 700;
        private int INCREMENT = 10; //Speed of background image

        private BufferedImage backgroundImage;

        private int dx1, dy1, dx2, dy2;
        private int sx1, sy1, sx2, sy2;
        private int IMAGE_WIDTH;

        //Constructors
        public AnimatingPanel() {
            initImages();
            initImagePoints();
            Timer timer = new Timer(40, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    moveBackground();
                    repaint();
                }
            });
            timer.start();
            
            FlowLayout layout = (FlowLayout)getLayout();
            layout.setHgap(0);
            layout.setVgap(0);
            
        }
        
        /**
         * This is the paintComponent which draws the image onto the panel. 
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(backgroundImage, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, this); 
            //this method takes the coordinates of the destination rectangle and the source rectangle. 
           
        }
        
        /**
         * sets the Dimension of the panel
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DIM_W, DIM_H);
        }
        
        /**
         * Declares the variables for the coordinates of the background image.
         */
        private void initImagePoints() {
            dx1 = 0;
            dy1 = 0;
            dx2 = DIM_W;
            dy2 = DIM_H;
            sx1 = 0;
            sy1 = 0;
            sx2 = DIM_W;
            sy2 = DIM_H;
        }
        
        /**
         * Prints out the background image.
         */
        private void initImages() {
            try {
            	
                backgroundImage = ImageIO.read(getClass().getResource("BackgroundImage1.png"));
                IMAGE_WIDTH = backgroundImage.getWidth();
                System.out.println(IMAGE_WIDTH);
            } catch (Exception ex) {
                //ex.printStackTrace();
            	System.out.println(ex);
            }
        }
        
        /**
         * This moves the image. 
         * Checks if the coordinates are greater than the image of the width. If they are, then reset the coordinate of sx1 so it is less than before. 
         */
        private void moveBackground() {
            if (sx1 > IMAGE_WIDTH) {
                sx1 = 0 - DIM_W;
                sx2 = 0;
            } else {
                sx1 += INCREMENT;
                sx2 += INCREMENT;
            }
        }
       
    } //end AnimatingPanel