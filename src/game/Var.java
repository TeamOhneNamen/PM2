/**
 * Var.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package game;

import javax.swing.JFrame;

public class Var {
	
	static JFrame jf1;
	
	static int screenwidth = 800, screenheight = 600;
	
	static int x = 20, y = 185;
	static boolean moveup = false, movedown = false;
	static boolean moveright = false, moveleft = false;
	
	static int enemyx = 755, enemyy = 185;
	
	
	static int playerpoints = 0, enemypoints = 0;
	
	static int ballx = 200, bally = 100;
	static int balldirx = 1, balldiry = 1;
	
	static int difficulty = 1;
	static boolean comp_enemy = false;

	public Var() {
	}

}
