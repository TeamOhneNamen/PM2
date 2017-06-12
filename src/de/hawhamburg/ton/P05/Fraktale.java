package de.hawhamburg.ton.P05;

import java.util.ArrayList;
/**
 * An immutable class for complex numbers, modeled after the corresponding Ruby
 * class Complex (Complex Ruby Stdlib 1.8.7).
 * 
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 *

 */ 

import de.hawhamburg.ton.P01.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fraktale extends Application{

	static Complex C = Complex.ofCart(0, 0);
	static ArrayList<Complex> arrayOfComplex;
	static int HOEHE = 600;
	static int BREITE = 900;
	
	public ArrayList<Complex> werteErrechnen(){
		
		for (int i = 100; i > 0; i--) {
			
			arrayOfComplex.add(function(i));
			
		}
		
		return arrayOfComplex;
		
	}
	
	public Complex function(int x){
		return C.add(x^2);
	}
	
	
	@Override
	public void start(Stage firstStage) throws Exception {
		
		Group root = new Group();
		Scene scene1 = new Scene(root, BREITE, HOEHE);
		
		
		firstStage.setScene(scene1);
		firstStage.setTitle("Fractale");
		firstStage.show();
		
	}

	
}
