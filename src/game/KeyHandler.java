/**
 * Keyhandler.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package game;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_UP){
			Var.moveup = true;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			Var.movedown = true;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Var.moveright = true;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Var.moveleft = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP){
			Var.moveup = false;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			Var.movedown = false;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Var.moveright = false;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Var.moveleft = false;
		}	
	}
	


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

