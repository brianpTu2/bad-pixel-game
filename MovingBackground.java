import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingBackground extends JFrame {
	
	int l = 1000;
	private char[][] mapData = new char[18][l];
    private static final int D_W = 999;
    private static final int D_H = 700;
    
    DrawPanel drawPanel = new DrawPanel();

    public MovingBackground() {
        ActionListener listener = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (l >= D_W) {
                    l = 0;
                    drawPanel.repaint();
                } else {
                    l += 10;
                    drawPanel.repaint();
                    
                }
            }
        };
        
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
        
        Timer timer = new Timer(100, listener);
        timer.start();
        add(drawPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DrawPanel extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
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
						Color brown = new Color(102, 51, 0);
						g.setColor(brown);
						g.fillRect(xloc, yloc, 10, 10);
					}
					xloc = xloc + 10;
				}
				xloc = 0;
				yloc = yloc + 10;
			}
        }

        public Dimension getPreferredSize() {
            return new Dimension(D_W, D_H);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovingBackground();
            }
        });
    }
}