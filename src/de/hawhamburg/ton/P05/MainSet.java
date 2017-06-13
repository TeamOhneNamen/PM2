/**
 * MainSet.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P05;

import de.hawhamburg.ton.P01.*;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainSet extends Application {
	private static final int CANVAS_WIDTH = 800;
	private static final int CANVAS_HEIGHT = 600;
	// scale to ensure the result will stay exactly the same as size of canvas
	private static final double SCALE = CANVAS_WIDTH * 1.0 / CANVAS_HEIGHT;

	// Left and right border
	private static final int X_OFFSET = 25;
	// Top and bottom border
	private static final int Y_OFFSET = 25;

	// Width of tempScene contains canvas
	private static final int WIDTH = (2 * X_OFFSET) + CANVAS_WIDTH;
	// Height of tempScene contains canvas
	private static final int HEIGHT = (2 * X_OFFSET) + CANVAS_HEIGHT;

	// threshold to prevent infinite iteration
	private static final double THRESHOLD = 2.0;

	// main pane
	private BorderPane rootPane;
	
	//StackPane to add canvas
	private FadeTransition  ft;
	// Canvas to draw
	private Canvas canvas;

	// Julia Set with default z0 and C
	private JuliaSet julia = new JuliaSet();

	// Field to change z0
	private TextField z0Re = new TextField();
	private TextField z0Im = new TextField();

	// Field to change c
	private TextField cRe = new TextField();
	private TextField cIm = new TextField();

	// zoom
	private Label zoomLabel = new Label();
	private double zoom = 1.0;

	// show mouse position on canvas and screen
	private Label posX = new Label();
	private Label posY = new Label();
	private Label screenX = new Label();
	private Label screenY = new Label();

	// value of position to zoom based on canvas screen
	private double xMove = 0;
	private double yMove = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		rootPane = new BorderPane();
		ft = new FadeTransition ();

		// Set canvas to right position
		canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		canvas.setLayoutX(X_OFFSET);
		canvas.setLayoutY(Y_OFFSET);
		
		//add canvas into stackPane
		ft.setNode(canvas);
		ft.setDuration(new Duration(2000));
	      ft.setFromValue(1.0);
	      ft.setToValue(0.0);

		// get position of mouse on canvas and
		canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				screenX.setText(String.valueOf("x = " + event.getX()));
				screenY.setText(String.valueOf("y = " + event.getY()));
				posX.setText(String.valueOf("x = " + (event.getX() - CANVAS_WIDTH / 2)));
				posY.setText(String.valueOf("y = " + (CANVAS_HEIGHT / 2 - event.getY())));
			}
		});

		// set click to zoom for canvas
		canvas.setOnMouseClicked(new zoomCanvas());

		// draw JuliaSet with default Complex
		draw(canvas.getGraphicsContext2D(), julia);

		// add right pane for rootPane
		GridPane topGridPane = new GridPane();
		topGridPane.setPadding(new Insets(20, 0, 0, 0));
		topGridPane.setHgap(10);
		topGridPane.setVgap(10);

		// Label for each real and imaginary of z0 and c
		Label z0ReLabel = new Label("z0 real");
		Label z0ImLabel = new Label("z0 imag");
		Label cReLabel = new Label("c real");
		Label cImLabel = new Label("c imag");
		Label xy = new Label("mouse position");
		Label screen = new Label("screen position");

		zoomLabel.setText("zoom " + (zoom * 100) + "%");

		// Button to process draw after input new Value from z0 and c
		Button process = new Button("Process");
		process.setOnAction(new processInput());

		// Button to process draw Julia with default value
		Button processDefault = new Button("Default");
		processDefault.setOnAction(new processInput());
		
		// Buttons to zoom in and out
		Button zoomIn = new Button("+");
		zoomIn.setOnAction(new processInput());
		
		Button zoomOut = new Button("-");
		zoomOut.setOnAction(new processInput());

		// set size for each Textfile to fix the screen
		z0Re.setPrefWidth(80);
		z0Im.setPrefWidth(80);
		cRe.setPrefWidth(80);
		cIm.setPrefWidth(80);

		// Set current value of z0 and c into Field
		z0Re.setText(String.valueOf(julia.getZ0().getRealNumber()));
		z0Im.setText(String.valueOf(julia.getZ0().getImaginaryNumber()));
		cRe.setText(String.valueOf(julia.getC().getRealNumber()));
		cIm.setText(String.valueOf(julia.getC().getImaginaryNumber()));

		// add all Label, Button and Field to Gridpane
		topGridPane.add(z0ReLabel, 0, 0);
		topGridPane.add(z0Re, 1, 0);
		topGridPane.add(z0ImLabel, 0, 1);
		topGridPane.add(z0Im, 1, 1);

		topGridPane.add(cReLabel, 0, 3);
		topGridPane.add(cRe, 1, 3);
		topGridPane.add(cImLabel, 0, 4);
		topGridPane.add(cIm, 1, 4);

		topGridPane.add(zoomLabel, 1, 6);
		topGridPane.add(zoomIn, 2, 6);
		topGridPane.add(zoomOut, 0, 6);
		
		topGridPane.add(process, 0, 7);
		topGridPane.add(processDefault, 1, 7);

		topGridPane.add(xy, 0, 10);
		topGridPane.add(posX, 0, 11);
		topGridPane.add(posY, 0, 12);

		topGridPane.add(screen, 0, 14);
		topGridPane.add(screenX, 0, 15);
		topGridPane.add(screenY, 0, 16);
		


		// set Gridpane at the right of BorderPane
		rootPane.setRight(topGridPane);
		// set Result Draw at center of BorderPane
		rootPane.setCenter(canvas);
		rootPane.setPadding(new Insets(0, 10, 0, 0));

		// set Scene with root and same Height of canvas but wider because of
		// GridPane
		Scene scene = new Scene(rootPane, WIDTH + 200, HEIGHT);
		primaryStage.setTitle("Fraktale");
		primaryStage.setScene(scene);

		// not allow to change size of Scene
		primaryStage.resizableProperty().set(false);
		primaryStage.show();

	}

	private void draw(GraphicsContext gc, JuliaSet julia) {
		Complex z0 = julia.getZ0();
		Complex c = julia.getC();

		// loop for every pixel, run from top left following column
		for (int x = 0; x < CANVAS_WIDTH; x++) {
			for (int y = 0; y < CANVAS_HEIGHT; y++) {
				
				//return 1 if real and imaginary = 0
				double divZ0Real = (Double.doubleToLongBits(z0.getRealNumber()) != 0) ? z0.getRealNumber() : 1;
				double divZ0Im = (Double.doubleToLongBits(z0.getImaginaryNumber()) != 0) ? z0.getImaginaryNumber() : 1;
				
				// calculate real and imaginary based on scale, width
				// threshold and value of z0
				double re = THRESHOLD * SCALE * ((x - CANVAS_WIDTH / 2.0) / zoom + xMove) / (divZ0Real * CANVAS_WIDTH);
				double	imag = THRESHOLD * ((CANVAS_HEIGHT / 2.0 - y) / zoom + yMove) / (divZ0Im * CANVAS_HEIGHT);

				//new Complex z0
				Complex z = Complex.ofCart(re, imag);

				// how many steps until absolute of zi is bigger or equal 2
				int nIteration = 0;
				while (z.abs() < 2 && nIteration < JuliaSet.MAX_ITERATION) {
					// real and imaginary automatically change due to mutable
					//x^2+c
					z = z.mul(z).add(c);
					++nIteration;
				}

				// choose color based on nIteration
				double scale = 255.0 * nIteration / JuliaSet.MAX_ITERATION;
				if (nIteration != JuliaSet.MAX_ITERATION) {
					gc.setFill(Color.color(scale / 500, scale / 255, 0));
				} else {
					gc.setFill(Color.PURPLE);
				}

				// fill color for round as Point(x,y) with 1x1 pixel
				gc.fillRect(x, y, 1, 1);
			}
		}
	}

	// re-enter z0 and c to draw back again
	private class processInput implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Button clickBttn = (Button) event.getSource();

			// get value from input of field
			double zRe = Double.valueOf(z0Re.getText());
			double zIm = Double.valueOf(z0Im.getText());
			double cReal = Double.valueOf(cRe.getText());
			double cImag = Double.valueOf(cIm.getText());

			// new z0 and c
			Complex z0 = Complex.ofCart(zRe, zIm);
			Complex c = Complex.ofCart(cReal, cImag);
			// new inputed Julia
			JuliaSet newJulia = new JuliaSet(z0, c);

			// default Julia
			JuliaSet defaultJulia = new JuliaSet();

			// only draw if Button Default was clicked
			// current julia are different from default Julia
			// or zoom or xMove or zMove are not default
			if (clickBttn.getText().equals("Default")) {
				if (!julia.equals(defaultJulia) || zoom != 1 || xMove != 0 || yMove != 0) {
					// set back xMove, yMove and zoom to default Value;
					xMove = 0;
					yMove = 0;
					zoom = 1;
					julia = defaultJulia;
					// set Textfield back to original
					z0Re.setText(String.valueOf(julia.getZ0().getRealNumber()));
					z0Im.setText(String.valueOf(julia.getZ0().getImaginaryNumber()));
					cRe.setText(String.valueOf(julia.getC().getRealNumber()));
					cIm.setText(String.valueOf(julia.getC().getImaginaryNumber()));

					// draw back again
					draw(canvas.getGraphicsContext2D(), julia);
				}
			}
			// only draw if Button Process was clicked and
			// current julia are different from inputed Julia
			// or zoom or xMove or zMove are not default
			if (clickBttn.getText().equals("Process")) {
				if (!julia.equals(newJulia) || zoom != 1 || xMove != 0 || yMove != 0) {
					// set back xMove, yMove and zoom to default Value;
					xMove = 0;
					yMove = 0;
					zoom = 1;
					// set julia equal to new one
					julia = newJulia;
					// draw back again
					draw(canvas.getGraphicsContext2D(), julia);
				}
			}
			if (clickBttn.getText().equals("+")) {
				zoom += 0.5;
				zoomLabel.setText("zoom " + (zoom * 100) + "%");
				draw(canvas.getGraphicsContext2D(), julia);
			}
			
			if (clickBttn.getText().equals("-")) {
				zoom -= (zoom > 1) ? 0.5 : 1;
				zoomLabel.setText("zoom " + (zoom * 100) + "%");
				draw(canvas.getGraphicsContext2D(), julia);
			}
			
		}
	}

	// zoom in or out to calculate xMove and yMove based on position of x,y
	private class zoomCanvas implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			// work only if 2 Double Click
			if (event.getClickCount() == 2) {
				// double click left button to zoom in and right to zoom back
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					xMove += (event.getX() - CANVAS_WIDTH / 2) / zoom;
					yMove += (CANVAS_HEIGHT / 2 - event.getY()) / zoom;
					// 4x zoom
					zoom += 0.5;
					
					

				} else if (event.getButton().equals(MouseButton.SECONDARY)) {
					xMove += (event.getX() - CANVAS_WIDTH / 2) / zoom;
					yMove += (CANVAS_HEIGHT / 2 - event.getY()) / zoom;
					// limit until zoom = 1
					zoom -= (zoom > 1) ? 0.5 : 1;
//					draw(canvas.getGraphicsContext2D(), julia);

				}

				// draw again after calculating new zoom, xMove and yMove
				zoomLabel.setText("zoom " + (zoom * 100) + "%");
				draw(canvas.getGraphicsContext2D(), julia);
			}
		}
	}
}

