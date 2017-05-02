/**
 * Movement.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package game;

import java.util.Timer;
import java.util.TimerTask;

public class Movement {
Timer move;

	public Movement() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask(){
				public void run(){
					
					if(Var.moveup){
							Var.y -= 2;
					}else if(Var.movedown){
							Var.y += 2;
					}else if(Var.moveleft){
								Var.x -= 2;
					}else if(Var.moveright){
									Var.x += 2;

					}
				}
	}, 0, 6);
}
}
