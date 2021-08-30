
import java.awt.Graphics2D;
import java.util.LinkedList;
/**
 * Control the printing of the LinkedList<Signs>
 * @author jia
 *
 */
public class Controller {
	static LinkedList<Signs> s = new LinkedList<Signs>();
	Signs TempSigns;
	Levels l = new Levels();
	public Controller(LinkedList<Signs> s) {
		this.s=s;

	}

	/**
	 * 
	 * @param g2d print the Signs objects(rocks) in the LinkedList
	 */
	public void draw(Graphics2D g2d) {
		for(int i=0; i<s.size();i++) {
			TempSigns=s.get(i);
			TempSigns.draw(g2d);
			
		}
	}
	public void update() {

	}
	/**
	 * 
	 * @return the LinkedList<Signs>
	 */
	public static LinkedList<Signs> getSignsBounds(){
			return s;
	}
}
