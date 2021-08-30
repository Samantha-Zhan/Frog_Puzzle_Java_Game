/**DISCLAIMER: The credit for the idea of the Game belongs 
   to Giyomu Games of its creation "Frog Puzzle" on Google Play

   The idea of the structure of coding a Java Game comes from youtube tutorial
   by #RealTutsGML called "Java Beginner Tutorial"
**/

// Represents a display panel for a dance group

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * This class is to complement the MainClass and add in a JPanel and graphical parts of 
 * the component on to the JFrame according to the #Level; which then operate logically
 * through the MovementHandler class
 * @author jia
 *
 */

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener{
	private static final long serialVersionUID = 1L;
	Timer gamelooptimer;
	private int x;
	private int y;
	private static LinkedList<Signs> s;
	private Signs newS;
	private boolean buttonDeterminator;
	MovementHandler mh;
	private static int level;
	public static boolean operated;
	private static Controller c;
	public static int locOnList;
	
	/**
	 * construct all the background image, rocks, buttons "start"&"clear" onto the Panel
	 */
	public GamePanel() {
		setFocusable(true);
		gamelooptimer = new Timer(10,this);
		gamelooptimer.start();
		operated=false;
		buttonDeterminator = false;
		mh = new MovementHandler();
		s=MainClass.s;
		c=MainClass.c;
		if(!buttonDeterminator){
			addMouseListener(this);
		}
		addKeyListener(this);
		setLayout(null);

		JButton button = new JButton();
		ImageIcon start = new ImageIcon("startText.jpg");
		start=MainPage.resizeImageIcon(155, 49, start);
		button.setIcon(start);
		button.setBounds(80,650, 155,49);
		add(button);
		
		
		JButton returnToLevel = new JButton();
		ImageIcon rtl = new ImageIcon("home.jpg");
		rtl=MainPage.resizeImageIcon(55, 55, rtl);
		returnToLevel.setIcon(rtl);
		returnToLevel.setBounds(421,30,55,55);
		add(returnToLevel);
		
		
		JButton clear = new JButton();
		ImageIcon cl = new ImageIcon("clear.jpg");
		cl = MainPage.resizeImageIcon(155,49,cl);
		clear.setIcon(cl);
		clear.setBounds(315,650, 155,49);
		add(clear);
		
		returnToLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPanel();
				Menu m = new Menu();
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonDeterminator = true;
				repaint();
				
				mh.buttonClicked(getStartPos());
				
				if(operated){
					buttonDeterminator = false;
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPanel();
				MainClass mc = new MainClass(MainClass.level,MainClass.s);
			}
		});
		
		
	}

	/**
	 * class to its default value, and dispose the current frame
	 * restore all the information and data in both the current rock and the MovementHandler
	 */
	public static void newPanel() {
		MainClass.f.dispose();
		operated = false;
		MovementHandler.setDefault();
	    GamePanel.setLevel(level);
	}
	/**
	 * @param l the level that should be set to
	 */
	public static void setLevel(int l) {
		level=l;
	}
	
	/**
	 * identify if an arrow key is pressed; then paseed to Signs class to process the click and change the image of the rock
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(newS!=null) {
			newS.keyPressed(e);
		}
		
	}
	/**
	 * update through repainting the panel
	 */
	public void update() {
		repaint();
	}
	/**
	 * paint everything if called(rocks, buttons, frog...)
	 */
 public void paintComponent( Graphics g ) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(new Color(69,160,211));
	g2d.fillRect(0, 0, 550, 800);
	MainClass.c.draw(g2d);
	if(buttonDeterminator) {   // if the button "start" is clicked, then the image of the frog is
								// updated through MovmentHandler class draw method
		mh.draw(g2d);
	}
	else { // if the button "start" is not yet clicked, then draw the frog at its start position
		ImageIcon ii = new ImageIcon("fup.png");
		g.drawImage(ii.getImage(),  getStartRock().getStatus()[1]-20,getStartRock().getStatus()[2]-20,150,150,null);
	}
	
}
 /**
  * @return the index of starting rock(green) in the LinkedList of all the rocks(Signs)
  */
 public static int getStartPos() {
		for(int i = 0; i<s.size();i++) {
			if(s.get(i).getStatus()[0]==100){
				locOnList = i;
				return i;
			}
		}
		return -1;
	}
 /** 
  * @return the start rock(green)
  */
 public Signs getStartRock() {
		Signs newS=s.get(getStartPos());
		return newS;
	}
@Override
public void actionPerformed(ActionEvent e) {
	repaint();
}

@Override
public void keyReleased(KeyEvent arg0) {
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	
}
@Override
/**
 * if a mouse clicked is detected, check to see if it is clicked one of the rocks
 * and find the location of the rock and the Signs object corresponding to it
 */
public void mouseClicked(MouseEvent e) {
	x=e.getX();
	y=e.getY();
	for(int i=0; i<s.size();i++) {
		int newSx = s.get(i).getStatus()[1];
		int newSy = s.get(i).getStatus()[2];
		
		if(x>=newSx && x<=newSx+100 && y>=newSy && y<=newSy+Signs.ROCKSIZE) {
			if(s.get(i).getStatus()[0]==100||s.get(i).getStatus()[0]==-100) {
				this.newS=null;
				break;
			}
			this.newS= s.get(i);
			break;
		}
		else {
			this.newS=null;
		}
		
	}
	
	
}	
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}





}

