/**DISCLAIMER: The credit for the idea of the Game belongs 
   to Giyomu Games of its creation "Frog Puzzle" on Google Play

   The idea of the structure of coding a Java Game comes from youtube tutorial
   by #RealTutsGML called "Java Beginner Tutorial"
**/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * This class is used to construct a menu page when called and direct the player to each
 * level through clicking on the level buttons
 * @author jia
 *
 */
public class Menu {
	static final int WIDTH = 550, HEIGHT=800;
	private static JFrame f;
	public Menu() {
		f= new JFrame();
		JPanel p = new JPanel();
		f = new JFrame( "Frog Puzzle" );
	    f.pack();
	    f.add(p);
	    p.setLayout(null);
	    Levels l =new Levels();
	    
	    // construct the tiles, the background image, and the return to home button
	    ImageIcon menu = new ImageIcon("menu.png");
	    JLabel label1 =new JLabel(MainPage.resizeImageIcon(315,81, menu));
	    label1.setBounds(0, -200, 550, 800);
	    ImageIcon background = new ImageIcon("Background-01.png");
	    JLabel label2 =new JLabel(MainPage.resizeImageIcon(555,766, background));
	    label2.setBounds(0, -10, 550, 800);
	    
	    JButton returnToHome = new JButton();
		ImageIcon rtl = new ImageIcon("home.jpg");
		rtl=MainPage.resizeImageIcon(55, 55, rtl);
		returnToHome.setIcon(rtl);
		returnToHome.setBounds(460,30,55,55);
		
		returnToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainPage mp = new MainPage();
			}
		});
	    
	    //add a set of image buttons for levels
	    JButton one = new JButton();
		ImageIcon first = new ImageIcon("1.png");
		first=MainPage.resizeImageIcon(70, 70, first);
		one.setIcon(first);
		one.setBounds(150,300, 70,70);
		
		JButton two = new JButton();
		ImageIcon second = new ImageIcon("2.png");
		second=MainPage.resizeImageIcon(70, 70, second);
		two.setIcon(second);
		two.setBounds(330,300, 70,70);
		
		JButton three = new JButton();
		ImageIcon third = new ImageIcon("3.png");
		third=MainPage.resizeImageIcon(70, 70, third);
		three.setIcon(third);
		three.setBounds(150,430, 70,70);
		
		JButton four = new JButton();
		ImageIcon fourth = new ImageIcon("4.png");
		fourth=MainPage.resizeImageIcon(70, 70, fourth);
		four.setIcon(fourth);
		four.setBounds(330,430, 70,70);
		
		JButton five = new JButton();
		ImageIcon fifth = new ImageIcon("5.png");
		fifth=MainPage.resizeImageIcon(70, 70, fifth);
		five.setIcon(fifth);
		five.setBounds(150,560, 70,70);
		
		JButton six = new JButton();
		ImageIcon sixth = new ImageIcon("6.png");
		sixth=MainPage.resizeImageIcon(70, 70, sixth);
		six.setIcon(sixth);
		six.setBounds(330,560, 70,70);
		
	     // add function to each button to direct user to each level when clikced
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				l.jumpTo(1);
			}
		});
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				l.jumpTo(2);
			}
		});
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				l.jumpTo(3);
			}
		});
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				l.jumpTo(4);
			}
		});
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				l.jumpTo(5);
			}
		});
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				l.jumpTo(6);
			}
		});
		// add all buttons and labels on to the panel
	    p.add(label1);
	    p.add(one);
	    p.add(two);
	    p.add(three);
	    p.add(returnToHome);
	    p.add(four);
	    p.add(five);
	    p.add(six);
	    p.add(label2);
	    
		f.setResizable(false);
		f.setSize(WIDTH,HEIGHT);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
