
public class Ball {

	private int x;
	private int y;
	private int r;
	
	public Ball(int xpos, int ypos) {
		x = xpos;
		y = ypos;
		r = 10;
	}
	
	public int getR() { return r;}
	public int getX() { return x;}
	public int getY() { return y;}
	
	public void changeX(int dx) {
		x = x + dx;
	}
	
	
}
