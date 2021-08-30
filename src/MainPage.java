/**DISCLAIMER: The credit for the idea of the Game belongs 
   to Giyomu Games of its creation "Frog Puzzle" on Google Play

   The idea of the structure of coding a Java Game comes from youtube tutorial
   by #RealTutsGML called "Java Beginner Tutorial"
**/
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**This class is used to construct the Main page(with the main title) when called
 * @author jia
 */
public class MainPage{
	static final int WIDTH = 550, HEIGHT=800;
	private static JFrame f;
	private static JFrame jf;
	public MainPage() {
		f= new JFrame();
		JPanel p = new JPanel();
		f = new JFrame( "Frog Puzzle" );
	    f.pack();
	    f.add(p);
	    p.setLayout(null);
	    ImageIcon title = new ImageIcon("Title.png");
	    ImageIcon background = new ImageIcon("Background-01.png");
	    JLabel label1 = new JLabel(resizeImageIcon(348,262,title));
	    label1.setBounds(101, 170, 348, 262);
	    JLabel label2 =new JLabel(resizeImageIcon(555,766, background));
	    label2.setBounds(0, -10, 550, 800);
	    
	    JButton button = new JButton();
		ImageIcon play = new ImageIcon("Play button.png");
		play=resizeImageIcon(155, 55, play);
		button.setIcon(play);
		button.setBounds(197,500, 155,55);
		p.add(button);
		
		JButton button2 = new JButton();
		ImageIcon instruction = new ImageIcon("instruction-01.png");
		instruction=resizeImageIcon(55, 55, instruction);
		button2.setIcon(instruction);
		button2.setBounds(470,690, 55,55);
		p.add(button2);
		// linked the player to the menu page if clicked on "play"
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Menu m = new Menu();
			}
		});
		// linked the player to the instruction page if clicked on the question mark icon
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				instruction();
			}
		});
		
	    p.add(label1);
	    p.add(label2);
		f.setResizable(false);
		f.setSize(WIDTH,HEIGHT);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	/**
	 * 
	 * @param width The width of the image the user of the method hope to adjust the image to
	 * @param height The height of the image the user of the method hope to adjust the image to
	 * @param ii The imageicon the user of the method hope to modify the size
	 * @return
	 */
	public static ImageIcon resizeImageIcon(int width, int height, ImageIcon ii) {
		Image img = ii.getImage();
		ImageIcon newI = new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		return newI;
	}
	
	/**
	 * construct the instruction page
	 */
	public static void instruction() {
		jf= new JFrame();
		JPanel p = new JPanel();
		jf = new JFrame( "Frog Puzzle" );
		jf.pack();
	    
	    p.setLayout(null);
	    JButton returnToHome = new JButton();
		ImageIcon rtl = new ImageIcon("home.jpg");
		rtl=MainPage.resizeImageIcon(45, 45, rtl);
		returnToHome.setIcon(rtl);
		returnToHome.setBounds(470,30,45,45);
		returnToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				MainPage mp = new MainPage();
			}
		});
	    ImageIcon title = new ImageIcon("InstructionPage.png");
	    ImageIcon background = new ImageIcon("Background-01.png");
	    JLabel label1 = new JLabel(resizeImageIcon(555,800,title));
	    label1.setBounds(0, -38, 550, 800);
	    JLabel label2 =new JLabel(resizeImageIcon(555,766, background));
	    label2.setBounds(0, -10, 550, 800);
	    p.add(label1);
	    p.add(label2);
	    jf.add(returnToHome);
	    jf.add(p);
	    jf.setResizable(false);
		jf.setSize(WIDTH,HEIGHT);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
