/**
 * Draw.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Draw extends JLabel{

	private static final long serialVersionUID = 1L;

	protected void paintComponent (Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Var.jf1.getWidth(), Var.jf1.getHeight());
		System.out.println("a" + Var.jf1.getWidth() + Var.jf1.getHeight());
		
		g.setColor(Color.WHITE);
		g.fillRect(Var.x, Var.y, 25, 25);
		
		//g.drawString("" + Var.playerpoints, Var.screenwidth / 2 - 95, 75);
		//tring("" + Var.enemypoints, Var.screenwidth / 2 + 50, 75);
		
		//g.fillRect(Var.ballx, Var.bally, 20, 20);
		
		repaint();
	}

}
