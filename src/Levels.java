/**DISCLAIMER: The credit for the idea of the Game belongs 
   to Giyomu Games of its creation "Frog Puzzle" on Google Play

   The idea of the structure of coding a Java Game comes from youtube tutorial
   by #RealTutsGML called "Java Beginner Tutorial"
**/

import java.util.LinkedList;
/**
 * This class is used to store the information and guidelines for the GamePanel class to 
 * construct the graphic layout of each game
 * @author jia
 *
 */

public class Levels {
	/**
	 * jumTo method allow the MovementHandler to direct the user to the next level/stay in
	 * the current method; constructing a new JFrame every time called
	 * @param num The level which should jump to
	 */
	public void jumpTo(int num) {
		switch(num) {
		case 1: level1();
				break;
				
		case 2: level2();
				break;
				
		case 3: level3();
				break;
				
		case 4: level4();
				break;
		case 5: level5();
				break;
		case 6: level6();
				break;
		}
	}

	/**The following are the information for each level; the method calls the MainClass to
	 * construct a new JPanel for a new Game
	 */
	public void level1(){  // 550 800
		final int ROCKSIZE=100;
		LinkedList<Signs> s = new LinkedList<Signs>();
		s.add(new Signs((550-ROCKSIZE*3)/2, (800-ROCKSIZE*3)/2+ROCKSIZE*2-50,"start", 0.0));
		s.add(new Signs((550-ROCKSIZE*3)/2, (800-ROCKSIZE*3)/2+ROCKSIZE-50, 1.0));
		s.add(new Signs((550-ROCKSIZE*3)/2, (800-ROCKSIZE*3)/2-50,2.0));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE, (800-ROCKSIZE*3)/2-50,2.1));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE*2, (800-ROCKSIZE*3)/2-50,"end",2.2));
		
		MainClass mc = new MainClass(1, s);
	}
	
	public void level2(){  // 550 800
		final int ROCKSIZE=100;
		LinkedList<Signs> s = new LinkedList<Signs>();
		s.add(new Signs((550-ROCKSIZE*3)/2, (800-ROCKSIZE*5)/2+ROCKSIZE*4-50,"start", 0.0));
		s.add(new Signs((550-ROCKSIZE*3)/2, (800-ROCKSIZE*5)/2+ROCKSIZE*3-50, 1.0));
		s.add(new Signs((550-ROCKSIZE*3)/2, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.0));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.1));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50, 2.2));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2+ROCKSIZE-50,3.2));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2-50,"end",4.2));
		MainClass mc = new MainClass(2, s);
	}
	
	public void level3(){  // 550 800
		final int ROCKSIZE=100;
		LinkedList<Signs> s = new LinkedList<Signs>();
		s.add(new Signs((550-ROCKSIZE*3)/2, (800-ROCKSIZE*5)/2+ROCKSIZE*4-50,"start", 0.0));
		s.add(new Signs((550-ROCKSIZE*3)/2, (800-ROCKSIZE*5)/2+ROCKSIZE*3-50, 1.0));
		s.add(new Signs((550-ROCKSIZE*3)/2, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.0));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.1));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50, 2.2));
		s.add(new Signs((550-ROCKSIZE*3)/2, (800-ROCKSIZE*5)/2+ROCKSIZE*1-50,3.0));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE, (800-ROCKSIZE*5)/2+ROCKSIZE-50,3.1));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2+ROCKSIZE-50,3.2));
		s.add(new Signs((550-ROCKSIZE*3)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2-50,"end",4.2));
		MainClass mc = new MainClass(3, s);
	}
	
	public void level4(){  // 550 800
		final int ROCKSIZE=100;
		LinkedList<Signs> s = new LinkedList<Signs>();
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE, (800-ROCKSIZE*4)/2+ROCKSIZE*3-50,"start", 0.1));
		s.add(new Signs((550-ROCKSIZE*4)/2, (800-ROCKSIZE*4)/2+ROCKSIZE*2-50, 1.0));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE, (800-ROCKSIZE*4)/2+ROCKSIZE*2-50,1.1));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE*2, (800-ROCKSIZE*4)/2+ROCKSIZE*2-50,1.2));
		s.add(new Signs((550-ROCKSIZE*4)/2, (800-ROCKSIZE*4)/2+ROCKSIZE-50, 2.0));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE, (800-ROCKSIZE*4)/2+ROCKSIZE-50,2.1));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE*2, (800-ROCKSIZE*4)/2+ROCKSIZE-50,2.2));
		s.add(new Signs((550-ROCKSIZE*4)/2, (800-ROCKSIZE*4)/2-50,3.0));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE, (800-ROCKSIZE*4)/2-50,3.1));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE*3, (800-ROCKSIZE*4)/2+ROCKSIZE*2-50,"end",1.3));
		MainClass mc = new MainClass(4, s);
	}
	
	public void level5(){  // 550 800
		final int ROCKSIZE=100;
		LinkedList<Signs> s = new LinkedList<Signs>();
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE, (800-ROCKSIZE*5)/2+ROCKSIZE*4-50,"start", 0.1));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE, (800-ROCKSIZE*5)/2+ROCKSIZE*3-50, 1.1));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2+ROCKSIZE*3-50,1.2));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE*3, (800-ROCKSIZE*5)/2+ROCKSIZE*3-50,1.3));
		s.add(new Signs((550-ROCKSIZE*4)/2, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50, 2.0));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.1));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.2));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE*3, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.3));
		s.add(new Signs((550-ROCKSIZE*4)/2, (800-ROCKSIZE*5)/2+ROCKSIZE-50,3.0));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE, (800-ROCKSIZE*5)/2-50+ROCKSIZE,3.1));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2-50+ROCKSIZE,3.2));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE*3, (800-ROCKSIZE*5)/2-50+ROCKSIZE,3.3));
		s.add(new Signs((550-ROCKSIZE*4)/2+ROCKSIZE, (800-ROCKSIZE*5)/2-50,"end",4.1));
		MainClass mc = new MainClass(5, s);
	}

	public void level6(){  // 550 800
		final int ROCKSIZE=100;
		LinkedList<Signs> s = new LinkedList<Signs>();
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE, (800-ROCKSIZE*5)/2+ROCKSIZE*4-50,"start", 0.1));
		s.add(new Signs((550-ROCKSIZE*5)/2, (800-ROCKSIZE*5)/2+ROCKSIZE*3-50, 1.0));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE, (800-ROCKSIZE*5)/2+ROCKSIZE*3-50,1.1));
		s.add(new Signs((550-ROCKSIZE*5)/2, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.0));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50, 2.1));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.2));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE*3, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.3));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE*4, (800-ROCKSIZE*5)/2+ROCKSIZE*2-50,2.4));
		s.add(new Signs((550-ROCKSIZE*5)/2, (800-ROCKSIZE*5)/2+ROCKSIZE-50,3.0));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE, (800-ROCKSIZE*5)/2-50+ROCKSIZE,3.1));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2-50+ROCKSIZE,"end",3.2));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE*3, (800-ROCKSIZE*5)/2-50+ROCKSIZE,3.3));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE*4, (800-ROCKSIZE*5)/2-50+ROCKSIZE,3.4));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE*2, (800-ROCKSIZE*5)/2-50,4.2));
		s.add(new Signs((550-ROCKSIZE*5)/2+ROCKSIZE*3, (800-ROCKSIZE*5)/2-50,4.3));
		MainClass mc = new MainClass(6, s);
	}
	
}
