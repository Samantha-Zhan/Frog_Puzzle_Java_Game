/**DISCLAIMER: The credit for the idea of the Game belongs 
   to Giyomu Games of its creation "Frog Puzzle" on Google Play

   The idea of the structure of coding a Java Game comes from youtube tutorial
   by #RealTutsGML called "Java Beginner Tutorial"
**/

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * This class is to handle all the logical component behind the game, changing the rock color,
 * determining the direction of the frog, and display the result of a round
 * @author jia
 *
 */
public class MovementHandler {
	private Signs currentSign;
	private Signs nextSign;
	enum Direction {EAST, SOUTH, WEST, NORTH};
	Direction d;
	private static LinkedList<Signs> signList;
	int col;
	int row;
	int[] nSign;
	int[] cSign;
	double testLocator;
	Signs start;
	Signs end;
	private static int locOL;
	private boolean checkSuccess;
	private boolean fail;
	

	public MovementHandler() {
		signList = MainClass.s;
		d= Direction.NORTH;
		this.locOL = GamePanel.locOnList;
		this.currentSign = signList.get(locOL);
		cSign = currentSign.getRowCol();
		col = currentSign.getRowCol()[1];
		row = currentSign.getRowCol()[0];
		nSign=cSign;
	}
	
	/**
	 *  Called by the GamePanel if a click on the button "start" is detected
	 * @param i is the index of the start rock/Sign(green) on the LinkedList of Signs
	 */
	public void buttonClicked(int i) {
		setlocOnList(i);
		directionDeterminator();
		nextSign = getNextButton();
		new Thread(() -> {
			while(nextSign!=null) {
				delay();

				currentSign = nextSign;
				directionDeterminator();
				nextSign = getNextButton();
				if(checkSuccess||fail){
					nextSign = null;
				}
				// determine if either the user reached the final rock but not covered all rocks
				// or if the user is in water; if one of them is true, then allow the user to 
				//try again
				if(fail||(nextSign==null&&!checkSuccess)) {
					int res = JOptionPane.showConfirmDialog(null, "You failed... please try again", "Fail", JOptionPane.YES_NO_OPTION);
					if (res == JOptionPane.YES_OPTION) {
						// restart the game
						
						GamePanel.newPanel();
						MainClass mc = new MainClass(MainClass.level,signList);
					} else {
						GamePanel.operated = true;
						GamePanel.newPanel();
						MainClass.f.dispose();
						Menu m = new Menu();
					}
				}
			}
			// check to see if the user successfully complete the game, and allow the user to
			// continue to the next level or return to the menu page
			// If the user is at the last level(level 6) then allow the user to replay the level
			// or to return to the menu page
			if(checkSuccess) {
				if(MainClass.level==6) {
					int res = JOptionPane.showConfirmDialog(null, "WOW! You have completed all the levels. Return to menu?", "Fail", JOptionPane.YES_NO_OPTION);
					if (res == JOptionPane.YES_OPTION) {
						GamePanel.operated = true;
						MainClass.f.dispose();
						Menu m = new Menu();
					} else {
						// restart the game
						Levels l = new Levels();
						MainClass.f.dispose();
						l.jumpTo(MainClass.level);
					}
				}
				else {
					int res = JOptionPane.showConfirmDialog(null, "Congratulations!! Continue to next level?", "Fail", JOptionPane.YES_NO_OPTION);
					if (res == JOptionPane.YES_OPTION) {
						// restart the game
						Levels l = new Levels();
						MainClass.f.dispose();
						l.jumpTo(MainClass.level+1);
					} else {
						GamePanel.operated = true;
						MainClass.f.dispose();
						Menu m = new Menu();
					}
				}
				
			}
		}).start();
		
	}
	
	/**
	 * @param i set the location of the current Signs object(rock) on the LinkedList<Signs>; this data is from the caller class GamePanel
	 */
	public void setlocOnList(int i) {
		locOL=i;
	}
	

	/**determine the location of the next button on the SignList according to the identifier
	 * (the actual location in a the matrix described in decimal; e.g. 1.2 means row 1 col 2)
	 *  of each Sign object in the LinkedList of Signs
	 * @return return the reference of the next sign on the list; if not exist, the frog is "in water" or at the end rock(red)
	 */
	public Signs getNextButton(){ 
		testLocator = (nSign[0]*10+nSign[1])/10.0;
		for(int i = 0; i<signList.size();i++) {
			if(signList.get(i).locatorIdentifier(testLocator)) {
				locOL = i;
				return signList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Determine the direction the frog should face ; update its next rock information; and update the rock image to be darker(stepped on)
	 */
	public void directionDeterminator(){
		int movementCode=Math.abs(currentSign.getStatus()[0]);
		if(movementCode!=1&&movementCode!=100){
			switch(movementCode) {
			case 2: d = Direction.NORTH; // get animation image of the frog;
					currentSign.upDateStatus(2);  // change the rock image to stepped on(darker rock)
					nSign[0]+=1;  // update the possible location of the next Sign on the matrix/2-d arrayList
					break;
			case 3: d=Direction.SOUTH;
					currentSign.upDateStatus(3);
					nSign[0]-=1;
					break;
			case 4: d=Direction.WEST;
					currentSign.upDateStatus(4);
					nSign[1]-=1;
					break;
			case 5: d=Direction.EAST;
					currentSign.upDateStatus(5);
					nSign[1]+=1;
					break;
			}
		}
		else if(movementCode ==1){
			currentSign.upDateStatus(1);
			switch(d){
			case NORTH:nSign[0]+=1;;
				break;
			case SOUTH: nSign[0]-=1;
				break;
			case WEST: nSign[1]-=1;
				break;
			case EAST:nSign[1]+=1;
			break;
			}
		}
		else if(currentSign.getStatus()[0]==100){ // if the current rock is the beginning rock, always start north
			 d= Direction.NORTH;
			 nSign[0]+=1;
		}
		else if(currentSign.getStatus()[0]==-100){ // if the current rock is the last rock, then check to see if 
													// if the player has stepped on all the rocks, if not then 
													// he/she failed
			if(!checkS()){
				fail=true;
			}
		}
	
	}
	
	/**
	 * restore all values to default values
	 */
	public static void setDefault(){
		for(int i=0;i<signList.size();i++){
			if(signList.get(i).getStatus()[0]!=100&&signList.get(i).getStatus()[0]!=-100){
				signList.get(i).getStatus()[0]=-1;
			}
		}
		locOL = GamePanel.locOnList;
	}
	/**
	 * 
	 * @return the image of the frog
	 */
	public Image getMovementImage() {
		ImageIcon ii = null;
		switch(d) {
		case NORTH:ii = new ImageIcon("fup.png");
				break;
		case SOUTH: ii = new ImageIcon("fdown.png");
				break;
		case WEST: ii = new ImageIcon("fleft.png");
				break;
		case EAST:ii = new ImageIcon("fright.png");
				break;
		}
		return ii.getImage();
	}
	
	/**
	 * @param g2d used to draw the image of the frog on current location
	 */
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getMovementImage(),  currentSign.x-20,currentSign.y-20,150,150,null);
	}
	
	/**
	 * @return  if all the rocks are stepped on when the frog is at the end rock(red)
	 */
	public boolean checkS(){
		if(currentSign.getStatus()[0]==-100){
			for(int i=0;i<signList.size();i++){
				if(signList.get(i).getStatus()[0]<0){
					if(signList.get(i).getStatus()[0]!=-100){
						checkSuccess =false;
						return false;
					}
				}
			}
			checkSuccess =true;
			return true;
		}
		return false;
	}
	/**
	 * delay the appearance of the frog image to be seen
	 */
	public void delay(){
		try {
		    Thread.sleep(500);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}
}
