

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Signs {

	private int i;
	int x;
	int y;
	int[] status;
	int row;
	int col;
    double locator;
	static final int ROCKSIZE = 100;
	/**
	 * First constructor construct finish and starting rock(green&red)
	 * @param x the x loc of the rock on the JFrame
	 * @param y the y loc of the rock on the JFrame
	 * @param s "start" means starting rock(green) and "end" means ending rock(red)
	 * @param locator a decimal number describing the rol and col of the Sign on the matrix
	 */
	public Signs(int x, int y, String s, double locator){
		this.x = x;
		this.y = y;
		this.locator=locator;
		row=(int)locator;
		col=(int)(locator*10)%10;
		if(s.equals("start")){
			status = new int[]{100,x,y};
		}
		else{
			status = new int[]{-100,x,y};
		}
	}
	/**
	 * Second constructor construct the rest of the rocks(plain rocks)
	 * @param x the x loc of the rock on the JFrame
	 * @param y the y loc of the rock on the JFrame
	 * @param locator  a decimal number describing the rol and col of the Sign on the matrix
	 */
	public Signs(int x, int y, double locator) {
		row=(int)locator;
		col=(int)(locator*10)%10;
		this.locator=locator;
		this.x = x;
		this.y = y;
		status = new int[]{-1,x,y};
	}
	/**
	 * 
	 * @param e the event detected from GamePanel of arrow key pressed
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_RIGHT:
			upDateStatus(-5); // first num: positive touched negative untouched; 1 is empty, 2-5 are UpDownLeftRight. second and third, loc of rock
			break;
		case KeyEvent.VK_LEFT:
			upDateStatus(-4);
			break;
		case KeyEvent.VK_DOWN:
			upDateStatus(-3);
			break;
		case KeyEvent.VK_UP:
			upDateStatus(-2);
			break;
		case KeyEvent.VK_SPACE:
			upDateStatus(-1);
			break;
		}
	}
	
	/**
	 * 
	 * @return a int array contained the converted version of the locator e.g. 1.2 to {1, 2}; row 1 col 2
	 */
	public int[] getRowCol() {
		return new int[] {row, col};
	}
	
	/**
	 * @param locator the locator from the caller class MovementHandler 
	 * @return Identify whether the locator matches the current Signs object(rock)
	 */
	public boolean locatorIdentifier(double locator) {
		if(this.locator==locator) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param i update the status of the rock(mainly for the first index, which is changing the image of the rock)
	 */
	public void upDateStatus(int i){
		status[0]=i;
	}

	/**
	 * @return a int array containing all the information for the Signs object: the rock image int, x loc, y loc, and identifier 
	 */
	public int[] getStatus() {
		return status;
	}
	/**
	 * @return The image of the current Sign object(rock)
	 */
	public Image getSignImage() {
		ImageIcon ii = null;
		switch(status[0]) {
		case -2: ii = new ImageIcon("Up(1)-01.png");
				break;
		case -3: ii = new ImageIcon("Down(1)-01.png");
				break;
		case -4: ii = new ImageIcon("Left(1)-01.png");
				break;
		case -5: ii = new ImageIcon("Right(1)-01.png");
				break;
		case 2:ii = new ImageIcon("Up(2)-01.png");
				break;
		case 3: ii = new ImageIcon("Down(2)-01.png");
				break;
		case 4: ii = new ImageIcon("Left(2)-01.png");
				break;
		case 5:ii = new ImageIcon("Right(2)-01.png");
				break;
		case 1: ii = new ImageIcon("touched-01.png");
				break;
		case -1:ii = new ImageIcon("untouched-01.png");
				break;
		case 100: ii = new ImageIcon("start-01.png");
				break;
		case-100: ii = new ImageIcon("finish-01.png");
				break;
		}
		
		return ii.getImage();
		
	}
	/**
	 * @param g2d used to construct and draw the current rock on its location on the JFrame
	 */
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getSignImage(), x,y,100,100,null);
	}

	
}