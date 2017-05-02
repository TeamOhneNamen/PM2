/**
 * Gui.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */

package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Gui {
	
	static boolean check = true;

	public Gui() {
		
		Var.jf1 = new JFrame();
		Var.jf1.setTitle("Snake");
		Var.jf1.setSize(Var.screenwidth , Var.screenheight);
		Var.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Var.jf1.setLayout(null);
		Var.jf1.setResizable(true);
		Var.jf1.setLocationRelativeTo(null);
		Var.jf1.addKeyListener(new KeyHandler());
		Var.jf1.requestFocus();	

		
		Draw lbldraw = new Draw();
		//System.out.println("a" + Var.jf1.getWidth() + Var.jf1.getHeight());
		lbldraw.setBounds(0, 0, Var.jf1.getWidth(), Var.jf1.getHeight());
		Var.jf1.add(lbldraw);
		
		JMenuBar jmb = new JMenuBar();
		JMenu jmiDifficulty = new JMenu("Difficulty");
		JMenu jmiMode = new JMenu("Mode");
		jmb.add(jmiMode);	
	    JMenu oneplayer = new JMenu("1 versus COM");
		
	    JMenuItem twoplayers = new JMenuItem("1 versus 1");
	    twoplayers.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		Var.comp_enemy = false;
	    	}
	    });
	    Var.jf1.setJMenuBar(jmb);
	    jmb.setVisible(true);
	    lbldraw.setVisible(true);
		Var.jf1.setVisible(true);
}
}
