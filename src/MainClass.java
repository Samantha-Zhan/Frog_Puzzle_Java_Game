/**DISCLAIMER: The credit for the idea of the Game belongs 
   to Giyomu Games of its creation "Frog Puzzle" on Google Play

   The idea of the structure of coding a Java Game comes from youtube tutorial
   by #RealTutsGML called "Java Beginner Tutorial"
**/

import java.util.LinkedList;

import javax.swing.JFrame;
	/**
	 * This class is to construct a game frame that is used to be later on 
	 * to add in components by the GamePanel class
	 * @author jia
	 */
	public class MainClass {
		public static JFrame f;
		public static int level;
		public static LinkedList<Signs> s;
		public static Controller c;
		/**
		 * 
		 * @param level The num of level the user clicked on
		 * @param s the linkedList<Signs> the Level class passed on to construct the level
		 */
		public MainClass(int level, LinkedList<Signs> s) {
			this.level=level;
			this.s=s;
			c = new Controller(s);
			final int WIDTH, HEIGHT;
			WIDTH = 550;
			HEIGHT = 800;
			f = new JFrame( "Frog Puzzle" );
		    f.pack();
		    GamePanel.setLevel(level);
		    GamePanel gp = new GamePanel();
		    f.add(gp);
			f.setResizable(false);
			f.setSize(WIDTH,HEIGHT);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}



